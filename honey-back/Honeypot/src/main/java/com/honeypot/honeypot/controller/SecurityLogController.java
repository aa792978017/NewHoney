package com.honeypot.honeypot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.service.SecurityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 功能：接收平台管理-审计日志界面的请求，做出响应
 * 前端页面：平台管理-系统日志
 * 开发人员：阿力木
 */

@RestController
@CrossOrigin
@RequestMapping("/security_log")
public class SecurityLogController {

    @Autowired
    private SecurityLogService securityLogService;
    /**
     * 获取数据库中所有审计日志
     * @return 包含所有系统日志信息的JSONArray，每个系统日志是一个JSONObject
     */
    @RequestMapping( value = "/AllSecurityLog")
    public JSONArray getAllSecurityLog() {
        return securityLogService.getAllSecurityLog();
    }
    /**
     * 删除审计日志，接受前端勾选可不唯一，所以用JSONArray处理
     * @param delArray
     * [{"id": 1}, {"id": 2}, ..., {"id": x}]
     * @return result
     * eg. {"result": "success"}
     */

    @ResponseBody
    @RequestMapping(value = "/delSecurityLog", method = RequestMethod.POST)
    public JSONObject delSecurityLog(@RequestBody JSONArray delArray){
        return securityLogService.delSecurityLog(delArray);
    }
}
