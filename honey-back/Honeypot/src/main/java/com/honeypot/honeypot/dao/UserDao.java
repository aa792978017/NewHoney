
package com.honeypot.honeypot.dao;

import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface UserDao {
//    @Select("Select id,username,password from user")
    // 获取全部用户，用来呈现在面板上
    public List<User> getAllUsers();
    // 获取单个用户，根据用户名来检查是否已有该用户
    public User getUserByUsername(String username);
    // 获取单个用户，根据id来检查是否已有该用户
    public User getUserById(int id);
    // 添加一个新用户
    public boolean addUser(User newUser);
    // 删除一个用户
    public boolean delUser(String username);
    // 修改一个用户
    public boolean updateUser(User updateUser);
}

