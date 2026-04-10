package com.google.zxing.m;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.b;
import com.google.zxing.common.d;
import com.google.zxing.common.f;
import com.google.zxing.datamatrix.decoder.c;
import com.google.zxing.datamatrix.detector.Detector;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.i;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DataMatrixReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements g {
    private static final i[] b = new i[0];
    private final c a = new c();

    @Override // com.google.zxing.g
    public h a(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        i[] iVarArrB;
        d dVarA;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            f fVarA = new Detector(bVar.a()).a();
            d dVarA2 = this.a.a(fVarA.a());
            iVarArrB = fVarA.b();
            dVarA = dVarA2;
        } else {
            dVarA = this.a.a(a(bVar.a()));
            iVarArrB = b;
        }
        h hVar = new h(dVarA.h(), dVarA.e(), iVarArrB, BarcodeFormat.DATA_MATRIX);
        List<byte[]> listA = dVarA.a();
        if (listA != null) {
            hVar.a(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strB = dVarA.b();
        if (strB != null) {
            hVar.a(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
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
            int iA = a(iArrD, bVar);
            int i2 = iArrD[1];
            int i3 = iArrA[1];
            int i4 = iArrD[0];
            int i5 = ((iArrA[0] - i4) + 1) / iA;
            int i6 = ((i3 - i2) + 1) / iA;
            if (i5 > 0 && i6 > 0) {
                int i7 = iA / 2;
                int i8 = i2 + i7;
                int i9 = i4 + i7;
                com.google.zxing.common.b bVar2 = new com.google.zxing.common.b(i5, i6);
                for (int i10 = 0; i10 < i6; i10++) {
                    int i11 = (i10 * iA) + i8;
                    for (int i12 = 0; i12 < i5; i12++) {
                        if (bVar.b((i12 * iA) + i9, i11)) {
                            bVar2.c(i12, i10);
                        }
                    }
                }
                return bVar2;
            }
            throw NotFoundException.f();
        }
        throw NotFoundException.f();
    }

    private static int a(int[] iArr, com.google.zxing.common.b bVar) throws NotFoundException {
        int iE = bVar.e();
        int i2 = iArr[0];
        int i3 = iArr[1];
        while (i2 < iE && bVar.b(i2, i3)) {
            i2++;
        }
        if (i2 != iE) {
            int i4 = i2 - iArr[0];
            if (i4 != 0) {
                return i4;
            }
            throw NotFoundException.f();
        }
        throw NotFoundException.f();
    }
}
