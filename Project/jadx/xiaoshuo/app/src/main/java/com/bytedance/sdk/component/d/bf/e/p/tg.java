package com.bytedance.sdk.component.d.bf.e.p;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class tg<T> {
    private final String bf;
    private final Class[] d;
    private final Class<?> e;

    public tg(Class<?> cls, String str, Class... clsArr) {
        this.e = cls;
        this.bf = str;
        this.d = clsArr;
    }

    public Object bf(T t, Object... objArr) {
        try {
            return e(t, objArr);
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

    public Object d(T t, Object... objArr) throws InvocationTargetException {
        Method methodE = e(t.getClass());
        if (methodE == null) {
            throw new AssertionError("Method " + this.bf + " not supported for object " + t);
        }
        try {
            return methodE.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodE);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public boolean e(T t) {
        return e(t.getClass()) != null;
    }

    public Object tg(T t, Object... objArr) {
        try {
            return d(t, objArr);
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

    public Object e(T t, Object... objArr) throws InvocationTargetException {
        Method methodE = e(t.getClass());
        if (methodE == null) {
            return null;
        }
        try {
            return methodE.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    private Method e(Class<?> cls) {
        Class<?> cls2;
        String str = this.bf;
        if (str == null) {
            return null;
        }
        Method methodE = e(cls, str, this.d);
        if (methodE == null || (cls2 = this.e) == null || cls2.isAssignableFrom(methodE.getReturnType())) {
            return methodE;
        }
        return null;
    }

    private static Method e(Class<?> cls, String str, Class[] clsArr) {
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
