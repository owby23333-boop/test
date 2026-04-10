package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
public final class kg extends kh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8156b;

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    public void b(byte[] bArr, int i, int i2) {
        this.f875a = bArr;
        this.f8155a = i;
        this.f8156b = i + i2;
    }

    @Override // com.xiaomi.push.kh
    public int a(byte[] bArr, int i, int i2) {
        int iB = b();
        if (i2 > iB) {
            i2 = iB;
        }
        if (i2 > 0) {
            System.arraycopy(this.f875a, this.f8155a, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.kh
    public int b() {
        return this.f8156b - this.f8155a;
    }

    @Override // com.xiaomi.push.kh
    /* JADX INFO: renamed from: a */
    public void mo690a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.kh
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] mo691a() {
        return this.f875a;
    }

    @Override // com.xiaomi.push.kh
    public int a() {
        return this.f8155a;
    }

    @Override // com.xiaomi.push.kh
    public void a(int i) {
        this.f8155a += i;
    }
}
