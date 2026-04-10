package top.canyie.pine.utils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import top.canyie.pine.PineConfig;

/* JADX INFO: loaded from: classes5.dex */
public final class ReflectionHelper {
    private static Field override;

    private ReflectionHelper() {
    }

    public static <T> Constructor<T> findConstructor(Class<T> cls, Class<?>... clsArr) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            forceAccessible(declaredConstructor);
            return declaredConstructor;
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Field findField(Class<?> cls, String str) {
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Method findMethod(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static void forceAccessible(AccessibleObject accessibleObject) {
        try {
            accessibleObject.setAccessible(true);
            if (accessibleObject.isAccessible()) {
                return;
            }
        } catch (SecurityException e) {
        }
        if (override == null) {
            override = getField(AccessibleObject.class, PineConfig.sdkLevel >= 24 ? "override" : "flag");
        }
        try {
            override.setBoolean(accessibleObject, true);
        } catch (IllegalAccessException e2) {
            throw new SecurityException("Cannot set AccessibleObject.override", e2);
        }
    }

    public static <T> Constructor<T> getConstructor(Class<T> cls, Class<?>... clsArr) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            forceAccessible(declaredConstructor);
            return declaredConstructor;
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("No constructor found with params " + Arrays.toString(clsArr), e);
        }
    }

    public static Field getField(Class<?> cls, String str) {
        Field fieldFindField = findField(cls, str);
        if (fieldFindField != null) {
            return fieldFindField;
        }
        throw new IllegalArgumentException("No field " + str + " found in " + cls);
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method methodFindMethod = findMethod(cls, str, clsArr);
        if (methodFindMethod != null) {
            return methodFindMethod;
        }
        throw new IllegalArgumentException("No method " + str + " with params " + Arrays.toString(clsArr) + " found in " + cls);
    }
}
