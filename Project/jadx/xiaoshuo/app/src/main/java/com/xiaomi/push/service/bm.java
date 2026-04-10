package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.xiaomi.ad.mediation.DspNameConstant;
import miuix.core.util.PackageHelper;

/* JADX INFO: loaded from: classes8.dex */
public class bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static bm f8253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f992a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f993a;

    private bm(Context context) {
        this.f993a = context.getApplicationContext();
    }

    public static bm a(Context context) {
        if (f8253a == null) {
            f8253a = new bm(context);
        }
        return f8253a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m772a() {
        String str = com.xiaomi.push.z.f1070a;
        return str.contains("xmsf") || str.contains(DspNameConstant.DSP_XIAOMI) || str.contains(PackageHelper.MIUI_SYSTEM_APK_NAME);
    }

    @SuppressLint({"NewApi"})
    public int a() {
        int i = this.f992a;
        if (i != 0) {
            return i;
        }
        try {
            this.f992a = Settings.Global.getInt(this.f993a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f992a;
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Uri m771a() {
        return Settings.Global.getUriFor("device_provisioned");
    }
}
