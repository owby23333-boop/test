package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes2.dex */
public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final ErrorCorrectionLevel[] f16330x;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f16332s;

    static {
        ErrorCorrectionLevel errorCorrectionLevel = L;
        ErrorCorrectionLevel errorCorrectionLevel2 = M;
        ErrorCorrectionLevel errorCorrectionLevel3 = Q;
        f16330x = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, H, errorCorrectionLevel3};
    }

    ErrorCorrectionLevel(int i2) {
        this.f16332s = i2;
    }

    public static ErrorCorrectionLevel b(int i2) {
        if (i2 >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = f16330x;
            if (i2 < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i2];
            }
        }
        throw new IllegalArgumentException();
    }

    public int f() {
        return this.f16332s;
    }
}
