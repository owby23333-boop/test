package com.yuewen;

/* JADX INFO: loaded from: classes17.dex */
public class gw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f11834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11835b;

    public gw(Integer num, String str) {
        this.f11834a = num;
        this.f11835b = str;
    }

    public Integer a() {
        return this.f11834a;
    }

    public String b() {
        return this.f11835b;
    }

    public void c(Integer num) {
        this.f11834a = num;
    }

    public void d(String str) {
        this.f11835b = str;
    }

    public String toString() {
        return "BusinessInfo{code=" + this.f11834a + ", message='" + this.f11835b + "'}";
    }
}
