package com.wf.demo.jdk8;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wf
 * @create 2020-10-23 14:07
 * @desc
 **/
public class DateFormatThreadLocal {
    private static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() ->
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static Date convert(String source) throws ParseException {
        return df.get().parse(source);
    }
}
