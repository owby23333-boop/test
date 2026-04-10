package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class wl {
    public static Method e(String str, String str2, Class<?>... clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class<?> clsE = e(str);
            if (clsE != null) {
                return clsE.getMethod(str2, clsArr);
            }
            return null;
        } catch (Throwable th) {
            wu.e("TTClassLoader", "get method: " + str + ", " + str2, th);
            return null;
        }
    }

    public static Class<?> e(String str) {
        try {
            try {
                try {
                    return Class.forName(str, true, e());
                } catch (ClassNotFoundException unused) {
                    return Class.forName(str, true, wl.class.getClassLoader());
                }
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return Class.forName(str);
        }
    }

    private static ClassLoader e() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? wl.class.getClassLoader() : contextClassLoader;
    }
}
