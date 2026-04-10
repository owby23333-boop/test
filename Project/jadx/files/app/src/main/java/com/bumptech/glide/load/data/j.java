package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: HttpUrlFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements d<InputStream> {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @VisibleForTesting
    static final b f13446y = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final com.bumptech.glide.load.j.g f13447s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f13448t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final b f13449u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private HttpURLConnection f13450v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private InputStream f13451w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private volatile boolean f13452x;

    /* JADX INFO: compiled from: HttpUrlFetcher.java */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.data.j.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: compiled from: HttpUrlFetcher.java */
    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(com.bumptech.glide.load.j.g gVar, int i2) {
        this(gVar, i2, f13446y);
    }

    private static boolean b(int i2) {
        return i2 / 100 == 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.data.d
    public void a(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        StringBuilder sb;
        String str = "HttpUrlFetcher";
        long jA = com.bumptech.glide.util.g.a();
        try {
            try {
                aVar.a(a(this.f13447s.toURL(), 0, null, this.f13447s.getHeaders()));
                str = str;
            } catch (IOException e2) {
                Log.isLoggable("HttpUrlFetcher", 3);
                aVar.a((Exception) e2);
                str = str;
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                double dA = com.bumptech.glide.util.g.a(jA);
                sb.append(dA);
                sb.toString();
                str = dA;
            }
        } catch (Throwable th) {
            if (Log.isLoggable(str, 2)) {
                String str2 = "Finished http url fetcher fetch in " + com.bumptech.glide.util.g.a(jA);
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        this.f13452x = true;
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @VisibleForTesting
    j(com.bumptech.glide.load.j.g gVar, int i2, b bVar) {
        this.f13447s = gVar;
        this.f13448t = i2;
        this.f13449u = bVar;
    }

    private InputStream b(HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f13451w = com.bumptech.glide.util.c.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    String str = "Got non empty content encoding: " + httpURLConnection.getContentEncoding();
                }
                this.f13451w = httpURLConnection.getInputStream();
            }
            return this.f13451w;
        } catch (IOException e2) {
            throw new HttpException("Failed to obtain InputStream", a(httpURLConnection), e2);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f13451w;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f13450v;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f13450v = null;
    }

    private InputStream a(URL url, int i2, URL url2, Map<String, String> map) throws HttpException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop", -1);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f13450v = a(url, map);
            try {
                this.f13450v.connect();
                this.f13451w = this.f13450v.getInputStream();
                if (this.f13452x) {
                    return null;
                }
                int iA = a(this.f13450v);
                if (a(iA)) {
                    return b(this.f13450v);
                }
                if (!b(iA)) {
                    if (iA == -1) {
                        throw new HttpException(iA);
                    }
                    try {
                        throw new HttpException(this.f13450v.getResponseMessage(), iA);
                    } catch (IOException e2) {
                        throw new HttpException("Failed to get a response message", iA, e2);
                    }
                }
                String headerField = this.f13450v.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    try {
                        URL url3 = new URL(url, headerField);
                        b();
                        return a(url3, i2 + 1, url, map);
                    } catch (MalformedURLException e3) {
                        throw new HttpException("Bad redirect url: " + headerField, iA, e3);
                    }
                }
                throw new HttpException("Received empty or null redirect url", iA);
            } catch (IOException e4) {
                throw new HttpException("Failed to connect or obtain data", a(this.f13450v), e4);
            }
        }
        throw new HttpException("Too many (> 5) redirects!", -1);
    }

    private static int a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException unused) {
            Log.isLoggable("HttpUrlFetcher", 3);
            return -1;
        }
    }

    private HttpURLConnection a(URL url, Map<String, String> map) throws HttpException {
        try {
            HttpURLConnection httpURLConnectionA = this.f13449u.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnectionA.addRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnectionA.setConnectTimeout(this.f13448t);
            httpURLConnectionA.setReadTimeout(this.f13448t);
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setDoInput(true);
            httpURLConnectionA.setInstanceFollowRedirects(false);
            return httpURLConnectionA;
        } catch (IOException e2) {
            throw new HttpException("URL.openConnection threw", 0, e2);
        }
    }

    private static boolean a(int i2) {
        return i2 / 100 == 2;
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
