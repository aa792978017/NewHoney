package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.HostType;
import com.honeypot.honeypot.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProvinceDao {
    /**
     * 获取所有省份
     * @return
     */
    List<Province> getAllTypes();

//    /**
//     * 根据查该省数量
//     * @param departmentId
//     * @return
//     */
//    List<Province> getAllRowCount(@Param("departmentId")Integer departmentId);

}
