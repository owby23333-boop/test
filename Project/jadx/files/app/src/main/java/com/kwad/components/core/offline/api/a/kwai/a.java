package com.kwad.components.core.offline.api.a.kwai;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final Map<Integer, AdTemplate> Kk = new HashMap();

    public static void a(int i2, AdTemplate adTemplate) {
        Kk.put(Integer.valueOf(i2), adTemplate);
    }

    public static AdTemplate at(int i2) {
        return Kk.get(Integer.valueOf(i2));
    }

    public static void au(int i2) {
        Kk.remove(Integer.valueOf(i2));
    }
}
