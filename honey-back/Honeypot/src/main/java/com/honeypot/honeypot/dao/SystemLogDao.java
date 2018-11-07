package com.honeypot.honeypot.dao;


import com.honeypot.honeypot.entity.SystemLog;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

public interface SystemLogDao {
    // 获取全部系统日志，用来呈现在面板上
    public List<SystemLog> getAllSystemLog();
    // 删除一个系统日志
    public boolean delSystemLog(String operationUser);
   /* @Select( "select * from atad.system_log" )
    List<SystemLog> findSystemLogList();*/
}
