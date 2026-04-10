package com.kwad.sdk.utils;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class AbiUtil {
    private static Abi axK;

    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A
    }

    public static String bF(Context context) {
        return isArm64(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.kwad.sdk.utils.AbiUtil.Abi bG(android.content.Context r4) {
        /*
            com.kwad.sdk.utils.AbiUtil$Abi r0 = com.kwad.sdk.utils.AbiUtil.axK
            if (r0 == 0) goto L5
            return r0
        L5:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 >= r1) goto L10
        Lb:
            com.kwad.sdk.utils.AbiUtil$Abi r4 = com.kwad.sdk.utils.AbiUtil.Abi.ARMEABI_V7A
        Ld:
            com.kwad.sdk.utils.AbiUtil.axK = r4
            goto L63
        L10:
            r2 = 23
            if (r0 < r2) goto L1d
            boolean r4 = android.os.Process.is64Bit()
            if (r4 == 0) goto Lb
            com.kwad.sdk.utils.AbiUtil$Abi r4 = com.kwad.sdk.utils.AbiUtil.Abi.ARM64_V8A
            goto Ld
        L1d:
            if (r0 < r1) goto L63
            java.lang.String r0 = "dalvik.system.VMRuntime"
            java.lang.String r1 = "getRuntime"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L42
            java.lang.Object r0 = com.kwad.sdk.utils.r.a(r0, r1, r3)     // Catch: java.lang.Throwable -> L42
            java.lang.String r1 = "is64Bit"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L42
            java.lang.Object r0 = com.kwad.sdk.utils.r.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L42
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L42
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L3d
            com.kwad.sdk.utils.AbiUtil$Abi r0 = com.kwad.sdk.utils.AbiUtil.Abi.ARM64_V8A     // Catch: java.lang.Throwable -> L42
            goto L3f
        L3d:
            com.kwad.sdk.utils.AbiUtil$Abi r0 = com.kwad.sdk.utils.AbiUtil.Abi.ARMEABI_V7A     // Catch: java.lang.Throwable -> L42
        L3f:
            com.kwad.sdk.utils.AbiUtil.axK = r0     // Catch: java.lang.Throwable -> L42
            goto L63
        L42:
            r0 = move-exception
            r0.printStackTrace()
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r4 = r4.nativeLibraryDir     // Catch: java.lang.Throwable -> L5c
            java.lang.String r0 = "arm64"
            boolean r4 = r4.contains(r0)     // Catch: java.lang.Throwable -> L5c
            if (r4 == 0) goto L59
            com.kwad.sdk.utils.AbiUtil$Abi r4 = com.kwad.sdk.utils.AbiUtil.Abi.ARM64_V8A     // Catch: java.lang.Throwable -> L5c
        L56:
            com.kwad.sdk.utils.AbiUtil.axK = r4     // Catch: java.lang.Throwable -> L5c
            goto L63
        L59:
            com.kwad.sdk.utils.AbiUtil$Abi r4 = com.kwad.sdk.utils.AbiUtil.Abi.UNKNOWN     // Catch: java.lang.Throwable -> L5c
            goto L56
        L5c:
            r4 = move-exception
            r4.printStackTrace()
            com.kwad.sdk.utils.AbiUtil$Abi r4 = com.kwad.sdk.utils.AbiUtil.Abi.UNKNOWN
            goto Ld
        L63:
            com.kwad.sdk.utils.AbiUtil$Abi r4 = com.kwad.sdk.utils.AbiUtil.axK
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.AbiUtil.bG(android.content.Context):com.kwad.sdk.utils.AbiUtil$Abi");
    }

    public static boolean isArm64(Context context) {
        return bG(context) == Abi.ARM64_V8A;
    }
}
