package com.google.zxing.common;

import java.util.List;

/* JADX INFO: compiled from: DecoderResult.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private final byte[] a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<byte[]> f16151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f16152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f16153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f16154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f16155h;

    public d(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public void a(int i2) {
        this.b = i2;
    }

    public void a(Integer num) {
    }

    public String b() {
        return this.f16152e;
    }

    public void b(Integer num) {
    }

    public int c() {
        return this.b;
    }

    public Object d() {
        return this.f16153f;
    }

    public byte[] e() {
        return this.a;
    }

    public int f() {
        return this.f16154g;
    }

    public int g() {
        return this.f16155h;
    }

    public String h() {
        return this.f16150c;
    }

    public boolean i() {
        return this.f16154g >= 0 && this.f16155h >= 0;
    }

    public d(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        this.a = bArr;
        this.b = bArr == null ? 0 : bArr.length * 8;
        this.f16150c = str;
        this.f16151d = list;
        this.f16152e = str2;
        this.f16154g = i3;
        this.f16155h = i2;
    }

    public List<byte[]> a() {
        return this.f16151d;
    }

    public void a(Object obj) {
        this.f16153f = obj;
    }
}
