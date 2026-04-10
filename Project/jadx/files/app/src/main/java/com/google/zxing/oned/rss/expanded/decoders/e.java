package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: AI013x0x1xDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
final class e extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16224d;

    e(com.google.zxing.common.a aVar, String str, String str2) {
        super(aVar);
        this.f16223c = str2;
        this.f16224d = str;
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected int a(int i2) {
        return i2 % 100000;
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected void b(StringBuilder sb, int i2) {
        sb.append('(');
        sb.append(this.f16224d);
        sb.append(i2 / 100000);
        sb.append(')');
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String c() throws NotFoundException {
        if (b().c() != 84) {
            throw NotFoundException.f();
        }
        StringBuilder sb = new StringBuilder();
        a(sb, 8);
        b(sb, 48, 20);
        c(sb, 68);
        return sb.toString();
    }

    private void c(StringBuilder sb, int i2) {
        int iA = a().a(i2, 16);
        if (iA == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f16223c);
        sb.append(')');
        int i3 = iA % 32;
        int i4 = iA / 32;
        int i5 = (i4 % 12) + 1;
        int i6 = i4 / 12;
        if (i6 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i6);
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i3 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i3);
    }
}
