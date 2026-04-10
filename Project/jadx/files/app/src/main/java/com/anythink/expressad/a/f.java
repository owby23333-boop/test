package com.anythink.expressad.a;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.anythink.expressad.foundation.h.o;
import com.umeng.message.utils.HttpRequest;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    private static final String a = "f";
    private static final int b = 60000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.anythink.expressad.d.a f8062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8064e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f8065f = 3145728;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f8066g;

    public static class a {
        public String a;
        public String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8068d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8069e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8070f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f8071g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f8072h;

        public final String a() {
            return "statusCode=" + this.f8070f + ", location=" + this.a + ", contentType=" + this.b + ", contentLength=" + this.f8069e + ", contentEncoding=" + this.f8067c + ", referer=" + this.f8068d;
        }

        public final String toString() {
            return "http响应头：...\nstatusCode=" + this.f8070f + ", location=" + this.a + ", contentType=" + this.b + ", contentLength=" + this.f8069e + ", contentEncoding=" + this.f8067c + ", referer=" + this.f8068d;
        }
    }

    public f() {
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        this.f8062c = com.anythink.expressad.d.b.b();
        if (this.f8062c == null) {
            com.anythink.expressad.d.b.a();
            this.f8062c = com.anythink.expressad.d.b.c();
        }
    }

    private void a(boolean z2) {
        this.f8064e = z2;
    }

    public final a a(String str, boolean z2, boolean z3, com.anythink.expressad.foundation.d.c cVar) {
        HttpURLConnection httpURLConnection;
        byte[] bytes;
        if (!URLUtil.isNetworkUrl(str)) {
            return null;
        }
        String strReplace = str.replace(" ", "%20");
        URLUtil.isHttpsUrl(strReplace);
        o.b(a, strReplace);
        this.f8066g = new a();
        try {
            httpURLConnection = (HttpURLConnection) new URL(strReplace).openConnection();
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.setRequestMethod("GET");
            if ((!z2 && !z3) || cVar == null) {
                httpURLConnection.setRequestProperty("User-Agent", com.anythink.core.common.k.d.i());
            }
            if (z2 && cVar != null && cVar.E() == 1) {
                httpURLConnection.setRequestProperty("User-Agent", com.anythink.core.common.k.d.i());
            }
            if (z3 && cVar != null && cVar.D() == 1) {
                httpURLConnection.setRequestProperty("User-Agent", com.anythink.core.common.k.d.i());
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (this.f8062c.v() && !TextUtils.isEmpty(this.f8063d)) {
                httpURLConnection.setRequestProperty("referer", this.f8063d);
            }
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(60000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.connect();
            this.f8066g.a = httpURLConnection.getHeaderField("Location");
            this.f8066g.f8068d = httpURLConnection.getHeaderField(HttpRequest.HEADER_REFERER);
            this.f8066g.f8070f = httpURLConnection.getResponseCode();
            this.f8066g.b = httpURLConnection.getContentType();
            this.f8066g.f8069e = httpURLConnection.getContentLength();
            this.f8066g.f8067c = httpURLConnection.getContentEncoding();
            o.b(a, this.f8066g.toString());
            boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(this.f8066g.f8067c);
            if (this.f8066g.f8070f == 200 && this.f8064e && this.f8066g.f8069e > 0 && this.f8066g.f8069e < 3145728 && !TextUtils.isEmpty(strReplace) && !strReplace.endsWith(com.anythink.china.common.a.a.f6395g)) {
                try {
                    String strA = a(httpURLConnection.getInputStream(), zEqualsIgnoreCase);
                    if (!TextUtils.isEmpty(strA) && (bytes = strA.getBytes()) != null && bytes.length > 0 && bytes.length < 3145728) {
                        this.f8066g.f8071g = strA.trim();
                    }
                } catch (Throwable unused) {
                }
            }
            this.f8063d = strReplace;
            return this.f8066g;
        } catch (Throwable th2) {
            th = th2;
            try {
                this.f8066g.f8072h = th.getMessage();
                o.c("http jump", "connecting");
                a aVar = this.f8066g;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return aVar;
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033 A[Catch: all -> 0x002c, TryCatch #5 {all -> 0x002c, blocks: (B:4:0x0008, B:5:0x000e, B:19:0x002f, B:21:0x0033, B:22:0x0042), top: B:38:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047 A[Catch: Exception -> 0x004b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x004b, blocks: (B:10:0x0022, B:24:0x0047), top: B:41:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.io.InputStream r4, boolean r5) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            if (r5 == 0) goto Le
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r4 = r5
        Le:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
        L18:
            java.lang.String r4 = r5.readLine()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L29
            if (r4 == 0) goto L22
            r0.append(r4)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L29
            goto L18
        L22:
            r5.close()     // Catch: java.lang.Exception -> L4b
            goto L4f
        L26:
            r4 = move-exception
            r1 = r5
            goto L54
        L29:
            r4 = move-exception
            r1 = r5
            goto L2f
        L2c:
            r4 = move-exception
            goto L54
        L2e:
            r4 = move-exception
        L2f:
            com.anythink.expressad.a.f$a r5 = r3.f8066g     // Catch: java.lang.Throwable -> L2c
            if (r5 != 0) goto L42
            com.anythink.expressad.a.f$a r5 = new com.anythink.expressad.a.f$a     // Catch: java.lang.Throwable -> L2c
            r5.<init>()     // Catch: java.lang.Throwable -> L2c
            r3.f8066g = r5     // Catch: java.lang.Throwable -> L2c
            com.anythink.expressad.a.f$a r5 = r3.f8066g     // Catch: java.lang.Throwable -> L2c
            java.lang.String r2 = r4.getMessage()     // Catch: java.lang.Throwable -> L2c
            r5.f8072h = r2     // Catch: java.lang.Throwable -> L2c
        L42:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L4f
            r1.close()     // Catch: java.lang.Exception -> L4b
            goto L4f
        L4b:
            r4 = move-exception
            r4.printStackTrace()
        L4f:
            java.lang.String r4 = r0.toString()
            return r4
        L54:
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.lang.Exception -> L5a
            goto L5e
        L5a:
            r5 = move-exception
            r5.printStackTrace()
        L5e:
            goto L60
        L5f:
            throw r4
        L60:
            goto L5f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.f.a(java.io.InputStream, boolean):java.lang.String");
    }
}
