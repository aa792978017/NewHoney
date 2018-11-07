package com.honeypot.honeypot.controller;


import com.honeypot.honeypot.entity.*;
import com.honeypot.honeypot.service.LogQueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 功能：各种日志信息查询
 * 前端页面：原始日志查询
 * 开发人员：lishuo
 * */
@RestController
@CrossOrigin
public class LogQueryController {
    @Autowired
    private LogQueryService logQueryService;


    /**
     * 根据uniqueid，获取对应全部文件操作信息
     * @return
     */
    @GetMapping("/getAllFileOperation")
    @ResponseBody
    public List<FileSystemInfo> getAllFileOperation(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId) {

        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<FileSystemInfo> AllFileMapOperation = logQueryService.getAllFileOperation(Integer.valueOf(uniqueId));


        return AllFileMapOperation;
    }
    /**
     * 根据各种查询条件，获取对应目标文件操作信息
     * @return
     * */
    @GetMapping("/getAimFileOperation")
    @ResponseBody
    public List<FileSystemInfo> getAimFileOperation(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId,@RequestParam(value = "opType", required = false, defaultValue = "") String opType, @RequestParam(value = "state", required = false, defaultValue = "") String state, @RequestParam(value = "filePath", required = false, defaultValue = "") String filePath, @RequestParam(value = "processPath", required = false, defaultValue = "") String processPath, @RequestParam(value = "processName", required = false, defaultValue = "")String processName,@RequestParam(value = "time",required = false,defaultValue = "")String time) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<FileSystemInfo> AimFileMapOperation = logQueryService.getAimFileOperation(Integer.valueOf(uniqueId),opType,state,filePath,processPath,processName,time);
//        System.out.println(request.getSession().getAttribute("uniqueId"));
        return AimFileMapOperation;
    }
    /**
     * 根据uniqueid，获取全部文件map操作详情
     * @return
     */
    @GetMapping("/getAllFileMapOperation")
    @ResponseBody
    public List<FileSystemInfo> getAllFileMapOperation(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<FileSystemInfo> AllFileMapOperation = logQueryService.getAllFileMapOperation(Integer.valueOf(uniqueId));
//        modelMap.put("AllFileMapOperation",AllFileMapOperation.get(0));
//        System.out.println(AllFileMapOperation.size());
//        if (AllFileMapOperation.size() > 0){
//            modelMap.put("success",true);
//        }else {
//            modelMap.put("success",false);
//        }
        return AllFileMapOperation;
    }
    /**
     * 根据查询条件，获取目标文件map操作详情
     * @return
     * */
    @GetMapping("/getAimFileMapOperation")
    @ResponseBody
    public List<FileSystemInfo> getAimFileMapOperation(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId,@RequestParam(value = "opType", required = false, defaultValue = "") String opType, @RequestParam(value = "state", required = false, defaultValue = "") String state, @RequestParam(value = "filePath", required = false, defaultValue = "") String filePath, @RequestParam(value = "processPath", required = false, defaultValue = "") String processPath, @RequestParam(value = "processName", required = false, defaultValue = "")String processName,@RequestParam(value = "time",required = false,defaultValue = "")String time) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<FileSystemInfo> AimFileMapOperation = logQueryService.getAimFileMapOperation(Integer.valueOf(uniqueId),opType,state,filePath,processPath,processName,time);
//        modelMap.put("AllFileMapOperation",AllFileMapOperation.get(0));
//        System.out.println(AllFileMapOperation.size());
//        if (AllFileMapOperation.size() > 0){
//            modelMap.put("success",true);
//        }else {
//            modelMap.put("success",false);
//        }
        return AimFileMapOperation;
    }
    /**
     *根据uniqueid，获取全部网络使用信息
     * @return
     * */
    @GetMapping("/getAllNetInfo")
    public Map<String, Object> getAllNetInfo(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<NetInfo> AllNetInfo = logQueryService.getAllNetInfo(Integer.valueOf(uniqueId));
        modelMap.put("AllNetInfo", AllNetInfo);
        if (AllNetInfo.size() > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;

    }
    /**
     * 根据uniqueid，获取全部注册表基本信息
     * @return
     */
    @GetMapping("/getAllReginfo")
    public Map<String, Object> getAllReginfo(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Reginfo> AllReginFo = logQueryService.getAllReginFo(Integer.valueOf(uniqueId));
        modelMap.put("AllReginFo", AllReginFo);
        if (AllReginFo.size() > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;

    }

    /**
     * 根据uniqueid，获取全部注册表赋值操作
     * @return
     */
    @GetMapping("/getAllSetRegValueKey")
    public Map<String, Object> getAllSetRegValueKey(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<SetRegValueKey> AllSetRegValueKey = logQueryService.getAllSetRegValueKey(Integer.valueOf(uniqueId));
        modelMap.put("AllSetRegValueKey", AllSetRegValueKey);
        if (AllSetRegValueKey.size() > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;
    }
    /**
     *根据查询条件  获取目标注册表赋值操作
     * @return
     * */
    @GetMapping("/getAimSetRegValueKey")
    public Map<String, Object> getAimSetRegValueKey(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId,@RequestParam(value = "processID", required = false, defaultValue = "") String processID, @RequestParam(value = "processName", required = false, defaultValue = "") String processName, @RequestParam(value = "keyValue", required = false, defaultValue = "") String keyValue, @RequestParam(value = "regPath", required = false, defaultValue = "") String regPath, @RequestParam(value = "time", required = false, defaultValue = "") String time)
    {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<SetRegValueKey> AimSetRegValueKey = logQueryService.getAimSetRegValueKey(Integer.valueOf(uniqueId),processName,processID,keyValue,regPath,time);
        modelMap.put("AimSetRegValueKey", AimSetRegValueKey);
        if (AimSetRegValueKey.size() > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;
    }
    /**
     * 根据uniqueid，获取全部进程操作信息
     * @return
     */
    @GetMapping("/getAllProcessOperation")
    public Map<String, Object> getAllProcessOperation(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<ProcessOperation> AllProcessOperation = logQueryService.getAllProcessOperation(Integer.valueOf(uniqueId));
        modelMap.put("AllProcessOperation", AllProcessOperation);
        if (AllProcessOperation.size() > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;

    }

    /**
     * 根据查询条件，获取目标进程操作信息
     * @return
     * */
    @GetMapping("/getAimProcessOperation")
    public Map<String, Object> getAimProcessOperation(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId,@RequestParam(value = "opType", required = false, defaultValue = "") String opType, @RequestParam(value = "currentProcessName", required = false, defaultValue = "") String currentProcessName, @RequestParam(value = "currentProcessID", required = false, defaultValue = "") String currentProcessID, @RequestParam(value = "objectProcessName", required = false, defaultValue = "") String objectProcessName, @RequestParam(value = "objectProcessID", required = false, defaultValue = "") String objectProcessID, @RequestParam(value = "time", required = false, defaultValue = "") String time) {

        Map<String, Object> modelMap = new HashMap<String, Object>();

        List<ProcessOperation> AimProcessOperation = logQueryService.getAimProcessOperation(Integer.valueOf(uniqueId), opType, currentProcessName, currentProcessID, objectProcessName, objectProcessID, time);

        modelMap.put("AimProcessOperation", AimProcessOperation);

        if (AimProcessOperation.size() > 0) {

            modelMap.put("success", true);

        } else {

            modelMap.put("success", false);

        }

        return modelMap;

    }
    /**
     * 根据uniqueid，获取全部进程操作线程信息
     * @return
     */
    @GetMapping("/getAllCreateThread")
    public Map<String, Object> getAllCreateThread(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<CreateThread> AllCreateThread = logQueryService.getAllCreaterThread(Integer.valueOf(uniqueId));
        modelMap.put("AllCreateThread", AllCreateThread);
        if (AllCreateThread.size() > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;

    }

    /**
     *
     * */
    /**
     * 根据查询条件，获取目标进程操作线程信息
     * @return
     */
    @GetMapping("/getAimCreateThread")
    public Map<String, Object> getAimCreateThread(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId,@RequestParam(value = "filemap_currentProcessName", required = false, defaultValue = "") String cunrrentProcessName, @RequestParam(value = "filemap_currentProcessID", required = false, defaultValue = "") String cunrrentProcessID, @RequestParam(value = "filemap_threadHandle", required = false, defaultValue = "") String threadHandle, @RequestParam(value = "filemap_targetProcessName", required = false, defaultValue = "") String targetProcessName, @RequestParam(value = "filemap_targetProcessID", required = false, defaultValue = "") String targetProcessID, @RequestParam(value = "filemap_time", required = false, defaultValue = "") String time) {

        Map<String, Object> modelMap = new HashMap<String, Object>();

        List<CreateThread> AimCreateThread = logQueryService.getAimCreateThread(Integer.valueOf(uniqueId), cunrrentProcessName, cunrrentProcessID, threadHandle, targetProcessName, targetProcessID, time);

        modelMap.put("AimCreateThread", AimCreateThread);

        if (AimCreateThread.size() > 0) {

            modelMap.put("success", true);

        } else {

            modelMap.put("success", false);

        }

        return modelMap;

    }

    /**
     * 根据uniqueid，获取全部挂起线程操作信息
     * @return
     */
    @GetMapping("/getAllPendingThread")
    public Map<String, Object> getAllPendingThread(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<PendingThread> AllPendingThread = logQueryService.getAllPendingThread(Integer.valueOf(uniqueId));
        modelMap.put("AllPendingThread", AllPendingThread);
        if (AllPendingThread.size() > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;

    }

    /**
     * 根据查询条件，获取目标挂起线程操作信息
     * @return
     * */
    @GetMapping("getAimPendingThread")
    public Map<String, Object> getAimPendingThread(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId,@RequestParam(value = "cunrrentProcessName", required = false, defaultValue = "") String cunrrentProcessName, @RequestParam(value = "cunrrentProcessID", required = false, defaultValue = "") String cunrrentProcessID, @RequestParam(value = "pendingProcessID", required = false, defaultValue = "") String pendingProcessID, @RequestParam(value = "dependProcessName", required = false, defaultValue = "") String dependProcessName, @RequestParam(value = "dependProcessID", required = false, defaultValue = "") String dependProcessID, @RequestParam(value = "time", required = false, defaultValue = "") String time) {

        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<PendingThread> AimPendingThread = logQueryService.getAimPendingThread(Integer.valueOf(uniqueId),cunrrentProcessName,cunrrentProcessID,pendingProcessID,dependProcessName,dependProcessID,time);
        modelMap.put("AimPendingThread", AimPendingThread);
        if (AimPendingThread.size() > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;

    }
    /**
     * 根据uniqueid，获取全部恢复线程操作信息
     * @return
     */
    @GetMapping("/getAllRecoverThread")
    public Map<String, Object> getAllRecoverThread(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RecoverThread> AllRecoverThread = logQueryService.getAllRecoverThread(Integer.valueOf(uniqueId));
        modelMap.put("AllRecoverThread", AllRecoverThread);
        if (AllRecoverThread.size() > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;

    }
    /**
     * 根据查询条件，获取目标恢复线程操作信息
     * @return
     * */
    @GetMapping("/getAimRecoverThread")
    public Map<String, Object> getAimRecoverThread(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId,@RequestParam(value = "cunrrentProcessName", required = false, defaultValue = "") String cunrrentProcessName, @RequestParam(value = "cunrrentProcessID", required = false, defaultValue = "") String cunrrentProcessID, @RequestParam(value = "pendingProcessID", required = false, defaultValue = "") String pendingProcessID, @RequestParam(value = "dependProcessName", required = false, defaultValue = "") String dependProcessName, @RequestParam(value = "dependProcessID", required = false, defaultValue = "") String dependProcessID, @RequestParam(value = "time", required = false, defaultValue = "") String time) {

        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RecoverThread> AimRecoverThread = logQueryService.getAimRecoverThread(Integer.valueOf(uniqueId),cunrrentProcessName,cunrrentProcessID,pendingProcessID,dependProcessName,dependProcessID,time);
        modelMap.put("AimRecoverThread", AimRecoverThread);
        if (AimRecoverThread.size() > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;

    }
    /**
     * 根据uniqueid，获取全部模块操作信息
     * @return
     */
    @GetMapping("/getAllModule")
    public Map<String, Object> getAllModule(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Module> AllModule = logQueryService.getAllModule(Integer.valueOf(uniqueId));
        modelMap.put("AllModule", AllModule);
        if (AllModule.size() > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;

    }

    /**
     * 根据查询条件，获取目标模块操作信息
     * @return
     */
    @GetMapping("/getAimModule")
    public Map<String, Object> getAimModule(@RequestParam(value = "uniqueId", required = false, defaultValue = "") String uniqueId,@RequestParam(value = "opType", required = false, defaultValue = "") String opType, @RequestParam(value = "processNum", required = false, defaultValue = "") String processNum, @RequestParam(value = "processName", required = false, defaultValue = "") String processName, @RequestParam(value = "regeditName", required = false, defaultValue = "") String regeditName, @RequestParam(value = "time", required = false, defaultValue = "") String time) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Module> AimModule = logQueryService.getAimModule(Integer.valueOf(uniqueId),opType,processName,processNum,regeditName,time);
        modelMap.put("AimModule", AimModule);
        if (AimModule.size() > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;

    }

    /**
     * 日期转换
     * */
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }


}


