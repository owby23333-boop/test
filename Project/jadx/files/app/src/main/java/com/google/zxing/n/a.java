package com.google.zxing.n;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.b;
import com.google.zxing.common.d;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.i;
import com.google.zxing.n.b.c;
import java.util.Map;

/* JADX INFO: compiled from: MaxiCodeReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements g {
    private static final i[] b = new i[0];
    private final c a = new c();

    @Override // com.google.zxing.g
    public h a(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            throw NotFoundException.f();
        }
        d dVarA = this.a.a(a(bVar.a()), map);
        h hVar = new h(dVarA.h(), dVarA.e(), b, BarcodeFormat.MAXICODE);
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
        int[] iArrB = bVar.b();
        if (iArrB != null) {
            int i2 = iArrB[0];
            int i3 = iArrB[1];
            int i4 = iArrB[2];
            int i5 = iArrB[3];
            com.google.zxing.common.b bVar2 = new com.google.zxing.common.b(30, 33);
            for (int i6 = 0; i6 < 33; i6++) {
                int i7 = (((i6 * i5) + (i5 / 2)) / 33) + i3;
                for (int i8 = 0; i8 < 30; i8++) {
                    if (bVar.b(((((i8 * i4) + (i4 / 2)) + (((i6 & 1) * i4) / 2)) / 30) + i2, i7)) {
                        bVar2.c(i8, i6);
                    }
                }
            }
            return bVar2;
        }
        throw NotFoundException.f();
    }
}
