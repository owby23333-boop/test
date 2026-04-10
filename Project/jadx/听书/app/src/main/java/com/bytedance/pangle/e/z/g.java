package com.bytedance.pangle.e.z;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private int g;
    private InputStream z;

    public g(InputStream inputStream) {
        z(inputStream);
    }

    public final void z(InputStream inputStream) {
        this.z = inputStream;
        this.g = 0;
    }

    public final void z() {
        InputStream inputStream = this.z;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            z((InputStream) null);
        }
    }

    public final int g() throws IOException {
        int i = 0;
        for (int i2 = 0; i2 != 32; i2 += 8) {
            int i3 = this.z.read();
            if (i3 == -1) {
                throw new EOFException();
            }
            this.g++;
            i |= i3 << i2;
        }
        return i;
    }

    public final int[] z(int i) throws IOException {
        int[] iArr = new int[i];
        int i2 = 0;
        while (i > 0) {
            iArr[i2] = g();
            i--;
            i2++;
        }
        return iArr;
    }

    public final void dl() throws IOException {
        long jSkip = this.z.skip(4L);
        this.g = (int) (((long) this.g) + jSkip);
        if (jSkip != 4) {
            throw new EOFException();
        }
    }

    public void g(int i) throws IOException {
        int iG = g();
        if (iG != i) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i), Integer.valueOf(iG)));
        }
    }
}
