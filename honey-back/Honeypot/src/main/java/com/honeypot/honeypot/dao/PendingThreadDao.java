package com.honeypot.honeypot.dao;

import java.util.List;
import com.honeypot.honeypot.entity.PendingThread;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PendingThreadDao {
    /**
     * 挂起线程操作信息
     * */
    List<PendingThread> getAllPendingThread(@Param("uniqueId")Integer uniqueId);
    List<PendingThread> getAimPendingThread(@Param("uniqueId") Integer uniqueid,@Param("currentProcessName") String currentProcessName,@Param("currentProcessID") String currentProcessID,@Param("pendingProcessID") String pendingProcessID,@Param("dependProcessName") String dependProcessName,@Param("dependProcessID") String dependProcessID,@Param("time") String time);
}
