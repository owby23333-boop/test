package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: classes3.dex */
public final class dm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f1852a;

    public enum a {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    private dm() {
    }

    public static String a(Context context) {
        return b(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean b(Context context) {
        return c(context) == a.ARM64_V8A;
    }

    private static a c(Context context) {
        a aVar = f1852a;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = Process.is64Bit() ? a.ARM64_V8A : a.ARMEABI_V7A;
        f1852a = aVar2;
        return aVar2;
    }
}
