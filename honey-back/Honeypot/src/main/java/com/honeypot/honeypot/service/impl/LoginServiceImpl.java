package com.honeypot.honeypot.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.dao.UserDao;
import com.honeypot.honeypot.entity.LockUser;
import com.honeypot.honeypot.entity.User;
import com.honeypot.honeypot.service.LoginService;
import com.honeypot.honeypot.util.SecurityUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserDao userDao;

    /**
     * 登录功能实现，密码，账户是否被锁校验
     * @param user
     * @param systemSecurityConfs
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @throws ParseException
     */
    @Override
    public Map<String,Object> checkUserNameAndPassword(User user, JSONObject systemSecurityConfs, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
        Map<String,Object> resultMap = new HashMap<>();
        LockUser lockInfo = userDao.getLockInfo(user.getId());
        //判断密码是否失效
        try {
            if (SecurityUtil.ifLosePassword(lockInfo, systemSecurityConfs)){
                resultMap.put("message", "密码已经失效");
                user.setPassword("");

                if (userDao.updateUser(user)){
                    //1 表示需要修改密码
                    resultMap.put("statusCode",001);
                    return resultMap;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("statusCode", 404);
            resultMap.put("message", "您的用户数据异常，请联系系统管理员");
            return resultMap;
        }
        Base64 base64 = new Base64();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if ( lockInfo.getLocked() == 1) {
           if (SecurityUtil.ifunLock(dateFormat.parse(lockInfo.getPwdStartTime()),
                   Integer.parseInt(systemSecurityConfs.getString("lock_period")))){
               if (base64.encodeAsString(password.getBytes()).equals(user.getPassword())) {
                   resultMap.put("statusCode",200);
                   lockInfo.setPwdLoginDate(new Date());
                   lockInfo.setTryTimes(0);
                   lockInfo.setLocked(0);
                   resultMap.put("message", "登录成功");
               }else {
                   resultMap.put("statusCode",000);
                   //密码尝试次数+1;
                   int tryTime = lockInfo.getTryTimes() + 1;
                   if (tryTime >= systemSecurityConfs.getIntValue("try_times")){
                       lockInfo.setPwdStartTime(dateFormat.format(new Date()));
                       lockInfo.setTryTimes(0);
                       lockInfo.setLocked(1);
                       //密码错误次数达到最大，用户被锁
                       resultMap.put("statusCode",401);
                   }else {
                       lockInfo.setTryTimes(tryTime);
                       lockInfo.setLocked(0);
                   }
                   resultMap.put("message", "密码错误");
               }
           }else {
               //账户被锁，而且未到解锁时间
               resultMap.put("statusCode",400);
               resultMap.put("message", "账户被锁，而且未到解锁时间,请等待：" + SecurityUtil.waitTime(dateFormat.parse(lockInfo.getPwdStartTime()),
                       Integer.parseInt(systemSecurityConfs.getString("lock_period"))) + " 分钟");
           }
        }else {

            if (base64.encodeAsString(password.getBytes()).equals(user.getPassword())) {
                resultMap.put("statusCode",200);
                lockInfo.setPwdLoginDate(new Date());
                lockInfo.setTryTimes(0);
                lockInfo.setLocked(0);
                resultMap.put("message", "登录成功");
            }else {
                resultMap.put("statusCode",000);
                //密码尝试次数+1;
                int tryTime = lockInfo.getTryTimes() + 1;
                if (tryTime >= systemSecurityConfs.getIntValue("try_times")){
                    lockInfo.setPwdStartTime(dateFormat.format(new Date()));
                    lockInfo.setTryTimes(0);
                    lockInfo.setLocked(1);
                    //密码错误次数达到最大，用户被锁
                    resultMap.put("statusCode",401);
                }else {
                    lockInfo.setTryTimes(tryTime);
                    lockInfo.setLocked(0);
                }
                resultMap.put("message", "密码错误");
            }
        }
        userDao.updateLockInfo(lockInfo);
        return resultMap;
    }

    @Override
    @Transactional
    public Map<String, Object> updatePassword(User user) {
        Map<String,Object> resultMap = new HashMap<>();
        int ifSuccess = userDao.updatePasswrod(user);
        if (ifSuccess == 1) {
            User userInfo = userDao.getUserByUsername(user.getUsername());
            LockUser lockInfo = userDao.getLockInfo(userInfo.getId());
            lockInfo.setPwdLoginDate(new Date());
            userDao.updateLockInfo(lockInfo);
            resultMap.put("statusCode", 200);
            resultMap.put("success", true);
            resultMap.put("message", "密码修改成功");
            resultMap.put("user", userInfo);
        }else {
            resultMap.put("statusCode", 400);
            resultMap.put("success", false);
            resultMap.put("message", "密码修改失败，用户名不存在");
        }
        return resultMap;
    }
}
