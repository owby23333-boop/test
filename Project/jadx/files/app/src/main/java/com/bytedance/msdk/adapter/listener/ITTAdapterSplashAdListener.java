package com.bytedance.msdk.adapter.listener;

import android.app.Activity;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener;

/* JADX INFO: loaded from: classes2.dex */
public interface ITTAdapterSplashAdListener extends GMSplashAdListener {
    Activity getActivity();

    void onMinWindowPlayFinish();

    void onMinWindowStart();

    void onSplashCardClick();

    void onSplashClickEyeClick();

    void onSplashClickEyeClose();

    void onSplashEyeReady();

    void setSupportSplashClickEye(boolean z2);
}
