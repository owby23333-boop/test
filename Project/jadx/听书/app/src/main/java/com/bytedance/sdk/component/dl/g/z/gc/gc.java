package com.bytedance.sdk.component.dl.g.z.gc;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class gc {
    static final com.bytedance.sdk.component.dl.z.m z = com.bytedance.sdk.component.dl.z.m.z("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f679a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] g = new String[64];
    static final String[] dl = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = dl;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = com.bytedance.sdk.component.dl.g.z.dl.z("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = g;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 <= 0; i3++) {
            int i4 = iArr[i3];
            String[] strArr3 = g;
            strArr3[i4 | 8] = strArr3[i4] + "|PADDED";
        }
        String[] strArr4 = g;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 <= 0; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = g;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                strArr5[i9 | 8] = strArr5[i8] + '|' + strArr5[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = g;
            if (i >= strArr6.length) {
                return;
            }
            if (strArr6[i] == null) {
                strArr6[i] = dl[i];
            }
            i++;
        }
    }

    private gc() {
    }

    static IllegalArgumentException z(String str, Object... objArr) {
        throw new IllegalArgumentException(com.bytedance.sdk.component.dl.g.z.dl.z(str, objArr));
    }

    static IOException g(String str, Object... objArr) throws IOException {
        throw new IOException(com.bytedance.sdk.component.dl.g.z.dl.z(str, objArr));
    }

    static String z(boolean z2, int i, int i2, byte b, byte b2) {
        String[] strArr = f679a;
        String strZ = b < strArr.length ? strArr[b] : com.bytedance.sdk.component.dl.g.z.dl.z("0x%02x", Byte.valueOf(b));
        String strZ2 = z(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z2 ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = strZ;
        objArr[4] = strZ2;
        return com.bytedance.sdk.component.dl.g.z.dl.z("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String z(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (b != 2 && b != 3) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : dl[b2];
            }
            if (b != 7 && b != 8) {
                String[] strArr = g;
                String str = b2 < strArr.length ? strArr[b2] : dl[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return dl[b2];
    }
}
