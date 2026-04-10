package com.kwad.components.core.o.b.a;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes3.dex */
final class b implements ICache {
    b() {
    }

    @Override // com.kwad.components.offline.api.core.api.ICache
    public final String getPreCacheUrl(String str) {
        return TextUtils.isEmpty(str) ? "" : com.kwad.components.core.video.k.h(ServiceProvider.getContext(), str);
    }
}
