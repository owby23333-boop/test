package com.bumptech.glide.load.j;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: GlideUrl.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bumptech.glide.load.c {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%;$";

    @Nullable
    private volatile byte[] cacheKeyBytes;
    private int hashCode;
    private final h headers;

    @Nullable
    private String safeStringUrl;

    @Nullable
    private URL safeUrl;

    @Nullable
    private final String stringUrl;

    @Nullable
    private final URL url;

    public g(URL url) {
        this(url, h.a);
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes == null) {
            this.cacheKeyBytes = getCacheKey().getBytes(com.bumptech.glide.load.c.a);
        }
        return this.cacheKeyBytes;
    }

    private String getSafeStringUrl() {
        if (TextUtils.isEmpty(this.safeStringUrl)) {
            String string = this.stringUrl;
            if (TextUtils.isEmpty(string)) {
                URL url = this.url;
                com.bumptech.glide.util.k.a(url);
                string = url.toString();
            }
            this.safeStringUrl = Uri.encode(string, ALLOWED_URI_CHARS);
        }
        return this.safeStringUrl;
    }

    private URL getSafeUrl() throws MalformedURLException {
        if (this.safeUrl == null) {
            this.safeUrl = new URL(getSafeStringUrl());
        }
        return this.safeUrl;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return getCacheKey().equals(gVar.getCacheKey()) && this.headers.equals(gVar.headers);
    }

    public String getCacheKey() {
        String str = this.stringUrl;
        if (str != null) {
            return str;
        }
        URL url = this.url;
        com.bumptech.glide.util.k.a(url);
        return url.toString();
    }

    public Map<String, String> getHeaders() {
        return this.headers.getHeaders();
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = getCacheKey().hashCode();
            this.hashCode = (this.hashCode * 31) + this.headers.hashCode();
        }
        return this.hashCode;
    }

    public String toString() {
        return getCacheKey();
    }

    public String toStringUrl() {
        return getSafeStringUrl();
    }

    public URL toURL() throws MalformedURLException {
        return getSafeUrl();
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(getCacheKeyBytes());
    }

    public g(String str) {
        this(str, h.a);
    }

    public g(URL url, h hVar) {
        com.bumptech.glide.util.k.a(url);
        this.url = url;
        this.stringUrl = null;
        com.bumptech.glide.util.k.a(hVar);
        this.headers = hVar;
    }

    public g(String str, h hVar) {
        this.url = null;
        com.bumptech.glide.util.k.a(str);
        this.stringUrl = str;
        com.bumptech.glide.util.k.a(hVar);
        this.headers = hVar;
    }
}
