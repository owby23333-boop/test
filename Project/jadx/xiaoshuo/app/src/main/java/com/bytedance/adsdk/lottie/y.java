package com.bytedance.adsdk.lottie;

/* JADX INFO: loaded from: classes.dex */
public enum y {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.y$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] e;

        static {
            int[] iArr = new int[y.values().length];
            e = iArr;
            try {
                iArr[y.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                e[y.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                e[y.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean e(int i, boolean z, int i2) {
        int i3 = AnonymousClass1.e[ordinal()];
        if (i3 == 1) {
            return false;
        }
        if (i3 != 2) {
            return (z && i < 28) || i2 > 4 || i <= 25;
        }
        return true;
    }
}
