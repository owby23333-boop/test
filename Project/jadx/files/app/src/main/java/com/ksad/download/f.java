package com.ksad.download;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.h;
import com.kwad.sdk.utils.p;
import com.kwai.filedownloader.e.c;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements com.kwai.filedownloader.kwai.b {
    private Request bA;
    private Response bB;
    private final OkHttpClient by;
    private final Request.Builder bz;

    public static class a implements c.b {
        private OkHttpClient.Builder bC;
        private volatile OkHttpClient by;

        public a() {
        }

        public a(boolean z2) {
            this.bC = z2 ? f.Z() : f.Y();
        }

        @Override // com.kwai.filedownloader.e.c.b
        public final com.kwai.filedownloader.kwai.b q(String str) {
            if (this.by == null) {
                synchronized (a.class) {
                    if (this.by == null) {
                        this.by = this.bC != null ? this.bC.build() : new OkHttpClient();
                        this.bC = null;
                    }
                }
            }
            return new f(str, this.by, (byte) 0);
        }
    }

    private f(String str, OkHttpClient okHttpClient) {
        this(new Request.Builder().url(str), okHttpClient);
    }

    /* synthetic */ f(String str, OkHttpClient okHttpClient, byte b) {
        this(str, okHttpClient);
    }

    private f(Request.Builder builder, OkHttpClient okHttpClient) {
        this.bz = builder;
        this.by = okHttpClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OkHttpClient.Builder Y() {
        return new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.ksad.download.a.a()).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OkHttpClient.Builder Z() {
        return new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.ksad.download.a.a()).protocols(Util.immutableList(new Protocol[]{Protocol.HTTP_1_1})).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true);
    }

    private String p(String str) {
        String strO = o("Content-Type");
        String extension = p.getExtension(str);
        boolean zIsEmpty = TextUtils.isEmpty(strO);
        String str2 = com.anythink.china.common.a.a.f6395g;
        if (zIsEmpty || !TextUtils.isEmpty(extension)) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return System.currentTimeMillis() + com.anythink.china.common.a.a.f6395g;
        }
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(strO);
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        if (!TextUtils.isEmpty(extensionFromMimeType)) {
            str2 = "." + extensionFromMimeType;
        }
        sb.append(str2);
        return sb.toString();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final Map<String, List<String>> V() {
        if (this.bA == null) {
            this.bA = this.bz.build();
        }
        return this.bA.headers().toMultimap();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final Map<String, List<String>> W() {
        Response response = this.bB;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void X() {
        this.bA = null;
        Response response = this.bB;
        if (response != null && response.body() != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(this.bB.body());
        }
        this.bB = null;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void addHeader(String str, String str2) {
        this.bz.addHeader(str, str2);
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void execute() {
        if (this.bA == null) {
            this.bA = this.bz.build();
        }
        this.bB = this.by.newCall(this.bA).execute();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final InputStream getInputStream() {
        Response response = this.bB;
        if (response == null) {
            throw new IllegalStateException("Please invoke #execute first!");
        }
        return ((h) ServiceProvider.get(h.class)).wrapInputStream(response.body().byteStream());
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final int getResponseCode() {
        Response response = this.bB;
        if (response != null) {
            return response.code();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final String o(String str) {
        String str2;
        if (!DownloadUtils.CONTENT_DISPOSITION.equals(str)) {
            Response response = this.bB;
            if (response == null) {
                return null;
            }
            return response.header(str);
        }
        try {
        } catch (Exception unused) {
            str2 = "";
        }
        if (!TextUtils.isEmpty(com.kwai.filedownloader.e.f.fl(this.bB.header(str)))) {
            return this.bB.header(str);
        }
        str2 = this.bB.request().url().pathSegments().get(r3.size() - 1);
        return "attachment; filename=\"" + p(str2) + "\"";
    }
}
