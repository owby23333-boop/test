package com.alipay.android.phone.mrpc.core;

/* JADX INFO: loaded from: classes.dex */
public class p extends v {
    private int c;
    private String d;
    private long e;
    private long f;
    private String g;
    private HttpUrlHeader h;

    public p(HttpUrlHeader httpUrlHeader, int i, String str, byte[] bArr) {
        this.h = httpUrlHeader;
        this.c = i;
        this.d = str;
        this.f1664a = bArr;
    }

    public HttpUrlHeader a() {
        return this.h;
    }

    public void b(long j) {
        this.f = j;
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(String str) {
        this.g = str;
    }
}
