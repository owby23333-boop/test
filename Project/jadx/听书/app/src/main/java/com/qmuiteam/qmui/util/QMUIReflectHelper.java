package com.qmuiteam.qmui.util;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIReflectHelper {
    private static final String TAG = "QMUIReflectHelper";

    private QMUIReflectHelper() {
    }

    public static <T> T getStaticFieldValue(Class<?> cls, String str) {
        if (cls == null || str == null) {
            return null;
        }
        try {
            Field field = getField(cls, str);
            if (field == null) {
                return null;
            }
            field.setAccessible(true);
            return (T) field.get(cls);
        } catch (Throwable th) {
            Log.w(TAG, "get static field " + str + " of " + cls + " error", th);
            return null;
        }
    }

    public static boolean setStaticFieldValue(Class<?> cls, String str, Object obj) {
        if (cls == null || str == null) {
            return false;
        }
        try {
            Field field = getField(cls, str);
            if (field == null) {
                return false;
            }
            field.setAccessible(true);
            field.set(cls, obj);
            return true;
        } catch (Throwable th) {
            Log.w(TAG, "set static field " + str + " of " + cls + " error", th);
            return false;
        }
    }

    public static <T> T getFieldValue(Object obj, String str) {
        if (obj == null || str == null) {
            return null;
        }
        try {
            Field field = getField(obj.getClass(), str);
            if (field == null) {
                return null;
            }
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (Throwable th) {
            Log.w(TAG, "get field " + str + " of " + obj + " error", th);
            return null;
        }
    }

    public static <T> T getFieldValue(Object obj, Class<?> cls) {
        if (obj == null || cls == null) {
            return null;
        }
        try {
            Field field = getField(obj.getClass(), cls);
            if (field == null) {
                return null;
            }
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (Throwable th) {
            Log.w(TAG, "get field with type " + cls + " of " + obj + " error", th);
            return null;
        }
    }

    public static boolean setFieldValue(Object obj, String str, Object obj2) {
        if (obj == null || str == null) {
            return false;
        }
        try {
            Field field = getField(obj.getClass(), str);
            if (field == null) {
                return false;
            }
            field.setAccessible(true);
            field.set(obj, obj2);
            return true;
        } catch (Throwable th) {
            Log.w(TAG, "set field " + str + " of " + obj + " error", th);
            return false;
        }
    }

    public static <T> T newInstance(String str, Object... objArr) {
        try {
            return (T) newInstance(Class.forName(str), objArr);
        } catch (ClassNotFoundException e) {
            Log.w(TAG, "new instance of " + str + " error", e);
            return null;
        }
    }

    public static <T> T newInstance(Class<?> cls, Object... objArr) {
        int i;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == objArr.length) {
                for (0; i < parameterTypes.length; i + 1) {
                    Object obj = objArr[i];
                    i = (obj == null || parameterTypes[i].isAssignableFrom(obj.getClass())) ? i + 1 : 0;
                }
                try {
                    constructor.setAccessible(true);
                    return (T) constructor.newInstance(objArr);
                } catch (Throwable th) {
                    Log.w(TAG, "Invoke constructor " + constructor + " error", th);
                    return null;
                }
            }
        }
        return null;
    }

    public static <T> T invokeStaticMethod(Class<?> cls, String str) {
        return (T) invokeStaticMethod(cls, str, new Class[0], new Object[0]);
    }

    public static <T> T invokeStaticMethod(Class<?> cls, String str, Class[] clsArr, Object[] objArr) {
        if (cls == null || str == null || clsArr == null || objArr == null || clsArr.length != objArr.length) {
            return null;
        }
        try {
            Method method = getMethod(cls, str, clsArr);
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return (T) method.invoke(cls, objArr);
        } catch (Throwable th) {
            Log.w(TAG, "Invoke " + str + "(" + Arrays.toString(clsArr) + ") of " + cls + " error", th);
            return null;
        }
    }

    public static <T> T invokeMethod(Object obj, String str) {
        return (T) invokeMethod(obj, str, new Class[0], new Object[0]);
    }

    public static <T> T invokeMethod(Object obj, String str, Class[] clsArr, Object[] objArr) {
        if (obj == null || str == null || clsArr == null || objArr == null || clsArr.length != objArr.length) {
            return null;
        }
        try {
            Method method = getMethod(obj.getClass(), str, clsArr);
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return (T) method.invoke(obj, objArr);
        } catch (Throwable th) {
            Log.w(TAG, "Invoke " + str + "(" + Arrays.toString(clsArr) + ") of " + obj + " error", th);
            return null;
        }
    }

    public static Field getField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return getField(superclass, str);
        }
    }

    public static Field getField(Class<?> cls, Class<?> cls2) {
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields.length <= 0) {
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return getField(superclass, cls2);
        }
        for (Field field : declaredFields) {
            if (field.getType() == cls2) {
                return field;
            }
        }
        return null;
    }

    private static Method getMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return getMethod(superclass, str, clsArr);
        }
    }
}
