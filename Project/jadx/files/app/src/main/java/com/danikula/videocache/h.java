package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: HttpUrlSource.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements n {
    private final com.danikula.videocache.s.b a;
    private final com.danikula.videocache.r.b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private o f14778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HttpURLConnection f14779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InputStream f14780e;

    public h(String str, com.danikula.videocache.s.b bVar, com.danikula.videocache.r.b bVar2) {
        k.a(bVar);
        this.a = bVar;
        k.a(bVar2);
        this.b = bVar2;
        o oVar = bVar.get(str);
        this.f14778c = oVar == null ? new o(str, -2147483648L, m.d(str)) : oVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c() throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Read content info from "
            r0.append(r1)
            com.danikula.videocache.o r1 = r7.f14778c
            java.lang.String r1 = r1.a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.danikula.videocache.j.a(r0)
            r0 = 0
            r2 = 10000(0x2710, float:1.4013E-41)
            r3 = 0
            java.net.HttpURLConnection r0 = r7.a(r0, r2)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L64
            long r1 = r7.a(r0)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            java.lang.String r4 = r0.getContentType()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            java.io.InputStream r3 = r0.getInputStream()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            com.danikula.videocache.o r5 = new com.danikula.videocache.o     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            com.danikula.videocache.o r6 = r7.f14778c     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            java.lang.String r6 = r6.a     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            r5.<init>(r6, r1, r4)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            r7.f14778c = r5     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            com.danikula.videocache.s.b r1 = r7.a     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            com.danikula.videocache.o r2 = r7.f14778c     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            java.lang.String r2 = r2.a     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            com.danikula.videocache.o r4 = r7.f14778c     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            r1.a(r2, r4)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            r1.<init>()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            java.lang.String r2 = "Source info fetched: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            com.danikula.videocache.o r2 = r7.f14778c     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            r1.append(r2)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            com.danikula.videocache.j.a(r1)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L65
            com.danikula.videocache.m.a(r3)
            if (r0 == 0) goto L85
            goto L82
        L5f:
            r1 = move-exception
            goto L86
        L61:
            r1 = move-exception
            r0 = r3
            goto L86
        L64:
            r0 = r3
        L65:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5f
            r1.<init>()     // Catch: java.lang.Throwable -> L5f
            java.lang.String r2 = "Error fetching info from "
            r1.append(r2)     // Catch: java.lang.Throwable -> L5f
            com.danikula.videocache.o r2 = r7.f14778c     // Catch: java.lang.Throwable -> L5f
            java.lang.String r2 = r2.a     // Catch: java.lang.Throwable -> L5f
            r1.append(r2)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L5f
            com.danikula.videocache.j.b(r1)     // Catch: java.lang.Throwable -> L5f
            com.danikula.videocache.m.a(r3)
            if (r0 == 0) goto L85
        L82:
            r0.disconnect()
        L85:
            return
        L86:
            com.danikula.videocache.m.a(r3)
            if (r0 == 0) goto L8e
            r0.disconnect()
        L8e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.h.c():void");
    }

    @Override // com.danikula.videocache.n
    public void a(long j2) throws ProxyCacheException {
        try {
            this.f14779d = a(j2, -1);
            String contentType = this.f14779d.getContentType();
            this.f14780e = new BufferedInputStream(this.f14779d.getInputStream(), 8192);
            this.f14778c = new o(this.f14778c.a, a(this.f14779d, j2, this.f14779d.getResponseCode()), contentType);
            this.a.a(this.f14778c.a, this.f14778c);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening connection for " + this.f14778c.a + " with offset " + j2, e2);
        }
    }

    public String b() {
        return this.f14778c.a;
    }

    @Override // com.danikula.videocache.n
    public void close() throws ProxyCacheException {
        HttpURLConnection httpURLConnection = this.f14779d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                j.b("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.danikula.videocache.n
    public synchronized long length() throws ProxyCacheException {
        if (this.f14778c.b == -2147483648L) {
            c();
        }
        return this.f14778c.b;
    }

    @Override // com.danikula.videocache.n
    public int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.f14780e;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.f14778c.a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e2) {
            throw new InterruptedProxyCacheException("Reading source " + this.f14778c.a + " is interrupted", e2);
        } catch (IOException e3) {
            throw new ProxyCacheException("Error reading data from " + this.f14778c.a, e3);
        }
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f14778c + "}";
    }

    public h(h hVar) {
        this.f14778c = hVar.f14778c;
        this.a = hVar.a;
        this.b = hVar.b;
    }

    private long a(HttpURLConnection httpURLConnection, long j2, int i2) throws IOException {
        long jA = a(httpURLConnection);
        return i2 == 200 ? jA : i2 == 206 ? jA + j2 : this.f14778c.b;
    }

    private long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private HttpURLConnection a(long j2, int i2) throws IOException, ProxyCacheException {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z2;
        String headerField = this.f14778c.a;
        int i3 = 0;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (j2 > 0) {
                str = " with offset " + j2;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(headerField);
            j.a(sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            a(httpURLConnection, headerField);
            if (j2 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j2 + "-");
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z2 = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z2) {
                headerField = httpURLConnection.getHeaderField("Location");
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i3);
            }
        } while (z2);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.b.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public synchronized String a() throws ProxyCacheException {
        if (TextUtils.isEmpty(this.f14778c.f14790c)) {
            c();
        }
        return this.f14778c.f14790c;
    }
}
