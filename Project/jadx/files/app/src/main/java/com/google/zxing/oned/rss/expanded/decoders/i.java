package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: AI01weightDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class i extends h {
    i(com.google.zxing.common.a aVar) {
        super(aVar);
    }

    protected abstract int a(int i2);

    protected abstract void b(StringBuilder sb, int i2);

    final void b(StringBuilder sb, int i2, int i3) {
        int iA = a().a(i2, i3);
        b(sb, iA);
        int iA2 = a(iA);
        int i4 = 100000;
        for (int i5 = 0; i5 < 5; i5++) {
            if (iA2 / i4 == 0) {
                sb.append('0');
            }
            i4 /= 10;
        }
        sb.append(iA2);
    }
}
