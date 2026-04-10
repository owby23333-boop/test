package com.kwad.sdk.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    private static final Map<Class<?>, Class<?>> ayF;

    public static class a<T> {
        public final Class<? extends T> ayG;
        public final T obj;
    }

    static {
        HashMap map = new HashMap();
        ayF = map;
        map.put(Boolean.class, Boolean.TYPE);
        ayF.put(Byte.class, Byte.TYPE);
        ayF.put(Character.class, Character.TYPE);
        ayF.put(Short.class, Short.TYPE);
        ayF.put(Integer.class, Integer.TYPE);
        ayF.put(Float.class, Float.TYPE);
        ayF.put(Long.class, Long.TYPE);
        ayF.put(Double.class, Double.TYPE);
        Map<Class<?>, Class<?>> map2 = ayF;
        Class<?> cls = Boolean.TYPE;
        map2.put(cls, cls);
        Map<Class<?>, Class<?>> map3 = ayF;
        Class<?> cls2 = Byte.TYPE;
        map3.put(cls2, cls2);
        Map<Class<?>, Class<?>> map4 = ayF;
        Class<?> cls3 = Character.TYPE;
        map4.put(cls3, cls3);
        Map<Class<?>, Class<?>> map5 = ayF;
        Class<?> cls4 = Short.TYPE;
        map5.put(cls4, cls4);
        Map<Class<?>, Class<?>> map6 = ayF;
        Class<?> cls5 = Integer.TYPE;
        map6.put(cls5, cls5);
        Map<Class<?>, Class<?>> map7 = ayF;
        Class<?> cls6 = Float.TYPE;
        map7.put(cls6, cls6);
        Map<Class<?>, Class<?>> map8 = ayF;
        Class<?> cls7 = Long.TYPE;
        map8.put(cls7, cls7);
        Map<Class<?>, Class<?>> map9 = ayF;
        Class<?> cls8 = Double.TYPE;
        map9.put(cls8, cls8);
    }

    public static <T> T X(String str, String str2) {
        try {
            return (T) Y(str, str2);
        } catch (Throwable th) {
            k(th);
            return null;
        }
    }

    private static <T> T Y(String str, String str2) {
        return (T) d(Class.forName(str), str2);
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return null;
        }
    }

    public static <T> T a(Class<?> cls, Object... objArr) {
        try {
            return (T) b(cls, objArr);
        } catch (Throwable th) {
            k(th);
            return null;
        }
    }

    public static <T> T a(Object obj, String str, Object... objArr) {
        try {
            return (T) c(obj, str, objArr);
        } catch (Throwable th) {
            k(th);
            return null;
        }
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return (T) c(Class.forName(str), str2, objArr);
        } catch (Throwable th) {
            k(th);
            return null;
        }
    }

    private static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        an.et(str);
        for (Method method : methodArr) {
            if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr, false)) {
                return method;
            }
        }
        return null;
    }

    public static void a(Class<?> cls, String str, Object obj) {
        try {
            b(cls, str, obj);
        } catch (Throwable th) {
            k(th);
        }
    }

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Throwable th) {
            k(th);
        }
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if ((!z2 || (clsArr[i2] != null && clsArr2[i2] != null)) && !clsArr[i2].isAssignableFrom(clsArr2[i2]) && (!ayF.containsKey(clsArr[i2]) || !ayF.get(clsArr[i2]).equals(ayF.get(clsArr2[i2])))) {
                return false;
            }
        }
        return true;
    }

    public static <T> T b(Class<?> cls, String str, Object... objArr) {
        try {
            return (T) c(cls, str, objArr);
        } catch (Throwable th) {
            k(th);
            return null;
        }
    }

    private static <T> T b(Class<?> cls, Object... objArr) {
        return (T) cls.getConstructor(c(objArr)).newInstance(d(objArr));
    }

    public static <T> T b(Object obj, String str, Object... objArr) {
        try {
            return (T) d(obj, str, objArr);
        } catch (Throwable th) {
            k(th);
            return null;
        }
    }

    private static Method b(Method[] methodArr, String str, Class<?>[] clsArr) {
        an.et(str);
        for (Method method : methodArr) {
            if (method.getName().equals(str) && b(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private static void b(Class<?> cls, String str, Object obj) throws IllegalAccessException, NoSuchFieldException {
        Class<?> superclass = cls;
        Field declaredField = null;
        while (declaredField == null) {
            try {
                declaredField = superclass.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
            }
            if (superclass == null) {
                throw new NoSuchFieldException();
            }
        }
        declaredField.setAccessible(true);
        declaredField.set(null, obj);
    }

    public static void b(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException {
        Class<?> superclass = obj.getClass();
        Field declaredField = null;
        while (declaredField == null) {
            try {
                declaredField = superclass.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
            }
            if (superclass == null) {
                throw new NoSuchFieldException();
            }
        }
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    private static boolean b(Class<?>[] clsArr, Class<?>[] clsArr2) {
        return a(clsArr, clsArr2, true);
    }

    public static <T> T c(Class<?> cls, String str) {
        try {
            return (T) d(cls, str);
        } catch (Throwable th) {
            k(th);
            return null;
        }
    }

    public static <T> T c(Class<?> cls, String str, Object... objArr) {
        return (T) c(cls, str, c(objArr)).invoke(null, d(objArr));
    }

    public static <T> T c(Object obj, String str, Object... objArr) {
        return (T) c(obj.getClass(), str, c(objArr)).invoke(obj, d(objArr));
    }

    public static <T> T c(String str, Object... objArr) {
        try {
            return (T) f(str, objArr);
        } catch (Throwable th) {
            k(th);
            return null;
        }
    }

    private static Method c(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        while (true) {
            Method methodA = a(cls.getDeclaredMethods(), str, clsArr);
            if (methodA != null) {
                methodA.setAccessible(true);
                return methodA;
            }
            if (cls.getSuperclass() == null) {
                throw new NoSuchMethodException();
            }
            cls = cls.getSuperclass();
        }
    }

    private static Class<?>[] c(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            clsArr[i2] = (obj == null || !(obj instanceof a)) ? obj == null ? null : obj.getClass() : ((a) obj).ayG;
        }
        return clsArr;
    }

    private static <T> T d(Class<?> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(null);
    }

    public static <T> T d(Object obj, String str) {
        try {
            return (T) e(obj, str);
        } catch (Throwable th) {
            k(th);
            return null;
        }
    }

    private static <T> T d(Object obj, String str, Object... objArr) {
        return (T) e(obj.getClass(), str, c(objArr)).invoke(obj, d(objArr));
    }

    private static Object[] d(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null || !(obj instanceof a)) {
                objArr2[i2] = obj;
            } else {
                objArr2[i2] = ((a) obj).obj;
            }
        }
        return objArr2;
    }

    public static <T> T e(Object obj, String str) throws NoSuchFieldException {
        Class<?> superclass = obj.getClass();
        Field declaredField = null;
        while (declaredField == null) {
            try {
                declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
            }
            if (superclass == null) {
                throw new NoSuchFieldException();
            }
        }
        declaredField.setAccessible(true);
        return (T) declaredField.get(obj);
    }

    private static Method e(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        while (true) {
            Method methodB = b(cls.getDeclaredMethods(), str, clsArr);
            if (methodB != null) {
                methodB.setAccessible(true);
                return methodB;
            }
            if (cls.getSuperclass() == null) {
                throw new NoSuchMethodException();
            }
            cls = cls.getSuperclass();
        }
    }

    public static boolean eh(String str) {
        try {
            return Class.forName(str) != null;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return false;
        }
    }

    private static <T> T f(String str, Object... objArr) {
        return (T) b(Class.forName(str), d(objArr));
    }

    public static <T> T i(Class<?> cls) {
        try {
            return (T) j(cls);
        } catch (Throwable th) {
            k(th);
            return null;
        }
    }

    private static <T> T j(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length == 0) {
            throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
        }
        Constructor<?> constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return (T) constructor.newInstance(new Object[0]);
        }
        Object[] objArr = new Object[parameterTypes.length];
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            objArr[i2] = k(parameterTypes[i2]);
        }
        return (T) constructor.newInstance(objArr);
    }

    private static Object k(Class<?> cls) {
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls) || Byte.TYPE.equals(cls) || Byte.class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return 0;
        }
        return (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) ? Boolean.FALSE : (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
    }

    private static void k(Throwable th) {
        if (!com.kwad.a.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        } else {
            if (!(th instanceof RuntimeException)) {
                throw new RuntimeException(th);
            }
            throw ((RuntimeException) th);
        }
    }
}
