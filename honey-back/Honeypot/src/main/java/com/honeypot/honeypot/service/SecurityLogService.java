package com.honeypot.honeypot.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.springframework.transaction.annotation.Transactional;



public interface SecurityLogService {

    @Transactional
    JSONArray getAllSecurityLog();

    @Transactional
    JSONObject delSecurityLog(JSONArray delArray);
}
