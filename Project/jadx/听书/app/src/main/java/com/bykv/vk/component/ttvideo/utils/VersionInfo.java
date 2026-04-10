package com.bykv.vk.component.ttvideo.utils;

/* JADX INFO: loaded from: classes2.dex */
public class VersionInfo {
    private static String[] mVersion;

    /* JADX WARN: Removed duplicated region for block: B:39:0x006c A[Catch: all -> 0x0070, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:9:0x0035, B:13:0x003d, B:39:0x006c, B:29:0x005a, B:24:0x0050, B:8:0x0032), top: B:47:0x0018, inners: #2, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] getVersion() {
        /*
            java.lang.String[] r0 = com.bykv.vk.component.ttvideo.utils.VersionInfo.mVersion
            if (r0 != 0) goto L82
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]
            r1 = 0
            java.lang.String r2 = "null"
            r0[r1] = r2
            r3 = 1
            r0[r3] = r2
            r4 = 2
            r0[r4] = r2
            r5 = 3
            r0[r5] = r2
            java.lang.String r2 = "/proc/version"
            r6 = 0
            java.io.FileReader r7 = new java.io.FileReader     // Catch: java.lang.Throwable -> L4d
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L4d
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4e
            r8 = 8192(0x2000, float:1.148E-41)
            r2.<init>(r7, r8)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r6 = r2.readLine()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r8 = "\\s+"
            java.lang.String[] r6 = r6.split(r8)     // Catch: java.lang.Throwable -> L4b
            r6 = r6[r4]     // Catch: java.lang.Throwable -> L4b
            r0[r1] = r6     // Catch: java.lang.Throwable -> L4b
            r2.close()     // Catch: java.lang.Throwable -> L39
            r7.close()     // Catch: java.lang.Throwable -> L70
            goto L74
        L39:
            r1 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r1)     // Catch: java.lang.Throwable -> L41
            r7.close()     // Catch: java.lang.Throwable -> L70
            goto L74
        L41:
            r0 = move-exception
            r7.close()     // Catch: java.lang.Throwable -> L46
            goto L4a
        L46:
            r1 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r1)
        L4a:
            throw r0
        L4b:
            r6 = r2
            goto L4e
        L4d:
            r7 = r6
        L4e:
            if (r6 == 0) goto L6a
            r6.close()     // Catch: java.lang.Throwable -> L54
            goto L6a
        L54:
            r1 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r1)     // Catch: java.lang.Throwable -> L5e
            if (r7 == 0) goto L74
            r7.close()     // Catch: java.lang.Throwable -> L70
            goto L74
        L5e:
            r0 = move-exception
            if (r7 == 0) goto L69
            r7.close()     // Catch: java.lang.Throwable -> L65
            goto L69
        L65:
            r1 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r1)
        L69:
            throw r0
        L6a:
            if (r7 == 0) goto L74
            r7.close()     // Catch: java.lang.Throwable -> L70
            goto L74
        L70:
            r1 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r1)
        L74:
            java.lang.String r1 = android.os.Build.VERSION.RELEASE
            r0[r3] = r1
            java.lang.String r1 = android.os.Build.MODEL
            r0[r4] = r1
            java.lang.String r1 = android.os.Build.DISPLAY
            r0[r5] = r1
            com.bykv.vk.component.ttvideo.utils.VersionInfo.mVersion = r0
        L82:
            java.lang.String[] r0 = com.bykv.vk.component.ttvideo.utils.VersionInfo.mVersion
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.utils.VersionInfo.getVersion():java.lang.String[]");
    }
}
