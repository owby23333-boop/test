package com.google.zxing;

/* JADX INFO: compiled from: InvertedLuminanceSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f16134c;

    public c(d dVar) {
        super(dVar.c(), dVar.a());
        this.f16134c = dVar;
    }

    @Override // com.google.zxing.d
    public byte[] a(int i2, byte[] bArr) {
        byte[] bArrA = this.f16134c.a(i2, bArr);
        int iC = c();
        for (int i3 = 0; i3 < iC; i3++) {
            bArrA[i3] = (byte) (255 - (bArrA[i3] & 255));
        }
        return bArrA;
    }

    @Override // com.google.zxing.d
    public byte[] b() {
        byte[] bArrB = this.f16134c.b();
        int iC = c() * a();
        byte[] bArr = new byte[iC];
        for (int i2 = 0; i2 < iC; i2++) {
            bArr[i2] = (byte) (255 - (bArrB[i2] & 255));
        }
        return bArr;
    }

    @Override // com.google.zxing.d
    public boolean e() {
        return this.f16134c.e();
    }

    @Override // com.google.zxing.d
    public d f() {
        return new c(this.f16134c.f());
    }
}
