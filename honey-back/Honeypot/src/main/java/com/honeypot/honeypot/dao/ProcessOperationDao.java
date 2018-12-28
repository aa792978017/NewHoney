package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.ProcessOperation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProcessOperationDao {

    /**
     * 根据uniqueid,获取全部进程操作信息
     * @param uniqueId
     * @return
     * */
    List<ProcessOperation> getAllProcessOperation(@Param("uniqueId")long uniqueId);

    /**
     * 根据查询条件，获取目标进程操作信息
     * @param uniqueId
     * @param time
     * @param opType
     * @param currentProcessID
     * @param currentProcessName
     * @param objectProcessID
     * @param objectProcessName
     * @return
     * */
    List<ProcessOperation> getAimProcessOperation(@Param("uniqueId")long uniqueId,@Param("opType")String opType,@Param("currentProcessName")String currentProcessName,@Param("currentProcessID")String currentProcessID,@Param("objectProcessName")String objectProcessName,@Param("objectProcessID")String objectProcessID,@Param("time")String time);
}
