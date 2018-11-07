
package com.honeypot.honeypot.dao;

import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.LockUser;
import com.honeypot.honeypot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface UserDao {
//    @Select("Select id,username,password from user")

    /**
     * 获取全部用户，用来前端table显示
     * @return
     */
    public List<User> getAllUsers();

    /**
     * 获取单个用户，根据用户名来检查是否已有该用户
     * @param username
     * @return
     */
    public User getUserByUsername(String username);

    /**
     * 获取单个用户，根据id来检查是否已有该用户
     * @param id
     * @return
     */
    public User getUserById(int id);

    /**
     * 添加一个新用户
     * @param newUser 一个用户对象
     * @return
     */
    public boolean addUser(User newUser);

    /**
     * 删除一个用户
     * @param username
     * @return
     */
    public boolean delUser(String username);

    /**
     * 修改一个用户
     * @param updateUser 一个用户对象
     * @return
     */
    public boolean updateUser(User updateUser);

    /**
     * 检查用户是否被锁定
     * @param id
     * @return
     */
    public int isLocked(int id);

    /**
     * 解锁用户
     * @param id
     * @return
     */
    public boolean unlockUser(int id);

    /**
     * 获取用户锁信息
     * @param id
     * @return
     */
    LockUser getLockInfo(int id);

    /**
     * 更新用户锁信息
     * @param lockUser
     * @return
     */
    int updateLockInfo(@Param("lockUser") LockUser lockUser);

    /**
     * 通过用户名修改密码
     * @param user
     * @return
     */
     int updatePasswrod(@Param(("user")) User user);
}

