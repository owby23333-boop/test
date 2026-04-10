package com.sntech.ads.impl;

import android.app.Activity;
import com.sntech.a4.A4AdListener;
import com.sntech.a4.A4AdSlot;
import com.sntech.ads.A4AdManager;

/* JADX INFO: loaded from: classes.dex */
public class A4AdManagerImpl implements A4AdManager {

    /* JADX INFO: loaded from: classes3.dex */
    public static class Holder {
        private static final A4AdManager sInstance = new A4AdManagerImpl();

        private Holder() {
        }
    }

    public static A4AdManager get() {
        return Holder.sInstance;
    }

    @Override // com.sntech.ads.A4AdManager
    public void showA4InterstitialAd(Activity activity, String str, A4AdListener a4AdListener) {
        SNADS.getA4Ads().showInterstitialAd(activity, new A4AdSlot.Builder().slotId(str).build(), a4AdListener);
    }
}
