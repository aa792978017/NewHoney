package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.Module;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ModuleDao {

    /**
     * 根据uniqueid,获取全部模块操作信息
     * @param uniqueId
     * @return
     * */
    List<Module> getAllModule(@Param("uniqueId")long uniqueId);

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
    List<Module> getAimModule(@Param("uniqueId")long uniqueid,@Param("opType") String opType,@Param("processName") String processName,@Param("processNum") String processNum,@Param("regeditName") String regeditName,@Param("time") String time);
}
