package com.anythink.core.common.k;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.g;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static String a = null;
    public static String b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f7675c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f7676d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static String f7677e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f7678f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f7679g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f7680h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f7681i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f7682j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f7683k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f7684l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static String f7685m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f7686n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static String f7687o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static String f7688p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f7689q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static String f7690r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static String f7691s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static int f7692t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static int f7693u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static int f7694v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static int f7695w = -1;

    private d() {
    }

    private static int a(int i2) {
        if (i2 == 20) {
            return 16;
        }
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
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
                return 13;
            default:
                return -1;
        }
    }

    public static void a(Context context) {
        try {
            d();
            k(context);
            i(context);
            h(context);
            g(context);
            a();
            b();
            d(context);
            f();
            f(context);
            c();
            n(context);
            a = p.b(context, com.anythink.core.common.b.g.f6799o, g.o.f6913e, "");
            if (h.a("android.permission.READ_PHONE_STATE", context)) {
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (!h.b(simOperator) || simOperator.length() <= 3) {
                    return;
                }
                f7690r = simOperator.substring(0, 3);
                f7691s = simOperator.substring(3, simOperator.length());
            }
        } catch (Exception unused) {
        }
    }

    public static String b(Context context) {
        if (com.anythink.core.common.b.n.a().c("mcc")) {
            return "";
        }
        if (context == null) {
            com.anythink.core.common.b.n.a().g();
        }
        try {
            return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : f7690r;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(Context context) {
        if (com.anythink.core.common.b.n.a().c("mnc")) {
            return "";
        }
        if (context == null) {
            com.anythink.core.common.b.n.a().g();
        }
        try {
            return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : f7691s;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        if (com.anythink.core.common.b.n.a().c("android_id")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.b.n.a().g();
        }
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                return "";
            }
            try {
                if (f7680h == null) {
                    String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    f7680h = string;
                    if (string == null) {
                        f7680h = "";
                    }
                }
            } catch (Exception unused) {
                f7680h = "";
            }
            return f7680h;
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String e(Context context) {
        if (context == null) {
            return "";
        }
        f7677e = null;
        try {
            if (TextUtils.isEmpty(f7677e)) {
                String strD = d(context);
                f7677e = strD;
                f7677e = f.b(strD);
            }
        } catch (Throwable unused) {
        }
        return f7677e;
    }

    public static String f(Context context) {
        if (com.anythink.core.common.b.n.a().c("language")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.b.n.a().g();
        }
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                return "";
            }
            if (!TextUtils.isEmpty(f7687o)) {
                return f7687o;
            }
            String language = context.getResources().getConfiguration().locale.getLanguage();
            f7687o = language;
            return language;
        } catch (Exception unused) {
            return "";
        }
    }

    public static int g(Context context) {
        if (com.anythink.core.common.b.n.a().c("orient")) {
            return 0;
        }
        if (context == null) {
            context = com.anythink.core.common.b.n.a().g();
        }
        int i2 = context.getResources().getConfiguration().orientation;
        if (i2 == 2) {
            return 2;
        }
        if (i2 == 1) {
        }
        return 1;
    }

    public static String h(Context context) {
        if (com.anythink.core.common.b.n.a().c("app_vc")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.b.n.a().g();
        }
        if (f7686n != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(f7686n);
            return sb.toString();
        }
        try {
            f7686n = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f7686n);
            return sb2.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String i(Context context) {
        if (com.anythink.core.common.b.n.a().c("app_vn")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.b.n.a().g();
        }
        try {
            if (!TextUtils.isEmpty(f7685m)) {
                return f7685m;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f7685m = str;
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String j(Context context) {
        if (com.anythink.core.common.b.n.a().c("screen")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.b.n.a().g();
        }
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append((context == null ? com.anythink.core.common.b.n.a().g() : context).getResources().getDisplayMetrics().widthPixels);
            sb.append("*");
            if (context == null) {
                context = com.anythink.core.common.b.n.a().g();
            }
            sb.append(context.getResources().getDisplayMetrics().heightPixels);
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String k(Context context) {
        if (com.anythink.core.common.b.n.a().c("package_name")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.b.n.a().g();
        }
        try {
            if (!TextUtils.isEmpty(f7684l)) {
                return f7684l;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            f7684l = str;
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String l(Context context) {
        if (com.anythink.core.common.b.n.a().c("it_src")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.b.n.a().g();
        }
        try {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            String installerPackageName = context.getPackageManager().getInstallerPackageName(k(context));
            b = installerPackageName;
            return installerPackageName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m(Context context) {
        NetworkInfo activeNetworkInfo;
        if (com.anythink.core.common.b.n.a().c("network_type")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                return "";
            }
            if (context == null) {
                return GMNetworkPlatformConst.AD_NETWORK_NO_PRICE;
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || !h.a("android.permission.ACCESS_NETWORK_STATE", context) || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    return GMNetworkPlatformConst.AD_NETWORK_NO_PRICE;
                }
                int i2 = 1;
                if (activeNetworkInfo.getType() == 1) {
                    return "-2";
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return GMNetworkPlatformConst.AD_NETWORK_NO_PRICE;
                }
                int networkType = telephonyManager.getNetworkType();
                StringBuilder sb = new StringBuilder();
                if (networkType != 20) {
                    switch (networkType) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            i2 = 3;
                            break;
                        case 13:
                            i2 = 13;
                            break;
                        default:
                            i2 = -1;
                            break;
                    }
                } else {
                    i2 = 16;
                }
                sb.append(i2);
                return sb.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                return GMNetworkPlatformConst.AD_NETWORK_NO_PRICE;
            }
        } catch (Exception unused) {
            return "";
        }
    }

    private static int n() {
        return Build.VERSION.SDK_INT;
    }

    public static String o(Context context) {
        if (com.anythink.core.common.b.n.a().b() == null) {
            return "";
        }
        if (TextUtils.isEmpty(f7675c)) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            f7675c = String.valueOf(displayMetrics.density);
        }
        return f7675c;
    }

    public static void p(Context context) {
        if (com.anythink.core.common.b.n.a().c("ua")) {
            return;
        }
        try {
            if (com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                f7681i = p.b(context, com.anythink.core.common.b.g.f6799o, com.anythink.core.common.b.g.f6789e, "");
                String strB = p.b(context, com.anythink.core.common.b.g.f6799o, com.anythink.core.common.b.g.f6790f, "");
                if (TextUtils.isEmpty(f7681i) || !Build.VERSION.RELEASE.equals(strB)) {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        if (TextUtils.isEmpty(f7681i)) {
                        }
                        return;
                    }
                    try {
                        if (Build.VERSION.SDK_INT >= 17) {
                            f7681i = WebSettings.getDefaultUserAgent(context);
                        } else {
                            WebView webView = new WebView(context);
                            g.a(webView);
                            f7681i = webView.getSettings().getUserAgentString();
                        }
                        p.a(context, com.anythink.core.common.b.g.f6799o, com.anythink.core.common.b.g.f6789e, f7681i);
                        p.a(context, com.anythink.core.common.b.g.f6799o, com.anythink.core.common.b.g.f6790f, Build.VERSION.RELEASE);
                    } catch (Throwable unused) {
                    }
                    if (TextUtils.isEmpty(f7681i)) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static synchronized void q(Context context) {
        if (TextUtils.isEmpty(com.anythink.core.common.b.n.a().x())) {
            IExHandler iExHandlerB = com.anythink.core.common.b.n.a().b();
            String uniqueId = iExHandlerB != null ? iExHandlerB.getUniqueId(context) : "";
            if (TextUtils.isEmpty(uniqueId)) {
                uniqueId = r(context);
            }
            if (TextUtils.isEmpty(uniqueId) || Pattern.matches("^[0-]+$", uniqueId)) {
                uniqueId = d(context);
            }
            if (TextUtils.isEmpty(uniqueId)) {
                uniqueId = UUID.randomUUID().toString();
            }
            com.anythink.core.common.b.n.a().k(f.a(uniqueId));
            com.anythink.core.common.j.c.a("", "3", "", String.valueOf(System.currentTimeMillis()));
        }
    }

    public static synchronized String r(final Context context) {
        if (com.anythink.core.common.b.n.a().c("gaid")) {
            return "";
        }
        final ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
        final String[] strArr = new String[1];
        executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: com.anythink.core.common.k.d.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    try {
                        Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                        Class<?> cls2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                        strArr[0] = (String) cls2.getMethod("getId", new Class[0]).invoke(cls.getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context), new Object[0]);
                    } catch (Throwable unused) {
                        strArr[0] = new com.anythink.core.common.b.c().a(context).a();
                    }
                } catch (Exception unused2) {
                }
                if (!TextUtils.isEmpty(strArr[0]) && !d.d(strArr[0])) {
                    d.a(strArr[0]);
                }
                try {
                    synchronized (executorServiceNewFixedThreadPool) {
                        executorServiceNewFixedThreadPool.notifyAll();
                    }
                } catch (Throwable unused3) {
                }
            }
        });
        try {
            synchronized (executorServiceNewFixedThreadPool) {
                executorServiceNewFixedThreadPool.wait(com.anythink.expressad.exoplayer.i.a.f9492f);
            }
            executorServiceNewFixedThreadPool.shutdown();
            if (strArr[0] == null) {
                return "";
            }
            return strArr[0];
        } catch (Exception unused) {
            return "";
        }
    }

    public static int s(Context context) {
        if (f7692t == -1) {
            f7692t = h.a(context, "com.tencent.mm") ? 1 : 0;
        }
        return f7692t;
    }

    private static int t(Context context) {
        if (context == null) {
            context = com.anythink.core.common.b.n.a().g();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static int u(Context context) {
        if (context == null) {
            context = com.anythink.core.common.b.n.a().g();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    private static int v(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return -1;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || !h.a("android.permission.ACCESS_NETWORK_STATE", context) || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return -1;
            }
            if (activeNetworkInfo.getType() == 1) {
                return -2;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            return telephonyManager.getNetworkType();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private static void w(Context context) {
        a = p.b(context, com.anythink.core.common.b.g.f6799o, g.o.f6913e, "");
    }

    public static String n(Context context) {
        String str = f7689q;
        if (str != null) {
            if (str == null) {
                f7689q = "";
            }
            return f7689q;
        }
        try {
            String str2 = context.getPackageManager().getPackageInfo("com.android.vending", 0).versionName;
            f7689q = str2;
            if (str2 == null) {
                f7689q = "";
            }
            return f7689q;
        } catch (Exception unused) {
            f7689q = "";
            return "";
        }
    }

    public static String b() {
        if (com.anythink.core.common.b.n.a().c("brand")) {
            return "";
        }
        try {
            return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : Build.BRAND;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c() {
        if (com.anythink.core.common.b.n.a().c("timezone")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                return "";
            }
            try {
                if (TextUtils.isEmpty(f7688p)) {
                    String displayName = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
                    f7688p = displayName;
                    return displayName;
                }
            } catch (Throwable unused) {
            }
            return f7688p;
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String g() {
        if (com.anythink.core.common.b.n.a().b() == null) {
            return "";
        }
        try {
            double dCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            Double.isNaN(dCurrentTimeMillis);
            return new BigDecimal(dCurrentTimeMillis / 1000.0d).setScale(6, 4).toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String e() {
        if (com.anythink.core.common.b.n.a().c("os_vn")) {
            return "";
        }
        if (TextUtils.isEmpty(f7682j)) {
            f7682j = Build.VERSION.RELEASE;
        }
        return f7682j;
    }

    public static String l() {
        Object obj;
        String strD = com.anythink.core.common.b.n.a().d();
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        try {
            Map<String, Object> mapM = com.anythink.core.common.b.n.a().m();
            if (mapM == null || (obj = mapM.get(ATAdConst.KEY.WECHAT_APPID)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static int b(String str) {
        int i2 = f7695w;
        if (i2 != -1) {
            return i2;
        }
        f7695w = 0;
        try {
            f7695w = ((Integer) Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("getWXAppSupportAPI", new Class[0]).invoke(c(str), new Object[0])).intValue();
        } catch (Throwable unused) {
        }
        return f7695w;
    }

    public static String f() {
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                return "";
            }
            if (TextUtils.isEmpty(f7679g)) {
                f7679g = p.b(com.anythink.core.common.b.n.a().g(), com.anythink.core.common.b.g.f6799o, com.anythink.core.common.b.g.f6802r, "");
            }
            return f7679g;
        } catch (Exception unused) {
            return "";
        }
    }

    public static JSONObject h() {
        if (!TextUtils.isEmpty(a)) {
            try {
                return new JSONObject(a);
            } catch (Exception unused) {
            }
        }
        return new JSONObject();
    }

    public static synchronized String i() {
        if (com.anythink.core.common.b.n.a().c("ua")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                return "";
            }
            if (!TextUtils.isEmpty(f7681i)) {
                return f7681i;
            }
            String str = Build.VERSION.RELEASE;
            String strA = a();
            String str2 = Build.ID;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(strA) || TextUtils.isEmpty(str2)) {
                return "";
            }
            return "Mozilla/5.0 (Linux; Android " + str + "; " + strA + " Build/" + str2 + ") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
        } catch (Exception unused) {
            return "";
        }
    }

    public static int k() {
        if (f7693u == -1) {
            if (TextUtils.isEmpty(l())) {
                f7693u = 0;
            } else {
                try {
                    Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
                    Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram");
                    f7693u = 1;
                } catch (Throwable unused) {
                    f7693u = 0;
                }
            }
        }
        return f7693u;
    }

    public static String d() {
        if (com.anythink.core.common.b.n.a().c("os_vc")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b()) {
                return "";
            }
            if (TextUtils.isEmpty(f7683k)) {
                f7683k = String.valueOf(Build.VERSION.SDK_INT);
            }
            return f7683k;
        } catch (Exception unused) {
            return "";
        }
    }

    private static boolean e(String str) {
        return Pattern.matches("^[0-]+$", str);
    }

    public static int m() {
        int i2 = f7694v;
        if (i2 != -1) {
            return i2;
        }
        f7694v = 0;
        try {
            f7694v = ((Integer) Class.forName("com.tencent.mm.opensdk.constants.Build").getField("SDK_INT").get(null)).intValue();
        } catch (Throwable unused) {
        }
        return f7694v;
    }

    public static Object c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getMethod("createWXAPI", Context.class, String.class).invoke(null, com.anythink.core.common.b.n.a().g(), str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String j() {
        if (!TextUtils.isEmpty(f7676d)) {
            return f7676d;
        }
        String strG = com.anythink.core.common.b.n.a().G();
        if (!TextUtils.isEmpty(strG)) {
            f7676d = strG;
            return strG;
        }
        String strG2 = com.anythink.core.common.b.n.a().G();
        if (TextUtils.isEmpty(strG2)) {
            try {
                Class.forName("com.unity3d.player.UnityPlayer");
                strG2 = "2";
            } catch (Throwable unused) {
                strG2 = "1";
            }
            try {
                Class.forName("org.cocos2dx.lib.Cocos2dxActivity");
                Class.forName("org.cocos2dx.lib.Cocos2dxJavascriptJavaBridge");
                strG2 = "4";
            } catch (Throwable unused2) {
            }
        }
        f7676d = strG2;
        return strG2;
    }

    static /* synthetic */ boolean d(String str) {
        return Pattern.matches("^[0-]+$", str);
    }

    public static String a() {
        if (com.anythink.core.common.b.n.a().c("model")) {
            return "";
        }
        try {
            return !com.anythink.core.common.b.p.a(com.anythink.core.common.b.n.a().g()).b() ? "" : Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(String str) {
        f7679g = str;
        p.a(com.anythink.core.common.b.n.a().g(), com.anythink.core.common.b.g.f6799o, com.anythink.core.common.b.g.f6802r, f7679g);
    }

    public static synchronized void a(int i2, String str) {
        if (!TextUtils.isEmpty(a)) {
            try {
                JSONObject jSONObject = new JSONObject(a);
                if (jSONObject.has(String.valueOf(i2))) {
                    return;
                }
                jSONObject.put(String.valueOf(i2), str);
                a = jSONObject.toString();
                return;
            } catch (Exception unused) {
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(String.valueOf(i2), str);
            a = jSONObject2.toString();
        } catch (Exception unused2) {
        }
    }
}
