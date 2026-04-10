package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    static final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f a = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String[] f1031c = new String[64];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String[] f1032d = new String[256];

    static {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = f1032d;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr2 = f1031c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i4 : iArr) {
            f1031c[i4 | 8] = f1031c[i4] + "|PADDED";
        }
        String[] strArr3 = f1031c;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        for (int i5 : new int[]{4, 32, 36}) {
            for (int i6 : iArr) {
                int i7 = i6 | i5;
                f1031c[i7] = f1031c[i6] + '|' + f1031c[i5];
                f1031c[i7 | 8] = f1031c[i6] + '|' + f1031c[i5] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = f1031c;
            if (i2 >= strArr4.length) {
                return;
            }
            if (strArr4[i2] == null) {
                strArr4[i2] = f1032d[i2];
            }
            i2++;
        }
    }

    private e() {
    }

    static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, objArr));
    }

    static String a(byte b2, byte b3) {
        String str;
        String str2;
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : f1032d[b3];
            }
            if (b2 != 7 && b2 != 8) {
                String[] strArr = f1031c;
                String str3 = b3 < strArr.length ? strArr[b3] : f1032d[b3];
                if (b2 == 5 && (b3 & 4) != 0) {
                    str = "HEADERS";
                    str2 = "PUSH_PROMISE";
                } else {
                    if (b2 != 0 || (b3 & 32) == 0) {
                        return str3;
                    }
                    str = "PRIORITY";
                    str2 = "COMPRESSED";
                }
                return str3.replace(str, str2);
            }
        }
        return f1032d[b3];
    }

    static String a(boolean z2, int i2, int i3, byte b2, byte b3) {
        String[] strArr = b;
        return bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("%s 0x%08x %5d %-13s %s", z2 ? "<<" : ">>", Integer.valueOf(i2), Integer.valueOf(i3), b2 < strArr.length ? strArr[b2] : bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("0x%02x", Byte.valueOf(b2)), a(b2, b3));
    }

    static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, objArr));
    }
}
