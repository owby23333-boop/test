package com.bytedance.sdk.component.adexpress.a;

import com.bytedance.sdk.component.utils.wp;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static final byte[] z = {-119, 80, 78, 71, 13, 10, Ascii.SUB, 10};
    private static final byte[] g = {97, 99, 84, 76};

    public static boolean z(byte[] bArr) {
        try {
            if (!z(bArr, z)) {
                return false;
            }
            int i = 8;
            while (i >= 0) {
                if (i + 12 > bArr.length) {
                    break;
                }
                int iZ = z(bArr, i);
                int i2 = i + 4;
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArr, i2, bArr2, 0, 4);
                int i3 = i2 + 4;
                if (Arrays.equals(bArr2, g)) {
                    return true;
                }
                i = i3 + iZ + 4;
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        return false;
    }

    private static boolean z(byte[] bArr, byte[] bArr2) {
        if (bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int z(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
