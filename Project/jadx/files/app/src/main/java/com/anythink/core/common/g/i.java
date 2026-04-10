package com.anythink.core.common.g;

import com.anythink.core.api.AdError;

/* JADX INFO: loaded from: classes2.dex */
public interface i {
    void onLoadCanceled(int i2);

    void onLoadError(int i2, String str, AdError adError);

    void onLoadFinish(int i2, Object obj);

    void onLoadStart(int i2);
}
