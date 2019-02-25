package com.honeypot.honeypot.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.transaction.annotation.Transactional;



public interface SystemLogService {
   /**

    * 获取所有系统日志

    * @return

    */
   @Transactional
   JSONArray getAllSystemLog();
   /**

    * 删除系统日志

    * @param delArray

    * @return

    */
   @Transactional
   JSONObject delSystemLog(JSONArray delArray);
}
