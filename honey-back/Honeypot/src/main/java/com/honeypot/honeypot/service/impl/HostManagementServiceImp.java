package com.honeypot.honeypot.service.impl;

import com.honeypot.honeypot.dao.*;
import com.honeypot.honeypot.entity.*;
import com.honeypot.honeypot.service.HostManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HostManagementServiceImp implements HostManagementService {
    @Autowired
    private HostDao hostDao;

    @Autowired
    private ProvinceDao provinceDao;

    @Autowired
    private OsDao osDao;
    @Autowired
    private WarningDao warningDao;

    @Autowired
    private StateTypeDao stateTypeDao;

    /**
     * 与原来的方法有出入，输入状态值，返回状态值的数据个数
     * @param state
     * @return
     */
    @Override
    public int getStateCount(Integer state) {

        return hostDao.getAllRowCountByState(state).size() ;
    }

    @Override
    public int getHostTypeCount(Object hostType) {
        return hostDao.getAllRowCountByHostType(hostType).size();
    }

    /**
     * 获取所有host主机类型
     * @return
     */
    @Override
    public List<HostType> getHostTypes() {
        return hostDao.getAllTypes();
    }

    @Override
    public List<Province> getProvinces() {
        return provinceDao.getAllTypes();
    }

    @Override
    public int getDepTypeCount(Integer province) {
        return hostDao.getHostByProvince(province).size();
    }

    @Override
    public List<OsType> getOsTypes() {
        return osDao.getAllTypes();
    }

    @Override
    public int getOsCount(Integer osTypeId) {
        return osDao.getOsTypeCountByOsType(osTypeId).size();
    }

    @Override
    public List<WarningCriterial> getLastWarning() {
        return warningDao.getLastWarning();
    }

    @Override
    public List<StateType> getAllStateType() {
        return stateTypeDao.getAllStateType();
    }
}
