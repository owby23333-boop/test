package com.bytedance.sdk.openadsdk.core.mc.z;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a9  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject z(android.net.Network r7, java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            if (r7 != 0) goto L12
            java.net.URL r7 = new java.net.URL     // Catch: java.lang.Throwable -> La4
            r7.<init>(r8)     // Catch: java.lang.Throwable -> La4
            java.net.URLConnection r7 = r7.openConnection()     // Catch: java.lang.Throwable -> La4
            javax.net.ssl.HttpsURLConnection r7 = (javax.net.ssl.HttpsURLConnection) r7     // Catch: java.lang.Throwable -> La4
            goto L1d
        L12:
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> La4
            r1.<init>(r8)     // Catch: java.lang.Throwable -> La4
            java.net.URLConnection r7 = r7.openConnection(r1)     // Catch: java.lang.Throwable -> La4
            javax.net.ssl.HttpsURLConnection r7 = (javax.net.ssl.HttpsURLConnection) r7     // Catch: java.lang.Throwable -> La4
        L1d:
            if (r7 != 0) goto L2b
            if (r7 == 0) goto L24
            r7.disconnect()
        L24:
            com.bytedance.sdk.openadsdk.hh.a.z(r0)
            com.bytedance.sdk.openadsdk.hh.a.z(r0)
            return r0
        L2b:
            r8 = 10000(0x2710, float:1.4013E-41)
            r7.setConnectTimeout(r8)     // Catch: java.lang.Throwable -> La2
            r7.setReadTimeout(r8)     // Catch: java.lang.Throwable -> La2
            r8 = 1
            r7.setDoInput(r8)     // Catch: java.lang.Throwable -> La2
            r1 = 0
            r7.setDefaultUseCaches(r1)     // Catch: java.lang.Throwable -> La2
            boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> La2
            if (r2 != 0) goto L58
            java.lang.String r2 = "POST"
            r7.setRequestMethod(r2)     // Catch: java.lang.Throwable -> La2
            r7.setDoOutput(r8)     // Catch: java.lang.Throwable -> La2
            java.io.OutputStream r8 = r7.getOutputStream()     // Catch: java.lang.Throwable -> La2
            byte[] r9 = r9.getBytes()     // Catch: java.lang.Throwable -> La0
            r8.write(r9)     // Catch: java.lang.Throwable -> La0
            r8.flush()     // Catch: java.lang.Throwable -> La0
            goto L5e
        L58:
            java.lang.String r8 = "GET"
            r7.setRequestMethod(r8)     // Catch: java.lang.Throwable -> La2
            r8 = r0
        L5e:
            r7.connect()     // Catch: java.lang.Throwable -> La0
            int r9 = r7.getResponseCode()     // Catch: java.lang.Throwable -> La0
            r2 = 200(0xc8, float:2.8E-43)
            if (r9 != r2) goto L92
            java.io.InputStream r9 = r7.getInputStream()     // Catch: java.lang.Throwable -> La0
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> La7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La7
            r3.<init>()     // Catch: java.lang.Throwable -> La7
        L76:
            int r4 = r9.read(r2)     // Catch: java.lang.Throwable -> La7
            if (r4 <= 0) goto L87
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> La7
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> La7
            r5.<init>(r2, r1, r4, r6)     // Catch: java.lang.Throwable -> La7
            r3.append(r5)     // Catch: java.lang.Throwable -> La7
            goto L76
        L87:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> La7
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> La7
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La7
            r0 = r9
            goto L93
        L92:
            r1 = r0
        L93:
            if (r7 == 0) goto L98
            r7.disconnect()
        L98:
            com.bytedance.sdk.openadsdk.hh.a.z(r8)
            com.bytedance.sdk.openadsdk.hh.a.z(r0)
            r0 = r1
            goto Lb2
        La0:
            r9 = r0
            goto La7
        La2:
            r8 = r0
            goto La6
        La4:
            r7 = r0
            r8 = r7
        La6:
            r9 = r8
        La7:
            if (r7 == 0) goto Lac
            r7.disconnect()
        Lac:
            com.bytedance.sdk.openadsdk.hh.a.z(r8)
            com.bytedance.sdk.openadsdk.hh.a.z(r9)
        Lb2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.mc.z.g.z(android.net.Network, java.lang.String, java.lang.String):org.json.JSONObject");
    }
}
