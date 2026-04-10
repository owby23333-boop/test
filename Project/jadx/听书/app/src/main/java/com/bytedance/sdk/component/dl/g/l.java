package com.bytedance.sdk.component.dl.g;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f639a;
    long dl;
    long e;
    long g;
    long gc;
    long m;
    long z = System.currentTimeMillis();

    public void z() {
        this.dl = System.currentTimeMillis();
    }

    public void g() {
        this.f639a = System.currentTimeMillis();
    }

    public void dl() {
        this.gc = System.currentTimeMillis();
    }

    public long a() {
        return this.z;
    }

    public long gc() {
        return this.dl;
    }

    public long m() {
        return this.f639a;
    }

    public long e() {
        return this.gc;
    }

    public long gz() {
        return this.m;
    }

    public void z(long j) {
        this.m = j;
    }

    public long fo() {
        return this.e;
    }

    public void g(long j) {
        this.e = j;
    }

    public long uy() {
        return this.g;
    }

    public void kb() {
        this.g = System.currentTimeMillis();
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.z + ", asyncCallExecTs=" + this.g + ", requestStartExecTs=" + this.dl + ", requestConnectStartTs=" + this.f639a + ", requestConnectFinishTs=" + this.gc + ", reqCallServerStartTs=" + this.m + ", reqCallServerFinishTs=" + this.e + '}';
    }
}
