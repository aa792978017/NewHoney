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
    /**

     * 获取所有系统日志
     * 调用SystemLogDao中的方法获得List<SystemLog>
     * @return JSONArray
     * 根据前端要求，返回如下形式的JSONArray

     *       [{"id": xx, "operationTime": xx, "operationUser": xx, "operationName": xx, "remark": xx},

     *       ......,

     *       {"id": xx, "operationTime": xx, "operationUser": xx, "operationName": xx, "remark": xx}]

     */
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
    /**

     * 删除系统日志，前端勾选的系统日志个数不同，故按照JSONArray处理

     * 遍历array，对每一个JSONObject进行删除

     * 若其中有某个系统日志删除失败，则返回其ID并停止删除

     * 否则删除成功，返回"success"供前端处理

     * @param delArray

     * 前端传来jsonArray形式为

     * [{"id": xx}, {"id": yy}, ..., {"id": nn}]

     * @return

     */
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
