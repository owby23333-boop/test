package com.ss.android.socialbase.appdownloader.u.mb;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class u {
    private int[] mb;
    private int[] ox;

    private u() {
    }

    public static u mb(hj hjVar) throws IOException {
        ox.mb(hjVar, 1835009);
        int iOx = hjVar.ox();
        int iOx2 = hjVar.ox();
        int iOx3 = hjVar.ox();
        hjVar.ox();
        int iOx4 = hjVar.ox();
        int iOx5 = hjVar.ox();
        u uVar = new u();
        uVar.mb = hjVar.ox(iOx2);
        if (iOx3 != 0) {
            hjVar.ox(iOx3);
        }
        int i2 = (iOx5 == 0 ? iOx : iOx5) - iOx4;
        if (i2 % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i2 + ").");
        }
        uVar.ox = hjVar.ox(i2 / 4);
        if (iOx5 != 0) {
            int i3 = iOx - iOx5;
            if (i3 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i3 + ").");
            }
            hjVar.ox(i3 / 4);
        }
        return uVar;
    }

    public String mb(int i2) {
        int[] iArr;
        if (i2 < 0 || (iArr = this.mb) == null || i2 >= iArr.length) {
            return null;
        }
        int i3 = iArr[i2];
        int iMb = mb(this.ox, i3);
        StringBuilder sb = new StringBuilder(iMb);
        while (iMb != 0) {
            i3 += 2;
            sb.append((char) mb(this.ox, i3));
            iMb--;
        }
        return sb.toString();
    }

    private static final int mb(int[] iArr, int i2) {
        int i3 = iArr[i2 / 4];
        return (i2 % 4) / 2 == 0 ? i3 & 65535 : i3 >>> 16;
    }
}
