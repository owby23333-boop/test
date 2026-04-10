package com.bytedance.pangle.res.z;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends uy {
    private long z;

    public gc(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.bytedance.pangle.res.z.uy, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        long jSkip;
        jSkip = super.skip(j);
        this.z += jSkip;
        return jSkip;
    }

    @Override // com.bytedance.pangle.res.z.uy
    protected synchronized void z(int i) {
        if (i != -1) {
            this.z += (long) i;
        }
    }

    public int z() {
        long jG = g();
        if (jG <= 2147483647L) {
            return (int) jG;
        }
        throw new ArithmeticException("The byte count " + jG + " is too large to be converted to an int");
    }

    public synchronized long g() {
        return this.z;
    }
}
