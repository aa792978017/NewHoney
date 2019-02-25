package com.honeypot.honeypot.service.impl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.dao.DepartmentDao;
import com.honeypot.honeypot.entity.Department;
import com.honeypot.honeypot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.getAllTypes();
    }
}
