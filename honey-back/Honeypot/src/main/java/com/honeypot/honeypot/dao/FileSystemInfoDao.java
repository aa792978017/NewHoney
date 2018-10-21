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
    //文件操作详情
    List<FileSystemInfo> getAllFileOperation(@Param("uniqueId")Integer uniqueId);
    //目标文件操作详情
    List<FileSystemInfo> getAimFileOperation(@Param("uniqueId")Integer uniqueId,@Param("opType")String opType,@Param("state")String state,@Param("filePath")String filePath,@Param("processPath")String processPath,@Param("processName")String processName,@Param("time")String time);
    //文件map操作详情
    List<FileSystemInfo> getAllFileMapOperation(@Param("uniqueId")Integer uniqueId);
    //目标文件map操作详情
    List<FileSystemInfo> getAimFileMapOperation(@Param("uniqueId")Integer uniqueId,@Param("opType")String opType,@Param("state")String state,@Param("filePath")String filePath,@Param("processPath")String processPath,@Param("processName")String processName,@Param("time")String time);
}
