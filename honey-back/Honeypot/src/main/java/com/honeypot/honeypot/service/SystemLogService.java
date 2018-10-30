package com.honeypot.honeypot.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.transaction.annotation.Transactional;



public interface SystemLogService {
   /* int delSystemLog(int id);
    SystemLog findSystemLogById(int id);
    List<SystemLog> findSystemLogList();*/
   @Transactional
   JSONArray getAllSystemLog();
   @Transactional
   JSONObject delSystemLog(JSONArray delArray);
}
