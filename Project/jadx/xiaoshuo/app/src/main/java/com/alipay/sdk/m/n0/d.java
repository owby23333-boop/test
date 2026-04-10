package com.alipay.sdk.m.n0;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1882b;
    public long c = System.currentTimeMillis() + 86400000;

    public d(String str, int i) {
        this.f1881a = str;
        this.f1882b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f1881a + "', code=" + this.f1882b + ", expired=" + this.c + '}';
    }
}
