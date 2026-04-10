package com.bytedance.pangle.e.z;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private int[] g;
    private int[] z;

    public static m z(g gVar) throws IOException {
        gVar.g(1835009);
        int iG = gVar.g();
        int iG2 = gVar.g();
        int iG3 = gVar.g();
        gVar.g();
        int iG4 = gVar.g();
        int iG5 = gVar.g();
        m mVar = new m();
        mVar.z = gVar.z(iG2);
        if (iG3 != 0) {
            gVar.z(iG3);
        }
        int i = (iG5 == 0 ? iG : iG5) - iG4;
        if (i % 4 == 0) {
            mVar.g = gVar.z(i / 4);
            if (iG5 != 0) {
                int i2 = iG - iG5;
                if (i2 % 4 == 0) {
                    gVar.z(i2 / 4);
                } else {
                    throw new IOException();
                }
            }
            return mVar;
        }
        throw new IOException();
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
