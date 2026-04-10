package com.xiaomi.ad.mediation.internal.loader.load;

import com.xiaomi.ad.mediation.MMAdError;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface AdLoadListener<T> {
    void onError(MMAdError mMAdError);

    void onLoaded(List<T> list);
}
