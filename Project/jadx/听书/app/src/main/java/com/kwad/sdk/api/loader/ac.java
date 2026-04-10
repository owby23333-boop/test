package com.kwad.sdk.api.loader;

import android.os.Process;

/* JADX INFO: loaded from: classes4.dex */
final class ac {
    static boolean is64Bit() {
        return Process.is64Bit();
    }

    public static String Az() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
