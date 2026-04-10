package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    private static final byte[] a;
    private static final byte[] b;

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = bArr[i2 >>> 4];
            bArr3[i2] = bArr[i2 & 15];
        }
        a = bArr2;
        b = bArr3;
    }

    public static boolean a(int i2, int i3) {
        return i2 == i3;
    }

    public static boolean a(long j2, long j3) {
        return j2 == j3;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static boolean a(boolean z2, boolean z3) {
        return z2 == z3;
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, bArr.length);
        return bArr;
    }
}
