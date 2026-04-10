package com.bytedance.sdk.component.d.bf.e.ga;

import com.dangdang.reader.utils.DangdangFileManager;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class ga {
    static final com.bytedance.sdk.component.d.e.vn e = com.bytedance.sdk.component.d.e.vn.e("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] tg = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] bf = new String[64];
    static final String[] d = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = d;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = com.bytedance.sdk.component.d.bf.e.d.e("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = bf;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        strArr2[1 | 8] = strArr2[1] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr2[i3];
            int i5 = iArr[0];
            String[] strArr3 = bf;
            int i6 = i5 | i4;
            strArr3[i6] = strArr3[i5] + DangdangFileManager.DELI + strArr3[i4];
            strArr3[i6 | 8] = strArr3[i5] + DangdangFileManager.DELI + strArr3[i4] + "|PADDED";
        }
        while (true) {
            String[] strArr4 = bf;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = d[i];
            }
            i++;
        }
    }

    private ga() {
    }

    public static IOException bf(String str, Object... objArr) throws IOException {
        throw new IOException(com.bytedance.sdk.component.d.bf.e.d.e(str, objArr));
    }

    public static IllegalArgumentException e(String str, Object... objArr) {
        throw new IllegalArgumentException(com.bytedance.sdk.component.d.bf.e.d.e(str, objArr));
    }

    public static String e(boolean z, int i, int i2, byte b2, byte b3) {
        String[] strArr = tg;
        String strE = b2 < strArr.length ? strArr[b2] : com.bytedance.sdk.component.d.bf.e.d.e("0x%02x", Byte.valueOf(b2));
        String strE2 = e(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = strE;
        objArr[4] = strE2;
        return com.bytedance.sdk.component.d.bf.e.d.e("%s 0x%08x %5d %-13s %s", objArr);
    }

    public static String e(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : d[b3];
            }
            if (b2 != 7 && b2 != 8) {
                String[] strArr = bf;
                String str = b3 < strArr.length ? strArr[b3] : d[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return d[b3];
    }
}
