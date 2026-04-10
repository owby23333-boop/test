package com.kwad.components.core.b;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.u;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static void af(String str) {
        if (!mt() || KsAdSDKImpl.get() == null || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        u.F(KsAdSDKImpl.get().getContext(), str);
    }

    public static void b(e eVar) {
        af("使用缓存策略: " + eVar.mB());
    }

    public static boolean mt() {
        return false;
    }
}
