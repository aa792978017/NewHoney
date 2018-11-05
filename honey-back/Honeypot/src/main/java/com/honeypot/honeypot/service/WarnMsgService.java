package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.AlarmInfo;
import com.honeypot.honeypot.entity.AlarmInfoResult;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface WarnMsgService {

    /**
     * 获取最近一周内的警告信息
     * @return
     */
    Map<String,Object> getWarnMsgNum();

    List<AlarmInfoResult> getNewWarnMsg();

    List<AlarmInfoResult> getMoreWarnMsg();
}
