package com.bytedance.sdk.component.m;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public interface wp {
    boolean cancelRequest();

    Bitmap.Config getBitmapConfig();

    int getHeight();

    String getMemoryCacheKey();

    String getRawCacheKey();

    ImageView.ScaleType getScaleType();

    String getUrl();

    int getWidth();
}
