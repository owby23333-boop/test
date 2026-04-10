package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
class q implements Callable<String[]> {
    private static Context a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private s f37a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2219d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private long f38d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f2220e;
    private Map<String, String> extra;
    private String hostName;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2221j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f2222k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f2223l;
    private static d hostManager = d.a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Object f36a = new Object();

    q(String str, s sVar) {
        this.f2219d = 1;
        this.f2222k = null;
        this.f2220e = f.f20c;
        this.f2221j = false;
        this.f2223l = null;
        this.extra = new HashMap();
        this.f38d = 0L;
        this.hostName = str;
        this.f37a = sVar;
    }

    q(String str, s sVar, Map<String, String> map, String str2) {
        this.f2219d = 1;
        this.f2222k = null;
        this.f2220e = f.f20c;
        this.f2221j = false;
        this.f2223l = null;
        this.extra = new HashMap();
        this.f38d = 0L;
        this.hostName = str;
        this.f37a = sVar;
        this.f2223l = str2;
        this.extra.putAll(map);
    }

    private boolean d(String str) {
        return str.matches("[a-zA-Z0-9\\-_]+");
    }

    private boolean e(String str) {
        return str.matches("[a-zA-Z0-9\\-_=]+");
    }

    private String getExtra() {
        boolean z2;
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = this.extra;
        boolean z3 = true;
        if (map != null) {
            z2 = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("&sdns-");
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                if (!d(entry.getKey())) {
                    i.f("设置自定义参数失败，自定义key不合法：" + entry.getKey());
                    z3 = false;
                }
                if (!e(entry.getValue())) {
                    i.f("设置自定义参数失败，自定义value不合法：" + entry.getValue());
                    z2 = false;
                }
            }
        } else {
            z2 = true;
        }
        if (z3 && z2) {
            String string = sb.toString();
            if (string.getBytes("UTF-8").length <= 1000) {
                return string;
            }
            i.f("设置自定义参数失败，自定义参数过长");
        }
        return "";
    }

    static void setContext(Context context) {
        a = context;
    }

    public void a(int i2) {
        if (i2 >= 0) {
            this.f2219d = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03c6 A[Catch: all -> 0x03f5, TryCatch #2 {all -> 0x03f5, blocks: (B:80:0x03b8, B:82:0x03c6, B:83:0x03cf), top: B:112:0x03b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03cf A[Catch: all -> 0x03f5, TRY_LEAVE, TryCatch #2 {all -> 0x03f5, blocks: (B:80:0x03b8, B:82:0x03c6, B:83:0x03cf), top: B:112:0x03b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03dc A[Catch: IOException -> 0x03e0, TRY_ENTER, TryCatch #6 {IOException -> 0x03e0, blocks: (B:66:0x0392, B:68:0x0397, B:87:0x03dc, B:91:0x03e4), top: B:116:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03e4 A[Catch: IOException -> 0x03e0, TRY_LEAVE, TryCatch #6 {IOException -> 0x03e0, blocks: (B:66:0x0392, B:68:0x0397, B:87:0x03dc, B:91:0x03e4), top: B:116:0x0046 }] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v65 */
    /* JADX WARN: Type inference failed for: r3v66 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String[] call() {
        /*
            Method dump skipped, instruction units count: 1039
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.q.call():java.lang.String[]");
    }
}
