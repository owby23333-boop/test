package com.baidu.tts.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class DateTool {
    public static String format(long j2, String str) {
        return format(new Date(j2), str);
    }

    public static String formatCurrentDate(String str) {
        return format(new Date(), str);
    }

    public static String formatInChinaDate(long j2) {
        return format(j2, "yyyy年M月d日");
    }

    public static String formatInHHmm(long j2) {
        return format(j2, "HH:mm");
    }

    public static String formatInyyyyMMdd(long j2) {
        return format(j2, "yyyy.MM.dd");
    }

    public static Calendar getCalendar(String str, String str2) {
        try {
            Date date = new SimpleDateFormat(str2, Locale.CHINA).parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Date getDate(String str, String str2) {
        try {
            return new SimpleDateFormat(str2, Locale.CHINA).parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String[] getDateRange(String str, String str2, int i2) {
        Calendar calendar = getCalendar(str, str2);
        Date time = calendar.getTime();
        String[] strArr = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            calendar.add(5, -((i2 - i3) - 1));
            calendar.getTime();
            strArr[i3] = String.valueOf(calendar.get(5));
            calendar.setTime(time);
        }
        return strArr;
    }

    public static String simpleFormatCurrentDate() {
        return formatCurrentDate("yyyy年M月d日 HH:mm:ss:SSS");
    }

    public static String format(Date date, String str) {
        return new SimpleDateFormat(str, Locale.CHINA).format(date);
    }

    public static String format(Calendar calendar, String str) {
        try {
            return format(calendar.getTime(), str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String format(String str, String str2, String str3) {
        try {
            return format(new SimpleDateFormat(str2, Locale.CHINA).parse(str), str3);
        } catch (Exception unused) {
            return null;
        }
    }
}
