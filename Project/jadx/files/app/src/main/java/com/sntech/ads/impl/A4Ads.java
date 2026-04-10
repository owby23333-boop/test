package com.sntech.ads.impl;

import android.app.Activity;
import com.sntech.a4.A4AdListener;
import com.sntech.a4.A4AdSlot;
import com.sntech.ads.ISNADS;

/* JADX INFO: loaded from: classes3.dex */
public class A4Ads {
    private ISNADS mSnads;

    public A4Ads(ISNADS isnads) {
        this.mSnads = isnads;
    }

    public void showInterstitialAd(Activity activity, A4AdSlot a4AdSlot, A4AdListener a4AdListener) {
        this.mSnads.showA4InterstitialAd(activity, a4AdSlot.getSlotId(), a4AdListener);
    }
}
