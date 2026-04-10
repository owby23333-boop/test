package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class bb {
    private static Class<?> azB;

    private static String ez(String str) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("getprop " + str).getInputStream());
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return null;
        }
    }

    @SuppressLint({"PrivateApi"})
    private static Object g(String str, Object... objArr) {
        try {
            if (azB == null) {
                azB = Class.forName("android.os.SystemProperties");
            }
            return r.c(azB, str, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
            return null;
        }
    }

    public static String get(String str) {
        Object objG = g(MonitorConstants.CONNECT_TYPE_GET, str);
        return objG instanceof String ? (String) objG : ez(str);
    }
}
