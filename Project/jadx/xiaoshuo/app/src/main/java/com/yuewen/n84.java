package com.yuewen;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public abstract class n84<T> {
    public static final int d = 0;
    public static final int e = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14791a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f14792b;
    public boolean c;

    public boolean a() {
        return this.f14791a == 0;
    }

    public abstract void b(@NonNull o84 o84Var);

    public T c() {
        return this.f14792b;
    }

    public boolean d() {
        return this.c;
    }

    public void e(int i, T t, o84 o84Var) {
        this.c = true;
        this.f14792b = t;
        o84Var.a(this);
    }

    public void f(o84 o84Var) {
        this.c = true;
        o84Var.a(this);
    }

    public void g(int i, T t, o84 o84Var) {
        this.f14791a = i;
        this.f14792b = t;
        o84Var.a(this);
    }
}
