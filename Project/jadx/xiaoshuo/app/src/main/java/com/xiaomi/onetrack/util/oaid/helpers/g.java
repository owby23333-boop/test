package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.Context;
import com.xiaomi.onetrack.util.p;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7749b = "MsaSDKHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<a> f7750a = new LinkedBlockingQueue<>(1);

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f7751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Method f7752b;
        Object[] c;

        public a(Object obj, Method method, Object[] objArr) {
            this.f7751a = obj;
            this.f7752b = method;
            this.c = objArr;
        }
    }

    public class b implements InvocationHandler {
        public b() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                g.this.f7750a.offer(g.this.new a(obj, method, objArr), 1L, TimeUnit.SECONDS);
                return null;
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                    return null;
                } catch (Exception e2) {
                    p.a(g.f7749b, e2.getMessage());
                    return null;
                }
            }
        }
    }

    public String a(Context context) {
        try {
            Class<?> cls = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            Class<?> cls2 = Class.forName("com.bun.supplier.IIdentifierListener");
            cls.getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, cls2).invoke(cls, context, Boolean.TRUE, Proxy.newProxyInstance(context.getClassLoader(), new Class[]{cls2}, new b()));
            a aVarPoll = this.f7750a.poll(1L, TimeUnit.SECONDS);
            return aVarPoll != null ? aVarPoll.c[1].getClass().getMethod("getOAID", new Class[0]).invoke(aVarPoll.c[1], new Object[0]).toString() : "";
        } catch (Throwable th) {
            p.a(f7749b, th.getMessage());
            return "";
        }
    }
}
