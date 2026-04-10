package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class AdExposureFailedReason {
    public String adnName;
    public int adnType;
    public int winEcpm;

    public AdExposureFailedReason setAdnName(String str) {
        this.adnName = str;
        return this;
    }

    public AdExposureFailedReason setAdnType(int i2) {
        this.adnType = i2;
        return this;
    }

    public AdExposureFailedReason setWinEcpm(int i2) {
        this.winEcpm = i2;
        return this;
    }
}
