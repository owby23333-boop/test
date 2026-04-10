package org.minidns.c;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.minidns.util.f;

/* JADX INFO: compiled from: UnixUsingEtcResolvConf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f21384v = new e();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Logger f21385w = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Pattern f21386x = Pattern.compile("^nameserver\\s+(.*)$");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static List<String> f21387y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static long f21388z;

    private e() {
        super(e.class.getSimpleName(), 2000);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.BufferedReader] */
    @Override // org.minidns.c.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.lang.String> a0() throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "Could not close reader"
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "/etc/resolv.conf"
            r1.<init>(r2)
            boolean r2 = r1.exists()
            r3 = 0
            if (r2 != 0) goto L11
            return r3
        L11:
            long r4 = r1.lastModified()
            long r6 = org.minidns.c.e.f21388z
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L20
            java.util.List<java.lang.String> r2 = org.minidns.c.e.f21387y
            if (r2 == 0) goto L20
            return r2
        L20:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7b
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7b
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7b
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7b
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7b
            r7.<init>(r8, r1)     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7b
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7b
        L36:
            java.lang.String r1 = r6.readLine()     // Catch: java.io.IOException -> L76 java.lang.Throwable -> L95
            if (r1 == 0) goto L55
            java.util.regex.Pattern r7 = org.minidns.c.e.f21386x     // Catch: java.io.IOException -> L76 java.lang.Throwable -> L95
            java.util.regex.Matcher r1 = r7.matcher(r1)     // Catch: java.io.IOException -> L76 java.lang.Throwable -> L95
            boolean r7 = r1.matches()     // Catch: java.io.IOException -> L76 java.lang.Throwable -> L95
            if (r7 == 0) goto L36
            r7 = 1
            java.lang.String r1 = r1.group(r7)     // Catch: java.io.IOException -> L76 java.lang.Throwable -> L95
            java.lang.String r1 = r1.trim()     // Catch: java.io.IOException -> L76 java.lang.Throwable -> L95
            r2.add(r1)     // Catch: java.io.IOException -> L76 java.lang.Throwable -> L95
            goto L36
        L55:
            r6.close()     // Catch: java.io.IOException -> L59
            goto L61
        L59:
            r1 = move-exception
            java.util.logging.Logger r6 = org.minidns.c.e.f21385w
            java.util.logging.Level r7 = java.util.logging.Level.WARNING
            r6.log(r7, r0, r1)
        L61:
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L6f
            java.util.logging.Logger r0 = org.minidns.c.e.f21385w
            java.lang.String r1 = "Could not find any nameservers in /etc/resolv.conf"
            r0.fine(r1)
            return r3
        L6f:
            org.minidns.c.e.f21387y = r2
            org.minidns.c.e.f21388z = r4
            java.util.List<java.lang.String> r0 = org.minidns.c.e.f21387y
            return r0
        L76:
            r1 = move-exception
            goto L7d
        L78:
            r1 = move-exception
            r6 = r3
            goto L96
        L7b:
            r1 = move-exception
            r6 = r3
        L7d:
            java.util.logging.Logger r2 = org.minidns.c.e.f21385w     // Catch: java.lang.Throwable -> L95
            java.util.logging.Level r4 = java.util.logging.Level.WARNING     // Catch: java.lang.Throwable -> L95
            java.lang.String r5 = "Could not read from /etc/resolv.conf"
            r2.log(r4, r5, r1)     // Catch: java.lang.Throwable -> L95
            if (r6 == 0) goto L94
            r6.close()     // Catch: java.io.IOException -> L8c
            goto L94
        L8c:
            r1 = move-exception
            java.util.logging.Logger r2 = org.minidns.c.e.f21385w
            java.util.logging.Level r4 = java.util.logging.Level.WARNING
            r2.log(r4, r0, r1)
        L94:
            return r3
        L95:
            r1 = move-exception
        L96:
            if (r6 == 0) goto La4
            r6.close()     // Catch: java.io.IOException -> L9c
            goto La4
        L9c:
            r2 = move-exception
            java.util.logging.Logger r3 = org.minidns.c.e.f21385w
            java.util.logging.Level r4 = java.util.logging.Level.WARNING
            r3.log(r4, r0, r2)
        La4:
            goto La6
        La5:
            throw r1
        La6:
            goto La5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.minidns.c.e.a0():java.util.List");
    }

    @Override // org.minidns.c.d
    public boolean isAvailable() {
        if (f.a()) {
            return false;
        }
        try {
            return new File("/etc/resolv.conf").exists();
        } catch (SecurityException e2) {
            f21385w.log(Level.FINE, "Access to /etc/resolv.conf not possible", (Throwable) e2);
            return false;
        }
    }
}
