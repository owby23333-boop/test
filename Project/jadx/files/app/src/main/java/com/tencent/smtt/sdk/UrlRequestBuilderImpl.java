package com.tencent.smtt.sdk;

import android.util.Pair;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class UrlRequestBuilderImpl extends UrlRequest.Builder {
    private static final String a = "UrlRequestBuilderImpl";
    private final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final UrlRequest.Callback f18949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f18950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f18951e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f18953g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f18955i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f18956j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f18957k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f18958l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayList<Pair<String, String>> f18952f = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18954h = 3;

    public UrlRequestBuilderImpl(String str, UrlRequest.Callback callback, Executor executor) {
        if (str == null) {
            throw new NullPointerException("URL is required.");
        }
        if (callback == null) {
            throw new NullPointerException("Callback is required.");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required.");
        }
        this.b = str;
        this.f18949c = callback;
        this.f18950d = executor;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl addHeader(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        if ("Accept-Encoding".equalsIgnoreCase(str)) {
            return this;
        }
        this.f18952f.add(Pair.create(str, str2));
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest build() throws NullPointerException {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            return null;
        }
        DexLoader dexLoaderB = wVarA.c().b();
        UrlRequest urlRequest = (UrlRequest) dexLoaderB.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[]{String.class, Integer.TYPE, UrlRequest.Callback.class, Executor.class, Boolean.TYPE, String.class, ArrayList.class, String.class, byte[].class, String.class, String.class}, this.b, Integer.valueOf(this.f18954h), this.f18949c, this.f18950d, Boolean.valueOf(this.f18953g), this.f18951e, this.f18952f, this.f18955i, this.f18956j, this.f18957k, this.f18958l);
        if (urlRequest == null) {
            urlRequest = (UrlRequest) dexLoaderB.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[]{String.class, Integer.TYPE, UrlRequest.Callback.class, Executor.class, Boolean.TYPE, String.class, ArrayList.class, String.class}, this.b, Integer.valueOf(this.f18954h), this.f18949c, this.f18950d, Boolean.valueOf(this.f18953g), this.f18951e, this.f18952f, this.f18955i);
        }
        if (urlRequest == null) {
            urlRequest = (UrlRequest) dexLoaderB.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[]{String.class, Integer.TYPE, UrlRequest.Callback.class, Executor.class, Boolean.TYPE, String.class, ArrayList.class}, this.b, Integer.valueOf(this.f18954h), this.f18949c, this.f18950d, Boolean.valueOf(this.f18953g), this.f18951e, this.f18952f);
        }
        if (urlRequest == null) {
            urlRequest = (UrlRequest) dexLoaderB.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "UrlRequest_getX5UrlRequestProvider", new Class[]{String.class, Integer.TYPE, UrlRequest.Callback.class, Executor.class, Boolean.TYPE, String.class, ArrayList.class, String.class, byte[].class, String.class, String.class}, this.b, Integer.valueOf(this.f18954h), this.f18949c, this.f18950d, Boolean.valueOf(this.f18953g), this.f18951e, this.f18952f, this.f18955i, this.f18956j, this.f18957k, this.f18958l);
        }
        if (urlRequest != null) {
            return urlRequest;
        }
        throw new NullPointerException("UrlRequest build fail");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl disableCache() {
        this.f18953g = true;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl setDns(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("host and address are required.");
        }
        this.f18957k = str;
        this.f18958l = str2;
        try {
            w wVarA = w.a();
            if (wVarA != null && wVarA.b()) {
                wVarA.c().b().invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "setDns", new Class[]{String.class, String.class}, this.f18957k, this.f18958l);
            }
        } catch (Exception unused) {
        }
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setHttpMethod(String str) {
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.f18951e = str;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl setPriority(int i2) {
        this.f18954h = i2;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setRequestBody(String str) {
        if (str == null) {
            throw new NullPointerException("Body is required.");
        }
        this.f18955i = str;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setRequestBodyBytes(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("Body is required.");
        }
        this.f18956j = bArr;
        return this;
    }
}
