package com.market.sdk.reflect;

import com.yuewen.w51;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes7.dex */
public class Method {
    private static final String TAG = "Method";
    private final java.lang.reflect.Method mMethod;

    private Method(java.lang.reflect.Method method) {
        this.mMethod = method;
    }

    public static Method of(Class<?> cls, String str, String str2) throws java.lang.NoSuchMethodException {
        try {
            return new Method(cls.getMethod(str, ReflectTool.parseTypesFromSignature(str2)));
        } catch (ClassNotFoundException e) {
            throw new java.lang.NoSuchMethodException(e.getMessage());
        } catch (java.lang.NoSuchMethodException e2) {
            throw new java.lang.NoSuchMethodException(e2.getMessage());
        }
    }

    public void invoke(Class<?> cls, Object obj, Object... objArr) throws IllegalArgumentException {
        java.lang.reflect.Method method = this.mMethod;
        if (method == null) {
            return;
        }
        try {
            method.setAccessible(true);
            this.mMethod.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (InvocationTargetException e2) {
            throw new IllegalArgumentException(e2.getMessage());
        }
    }

    public boolean invokeBoolean(Class<?> cls, Object obj, Object... objArr) throws IllegalArgumentException {
        Object objInvokeObject = invokeObject(cls, obj, objArr);
        if (objInvokeObject != null && (objInvokeObject instanceof Boolean)) {
            return ((Boolean) objInvokeObject).booleanValue();
        }
        return false;
    }

    public double invokeDouble(Class<?> cls, Object obj, Object... objArr) throws IllegalArgumentException {
        Object objInvokeObject = invokeObject(cls, obj, objArr);
        return (objInvokeObject != null && (objInvokeObject instanceof Double)) ? ((Double) objInvokeObject).doubleValue() : w51.l;
    }

    public float invokeFloat(Class<?> cls, Object obj, Object... objArr) throws IllegalArgumentException {
        Object objInvokeObject = invokeObject(cls, obj, objArr);
        if (objInvokeObject != null && (objInvokeObject instanceof Double)) {
            return ((Float) objInvokeObject).floatValue();
        }
        return 0.0f;
    }

    public int invokeInt(Class<?> cls, Object obj, Object... objArr) throws IllegalArgumentException {
        Object objInvokeObject = invokeObject(cls, obj, objArr);
        if (objInvokeObject != null && (objInvokeObject instanceof Integer)) {
            return ((Integer) objInvokeObject).intValue();
        }
        return -1;
    }

    public long invokeLong(Class<?> cls, Object obj, Object... objArr) throws IllegalArgumentException {
        Object objInvokeObject = invokeObject(cls, obj, objArr);
        if (objInvokeObject != null && (objInvokeObject instanceof Long)) {
            return ((Long) objInvokeObject).longValue();
        }
        return -1L;
    }

    public Object invokeObject(Class<?> cls, Object obj, Object... objArr) throws IllegalArgumentException {
        java.lang.reflect.Method method = this.mMethod;
        if (method == null) {
            return null;
        }
        try {
            method.setAccessible(true);
            return this.mMethod.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (InvocationTargetException e2) {
            throw new IllegalArgumentException(e2.getMessage());
        }
    }

    public static Method of(Class<?> cls, String str, Class<?> cls2, Class<?>... clsArr) {
        return new Method(null);
    }

    public static Method of(String str, String str2, String str3) throws java.lang.NoSuchMethodException, NoSuchClassException {
        try {
            return of(Class.forName(str), str2, str3);
        } catch (ClassNotFoundException e) {
            throw new NoSuchClassException(e.getMessage());
        }
    }
}
