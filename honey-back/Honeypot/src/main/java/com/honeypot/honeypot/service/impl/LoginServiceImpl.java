package com.honeypot.honeypot.service.impl;

import com.honeypot.honeypot.dao.UserDao;
import com.honeypot.honeypot.entity.User;
import com.honeypot.honeypot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserDao userDao;
    @Override
    public boolean checkUserNameAndPassword(String userName, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        User trueUser = userDao.getUserByUsername(userName);
        if (trueUser != null){
            String newpasswordMD5 = new String();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            newpasswordMD5 = base64Encoder.encode(md5.digest(password.getBytes("UTF-8")));
            if (trueUser.getPassword().equals(password))
                return true ;
            else
                return false;
        }

        else
            return false;

    }
}
