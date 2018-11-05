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

    /**
     * 通过省份id获取省份信息
     * @param provinceId
     * @return
     */
    List<City> getAllTypeByProvinceId(@Param("provinceId") Integer provinceId);

    /**
     * 通过城市id获取城市信息
     * @param cityId
     * @return
     */
    City getCity(@Param("cityId") Integer cityId);
}
