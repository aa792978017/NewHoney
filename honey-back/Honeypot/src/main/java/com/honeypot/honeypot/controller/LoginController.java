package com.honeypot.honeypot.controller;

import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.User;
import com.honeypot.honeypot.service.LoginService;
import com.honeypot.honeypot.service.SystemSecurityConfService;
import com.honeypot.honeypot.service.UserService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能：登录功能
 * 页面：登录页面
 * 开发人员：wangchang
 */
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private SystemSecurityConfService systemSecurityConfService;

    @Autowired
    private LoginService loginService;
    
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody JSONObject updateJson) throws UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
        Map<String,Object> modelMap = new HashMap<>();
        //获取安全管理的配置信息，密码失效时间
        JSONObject systemSecurityConfs = systemSecurityConfService.getSystemSecurityConf();
        String password = updateJson.getString("password");
        String userName = updateJson.getString("username");
        if (password.equals("") || userName.equals("")) {
            modelMap.put("success", false);
            return modelMap;
        }
        //用户不存在，登录失败
        User nowUser = userService.getUserByUsername(updateJson.getString("username"));
        if (nowUser == null) {
            modelMap.put("success", false);
            return modelMap;
        }
        // /返回最终结果给前端
        modelMap = loginService.checkUserNameAndPassword(nowUser,systemSecurityConfs, password);
        modelMap.put("success", true);
        modelMap.put("username",nowUser.getUsername());
        modelMap.put("authority", nowUser.getAuthority());
        return modelMap;
    }

    @PostMapping("/updatepassword")
    public Map<String,Object> updatePassword(@RequestBody JSONObject jsonObject){
        Map<String,Object> resultMap = new HashMap<>();
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        JSONObject systemSecurityConfs = systemSecurityConfService.getSystemSecurityConf();
        int passwordLength = systemSecurityConfs.getIntValue("password_length");
        if (password.length() < passwordLength){
            resultMap.put("statusCode", 401);
            resultMap.put("success", false);
            resultMap.put("message", "密码修改失败，密码太短");
            return resultMap;
        }
        User user = new User();
        Base64 base64 = new Base64();
        String base64Password = base64.encodeAsString(password.getBytes());
        user.setUsername(username);
        user.setPassword(base64Password);
        resultMap  = loginService.updatePassword(user);
        return resultMap;

    }
}
