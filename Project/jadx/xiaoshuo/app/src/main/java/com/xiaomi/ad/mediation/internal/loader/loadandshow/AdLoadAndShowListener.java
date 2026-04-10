package com.xiaomi.ad.mediation.internal.loader.loadandshow;

import com.xiaomi.ad.mediation.MMAdError;

/* JADX INFO: loaded from: classes5.dex */
public interface AdLoadAndShowListener {
    void onError(MMAdError mMAdError);

    void onLoaded();
}
