package com.anythink.splashad.unitgroup.api;

import android.content.Context;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;

/* JADX INFO: loaded from: classes2.dex */
public interface CustomSplashEventListener {
    void onDeeplinkCallback(boolean z2);

    void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo);

    void onSplashAdClicked();

    void onSplashAdDismiss();

    void onSplashAdShow();

    void onSplashAdShowFail(AdError adError);
}
