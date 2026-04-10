package com.yuewen;

/* JADX INFO: loaded from: classes12.dex */
public class iw3 {
    public static String a(String str) {
        return b(str, "");
    }

    public static String b(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
