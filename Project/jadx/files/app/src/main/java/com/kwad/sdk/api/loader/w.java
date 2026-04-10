package com.kwad.sdk.api.loader;

import android.os.Build;
import android.os.Process;

/* JADX INFO: loaded from: classes3.dex */
final class w {
    static boolean is64Bit() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return Process.is64Bit();
        }
        if (i2 >= 21) {
            try {
                return ((Boolean) Reflect.aV("dalvik.system.VMRuntime").aY("getRuntime").aY("is64Bit").get()).booleanValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static String tM() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
