package com.ss.android.socialbase.appdownloader.vn.e;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class tg {
    private boolean bf;
    private int d;
    private InputStream e;

    public tg() {
    }

    public final int bf() throws IOException {
        return e(4);
    }

    public final void d(int i) throws IOException {
        if (i > 0) {
            long j = i;
            long jSkip = this.e.skip(j);
            this.d = (int) (((long) this.d) + jSkip);
            if (jSkip != j) {
                throw new EOFException();
            }
        }
    }

    public final void e(InputStream inputStream, boolean z) {
        this.e = inputStream;
        this.bf = z;
        this.d = 0;
    }

    public tg(InputStream inputStream, boolean z) {
        e(inputStream, z);
    }

    public final int[] bf(int i) throws IOException {
        int[] iArr = new int[i];
        e(iArr, 0, i);
        return iArr;
    }

    public final void d() throws IOException {
        d(4);
    }

    public final void e() {
        InputStream inputStream = this.e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            e(null, false);
        }
    }

    public final int e(int i) throws IOException {
        if (i >= 0 && i <= 4) {
            int i2 = 0;
            if (this.bf) {
                for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                    int i4 = this.e.read();
                    if (i4 == -1) {
                        throw new EOFException();
                    }
                    this.d++;
                    i2 |= i4 << i3;
                }
                return i2;
            }
            int i5 = i * 8;
            int i6 = 0;
            while (i2 != i5) {
                int i7 = this.e.read();
                if (i7 == -1) {
                    throw new EOFException();
                }
                this.d++;
                i6 |= i7 << i2;
                i2 += 8;
            }
            return i6;
        }
        throw new IllegalArgumentException();
    }

    public final void e(int[] iArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            iArr[i] = bf();
            i2--;
            i++;
        }
    }
}
