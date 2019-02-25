package com.honeypot.honeypot.service;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.SystemSecurityConf;

import org.springframework.transaction.annotation.Transactional;

public interface SystemSecurityConfService {
    /**
     * 获取所有系统安全配置信息
     * @return
     * @throws JSONException
     */
    @Transactional
    JSONObject getSystemSecurityConf() throws JSONException;

    /**
     * 根据安全配置名称获取该项系统安全配置
     * 共四项系统安全配置，每一项都是一个对象
     * @param confName
     * @return
     */
    @Transactional
    SystemSecurityConf getAConfByName(String confName);

    /**
     * 修改系统安全配置信息
     * @param updateConf
     * @return
     */
    @Transactional
    JSONObject updateSystemSecurityConf(JSONObject updateConf);
}
