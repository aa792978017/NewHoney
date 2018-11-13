package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DepartmentDao {
    /**
     * 获取全部部门信息
     * @return
     */
    public List<Department> getAllDepts();

    /**
     * 根据部门名称获取单个部门信息
     * @param depName
     * @return
     */
    public Department getDeptByDepName(String depName);

    /**
     * 根据部门id获取单个部门信息
     * @param id
     * @return
     */
    public Department getDeptById(int id);

    /**
     * 增加部门
     * @param newDepartment
     * @return
     */
    public boolean addDept(@Param("newDepartment") Department newDepartment);

    /**
     * 删除部门
     * @param depName
     * @return
     */
    public boolean delDept(String depName);

    /**
     * 更新部门
     * @param updateDepartment
     * @return
     */
    public boolean updateDept(Department updateDepartment);
    /**
     * 获取所有department信息
     * @return
     */
    List<Department> getAllTypes();
}
