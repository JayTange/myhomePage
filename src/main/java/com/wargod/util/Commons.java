package com.wargod.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 页面工具类
 *
 * @author tangj
 */
@Component
public class Commons {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 格式化Date为日期
     *
     * @param date
     * @return
     */
    public static String fmtdate(Date date) {
        String dateString = dateFormat.format(date);
        return dateString;
    }

    /**
     * 返回时间戳
     *
     * @param date
     * @return
     */
    public static long fmtdateLong(Date date) {
        return date.getTime();
    }

}
