package com.anythink.core.common.k;

import com.umeng.analytics.pro.cb;

/* JADX INFO: loaded from: classes2.dex */
final class k {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private k() {
    }

    private static char[] a(byte[] bArr, boolean z2) {
        return a(bArr, z2 ? b : a);
    }

    private static char[] b(byte[] bArr) {
        return a(bArr, false);
    }

    private static char[] a(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            cArr2[i2] = cArr[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr2[i4] = cArr[bArr[i3] & cb.f19604m];
        }
        return cArr2;
    }

    public static String a(byte[] bArr) {
        return new String(a(bArr, true));
    }
}
