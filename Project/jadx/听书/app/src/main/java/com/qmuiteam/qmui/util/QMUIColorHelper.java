package com.qmuiteam.qmui.util;

import android.graphics.Color;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIColorHelper {
    public static int setColorAlpha(int i, float f, boolean z) {
        return (i & 16777215) | (((int) (f * (z ? 255 : 255 & (i >> 24)))) << 24);
    }

    public static int setColorAlpha(int i, float f) {
        return setColorAlpha(i, f, true);
    }

    public static int computeColor(int i, int i2, float f) {
        float fConstrain = QMUILangHelper.constrain(f, 0.0f, 1.0f);
        return Color.argb(((int) ((Color.alpha(i2) - r0) * fConstrain)) + Color.alpha(i), ((int) ((Color.red(i2) - r0) * fConstrain)) + Color.red(i), ((int) ((Color.green(i2) - r0) * fConstrain)) + Color.green(i), ((int) ((Color.blue(i2) - r4) * fConstrain)) + Color.blue(i));
    }

    public static String colorToString(int i) {
        return String.format("#%08X", Integer.valueOf(i));
    }
}
