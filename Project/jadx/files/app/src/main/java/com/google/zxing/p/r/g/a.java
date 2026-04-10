package com.google.zxing.p.r.g;

import java.util.List;

/* JADX INFO: compiled from: BitArrayBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
final class a {
    static com.google.zxing.common.a a(List<b> list) {
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).c() == null) {
            size--;
        }
        com.google.zxing.common.a aVar = new com.google.zxing.common.a(size * 12);
        int iB = list.get(0).c().b();
        int i2 = 0;
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & iB) != 0) {
                aVar.d(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            b bVar = list.get(i4);
            int iB2 = bVar.b().b();
            int i5 = i2;
            for (int i6 = 11; i6 >= 0; i6--) {
                if (((1 << i6) & iB2) != 0) {
                    aVar.d(i5);
                }
                i5++;
            }
            if (bVar.c() != null) {
                int iB3 = bVar.c().b();
                for (int i7 = 11; i7 >= 0; i7--) {
                    if (((1 << i7) & iB3) != 0) {
                        aVar.d(i5);
                    }
                    i5++;
                }
            }
            i2 = i5;
        }
        return aVar;
    }
}
