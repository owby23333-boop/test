package com.kwad.library.solder.lib.d;

import android.os.Process;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static String arH;
    private static String arI;
    private static final Map<String, String> arJ;

    static {
        HashMap map = new HashMap();
        arJ = map;
        map.put("mips", "mips");
        map.put("mips64", "mips64");
        map.put("x86", "x86");
        map.put("x86_64", "x86_64");
        map.put("arm64", "arm64-v8a");
    }

    private static boolean is64Bit() {
        return Process.is64Bit();
    }

    public static String Az() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
