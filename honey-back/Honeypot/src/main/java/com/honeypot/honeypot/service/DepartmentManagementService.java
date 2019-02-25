package com.honeypot.honeypot.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.Department;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DepartmentManagementService {
    /**
     * 获取所有部门信息
     * @return
     */
    @Transactional
    JSONArray getAllDepts();

    /**
     * 根据部门名称查找部门
     * @param depName
     * @return
     */
    @Transactional
    Department getDeptByDepName(String depName);

    /**
     * 根据部门id查找部门
     * @param id
     * @return
     */
    @Transactional
    Department getDeptById(int id);

    /**
     * 添加部门
     * @param deptJson
     * @return
     */
    @Transactional
    JSONObject addDept(JSONObject deptJson);

    /**
     * 删除部门
     * @param delArray
     * @return
     */
    @Transactional
    JSONObject delDept(JSONArray delArray);

    /**
     * 修改部门信息
     * @param updateJson
     * @return
     */
    @Transactional
    JSONObject updateDept(JSONObject updateJson);
}
