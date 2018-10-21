package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.RecoverThread;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecoverThreadDao {
    /**
     * 查询恢复线程操作信息
     * */
    List<RecoverThread> getAllRecoverThread(@Param("uniqueId")Integer uniqueId);
    List<RecoverThread> getAimRecoverThread(@Param("uniqueId") Integer uniqueid,@Param("currentProcessName") String currentProcessName,@Param("currentProcessID") String currentProcessID,@Param("pendingProcessID") String pendingProcessID,@Param("dependProcessName") String dependProcessName,@Param("dependProcessID") String dependProcessID,@Param("time") String time);
}
