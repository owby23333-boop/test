package com.google.zxing.qrcode.decoder;

/* JADX INFO: compiled from: FormatInformation.java */
/* JADX INFO: loaded from: classes2.dex */
final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[][] f16343c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};
    private final ErrorCorrectionLevel a;
    private final byte b;

    private e(int i2) {
        this.a = ErrorCorrectionLevel.b((i2 >> 3) & 3);
        this.b = (byte) (i2 & 7);
    }

    static e a(int i2, int i3) {
        e eVarB = b(i2, i3);
        return eVarB != null ? eVarB : b(i2 ^ 21522, i3 ^ 21522);
    }

    private static e b(int i2, int i3) {
        int iC;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        for (int[] iArr : f16343c) {
            int i6 = iArr[0];
            if (i6 == i2 || i6 == i3) {
                return new e(iArr[1]);
            }
            int iC2 = c(i2, i6);
            if (iC2 < i4) {
                i5 = iArr[1];
                i4 = iC2;
            }
            if (i2 != i3 && (iC = c(i3, i6)) < i4) {
                i5 = iArr[1];
                i4 = iC;
            }
        }
        if (i4 <= 3) {
            return new e(i5);
        }
        return null;
    }

    static int c(int i2, int i3) {
        return Integer.bitCount(i2 ^ i3);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b == eVar.b;
    }

    public int hashCode() {
        return (this.a.ordinal() << 3) | this.b;
    }

    byte a() {
        return this.b;
    }

    ErrorCorrectionLevel b() {
        return this.a;
    }
}
