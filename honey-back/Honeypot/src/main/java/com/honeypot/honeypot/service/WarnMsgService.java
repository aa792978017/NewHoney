package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.AlarmInfo;
import com.honeypot.honeypot.entity.AlarmInfoResult;
import com.honeypot.honeypot.entity.AlarmextendInfo;
import org.apache.ibatis.annotations.Select;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface WarnMsgService {

    /**
     * 获取最近一周内的警告信息
     * @return
     */
    Map<String,Object> getWarnMsgNum();

    /**
     * 获取最新的警告信息--实时警告版
     * @return
     */
    List<AlarmInfoResult> getNewWarnMsg();

    /**
     * 获取所有的警告信息--实时警告版
     * @return
     */
    List<AlarmInfoResult> getMoreWarnMsg();

    /**
     * 通过macAddress获取详细的警告信息
     * @param tempId
     * @return
     */
    List<AlarmextendInfo> getDetailInfo(Integer tempId) throws ParseException;
}
