package com.kwad.components.core.t;

import android.content.Context;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes4.dex */
public final class k {
    public static boolean d(AdTemplate adTemplate, boolean z) {
        if (!z && com.kwad.sdk.core.response.b.b.dD(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
            return com.kwad.sdk.core.config.e.Gd();
        }
        return false;
    }

    public static void f(Context context, AdTemplate adTemplate) {
        com.kwad.components.core.e.d.a.a(new a.C0333a(context).ao(true).aB(adTemplate));
    }
}
