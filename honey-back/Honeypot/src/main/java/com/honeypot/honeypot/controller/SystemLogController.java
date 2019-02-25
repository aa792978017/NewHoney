package com.honeypot.honeypot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 功能：接收平台管理-系统日志界面的请求，做出响应
 * 前端页面：平台管理-系统日志
 * 开发人员：阿力木
 */
@RestController
@CrossOrigin
@RequestMapping("/system_log")
public class SystemLogController {

    @Autowired
    private SystemLogService systemLogService;
    /**
     * 获取数据库中所有系统日志
     * @return 包含所有系统日志信息的JSONArray，每个系统日志是一个JSONObject
     */
    @RequestMapping(value = "/AllSystemLog")
    public JSONArray getAllSystemLog() {
        return systemLogService.getAllSystemLog();
    }
    /**
     * 删除系统日志，前端勾选可以是多个，所以用JSONArray处理
     * @param delArray
     * [{"id": 1}, {"id": 2}, ..., {"id": x}]
     * @return result
     * eg. {"result": "success"}
     */
    @ResponseBody
    @RequestMapping(value = "/delSystemLog", method = RequestMethod.POST)
    public JSONObject delSystemLog(@RequestBody JSONArray delArray){
        return systemLogService.delSystemLog(delArray);
    }
}




