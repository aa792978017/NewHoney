package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.RecoverThread;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecoverThreadDao {

    /**
     * 根据uniqueid,获取全部恢复线程操作信息
     * @param uniqueId
     * @return
     * */
    List<RecoverThread> getAllRecoverThread(@Param("uniqueId")long uniqueId);

    /**
     * 根据查询条件，获取目标恢复线程操作信息
     * @param uniqueid
     * @param pendingProcessID
     * @param dependProcessName
     * @param dependProcessID
     * @param time
     * @param currentProcessID
     * @param currentProcessName
     * @return
     * */
    List<RecoverThread> getAimRecoverThread(@Param("uniqueId") long uniqueid,@Param("currentProcessName") String currentProcessName,@Param("currentProcessID") String currentProcessID,@Param("pendingProcessID") String pendingProcessID,@Param("dependProcessName") String dependProcessName,@Param("dependProcessID") String dependProcessID,@Param("time") String time);
}
