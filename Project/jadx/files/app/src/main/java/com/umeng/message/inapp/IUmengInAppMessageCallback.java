package com.umeng.message.inapp;

import com.umeng.message.entity.UInAppMessage;

/* JADX INFO: loaded from: classes3.dex */
public interface IUmengInAppMessageCallback {
    void onCardMessage(UInAppMessage uInAppMessage);

    void onSplashMessage(UInAppMessage uInAppMessage);
}
