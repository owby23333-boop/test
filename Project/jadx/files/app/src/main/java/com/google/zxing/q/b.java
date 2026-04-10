package com.google.zxing.q;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.common.d;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.i;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: PDF417Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements g, com.google.zxing.o.a {
    private static int b(i iVar, i iVar2) {
        if (iVar == null || iVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(iVar.a() - iVar2.a());
    }

    @Override // com.google.zxing.g
    public h a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        h[] hVarArrA = a(bVar, map, false);
        if (hVarArrA == null || hVarArrA.length == 0 || hVarArrA[0] == null) {
            throw NotFoundException.f();
        }
        return hVarArrA[0];
    }

    @Override // com.google.zxing.g
    public void reset() {
    }

    private static int b(i[] iVarArr) {
        return Math.min(Math.min(b(iVarArr[0], iVarArr[4]), (b(iVarArr[6], iVarArr[2]) * 17) / 18), Math.min(b(iVarArr[1], iVarArr[5]), (b(iVarArr[7], iVarArr[3]) * 17) / 18));
    }

    private static h[] a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map, boolean z2) throws NotFoundException, ChecksumException, FormatException {
        ArrayList arrayList = new ArrayList();
        com.google.zxing.q.d.b bVarA = com.google.zxing.q.d.a.a(bVar, map, z2);
        for (i[] iVarArr : bVarA.b()) {
            d dVarA = com.google.zxing.pdf417.decoder.i.a(bVarA.a(), iVarArr[4], iVarArr[5], iVarArr[6], iVarArr[7], b(iVarArr), a(iVarArr));
            h hVar = new h(dVarA.h(), dVarA.e(), iVarArr, BarcodeFormat.PDF_417);
            hVar.a(ResultMetadataType.ERROR_CORRECTION_LEVEL, dVarA.b());
            c cVar = (c) dVarA.d();
            if (cVar != null) {
                hVar.a(ResultMetadataType.PDF417_EXTRA_METADATA, cVar);
            }
            arrayList.add(hVar);
        }
        return (h[]) arrayList.toArray(new h[arrayList.size()]);
    }

    private static int a(i iVar, i iVar2) {
        if (iVar == null || iVar2 == null) {
            return 0;
        }
        return (int) Math.abs(iVar.a() - iVar2.a());
    }

    private static int a(i[] iVarArr) {
        return Math.max(Math.max(a(iVarArr[0], iVarArr[4]), (a(iVarArr[6], iVarArr[2]) * 17) / 18), Math.max(a(iVarArr[1], iVarArr[5]), (a(iVarArr[7], iVarArr[3]) * 17) / 18));
    }
}
