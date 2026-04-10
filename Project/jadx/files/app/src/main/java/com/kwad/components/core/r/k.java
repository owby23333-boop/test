package com.kwad.components.core.r;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static boolean e(@NonNull AdTemplate adTemplate, boolean z2) {
        if (!z2 && com.kwad.sdk.core.response.a.b.cH(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            return com.kwad.sdk.core.config.d.vi();
        }
        return false;
    }

    public static void f(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0405a().as(com.kwad.sdk.core.response.a.b.bh(adTemplate)).M(adTemplate).ay(true).ow());
    }
}
