package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.FileSystemInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件操作信息
 * */
@Mapper
public interface FileSystemInfoDao {

    /**
     * 根据uniqueid，获取全部文件操作信息
     * @param uniqueId
     * */
    List<FileSystemInfo> getAllFileOperation(@Param("uniqueId")Integer uniqueId);

    /**
     * 根据查询条件,获取目标文件操作信息
     * @param uniqueId
     * @param filePath
     * @param opType
     * @param processName
     * @param processPath
     * @param state
     * @param time
     * @return
     * */
    List<FileSystemInfo> getAimFileOperation(@Param("uniqueId")Integer uniqueId,@Param("opType")String opType,@Param("state")String state,@Param("filePath")String filePath,@Param("processPath")String processPath,@Param("processName")String processName,@Param("time")String time);

    /**
     * 根据uniqueid,获取全部文件map操作信息
     * @param uniqueId
     * @return
     * */
    List<FileSystemInfo> getAllFileMapOperation(@Param("uniqueId")Integer uniqueId);

    /**
     * 根据查询条件，获取目标文件map操作详情
     * @param processPath
     * @param processName
     * @param state
     * @param opType
     * @param filePath
     * @param uniqueId
     * @param time
     * @return
     * */
    List<FileSystemInfo> getAimFileMapOperation(@Param("uniqueId")Integer uniqueId,@Param("opType")String opType,@Param("state")String state,@Param("filePath")String filePath,@Param("processPath")String processPath,@Param("processName")String processName,@Param("time")String time);
}
