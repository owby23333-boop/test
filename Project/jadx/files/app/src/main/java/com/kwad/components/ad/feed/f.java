package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static String b(@NonNull AdTemplate adTemplate) {
        String strAo = com.kwad.sdk.core.response.a.a.ao(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        if (!com.kwad.components.core.b.b.mt()) {
            return strAo;
        }
        return (adTemplate.fromCache ? "【cache】" : "") + strAo;
    }
}
