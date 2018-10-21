package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.SetRegValueKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface SetRegValueKeyDao {
    /**
     * 获取注册表赋值操作信息 表为setregvaluekey
     * */
    List<SetRegValueKey> getAllSetRegValueKey(@Param("uniqueId")Integer uniqueId);
    List<SetRegValueKey> getAimSetRegValueKey(@Param("uniqueId") Integer uniqueid,@Param("processName")String processName,@Param("processID")String processID,@Param("keyValue")String keyValue,@Param("regPath")String regPath,@Param("time")String time);
}
