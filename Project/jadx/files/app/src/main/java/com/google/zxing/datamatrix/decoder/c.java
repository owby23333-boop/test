package com.google.zxing.datamatrix.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private final com.google.zxing.common.reedsolomon.c a = new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f16176m);

    public com.google.zxing.common.d a(com.google.zxing.common.b bVar) throws ChecksumException, FormatException {
        a aVar = new a(bVar);
        b[] bVarArrA = b.a(aVar.b(), aVar.a());
        int iB = 0;
        for (b bVar2 : bVarArrA) {
            iB += bVar2.b();
        }
        byte[] bArr = new byte[iB];
        int length = bVarArrA.length;
        for (int i2 = 0; i2 < length; i2++) {
            b bVar3 = bVarArrA[i2];
            byte[] bArrA = bVar3.a();
            int iB2 = bVar3.b();
            a(bArrA, iB2);
            for (int i3 = 0; i3 < iB2; i3++) {
                bArr[(i3 * length) + i2] = bArrA[i3];
            }
        }
        return DecodedBitStreamParser.a(bArr);
    }

    private void a(byte[] bArr, int i2) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.f();
        }
    }
}
