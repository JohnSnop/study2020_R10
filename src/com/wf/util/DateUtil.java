package com.wf.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author wf
 * @create 2020-09-23 22:41
 * @desc
 **/
public class DateUtil {
    private DateUtil(){}

    /**
     * 根据传入的日期，获取一自然月后的时间
     * @param startDate
     * @return
     */
    public static Date packNatureMonthLater(Date startDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        // 31天的月份
        if (calendar.get(Calendar.DAY_OF_MONTH) == 31) {
            // 不是7月，不是12月
            if (!(calendar.get(Calendar.MONTH) == 6 || calendar.get(Calendar.MONTH) == 11)) {
                return countMonth(calendar, 1, 1);
            }
        }
        // 1月份，计算2月份止期
        if (calendar.get(Calendar.MONTH) == 0) {
            if (!isLeapYear(calendar) && calendar.get(Calendar.DAY_OF_MONTH) == 29) {
                return countMonth(calendar, 1, 1);
            }
            if (calendar.get(Calendar.DAY_OF_MONTH) == 30) {
                return countMonth(calendar, 1, 1);
            }
        }
        return countMonth(calendar, 1, 0);
    }

    private static boolean isLeapYear(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private static Date countMonth(Calendar calendar, int asignMonth, int asignDay) {
        calendar.add(Calendar.MONTH, asignMonth);
        calendar.add(Calendar.DATE, asignDay);
        return calendar.getTime();
    }
}
