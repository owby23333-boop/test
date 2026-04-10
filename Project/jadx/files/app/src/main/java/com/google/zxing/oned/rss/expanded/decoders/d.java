package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: AI01393xDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
final class d extends h {
    d(com.google.zxing.common.a aVar) {
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
        sb.append("(393");
        sb.append(iA);
        sb.append(')');
        int iA2 = a().a(50, 10);
        if (iA2 / 100 == 0) {
            sb.append('0');
        }
        if (iA2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(iA2);
        sb.append(a().a(60, (String) null).b());
        return sb.toString();
    }
}
