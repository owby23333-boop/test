package com.bytedance.sdk.component.m.g;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.component.m.gc<a> {
    /* JADX WARN: Can't wrap try/catch for region: R(13:46|3|4|51|5|(7:49|6|(1:8)(1:54)|38|39|40|41)|9|47|10|(2:12|13)|14|40|41) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    @Override // com.bytedance.sdk.component.m.gc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.m.g.a<byte[]> call(com.bytedance.sdk.component.m.m r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "InternalHttpClient"
            r1 = 0
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c java.net.MalformedURLException -> L8b
            java.lang.String r4 = r10.z()     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c java.net.MalformedURLException -> L8b
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c java.net.MalformedURLException -> L8b
            java.net.URLConnection r3 = r3.openConnection()     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c java.net.MalformedURLException -> L8b
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c java.net.MalformedURLException -> L8b
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c java.net.MalformedURLException -> L8b
            r4 = 5000(0x1388, float:7.006E-42)
            r3.setConnectTimeout(r4)     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c java.net.MalformedURLException -> L8b
            r3.setReadTimeout(r4)     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c java.net.MalformedURLException -> L8b
            r3.connect()     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c java.net.MalformedURLException -> L8b
            java.io.InputStream r4 = r3.getInputStream()     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6c java.net.MalformedURLException -> L8b
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63 java.net.MalformedURLException -> L66
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63 java.net.MalformedURLException -> L66
            r6.<init>()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L63 java.net.MalformedURLException -> L66
        L30:
            int r7 = r4.read(r5)     // Catch: java.io.IOException -> L5a java.net.MalformedURLException -> L5d java.lang.Throwable -> Lb5
            r8 = -1
            if (r7 == r8) goto L3b
            r6.write(r5, r2, r7)     // Catch: java.io.IOException -> L5a java.net.MalformedURLException -> L5d java.lang.Throwable -> Lb5
            goto L30
        L3b:
            r2 = 200(0xc8, float:2.8E-43)
            byte[] r5 = r6.toByteArray()     // Catch: java.io.IOException -> L5a java.net.MalformedURLException -> L5d java.lang.Throwable -> Lb5
            boolean r10 = r10.g()     // Catch: java.io.IOException -> L56 java.net.MalformedURLException -> L58 java.lang.Throwable -> Lb5
            if (r10 == 0) goto L4c
            java.util.Map r10 = r9.z(r3)     // Catch: java.io.IOException -> L56 java.net.MalformedURLException -> L58 java.lang.Throwable -> Lb5
            r1 = r10
        L4c:
            com.bytedance.sdk.component.m.dl.dl.g.z(r4)
            com.bytedance.sdk.component.m.dl.dl.g.z(r6)
            java.lang.String r10 = "success"
            goto Laf
        L56:
            r10 = move-exception
            goto L70
        L58:
            r10 = move-exception
            goto L8f
        L5a:
            r10 = move-exception
            r5 = r1
            goto L70
        L5d:
            r10 = move-exception
            r5 = r1
            goto L8f
        L60:
            r10 = move-exception
            r6 = r1
            goto Lb6
        L63:
            r10 = move-exception
            r5 = r1
            goto L6f
        L66:
            r10 = move-exception
            r5 = r1
            goto L8e
        L69:
            r10 = move-exception
            r6 = r1
            goto Lb7
        L6c:
            r10 = move-exception
            r4 = r1
            r5 = r4
        L6f:
            r6 = r5
        L70:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r7 = "IOException:"
            r3.<init>(r7)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r7 = r10.getMessage()     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lb5
            com.bytedance.sdk.component.utils.wp.g(r0, r3)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> Lb5
            goto La9
        L8b:
            r10 = move-exception
            r4 = r1
            r5 = r4
        L8e:
            r6 = r5
        L8f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r7 = "MalformedURLException:"
            r3.<init>(r7)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r7 = r10.getMessage()     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lb5
            com.bytedance.sdk.component.utils.wp.g(r0, r3)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> Lb5
        La9:
            com.bytedance.sdk.component.m.dl.dl.g.z(r4)
            com.bytedance.sdk.component.m.dl.dl.g.z(r6)
        Laf:
            com.bytedance.sdk.component.m.g.a r0 = new com.bytedance.sdk.component.m.g.a
            r0.<init>(r2, r5, r10, r1)
            return r0
        Lb5:
            r10 = move-exception
        Lb6:
            r1 = r4
        Lb7:
            com.bytedance.sdk.component.m.dl.dl.g.z(r1)
            com.bytedance.sdk.component.m.dl.dl.g.z(r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.m.g.z.call(com.bytedance.sdk.component.m.m):com.bytedance.sdk.component.m.g.a");
    }

    private Map<String, String> z(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list != null && list.size() > 0) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }
}
