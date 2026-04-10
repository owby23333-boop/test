package com.ss.android.socialbase.appdownloader.m.z;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class m {
    private int[] g;
    private int[] z;

    public static m z(a aVar) throws IOException {
        g.z(aVar, 1835009);
        int iG = aVar.g();
        int iG2 = aVar.g();
        int iG3 = aVar.g();
        aVar.g();
        int iG4 = aVar.g();
        int iG5 = aVar.g();
        m mVar = new m();
        mVar.z = aVar.g(iG2);
        if (iG3 != 0) {
            aVar.g(iG3);
        }
        int i = (iG5 == 0 ? iG : iG5) - iG4;
        if (i % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }
        mVar.g = aVar.g(i / 4);
        if (iG5 != 0) {
            int i2 = iG - iG5;
            if (i2 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
            }
            aVar.g(i2 / 4);
        }
        return mVar;
    }

    public String z(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.z) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int iZ = z(this.g, i2);
        StringBuilder sb = new StringBuilder(iZ);
        while (iZ != 0) {
            i2 += 2;
            sb.append((char) z(this.g, i2));
            iZ--;
        }
        return sb.toString();
    }

    private m() {
    }

    private static final int z(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }
}
