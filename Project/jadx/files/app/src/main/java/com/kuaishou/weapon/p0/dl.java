package com.kuaishou.weapon.p0;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class dl {
    private static a a;

    public enum a {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    private dl() {
    }

    public static String a(Context context) {
        return b(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    public static boolean b(Context context) {
        return c(context) == a.ARM64_V8A;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.kuaishou.weapon.p0.dl.a c(android.content.Context r5) {
        /*
            com.kuaishou.weapon.p0.dl$a r0 = com.kuaishou.weapon.p0.dl.a
            if (r0 == 0) goto L5
            return r0
        L5:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 >= r1) goto L10
        Lb:
            com.kuaishou.weapon.p0.dl$a r5 = com.kuaishou.weapon.p0.dl.a.ARMEABI_V7A
        Ld:
            com.kuaishou.weapon.p0.dl.a = r5
            goto L73
        L10:
            r2 = 23
            if (r0 < r2) goto L1d
            boolean r5 = android.os.Process.is64Bit()
            if (r5 == 0) goto Lb
            com.kuaishou.weapon.p0.dl$a r5 = com.kuaishou.weapon.p0.dl.a.ARM64_V8A
            goto Ld
        L1d:
            if (r0 < r1) goto L73
            java.lang.String r0 = "dalvik.system.VMRuntime"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = "getRuntime"
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L52
            java.lang.reflect.Method r1 = r0.getDeclaredMethod(r1, r3)     // Catch: java.lang.Throwable -> L52
            java.lang.String r3 = "is64Bit"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L52
            java.lang.reflect.Method r3 = r0.getDeclaredMethod(r3, r4)     // Catch: java.lang.Throwable -> L52
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L52
            java.lang.Object r0 = r1.invoke(r0, r4)     // Catch: java.lang.Throwable -> L52
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L52
            java.lang.Object r0 = r3.invoke(r0, r1)     // Catch: java.lang.Throwable -> L52
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L52
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto L4d
            com.kuaishou.weapon.p0.dl$a r0 = com.kuaishou.weapon.p0.dl.a.ARM64_V8A     // Catch: java.lang.Throwable -> L52
            goto L4f
        L4d:
            com.kuaishou.weapon.p0.dl$a r0 = com.kuaishou.weapon.p0.dl.a.ARMEABI_V7A     // Catch: java.lang.Throwable -> L52
        L4f:
            com.kuaishou.weapon.p0.dl.a = r0     // Catch: java.lang.Throwable -> L52
            goto L73
        L52:
            r0 = move-exception
            r0.printStackTrace()
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo()     // Catch: java.lang.Throwable -> L6c
            java.lang.String r5 = r5.nativeLibraryDir     // Catch: java.lang.Throwable -> L6c
            java.lang.String r0 = "arm64"
            boolean r5 = r5.contains(r0)     // Catch: java.lang.Throwable -> L6c
            if (r5 == 0) goto L69
            com.kuaishou.weapon.p0.dl$a r5 = com.kuaishou.weapon.p0.dl.a.ARM64_V8A     // Catch: java.lang.Throwable -> L6c
        L66:
            com.kuaishou.weapon.p0.dl.a = r5     // Catch: java.lang.Throwable -> L6c
            goto L73
        L69:
            com.kuaishou.weapon.p0.dl$a r5 = com.kuaishou.weapon.p0.dl.a.UNKNOWN     // Catch: java.lang.Throwable -> L6c
            goto L66
        L6c:
            r5 = move-exception
            r5.printStackTrace()
            com.kuaishou.weapon.p0.dl$a r5 = com.kuaishou.weapon.p0.dl.a.UNKNOWN
            goto Ld
        L73:
            com.kuaishou.weapon.p0.dl$a r5 = com.kuaishou.weapon.p0.dl.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.dl.c(android.content.Context):com.kuaishou.weapon.p0.dl$a");
    }
}
