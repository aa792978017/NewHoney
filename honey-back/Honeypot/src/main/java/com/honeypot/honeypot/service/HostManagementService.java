package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.*;

import java.util.List;

public interface HostManagementService {
    /**
     * 状态检测页面，获取状态
     * @param state
     * @return
     */
     int getStateCount(Integer state);

    /**
     * 根据host类型返回该类型数量
     * @param hostType
     * @return
     */
     int getHostTypeCount(Object hostType);

    /**
     * 获取host主机类型
     * @return
     */
     List<HostType> getHostTypes();

    /**
     * 获取所有省份
     * @return
     */
     List<Province> getProvinces();

    /**
     * 根据省份获取该host数量
     * @param province
     * @return
     */
     int getDepTypeCount(Integer province);

    /**
     * 获取所有os类型
     * @return
     */
    List<OsType> getOsTypes();

    /**
     * 根据osType类型的数量
     * @param osTypeId
     * @return
     */
    int getOsCount(Integer osTypeId);

    /**
     * 获取警告列表
     * @return
     */
    List<WarningCriterial> getLastWarning();

    /**
     * 获取所有状态类型
     * @return
     */
    List<StateType> getAllStateType();


}
