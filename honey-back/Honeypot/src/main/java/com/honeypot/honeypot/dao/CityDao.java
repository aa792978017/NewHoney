package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CityDao {
    /**
     * 获取所有城市信息
     * @return
     */
    List<City> getAllTypes();

    List<City> getAllTypeByProvinceId(@Param("provinceId") Integer provinceId);

    City getCity(@Param("cityId") Integer cityId);
}
