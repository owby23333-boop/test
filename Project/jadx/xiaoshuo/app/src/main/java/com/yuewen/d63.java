package com.yuewen;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes12.dex */
public abstract class d63 {
    public static Object a(Class<? extends Object> cls, Object obj, String str, Class<?>[] clsArr, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    public static <T> T b(Object obj, Class<T> cls, String str, Class<?>[] clsArr, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return (T) declaredMethod.invoke(obj, objArr);
    }

    public static Object c(Object obj, String str, Class<?> cls, Class<?>[] clsArr, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    public static Object d(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        return obj.getClass().getDeclaredMethod(str, clsArr).invoke(obj, objArr);
    }

    public static <T> T e(Object obj, Class<T> cls, String str, Class<?>[] clsArr, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method = obj.getClass().getMethod(str, clsArr);
        method.setAccessible(true);
        return (T) method.invoke(obj, objArr);
    }

    public static Object f(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
    }

    public static <T> T g(Class<?> cls, Class<T> cls2, String str, Class<?>[] clsArr, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return (T) declaredMethod.invoke(null, objArr);
    }

    public static Object h(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(null, objArr);
    }

    public static ParameterizedType i(Class cls, Class cls2) {
        Class cls3;
        if (cls != null && cls2 != null) {
            Class superclass = cls.getSuperclass();
            while (true) {
                Class cls4 = superclass;
                cls3 = cls;
                cls = cls4;
                if (cls == null || cls.equals(cls2)) {
                    break;
                }
                superclass = cls.getSuperclass();
            }
            Type genericSuperclass = cls3.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                return (ParameterizedType) genericSuperclass;
            }
        }
        return null;
    }

    public static Object j(Object obj, Class<?> cls, String str) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object k(Object obj, String str) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static <T> T l(Object obj, String str, Class<T> cls) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(obj);
    }

    public static Object m(Object obj, String str) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field field = obj.getClass().getField(str);
        field.setAccessible(true);
        return field.get(obj);
    }

    public static Object n(Class<?> cls, String str) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(null);
    }

    public static <T> T o(Class<?> cls, String str, Class<T> cls2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(null);
    }

    public static void p(Object obj, Class<?> cls, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public static void q(Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public static void r(Class<?> cls, String str, Object obj) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(null, obj);
    }
}
