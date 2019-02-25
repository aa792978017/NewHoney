package com.honeypot.honeypot.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.Pot;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PotService {
    /**
     * 根据类型获取蜜罐信息
     * @return
     */
    List<Pot> getPotByType(String type);
    /**
     * 应该根据类型获取主机蜜罐信息
     * getHostPotByType 是主机蜜罐管理页面的方法
     * @return
     */
    List<Pot> getHostPotByType(String type);
    /**
     *根据IP获取蜜罐信息
     * @return
     */
    List<Pot> getPotByIp(String ip);
    /**
     *删除主机蜜罐信息
     * @return
     */

    /**
     * 添加蜜罐信息
     * @param pot
     * @return
     */
    int addPot(Pot pot);

    String deletepotbyid(int id);

}
