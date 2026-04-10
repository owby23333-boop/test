package com.amgcyo.cuttadon.utils.otherutils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.ColorInt;

/* JADX INFO: compiled from: MkScreenUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c0 {
    @ColorInt
    public static int a(int i2) {
        if (i2 < 10) {
            i2 = 10;
        } else if (i2 > 80) {
            i2 = 80;
        }
        float f2 = i2 / 80.0f;
        return Color.argb((int) (f2 * 180.0f), (int) (200.0f - (190.0f * f2)), (int) (180.0f - (170.0f * f2)), (int) (60.0f - (f2 * 60.0f)));
    }

    public static void b(Activity activity, int i2) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (i2 == -1) {
            attributes.screenBrightness = -1.0f;
        } else {
            if (i2 <= 0) {
                i2 = 1;
            }
            attributes.screenBrightness = i2 / 255.0f;
        }
        window.setAttributes(attributes);
    }

    public static int c(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception unused) {
            return 127;
        }
    }

    public static void a(Activity activity, int i2) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = i2 / 255.0f;
        activity.getWindow().setAttributes(attributes);
    }

    public static void c(Activity activity, int i2) {
        a(activity, i2);
    }

    public static boolean a(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static int b(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
