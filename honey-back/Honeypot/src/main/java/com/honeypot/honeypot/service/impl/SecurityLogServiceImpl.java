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
    /**

     * 获取所有审计日志
     * 调用SecurityLogDao中的方法获得List<SecurityLog>
     * @return JSONArray
     * 根据前端要求，返回如下形式的JSONArray

     *       [{"id": xx, "operationTime": xx, "operationUser": xx, "userDuty":xx,"operationName": xx, "remark": xx},

     *       ......,

     *       {"id": xx, "operationTime": xx, "operationUser": xx, "userDuty":xx,"operationName": xx, "remark": xx}]

     */

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

    /**

     * 删除审计日志，前端勾选的审计日志个数不同，故按照JSONArray处理

     * 遍历array，对每一个JSONObject进行删除

     * 若其中有某个审计日志删除失败，则返回其ID并停止删除

     * 否则删除成功，返回"success"供前端处理

     * @param delArray

     * 前端传来jsonArray形式为

     * [{"id": xx}, {"id": yy}, ..., {"id": nn}]

     * @return

     */
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
