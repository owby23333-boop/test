package com.umeng.message.proguard;

/* JADX INFO: compiled from: OSUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class ah {
    public static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
