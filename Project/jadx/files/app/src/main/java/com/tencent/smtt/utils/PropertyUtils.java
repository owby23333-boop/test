package com.tencent.smtt.utils;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class PropertyUtils {
    private static Class a;
    private static Method b;

    static {
        try {
            a = Class.forName("android.os.SystemProperties");
            b = a.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static String a(String str, String str2) {
        Method method;
        Class cls = a;
        if (cls == null || (method = b) == null) {
            return str2;
        }
        try {
            return (String) method.invoke(cls, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static String getQuickly(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : a(str, str2);
    }
}
