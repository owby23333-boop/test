package com.ss.android.socialbase.appdownloader.vn.e;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class vn {
    private int[] bf;
    private int[] e;

    private vn() {
    }

    public static vn e(tg tgVar) throws IOException {
        bf.e(tgVar, 1835009);
        int iBf = tgVar.bf();
        int iBf2 = tgVar.bf();
        int iBf3 = tgVar.bf();
        tgVar.bf();
        int iBf4 = tgVar.bf();
        int iBf5 = tgVar.bf();
        vn vnVar = new vn();
        vnVar.e = tgVar.bf(iBf2);
        if (iBf3 != 0) {
            tgVar.bf(iBf3);
        }
        int i = (iBf5 == 0 ? iBf : iBf5) - iBf4;
        if (i % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }
        vnVar.bf = tgVar.bf(i / 4);
        if (iBf5 != 0) {
            int i2 = iBf - iBf5;
            if (i2 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
            }
            tgVar.bf(i2 / 4);
        }
        return vnVar;
    }

    public String e(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.e) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int iE = e(this.bf, i2);
        StringBuilder sb = new StringBuilder(iE);
        while (iE != 0) {
            i2 += 2;
            sb.append((char) e(this.bf, i2));
            iE--;
        }
        return sb.toString();
    }

    private static final int e(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }
}
