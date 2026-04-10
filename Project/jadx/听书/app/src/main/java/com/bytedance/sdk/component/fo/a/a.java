package com.bytedance.sdk.component.fo.a;

import android.content.Context;
import com.bytedance.sdk.component.fo.dl.e;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void z(Context context, int i, String str, int i2) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put(z(i2), str);
            }
            dl.g("MultiProcessFileUtils", "saveData = ".concat(String.valueOf(str)));
            if (e.z().z(i2).a() != null) {
                e.z().z(i2).a().z(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String z(android.content.Context r2, int r3, int r4) {
        /*
            java.lang.String r0 = ""
            r1 = 1
            if (r3 == r1) goto L6
            goto L29
        L6:
            com.bytedance.sdk.component.fo.dl.e r3 = com.bytedance.sdk.component.fo.dl.e.z()     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.fo.dl.gc r3 = r3.z(r4)     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.fo.dl.g r3 = r3.a()     // Catch: java.lang.Exception -> L29
            if (r3 == 0) goto L29
            com.bytedance.sdk.component.fo.dl.e r3 = com.bytedance.sdk.component.fo.dl.e.z()     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.fo.dl.gc r3 = r3.z(r4)     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.fo.dl.g r3 = r3.a()     // Catch: java.lang.Exception -> L29
            java.lang.String r4 = z(r4)     // Catch: java.lang.Exception -> L29
            java.lang.String r2 = r3.z(r2, r4, r0)     // Catch: java.lang.Exception -> L29
            goto L2a
        L29:
            r2 = r0
        L2a:
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L32
            java.lang.String r0 = java.lang.String.valueOf(r2)
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.fo.a.a.z(android.content.Context, int, int):java.lang.String");
    }

    private static String z(int i) {
        return "tnc_config".concat(String.valueOf(i));
    }
}
