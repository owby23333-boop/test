package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;

/* JADX INFO: loaded from: classes3.dex */
public class l {
    private static String a = null;
    private static String b = "GA";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f19266c = "GE";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f19267d = "9422";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f19268e = "0";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f19269f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f19270g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f19271h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f19272i = false;

    public static String a(Context context) {
        return a(context, "0");
    }

    public static String a(Context context, String str) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        a = a(context, String.valueOf(WebView.getTbsSDKVersion(context)), str, b, f19266c, f19267d, f19268e, f19269f, f19270g);
        return a;
    }

    private static String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z2) {
        String str8;
        StringBuilder sb = new StringBuilder();
        String str9 = b(context) + "*" + c(context);
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
            str8 = applicationInfo.packageName;
            try {
                if (TextUtils.isEmpty(str7)) {
                    str7 = packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                e = e2;
                e.printStackTrace();
                str7 = "";
            }
        } catch (PackageManager.NameNotFoundException e3) {
            e = e3;
            str8 = "";
        }
        String strA = a(str8);
        String str10 = "PAD";
        if (!"QB".equals(strA) ? !d(context) : !z2) {
            str10 = "PHONE";
        }
        sb.append("QV");
        sb.append("=");
        sb.append("3");
        a(sb, "PL", "ADR");
        a(sb, "PR", strA);
        a(sb, "PP", str8);
        a(sb, "PPVN", str7);
        if (!TextUtils.isEmpty(str)) {
            a(sb, "TBSVC", str);
        }
        a(sb, "CO", "SYS");
        if (!TextUtils.isEmpty(str2) && !str2.equals("0")) {
            a(sb, "CO", "BK");
        }
        if (!TextUtils.isEmpty(str2)) {
            a(sb, "COVC", str2);
        }
        a(sb, "PB", str4);
        a(sb, "VE", str3);
        a(sb, "DE", str10);
        if (TextUtils.isEmpty(str6)) {
            str6 = "0";
        }
        a(sb, "CHID", str6);
        a(sb, "LCID", str5);
        a(sb, "MO", "unknown");
        a(sb, "RL", str9);
        String str11 = Build.VERSION.RELEASE;
        try {
            str11 = new String(str11.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(str11)) {
            a(sb, "OS", str11);
        }
        a(sb, "API", Build.VERSION.SDK_INT + "");
        return sb.toString();
    }

    private static String a(String str) {
        return "com.tencent.mm".equals(str) ? "WX" : TbsConfig.APP_QQ.equals(str) ? "QQ" : TbsConfig.APP_QZONE.equals(str) ? "QZ" : TbsConfig.APP_QB.equals(str) ? "QB" : "TRD";
    }

    private static void a(StringBuilder sb, String str, String str2) {
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(str);
        sb.append("=");
        sb.append(str2);
    }

    private static int b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getWidth();
        }
        return -1;
    }

    private static int c(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getHeight();
        }
        return -1;
    }

    private static boolean d(Context context) {
        if (f19271h) {
            return f19272i;
        }
        try {
            f19272i = (Math.min(b(context), c(context)) * 160) / e(context) >= 700;
            f19271h = true;
            return f19272i;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static int e(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay == null) {
            return 160;
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }
}
