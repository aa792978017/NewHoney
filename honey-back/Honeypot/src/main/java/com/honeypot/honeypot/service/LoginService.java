package com.honeypot.honeypot.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface LoginService {
    /**
     *登录功能，验证用户名和密码是否正确
     * @return
     */
    boolean checkUserNameAndPassword(String userName, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException;
}
