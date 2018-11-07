package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityService {
    /**
     * 获取所有类型的城市信息
     * @return
     */
    List<City> getAllTypes();

    /**
     * 根据省份id获取所有类型的城市信息
     * @param provinceId
     * @return
     */
    List<City> getAllTypeByProvinceId(Integer provinceId);

    /**
     * 根据城市id查询城市信息
     * @param cityId
     * @return
     */
    City getCity(Integer cityId);
}
