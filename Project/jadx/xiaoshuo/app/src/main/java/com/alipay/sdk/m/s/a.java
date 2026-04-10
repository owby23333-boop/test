package com.alipay.sdk.m.s;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: com.alipay.sdk.m.s.a$a, reason: collision with other inner class name */
    public interface InterfaceC0039a {
        void a(File file);

        void a(Throwable th);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r4, java.lang.String r5, com.alipay.sdk.m.s.a.InterfaceC0039a r6) {
        /*
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L7b
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L7b
            java.net.URLConnection r4 = r0.openConnection()     // Catch: java.lang.Throwable -> L7b
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Throwable -> L7b
            r4.connect()     // Catch: java.lang.Throwable -> L7b
            int r0 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L7b
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L60
            r4.getContentLength()     // Catch: java.lang.Throwable -> L7b
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L7b
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L7b
            boolean r5 = r0.exists()     // Catch: java.lang.Throwable -> L7b
            if (r5 == 0) goto L27
            r0.delete()     // Catch: java.lang.Throwable -> L7b
        L27:
            java.io.InputStream r4 = r4.getInputStream()     // Catch: java.lang.Throwable -> L7b
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L54
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L54
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L4a
        L34:
            int r2 = r4.read(r1)     // Catch: java.lang.Throwable -> L4a
            r3 = -1
            if (r2 == r3) goto L40
            r3 = 0
            r5.write(r1, r3, r2)     // Catch: java.lang.Throwable -> L4a
            goto L34
        L40:
            r6.a(r0)     // Catch: java.lang.Throwable -> L4a
            r5.close()     // Catch: java.lang.Throwable -> L54
            r4.close()     // Catch: java.lang.Throwable -> L7b
            goto L7f
        L4a:
            r0 = move-exception
            r5.close()     // Catch: java.lang.Throwable -> L4f
            goto L53
        L4f:
            r5 = move-exception
            r0.addSuppressed(r5)     // Catch: java.lang.Throwable -> L54
        L53:
            throw r0     // Catch: java.lang.Throwable -> L54
        L54:
            r5 = move-exception
            if (r4 == 0) goto L5f
            r4.close()     // Catch: java.lang.Throwable -> L5b
            goto L5f
        L5b:
            r4 = move-exception
            r5.addSuppressed(r4)     // Catch: java.lang.Throwable -> L7b
        L5f:
            throw r5     // Catch: java.lang.Throwable -> L7b
        L60:
            java.io.IOException r5 = new java.io.IOException     // Catch: java.lang.Throwable -> L7b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7b
            r0.<init>()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r1 = "Server returned HTTP "
            r0.append(r1)     // Catch: java.lang.Throwable -> L7b
            int r4 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L7b
            r0.append(r4)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L7b
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L7b
            throw r5     // Catch: java.lang.Throwable -> L7b
        L7b:
            r4 = move-exception
            r6.a(r4)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.s.a.a(java.lang.String, java.lang.String, com.alipay.sdk.m.s.a$a):void");
    }
}
