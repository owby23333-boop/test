package com.ss.android.downloadlib.utils;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class x {
    public static void b(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.jb jbVarIo = com.ss.android.downloadlib.addownload.x.io();
        if (jbVarIo != null) {
            jbVarIo.mb(6, str, str2, jSONObject);
        }
    }

    public static void mb(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.jb jbVarIo = com.ss.android.downloadlib.addownload.x.io();
        if (jbVarIo != null) {
            jbVarIo.mb(2, str, str2, jSONObject);
        }
    }

    public static void ox(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.jb jbVarIo = com.ss.android.downloadlib.addownload.x.io();
        if (jbVarIo != null) {
            jbVarIo.mb(3, str, str2, jSONObject);
        }
    }

    public static void mb(String str, String str2) {
        b(str, str2, null);
    }

    public static void mb(String str) {
        b(null, str, null);
    }
}
