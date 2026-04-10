package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes2.dex */
public enum Mode {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);


    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int[] f16339s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f16340t;

    Mode(int[] iArr, int i2) {
        this.f16339s = iArr;
        this.f16340t = i2;
    }

    public static Mode b(int i2) {
        if (i2 == 0) {
            return TERMINATOR;
        }
        if (i2 == 1) {
            return NUMERIC;
        }
        if (i2 == 2) {
            return ALPHANUMERIC;
        }
        if (i2 == 3) {
            return STRUCTURED_APPEND;
        }
        if (i2 == 4) {
            return BYTE;
        }
        if (i2 == 5) {
            return FNC1_FIRST_POSITION;
        }
        if (i2 == 7) {
            return ECI;
        }
        if (i2 == 8) {
            return KANJI;
        }
        if (i2 == 9) {
            return FNC1_SECOND_POSITION;
        }
        if (i2 == 13) {
            return HANZI;
        }
        throw new IllegalArgumentException();
    }

    public int a(g gVar) {
        int iE = gVar.e();
        return this.f16339s[iE <= 9 ? (char) 0 : iE <= 26 ? (char) 1 : (char) 2];
    }

    public int f() {
        return this.f16340t;
    }
}
