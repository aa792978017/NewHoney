package com.honeypot.honeypot.util;

import com.honeypot.honeypot.entity.AlarmInfo;

public class AlarmInfoUtil {
    public static String typeMap(AlarmInfo alarmInfo){
        String typeReturn = ""+alarmInfo.getId()+"/";
        switch (alarmInfo.getType()){
            case 1:
                typeReturn += "启动自释放文件";
                break;
            case 2:
                typeReturn += "注册系统服务动态库";
                break;
            case 3:
                typeReturn += "添加系统防火墙";
                break;
            case 4:
                typeReturn += "禁止服务";
                break;
            case 5:
                typeReturn += "降低系统安全性";
                break;
            case 6:
                typeReturn += "修改注册表启动项";
                break;
            case 7:
                typeReturn += "释放PE文件";
                break;
            case 8:
                typeReturn += "";
                break;
            case 9:
                typeReturn += "入侵进程";
                break;
            case 10:
                typeReturn += "";
                break;
            case 12:
                typeReturn += "利用互斥量";
                break;
            case 11:
                typeReturn += "自我删除";
                break;
            case 13:
                typeReturn += "伪装系统服务";
                break;
        }
        return typeReturn;
    }
}
