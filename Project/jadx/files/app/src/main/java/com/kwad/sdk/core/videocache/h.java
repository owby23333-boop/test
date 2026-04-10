package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.core.network.s;
import com.kwad.sdk.utils.an;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements l {
    private final com.kwad.sdk.core.videocache.c.b amT;
    private final com.kwad.sdk.core.videocache.a.b amU;
    private m anp;
    private HttpURLConnection anq;
    private InputStream anr;

    public h(h hVar) {
        this.anp = hVar.anp;
        this.amT = hVar.amT;
        this.amU = hVar.amU;
    }

    public h(String str, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.amT = (com.kwad.sdk.core.videocache.c.b) an.checkNotNull(bVar);
        this.amU = (com.kwad.sdk.core.videocache.a.b) an.checkNotNull(bVar2);
        m mVarCI = bVar.cI(str);
        this.anp = mVarCI == null ? new m(str, -2147483648L, k.cG(str)) : mVarCI;
    }

    private long a(HttpURLConnection httpURLConnection, long j2, int i2) {
        long jC = c(httpURLConnection);
        return i2 == 200 ? jC : i2 == 206 ? jC + j2 : this.anp.anE;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.amU.yX().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private HttpURLConnection b(long j2, int i2) throws IOException, ProxyCacheException {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z2;
        String headerField = this.anp.url;
        int i3 = 0;
        do {
            StringBuilder sb = new StringBuilder("Open connection ");
            if (j2 > 0) {
                str = " with offset " + j2;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(headerField);
            com.kwad.sdk.core.d.b.d("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            s.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, headerField);
            if (j2 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j2 + "-");
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            q.b(httpURLConnection);
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

    private static long c(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private void yP() throws Throwable {
        HttpURLConnection httpURLConnectionB;
        com.kwad.sdk.core.d.b.d("HttpUrlSource", "Read content info from " + this.anp.url);
        InputStream inputStream = null;
        try {
            httpURLConnectionB = b(0L, 10000);
        } catch (IOException unused) {
            httpURLConnectionB = null;
        } catch (Throwable th) {
            th = th;
            httpURLConnectionB = null;
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.a(httpURLConnectionB);
            throw th;
        }
        try {
            try {
                long jC = c(httpURLConnectionB);
                String contentType = httpURLConnectionB.getContentType();
                inputStream = httpURLConnectionB.getInputStream();
                this.anp = new m(this.anp.url, jC, contentType);
                this.amT.a(this.anp.url, this.anp);
                com.kwad.sdk.core.d.b.d("HttpUrlSource", "Source info fetched: " + this.anp);
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.a(httpURLConnectionB);
                throw th;
            }
        } catch (IOException unused2) {
            com.kwad.sdk.core.d.b.e("HttpUrlSource", "Error fetching info from " + this.anp.url);
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        com.kwad.sdk.crash.utils.b.a(httpURLConnectionB);
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final void U(long j2) throws ProxyCacheException {
        try {
            this.anq = b(j2, -1);
            String contentType = this.anq.getContentType();
            this.anr = new BufferedInputStream(this.anq.getInputStream(), 8192);
            this.anp = new m(this.anp.url, a(this.anq, j2, this.anq.getResponseCode()), contentType);
            this.amT.a(this.anp.url, this.anp);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening connection for " + this.anp.url + " with offset " + j2, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final void close() {
        HttpURLConnection httpURLConnection = this.anq;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.d.b.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final synchronized long length() {
        if (this.anp.anE == -2147483648L) {
            yP();
        }
        return this.anp.anE;
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.anr;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.anp.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, 8192);
        } catch (InterruptedIOException e2) {
            throw new InterruptedProxyCacheException("Reading source " + this.anp.url + " is interrupted", e2);
        } catch (IOException e3) {
            throw new ProxyCacheException("Error reading data from " + this.anp.url, e3);
        }
    }

    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.anp + "}";
    }

    public final synchronized String yQ() {
        if (TextUtils.isEmpty(this.anp.anF)) {
            yP();
        }
        return this.anp.anF;
    }
}
