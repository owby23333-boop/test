package com.google.zxing.p;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatUPCEANReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends k {
    private final p[] a;

    public j(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new e());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new l());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new f());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new q());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new e());
            arrayList.add(new f());
            arrayList.add(new q());
        }
        this.a = (p[]) arrayList.toArray(new p[arrayList.size()]);
    }

    @Override // com.google.zxing.p.k
    public com.google.zxing.h a(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        int[] iArrA = p.a(aVar);
        for (p pVar : this.a) {
            try {
                com.google.zxing.h hVarA = pVar.a(i2, aVar, iArrA, map);
                boolean z2 = hVarA.a() == BarcodeFormat.EAN_13 && hVarA.e().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                boolean z3 = collection == null || collection.contains(BarcodeFormat.UPC_A);
                if (!z2 || !z3) {
                    return hVarA;
                }
                com.google.zxing.h hVar = new com.google.zxing.h(hVarA.e().substring(1), hVarA.b(), hVarA.d(), BarcodeFormat.UPC_A);
                hVar.a(hVarA.c());
                return hVar;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.f();
    }

    @Override // com.google.zxing.p.k, com.google.zxing.g
    public void reset() {
        for (p pVar : this.a) {
            pVar.reset();
        }
    }
}
