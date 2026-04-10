package com.bytedance.msdk.api;

/* JADX INFO: loaded from: classes2.dex */
public class AdmobNativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    private int a = 1;
    private boolean b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14060c = true;

    public int getAdChoicesPlacement() {
        return this.a;
    }

    public boolean isRequestMultipleImages() {
        return this.f14060c;
    }

    public boolean isReturnUrlsForImageAssets() {
        return this.b;
    }

    public AdmobNativeAdOptions setAdChoicesPlacement(int i2) {
        this.a = i2;
        return this;
    }

    public AdmobNativeAdOptions setRequestMultipleImages(boolean z2) {
        this.f14060c = z2;
        return this;
    }

    public AdmobNativeAdOptions setReturnUrlsForImageAssets(boolean z2) {
        this.b = z2;
        return this;
    }
}
