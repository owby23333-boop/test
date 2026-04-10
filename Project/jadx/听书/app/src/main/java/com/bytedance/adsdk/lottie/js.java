package com.bytedance.adsdk.lottie;

/* JADX INFO: loaded from: classes2.dex */
public enum js {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.js$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[js.values().length];
            z = iArr;
            try {
                iArr[js.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[js.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[js.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean z(int i, boolean z, int i2) {
        int i3 = AnonymousClass1.z[ordinal()];
        if (i3 == 1) {
            return false;
        }
        if (i3 != 2) {
            return (z && i < 28) || i2 > 4 || i <= 25;
        }
        return true;
    }
}
