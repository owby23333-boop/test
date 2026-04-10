package com.google.zxing.p;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;

/* JADX INFO: compiled from: UPCEANExtensionSupport.java */
/* JADX INFO: loaded from: classes2.dex */
final class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f16250c = {1, 1, 2};
    private final m a = new m();
    private final n b = new n();

    o() {
    }

    com.google.zxing.h a(int i2, com.google.zxing.common.a aVar, int i3) throws NotFoundException {
        int[] iArrA = p.a(aVar, i3, false, f16250c);
        try {
            return this.b.a(i2, aVar, iArrA);
        } catch (ReaderException unused) {
            return this.a.a(i2, aVar, iArrA);
        }
    }
}
