package com.anythink.expressad.exoplayer.k;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class w {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9909c = 2;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    private w() {
    }

    private static int a(int i2, int i3) {
        for (int i4 = 1; i4 <= 2; i4++) {
            int i5 = (i2 + i4) % 3;
            boolean z2 = false;
            if (i5 == 0 || (i5 == 1 ? (i3 & 1) != 0 : !(i5 != 2 || (i3 & 2) == 0))) {
                z2 = true;
            }
            if (z2) {
                return i5;
            }
        }
        return i2;
    }

    private static boolean b(int i2, int i3) {
        if (i2 != 0) {
            return i2 != 1 ? i2 == 2 && (i3 & 2) != 0 : (i3 & 1) != 0;
        }
        return true;
    }
}
