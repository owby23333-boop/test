package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class sy {
    public static Method z(String str, String str2, Class<?>... clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class<?> clsZ = z(str);
            if (clsZ != null) {
                return clsZ.getMethod(str2, clsArr);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> z(String str) {
        try {
            try {
                try {
                    return Class.forName(str, true, z());
                } catch (ClassNotFoundException unused) {
                    return Class.forName(str, true, sy.class.getClassLoader());
                }
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return Class.forName(str);
        }
    }

    private static ClassLoader z() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? sy.class.getClassLoader() : contextClassLoader;
    }
}
