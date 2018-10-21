package com.honeypot.honeypot.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.Pot;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PotService {
    /**
     * 应该根据类型获取蜜罐信息，暂时写死
     * getHostPotByType 是主机蜜罐管理页面的方法
     * @return
     */
    List<Pot> getPotByType(String type);
    List<Pot> getHostPotByType(String type);
    List<Pot> getPotByIp(String ip);
    @Transactional
    JSONObject delPot(JSONArray delArray);
}
