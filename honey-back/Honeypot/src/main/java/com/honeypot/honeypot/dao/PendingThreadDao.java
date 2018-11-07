package com.honeypot.honeypot.dao;

import java.util.List;
import com.honeypot.honeypot.entity.PendingThread;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PendingThreadDao {

    /**
     * 根据uniqueid,获取挂起线程操作信息
     * @param uniqueId
     * @return
     * */
    List<PendingThread> getAllPendingThread(@Param("uniqueId")Integer uniqueId);

    /**
     * 根据查询条件，获取目标挂起线程操作信息
     * @param currentProcessName
     * @param currentProcessID
     * @param time
     * @param uniqueid
     * @param dependProcessID
     * @param dependProcessName
     * @param pendingProcessID
     * @return
     * */
    List<PendingThread> getAimPendingThread(@Param("uniqueId") Integer uniqueid,@Param("currentProcessName") String currentProcessName,@Param("currentProcessID") String currentProcessID,@Param("pendingProcessID") String pendingProcessID,@Param("dependProcessName") String dependProcessName,@Param("dependProcessID") String dependProcessID,@Param("time") String time);
}
