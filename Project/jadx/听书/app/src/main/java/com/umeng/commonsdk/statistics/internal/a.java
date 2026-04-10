package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.an;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: HeaderHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f2349a;
    private String b;
    private String c;

    private a() {
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HeaderHelper.java */
    private static class C0497a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f2350a = new a();

        private C0497a() {
        }
    }

    public static a a(Context context) {
        if (f2349a == null && context != null) {
            f2349a = context.getApplicationContext();
        }
        return C0497a.f2350a;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("a");
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(an.aI);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(an.aD);
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("h");
    }

    public void e(String str) {
        String strSubstring = str.substring(0, str.indexOf(95));
        g(strSubstring);
        f(strSubstring);
    }

    private void f(String str) {
        try {
            String strReplaceAll = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", "/");
            StringBuilder sb = new StringBuilder();
            sb.append(strReplaceAll).append("/Android/").append(Build.DISPLAY).append("/").append(Build.MODEL).append("/").append(Build.VERSION.RELEASE).append(" ").append(HelperUtils.getUmengMD5(UMUtils.getAppkey(f2349a)));
            this.b = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f2349a, th);
        }
    }

    private void g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] strArrSplit = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(an.aQ);
            for (String str3 : strArrSplit) {
                if (!TextUtils.isEmpty(str3)) {
                    String strSubstring = str3.substring(0, 2);
                    if (strSubstring.endsWith("=")) {
                        strSubstring = strSubstring.replace("=", "");
                    }
                    sb.append(strSubstring);
                }
            }
            this.c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f2349a, th);
        }
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.b;
    }
}
