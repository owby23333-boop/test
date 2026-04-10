package com.xiaomi.ad.common.util;

/* JADX INFO: loaded from: classes5.dex */
public final class SystemProperties {
    public static final String TAG = "SProp";

    public static String get(String str) {
        return get(str, "");
    }

    public static String get(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            MLog.e(TAG, "Get exception", e);
            return str2;
        }
    }
}
