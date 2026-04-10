package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* JADX INFO: loaded from: classes2.dex */
public interface TTInitializer {
    TTAdManager getAdManager();

    void init(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback);

    boolean isInitSuccess();
}
