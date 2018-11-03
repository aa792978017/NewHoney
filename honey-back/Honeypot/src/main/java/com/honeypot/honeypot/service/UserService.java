package com.honeypot.honeypot.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.User;
import com.honeypot.honeypot.entity.UserCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface UserService {

    @Transactional
    JSONArray getAllUsers();
    @Transactional
    User getUserByUsername(String username);
    @Transactional
    User getUserById(int id);
    @Transactional
    JSONObject addUser(JSONObject userJson);
    @Transactional
    JSONObject delUser(JSONArray delArray);
    @Transactional
    JSONObject updateUser(JSONObject updateJson);

}
