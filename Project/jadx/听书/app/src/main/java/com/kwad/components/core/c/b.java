package com.kwad.components.core.c;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static void b(e eVar) {
        ae("使用缓存策略: " + eVar.oh());
    }

    private static void ae(String str) {
        if (oc() && com.kwad.sdk.l.Cf().Bn()) {
            ac.Q(ServiceProvider.getContext(), str);
        }
    }

    public static boolean oc() {
        return false;
    }
}
