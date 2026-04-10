package com.xiaomi.ad.common.util;

import com.dangdang.zframework.utils.DateUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public final class TimeUtils {
    public static int HALF_DAY_IN_MS = 0;
    public static int ONE_DAY_IN_MS = 0;
    public static int ONE_HOUR_IN_MS = 0;
    public static int ONE_MINUTE_IN_MS = 0;
    public static int ONE_SECOND_IN_MS = 1000;
    public static int ONE_WEEK_IN_MS;

    static {
        int i = ONE_SECOND_IN_MS * 60;
        ONE_MINUTE_IN_MS = i;
        int i2 = i * 60;
        ONE_HOUR_IN_MS = i2;
        HALF_DAY_IN_MS = i2 * 12;
        int i3 = i2 * 24;
        ONE_DAY_IN_MS = i3;
        ONE_WEEK_IN_MS = i3 * 7;
    }

    public static boolean expired(long j, long j2) {
        return Math.abs(System.currentTimeMillis() - j) > j2;
    }

    public static String getCurrentDateString() {
        return getDateString(System.currentTimeMillis());
    }

    public static String getDateString(long j) {
        try {
            return new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_2).format(new Date(j));
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean inToday(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        long timeInMillis = calendar.getTimeInMillis();
        return timeInMillis <= j && j < ((long) ONE_DAY_IN_MS) + timeInMillis;
    }
}
