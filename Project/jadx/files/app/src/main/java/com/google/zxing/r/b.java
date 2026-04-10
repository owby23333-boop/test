package com.google.zxing.r;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.k;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.r.c.c;
import com.google.zxing.r.c.f;
import java.util.Map;

/* JADX INFO: compiled from: QRCodeWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements k {
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(barcodeFormat)));
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        ErrorCorrectionLevel errorCorrectionLevelValueOf = ErrorCorrectionLevel.L;
        int i4 = 4;
        if (map != null) {
            if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                errorCorrectionLevelValueOf = ErrorCorrectionLevel.valueOf(map.get(EncodeHintType.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(EncodeHintType.MARGIN)) {
                i4 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
            }
        }
        return a(c.a(str, errorCorrectionLevelValueOf, map), i2, i3, i4);
    }

    private static com.google.zxing.common.b a(f fVar, int i2, int i3, int i4) {
        com.google.zxing.r.c.b bVarA = fVar.a();
        if (bVarA != null) {
            int iC = bVarA.c();
            int iB = bVarA.b();
            int i5 = i4 << 1;
            int i6 = iC + i5;
            int i7 = i5 + iB;
            int iMax = Math.max(i2, i6);
            int iMax2 = Math.max(i3, i7);
            int iMin = Math.min(iMax / i6, iMax2 / i7);
            int i8 = (iMax - (iC * iMin)) / 2;
            int i9 = (iMax2 - (iB * iMin)) / 2;
            com.google.zxing.common.b bVar = new com.google.zxing.common.b(iMax, iMax2);
            int i10 = 0;
            while (i10 < iB) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < iC) {
                    if (bVarA.a(i12, i10) == 1) {
                        bVar.a(i11, i9, iMin, iMin);
                    }
                    i12++;
                    i11 += iMin;
                }
                i10++;
                i9 += iMin;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }
}
