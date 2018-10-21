package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityService {

    List<City> getAllTypes();

    List<City> getAllTypeByProvinceId(Integer provinceId);

    City getCity(Integer cityId);
}
