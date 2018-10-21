package com.honeypot.honeypot.service;

import com.honeypot.honeypot.entity.WarningSum;

import java.util.List;
import java.util.Map;

public interface WarningService {
    /**
     * 获取警告总量按月
     * @return
     */
   Map<String, Object> getSumOfWarningSumForMonth();

    /**
     * 根据flag获取一年的警告信息
     * @param flag
     * @return
     */
  Integer getSumOfWarningSumForYear(Integer flag);

    /**
     * 根据flag获取七天内的警告信息
     * @param flag
     * @return
     */
  List<List<Object>> getNumOfWarningFor7DaysNew(Integer flag);

    /**
     * 获取最新的虚拟警告数据
     * @return
     */
  List<WarningSum> getAllWarningSum(Integer flag);
}
