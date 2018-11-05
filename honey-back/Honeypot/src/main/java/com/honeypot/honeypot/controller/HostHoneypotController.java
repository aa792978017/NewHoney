package com.honeypot.honeypot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.Pot;
import com.honeypot.honeypot.service.HostManagementService;
import com.honeypot.honeypot.service.PotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 功能：主机蜜罐信息获取
 * 前端页面：主机蜜罐页面
 * 开发人员：Tahir
 */
@RestController
@CrossOrigin
public class HostHoneypotController {
    @Autowired
    private PotService potService;
    @Autowired
    private HostManagementService hostManagementService;
    /**
     * 主机蜜罐-主机蜜罐管理信息页面
     * @return
     */
    @GetMapping("/getListHostPot")
    @ResponseBody
    public List<Pot> listHostPot() {
        List<Pot> potList = potService.getHostPotByType("");   //暂时把type写死
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("potList",potList);
        return potService.getHostPotByType("");
    }

    /**
     * 删除主机蜜罐
     * @return result
     */
}
