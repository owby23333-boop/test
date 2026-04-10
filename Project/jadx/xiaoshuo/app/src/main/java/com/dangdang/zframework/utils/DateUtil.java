package com.dangdang.zframework.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes10.dex */
public class DateUtil {
    public static final String DATE_FORMAT_TYPE_1 = "yyyy.MM.dd HH:mm:ss.S";
    public static final String DATE_FORMAT_TYPE_2 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_TYPE_3 = "yyyy-MM-dd";
    public static final String DATE_FORMAT_TYPE_4 = "yyyy";
    public static final String DATE_FORMAT_TYPE_5 = "MM-dd";
    public static final String DATE_FORMAT_TYPE_6 = "HH:mm:ss";
    public static final String DATE_FORMAT_TYPE_7 = "HH:mm";
    public static final String DATE_FORMAT_TYPE_8 = "yyyy年MM月dd日";
    public static final String DATE_FORMAT_TYPE_9 = "MM月dd日";

    public static String dateFormat(long j, String str) {
        try {
            return new SimpleDateFormat(str).format(new Date(j));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static long getTimeMillis(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String dateFormat(long j, String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str2));
            return simpleDateFormat.format(new Date(j));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
