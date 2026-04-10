package com.yuewen;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q90 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16443b = 0;
    public static final int c = 1;
    public static final int d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f16444a;

    public q90(Object obj) {
        this.f16444a = obj;
    }

    public <T> T a() {
        return (T) this.f16444a;
    }

    public abstract int b(boolean z);

    public boolean c() {
        return b(false) != 0;
    }
}
