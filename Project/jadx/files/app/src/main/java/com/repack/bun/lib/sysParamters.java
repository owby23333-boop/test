package com.repack.bun.lib;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import v.b;

/* JADX INFO: loaded from: classes3.dex */
public class sysParamters {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile sysParamters f17841d;
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f17842c;

    @Keep
    private String sdk_version = "10012";

    @Keep
    private sysParamters() {
    }

    public static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static sysParamters b() {
        if (f17841d == null) {
            synchronized (sysParamters.class) {
                if (f17841d == null) {
                    f17841d = new sysParamters();
                }
            }
        }
        return f17841d;
    }

    public static String c() {
        ApplicationInfo applicationInfo = b.a().getApplicationInfo();
        return (applicationInfo == null || TextUtils.isEmpty(applicationInfo.packageName)) ? b.a().getPackageName() : applicationInfo.packageName;
    }

    public String a() {
        return this.sdk_version;
    }
}
