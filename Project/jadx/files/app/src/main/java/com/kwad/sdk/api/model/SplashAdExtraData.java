package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class SplashAdExtraData {
    private boolean isDisableRotate;
    private boolean isDisableShake;
    private boolean isDisableSlide;

    public boolean getDisableRotateStatus() {
        return this.isDisableRotate;
    }

    public boolean getDisableShakeStatus() {
        return this.isDisableShake;
    }

    public boolean getDisableSlideStatus() {
        return this.isDisableSlide;
    }

    public void setDisableRotateStatus(boolean z2) {
        this.isDisableRotate = z2;
    }

    public void setDisableShakeStatus(boolean z2) {
        this.isDisableShake = z2;
    }

    public void setDisableSlideStatus(boolean z2) {
        this.isDisableSlide = z2;
    }
}
