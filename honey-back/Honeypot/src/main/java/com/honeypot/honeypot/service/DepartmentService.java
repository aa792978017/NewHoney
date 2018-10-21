package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 获取所有department
     * @return
     */
    List<Department> getAllDepartment();
}
