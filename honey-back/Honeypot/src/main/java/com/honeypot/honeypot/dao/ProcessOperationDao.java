package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.ProcessOperation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProcessOperationDao {
    List<ProcessOperation> getAllProcessOperation(@Param("uniqueId")Integer uniqueId);
    List<ProcessOperation> getAimProcessOperation(@Param("uniqueId")Integer uniqueId,@Param("opType")String opType,@Param("currentProcessName")String currentProcessName,@Param("currentProcessID")String currentProcessID,@Param("objectProcessName")String objectProcessName,@Param("objectProcessID")String objectProcessID,@Param("time")String time);
}
