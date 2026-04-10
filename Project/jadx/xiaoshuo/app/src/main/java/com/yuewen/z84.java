package com.yuewen;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public class z84 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f20713b;
    public long c;
    public long d;
    public long e;
    public int f;
    public String g;
    public Throwable h;
    public final ArrayList<String> i = new ArrayList<>();

    public long a() {
        return this.c - this.f20713b;
    }

    public int b() {
        long j = this.e;
        if (j == 0) {
            return 0;
        }
        return (int) ((this.d * 100) / j);
    }

    public long c() {
        return this.f20713b;
    }

    public ArrayList<String> d() {
        return this.i;
    }

    public long e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public String g() {
        return this.f20712a;
    }

    public long h() {
        return this.d;
    }

    public boolean i() {
        int iF = f();
        return iF != 0 && iF == d().size();
    }

    public void j(long j) {
        this.c = j;
    }

    public void k(long j) {
        this.f20713b = j;
    }

    public void l(long j) {
        this.e = j;
    }

    public void m(int i) {
        this.f = i;
    }

    public void n(String str) {
        this.f20712a = str;
    }

    public void o(long j) {
        this.d = j;
    }

    public String toString() {
        return "UploadInfo{uploadId='" + this.f20712a + "', startTime=" + this.f20713b + ", currentTime=" + this.c + ", uploadedBytes=" + this.d + ", totalBytes=" + this.e + ", totalFiles=" + this.f + ", successfullyUploadedFiles=" + this.i + '}';
    }
}
