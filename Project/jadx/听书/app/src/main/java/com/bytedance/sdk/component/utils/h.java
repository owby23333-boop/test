package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    private static final HashMap<Class<?>, Class<?>> dl;
    private static Map<String, Method> g = new HashMap();
    public static final Class<?>[] z;

    static {
        HashMap<Class<?>, Class<?>> map = new HashMap<>();
        dl = map;
        map.put(Boolean.TYPE, Boolean.class);
        map.put(Byte.TYPE, Byte.class);
        map.put(Character.TYPE, Character.class);
        map.put(Short.TYPE, Short.class);
        map.put(Integer.TYPE, Integer.class);
        map.put(Long.TYPE, Long.class);
        map.put(Double.TYPE, Double.class);
        map.put(Float.TYPE, Float.class);
        map.put(Void.TYPE, Void.class);
        z = new Class[0];
    }

    public static int z(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static String g(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str).append("#").append(cls.getClassLoader() != null ? Integer.valueOf(cls.getClassLoader().hashCode()) : "");
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.toString()).append("#");
            }
        } else {
            sb.append(Void.class.toString());
        }
        return sb.toString();
    }

    public static Method z(Class<?> cls, String str, Class<?>... clsArr) {
        Method declaredMethod;
        String strG = g(cls, str, clsArr);
        synchronized (g) {
            declaredMethod = g.get(strG);
        }
        if (declaredMethod != null) {
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            return declaredMethod;
        }
        while (cls != null) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (declaredMethod == null) {
                try {
                    for (Method method : cls.getDeclaredMethods()) {
                        if (method != null && TextUtils.equals(method.getName(), str)) {
                            Class<?>[] parameterTypes = method.getParameterTypes();
                            if (clsArr != null && parameterTypes != null && clsArr.length == parameterTypes.length) {
                                boolean z2 = true;
                                for (int i = 0; i < clsArr.length; i++) {
                                    if (!z(clsArr[i], parameterTypes[i])) {
                                        z2 = false;
                                    }
                                }
                                if (z2) {
                                    declaredMethod = method;
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                synchronized (g) {
                    g.put(strG, declaredMethod);
                }
                return declaredMethod;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static boolean z(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = dl.get(cls);
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = dl.get(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    public static Object z(Object obj, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return z(obj, str, objArr, z(objArr));
    }

    public static Object z(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method methodZ = z(obj.getClass(), str, clsArr);
        if (methodZ != null) {
            return methodZ.invoke(obj, objArr);
        }
        throw new NoSuchMethodException(str);
    }

    public static Class<?>[] z(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                clsArr[i] = obj == null ? null : obj.getClass();
            }
            return clsArr;
        }
        return z;
    }
}
