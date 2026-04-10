package com.ss.android.socialbase.appdownloader.u.mb;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class hj {
    private int b;
    private InputStream mb;
    private boolean ox;

    public hj() {
    }

    public final void b(int i2) throws IOException {
        if (i2 > 0) {
            long j2 = i2;
            long jSkip = this.mb.skip(j2);
            this.b = (int) (((long) this.b) + jSkip);
            if (jSkip != j2) {
                throw new EOFException();
            }
        }
    }

    public final void mb(InputStream inputStream, boolean z2) {
        this.mb = inputStream;
        this.ox = z2;
        this.b = 0;
    }

    public final int ox() throws IOException {
        return mb(4);
    }

    public hj(InputStream inputStream, boolean z2) {
        mb(inputStream, z2);
    }

    public final int[] ox(int i2) throws IOException {
        int[] iArr = new int[i2];
        mb(iArr, 0, i2);
        return iArr;
    }

    public final void b() throws IOException {
        b(4);
    }

    public final void mb() {
        InputStream inputStream = this.mb;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            mb(null, false);
        }
    }

    public final int mb(int i2) throws IOException {
        if (i2 >= 0 && i2 <= 4) {
            int i3 = 0;
            if (this.ox) {
                for (int i4 = (i2 - 1) * 8; i4 >= 0; i4 -= 8) {
                    int i5 = this.mb.read();
                    if (i5 == -1) {
                        throw new EOFException();
                    }
                    this.b++;
                    i3 |= i5 << i4;
                }
                return i3;
            }
            int i6 = i2 * 8;
            int i7 = 0;
            while (i3 != i6) {
                int i8 = this.mb.read();
                if (i8 == -1) {
                    throw new EOFException();
                }
                this.b++;
                i7 |= i8 << i3;
                i3 += 8;
            }
            return i7;
        }
        throw new IllegalArgumentException();
    }

    public final void mb(int[] iArr, int i2, int i3) throws IOException {
        while (i3 > 0) {
            iArr[i2] = ox();
            i3--;
            i2++;
        }
    }
}
