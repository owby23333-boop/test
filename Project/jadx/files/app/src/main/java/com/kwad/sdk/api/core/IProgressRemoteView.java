package com.kwad.sdk.api.core;

import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.DrawableRes;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkDynamicApi
@Keep
public interface IProgressRemoteView {
    @KsAdSdkDynamicApi
    @Keep
    RemoteViews build();

    @KsAdSdkDynamicApi
    @Keep
    void setControlBtnPaused(boolean z2);

    @KsAdSdkDynamicApi
    @Keep
    void setIcon(@DrawableRes int i2);

    @KsAdSdkDynamicApi
    @Keep
    void setIcon(Bitmap bitmap);

    @KsAdSdkDynamicApi
    @Keep
    void setName(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setPercentNum(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setProgress(int i2, int i3, boolean z2);

    @KsAdSdkDynamicApi
    @Keep
    void setSize(String str);

    @KsAdSdkDynamicApi
    @Keep
    void setStatus(String str);
}
