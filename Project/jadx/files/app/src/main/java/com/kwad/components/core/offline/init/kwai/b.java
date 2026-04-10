package com.kwad.components.core.offline.init.kwai;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.sdk.KsAdSDKImpl;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
final class b implements ICache {
    b() {
    }

    @Override // com.kwad.components.offline.api.core.api.ICache
    public final String getPreCacheUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iUJ = com.kwad.sdk.core.config.d.uJ();
        if (iUJ >= 0) {
            return iUJ == 0 ? str : com.kwad.sdk.core.videocache.b.a.bl(KsAdSDKImpl.get().getContext()).cz(str);
        }
        File fileAN = com.kwad.sdk.core.diskcache.a.a.vE().aN(str);
        if (fileAN == null || !fileAN.exists()) {
            return null;
        }
        return fileAN.getAbsolutePath();
    }
}
