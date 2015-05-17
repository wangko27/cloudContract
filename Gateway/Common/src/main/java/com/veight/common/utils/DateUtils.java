/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.common.utils;

import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 *
 * @author youyou
 */
public class DateUtils {

    /**
     * 默认日期格式
     */
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式
     */
    private String dateFormat = DEFAULT_DATE_FORMAT;

    /**
     * 获取日期
     *
     * @return 日期
     */
    public static String format(Date date) {
        return DateFormatUtils.format(date, DEFAULT_DATE_FORMAT);
    }

}
