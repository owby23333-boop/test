package com.yuewen;

import com.yuewen.qh;

/* JADX INFO: loaded from: classes12.dex */
public abstract class x31<T extends qh> implements w31<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f19768b = "cache_";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f19769a;

    public x31(T t) {
        this.f19769a = t;
    }

    @Override // com.yuewen.w31
    public T a() {
        return this.f19769a;
    }

    public String d() {
        return f19768b + System.currentTimeMillis();
    }
}
