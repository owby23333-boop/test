package com.kwad.components.core.d.kwai;

import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private final int[] IH;

    private c(int[] iArr) {
        this.IH = iArr;
    }

    private static long a(int i2, int[] iArr, long j2) {
        long j3 = j2 >>> 48;
        long j4 = (j2 >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = (j2 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long jE = ((j2 & WebSocketProtocol.PAYLOAD_SHORT_MAX) ^ e(i2, iArr, j3)) ^ ((long) (i2 + 1));
        return (e(i2, iArr, j3) << 32) | (jE << 48) | (j4 << 16) | j5;
    }

    private static long a(long j2, int[] iArr) {
        int i2 = 0;
        while (i2 < 8) {
            j2 = a(i2, iArr, j2);
            i2++;
        }
        while (i2 < 16) {
            j2 = b(i2, iArr, j2);
            i2++;
        }
        while (i2 < 24) {
            j2 = a(i2, iArr, j2);
            i2++;
        }
        while (i2 < 32) {
            j2 = b(i2, iArr, j2);
            i2++;
        }
        return j2;
    }

    public static c a(int[] iArr) {
        return new c(iArr);
    }

    private static long b(int i2, int[] iArr, long j2) {
        long j3 = j2 >>> 48;
        long j4 = (j2 >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = (j2 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j6 = j2 & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long jE = e(i2, iArr, j3);
        return ((((long) (i2 + 1)) ^ (j3 ^ j4)) << 16) | (j6 << 48) | (jE << 32) | j5;
    }

    private static long b(long j2, int[] iArr) {
        int i2 = 31;
        while (i2 > 23) {
            j2 = d(i2, iArr, j2);
            i2--;
        }
        while (i2 > 15) {
            j2 = c(i2, iArr, j2);
            i2--;
        }
        while (i2 > 7) {
            j2 = d(i2, iArr, j2);
            i2--;
        }
        while (i2 >= 0) {
            j2 = c(i2, iArr, j2);
            i2--;
        }
        return j2;
    }

    private static long c(int i2, int[] iArr, long j2) {
        long j3 = j2 >>> 48;
        long j4 = (j2 >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = (j2 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j6 = j2 & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long jF = f(i2, iArr, j4);
        return (((long) (i2 + 1)) ^ (j3 ^ j4)) | (j6 << 16) | (jF << 48) | (j5 << 32);
    }

    private static long d(int i2, int[] iArr, long j2) {
        long j3 = j2 >>> 48;
        long j4 = (j2 >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = (j2 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j6 = j2 & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long jF = f(i2, iArr, j4);
        return ((((long) (i2 + 1)) ^ (f(i2, iArr, j4) ^ j5)) << 32) | (jF << 48) | (j6 << 16) | j3;
    }

    private static long e(int i2, int[] iArr, long j2) {
        int i3 = (int) (j2 >>> 8);
        int i4 = (int) (j2 & 255);
        int i5 = i2 * 4;
        int i6 = iArr[i5 % 10];
        int i7 = iArr[(i5 + 1) % 10];
        int i8 = iArr[(i5 + 2) % 10];
        int i9 = iArr[(i5 + 3) % 10];
        int[] iArr2 = b.IG;
        int i10 = iArr2[i6 ^ i4] ^ i3;
        int i11 = i4 ^ iArr2[i7 ^ i10];
        int i12 = i10 ^ iArr2[i11 ^ i8];
        return (((long) i12) << 8) | ((long) (iArr2[i9 ^ i12] ^ i11));
    }

    private static long f(int i2, int[] iArr, long j2) {
        int i3 = (int) (255 & j2);
        int i4 = (int) (j2 >>> 8);
        int i5 = i2 * 4;
        int i6 = iArr[(i5 + 3) % 10];
        int i7 = iArr[(i5 + 2) % 10];
        int i8 = iArr[(i5 + 1) % 10];
        int i9 = iArr[i5 % 10];
        int[] iArr2 = b.IG;
        int i10 = iArr2[i6 ^ i4] ^ i3;
        int i11 = i4 ^ iArr2[i10 ^ i7];
        int i12 = i10 ^ iArr2[i11 ^ i8];
        return (((long) (iArr2[i9 ^ i12] ^ i11)) << 8) | ((long) i12);
    }

    public final long ak(String str) {
        byte[] bArrDecode = com.kwad.sdk.core.kwai.c.vW().decode(str);
        if (bArrDecode != null && bArrDecode.length == 8) {
            return b(ByteBuffer.wrap(bArrDecode).getLong(), this.IH);
        }
        throw new RuntimeException("fail to decode: " + str);
    }

    public final String p(long j2) {
        return com.kwad.sdk.core.kwai.c.vU().encodeToString(ByteBuffer.allocate(8).putLong(a(j2, this.IH)).array());
    }
}
