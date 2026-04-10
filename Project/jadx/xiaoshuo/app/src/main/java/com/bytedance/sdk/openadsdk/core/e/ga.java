package com.bytedance.sdk.openadsdk.core.e;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes10.dex */
public class ga implements InvocationHandler {
    private Object e;

    public Object e(Object obj, Class cls) {
        if (obj == null) {
            return null;
        }
        this.e = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{cls}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            return method.invoke(this.e, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
