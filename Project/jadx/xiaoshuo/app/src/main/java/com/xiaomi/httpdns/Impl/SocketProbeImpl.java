package com.xiaomi.httpdns.Impl;

import com.xiaomi.httpdns.api.Probe;

/* JADX INFO: loaded from: classes8.dex */
public class SocketProbeImpl implements Probe {
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x003e: MOVE (r5 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:26:0x003d */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.xiaomi.httpdns.api.Probe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int probe(java.lang.String r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            r4 = this;
            r5 = 0
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            java.net.Socket r2 = new java.net.Socket     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            r2.<init>()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            java.net.InetSocketAddress r5 = new java.net.InetSocketAddress     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L3c
            r3 = 0
            r5.<init>(r6, r3)     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L3c
            r6 = 5000(0x1388, float:7.006E-42)
            r2.connect(r5, r6)     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L3c
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L3c
            long r5 = r5 - r0
            int r5 = (int) r5
            r2.close()     // Catch: java.io.IOException -> L1f
            goto L23
        L1f:
            r6 = move-exception
            r6.printStackTrace()
        L23:
            return r5
        L24:
            r5 = move-exception
            goto L2b
        L26:
            r6 = move-exception
            goto L3f
        L28:
            r6 = move-exception
            r2 = r5
            r5 = r6
        L2b:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L38
            r2.close()     // Catch: java.io.IOException -> L34
            goto L38
        L34:
            r5 = move-exception
            r5.printStackTrace()
        L38:
            r5 = 2147483647(0x7fffffff, float:NaN)
            return r5
        L3c:
            r5 = move-exception
            r6 = r5
            r5 = r2
        L3f:
            if (r5 == 0) goto L49
            r5.close()     // Catch: java.io.IOException -> L45
            goto L49
        L45:
            r5 = move-exception
            r5.printStackTrace()
        L49:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.httpdns.Impl.SocketProbeImpl.probe(java.lang.String, java.lang.String):int");
    }
}
