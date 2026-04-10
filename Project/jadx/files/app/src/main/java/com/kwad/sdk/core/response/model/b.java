package com.kwad.sdk.core.response.model;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private boolean Rp = true;
    private boolean alt;
    private int mHeight;
    private String mUrl;
    private int mWidth;

    public b(String str, int i2, int i3, boolean z2, boolean z3) {
        this.mUrl = str;
        this.mWidth = i2;
        this.mHeight = i3;
        this.alt = z3;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public final int getWidth() {
        return this.mWidth;
    }
}
