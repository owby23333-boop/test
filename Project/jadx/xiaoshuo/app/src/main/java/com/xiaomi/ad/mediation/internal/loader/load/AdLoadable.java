package com.xiaomi.ad.mediation.internal.loader.load;

import com.xiaomi.ad.mediation.internal.loader.AdInternalConfig;

/* JADX INFO: loaded from: classes5.dex */
public interface AdLoadable<T> {
    void load(AdInternalConfig adInternalConfig, AdLoadListener<T> adLoadListener);
}
