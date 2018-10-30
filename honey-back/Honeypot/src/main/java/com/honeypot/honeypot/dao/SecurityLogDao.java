package com.honeypot.honeypot.dao;


import com.honeypot.honeypot.entity.SecurityLog;


import java.util.List;
//@Mapper
public interface SecurityLogDao {
    public List<SecurityLog> getAllSecurityLog();
    // 删除一个审计日志
    public boolean delSecurityLog(String operationUser);
   /* @Select( "select * from atad.security_log" )
    List<SecurityLog> findSecurityLogList();*/
}
