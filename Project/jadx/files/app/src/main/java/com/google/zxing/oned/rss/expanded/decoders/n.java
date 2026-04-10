package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: DecodedInformation.java */
/* JADX INFO: loaded from: classes2.dex */
final class n extends p {
    private final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f16226d;

    n(int i2, String str) {
        super(i2);
        this.b = str;
        this.f16226d = false;
        this.f16225c = 0;
    }

    String b() {
        return this.b;
    }

    int c() {
        return this.f16225c;
    }

    boolean d() {
        return this.f16226d;
    }

    n(int i2, String str, int i3) {
        super(i2);
        this.f16226d = true;
        this.f16225c = i3;
        this.b = str;
    }
}
