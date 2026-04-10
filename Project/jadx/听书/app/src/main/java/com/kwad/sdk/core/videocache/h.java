package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.utils.ax;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class h extends p {
    private final com.kwad.sdk.core.videocache.d.c aKN;
    private final com.kwad.sdk.core.videocache.b.b aKO;
    private n aLl;
    private HttpURLConnection aLm;
    private InputStream aLn;

    public h(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aKN = (com.kwad.sdk.core.videocache.d.c) ax.checkNotNull(cVar);
        this.aKO = (com.kwad.sdk.core.videocache.b.b) ax.checkNotNull(bVar);
        n nVarES = cVar.eS(str);
        this.aLl = nVarES == null ? new n(str, -2147483648L, l.eQ(str)) : nVarES;
    }

    public h(h hVar) {
        this.aLl = hVar.aLl;
        this.aKN = hVar.aKN;
        this.aKO = hVar.aKO;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final synchronized long length() {
        if (this.aLl.aLB == -2147483648L) {
            Kv();
        }
        if (this.aLl.aLB == -2147483648L) {
            Kt();
        }
        return this.aLl.aLB;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void aK(long j) throws ProxyCacheException {
        try {
            HttpURLConnection httpURLConnectionE = e(j, -1);
            this.aLm = httpURLConnectionE;
            String contentType = httpURLConnectionE.getContentType();
            this.aLn = new BufferedInputStream(this.aLm.getInputStream(), 1024);
            HttpURLConnection httpURLConnection = this.aLm;
            n nVar = new n(this.aLl.url, a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.aLl = nVar;
            this.aKN.a(nVar.url, this.aLl);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + this.aLl.url + " with offset " + j, e);
        }
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long jD = d(httpURLConnection);
        return i == 200 ? jD : i == 206 ? jD + j : this.aLl.aLB;
    }

    private static long d(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_LENGTH);
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        HttpURLConnection httpURLConnection = this.aLm;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.aLn;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.aLl.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, 1024);
        } catch (InterruptedIOException e) {
            throw new InterruptedProxyCacheException("Reading source " + this.aLl.url + " is interrupted", e);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading data from " + this.aLl.url, e2);
        }
    }

    private void Kt() throws Throwable {
        HttpURLConnection httpURLConnectionE;
        com.kwad.sdk.core.d.c.d("HttpUrlSource", "Read content info from " + this.aLl.url);
        InputStream inputStream = null;
        try {
            httpURLConnectionE = e(0L, 10000);
        } catch (IOException unused) {
            httpURLConnectionE = null;
        } catch (Throwable th) {
            th = th;
            httpURLConnectionE = null;
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnectionE);
            throw th;
        }
        try {
            try {
                long jD = d(httpURLConnectionE);
                String contentType = httpURLConnectionE.getContentType();
                inputStream = httpURLConnectionE.getInputStream();
                n nVar = new n(this.aLl.url, jD, contentType);
                this.aLl = nVar;
                this.aKN.a(nVar.url, this.aLl);
                com.kwad.sdk.core.d.c.d("HttpUrlSource", "Source info fetched: " + this.aLl);
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnectionE);
                throw th;
            }
        } catch (IOException unused2) {
            com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error fetching info from " + this.aLl.url);
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnectionE);
    }

    private HttpURLConnection e(long j, int i) throws IOException, ProxyCacheException {
        HttpURLConnection httpURLConnection;
        boolean z;
        String headerField = this.aLl.url;
        int i2 = 0;
        do {
            com.kwad.sdk.core.d.c.d("HttpUrlSource", "Open connection " + (j > 0 ? " with offset " + j : "") + " to " + headerField);
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            r.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, headerField);
            if (j > 0) {
                httpURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + j + "-");
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            com.kwad.sdk.core.network.p.b(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.aKO.KC().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final synchronized String Ku() {
        if (TextUtils.isEmpty(this.aLl.aLC)) {
            Kv();
        }
        if (TextUtils.isEmpty(this.aLl.aLC)) {
            Kt();
        }
        return this.aLl.aLC;
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String getUrl() {
        return this.aLl.url;
    }

    private void Kv() {
        n nVarES;
        com.kwad.sdk.core.videocache.d.c cVar = this.aKN;
        if (cVar == null || !(cVar instanceof com.kwad.sdk.core.videocache.d.b) || (nVarES = cVar.eS(getUrl())) == null || TextUtils.isEmpty(nVarES.aLC) || nVarES.aLB == -2147483648L) {
            return;
        }
        this.aLl = nVarES;
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.aLl + "}";
    }
}
