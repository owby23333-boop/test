package com.google.zxing.p;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* JADX INFO: compiled from: UPCAReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final p f16248h = new e();

    @Override // com.google.zxing.p.p
    public com.google.zxing.h a(int i2, com.google.zxing.common.a aVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return a(this.f16248h.a(i2, aVar, iArr, map));
    }

    @Override // com.google.zxing.p.p, com.google.zxing.p.k
    public com.google.zxing.h a(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return a(this.f16248h.a(i2, aVar, map));
    }

    @Override // com.google.zxing.p.k, com.google.zxing.g
    public com.google.zxing.h a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return a(this.f16248h.a(bVar, map));
    }

    @Override // com.google.zxing.p.p
    BarcodeFormat a() {
        return BarcodeFormat.UPC_A;
    }

    @Override // com.google.zxing.p.p
    protected int a(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.f16248h.a(aVar, iArr, sb);
    }

    private static com.google.zxing.h a(com.google.zxing.h hVar) throws FormatException {
        String strE = hVar.e();
        if (strE.charAt(0) == '0') {
            com.google.zxing.h hVar2 = new com.google.zxing.h(strE.substring(1), null, hVar.d(), BarcodeFormat.UPC_A);
            if (hVar.c() != null) {
                hVar2.a(hVar.c());
            }
            return hVar2;
        }
        throw FormatException.f();
    }
}
