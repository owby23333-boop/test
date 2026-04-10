package com.bytedance.sdk.component.adexpress.z.z;

import com.bytedance.sdk.component.m.iq;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static z gc = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile iq f622a;
    private volatile dl dl;
    private volatile a g;
    private volatile gc m;
    private volatile g z;

    private z() {
    }

    public static z z() {
        return gc;
    }

    public void z(g gVar) {
        this.z = gVar;
    }

    public g g() {
        return this.z;
    }

    public void z(dl dlVar) {
        this.dl = dlVar;
    }

    public dl dl() {
        return this.dl;
    }

    public void z(a aVar) {
        this.g = aVar;
    }

    public a a() {
        return this.g;
    }

    public void z(iq iqVar) {
        this.f622a = iqVar;
    }

    public iq gc() {
        return this.f622a;
    }

    public void z(gc gcVar) {
        this.m = gcVar;
    }

    public gc m() {
        return this.m;
    }
}
