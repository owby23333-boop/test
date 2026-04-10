package com.alibaba.sdk.android.httpdns;

/* JADX INFO: loaded from: classes.dex */
public class t {
    private static volatile t a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f2227h = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2228k = true;
    private String hostName = null;

    private t() {
    }

    public static t a() {
        if (a == null) {
            synchronized (t.class) {
                if (a == null) {
                    a = new t();
                }
            }
        }
        return a;
    }

    private void a(String str, String str2) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                bVarA.a(str, u.a(s.SNIFF_HOST), str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.f2227h;
        if (j2 != 0 && jCurrentTimeMillis - j2 < 30000) {
            return false;
        }
        this.f2227h = jCurrentTimeMillis;
        return true;
    }

    public synchronized void c(boolean z2) {
        this.f2228k = z2;
    }

    public synchronized void g() {
        this.f2227h = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028 A[Catch: all -> 0x0061, Exception -> 0x0063, TryCatch #1 {Exception -> 0x0063, blocks: (B:4:0x0003, B:5:0x0005, B:17:0x0028, B:18:0x004c, B:9:0x0011, B:12:0x001a), top: B:31:0x0003, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c A[Catch: all -> 0x0061, Exception -> 0x0063, TRY_LEAVE, TryCatch #1 {Exception -> 0x0063, blocks: (B:4:0x0003, B:5:0x0005, B:17:0x0028, B:18:0x004c, B:9:0x0011, B:12:0x001a), top: B:31:0x0003, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011 A[Catch: all -> 0x0061, Exception -> 0x0063, TryCatch #1 {Exception -> 0x0063, blocks: (B:4:0x0003, B:5:0x0005, B:17:0x0028, B:18:0x004c, B:9:0x0011, B:12:0x001a), top: B:31:0x0003, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void g(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto L5
            r5.hostName = r6     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
        L5:
            r0 = 1
            boolean r1 = r5.f2228k     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L11
            java.lang.String r0 = "sniffer is turned off"
        Le:
            r1 = r0
            r0 = 0
            goto L26
        L11:
            boolean r1 = r5.d()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            if (r1 != 0) goto L1a
            java.lang.String r0 = "sniff too often"
            goto Le
        L1a:
            java.lang.String r1 = r5.hostName     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            if (r1 == 0) goto L25
            java.lang.String r0 = "hostname is null"
            goto Le
        L25:
            r1 = r2
        L26:
            if (r0 == 0) goto L4c
            java.lang.String r0 = "launch a sniff task"
            com.alibaba.sdk.android.httpdns.i.d(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            com.alibaba.sdk.android.httpdns.q r0 = new com.alibaba.sdk.android.httpdns.q     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r1 = r5.hostName     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            com.alibaba.sdk.android.httpdns.s r4 = com.alibaba.sdk.android.httpdns.s.SNIFF_HOST     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r0.<init>(r1, r4)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r0.a(r3)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.util.concurrent.ExecutorService r1 = com.alibaba.sdk.android.httpdns.c.a()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r1.submit(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            com.alibaba.sdk.android.httpdns.s r0 = com.alibaba.sdk.android.httpdns.s.SNIFF_HOST     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r0 = com.alibaba.sdk.android.httpdns.u.a(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r5.a(r6, r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r5.hostName = r2     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            goto L67
        L4c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r6.<init>()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r0 = "launch sniffer failed due to "
            r6.append(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r6.append(r1)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            com.alibaba.sdk.android.httpdns.i.d(r6)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            goto L67
        L61:
            r6 = move-exception
            goto L69
        L63:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L61
        L67:
            monitor-exit(r5)
            return
        L69:
            monitor-exit(r5)
            goto L6c
        L6b:
            throw r6
        L6c:
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.t.g(java.lang.String):void");
    }
}
