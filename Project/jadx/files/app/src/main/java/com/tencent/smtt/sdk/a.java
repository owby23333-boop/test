package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static int a = 600;
    private static int b;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        r2 = r2.substring(r4 + 9).trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        if (r2 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
    
        if (r2.length() == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
    
        if (r2.contains("k") == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        r3 = java.lang.Integer.parseInt(r2.substring(0, r2.indexOf("k")).trim()) / 1024;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0056 -> B:49:0x0073). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a() {
        /*
            java.lang.String r0 = "k"
            int r1 = com.tencent.smtt.sdk.a.b
            if (r1 <= 0) goto L7
            return r1
        L7:
            java.lang.String r1 = "/proc/meminfo"
            r2 = 0
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L69
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L69
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L69
            r5 = 8192(0x2000, float:1.148E-41)
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L69
        L17:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            if (r2 == 0) goto L51
            java.lang.String r4 = "MemTotal:"
            int r4 = r2.indexOf(r4)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            r5 = -1
            if (r5 == r4) goto L17
            int r4 = r4 + 9
            java.lang.String r2 = r2.substring(r4)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            java.lang.String r2 = r2.trim()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            if (r2 == 0) goto L51
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            if (r4 == 0) goto L51
            boolean r4 = r2.contains(r0)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            if (r4 == 0) goto L51
            int r0 = r2.indexOf(r0)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            java.lang.String r0 = r2.substring(r3, r0)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            int r0 = r0 / 1024
            r3 = r0
        L51:
            r1.close()     // Catch: java.io.IOException -> L55
            goto L73
        L55:
            r0 = move-exception
            r0.printStackTrace()
            goto L73
        L5a:
            r0 = move-exception
            goto L60
        L5c:
            r0 = move-exception
            goto L6b
        L5e:
            r0 = move-exception
            r1 = r2
        L60:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L78
            if (r1 == 0) goto L73
            r1.close()     // Catch: java.io.IOException -> L55
            goto L73
        L69:
            r0 = move-exception
            r1 = r2
        L6b:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L78
            if (r1 == 0) goto L73
            r1.close()     // Catch: java.io.IOException -> L55
        L73:
            com.tencent.smtt.sdk.a.b = r3
            int r0 = com.tencent.smtt.sdk.a.b
            return r0
        L78:
            r0 = move-exception
            if (r1 == 0) goto L83
            r1.close()     // Catch: java.io.IOException -> L7f
            goto L83
        L7f:
            r1 = move-exception
            r1.printStackTrace()
        L83:
            goto L85
        L84:
            throw r0
        L85:
            goto L84
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.a():int");
    }
}
