package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.CreateThread;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Mapper
public interface CreateThreadDao {

    /**
     * 根据uniqueid,获取全部进程操作线程信息
     * @param uniqueId
     * @return
     * */
    List<CreateThread> getAllCreateThread(@Param("uniqueId")Integer uniqueId);

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
    List<CreateThread> getAimCreateThread(@Param("uniqueId") Integer uniqueid,@Param("currentProcessName") String currentProcessName, @Param("currentProcessID") String currentProcessID, @Param("threadHandle") String threadHandle, @Param("targetProcessName") String targetProcessName, @Param("targetProcessID") String targetProcessID, @Param("time") String time);

}
