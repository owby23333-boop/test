package com.xiaomi.passport.ui.internal.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes8.dex */
public class Build extends android.os.Build {
    public static final boolean IS_MIPAD;
    public static final boolean IS_N7;
    public static final boolean IS_TABLET;

    static {
        String str = android.os.Build.DEVICE;
        IS_MIPAD = "mocha".equals(str);
        IS_N7 = "flo".equals(str);
        IS_TABLET = isTablet();
    }

    private static boolean isTablet() {
        if (IS_N7 || IS_MIPAD) {
            return true;
        }
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return ((int) ((((float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)) / displayMetrics.density) + 0.5f)) >= 600;
    }
}
