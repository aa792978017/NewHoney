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
    /**
     * 删除用户，前端勾选的用户个数不同，故按照JSONArray处理
     * 遍历array，对每一个JSONObject进行删除
     * 若其中有某个用户删除失败，则返回其ID并停止删除
     * 否则删除成功，返回"success"供前端处理
     * @param delArray
     * 前端传来jsonArray形式为
     * [{"id": 1}, {"id": 2}, ..., {"id": n}]
     * @return
     */
    @Override
    public JSONObject delPot(JSONArray delArray) {
        JSONObject result = new JSONObject();
        for(int i = 0; i < delArray.size(); i++){
            JSONObject obj = delArray.getJSONObject(i);
            if(!potDao.delPot(obj.getString("ip"))){
                result.put("result", obj.getString("ip"));
                return result;
            }
        }
        result.put("result", "success");
        return result;
    }




}
