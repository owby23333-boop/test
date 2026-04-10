package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ga {
    public static volatile String bf = "";
    public static volatile String d = "";
    public static volatile String e = "";
    public static long ga = 50;
    public static long p = 31457280;
    public static long tg = 512000;
    public static long v = 10485760;
    public static long vn = 5242880;
    public static final JSONObject zk = new JSONObject();

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e = str;
    }
}
