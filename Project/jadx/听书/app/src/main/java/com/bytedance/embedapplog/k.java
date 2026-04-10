package com.bytedance.embedapplog;

import android.os.SystemProperties;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    private static volatile Object z;

    private Object z() {
        if (z == null) {
            synchronized (k.class) {
                if (z == null) {
                    try {
                        z = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.wp.z(th);
                    }
                }
            }
        }
        return z;
    }

    public String z(String str) {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            cb.z(th);
            try {
                Object objZ = z();
                return (String) objZ.getClass().getMethod("get", String.class).invoke(objZ, str);
            } catch (Throwable th2) {
                cb.z(th2);
                return "";
            }
        }
    }
}
