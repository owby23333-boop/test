package com.kwai.sodler.lib.d;

import android.os.Build;
import android.os.Process;
import com.kwad.sdk.utils.r;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static String aJI;
    private static String aJJ;
    private static final Map<String, String> aJK;

    static {
        HashMap map = new HashMap();
        aJK = map;
        map.put("mips", "mips");
        aJK.put("mips64", "mips64");
        aJK.put("x86", "x86");
        aJK.put("x86_64", "x86_64");
        aJK.put("arm64", "arm64-v8a");
    }

    private static boolean is64Bit() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return Process.is64Bit();
        }
        if (i2 < 21) {
            return false;
        }
        Boolean bool = null;
        try {
            bool = (Boolean) r.a(r.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static String tM() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
