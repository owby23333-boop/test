package com.sntech.net.constant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import okhttp3.MediaType;

/* JADX INFO: renamed from: com.sntech.net.constant.do, reason: invalid class name */
/* JADX INFO: compiled from: NetConstant.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cdo {

    /* JADX INFO: renamed from: case, reason: not valid java name */
    public static final MediaType f83case = MediaType.parse("application/json; charset=utf-8");

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static Context f84do;

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public static String f85for;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static String f86if;

    /* JADX INFO: renamed from: new, reason: not valid java name */
    public static String f87new;

    /* JADX INFO: renamed from: try, reason: not valid java name */
    public static String f88try;

    @SuppressLint({"HardwareIds"})
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static String m97do() {
        if (f88try == null) {
            f88try = Settings.Secure.getString(f84do.getContentResolver(), "android_id");
        }
        if (f88try == null) {
            f88try = "";
        }
        return f88try;
    }
}
