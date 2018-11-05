/**
 * 处理配置管理-部门管理/安全配置页面的请求
 */
package com.honeypot.honeypot.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.dao.DepartmentDao;
import com.honeypot.honeypot.entity.Department;
import com.honeypot.honeypot.entity.SystemSecurityConf;
import com.honeypot.honeypot.service.DepartmentManagementService;
import com.honeypot.honeypot.service.SystemSecurityConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/honeycontrol")
public class ConfManagementController {
    /**
     * 该Controller会调用两个service
     * 主要注释见各service的实现类
     */
    @Autowired
    private DepartmentManagementService departmentManagementService;
    @Autowired
    private SystemSecurityConfService systemSecurityConfService;

    @RequestMapping(value = "/getAllDepts")
    public JSONArray getAllDepts(){
        return departmentManagementService.getAllDepts();
    }

    /**
     * 添加部门，需要先判断一下该部门是否已存在
     * @param deptJson
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addDept", method = RequestMethod.POST)
    public JSONObject addDept(@RequestBody JSONObject deptJson){
        JSONObject result = new JSONObject();

        if(departmentManagementService.getDeptByDepName(deptJson.getString("depName")) != null)
        {
            result.put("result", "部门已存在，请勿重复添加！");
            return result;
        }

        return departmentManagementService.addDept(deptJson);
    }

    @ResponseBody
    @RequestMapping(value = "/delDept", method = RequestMethod.POST)
    public JSONObject delDept(@RequestBody JSONArray delArray){
        return departmentManagementService.delDept(delArray);
    }

    @ResponseBody
    @RequestMapping(value = "/updateDept", method = RequestMethod.POST)
    public JSONObject updateDept(@RequestBody JSONObject updateJson){
        return departmentManagementService.updateDept(updateJson);
    }

    @RequestMapping(value = "/getSystemSecurityConf")
    public JSONObject getSystemSecurityConf(){
        return systemSecurityConfService.getSystemSecurityConf();
    }

    @ResponseBody
    @RequestMapping(value = "/updateSystemSecurityConf", method = RequestMethod.POST)
    public JSONObject updateSystemSecurityConf(@RequestBody JSONObject updateConf){
        return systemSecurityConfService.updateSystemSecurityConf(updateConf);
    }
}
