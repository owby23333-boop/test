package com.anythink.expressad.foundation.h;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public final class k extends d {
    private static final String a = "SameDiTool";
    private static String b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f10655c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f10656d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f10657e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f10658f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f10659g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f10660h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f10661i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f10662j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f10663k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f10664l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static String f10665m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f10666n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static String f10667o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f10668p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f10669q = "";

    /* JADX INFO: renamed from: com.anythink.expressad.foundation.h.k$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"MissingPermission"})
        public final void run() {
            ConnectivityManager connectivityManager;
            try {
                if (com.anythink.core.common.b.n.a().c("network_type")) {
                    return;
                }
                try {
                    if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() || this.a == null || (connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity")) == null) {
                        return;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        int unused = k.f10658f = 0;
                        return;
                    }
                    if (activeNetworkInfo.getType() == 1) {
                        int unused2 = k.f10658f = 9;
                        return;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
                    if (telephonyManager == null) {
                        int unused3 = k.f10658f = 0;
                    } else {
                        int unused4 = k.f10658f = k.a(telephonyManager.getNetworkType());
                    }
                } catch (Exception unused5) {
                }
            } catch (Throwable th) {
                o.b(k.a, th.getMessage(), th);
                int unused6 = k.f10658f = 0;
            }
        }
    }

    private k() {
    }

    @SuppressLint({"MissingPermission"})
    public static int a() {
        Context contextG;
        try {
            contextG = com.anythink.core.common.b.n.a().g();
        } catch (Throwable th) {
            o.b(a, th.getMessage(), th);
            f10658f = 0;
            return 0;
        }
        if (com.anythink.core.common.b.n.a().c("network_type")) {
            return f10658f;
        }
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                return f10658f;
            }
            if (contextG == null) {
                return f10658f;
            }
            if (f10658f == -1) {
                f10658f = 0;
                return f10658f;
            }
            try {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(contextG);
                if (com.anythink.expressad.foundation.g.h.a.b().getActiveCount() <= 0) {
                    com.anythink.expressad.foundation.g.h.a.b().execute(anonymousClass2);
                }
            } catch (Throwable th2) {
                o.d(a, th2.getMessage());
            }
            return f10658f;
        } catch (Exception unused) {
            return f10658f;
        }
        o.b(a, th.getMessage(), th);
        f10658f = 0;
        return 0;
    }

    public static int a(int i2) {
        if (i2 == 20) {
            return 5;
        }
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    public static int c(Context context) {
        if (context == null) {
            return f10663k;
        }
        int i2 = f10663k;
        if (i2 != 0) {
            return i2;
        }
        try {
            int i3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            f10663k = i3;
            return i3;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String d(Context context) {
        if (context == null) {
            return f10662j;
        }
        try {
            if (!TextUtils.isEmpty(f10662j)) {
                return f10662j;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f10662j = str;
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int e(Context context) {
        if (com.anythink.core.common.b.n.a().c("screen")) {
            return 0;
        }
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() || context == null) {
                return 0;
            }
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                HashMap mapG = g(context);
                return mapG.get("width") == null ? displayMetrics.widthPixels : ((Integer) mapG.get("width")).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        } catch (Exception unused) {
        }
    }

    public static int f(Context context) {
        if (com.anythink.core.common.b.n.a().c("screen")) {
            return 0;
        }
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() || context == null) {
                return 0;
            }
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                HashMap mapG = g(context);
                return mapG.get("height") == null ? displayMetrics.heightPixels : ((Integer) mapG.get("height")).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        } catch (Exception unused) {
        }
    }

    public static HashMap g(Context context) {
        HashMap map = new HashMap();
        if (context == null) {
            return map;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            map.put("height", Integer.valueOf(displayMetrics.heightPixels));
            map.put("width", Integer.valueOf(displayMetrics.widthPixels));
        } catch (Exception e2) {
            o.b(a, e2.getMessage(), e2);
        }
        return map;
    }

    public static String h(Context context) {
        if (context == null) {
            return f10661i;
        }
        try {
            if (!TextUtils.isEmpty(f10661i)) {
                return f10661i;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            f10661i = str;
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int i() {
        return 0;
    }

    public static void i(final Context context) {
        if (context == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                d.a(context);
            } else {
                com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.expressad.foundation.h.k.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.a(context);
                    }
                });
            }
        } catch (Throwable th) {
            o.b(a, "", th);
        }
    }

    private static void j(Context context) {
        try {
            h(context);
            d(context);
            c(context);
            b(context);
            com.anythink.expressad.foundation.g.a.bX = t.a("android.permission.WRITE_EXTERNAL_STORAGE", context);
            com.anythink.expressad.foundation.g.a.bW = t.a("android.permission.ACCESS_NETWORK_STATE", context);
            k(context);
        } catch (Throwable unused) {
        }
    }

    private static int k(Context context) {
        if (context == null) {
            return f10668p;
        }
        if (f10668p == 0) {
            try {
                f10668p = context.getApplicationInfo().targetSdkVersion;
            } catch (Exception e2) {
                o.d(a, e2.getMessage());
            }
        }
        return f10668p;
    }

    private static void l(Context context) {
        try {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(context);
            if (com.anythink.expressad.foundation.g.h.a.b().getActiveCount() <= 0) {
                com.anythink.expressad.foundation.g.h.a.b().execute(anonymousClass2);
            }
        } catch (Throwable th) {
            o.d(a, th.getMessage());
        }
    }

    private static boolean m(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null) {
            return false;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
        } catch (Exception e2) {
            o.b(a, e2.getMessage(), e2);
        }
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 6.0d;
    }

    private static String n() {
        return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : Arrays.asList(Build.SUPPORTED_ABIS).toString();
    }

    private static String o() {
        return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : Build.CPU_ABI;
    }

    private static String p() {
        return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : Build.CPU_ABI2;
    }

    public static int b(Context context) {
        Configuration configuration;
        if (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null) {
            return 1;
        }
        int i2 = configuration.orientation;
        if (i2 == 2) {
            return 2;
        }
        if (i2 == 1) {
        }
        return 1;
    }

    public static String b() {
        if (com.anythink.core.common.b.n.a().c("model")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                return "";
            }
            return Build.MANUFACTURER + " " + Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    private static long l() {
        Context contextG = com.anythink.core.common.b.n.a().g();
        if (contextG == null) {
            return 0L;
        }
        ActivityManager activityManager = (ActivityManager) contextG.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        if (Build.VERSION.SDK_INT >= 16) {
            return memoryInfo.totalMem;
        }
        return 0L;
    }

    private static int k() {
        return f10666n;
    }

    public static String c() {
        if (com.anythink.core.common.b.n.a().c("os_vc")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                return "";
            }
            if (TextUtils.isEmpty(f10660h)) {
                f10660h = String.valueOf(d());
            }
            return f10660h;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e() {
        String strA = "";
        try {
            Context contextG = com.anythink.core.common.b.n.a().g();
            long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            long jL = l();
            String str = "app_tki_" + jCurrentTimeMillis + "_" + jL;
            String str2 = (String) v.b(contextG, str, "");
            try {
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("1", "");
                    jSONObject.put("2", String.valueOf(jL));
                    jSONObject.put("3", String.valueOf(jCurrentTimeMillis));
                    jSONObject.put("4", "");
                    jSONObject.put("5", "");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                strA = a.a(jSONObject.toString());
                v.a(contextG, str, strA);
                return strA;
            } catch (Exception e3) {
                e = e3;
                strA = str2;
                e.printStackTrace();
                return strA;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static int f() {
        if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
            return 0;
        }
        if (f10656d <= 0) {
            try {
                Context contextG = com.anythink.core.common.b.n.a().g();
                long jLongValue = ((Long) v.b(contextG, "TotalRamSize", 0L)).longValue();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - jLongValue > 1800000 || f10656d == -1) {
                    f10656d = Long.valueOf((l() / 1000) / 1000).intValue();
                    v.a(contextG, "TotalRamSize", Long.valueOf(jCurrentTimeMillis));
                }
            } catch (Throwable th) {
                o.b(a, th.getMessage(), th);
            }
        }
        return f10656d;
    }

    public static int d() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static String h() {
        if (TextUtils.isEmpty(f10669q)) {
            if (Build.VERSION.SDK_INT >= 21) {
                f10669q = com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? Arrays.asList(Build.SUPPORTED_ABIS).toString() : "";
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : Build.CPU_ABI);
                arrayList.add(com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? Build.CPU_ABI2 : "");
                f10669q = arrayList.toString();
            }
        }
        return f10669q;
    }

    private static UUID j() {
        try {
            return UUID.randomUUID();
        } catch (Throwable th) {
            o.b(a, th.getMessage(), th);
            return null;
        }
    }

    private static long m() {
        Context contextG = com.anythink.core.common.b.n.a().g();
        if (contextG == null) {
            return 0L;
        }
        ActivityManager activityManager = (ActivityManager) contextG.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static int g() {
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                return 0;
            }
            Context contextG = com.anythink.core.common.b.n.a().g();
            long j2 = 0;
            long jLongValue = ((Long) v.b(contextG, "FreeRamSize", 0L)).longValue();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - jLongValue > 1800000 || f10657e == -1) {
                Context contextG2 = com.anythink.core.common.b.n.a().g();
                if (contextG2 != null) {
                    ActivityManager activityManager = (ActivityManager) contextG2.getSystemService("activity");
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    j2 = memoryInfo.availMem;
                }
                f10657e = Long.valueOf((j2 / 1000) / 1000).intValue();
                v.a(contextG, "FreeRamSize", Long.valueOf(jCurrentTimeMillis));
            }
        } catch (Throwable th) {
            o.b(a, th.getMessage(), th);
        }
        return f10657e;
    }

    public static String a(Context context, int i2) {
        TelephonyManager telephonyManager;
        if (i2 == 0 || i2 == 9) {
            return "";
        }
        try {
            return (!com.anythink.expressad.foundation.g.a.bW || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : String.valueOf(telephonyManager.getNetworkType());
        } catch (Throwable th) {
            o.b(a, th.getMessage(), th);
            return "";
        }
    }

    private static void a(String str) {
        f10655c = j.a(str);
        b = str;
    }

    private static String a(String str, Context context) {
        try {
        } catch (Exception e2) {
            o.b(a, e2.getMessage(), e2);
        }
        if (!TextUtils.isEmpty(f10667o)) {
            return f10667o;
        }
        if (!TextUtils.isEmpty(str) && context != null) {
            f10667o = context.getPackageManager().getInstallerPackageName(str);
            o.a(a, "PKGSource:" + f10667o);
        }
        return f10667o;
    }
}
