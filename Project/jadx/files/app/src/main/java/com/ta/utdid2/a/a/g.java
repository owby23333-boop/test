package com.ta.utdid2.a.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static String get(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }
}
