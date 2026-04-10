package com.anythink.expressad.exoplayer.l;

import com.anythink.expressad.exoplayer.k.p;
import com.anythink.expressad.exoplayer.k.s;
import com.anythink.expressad.exoplayer.t;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public final List<byte[]> a;
    public final int b;

    private d(List<byte[]> list, int i2) {
        this.a = list;
        this.b = i2;
    }

    public static d a(s sVar) throws t {
        try {
            sVar.d(21);
            int iD = sVar.d() & 3;
            int iD2 = sVar.d();
            int iC = sVar.c();
            int i2 = 0;
            int i3 = 0;
            while (i2 < iD2) {
                sVar.d(1);
                int iE = sVar.e();
                int i4 = i3;
                for (int i5 = 0; i5 < iE; i5++) {
                    int iE2 = sVar.e();
                    i4 += iE2 + 4;
                    sVar.d(iE2);
                }
                i2++;
                i3 = i4;
            }
            sVar.c(iC);
            byte[] bArr = new byte[i3];
            int i6 = 0;
            int i7 = 0;
            while (i6 < iD2) {
                sVar.d(1);
                int iE3 = sVar.e();
                int i8 = i7;
                for (int i9 = 0; i9 < iE3; i9++) {
                    int iE4 = sVar.e();
                    System.arraycopy(p.a, 0, bArr, i8, p.a.length);
                    int length = i8 + p.a.length;
                    System.arraycopy(sVar.a, sVar.c(), bArr, length, iE4);
                    i8 = length + iE4;
                    sVar.d(iE4);
                }
                i6++;
                i7 = i8;
            }
            return new d(i3 == 0 ? null : Collections.singletonList(bArr), iD + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new t("Error parsing HEVC config", e2);
        }
    }
}
