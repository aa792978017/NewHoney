package com.honeypot.honeypot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/system_log")
public class SystemLogController {

    /**
     * 删除系统日志，前端勾选可以是多个，所以用JSONArray处理
     * @param delArray
     * [{"id": 1}, {"id": 2}, ..., {"id": x}]
     * @return result
     * eg. {"result": "success"}
     */
    @Autowired
    private SystemLogService systemLogService;

    @RequestMapping(value = "/AllSystemLog")
    public JSONArray getAllSystemLog() {
        return systemLogService.getAllSystemLog();
    }
    @ResponseBody
    @RequestMapping(value = "/delSystemLog", method = RequestMethod.POST)
    public JSONObject delSystemLog(@RequestBody JSONArray delArray){
        return systemLogService.delSystemLog(delArray);
    }
}




