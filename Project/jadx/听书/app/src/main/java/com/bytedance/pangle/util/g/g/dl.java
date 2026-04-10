package com.bytedance.pangle.util.g.g;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private int e;
    private long fo;
    private int gc;
    private String gz;
    private int m;
    private int z;
    private long g = 0;
    private long dl = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f537a = 0;
    private final long uy = 30;

    public long gc() {
        return 28L;
    }

    public int z() {
        return this.z;
    }

    public void z(int i) {
        this.z = i;
    }

    public long g() {
        long j = this.dl;
        return j > 0 ? j : this.f537a;
    }

    public long dl() {
        return a() + g();
    }

    public long a() {
        return ((long) this.gc) + 30 + ((long) this.e);
    }

    public void g(int i) {
        this.e = i;
    }

    public int m() {
        return this.e;
    }

    public long e() {
        return this.g;
    }

    public void z(long j) {
        this.g = j;
    }

    public long gz() {
        return this.dl;
    }

    public void g(long j) {
        this.dl = j;
    }

    public long fo() {
        return this.f537a;
    }

    public void dl(long j) {
        this.f537a = j;
    }

    public int uy() {
        return this.gc;
    }

    public void dl(int i) {
        this.gc = i;
    }

    public int kb() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
    }

    public String wp() {
        return this.gz;
    }

    public void z(String str) {
        this.gz = str;
    }

    public long i() {
        return this.fo;
    }

    public void a(long j) {
        this.fo = j;
    }
}
