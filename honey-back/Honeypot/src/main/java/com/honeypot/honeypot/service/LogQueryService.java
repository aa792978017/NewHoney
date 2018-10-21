package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.*;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface LogQueryService {
    /**
     * 根据选中的主机uniqueid查询到对应的所有的信息
     * */
    //文件操作
    List<FileSystemInfo> getAllFileOperation(Integer uniqueid);
    //根据查询条件，获取目标文件操作
    List<FileSystemInfo> getAimFileOperation(Integer uniqueId,String opType,String state,String filePath,String processPath,String processName, String time);
    //文件map操作详情
    List<FileSystemInfo> getAllFileMapOperation(Integer uniqueid);
    //根据查询条件，获取目标文件map操作详情
    List<FileSystemInfo> getAimFileMapOperation(Integer uniqueId,String opType,String state,String filePath,String processPath,String processName,String time);
    //网络使用情况
    List<NetInfo> getAllNetInfo(Integer uniqueId);
    //注册表基本信息
    List<Reginfo> getAllReginFo( Integer uniqueid);
    //注册表赋值操作
    List<SetRegValueKey> getAllSetRegValueKey( Integer uniqueid);
    //根据查询条件，获取目标注册表赋值操作
    List<SetRegValueKey> getAimSetRegValueKey( Integer uniqueid,String processName,String processID,String keyValue,String regPath,String time);
    //进程操作信息
    List<ProcessOperation> getAllProcessOperation( Integer uniqueid);
    //根据查询条件，获取目标进程操作信息
    List<ProcessOperation> getAimProcessOperation(Integer uniqueid,String opType,String currentProcessName,String currentProcessID,String objectProcessName,String objectProcessID,String time);
    //挂起线程操作信息
    List<PendingThread> getAllPendingThread( Integer uniqueid);
    //根据查询条件，获取挂起线程操作信息
    List<PendingThread> getAimPendingThread(Integer uniqueid,String currentProcessName,String currentProcessID,String pendingProcessID,String dependProcessName,String dependProcessID,String time);
    //恢复线程信息
    List<RecoverThread> getAllRecoverThread( Integer uniqueid);
    //根据查询条件，获取恢复线程操作信息
    List<RecoverThread> getAimRecoverThread(Integer uniqueid,String currentProcessName,String currentProcessID,String pendingProcessID,String dependProcessName,String dependProcessID,String time);
    //全部进程操作线程信息
    List<CreateThread> getAllCreaterThread( Integer uniqueid);
    //根据查询条件，获取进程操作线程信息
    List<CreateThread> getAimCreateThread(Integer uniqueid,String currentProcessName, String currentProcessID, String threadHandle, String targetProcessName, String targetProcessID, String time);
    //模块操作
    List<Module> getAllModule(Integer uniqueid);
    //根据查询条件，获取模块操作信息
    List<Module> getAimModule(Integer uniqueid,String opType,String processName,String processNum,String regeditName,String time);
}
