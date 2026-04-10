package com.bytedance.sdk.component.dl.z;

import java.nio.charset.Charset;
import kotlin.UShort;

/* JADX INFO: loaded from: classes2.dex */
final class q {
    public static final Charset z = Charset.forName("UTF-8");

    public static int z(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static short z(short s) {
        int i = s & UShort.MAX_VALUE;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    public static void z(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static void z(Throwable th) throws Throwable {
        g(th);
    }

    private static <T extends Throwable> void g(Throwable th) throws Throwable {
        throw th;
    }

    public static boolean z(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
