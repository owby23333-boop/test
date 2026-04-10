package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReedSolomonEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private final a a;
    private final List<b> b = new ArrayList();

    public d(a aVar) {
        this.a = aVar;
        this.b.add(new b(aVar, new int[]{1}));
    }

    private b a(int i2) {
        if (i2 >= this.b.size()) {
            List<b> list = this.b;
            b bVarC = list.get(list.size() - 1);
            for (int size = this.b.size(); size <= i2; size++) {
                a aVar = this.a;
                bVarC = bVarC.c(new b(aVar, new int[]{1, aVar.a((size - 1) + aVar.a())}));
                this.b.add(bVarC);
            }
        }
        return this.b.get(i2);
    }

    public void a(int[] iArr, int i2) {
        if (i2 != 0) {
            int length = iArr.length - i2;
            if (length > 0) {
                b bVarA = a(i2);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] iArrA = new b(this.a, iArr2).a(i2, 1).b(bVarA)[1].a();
                int length2 = i2 - iArrA.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr[length + i3] = 0;
                }
                System.arraycopy(iArrA, 0, iArr, length + length2, iArrA.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
