package com.honeypot.honeypot.dao;


import com.honeypot.honeypot.entity.SecurityLog;


import java.util.List;

public interface SecurityLogDao {
    /**

     * 获取全部审计日志，用来前端table显示

     * @return

     */
    public List<SecurityLog> getAllSecurityLog();
    /**

     * 删除系统日志

     * @param operationUser

     * @return

     */
    public boolean delSecurityLog(String operationUser);

}
