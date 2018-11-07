package com.honeypot.honeypot.dao;


import com.honeypot.honeypot.entity.SystemLog;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

public interface SystemLogDao {
    /**

     * 获取全部系统日志，用来前端table显示

     * @return

     */

    public List<SystemLog> getAllSystemLog();

    /**

     * 删除系统日志

     * @param operationUser

     * @return

     */
    public boolean delSystemLog(String operationUser);

}
