package com.yuewen;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public class e63 {
    public static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object b(Object obj, Field field) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Field c(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static Field d(String str, String str2) {
        return c(a(str), str2);
    }

    public static Method e(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static Method f(String str, String str2, Class<?>... clsArr) {
        return e(a(str), str2, clsArr);
    }

    public static Field g(Class<?> cls, String str) {
        try {
            Field field = cls.getField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static Field h(String str, String str2) {
        return g(a(str), str2);
    }

    public static Method i(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            return method;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static Method j(String str, String str2, Class<?>... clsArr) {
        return i(a(str), str2, clsArr);
    }

    public static Object k(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void l(Object obj, Field field, Object obj2) {
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
