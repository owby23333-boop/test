package com.bytedance.pangle.b.b;

import com.bytedance.pangle.log.ZeusLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static Method a;
    private static Method b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f14504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f14505d;

    static {
        try {
            a = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            f14504c = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            f14505d = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    public static Field a(Class<?> cls, String str) {
        Method method = a;
        Field field = null;
        if (method != null) {
            try {
                Field field2 = (Field) method.invoke(cls, str);
                if (field2 != null) {
                    try {
                        field2.setAccessible(true);
                    } catch (Throwable th) {
                        field = field2;
                        th = th;
                        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
                    }
                }
                field = field2;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return field != null ? field : com.bytedance.pangle.b.a.a.a(cls, str);
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method = b;
        Method method2 = null;
        if (method != null) {
            try {
                Method method3 = (Method) method.invoke(cls, str, clsArr);
                if (method3 != null) {
                    try {
                        method3.setAccessible(true);
                    } catch (Throwable th) {
                        method2 = method3;
                        th = th;
                        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
                    }
                }
                method2 = method3;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return method2 != null ? method2 : com.bytedance.pangle.b.a.a.a(cls, str, clsArr);
    }

    public static Constructor a(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        Method method = f14504c;
        if (method != null) {
            try {
                constructor = (Constructor) method.invoke(cls, clsArr);
            } catch (Throwable th) {
                ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getConstructor %s<init>%s failed !!!", cls.getName(), 1), th);
                constructor = null;
            }
        } else {
            constructor = null;
        }
        return constructor != null ? constructor : com.bytedance.pangle.b.a.a.a(cls, clsArr);
    }
}
