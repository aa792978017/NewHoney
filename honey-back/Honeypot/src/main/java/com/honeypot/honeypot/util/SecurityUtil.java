package com.honeypot.honeypot.util;
import com.alibaba.fastjson.JSONObject;
import com.honeypot.honeypot.entity.LockUser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class SecurityUtil {

    /**
     * 判断是否到达解锁日期
     *  如果到达解锁日期，返回true，
     * @param lockBeginDate
     * @param unLockDayCount
     * @return
     */
    public static boolean ifunLock(Date lockBeginDate, int unLockDayCount) {
        Date now = new Date();
        Date endDate = new Date(lockBeginDate.getTime() + 60 * 1000 * unLockDayCount);
        if (now.getTime() >= endDate.getTime()){
            return true;
        }
        return false;
    }

    /**
     * 密码错误超出允许值后，计算需要还需要等待的时间
     * @param lockBeginDate
     * @param unLockDayCount
     * @return
     */
    public static String waitTime(Date lockBeginDate, int unLockDayCount) {
        long endTime = (new Date(lockBeginDate.getTime() + 60 * 1000 * unLockDayCount).getTime()) / 60 / 1000;
        long nowTime = (new Date().getTime()) / 60 / 1000;
        String waitTime = String.valueOf(endTime - nowTime);
        return waitTime;
    }

    /**
     * 判断密码是否超过失效天数
     * @param lockUser
     * @return
     */
    public static boolean ifLosePassword(LockUser lockUser, JSONObject systemSecurityConfs) {
        int dayNum = Integer.parseInt(systemSecurityConfs.getString("lock_period"));
        Date currentDate = lockUser.getPwdLoginDate();
        boolean bo  = false;
        Date now = new Date();
        Date endDate = new Date(currentDate.getTime() + 60 * 1000 * dayNum * 60 *24);
        if (now.getTime() >= endDate.getTime()){
            bo =  true;
        }
        return bo;

    }
}
