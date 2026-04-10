package com.qmuiteam.qmui.util;

import com.qq.e.comm.managers.setting.GlobalSetting;
import java.io.Closeable;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class QMUILangHelper {
    public static float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static int constrain(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static int getNumberDigits(int i) {
        if (i <= 0) {
            return 0;
        }
        return (int) (Math.log10(i) + 1.0d);
    }

    public static int getNumberDigits(long j) {
        if (j <= 0) {
            return 0;
        }
        return (int) (Math.log10(j) + 1.0d);
    }

    public static String formatNumberToLimitedDigits(int i, int i2) {
        if (getNumberDigits(i) > i2) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 1; i3 <= i2; i3++) {
                sb.append(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD);
            }
            sb.append("+");
            return sb.toString();
        }
        return String.valueOf(i);
    }

    public static String regularizePrice(float f) {
        return String.format(Locale.CHINESE, "%.2f", Float.valueOf(f));
    }

    public static String regularizePrice(double d) {
        return String.format(Locale.CHINESE, "%.2f", Double.valueOf(d));
    }

    public static boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Deprecated
    public static boolean objectEquals(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }
}
