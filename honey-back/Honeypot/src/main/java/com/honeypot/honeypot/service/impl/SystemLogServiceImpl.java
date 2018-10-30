package com.honeypot.honeypot.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.dao.SystemLogDao;
import com.honeypot.honeypot.entity.SystemLog;
import com.honeypot.honeypot.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemLogServiceImpl implements SystemLogService {
    @Autowired
    private SystemLogDao systemLogDao;
//    @Override
    public JSONArray getAllSystemLog() {
        List<SystemLog> systemLogs = systemLogDao.getAllSystemLog();
        JSONArray array = new JSONArray();

        for (SystemLog systemLog : systemLogs){
            JSONObject one = new JSONObject();
            one.put("id", systemLog.getId() == null ? "" : systemLog.getId());
            one.put("operationUser", systemLog.getOperationUser() == null ? "" : systemLog.getOperationUser());
            one.put("operationName", systemLog.getOperationName() == null ? "" : systemLog.getOperationName());
            one.put("operationTime", systemLog.getOperationTime() == null ? "" : systemLog.getOperationTime());
            one.put("remark", systemLog.getRemark() == null ? "" : systemLog.getRemark());
            array.add(one);
        }
        return array;
    }

    @Override
    public JSONObject delSystemLog(JSONArray delArray) {
        JSONObject result = new JSONObject();
        for(int i = 0; i < delArray.size(); i++){
            JSONObject obj = delArray.getJSONObject(i);
            if(!systemLogDao.delSystemLog(obj.getString("id"))){
                result.put("result", obj.getString("id"));
                return result;
            }
        }
        result.put("result", "success");
        return result;
    }

}
