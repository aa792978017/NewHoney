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

/**
 * 功能：接收平台管理-部门管理/配置管理的请求，做出响应
 * 前端界面：平台管理-部门管理/皮质管理
 * 开发人员：XiangYuhan
 */
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

    /**
     * 获取数据库中所有部门的信息
     * @return 包含所有部门信息的JSONArray，每个部门信息是一个JSONObject
     */
    @RequestMapping(value = "/getAllDepts")
    public JSONArray getAllDepts(){
        return departmentManagementService.getAllDepts();
    }

    /**
     * 添加部门，需要先判断一下该部门是否已存在
     * @param deptJson
     *  格式：{'depName": xxxx, 'dutyName': xxxx}
     * @return 一个json对象，表示状态
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

    /**
     * 删除（若干）部门，前端可能勾选多个，故按JSONArray处理
     * @param delArray
     *  格式：{'depName': xxxx}
     * @return 一个json对象，表示状态
     */
    @ResponseBody
    @RequestMapping(value = "/delDept", method = RequestMethod.POST)
    public JSONObject delDept(@RequestBody JSONArray delArray){
        return departmentManagementService.delDept(delArray);
    }

    /**
     * 修改部门信息。 对应前端设计，一个弹窗中选择部门名称，修改部门负责人名称。
     * @param updateJson
     *  格式： {'depName': xxxx, 'dutyName': xxxx}
     * @return 一个json对象，表示状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateDept", method = RequestMethod.POST)
    public JSONObject updateDept(@RequestBody JSONObject updateJson){
        return departmentManagementService.updateDept(updateJson);
    }

    /**
     * 获取系统安全配置
     * @return 一个json对象，包含系统安全配置信息（四项）
     */
    @RequestMapping(value = "/getSystemSecurityConf")
    public JSONObject getSystemSecurityConf(){
        return systemSecurityConfService.getSystemSecurityConf();
    }

    /**
     * 修改系统安全配置信息
     * @param updateConf
     *  一个json对象，包含四项信息，由service实现类去判断哪一项被修改就更新哪一项
     * @return 一个json对象，表示状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateSystemSecurityConf", method = RequestMethod.POST)
    public JSONObject updateSystemSecurityConf(@RequestBody JSONObject updateConf){
        return systemSecurityConfService.updateSystemSecurityConf(updateConf);
    }
}
