package com.honeypot.honeypot.service.impl;

import com.honeypot.honeypot.controller.LogQueryController;
import com.honeypot.honeypot.dao.*;
import com.honeypot.honeypot.entity.*;
import com.honeypot.honeypot.service.LogQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class LogQureyServiceImpl implements LogQueryService {
    @Autowired
    private CreateThreadDao createThreadDao;
    @Autowired
    private FileSystemInfoDao fileSystemInfoDao;
    @Autowired
    private ModuleDao moduleDao;
    @Autowired
    private NetInfoDao netinfoDao;
    @Autowired
    private PendingThreadDao pendingThreadDao;
    @Autowired
    private ProcessOperationDao processOperationDao;
    @Autowired
    private RecoverThreadDao recoverThreadDao;
    @Autowired
    private ReginfoDao reginfoDao;
    @Autowired
    private SetRegValueKeyDao setRegValueKeyDao;

    @Override
    public List<FileSystemInfo> getAllFileOperation(Integer uniqueid) {
        return fileSystemInfoDao.getAllFileOperation(uniqueid);
    }

    @Override
    public List<FileSystemInfo> getAimFileOperation(Integer uniqueId, String opType, String state, String filePath, String processPath, String processName, String time) {
        return fileSystemInfoDao.getAimFileOperation(uniqueId,opType,state,filePath,processPath,processName,time);
    }

    @Override
    public List<FileSystemInfo> getAllFileMapOperation(Integer uniqueid) {
        return fileSystemInfoDao.getAllFileMapOperation(uniqueid);
    }

    @Override
    public List<FileSystemInfo> getAimFileMapOperation(Integer uniqueId, String opType, String state, String filePath, String processPath, String processName, String time) {
        return fileSystemInfoDao.getAimFileMapOperation(uniqueId,opType,state,filePath,processPath,processName,time);
    }

    @Override
    public List<NetInfo> getAllNetInfo(Integer uniqueId) {
        return netinfoDao.getAllNetInfo(uniqueId);
    }

    @Override
    public List<Reginfo> getAllReginFo(Integer uniqueid) {
        return reginfoDao.getAllReginfo(uniqueid);
    }

    @Override
    public List<SetRegValueKey> getAllSetRegValueKey(Integer uniqueid) {
        return setRegValueKeyDao.getAllSetRegValueKey(uniqueid);
    }

    @Override
    public List<SetRegValueKey> getAimSetRegValueKey(Integer uniqueid, String processName, String processID, String keyValue, String regPath, String time) {
        return setRegValueKeyDao.getAimSetRegValueKey(uniqueid,processName,processID,keyValue,regPath,time);
    }

    @Override
    public List<ProcessOperation> getAllProcessOperation(Integer uniqueid) {
        return processOperationDao.getAllProcessOperation(uniqueid);
    }

    @Override
    public List<ProcessOperation> getAimProcessOperation(Integer uniqueid, String opType, String currentProcessName, String currentProcessID, String objectProcessName, String objectProcessID, String time) {
        return processOperationDao.getAimProcessOperation(uniqueid,opType,currentProcessName,currentProcessID,objectProcessName,objectProcessID,time);
    }

    @Override
    public List<PendingThread> getAllPendingThread(Integer uniqueid) {
        return pendingThreadDao.getAllPendingThread(uniqueid);
    }

    @Override
    public List<PendingThread> getAimPendingThread(Integer uniqueid, String currentProcessName, String currentProcessID, String pendingProcessID, String dependProcessName, String dependProcessID, String time) {
        return pendingThreadDao.getAimPendingThread(uniqueid,currentProcessName,currentProcessID,pendingProcessID,dependProcessName,dependProcessID,time);
    }

    @Override
    public List<RecoverThread> getAllRecoverThread(Integer uniqueid) {
        return recoverThreadDao.getAllRecoverThread(uniqueid);
    }

    @Override
    public List<RecoverThread> getAimRecoverThread(Integer uniqueid, String currentProcessName, String currentProcessID, String pendingProcessID, String dependProcessName, String dependProcessID, String time) {
        return recoverThreadDao.getAimRecoverThread(uniqueid,currentProcessName,currentProcessID,pendingProcessID,dependProcessName,dependProcessID,time);
    }

    @Override
    public List<CreateThread> getAllCreaterThread(Integer uniqueid) {
        return createThreadDao.getAllCreateThread(uniqueid);
    }

    @Override
    public List<CreateThread> getAimCreateThread(Integer uniqueid,String currentProcessName, String currentProcessID, String threadHandle, String targetProcessName, String  targetProcessID, String time) {
        return createThreadDao.getAimCreateThread(uniqueid,currentProcessName,currentProcessID,threadHandle,targetProcessName,targetProcessID,time);
    }

    @Override
    public List<Module> getAllModule(Integer uniqueid) {
        return moduleDao.getAllModule(uniqueid);
    }

    @Override
    public List<Module> getAimModule(Integer uniqueid, String opType, String processName, String processNum, String regeditName, String time) {
        return moduleDao.getAimModule(uniqueid,opType,processName,processNum,regeditName,time);
    }
}
