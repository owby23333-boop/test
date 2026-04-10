package com.bytedance.sdk.openadsdk.core.a;

import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.uy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static AtomicBoolean z;

    public static boolean gz() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean z() {
        /*
            r0 = 0
            java.util.concurrent.atomic.AtomicBoolean r1 = com.bytedance.sdk.openadsdk.core.a.z.z     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto La
            boolean r0 = r1.get()     // Catch: java.lang.Throwable -> L45
            return r0
        La:
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.zw.getContext()     // Catch: java.lang.Throwable -> L45
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L45
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.g.z(r1)     // Catch: java.lang.Throwable -> L45
            java.lang.String r1 = r1.getParent()     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = "/pangle_p/com.byted.pangle"
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L45
            r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L45
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L40
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = "^version-(\\d+)$"
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L45
            r2.listFiles()     // Catch: java.lang.Throwable -> L45
            com.bytedance.sdk.openadsdk.core.a.z$1 r3 = new com.bytedance.sdk.openadsdk.core.a.z$1     // Catch: java.lang.Throwable -> L45
            r3.<init>()     // Catch: java.lang.Throwable -> L45
            java.io.File[] r1 = r2.listFiles(r3)     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L40
            int r1 = r1.length     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L40
            r1 = 1
            goto L41
        L40:
            r1 = r0
        L41:
            z(r1)     // Catch: java.lang.Throwable -> L45
            return r1
        L45:
            r1 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.a.z.z():boolean");
    }

    public static void z(boolean z2) {
        if (z == null) {
            z = new AtomicBoolean();
        }
        z.set(z2);
        uy.ls().pf();
    }

    public static boolean g() {
        return gc() && !com.bytedance.sdk.openadsdk.core.dl.dl.z().gz() && z();
    }

    public static boolean dl() {
        boolean z2 = gk.g;
        return false;
    }

    public static int a() {
        return gk.g ? 1 : 0;
    }

    public static boolean gc() {
        return gk.g;
    }

    public static boolean m() {
        return gc() && uy.ls().gk();
    }

    public static boolean e() {
        return com.bytedance.sdk.openadsdk.core.dl.dl.z().fo();
    }
}
