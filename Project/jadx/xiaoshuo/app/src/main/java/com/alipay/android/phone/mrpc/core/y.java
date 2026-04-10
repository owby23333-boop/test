package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f1666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private aa f1667b = new aa(this);

    public y(g gVar) {
        this.f1666a = gVar;
    }

    public g a() {
        return this.f1666a;
    }

    public <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new z(this.f1666a, cls, this.f1667b));
    }
}
