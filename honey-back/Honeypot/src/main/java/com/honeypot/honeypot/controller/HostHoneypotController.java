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
     * 删除用户，前端可能勾选多个，故按JSONArray处理
     * @param delArray
     * [{"id": 1}, {"id": 2}, ..., {"id": x}]
     * @return result
     * eg. {"result": "success"}
     */
    @ResponseBody
    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public JSONObject delPot(@RequestBody JSONArray delArray){
        return potService.delPot(delArray);
    }
}
