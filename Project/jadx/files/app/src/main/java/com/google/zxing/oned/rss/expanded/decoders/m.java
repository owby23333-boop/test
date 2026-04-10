package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: DecodedChar.java */
/* JADX INFO: loaded from: classes2.dex */
final class m extends p {
    private final char b;

    m(int i2, char c2) {
        super(i2);
        this.b = c2;
    }

    char b() {
        return this.b;
    }

    boolean c() {
        return this.b == '$';
    }
}
