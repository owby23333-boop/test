package com.anythink.expressad.atsignalcommon.windvane;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    private interface a {
    }

    public static abstract class b<T> implements InvocationHandler {
        private T a;

        private T a() {
            return this.a;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            return method.invoke(this.a, objArr);
        }

        final void a(T t2) {
            this.a = t2;
        }
    }

    private f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(Object obj, Class<T> cls, b<T> bVar) {
        if (obj instanceof a) {
            return obj;
        }
        bVar.a(obj);
        return (T) Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{cls, a.class}, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(Object obj, b<T> bVar, Class<?>... clsArr) {
        if (Proxy.isProxyClass(obj.getClass())) {
            return obj;
        }
        bVar.a(obj);
        return (T) Proxy.newProxyInstance(f.class.getClassLoader(), clsArr, bVar);
    }
}
