package com.bytedance.pangle.res.a;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends j {
    private long a;

    public e(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.bytedance.pangle.res.a.j
    protected final synchronized void a(int i2) {
        if (i2 != -1) {
            this.a += (long) i2;
        }
    }

    public final synchronized long b() {
        return this.a;
    }

    @Override // com.bytedance.pangle.res.a.j, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j2) {
        long jSkip;
        jSkip = super.skip(j2);
        this.a += jSkip;
        return jSkip;
    }

    public final int a() {
        long jB = b();
        if (jB <= 2147483647L) {
            return (int) jB;
        }
        throw new ArithmeticException("The byte count " + jB + " is too large to be converted to an int");
    }
}
