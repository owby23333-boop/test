package com.bytedance.pangle.g.z;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static Map<String, Field> z = new HashMap();
    private static Map<String, Method> g = new HashMap();
    private static Map<String, Constructor> dl = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Class> f512a = new HashMap();

    static {
        try {
            FieldUtils.writeField(g.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e);
        }
    }

    public static Field z(Class<?> cls, String str) {
        Field field;
        String strG = g(cls, str);
        synchronized (z) {
            field = z.get(strG);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field fieldZ = g.z(cls, str);
            if (fieldZ != null) {
                synchronized (z) {
                    z.put(strG, fieldZ);
                }
            }
            return fieldZ;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Method z(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String strG = g(cls, str, clsArr);
        synchronized (g) {
            method = g.get(strG);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method methodZ = g.z(cls, str, clsArr);
            if (methodZ != null) {
                synchronized (g) {
                    g.put(strG, methodZ);
                }
            }
            return methodZ;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Constructor z(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String strG = g(cls, "clinit", clsArr);
        synchronized (dl) {
            constructor = dl.get(strG);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor constructorZ = g.z(cls, clsArr);
            if (constructorZ != null) {
                synchronized (dl) {
                    dl.put(strG, constructorZ);
                }
            }
            return constructorZ;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    private static String g(Class<?> cls, String str) {
        return cls.getName() + "#" + str;
    }

    private static String g(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName()).append("#").append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName()).append("#");
            }
        } else {
            sb.append(Void.class.getName());
        }
        return sb.toString();
    }
}
