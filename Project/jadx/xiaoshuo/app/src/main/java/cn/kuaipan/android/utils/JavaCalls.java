package cn.kuaipan.android.utils;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class JavaCalls {
    private static final String LOG_TAG = "JavaCalls";
    private static final HashMap<Class<?>, Class<?>> PRIMITIVE_MAP;

    public static class JavaParam<T> {
        public final Class<? extends T> clazz;
        public final T obj;

        public JavaParam(Class<? extends T> cls, T t) {
            this.clazz = cls;
            this.obj = t;
        }
    }

    static {
        HashMap<Class<?>, Class<?>> map = new HashMap<>();
        PRIMITIVE_MAP = map;
        Class<?> cls = Boolean.TYPE;
        map.put(Boolean.class, cls);
        map.put(Byte.class, Byte.TYPE);
        map.put(Character.class, Character.TYPE);
        map.put(Short.class, Short.TYPE);
        Class<?> cls2 = Integer.TYPE;
        map.put(Integer.class, cls2);
        Class<?> cls3 = Float.TYPE;
        map.put(Float.class, cls3);
        Class<?> cls4 = Long.TYPE;
        map.put(Long.class, cls4);
        map.put(Double.class, Double.TYPE);
        map.put(cls, cls);
        Class<?> cls5 = Byte.TYPE;
        map.put(cls5, cls5);
        Class<?> cls6 = Character.TYPE;
        map.put(cls6, cls6);
        Class<?> cls7 = Short.TYPE;
        map.put(cls7, cls7);
        map.put(cls2, cls2);
        map.put(cls3, cls3);
        map.put(cls4, cls4);
        Class<?> cls8 = Double.TYPE;
        map.put(cls8, cls8);
    }

    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) callMethodOrThrow(obj, str, objArr);
        } catch (Exception e) {
            Log.w(LOG_TAG, "Meet exception when call Method '" + str + "' in " + obj, e);
            return null;
        }
    }

    public static <T> T callMethodOrThrow(Object obj, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        return (T) getDeclaredMethod(obj.getClass(), str, getParameterTypes(objArr)).invoke(obj, getParameters(objArr));
    }

    public static <T> T callStaticMethod(String str, String str2, Object... objArr) {
        try {
            return (T) callStaticMethodOrThrow(Class.forName(str), str2, objArr);
        } catch (Exception e) {
            Log.w(LOG_TAG, "Meet exception when call Method '" + str2 + "' in " + str, e);
            return null;
        }
    }

    public static <T> T callStaticMethodOrThrow(String str, String str2, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        return (T) getDeclaredMethod(Class.forName(str), str2, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    private static boolean compareClassLists(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        int length = clsArr.length;
        if (clsArr2 == null) {
            return length == 0;
        }
        if (length != clsArr2.length) {
            return false;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (!clsArr[i].isAssignableFrom(clsArr2[i])) {
                HashMap<Class<?>, Class<?>> map = PRIMITIVE_MAP;
                if (!map.containsKey(clsArr[i]) || !map.get(clsArr[i]).equals(map.get(clsArr2[i]))) {
                }
            }
            return true;
        }
        return false;
    }

    private static Method findMethodByName(Method[] methodArr, String str, Class<?>[] clsArr) throws NoSuchMethodException {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str) && compareClassLists(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        throw new NoSuchMethodException(str);
    }

    private static Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        return findMethodByName(cls.getDeclaredMethods(), str, clsArr);
    }

    public static <T> T getInstance(Class<?> cls, Object... objArr) {
        try {
            return (T) getInstanceOrThrow(cls, objArr);
        } catch (Exception e) {
            Log.w(LOG_TAG, "Meet exception when make instance as a " + cls.getSimpleName(), e);
            return null;
        }
    }

    public static <T> T getInstanceOrThrow(Class<?> cls, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        return (T) cls.getConstructor(getParameterTypes(objArr)).newInstance(getParameters(objArr));
    }

    private static Class<?>[] getParameterTypes(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof JavaParam)) {
                clsArr[i] = obj == null ? null : obj.getClass();
            } else {
                clsArr[i] = ((JavaParam) obj).clazz;
            }
        }
        return clsArr;
    }

    private static Object[] getParameters(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof JavaParam)) {
                objArr2[i] = obj;
            } else {
                objArr2[i] = ((JavaParam) obj).obj;
            }
        }
        return objArr2;
    }

    public static Object getInstanceOrThrow(String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        return getInstanceOrThrow(Class.forName(str), getParameters(objArr));
    }

    public static <T> T callStaticMethodOrThrow(Class<?> cls, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        return (T) getDeclaredMethod(cls, str, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    public static Object getInstance(String str, Object... objArr) {
        try {
            return getInstanceOrThrow(str, objArr);
        } catch (Exception e) {
            Log.w(LOG_TAG, "Meet exception when make instance as a " + str, e);
            return null;
        }
    }
}
