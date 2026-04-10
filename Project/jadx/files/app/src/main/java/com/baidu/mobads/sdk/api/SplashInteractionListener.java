package com.baidu.mobads.sdk.api;

/* JADX INFO: loaded from: classes2.dex */
public interface SplashInteractionListener extends SplashAdListener {
    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdDismissed();

    void onAdPresent();

    void onLpClosed();
}
