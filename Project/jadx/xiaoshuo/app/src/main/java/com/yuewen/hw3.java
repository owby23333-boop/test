package com.yuewen;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.duokan.core.diagnostic.LogLevel;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class hw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12300a = "SystemProperties";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f12301b;
    public static Method c;
    public static Method d;

    static {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            f12301b = cls;
            c = cls.getDeclaredMethod("get", String.class, String.class);
            d = f12301b.getDeclaredMethod("get", String.class, Integer.TYPE);
        } catch (Exception e) {
            qt1.e(f12300a, e.getMessage(), e);
        }
    }

    public static String a(String str) {
        return c(str, "");
    }

    @NonNull
    public static int b(String str, int i) {
        try {
            Integer num = (Integer) d.invoke(f12301b, str, Integer.valueOf(i));
            return num != null ? num.intValue() : i;
        } catch (Exception unused) {
            ia0.w().f(LogLevel.INFO, f12300a, "-->getString() fail, key=" + str + ", defValue=" + i);
            return i;
        }
    }

    @NonNull
    public static String c(String str, String str2) {
        try {
            String str3 = (String) c.invoke(f12301b, str, str2);
            return !TextUtils.isEmpty(str3) ? str3 : str2;
        } catch (Exception e) {
            ia0.w().f(LogLevel.INFO, f12300a, "-->getString() fail, key=" + str + ", defValue=" + str2);
            qt1.e(f12300a, e.getMessage(), e);
            return str2;
        }
    }
}
