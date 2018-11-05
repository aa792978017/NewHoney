package com.honeypot.honeypot.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.dao.PotDao;
import com.honeypot.honeypot.entity.Pot;
import com.honeypot.honeypot.service.PotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PotServiceImpl implements PotService {
    @Autowired
    private PotDao potDao;
    @Override
    public List<Pot> getPotByType(String type) {
        List<Pot> potList = new ArrayList<Pot>();
        potList = potDao.getPotByType(type);
        for(int i = 0; i < potList.size();i++){
            potList.get(i).setId(i+1);
        }
        return potList;
    }
    @Override
    public List<Pot> getHostPotByType(String type) {
        List<Pot> potList = new ArrayList<Pot>();
        potList = potDao.getHostPotByType(type);
        for(int i = 0; i < potList.size();i++){
            potList.get(i).setId(i+1);
        }

        return potList;
    }

    @Override
    public List<Pot> getPotByIp(String ip) {
        List<Pot> potList = new ArrayList<Pot>();
        potList = potDao.getPotByIp(ip);
        for(int i = 0; i < potList.size();i++){
            potList.get(i).setId(i+1);
        }
        return potList;
    }

}
