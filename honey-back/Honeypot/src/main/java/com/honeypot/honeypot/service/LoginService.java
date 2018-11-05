package com.honeypot.honeypot.service;

import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Map;

public interface LoginService {
    /**
     *登录功能，验证用户名和密码是否正确
     * @return
     */
    Map<String,Object> checkUserNameAndPassword(User nowUser, JSONObject jsonObject, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException;

    /**
     * 普通用户修改密码
     * @param user
     * @return
     */
    Map<String,Object> updatePassword(User user);
}
