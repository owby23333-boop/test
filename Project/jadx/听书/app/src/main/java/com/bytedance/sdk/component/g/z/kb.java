package com.bytedance.sdk.component.g.z;

import com.bytedance.sdk.component.dl.g.l;

/* JADX INFO: loaded from: classes2.dex */
public class kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f718a;
    public long dl;
    public long e;
    public long g;
    public long gc;
    public long m;
    public long z;

    public kb() {
        this.z = System.currentTimeMillis();
    }

    public kb(Object obj) {
        this.z = System.currentTimeMillis();
        try {
            if (obj instanceof l) {
                l lVar = (l) obj;
                this.z = lVar.a();
                this.g = lVar.uy();
                this.dl = lVar.gc();
                this.f718a = lVar.m();
                this.gc = lVar.e();
                this.m = lVar.gz();
                this.e = lVar.fo();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public void z() {
        this.dl = System.currentTimeMillis();
    }

    public void g() {
        this.f718a = System.currentTimeMillis();
    }

    public void dl() {
        this.gc = System.currentTimeMillis();
    }

    public void z(long j) {
        this.m = j;
    }

    public void g(long j) {
        this.e = j;
    }

    public void a() {
        this.g = System.currentTimeMillis();
    }
}
