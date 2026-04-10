package com.sntech.ads;

import android.view.View;
import androidx.annotation.Keep;
import com.sntech.ads.api.event.SNEvent;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface SNEventManager {
    @Keep
    void onAdClick(SNEvent.AdPlatform adPlatform, String str);

    @Keep
    void onAdClick(SNEvent.AdPlatform adPlatform, String str, String str2);

    @Keep
    void onAdShow(View view, SNEvent.AdPlatform adPlatform, String str, double d2);

    @Keep
    void onAdShow(View view, SNEvent.AdPlatform adPlatform, String str, double d2, String str2);

    @Keep
    void onAdShow(SNEvent.AdPlatform adPlatform, String str, double d2);

    @Keep
    void onAdShow(SNEvent.AdPlatform adPlatform, String str, double d2, String str2);

    @Keep
    void onUserEvent(SNEvent.UserEvent userEvent);

    @Keep
    void onWithdraw(String str, float f2, SNEvent.WithdrawChannel withdrawChannel, String str2);

    @Keep
    void setABTest(String str, int i2, String... strArr);
}
