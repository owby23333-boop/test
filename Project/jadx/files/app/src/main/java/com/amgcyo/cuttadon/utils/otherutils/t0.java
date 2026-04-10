package com.amgcyo.cuttadon.utils.otherutils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: TimeUtils.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"SimpleDateFormat"})
public class t0 {
    public static String a(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
            return simpleDateFormat.format(simpleDateFormat.parse(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static long b(long j2) {
        long jCurrentTimeMillis = (System.currentTimeMillis() - j2) / 1000;
        String str = jCurrentTimeMillis + " isOverTime上次观看时间戳：" + d(j2);
        return jCurrentTimeMillis / 60;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String c() {
        return new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(Long.valueOf(System.currentTimeMillis()));
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String d(long j2) {
        return j2 <= 0 ? "" : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Long.valueOf(j2));
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String e(long j2) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(Long.valueOf(j2));
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String c(long j2) {
        return j2 <= 0 ? "" : new SimpleDateFormat("yy-MM-dd HH:mm", Locale.getDefault()).format(Long.valueOf(j2));
    }

    public static boolean b(long j2, int i2) {
        long jCurrentTimeMillis = (System.currentTimeMillis() - j2) / 1000;
        String str = jCurrentTimeMillis + " isOverSecond上次观看时间戳：" + d(j2);
        return jCurrentTimeMillis >= ((long) i2);
    }

    public static boolean a(long j2, int i2) {
        String str = "isOverMinute上次观看时间戳：" + j2 + " " + d(j2);
        long jCurrentTimeMillis = (System.currentTimeMillis() - j2) / 1000;
        String str2 = "betweenSecond：" + jCurrentTimeMillis;
        long j3 = jCurrentTimeMillis / 60;
        String str3 = "minute：" + j3;
        return j3 >= ((long) i2);
    }

    public static long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        long minutes = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - a(str));
        String str2 = minutes + " isOverMinute 上次请求配置时间：" + str;
        return minutes;
    }

    public static String a(int i2) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(10, -i2);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static long b() {
        try {
            Date date = new Date();
            TimeZone timeZone = TimeZone.getTimeZone(TimeZone.getDefault().getID());
            return (r2.getRawOffset() + (TimeZone.getTimeZone("Asia/Shanghai").inDaylightTime(date) ? r2.getDSTSavings() : 0)) - (timeZone.getRawOffset() + (timeZone.inDaylightTime(date) ? timeZone.getDSTSavings() : 0));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static boolean a(long j2) {
        long jLongValue = (((Long.valueOf(System.currentTimeMillis()).longValue() / 86400000) * 86400000) - ((long) TimeZone.getDefault().getRawOffset())) / 1000;
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 23, 59, 59);
        long time = calendar.getTime().getTime() / 1000;
        String str = "今天23点59分59秒的时间戳: " + time;
        return j2 <= jLongValue || j2 >= time;
    }

    public static long a(String str) {
        long time = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
            if (date != null) {
                time = date.getTime();
            }
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        String str2 = "ts: " + time;
        return time;
    }

    public static String a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String a(Long l2) {
        int iLongValue = (int) ((((l2.longValue() / 1000) / 60) / 60) / 24);
        int iLongValue2 = (int) (l2.longValue() - ((long) ((((iLongValue * 1000) * 60) * 60) * 24)));
        int i2 = ((iLongValue2 / 1000) / 60) / 60;
        int i3 = iLongValue2 - (((i2 * 1000) * 60) * 60);
        int i4 = (i3 / 1000) / 60;
        int i5 = (i3 - ((i4 * 1000) * 60)) / 1000;
        String str = "";
        if (iLongValue != 0) {
            str = "" + iLongValue + "天";
        }
        if (i2 != 0) {
            str = str + i2 + "小时";
        }
        if (i4 != 0) {
            str = str + i4 + "分钟";
        }
        if (i5 == 0) {
            return str;
        }
        return str + i5 + "秒";
    }

    public static boolean a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String str2 = "isOverMinute上次请求配置时间：" + str;
        return TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - a(str)) >= ((long) i2);
    }
}
