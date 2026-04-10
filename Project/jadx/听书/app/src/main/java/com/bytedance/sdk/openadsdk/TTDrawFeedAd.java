package com.bytedance.sdk.openadsdk;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes3.dex */
public interface TTDrawFeedAd extends TTFeedAd {

    /* JADX INFO: loaded from: classes2.dex */
    public interface DrawVideoListener {
        void onClick();

        void onClickRetry();
    }

    void setCanInterruptVideoPlay(boolean z);

    void setDrawVideoListener(DrawVideoListener drawVideoListener);

    void setPauseIcon(Bitmap bitmap, int i);
}
