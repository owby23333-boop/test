package com.xiaomi.ad.mediation;

/* JADX INFO: loaded from: classes5.dex */
public class MMAdImage {
    public int mHeight;
    public String mImageUrl;
    public int mWidth;

    public MMAdImage(String str) {
        this.mImageUrl = str;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getUrl() {
        return this.mImageUrl;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public MMAdImage(String str, int i, int i2) {
        this.mImageUrl = str;
        this.mWidth = i;
        this.mHeight = i2;
    }
}
