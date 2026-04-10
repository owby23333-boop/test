package com.bytedance.msdk.core.wp;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static final Map<String, InterfaceC0077z> z = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: com.bytedance.msdk.core.wp.z$z, reason: collision with other inner class name */
    public interface InterfaceC0077z {
    }

    public static void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g(str);
    }

    public static void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g(str);
    }

    private static InterfaceC0077z g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return z.remove(str);
    }
}
