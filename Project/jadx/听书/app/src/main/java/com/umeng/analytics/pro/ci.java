package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TMemoryInputTransport.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ci extends cj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f2214a;
    private int b;
    private int c;

    @Override // com.umeng.analytics.pro.cj
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cj
    public void b() throws ck {
    }

    @Override // com.umeng.analytics.pro.cj
    public void c() {
    }

    public ci() {
    }

    public ci(byte[] bArr) {
        a(bArr);
    }

    public ci(byte[] bArr, int i, int i2) {
        c(bArr, i, i2);
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    public void c(byte[] bArr, int i, int i2) {
        this.f2214a = bArr;
        this.b = i;
        this.c = i + i2;
    }

    public void e() {
        this.f2214a = null;
    }

    @Override // com.umeng.analytics.pro.cj
    public int a(byte[] bArr, int i, int i2) throws ck {
        int iH = h();
        if (i2 > iH) {
            i2 = iH;
        }
        if (i2 > 0) {
            System.arraycopy(this.f2214a, this.b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.umeng.analytics.pro.cj
    public void b(byte[] bArr, int i, int i2) throws ck {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.cj
    public byte[] f() {
        return this.f2214a;
    }

    @Override // com.umeng.analytics.pro.cj
    public int g() {
        return this.b;
    }

    @Override // com.umeng.analytics.pro.cj
    public int h() {
        return this.c - this.b;
    }

    @Override // com.umeng.analytics.pro.cj
    public void a(int i) {
        this.b += i;
    }
}
