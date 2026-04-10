package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: AI01392xDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
final class c extends h {
    c(com.google.zxing.common.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String c() throws NotFoundException, FormatException {
        if (b().c() < 48) {
            throw NotFoundException.f();
        }
        StringBuilder sb = new StringBuilder();
        a(sb, 8);
        int iA = a().a(48, 2);
        sb.append("(392");
        sb.append(iA);
        sb.append(')');
        sb.append(a().a(50, (String) null).b());
        return sb.toString();
    }
}
