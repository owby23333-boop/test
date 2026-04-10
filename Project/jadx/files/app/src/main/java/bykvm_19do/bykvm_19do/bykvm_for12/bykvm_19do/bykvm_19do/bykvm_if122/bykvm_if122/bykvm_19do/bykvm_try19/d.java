package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class d<T> {
    private final Class<?> a;
    private final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class[] f1142c;

    d(Class<?> cls, String str, Class... clsArr) {
        this.a = cls;
        this.b = str;
        this.f1142c = clsArr;
    }

    private Method a(Class<?> cls) {
        Method methodA;
        Class<?> cls2;
        String str = this.b;
        if (str == null || !((methodA = a(cls, str, this.f1142c)) == null || (cls2 = this.a) == null || cls2.isAssignableFrom(methodA.getReturnType()))) {
            return null;
        }
        return methodA;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) {
        Method method;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
        }
        try {
            if ((method.getModifiers() & 1) == 0) {
                return null;
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return method;
        }
    }

    public Object a(T t2, Object... objArr) throws InvocationTargetException {
        Method methodA = a(t2.getClass());
        if (methodA == null) {
            throw new AssertionError("Method " + this.b + " not supported for object " + t2);
        }
        try {
            return methodA.invoke(t2, objArr);
        } catch (IllegalAccessException e2) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodA);
            assertionError.initCause(e2);
            throw assertionError;
        }
    }

    public boolean a(T t2) {
        return a(t2.getClass()) != null;
    }

    public Object b(T t2, Object... objArr) throws InvocationTargetException {
        Method methodA = a(t2.getClass());
        if (methodA != null) {
            try {
                return methodA.invoke(t2, objArr);
            } catch (IllegalAccessException unused) {
            }
        }
        return null;
    }

    public Object c(T t2, Object... objArr) {
        try {
            return b(t2, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object d(T t2, Object... objArr) {
        try {
            return a(t2, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
