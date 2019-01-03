package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.*;
import com.honeypot.honeypot.entity.Module;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface LogQueryService {

    /**
     * 根据uniqueid，获取全部文件操作信息
     * @param uniqueid
     * */
    List<FileSystemInfo> getAllFileOperation(long uniqueid);

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
    List<FileSystemInfo> getAimFileOperation(long uniqueId,String opType,String state,String filePath,String processPath,String processName, String time);

    /**
     * 根据uniqueid,获取全部文件map操作信息
     * @param uniqueid
     * @return
     * */
    List<FileSystemInfo> getAllFileMapOperation(long uniqueid);

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
    List<FileSystemInfo> getAimFileMapOperation(long uniqueId,String opType,String state,String filePath,String processPath,String processName,String time);

    /**
     * 根据uniqueid,获取全部网络使用情况
     * @param uniqueId
     * @return
     * */
    List<NetInfo> getAllNetInfo(long uniqueId);

    /**
     * 根据uniqueid,获取全部注册表基本信息
     * @param uniqueid
     * @return
     * */
    List<Reginfo> getAllReginFo( long uniqueid);

    /**
     * 根据uniqueid,获取全部注册表赋值操作
     * @param uniqueid
     * @return
     * */
    List<SetRegValueKey> getAllSetRegValueKey( long uniqueid);

    /**
     * 根据查询条件，获取目标注册表赋值操作
     * @param uniqueid
     * @param processName
     * @param keyValue
     * @param processID
     * @param regPath
     * @param time
     * @return
     * */
    List<SetRegValueKey> getAimSetRegValueKey( long uniqueid,String processName,String processID,String keyValue,String regPath,String time);

    /**
     * 根据uniqueid,获取全部进程操作信息
     * @param uniqueid
     * @return
     * */
    List<ProcessOperation> getAllProcessOperation( long uniqueid);

    /**
     * 根据查询条件，获取目标进程操作信息
     * @param uniqueid
     * @param time
     * @param opType
     * @param currentProcessID
     * @param currentProcessName
     * @param objectProcessID
     * @param objectProcessName
     * @return
     * */
    List<ProcessOperation> getAimProcessOperation(long uniqueid,String opType,String currentProcessName,String currentProcessID,String objectProcessName,String objectProcessID,String time);

    /**
     * 根据uniqueid,获取挂起线程操作信息
     * @param uniqueid
     * @return
     * */
    List<PendingThread> getAllPendingThread( long uniqueid);

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
    List<PendingThread> getAimPendingThread(long uniqueid,String currentProcessName,String currentProcessID,String pendingProcessID,String dependProcessName,String dependProcessID,String time);

    /**
     * 根据uniqueid,获取全部恢复线程操作信息
     * @param uniqueid
     * @return
     * */
    List<RecoverThread> getAllRecoverThread( long uniqueid);

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
    List<RecoverThread> getAimRecoverThread(long uniqueid,String currentProcessName,String currentProcessID,String pendingProcessID,String dependProcessName,String dependProcessID,String time);

    /**
     * 根据uniqueid,获取全部进程操作线程信息
     * @param uniqueid
     * @return
     * */
    List<CreateThread> getAllCreaterThread( long uniqueid);

    /**
     * 根据查询条件，获取全部进程操作线程信息
     * @param uniqueid
     * @param currentProcessName
     * @param currentProcessID
     * @param time
     * @param targetProcessID
     * @param targetProcessName
     * @param threadHandle
     * @return
     * */
    List<CreateThread> getAimCreateThread(long uniqueid,String currentProcessName, String currentProcessID, String threadHandle, String targetProcessName, String targetProcessID, String time);

    /**
     * 根据uniqueid,获取全部模块操作信息
     * @param uniqueid
     * @return
     * */
    List<Module> getAllModule(long uniqueid);

    /**
     * 根据查询条件，获取目标模块操作信息
     * @param uniqueid
     * @param time
     * @param opType
     * @param processName
     * @param processNum
     * @param regeditName
     * @return
     * */
    List<Module> getAimModule(long uniqueid, String opType, String processName, String processNum, String regeditName, String time);
}
