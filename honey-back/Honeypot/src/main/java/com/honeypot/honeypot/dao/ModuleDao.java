package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.Module;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ModuleDao {
    /**
     * 获取模块操作信息
     * */
    List<Module> getAllModule(@Param("uniqueId")Integer uniqueId);

    List<Module> getAimModule(@Param("uniqueId")Integer uniqueid,@Param("opType") String opType,@Param("processName") String processName,@Param("processNum") String processNum,@Param("regeditName") String regeditName,@Param("time") String time);
}
