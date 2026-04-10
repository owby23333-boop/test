package com.bytedance.pangle.f.a;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    int[] a;
    int[] b;

    f() {
    }

    public final String a(int i2) {
        int[] iArr;
        if (i2 < 0 || (iArr = this.a) == null || i2 >= iArr.length) {
            return null;
        }
        int i3 = iArr[i2];
        int iA = a(this.b, i3);
        StringBuilder sb = new StringBuilder(iA);
        while (iA != 0) {
            i3 += 2;
            sb.append((char) a(this.b, i3));
            iA--;
        }
        return sb.toString();
    }

    private static final int a(int[] iArr, int i2) {
        int i3 = iArr[i2 / 4];
        return (i2 % 4) / 2 == 0 ? i3 & 65535 : i3 >>> 16;
    }
}
