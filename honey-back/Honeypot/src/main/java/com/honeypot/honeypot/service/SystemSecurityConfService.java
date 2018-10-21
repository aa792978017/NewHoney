package com.honeypot.honeypot.service;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.SystemSecurityConf;

import org.springframework.transaction.annotation.Transactional;

public interface SystemSecurityConfService {
    @Transactional
    com.alibaba.fastjson.JSONObject getSystemSecurityConf() throws JSONException;

    @Transactional
    SystemSecurityConf getAConfByName(String confName);

    @Transactional
    JSONObject updateSystemSecurityConf(JSONObject updateConf);
}
