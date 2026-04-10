package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.google.common.net.HttpHeaders;
import com.kwad.sdk.utils.ax;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends p {
    private final com.kwad.sdk.core.videocache.d.c aKN;
    private final com.kwad.sdk.core.videocache.b.b aKO;
    private n aLl;
    private InputStream aLn;
    private OkHttpClient aLs = new OkHttpClient();

    public j(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aKN = (com.kwad.sdk.core.videocache.d.c) ax.checkNotNull(cVar);
        this.aKO = (com.kwad.sdk.core.videocache.b.b) ax.checkNotNull(bVar);
        n nVarES = cVar.eS(str);
        this.aLl = nVarES == null ? new n(str, -2147483648L, l.eQ(str)) : nVarES;
    }

    public j(j jVar) {
        this.aLl = jVar.aLl;
        this.aKN = jVar.aKN;
        this.aKO = jVar.aKO;
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

    private void Kv() {
        n nVarES;
        com.kwad.sdk.core.videocache.d.c cVar = this.aKN;
        if (cVar == null || !(cVar instanceof com.kwad.sdk.core.videocache.d.b) || (nVarES = cVar.eS(getUrl())) == null || TextUtils.isEmpty(nVarES.aLC) || nVarES.aLB == -2147483648L) {
            return;
        }
        this.aLl = nVarES;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void aK(long j) throws ProxyCacheException {
        try {
            Response responseF = f(j, -1);
            String mediaType = responseF.body().get$contentType().getMediaType();
            long jA = a(responseF, j);
            this.aLn = new BufferedInputStream(responseF.body().byteStream(), 1024);
            n nVar = new n(this.aLl.url, jA, mediaType);
            this.aLl = nVar;
            this.aKN.a(nVar.url, this.aLl);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + getUrl() + " with offset " + j, e);
        }
    }

    private long a(Response response, long j) {
        int iCode = response.code();
        long contentLength = response.body().getContentLength();
        return iCode == 200 ? contentLength : iCode == 206 ? contentLength + j : this.aLl.aLB;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aLn);
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

    private void Kt() {
        Response responseDP = null;
        try {
            try {
                responseDP = dP(10000);
            } catch (IOException unused) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error fetching info from " + this.aLl.url);
                if (0 == 0 || responseDP.body() == null) {
                    return;
                }
            }
            if (responseDP == null || !responseDP.isSuccessful()) {
                throw new ProxyCacheException("Fail to fetchContentInfo: " + getUrl());
            }
            n nVar = new n(this.aLl.url, c(responseDP), responseDP.header(HttpHeaders.CONTENT_TYPE));
            this.aLl = nVar;
            this.aKN.a(nVar.url, this.aLl);
            com.kwad.sdk.core.d.c.d("HttpUrlSource", "Source info fetched: " + this.aLl);
            if (responseDP == null || responseDP.body() == null) {
                return;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(responseDP.body());
        } catch (Throwable th) {
            if (0 != 0 && responseDP.body() != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(responseDP.body());
            }
            throw th;
        }
    }

    private static long c(Response response) {
        String strHeader = response.header(HttpHeaders.CONTENT_LENGTH);
        if (strHeader == null) {
            return -1L;
        }
        return Long.parseLong(strHeader);
    }

    private Response f(long j, int i) throws IOException, ProxyCacheException {
        Response responseExecute;
        OkHttpClient.Builder builderNewBuilder = this.aLs.newBuilder();
        int i2 = 0;
        builderNewBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            builderNewBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        this.aLs = builderNewBuilder.build();
        String url = getUrl();
        boolean zIsRedirect = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.get();
            builder.url(url);
            if (j > 0) {
                builder.addHeader(HttpHeaders.RANGE, "bytes=" + j + "-");
            }
            responseExecute = this.aLs.newCall(builder.build()).execute();
            if (responseExecute.isRedirect()) {
                url = responseExecute.header(HttpHeaders.LOCATION);
                zIsRedirect = responseExecute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (zIsRedirect);
        return responseExecute;
    }

    private Response dP(int i) throws IOException, ProxyCacheException {
        Response responseExecute;
        OkHttpClient.Builder builderNewBuilder = new OkHttpClient().newBuilder();
        builderNewBuilder.connectTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
        builderNewBuilder.readTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
        builderNewBuilder.writeTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
        int i2 = 0;
        builderNewBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            builderNewBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        this.aLs = builderNewBuilder.build();
        String url = getUrl();
        boolean zIsRedirect = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.head();
            builder.url(url);
            responseExecute = this.aLs.newCall(builder.build()).execute();
            if (responseExecute.isRedirect()) {
                url = responseExecute.header(HttpHeaders.LOCATION);
                zIsRedirect = responseExecute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (zIsRedirect);
        return responseExecute;
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

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.aLl + "}";
    }
}
