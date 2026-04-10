package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
public class q {
    public static String a(String str, String str2) {
        try {
            return (String) C0855r.a(null, "android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a("SystemProperties.get: " + e);
            return str2;
        }
    }
}
