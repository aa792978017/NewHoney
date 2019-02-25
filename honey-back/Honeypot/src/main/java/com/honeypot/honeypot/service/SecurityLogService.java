package com.honeypot.honeypot.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.springframework.transaction.annotation.Transactional;



public interface SecurityLogService {
    /**

     * 获取所有审计日志

     * @return

     */
    @Transactional
    JSONArray getAllSecurityLog();
    /**

     * 删除审计日志

     * @param delArray

     * @return

     */
    @Transactional
    JSONObject delSecurityLog(JSONArray delArray);
}
