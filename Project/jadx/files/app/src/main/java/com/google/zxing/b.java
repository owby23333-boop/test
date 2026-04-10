package com.google.zxing;

/* JADX INFO: compiled from: BinaryBitmap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private final a a;
    private com.google.zxing.common.b b;

    public b(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.a = aVar;
    }

    public com.google.zxing.common.a a(int i2, com.google.zxing.common.a aVar) throws NotFoundException {
        return this.a.a(i2, aVar);
    }

    public int b() {
        return this.a.b();
    }

    public int c() {
        return this.a.d();
    }

    public boolean d() {
        return this.a.c().e();
    }

    public b e() {
        return new b(this.a.a(this.a.c().f()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }

    public com.google.zxing.common.b a() throws NotFoundException {
        if (this.b == null) {
            this.b = this.a.a();
        }
        return this.b;
    }
}
