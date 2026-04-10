package com.bytedance.sdk.component.ga.bf;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.sdk.component.ga.tg<tg> {
    private Map<String, String> e(HttpURLConnection httpURLConnection) {
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

    /* JADX WARN: Can't wrap try/catch for region: R(13:46|3|4|49|5|(7:51|6|(1:8)(1:54)|38|39|40|41)|9|47|10|(2:12|13)|14|40|41) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
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
    @Override // com.bytedance.sdk.component.ga.tg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.ga.bf.tg<byte[]> call(com.bytedance.sdk.component.ga.ga r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "InternalHttpClient"
            r1 = 0
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.net.MalformedURLException -> L8e
            java.lang.String r4 = r10.e()     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.net.MalformedURLException -> L8e
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.net.MalformedURLException -> L8e
            java.net.URLConnection r3 = r3.openConnection()     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.net.MalformedURLException -> L8e
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.net.MalformedURLException -> L8e
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.net.MalformedURLException -> L8e
            r4 = 5000(0x1388, float:7.006E-42)
            r3.setConnectTimeout(r4)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.net.MalformedURLException -> L8e
            r3.setReadTimeout(r4)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.net.MalformedURLException -> L8e
            r3.connect()     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.net.MalformedURLException -> L8e
            java.io.InputStream r4 = r3.getInputStream()     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L6d java.net.MalformedURLException -> L8e
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L64 java.net.MalformedURLException -> L67
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L64 java.net.MalformedURLException -> L67
            r6.<init>()     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L64 java.net.MalformedURLException -> L67
        L30:
            int r7 = r4.read(r5)     // Catch: java.io.IOException -> L5b java.net.MalformedURLException -> L5e java.lang.Throwable -> Lba
            r8 = -1
            if (r7 == r8) goto L3b
            r6.write(r5, r2, r7)     // Catch: java.io.IOException -> L5b java.net.MalformedURLException -> L5e java.lang.Throwable -> Lba
            goto L30
        L3b:
            r2 = 200(0xc8, float:2.8E-43)
            byte[] r5 = r6.toByteArray()     // Catch: java.io.IOException -> L5b java.net.MalformedURLException -> L5e java.lang.Throwable -> Lba
            boolean r10 = r10.bf()     // Catch: java.io.IOException -> L57 java.net.MalformedURLException -> L59 java.lang.Throwable -> Lba
            if (r10 == 0) goto L4c
            java.util.Map r10 = r9.e(r3)     // Catch: java.io.IOException -> L57 java.net.MalformedURLException -> L59 java.lang.Throwable -> Lba
            r1 = r10
        L4c:
            com.bytedance.sdk.component.ga.d.d.bf.e(r4)
            com.bytedance.sdk.component.ga.d.d.bf.e(r6)
            java.lang.String r10 = "success"
            goto Lb4
        L57:
            r10 = move-exception
            goto L71
        L59:
            r10 = move-exception
            goto L92
        L5b:
            r10 = move-exception
            r5 = r1
            goto L71
        L5e:
            r10 = move-exception
            r5 = r1
            goto L92
        L61:
            r10 = move-exception
            r6 = r1
            goto Lbb
        L64:
            r10 = move-exception
            r5 = r1
            goto L70
        L67:
            r10 = move-exception
            r5 = r1
            goto L91
        L6a:
            r10 = move-exception
            r6 = r1
            goto Lbc
        L6d:
            r10 = move-exception
            r4 = r1
            r5 = r4
        L70:
            r6 = r5
        L71:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lba
            r3.<init>()     // Catch: java.lang.Throwable -> Lba
            java.lang.String r7 = "IOException:"
            r3.append(r7)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r7 = r10.getMessage()     // Catch: java.lang.Throwable -> Lba
            r3.append(r7)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lba
            android.util.Log.w(r0, r3)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> Lba
            goto Lae
        L8e:
            r10 = move-exception
            r4 = r1
            r5 = r4
        L91:
            r6 = r5
        L92:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lba
            r3.<init>()     // Catch: java.lang.Throwable -> Lba
            java.lang.String r7 = "MalformedURLException:"
            r3.append(r7)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r7 = r10.getMessage()     // Catch: java.lang.Throwable -> Lba
            r3.append(r7)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lba
            android.util.Log.w(r0, r3)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> Lba
        Lae:
            com.bytedance.sdk.component.ga.d.d.bf.e(r4)
            com.bytedance.sdk.component.ga.d.d.bf.e(r6)
        Lb4:
            com.bytedance.sdk.component.ga.bf.tg r0 = new com.bytedance.sdk.component.ga.bf.tg
            r0.<init>(r2, r5, r10, r1)
            return r0
        Lba:
            r10 = move-exception
        Lbb:
            r1 = r4
        Lbc:
            com.bytedance.sdk.component.ga.d.d.bf.e(r1)
            com.bytedance.sdk.component.ga.d.d.bf.e(r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ga.bf.e.call(com.bytedance.sdk.component.ga.ga):com.bytedance.sdk.component.ga.bf.tg");
    }
}
