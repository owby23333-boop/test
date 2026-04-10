package com.anythink.expressad.mbbanner.a.b;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10805d;

    public e(String str, String str2, int i2) {
        this.a = "";
        this.b = "";
        this.f10804c = 0;
        this.f10805d = 1;
        this.a = str;
        this.b = str2;
        this.f10804c = 0;
        this.f10805d = i2;
    }

    private void b(String str) {
        this.a = str;
    }

    private String d() {
        return this.a;
    }

    public final String a() {
        return this.b;
    }

    public final int c() {
        return this.f10805d;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final int b() {
        return this.f10804c;
    }

    private void b(int i2) {
        this.f10805d = i2;
    }

    public final void a(int i2) {
        this.f10804c = i2;
    }
}
