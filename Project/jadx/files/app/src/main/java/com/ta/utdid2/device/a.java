package com.ta.utdid2.device;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f152b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f18104c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f18105d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f18106e = "";
    private long a = 0;
    private long b = 0;

    void a(long j2) {
        this.b = j2;
    }

    void b(long j2) {
        this.a = j2;
    }

    void c(String str) {
        this.f18105d = str;
    }

    public String d() {
        return this.f152b;
    }

    public String e() {
        return this.f18106e;
    }

    public String getDeviceId() {
        return this.f18105d;
    }

    public String getImsi() {
        return this.f18104c;
    }

    long a() {
        return this.a;
    }

    void b(String str) {
        this.f18104c = str;
    }

    void d(String str) {
        this.f18106e = str;
    }

    void a(String str) {
        this.f152b = str;
    }
}
