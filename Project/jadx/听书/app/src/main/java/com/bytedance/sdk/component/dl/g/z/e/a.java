package com.bytedance.sdk.component.dl.g.z.e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class a<T> {
    private final Class[] dl;
    private final String g;
    private final Class<?> z;

    a(Class<?> cls, String str, Class... clsArr) {
        this.z = cls;
        this.g = str;
        this.dl = clsArr;
    }

    public boolean z(T t) {
        return z(t.getClass()) != null;
    }

    public Object z(T t, Object... objArr) throws InvocationTargetException {
        Method methodZ = z(t.getClass());
        if (methodZ == null) {
            return null;
        }
        try {
            return methodZ.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object g(T t, Object... objArr) {
        try {
            return z(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object dl(T t, Object... objArr) throws InvocationTargetException {
        Method methodZ = z(t.getClass());
        if (methodZ == null) {
            throw new AssertionError("Method " + this.g + " not supported for object " + t);
        }
        try {
            return methodZ.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(methodZ)));
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public Object a(T t, Object... objArr) {
        try {
            return dl(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    private Method z(Class<?> cls) {
        Class<?> cls2;
        String str = this.g;
        if (str == null) {
            return null;
        }
        Method methodZ = z(cls, str, this.dl);
        if (methodZ == null || (cls2 = this.z) == null || cls2.isAssignableFrom(methodZ.getReturnType())) {
            return methodZ;
        }
        return null;
    }

    private static Method z(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
