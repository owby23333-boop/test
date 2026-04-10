package com.bytedance.sdk.component.p.e;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void e(Object obj, String str) {
        if (obj == null) {
            e(str);
        }
    }

    public static void e(String str) {
        throw new IllegalArgumentException(str);
    }
}
