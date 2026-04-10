package com.yuewen;

import android.os.SystemClock;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes12.dex */
public class c04 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9488a = 86400000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f9489b = 3600000;
    public static final int c = 60000;
    public static long d;
    public static long e;
    public static long f;
    public static long g;

    public static long a() {
        long j = f;
        if (j <= 0) {
            qt1.t("TimeUtil", "客户端时间未与服务端同步");
            return System.currentTimeMillis();
        }
        long jElapsedRealtime = (j + SystemClock.elapsedRealtime()) - g;
        qt1.a("TimeUtil", "客户端与服务器时间差值为" + (System.currentTimeMillis() - jElapsedRealtime));
        return jElapsedRealtime;
    }

    public static void b(long j) {
        qt1.a("TimeUtil", "updateServerTime serverTime = " + j);
        g = SystemClock.elapsedRealtime();
        f = j;
    }

    public static String c(long j) {
        if (j > TimeUnit.SECONDS.toMillis(10L)) {
            return "10+";
        }
        int i = (int) (j / 1000);
        if (((int) (j - ((long) (i * 1000)))) > 500) {
            return i + ".5-" + (i + 1);
        }
        return i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i + ".5";
    }

    public static String d(long j, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
    }

    public static long e() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static long f() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        calendar.add(11, -1);
        return calendar.getTimeInMillis();
    }

    public static void g(String str) {
    }

    public static boolean h() {
        return false;
    }

    public static boolean i(long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            if (j < date.getTime()) {
                return j > date.getTime() - 86400000;
            }
            return false;
        } catch (ParseException e2) {
            qt1.p(e2);
            return false;
        }
    }

    public static boolean j() {
        return f != 0;
    }

    public static boolean k(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar2.setTime(new Date(j2));
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static boolean l(long j, long j2) {
        if (j2 >= 0) {
            return a() - j < j2;
        }
        throw new IllegalArgumentException("timeInternal is " + j2);
    }

    public static boolean m(long j) {
        return q(j) == p();
    }

    public static boolean n(Calendar calendar) {
        return m(calendar.getTimeInMillis());
    }

    public static boolean o(long j) {
        long jF = f();
        return j >= jF && j < jF + 86400000;
    }

    public static int p() {
        return q(System.currentTimeMillis());
    }

    public static int q(long j) {
        return (int) ((j + ((long) TimeZone.getDefault().getRawOffset())) / 86400000);
    }

    public static int r(long j) {
        return (int) ((j + ((long) TimeZone.getDefault().getRawOffset())) % 86400000);
    }

    public static void s(String str) {
    }

    public static void t(long j) {
        if (f > 0) {
            return;
        }
        synchronized (c04.class) {
            if (f > 0) {
                return;
            }
            b(j);
        }
    }
}
