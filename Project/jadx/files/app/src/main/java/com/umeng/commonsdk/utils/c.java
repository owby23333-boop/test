package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: compiled from: SLModeUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static final String a = "um_slmode_sp";
    private static final String b = "lastReqTime";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f20206c = 48;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f20207d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f20208e = 720;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f20209f = "iss";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f20210g = "sinr";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f20211h = "clean";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f20212i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f20213j = 720;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Object f20214k = new Object();

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(appContext, f20209f, "");
            if (TextUtils.isEmpty(strImprintProperty) || !"1".equals(strImprintProperty)) {
                return;
            }
            synchronized (f20214k) {
                f20212i = true;
            }
            String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, f20210g, "");
            if (TextUtils.isEmpty(strImprintProperty)) {
                f20213j = 48;
                return;
            }
            try {
                f20213j = a(Integer.parseInt(strImprintProperty2));
            } catch (Throwable unused) {
                f20213j = 48;
            }
        }
    }

    private static int a(int i2) {
        if (i2 > f20208e) {
            return f20208e;
        }
        if (i2 < 1) {
            return 1;
        }
        return i2;
    }

    public static boolean a() {
        boolean z2;
        synchronized (f20214k) {
            z2 = f20212i;
        }
        return z2;
    }

    public static long b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(b, 0L);
        }
        return 0L;
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f20211h, true).commit();
        }
    }

    public static void d(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f20211h, false).commit();
        }
    }

    public static boolean e(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(f20211h, false);
        }
        return false;
    }

    public static int a(Context context) {
        int i2;
        synchronized (f20214k) {
            i2 = f20213j;
        }
        return i2;
    }

    public static boolean a(long j2, long j3, int i2) {
        Date date = new Date(j3);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        calendar.add(10, i2);
        return date.after(calendar.getTime());
    }

    public static void a(Context context, long j2) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(b, j2).commit();
        }
    }
}
