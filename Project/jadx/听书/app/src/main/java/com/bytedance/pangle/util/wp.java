package com.bytedance.pangle.util;

/* JADX INFO: loaded from: classes2.dex */
public class wp {
    public static int z(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i;
        }
    }
}
