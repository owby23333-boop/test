package com.anythink.expressad.atsignalcommon.b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    private interface a {
    }

    /* JADX INFO: renamed from: com.anythink.expressad.atsignalcommon.b.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0176b<T> implements InvocationHandler {
        private T a;

        private T a() {
            return this.a;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return method.invoke(this.a, objArr);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                throw e4.getTargetException();
            }
        }

        final void a(T t2) {
            this.a = t2;
        }
    }

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(Object obj, Class<T> cls, AbstractC0176b<T> abstractC0176b) {
        if (obj instanceof a) {
            return obj;
        }
        abstractC0176b.a(obj);
        return (T) Proxy.newProxyInstance(b.class.getClassLoader(), new Class[]{cls, a.class}, abstractC0176b);
    }

    public static <T> T a(Object obj, AbstractC0176b<T> abstractC0176b, Class<?>... clsArr) {
        abstractC0176b.a(obj);
        return (T) Proxy.newProxyInstance(b.class.getClassLoader(), clsArr, abstractC0176b);
    }
}
