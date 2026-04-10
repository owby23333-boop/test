package com.google.zxing;

/* JADX INFO: compiled from: PlanarYUVLuminanceSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f16203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f16207g;

    public f(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2) {
        super(i6, i7);
        if (i4 + i6 > i2 || i5 + i7 > i3) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f16203c = bArr;
        this.f16204d = i2;
        this.f16205e = i3;
        this.f16206f = i4;
        this.f16207g = i5;
        if (z2) {
            a(i6, i7);
        }
    }

    @Override // com.google.zxing.d
    public byte[] a(int i2, byte[] bArr) {
        if (i2 < 0 || i2 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i2)));
        }
        int iC = c();
        if (bArr == null || bArr.length < iC) {
            bArr = new byte[iC];
        }
        System.arraycopy(this.f16203c, ((i2 + this.f16207g) * this.f16204d) + this.f16206f, bArr, 0, iC);
        return bArr;
    }

    @Override // com.google.zxing.d
    public byte[] b() {
        int iC = c();
        int iA = a();
        if (iC == this.f16204d && iA == this.f16205e) {
            return this.f16203c;
        }
        int i2 = iC * iA;
        byte[] bArr = new byte[i2];
        int i3 = this.f16207g;
        int i4 = this.f16204d;
        int i5 = (i3 * i4) + this.f16206f;
        if (iC == i4) {
            System.arraycopy(this.f16203c, i5, bArr, 0, i2);
            return bArr;
        }
        for (int i6 = 0; i6 < iA; i6++) {
            System.arraycopy(this.f16203c, i5, bArr, i6 * iC, iC);
            i5 += this.f16204d;
        }
        return bArr;
    }

    public int g() {
        return a() / 2;
    }

    public int h() {
        return c() / 2;
    }

    public int[] i() {
        int iC = c() / 2;
        int iA = a() / 2;
        int[] iArr = new int[iC * iA];
        byte[] bArr = this.f16203c;
        int i2 = (this.f16207g * this.f16204d) + this.f16206f;
        for (int i3 = 0; i3 < iA; i3++) {
            int i4 = i3 * iC;
            for (int i5 = 0; i5 < iC; i5++) {
                iArr[i4 + i5] = ((bArr[(i5 << 1) + i2] & 255) * 65793) | (-16777216);
            }
            i2 += this.f16204d << 1;
        }
        return iArr;
    }

    private void a(int i2, int i3) {
        byte[] bArr = this.f16203c;
        int i4 = (this.f16207g * this.f16204d) + this.f16206f;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = (i2 / 2) + i4;
            int i7 = (i4 + i2) - 1;
            int i8 = i4;
            while (i8 < i6) {
                byte b = bArr[i8];
                bArr[i8] = bArr[i7];
                bArr[i7] = b;
                i8++;
                i7--;
            }
            i5++;
            i4 += this.f16204d;
        }
    }
}
