package com.yuewen;

/* JADX INFO: loaded from: classes12.dex */
public abstract class ib1 extends uo1 implements hb1 {
    public final int[] u(int i) {
        int groupCount = getGroupCount();
        int i2 = 0;
        while (i2 < groupCount) {
            int iA = a(i2);
            if (i < iA) {
                break;
            }
            i -= iA;
            i2++;
        }
        return new int[]{i2, i};
    }

    public final int v(int i, int i2) {
        for (int i3 = 0; i3 <= i - 1; i3++) {
            i2 += a(i3);
        }
        return i2;
    }
}
