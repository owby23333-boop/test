package com.ss.android.socialbase.appdownloader.m.z;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private int dl;
    private boolean g;
    private InputStream z;

    public a() {
    }

    public a(InputStream inputStream, boolean z) {
        z(inputStream, z);
    }

    public final void z(InputStream inputStream, boolean z) {
        this.z = inputStream;
        this.g = z;
        this.dl = 0;
    }

    public final void z() {
        InputStream inputStream = this.z;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            z(null, false);
        }
    }

    public final int g() throws IOException {
        return z(4);
    }

    public final int z(int i) throws IOException {
        if (i >= 0 && i <= 4) {
            int i2 = 0;
            if (this.g) {
                for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                    int i4 = this.z.read();
                    if (i4 == -1) {
                        throw new EOFException();
                    }
                    this.dl++;
                    i2 |= i4 << i3;
                }
                return i2;
            }
            int i5 = i * 8;
            int i6 = 0;
            while (i2 != i5) {
                int i7 = this.z.read();
                if (i7 == -1) {
                    throw new EOFException();
                }
                this.dl++;
                i6 |= i7 << i2;
                i2 += 8;
            }
            return i6;
        }
        throw new IllegalArgumentException();
    }

    public final int[] g(int i) throws IOException {
        int[] iArr = new int[i];
        z(iArr, 0, i);
        return iArr;
    }

    public final void z(int[] iArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            iArr[i] = g();
            i2--;
            i++;
        }
    }

    public final void dl(int i) throws IOException {
        if (i > 0) {
            long j = i;
            long jSkip = this.z.skip(j);
            this.dl = (int) (((long) this.dl) + jSkip);
            if (jSkip != j) {
                throw new EOFException();
            }
        }
    }

    public final void dl() throws IOException {
        dl(4);
    }
}
