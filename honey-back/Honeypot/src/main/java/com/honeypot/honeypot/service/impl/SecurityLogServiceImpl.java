package com.honeypot.honeypot.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.dao.SecurityLogDao;
import com.honeypot.honeypot.entity.SecurityLog;
import com.honeypot.honeypot.service.SecurityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SecurityLogServiceImpl implements SecurityLogService {
    @Autowired
    private SecurityLogDao securityLogDao;

    public JSONArray getAllSecurityLog() {
        List<SecurityLog> securityLogs = securityLogDao.getAllSecurityLog();
        JSONArray array = new JSONArray();

        for (SecurityLog securityLog : securityLogs){
            JSONObject one = new JSONObject();
            one.put("id", securityLog.getId() == null ? "" : securityLog.getId());
            one.put("operationUser", securityLog.getOperationUser() == null ? "" : securityLog.getOperationUser());
            one.put("operationName", securityLog.getOperationName() == null ? "" : securityLog.getOperationName());
            one.put("operationTime", securityLog.getOperationTime() == null ? "" : securityLog.getOperationTime());
            one.put("remark", securityLog.getRemark() == null ? "" : securityLog.getRemark());
            one.put( "userDuty",securityLog.getUserDuty() == null ? "" : securityLog.getUserDuty());
            array.add(one);
        }
        return array;
    }
    @Override
    public JSONObject delSecurityLog(JSONArray delArray) {
        JSONObject result = new JSONObject();
        for(int i = 0; i < delArray.size(); i++){
            JSONObject obj = delArray.getJSONObject(i);
            if(!securityLogDao.delSecurityLog(obj.getString("id"))){
                result.put("result", obj.getString("id"));
                return result;
            }
        }
        result.put("result", "success");
        return result;
    }

}
