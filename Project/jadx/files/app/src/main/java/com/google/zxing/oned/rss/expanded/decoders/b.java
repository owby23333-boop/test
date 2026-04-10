package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: AI01320xDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends f {
    b(com.google.zxing.common.a aVar) {
        super(aVar);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected int a(int i2) {
        return i2 < 10000 ? i2 : i2 - 10000;
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected void b(StringBuilder sb, int i2) {
        if (i2 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}
