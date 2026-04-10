package com.google.zxing.r;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.common.f;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.i;
import com.google.zxing.qrcode.decoder.d;
import com.google.zxing.qrcode.detector.c;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: QRCodeReader.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements g {
    private static final i[] b = new i[0];
    private final d a = new d();

    @Override // com.google.zxing.g
    public final h a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        i[] iVarArrB;
        com.google.zxing.common.d dVarA;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            f fVarA = new c(bVar.a()).a(map);
            com.google.zxing.common.d dVarA2 = this.a.a(fVarA.a(), map);
            iVarArrB = fVarA.b();
            dVarA = dVarA2;
        } else {
            dVarA = this.a.a(a(bVar.a()), map);
            iVarArrB = b;
        }
        if (dVarA.d() instanceof com.google.zxing.qrcode.decoder.f) {
            ((com.google.zxing.qrcode.decoder.f) dVarA.d()).a(iVarArrB);
        }
        h hVar = new h(dVarA.h(), dVarA.e(), iVarArrB, BarcodeFormat.QR_CODE);
        List<byte[]> listA = dVarA.a();
        if (listA != null) {
            hVar.a(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strB = dVarA.b();
        if (strB != null) {
            hVar.a(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        if (dVarA.i()) {
            hVar.a(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(dVarA.g()));
            hVar.a(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(dVarA.f()));
        }
        return hVar;
    }

    @Override // com.google.zxing.g
    public void reset() {
    }

    private static com.google.zxing.common.b a(com.google.zxing.common.b bVar) throws NotFoundException {
        int[] iArrD = bVar.d();
        int[] iArrA = bVar.a();
        if (iArrD != null && iArrA != null) {
            float fA = a(iArrD, bVar);
            int i2 = iArrD[1];
            int i3 = iArrA[1];
            int i4 = iArrD[0];
            int i5 = iArrA[0];
            if (i4 < i5 && i2 < i3) {
                int i6 = i3 - i2;
                if (i6 != i5 - i4 && (i5 = i4 + i6) >= bVar.e()) {
                    throw NotFoundException.f();
                }
                int iRound = Math.round(((i5 - i4) + 1) / fA);
                int iRound2 = Math.round((i6 + 1) / fA);
                if (iRound <= 0 || iRound2 <= 0) {
                    throw NotFoundException.f();
                }
                if (iRound2 == iRound) {
                    int i7 = (int) (fA / 2.0f);
                    int i8 = i2 + i7;
                    int i9 = i4 + i7;
                    int i10 = (((int) ((iRound - 1) * fA)) + i9) - i5;
                    if (i10 > 0) {
                        if (i10 > i7) {
                            throw NotFoundException.f();
                        }
                        i9 -= i10;
                    }
                    int i11 = (((int) ((iRound2 - 1) * fA)) + i8) - i3;
                    if (i11 > 0) {
                        if (i11 > i7) {
                            throw NotFoundException.f();
                        }
                        i8 -= i11;
                    }
                    com.google.zxing.common.b bVar2 = new com.google.zxing.common.b(iRound, iRound2);
                    for (int i12 = 0; i12 < iRound2; i12++) {
                        int i13 = ((int) (i12 * fA)) + i8;
                        for (int i14 = 0; i14 < iRound; i14++) {
                            if (bVar.b(((int) (i14 * fA)) + i9, i13)) {
                                bVar2.c(i14, i12);
                            }
                        }
                    }
                    return bVar2;
                }
                throw NotFoundException.f();
            }
            throw NotFoundException.f();
        }
        throw NotFoundException.f();
    }

    private static float a(int[] iArr, com.google.zxing.common.b bVar) throws NotFoundException {
        int iC = bVar.c();
        int iE = bVar.e();
        int i2 = iArr[0];
        boolean z2 = true;
        int i3 = iArr[1];
        int i4 = 0;
        while (i2 < iE && i3 < iC) {
            if (z2 != bVar.b(i2, i3)) {
                i4++;
                if (i4 == 5) {
                    break;
                }
                z2 = !z2;
            }
            i2++;
            i3++;
        }
        if (i2 != iE && i3 != iC) {
            return (i2 - iArr[0]) / 7.0f;
        }
        throw NotFoundException.f();
    }
}
