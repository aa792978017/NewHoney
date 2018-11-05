package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.SetRegValueKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface SetRegValueKeyDao {

    /**
     * 根据uniqueid,获取全部注册表赋值操作
     * @param uniqueId
     * @return
     * */
    List<SetRegValueKey> getAllSetRegValueKey(@Param("uniqueId")Integer uniqueId);

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
    List<SetRegValueKey> getAimSetRegValueKey(@Param("uniqueId") Integer uniqueid,@Param("processName")String processName,@Param("processID")String processID,@Param("keyValue")String keyValue,@Param("regPath")String regPath,@Param("time")String time);
}
