package com.anythink.splashad.api;

/* JADX INFO: loaded from: classes2.dex */
public class ATSplashAdExtraInfo {
    private IATSplashEyeAd atSplashEyeAd;
    private int dismissType;

    public ATSplashAdExtraInfo(int i2, IATSplashEyeAd iATSplashEyeAd) {
        this.dismissType = i2;
        this.atSplashEyeAd = iATSplashEyeAd;
    }

    public IATSplashEyeAd getAtSplashEyeAd() {
        return this.atSplashEyeAd;
    }

    public int getDismissType() {
        return this.dismissType;
    }
}
