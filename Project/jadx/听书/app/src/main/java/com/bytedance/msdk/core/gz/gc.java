package com.bytedance.msdk.core.gz;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f400a;
    private String dl;
    private long g;
    private int gc;
    private int z;

    public void z(gc gcVar) {
        this.z = gcVar.z();
        this.g = gcVar.g();
        this.dl = gcVar.dl();
        this.f400a = gcVar.a();
        this.gc = gcVar.gc();
    }

    public int z() {
        return this.z;
    }

    public void z(int i) {
        this.z = i;
    }

    public long g() {
        return this.g;
    }

    public void z(long j) {
        this.g = j;
    }

    public String dl() {
        return this.dl;
    }

    public void z(String str) {
        this.dl = str;
    }

    public long a() {
        return this.f400a;
    }

    public int gc() {
        return this.gc;
    }

    public void g(long j) {
        this.f400a = j;
    }

    public void g(int i) {
        this.gc = i;
    }
}
