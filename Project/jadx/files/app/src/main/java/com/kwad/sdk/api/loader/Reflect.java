package com.kwad.sdk.api.loader;

import androidx.annotation.Nullable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class Reflect {
    private final Class<?> ZW;
    private final Object ZX;

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -6213149635297151442L;

        public ReflectException() {
        }

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }

    static class a {
        private static final Method ZY;
        private static final Method ZZ;
        private static final Method aaa;
        private static final Method aab;
        private static final Method aac;
        private static final Method aad;
        private static final Method aae;
        private static final Method aaf;
        private static final Method aag;
        private static final Method aah;
        private static final Method aai;
        private static final Method aaj;
        private static final Method aak;
        private static final Method aal;

        static {
            try {
                ZY = Class.class.getDeclaredMethod("forName", String.class);
                ZZ = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                aaa = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                aab = Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]);
                aac = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                aad = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);
                aae = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                aaf = Class.class.getDeclaredMethod("getDeclaredConstructors", new Class[0]);
                aag = Class.class.getDeclaredMethod("getField", String.class);
                aah = Class.class.getDeclaredMethod("getFields", new Class[0]);
                aai = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                aaj = Class.class.getDeclaredMethod("getMethods", new Class[0]);
                aak = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                aal = Class.class.getDeclaredMethod("getConstructors", new Class[0]);
            } catch (NoSuchMethodException e2) {
                throw new ReflectException(e2);
            }
        }

        static Constructor a(Class cls, Class<?>... clsArr) throws NoSuchMethodException {
            try {
                return (Constructor) aae.invoke(cls, clsArr);
            } catch (Exception e2) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e2);
                throw noSuchMethodException;
            }
        }

        static Field a(Class cls, String str) throws NoSuchFieldException {
            try {
                return (Field) aaa.invoke(cls, str);
            } catch (Exception e2) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e2);
                throw noSuchFieldException;
            }
        }

        static Field b(Class cls, String str) throws NoSuchFieldException {
            try {
                return (Field) aag.invoke(cls, str);
            } catch (Exception e2) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e2);
                throw noSuchFieldException;
            }
        }

        static Method c(Class cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
            try {
                return (Method) aac.invoke(cls, str, clsArr);
            } catch (Exception e2) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e2);
                throw noSuchMethodException;
            }
        }

        static Method[] c(Class cls) {
            try {
                return (Method[]) aad.invoke(cls, new Object[0]);
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }

        static Method d(Class cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
            try {
                return (Method) aai.invoke(cls, str, clsArr);
            } catch (Exception e2) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e2);
                throw noSuchMethodException;
            }
        }

        static Method[] d(Class cls) {
            try {
                return (Method[]) aaj.invoke(cls, new Object[0]);
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }

        static Constructor[] e(Class cls) {
            try {
                return (Constructor[]) aaf.invoke(cls, new Object[0]);
            } catch (Exception e2) {
                throw new ReflectException(e2);
            }
        }

        static Class forName(String str) throws ClassNotFoundException {
            try {
                return (Class) ZY.invoke(null, str);
            } catch (Exception e2) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e2);
                throw classNotFoundException;
            }
        }
    }

    static class b {
        private b() {
        }
    }

    private Reflect(Class<?> cls) {
        this(cls, cls);
    }

    private Reflect(Class<?> cls, Object obj) {
        this.ZW = cls;
        this.ZX = obj;
    }

    public static Reflect a(Class<?> cls) {
        return new Reflect(cls);
    }

    private static Reflect a(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
    }

    private static Reflect a(Constructor<?> constructor, Object... objArr) {
        try {
            return a(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    private static Reflect a(Method method, Object obj, Object... objArr) {
        try {
            a(method);
            if (method.getReturnType() != Void.TYPE) {
                return c(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return c(obj);
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    private Reflect a(Object... objArr) {
        return a(b(objArr), objArr);
    }

    @Nullable
    private static <T extends AccessibleObject> T a(T t2) {
        if (t2 == null) {
            return null;
        }
        if (t2 instanceof Member) {
            Member member = (Member) t2;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t2;
            }
        }
        if (!t2.isAccessible()) {
            t2.setAccessible(true);
        }
        return t2;
    }

    private Method a(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsType = type();
        try {
            return a.d(clsType, str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return a.c(clsType, str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    clsType = clsType.getSuperclass();
                }
            } while (clsType != null);
            throw new NoSuchMethodException();
        }
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr2.length; i2++) {
            if (clsArr2[i2] != b.class && !b(clsArr[i2]).isAssignableFrom(b(clsArr2[i2]))) {
                return false;
            }
        }
        return true;
    }

    public static Reflect aV(String str) {
        return a(forName(str));
    }

    private Reflect aW(String str) {
        try {
            Field fieldAX = aX(str);
            return a(fieldAX.getType(), fieldAX.get(this.ZX));
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    private Field aX(String str) {
        Class<?> clsType = type();
        try {
            return (Field) a(a.b(clsType, str));
        } catch (NoSuchFieldException e2) {
            do {
                try {
                    return (Field) a(a.a(clsType, str));
                } catch (NoSuchFieldException unused) {
                    clsType = clsType.getSuperclass();
                    if (clsType == null) {
                        throw new ReflectException(e2);
                    }
                }
            } while (clsType == null);
            throw new ReflectException(e2);
        }
    }

    private Reflect b(String str, Object... objArr) {
        return a(str, b(objArr), objArr);
    }

    private static Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    private Method b(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsType = type();
        for (Method method : a.d(clsType)) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : a.c(clsType)) {
                if (a(method2, str, clsArr)) {
                    return method2;
                }
            }
            clsType = clsType.getSuperclass();
        } while (clsType != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + ".");
    }

    private static Class<?>[] b(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            clsArr[i2] = obj == null ? b.class : obj.getClass();
        }
        return clsArr;
    }

    public static Reflect c(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    private static Object d(Object obj) {
        return obj instanceof Reflect ? ((Reflect) obj).get() : obj;
    }

    private static Class<?> forName(String str) {
        try {
            return a.forName(str);
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    private Class<?> type() {
        return this.ZW;
    }

    public final Reflect a(String str, Object obj) {
        try {
            Field fieldAX = aX(str);
            if ((fieldAX.getModifiers() & 16) == 16) {
                try {
                    Field fieldA = a.a(Field.class, "modifiers");
                    fieldA.setAccessible(true);
                    fieldA.setInt(fieldAX, fieldAX.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            fieldAX.set(this.ZX, d(obj));
            return this;
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    public final Reflect a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            try {
                return a(a(str, clsArr), this.ZX, objArr);
            } catch (NoSuchMethodException e2) {
                throw new ReflectException(e2);
            }
        } catch (NoSuchMethodException unused) {
            return a(b(str, clsArr), this.ZX, objArr);
        }
    }

    public final Reflect a(Class<?>[] clsArr, Object... objArr) {
        try {
            return a((Constructor<?>) a.a(type(), clsArr), objArr);
        } catch (NoSuchMethodException e2) {
            for (Constructor constructor : a.e(type())) {
                if (a(constructor.getParameterTypes(), clsArr)) {
                    return a((Constructor<?>) constructor, objArr);
                }
            }
            throw new ReflectException(e2);
        }
    }

    public final Reflect aY(String str) {
        return b(str, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.ZX.equals(((Reflect) obj).get());
        }
        return false;
    }

    public final <T> T get() {
        return (T) this.ZX;
    }

    public final <T> T get(String str) {
        return (T) aW(str).get();
    }

    public final int hashCode() {
        return this.ZX.hashCode();
    }

    public final Reflect tI() {
        return a(new Object[0]);
    }

    public final String toString() {
        return String.valueOf(this.ZX);
    }
}
