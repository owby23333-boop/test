package com.bytedance.msdk.api.v2.ad;

import com.bytedance.msdk.api.AdError;

/* JADX INFO: loaded from: classes2.dex */
public interface GMAdTokenCallback {
    void onAdTokenLoaded(String str);

    void onAdTokenLoadedFail(AdError adError);
}
