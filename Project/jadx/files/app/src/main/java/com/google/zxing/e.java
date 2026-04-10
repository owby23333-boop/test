package com.google.zxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements g {
    private Map<DecodeHintType, ?> a;
    private g[] b;

    private h b(b bVar) throws NotFoundException {
        g[] gVarArr = this.b;
        if (gVarArr != null) {
            for (g gVar : gVarArr) {
                try {
                    return gVar.a(bVar, this.a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.f();
    }

    @Override // com.google.zxing.g
    public h a(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        a(map);
        return b(bVar);
    }

    @Override // com.google.zxing.g
    public void reset() {
        g[] gVarArr = this.b;
        if (gVarArr != null) {
            for (g gVar : gVarArr) {
                gVar.reset();
            }
        }
    }

    public h a(b bVar) throws NotFoundException {
        if (this.b == null) {
            a((Map<DecodeHintType, ?>) null);
        }
        return b(bVar);
    }

    public void a(Map<DecodeHintType, ?> map) {
        this.a = map;
        boolean z2 = true;
        boolean z3 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(BarcodeFormat.UPC_A) && !collection.contains(BarcodeFormat.UPC_E) && !collection.contains(BarcodeFormat.EAN_13) && !collection.contains(BarcodeFormat.EAN_8) && !collection.contains(BarcodeFormat.CODABAR) && !collection.contains(BarcodeFormat.CODE_39) && !collection.contains(BarcodeFormat.CODE_93) && !collection.contains(BarcodeFormat.CODE_128) && !collection.contains(BarcodeFormat.ITF) && !collection.contains(BarcodeFormat.RSS_14) && !collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                z2 = false;
            }
            if (z2 && !z3) {
                arrayList.add(new com.google.zxing.p.i(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new com.google.zxing.r.a());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new com.google.zxing.m.a());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new com.google.zxing.l.b());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new com.google.zxing.q.b());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new com.google.zxing.n.a());
            }
            if (z2 && z3) {
                arrayList.add(new com.google.zxing.p.i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z3) {
                arrayList.add(new com.google.zxing.p.i(map));
            }
            arrayList.add(new com.google.zxing.r.a());
            arrayList.add(new com.google.zxing.m.a());
            arrayList.add(new com.google.zxing.l.b());
            arrayList.add(new com.google.zxing.q.b());
            arrayList.add(new com.google.zxing.n.a());
            if (z3) {
                arrayList.add(new com.google.zxing.p.i(map));
            }
        }
        this.b = (g[]) arrayList.toArray(new g[arrayList.size()]);
    }
}
