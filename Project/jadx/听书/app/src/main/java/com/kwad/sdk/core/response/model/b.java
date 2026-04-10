package com.kwad.sdk.core.response.model;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private boolean aIW;
    private boolean aaD = true;
    private int mHeight;
    private String mUrl;
    private int mWidth;

    public b(String str, int i, int i2, boolean z, boolean z2) {
        this.mUrl = str;
        this.mWidth = i;
        this.mHeight = i2;
        this.aIW = z2;
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final int getWidth() {
        return this.mWidth;
    }
}
