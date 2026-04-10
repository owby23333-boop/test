package com.google.zxing.l;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.common.d;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.i;
import com.google.zxing.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AztecReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements g {
    @Override // com.google.zxing.g
    public h a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        i[] iVarArrB;
        i[] iVarArrB2;
        FormatException formatException;
        j jVar;
        a aVarA;
        com.google.zxing.l.c.a aVar = new com.google.zxing.l.c.a(bVar.a());
        d dVarA = null;
        try {
            aVarA = aVar.a(false);
            iVarArrB = aVarA.b();
        } catch (FormatException e2) {
            e = e2;
            iVarArrB = null;
        } catch (NotFoundException e3) {
            e = e3;
            iVarArrB = null;
        }
        try {
            iVarArrB2 = iVarArrB;
            formatException = null;
            dVarA = new Decoder().a(aVarA);
            e = null;
        } catch (FormatException e4) {
            e = e4;
            iVarArrB2 = iVarArrB;
            formatException = e;
            e = null;
        } catch (NotFoundException e5) {
            e = e5;
            iVarArrB2 = iVarArrB;
            formatException = null;
        }
        if (dVarA == null) {
            try {
                a aVarA2 = aVar.a(true);
                iVarArrB2 = aVarA2.b();
                dVarA = new Decoder().a(aVarA2);
            } catch (FormatException | NotFoundException e6) {
                if (e != null) {
                    throw e;
                }
                if (formatException != null) {
                    throw formatException;
                }
                throw e6;
            }
        }
        i[] iVarArr = iVarArrB2;
        if (map != null && (jVar = (j) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (i iVar : iVarArr) {
                jVar.a(iVar);
            }
        }
        h hVar = new h(dVarA.h(), dVarA.e(), dVarA.c(), iVarArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
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
}
