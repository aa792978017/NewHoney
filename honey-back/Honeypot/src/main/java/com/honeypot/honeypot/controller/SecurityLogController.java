package com.honeypot.honeypot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.service.SecurityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
@RequestMapping("/security_log")
public class SecurityLogController {
    /**
     * 删除审计日志，接受前端勾选可不唯一，所以用JSONArray处理
     * @param delArray
     * [{"id": 1}, {"id": 2}, ..., {"id": x}]
     * @return result
     * eg. {"result": "success"}
     */
    @Autowired
    private SecurityLogService securityLogService;
    @RequestMapping( value = "/AllSecurityLog")
    public JSONArray getAllSecurityLog() {
        return securityLogService.getAllSecurityLog();
    }

    @ResponseBody
    @RequestMapping(value = "/delSecurityLog", method = RequestMethod.POST)
    public JSONObject delSecurityLog(@RequestBody JSONArray delArray){
        return securityLogService.delSecurityLog(delArray);
    }
}
