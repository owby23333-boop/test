package com.google.android.play.core.splitcompat.c;

import android.os.Bundle;
import com.a.a.g;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static Bundle a(String[] strArr) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("status", 5);
        bundle.putInt("error_code", 0);
        bundle.putStringArrayList("module_names", new ArrayList<>(Arrays.asList(strArr)));
        bundle.putLong("total_bytes_to_download", 0L);
        bundle.putLong("bytes_downloaded", 0L);
        return bundle;
    }

    public static <T> a<T> b(Object obj, String str, Class<T> cls) {
        return new a<>(obj, a(obj, str), cls);
    }

    public static <T> a c(Object obj, String str, Class<T> cls) {
        return new a(obj, a(obj, str), cls, (byte) 0);
    }

    public static <R, P0, P1> R a(Class<?> cls, String str, Class<R> cls2, Class<P0> cls3, P0 p0, Class<P1> cls4, P1 p1) {
        try {
            return cls2.cast(a(cls, str, (Class<?>[]) new Class[]{cls3, cls4}).invoke(null, p0, p1));
        } catch (Exception e) {
            throw new c(String.format("Failed to invoke static method %s on type %s", str, cls), e);
        }
    }

    public static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <R> R a(Object obj, String str, Class<R> cls) {
        try {
            return cls.cast(a(obj, str, (Class<?>[]) new Class[0]).invoke(obj, new Object[0]));
        } catch (Exception e) {
            throw new c(String.format("Failed to invoke method %s on an object of type %s", str, obj.getClass()), e);
        }
    }

    public static <R, P0> R a(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0) {
        try {
            return cls.cast(a(obj, str, (Class<?>[]) new Class[]{cls2}).invoke(obj, p0));
        } catch (Exception e) {
            throw new c(String.format("Failed to invoke method %s on an object of type %s", str, obj.getClass()), e);
        }
    }

    public static <R, P0, P1, P2> R a(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0, Class<P1> cls3, P1 p1, Class<P0> cls4, P2 p2) {
        try {
            return cls.cast(a(obj, str, (Class<?>[]) new Class[]{cls2, cls3, cls4}).invoke(obj, p0, p1, p2));
        } catch (Exception e) {
            throw new c(String.format("Failed to invoke method %s on an object of type %s", str, obj.getClass()), e);
        }
    }

    private static Field a(Object obj, String str) {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new c(String.format("Failed to find a field named %s on an object of instance %s", str, obj.getClass().getName()));
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new c(String.format("Could not find a method named %s with parameters %s in type %s", str, Arrays.asList(clsArr), cls));
    }

    private static Method a(Object obj, String str, Class<?>... clsArr) {
        return a(obj.getClass(), str, clsArr);
    }

    public static void a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static X509Certificate[][] a(String str) {
        return g.a(str);
    }
}
