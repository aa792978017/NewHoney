package com.honeypot.honeypot.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.Department;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DepartmentManagementService {
    @Transactional
    JSONArray getAllDepts();
    @Transactional
    Department getDeptByDepName(String depName);
    @Transactional
    Department getDeptById(int id);
    @Transactional
    JSONObject addDept(JSONObject deptJson);
    @Transactional
    JSONObject delDept(JSONArray delArray);
    @Transactional
    JSONObject updateDept(JSONObject updateJson);
}
