package com.bytedance.msdk.api.v2.ad.splash;

import android.app.Activity;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;

/* JADX INFO: loaded from: classes2.dex */
public interface GMSplashCardListener extends ITTAdatperCallback {
    Activity getActivity();

    void onSplashCardClick();

    void onSplashClickEyeClick();

    void onSplashClickEyeClose();

    void onSplashEyeReady();

    void setSupportSplashClickEye(boolean z2);
}
