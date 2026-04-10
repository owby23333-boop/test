package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: AI01AndOtherAIs.java */
/* JADX INFO: loaded from: classes2.dex */
final class g extends h {
    g(com.google.zxing.common.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String c() throws NotFoundException, FormatException {
        StringBuilder sb = new StringBuilder();
        sb.append("(01)");
        int length = sb.length();
        sb.append(a().a(4, 4));
        a(sb, 8, length);
        return a().a(sb, 48);
    }
}
