package com.ss.android.socialbase.downloader.g;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f2084a = 512000;
    public static volatile String dl = "";
    public static long e = 31457280;
    public static final JSONObject fo = new JSONObject();
    public static volatile String g = "";
    public static long gc = 50;
    public static long gz = 10485760;
    public static long m = 5242880;
    public static volatile String z = "";

    public static void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        z = str;
    }
}
