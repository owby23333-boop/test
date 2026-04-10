package com.sntech.ads.impl;

import android.view.View;
import com.sntech.ads.SNEventManager;
import com.sntech.ads.api.event.SNEvent;
import com.sntech.ads.impl.utils.EventConverter;

/* JADX INFO: loaded from: classes.dex */
public final class SNEventManagerImpl implements SNEventManager {

    /* JADX INFO: loaded from: classes3.dex */
    public static class Holder {
        private static final SNEventManager sInstance = new SNEventManagerImpl();

        private Holder() {
        }
    }

    public static SNEventManager get() {
        return Holder.sInstance;
    }

    @Override // com.sntech.ads.SNEventManager
    public void onAdClick(SNEvent.AdPlatform adPlatform, String str) {
        onAdClick(adPlatform, str, null);
    }

    @Override // com.sntech.ads.SNEventManager
    public void onAdShow(SNEvent.AdPlatform adPlatform, String str, double d2) {
        onAdShow(null, adPlatform, str, d2, null);
    }

    @Override // com.sntech.ads.SNEventManager
    public void onUserEvent(SNEvent.UserEvent userEvent) {
        SNADS.onUserEvent(EventConverter.convertUserEvent(userEvent));
    }

    @Override // com.sntech.ads.SNEventManager
    public void onWithdraw(String str, float f2, SNEvent.WithdrawChannel withdrawChannel, String str2) {
        SNADS.onWithdraw(str, f2, EventConverter.convertWithdrawChannel(withdrawChannel), str2);
    }

    @Override // com.sntech.ads.SNEventManager
    public void setABTest(String str, int i2, String... strArr) {
        SNADS.setABTest(str, i2, strArr);
    }

    @Override // com.sntech.ads.SNEventManager
    public void onAdClick(SNEvent.AdPlatform adPlatform, String str, String str2) {
        SNADS.clickAd(EventConverter.convertPlatform(adPlatform), str, str2);
    }

    @Override // com.sntech.ads.SNEventManager
    public void onAdShow(View view, SNEvent.AdPlatform adPlatform, String str, double d2) {
        onAdShow(view, adPlatform, str, d2, null);
    }

    @Override // com.sntech.ads.SNEventManager
    public void onAdShow(SNEvent.AdPlatform adPlatform, String str, double d2, String str2) {
        onAdShow(null, adPlatform, str, d2, str2);
    }

    @Override // com.sntech.ads.SNEventManager
    public void onAdShow(View view, SNEvent.AdPlatform adPlatform, String str, double d2, String str2) {
        SNADS.showAd(view, EventConverter.convertPlatform(adPlatform), str, d2, str2);
    }
}
