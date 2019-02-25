package com.honeypot.honeypot.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.dao.UserDao;
import com.honeypot.honeypot.entity.LockUser;
import com.honeypot.honeypot.entity.User;

import com.honeypot.honeypot.service.DepartmentManagementService;
import com.honeypot.honeypot.service.UserService;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private DepartmentManagementService departmentManagementService;

    /**
     * 获取所有用户信息
     * 调用UserDao中的方法获得List<User>
     * 需要将user表中取得的department和authority由数字转换成对应的文字
     * 其中department名称需要利用department的service去查询
     * @return JSONArray
     * 根据前端要求，返回如下形式的JSONArray
     *       [{"id": xx, "username": xx, "realName": xx, "role": xx, "department": xx},
     *       ......,
     *       {"id": xx, "username": xx, "realName": xx, "role": xx, "department": xx}]
     */
    @Override
    public JSONArray getAllUsers() {
        List<User> users = userDao.getAllUsers();
        JSONArray array = new JSONArray();
        Map<Integer, String> roleMap = new HashMap<Integer, String>();
        roleMap.put(1, "系统管理员");
        roleMap.put(2, "安全审计管理员");
        roleMap.put(3, "普通用户");
        roleMap.put(4, "安全保密管理员");

        for (User user : users){
            JSONObject one = new JSONObject();
            one.put("id", user.getId());
            one.put("username", user.getUsername());
            one.put("realName", user.getRealName());
            one.put("role", roleMap.get(user.getAuthority()));
            one.put("department", departmentManagementService.getDeptById(user.getDept()).getDepName());
            array.add(one);
        }
        return array;
    }

    // 接下来两个getUser的方法会在其他方法中用到
    /**
     * 根据用户名获取单个用户信息，直接调用userDao中方法即可
     * @param username
     * @return User
     */
    @Override
    public User getUserByUsername(String username){
        return userDao.getUserByUsername(username);
    }

    /**
     * 根据id获取单个用户信息，直接调用userDao中方法即可
     * @param id
     * @return User
     */
    @Override
    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    /**
     * 添加一个新用户，将json解析赋给一个User对象，再调用userDao中的方法添加
     * @param userJson 前端传来的json数据
     * @return result 一个json数据，用于显示添加是否成功
     */
    @Override
    @Transactional
    public JSONObject addUser(JSONObject userJson){
        User newUser = new User();
        JSONObject result = new JSONObject();
        Base64 base64 = new Base64();
        String delPassword = base64.encodeAsString(userJson.getString("password").getBytes());
//        newUser.setId(userJson.getIntValue("id"));
        newUser.setUsername(userJson.getString("username"));
        newUser.setPassword(delPassword);
        newUser.setRealName(userJson.getString("realName"));
        newUser.setAuthority(userJson.getIntValue("authority"));
        newUser.setDept(userJson.getIntValue("dept"));

        if(userDao.addUser(newUser)){
            LockUser lockUser = new LockUser();
            lockUser.setPwdLoginDate(new Date());
            lockUser.setUserId(newUser.getId());
            lockUser.setTryTimes(0);
            lockUser.setLocked(0);
            lockUser.setPwdLoginTime(new Date());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            lockUser.setPwdStartTime(dateFormat.format(new Date()));
            userDao.insertLockInfo(lockUser);
            result.put("result", "添加用户成功！");

        }
        else
            result.put("result", "添加用户失败！");

        return result;
    }

    /**
     * 删除用户，前端勾选的用户个数不同，故按照JSONArray处理
     * 遍历array，对每一个JSONObject进行删除
     * 若其中有某个用户删除失败，则返回其ID并停止删除
     * 否则删除成功，返回"success"供前端处理
     * @param delArray
     * 前端传来jsonArray形式为
     * [{"username": xx}, {"username": yy}, ..., {"username": nn}]
     * @return
     */
    @Override
    @Transactional
    public JSONObject delUser(JSONArray delArray){
        JSONObject result = new JSONObject();
        for(int i = 0; i < delArray.size(); i++){
            JSONObject obj = delArray.getJSONObject(i);
            User user = userDao.getUserByUsername(obj.getString("username"));
            if( user != null){
                userDao.delLockInfo(userDao.getUserByUsername(obj.getString("username")).getId());
                userDao.delUser(obj.getString("username"));
                result.put("result", obj.getString("username"));

            }
        }
        result.put("result", "success");
        return result;
    }

    /**
     * 修改用户信息
     * @param updateJson
     * 前端传来json形式为
     * {
     *     "username": x,
     *     "oldpassword": xxxxx,
     *     "newpassword": xxxxxx,
     *     "newrealname": xxxx,
     *     "newdept": xx
     * }
     * 由username获得需要修改的用户对象，根据不同键对应的值是否为空,来确定是否对对应属性进行修改
     * 至少有一项会被修改，故最后调用userDao的updateUser方法进行更新即可
     * @return 返回json供前端显示结果
     */
    @Override
    @Transactional
    public JSONObject updateUser(JSONObject updateJson){
        JSONObject result = new JSONObject();
        User update = new User();
        Base64 base64 = new Base64();
        String delPassword = base64.encodeAsString(updateJson.getString("newpassword").getBytes());
        update = getUserByUsername(updateJson.getString("username"));
        if(!updateJson.getString("newpassword").equals(""))
        {
            update.setPassword(delPassword);
        }
        if(!updateJson.getString("newrealname").equals(""))
            update.setRealName(updateJson.getString("newrealname"));
        if(!updateJson.getString("newdept").equals(""))
            update.setDept(updateJson.getIntValue("newdept"));

        if(userDao.updateUser(update))
            result.put("result", "修改用户成功！");
        else
            result.put("result", "修改用户失败！");

        return result;
    }

    /**
     * 解锁用户，首先判断该用户是否被锁定，若为被锁定返回即可
     * 若锁定，则继续执行解锁操作
     * @param unlockJson
     * @return 一个json对象，返回是否被锁定，以及是否成功解锁
     */
    @Override
    @Transactional
    public JSONObject unlockUser(JSONObject unlockJson){
        JSONObject result = new JSONObject();
        int userId = unlockJson.getIntValue("userId");
        if (userDao.isLocked(userId) == 1){
            if (userDao.unlockUser(userId))
                result.put("result", "解锁成功！");
            else
                result.put("result", "解锁失败！");
        }
        else
            result.put("result", "该用户未被锁定！");

        return result;
    }
}
