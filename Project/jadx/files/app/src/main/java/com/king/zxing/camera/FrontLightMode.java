package com.king.zxing.camera;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public enum FrontLightMode {
    ON,
    AUTO,
    OFF;

    private static FrontLightMode a(String str) {
        return str == null ? AUTO : valueOf(str);
    }

    public static FrontLightMode a(SharedPreferences sharedPreferences) {
        return a(sharedPreferences.getString("preferences_front_light_mode", AUTO.toString()));
    }
}
