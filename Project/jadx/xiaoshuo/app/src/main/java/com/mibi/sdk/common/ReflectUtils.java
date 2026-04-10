package com.mibi.sdk.common;

import com.mibi.sdk.common.utils.MibiLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes13.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    private ReflectUtils() {
    }

    public static Class<?> getClassFromName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            MibiLog.e(TAG, "getClassFromName:" + str, e);
            return null;
        }
    }

    public static Field getFiled(Class<?> cls, String str) {
        Field declaredField;
        try {
            declaredField = cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            MibiLog.e(TAG, "getFiled:" + str, e);
            declaredField = null;
        }
        if (declaredField != null) {
            declaredField.setAccessible(true);
        }
        return declaredField;
    }

    public static <T> T getMember(Class<?> cls, Object obj, String str) {
        Field filed = getFiled(cls, str);
        if (filed == null) {
            return null;
        }
        try {
            return (T) filed.get(obj);
        } catch (Exception e) {
            MibiLog.e(TAG, "getMember:" + str, e);
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method declaredMethod;
        try {
            declaredMethod = cls.getDeclaredMethod(str, clsArr);
        } catch (Exception e) {
            MibiLog.e(TAG, "getMethod:" + str, e);
            declaredMethod = null;
        }
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod;
    }

    public static <T> T invoke(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            return (T) method.invoke(obj, objArr);
        } catch (Exception e) {
            MibiLog.e(TAG, "invoke error", e);
            return null;
        }
    }

    public static boolean isMethodExist(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            cls.getDeclaredMethod(str, clsArr);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
