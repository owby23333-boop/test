package com.alibaba.sdk.android.httpdns;

import com.alibaba.sdk.android.httpdns.probe.IPProbeItem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static String f2194c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static String[] f19a = {"203.107.1.1"};
    static final String[] b = {"203.107.1.97", "203.107.1.100", "httpdns-sc.aliyuncs.com"};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    static final String[] f20c = new String[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static String f2195d = "80";
    static String PROTOCOL = "http://";
    static int a = 15000;
    static Map<String, String> extra = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static List<IPProbeItem> f18a = null;

    static synchronized void a(List<IPProbeItem> list) {
        f18a = list;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static synchronized boolean a(java.lang.String[] r2) {
        /*
            java.lang.Class<com.alibaba.sdk.android.httpdns.f> r0 = com.alibaba.sdk.android.httpdns.f.class
            monitor-enter(r0)
            if (r2 == 0) goto L2a
            int r1 = r2.length     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L2a
            com.alibaba.sdk.android.httpdns.f.f19a = r2     // Catch: java.lang.Throwable -> L27
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L27
            r2.<init>()     // Catch: java.lang.Throwable -> L27
            java.lang.String r1 = "serverIps:"
            r2.append(r1)     // Catch: java.lang.Throwable -> L27
            java.lang.String[] r1 = com.alibaba.sdk.android.httpdns.f.f19a     // Catch: java.lang.Throwable -> L27
            java.lang.String r1 = java.util.Arrays.toString(r1)     // Catch: java.lang.Throwable -> L27
            r2.append(r1)     // Catch: java.lang.Throwable -> L27
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L27
            com.alibaba.sdk.android.httpdns.i.d(r2)     // Catch: java.lang.Throwable -> L27
            r2 = 1
        L25:
            monitor-exit(r0)
            return r2
        L27:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L2a:
            r2 = 0
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.f.a(java.lang.String[]):boolean");
    }

    static synchronized void c(String str) {
        f2194c = str;
    }

    static synchronized void clearSdnsGlobalParams() {
        extra.clear();
    }

    static synchronized void setHTTPSRequestEnabled(boolean z2) {
        String str;
        if (z2) {
            PROTOCOL = "https://";
            str = "443";
        } else {
            PROTOCOL = "http://";
            str = "80";
        }
        f2195d = str;
    }

    static synchronized void setSdnsGlobalParams(Map<String, String> map) {
        extra.putAll(map);
    }

    static synchronized void setTimeoutInterval(int i2) {
        if (i2 > 0) {
            a = i2;
        }
    }
}
