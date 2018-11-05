package com.honeypot.honeypot.dao;

import com.honeypot.honeypot.entity.StateType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StateTypeDao {
    /**
     * 获取所有状态类型
     * @return
     */
    List<StateType> getAllStateType();
}
