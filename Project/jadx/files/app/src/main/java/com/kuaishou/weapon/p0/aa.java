package com.kuaishou.weapon.p0;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class aa {
    private static volatile aa a;

    private aa() {
    }

    public static synchronized aa a() {
        if (a == null) {
            synchronized (aa.class) {
                if (a == null) {
                    a = new aa();
                }
            }
        }
        return a;
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int i2;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                i2 = bufferedInputStream.read(bArr);
                if (i2 > 0) {
                    sb.append(new String(bArr, 0, i2));
                }
            } catch (Exception unused) {
            }
        } while (i2 >= 512);
        return sb.toString();
    }

    public String a(String str) {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L69
            java.lang.String r2 = "sh"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L69
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            byte[] r6 = r6.getBytes()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
            r2.write(r6)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
            r6 = 10
            r2.write(r6)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
            r2.flush()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
            r2.close()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
            r1.waitFor()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
            java.lang.String r6 = a(r3)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
            r2.close()     // Catch: java.io.IOException -> L39
        L39:
            r3.close()     // Catch: java.io.IOException -> L3d
            goto L3e
        L3d:
        L3e:
            if (r1 == 0) goto L43
            r1.destroy()
        L43:
            return r6
        L44:
            r6 = move-exception
            r0 = r3
            goto L55
        L47:
            goto L6c
        L49:
            r6 = move-exception
            goto L55
        L4b:
            r3 = r0
            goto L6c
        L4d:
            r6 = move-exception
            r2 = r0
            goto L55
        L50:
            r2 = r0
            goto L6b
        L52:
            r6 = move-exception
            r1 = r0
            r2 = r1
        L55:
            if (r2 == 0) goto L5c
            r2.close()     // Catch: java.io.IOException -> L5b
            goto L5c
        L5b:
        L5c:
            if (r0 == 0) goto L63
            r0.close()     // Catch: java.io.IOException -> L62
            goto L63
        L62:
        L63:
            if (r1 == 0) goto L68
            r1.destroy()
        L68:
            throw r6
        L69:
            r1 = r0
            r2 = r1
        L6b:
            r3 = r2
        L6c:
            if (r2 == 0) goto L73
            r2.close()     // Catch: java.io.IOException -> L72
            goto L73
        L72:
        L73:
            if (r3 == 0) goto L7a
            r3.close()     // Catch: java.io.IOException -> L79
            goto L7a
        L79:
        L7a:
            if (r1 == 0) goto L7f
            r1.destroy()
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.aa.b(java.lang.String):java.lang.String");
    }
}
