package com.honeypot.honeypot.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.User;
import com.honeypot.honeypot.entity.UserCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 获取所有用户信息
     * @return
     */
    @Transactional
    JSONArray getAllUsers();

    /**
     * 根据用户名查询用户（其他方法利用)
     * @param username
     * @return
     */
    @Transactional
    User getUserByUsername(String username);

    /**
     * 根据ID查询用户（其他方法利用）
     * @param id
     * @return
     */
    @Transactional
    User getUserById(int id);

    /**
     * 添加用户
     * @param userJson
     * @return
     */
    @Transactional
    JSONObject addUser(JSONObject userJson);

    /**
     * 删除用户
     * @param delArray
     * @return
     */
    @Transactional
    JSONObject delUser(JSONArray delArray);

    /**
     * 修改用户
     * @param updateJson
     * @return
     */
    @Transactional
    JSONObject updateUser(JSONObject updateJson);

    /**
     * 解锁用户
     * @param unlockJson
     * @return
     */
    @Transactional
    JSONObject unlockUser(JSONObject unlockJson);
}
