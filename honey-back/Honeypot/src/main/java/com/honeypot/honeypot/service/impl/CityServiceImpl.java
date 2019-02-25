package com.honeypot.honeypot.service.impl;

import com.honeypot.honeypot.dao.CityDao;
import com.honeypot.honeypot.entity.City;
import com.honeypot.honeypot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityDao cityDao;
    @Override
    public List<City> getAllTypes() {
        return cityDao.getAllTypes();
    }

    @Override
    public List<City> getAllTypeByProvinceId(Integer provinceId) {
        return cityDao.getAllTypeByProvinceId(provinceId);
    }

    @Override
    public City getCity(Integer cityId) {
        return cityDao.getCity(cityId);
    }
}
