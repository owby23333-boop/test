package com.google.zxing;

/* JADX INFO: compiled from: Binarizer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    private final d a;

    protected a(d dVar) {
        this.a = dVar;
    }

    public abstract a a(d dVar);

    public abstract com.google.zxing.common.a a(int i2, com.google.zxing.common.a aVar) throws NotFoundException;

    public abstract com.google.zxing.common.b a() throws NotFoundException;

    public final int b() {
        return this.a.a();
    }

    public final d c() {
        return this.a;
    }

    public final int d() {
        return this.a.c();
    }
}
