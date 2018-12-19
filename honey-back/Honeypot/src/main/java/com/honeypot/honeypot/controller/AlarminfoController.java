package com.honeypot.honeypot.controller;

import com.honeypot.honeypot.entity.AlarmInfo;
import com.honeypot.honeypot.entity.AlarmextendInfo;
import com.honeypot.honeypot.service.AlarminfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class AlarminfoController {
    @Autowired
    private AlarminfoService alarminfoService;

    /**
     * 主机蜜罐-主机告警信息页面
     * @return
     */
    @GetMapping("/getAlarmInfo")
    @ResponseBody
    public List<AlarmInfo> listAlarmInfo(@RequestParam(value="type") int type, @RequestParam(value="uniqueId") long uniqueId ) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<AlarmInfo> AlarmInfoList = alarminfoService.getAlarminfoByUniqueId(type,uniqueId);
        return AlarmInfoList;
    }
    /**
     * 主机蜜罐-主机告警详细信息页面
     * @return
     */
    @GetMapping("/getAlarmExtendInfo")
    @ResponseBody
    public List<AlarmextendInfo> listAlarmExtendInfo(@RequestParam(value="id") int id ) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<AlarmextendInfo> AlarmExtendInfoList = alarminfoService.getAlarmExtendinfoById(id);
        return AlarmExtendInfoList;
    }
}
