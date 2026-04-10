package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: loaded from: classes8.dex */
public class dx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f7899a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f257a = true;

    private static int a(boolean z) {
        return z ? 1 : 0;
    }

    public static void b(Context context, long j, boolean z) {
        ag.a(context).a(new dz(context, j, z));
    }

    public static void c(Context context, long j, boolean z) {
        ag.a(context).a(new ea(context, j, z));
    }

    public static void d(Context context, long j, boolean z) {
        ag.a(context).a(new eb(context, j, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void i(Context context, long j, boolean z) {
        int i;
        du.a("recordSendMsg start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM314a = m314a(context);
        long j2 = sharedPreferencesM314a.getLong("start_time", 0L);
        if (j2 <= 0) {
            a(context, sharedPreferencesM314a, j, iA);
        }
        if (iA == 1) {
            i = sharedPreferencesM314a.getInt("on_up_count", 0) + 1;
            sharedPreferencesM314a.edit().putInt("on_up_count", i).apply();
        } else {
            i = sharedPreferencesM314a.getInt("off_up_count", 0) + 1;
            sharedPreferencesM314a.edit().putInt("off_up_count", i).apply();
        }
        a(context, j2, j, i, iA);
        du.a("recordSendMsg complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void j(Context context, long j, boolean z) {
        int i;
        du.a("recordReceiveMsg start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM314a = m314a(context);
        long j2 = sharedPreferencesM314a.getLong("start_time", 0L);
        if (j2 <= 0) {
            a(context, sharedPreferencesM314a, j, iA);
        }
        if (iA == 1) {
            i = sharedPreferencesM314a.getInt("on_down_count", 0) + 1;
            sharedPreferencesM314a.edit().putInt("on_down_count", i).apply();
        } else {
            i = sharedPreferencesM314a.getInt("off_down_count", 0) + 1;
            sharedPreferencesM314a.edit().putInt("off_down_count", i).apply();
        }
        a(context, j2, j, i, iA);
        du.a("recordReceiveMsg complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void k(Context context, long j, boolean z) {
        int i;
        du.a("recordPing start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM314a = m314a(context);
        long j2 = sharedPreferencesM314a.getLong("start_time", 0L);
        if (j2 <= 0) {
            a(context, sharedPreferencesM314a, j, iA);
        }
        if (iA == 1) {
            i = sharedPreferencesM314a.getInt("on_ping_count", 0) + 1;
            sharedPreferencesM314a.edit().putInt("on_ping_count", i).apply();
        } else {
            i = sharedPreferencesM314a.getInt("off_ping_count", 0) + 1;
            sharedPreferencesM314a.edit().putInt("off_ping_count", i).apply();
        }
        a(context, j2, j, i, iA);
        du.a("recordPing complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void l(Context context, long j, boolean z) {
        int i;
        du.a("recordPong start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM314a = m314a(context);
        long j2 = sharedPreferencesM314a.getLong("start_time", 0L);
        if (j2 <= 0) {
            a(context, sharedPreferencesM314a, j, iA);
        }
        if (iA == 1) {
            i = sharedPreferencesM314a.getInt("on_pong_count", 0) + 1;
            sharedPreferencesM314a.edit().putInt("on_pong_count", i).apply();
        } else {
            i = sharedPreferencesM314a.getInt("off_pong_count", 0) + 1;
            sharedPreferencesM314a.edit().putInt("off_pong_count", i).apply();
        }
        a(context, j2, j, i, iA);
        du.a("recordPong complete");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static SharedPreferences m314a(Context context) {
        return context.getSharedPreferences("sp_power_stats", 0);
    }

    private static void b(Context context, long j, int i) {
        du.a("reset");
        m314a(context).edit().clear().putLong("start_time", j).putInt("current_screen_state", i).putLong("current_screen_state_start_time", j).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    public static void a(Context context, long j, boolean z) {
        ag.a(context).a(new dy(context, j, z));
    }

    private static void a(Context context, SharedPreferences sharedPreferences, long j, int i) {
        du.a("recordInit");
        sharedPreferences.edit().putLong("start_time", j).putInt("current_screen_state", i).putLong("current_screen_state_start_time", j).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    private static void a(Context context, long j, long j2, int i, int i2) {
        if (j > 0) {
            if (m316a(context) || i >= 1073741823 || j2 - j >= 86400000) {
                m314a(context).edit().putLong("end_time", j2).apply();
                a(context, j2, i2);
            }
        }
    }

    private static void a(Context context, long j, int i) {
        du.a("upload");
        new dw().a(context, m315a(context));
        b(context, j, i);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static dv m315a(Context context) {
        SharedPreferences sharedPreferencesM314a = m314a(context);
        dv dvVar = new dv();
        dvVar.a(sharedPreferencesM314a.getInt("off_up_count", 0));
        dvVar.b(sharedPreferencesM314a.getInt("off_down_count", 0));
        dvVar.c(sharedPreferencesM314a.getInt("off_ping_count", 0));
        dvVar.d(sharedPreferencesM314a.getInt("off_pong_count", 0));
        dvVar.a(sharedPreferencesM314a.getLong("off_duration", 0L));
        dvVar.e(sharedPreferencesM314a.getInt("on_up_count", 0));
        dvVar.f(sharedPreferencesM314a.getInt("on_down_count", 0));
        dvVar.g(sharedPreferencesM314a.getInt("on_ping_count", 0));
        dvVar.h(sharedPreferencesM314a.getInt("on_pong_count", 0));
        dvVar.b(sharedPreferencesM314a.getLong("on_duration", 0L));
        dvVar.c(sharedPreferencesM314a.getLong("start_time", 0L));
        dvVar.d(sharedPreferencesM314a.getLong("end_time", 0L));
        dvVar.i(sharedPreferencesM314a.getInt("xmsf_vc", 0));
        dvVar.j(sharedPreferencesM314a.getInt("android_vc", 0));
        return dvVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m316a(Context context) {
        boolean z = false;
        if (f257a) {
            f257a = false;
            SharedPreferences sharedPreferencesM314a = m314a(context);
            int i = sharedPreferencesM314a.getInt("xmsf_vc", 0);
            int i2 = sharedPreferencesM314a.getInt("android_vc", 0);
            if (i != 0 && i2 != 0 && (i != a(context) || i2 != Build.VERSION.SDK_INT)) {
                z = true;
            }
        }
        du.a("isVcChanged = " + z);
        return z;
    }

    private static int a(Context context) {
        if (f7899a <= 0) {
            f7899a = j.b(context);
        }
        return f7899a;
    }
}
