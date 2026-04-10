package com.umeng.message.proguard;

/* JADX INFO: compiled from: UPushCompat.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static final String a = "umeng:";

    public static String a(String str) {
        return a + str;
    }

    public static String b(String str) {
        return (str == null || str.length() == 0) ? str : str.replaceFirst(a, "");
    }
}
