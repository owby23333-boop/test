package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: AI013x0xDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class f extends i {
    f(com.google.zxing.common.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String c() throws NotFoundException {
        if (b().c() != 60) {
            throw NotFoundException.f();
        }
        StringBuilder sb = new StringBuilder();
        a(sb, 5);
        b(sb, 45, 15);
        return sb.toString();
    }
}
