package com.bytedance.embedapplog;

import android.os.SystemProperties;

/* JADX INFO: loaded from: classes.dex */
public class em {
    private static volatile Object e;

    private Object e() {
        if (e == null) {
            synchronized (em.class) {
                if (e == null) {
                    try {
                        e = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return e;
    }

    public String e(String str) {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            tx.e(th);
            try {
                Object objE = e();
                return (String) objE.getClass().getMethod("get", String.class).invoke(objE, str);
            } catch (Throwable th2) {
                tx.e(th2);
                return "";
            }
        }
    }
}
