package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private final com.google.zxing.common.reedsolomon.c a = new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f16175l);

    public com.google.zxing.common.d a(com.google.zxing.common.b bVar, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        ChecksumException e2;
        a aVar = new a(bVar);
        FormatException formatException = null;
        try {
            return a(aVar, map);
        } catch (ChecksumException e3) {
            e2 = e3;
            try {
                aVar.e();
                aVar.a(true);
                aVar.d();
                aVar.c();
                aVar.a();
                com.google.zxing.common.d dVarA = a(aVar, map);
                dVarA.a(new f(true));
                return dVarA;
            } catch (ChecksumException | FormatException unused) {
                if (formatException != null) {
                    throw formatException;
                }
                throw e2;
            }
        } catch (FormatException e4) {
            e2 = null;
            formatException = e4;
            aVar.e();
            aVar.a(true);
            aVar.d();
            aVar.c();
            aVar.a();
            com.google.zxing.common.d dVarA2 = a(aVar, map);
            dVarA2.a(new f(true));
            return dVarA2;
        }
    }

    private com.google.zxing.common.d a(a aVar, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        g gVarD = aVar.d();
        ErrorCorrectionLevel errorCorrectionLevelB = aVar.c().b();
        b[] bVarArrA = b.a(aVar.b(), gVarD, errorCorrectionLevelB);
        int iB = 0;
        for (b bVar : bVarArrA) {
            iB += bVar.b();
        }
        byte[] bArr = new byte[iB];
        int length = bVarArrA.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            b bVar2 = bVarArrA[i2];
            byte[] bArrA = bVar2.a();
            int iB2 = bVar2.b();
            a(bArrA, iB2);
            int i4 = i3;
            int i5 = 0;
            while (i5 < iB2) {
                bArr[i4] = bArrA[i5];
                i5++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
        return c.a(bArr, gVarD, errorCorrectionLevelB, map);
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
