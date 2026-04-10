package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class NativeAdExtraData {
    private boolean enableShake;
    private int showLiveStatus;
    private int showLiveStyle;

    public int getShowLiveStatus() {
        return this.showLiveStatus;
    }

    public int getShowLiveStyle() {
        return this.showLiveStyle;
    }

    public boolean isEnableShake() {
        return this.enableShake;
    }

    public void setEnableShake(boolean z2) {
        this.enableShake = z2;
    }

    public void setShowLiveStatus(int i2) {
        this.showLiveStatus = i2;
    }

    public void setShowLiveStyle(int i2) {
        this.showLiveStyle = i2;
    }
}
