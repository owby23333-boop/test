package com.alipay.sdk.m.f0;

import android.content.Context;
import android.os.Build;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f1816a = new e();

    public static e a() {
        return f1816a;
    }

    public String b() {
        return "android";
    }

    public boolean c() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i = 0; i < 5; i++) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public String d() {
        return Build.BOARD;
    }

    public String e() {
        return Build.BRAND;
    }

    public String f() {
        return Build.DEVICE;
    }

    public String g() {
        return Build.DISPLAY;
    }

    public String h() {
        return Build.VERSION.INCREMENTAL;
    }

    public String i() {
        return Build.MANUFACTURER;
    }

    public String j() {
        return Build.MODEL;
    }

    public String k() {
        return Build.PRODUCT;
    }

    public String l() {
        return Build.VERSION.RELEASE;
    }

    public String m() {
        return Build.VERSION.SDK;
    }

    public String n() {
        return Build.TAGS;
    }

    public String o() {
        return a("ro.kernel.qemu", "0");
    }

    public final String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public boolean a(Context context) {
        try {
            if (!Build.HARDWARE.contains("goldfish") && !Build.PRODUCT.contains("sdk")) {
                if (!Build.FINGERPRINT.contains("generic")) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
