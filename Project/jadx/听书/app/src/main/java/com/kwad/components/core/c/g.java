package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class g {
    private static volatile g NM;
    private ConcurrentHashMap<String, WeakReference<Object>> NL = new ConcurrentHashMap<>();

    public static g om() {
        if (NM == null) {
            synchronized (g.class) {
                if (NM == null) {
                    NM = new g();
                }
            }
        }
        return NM;
    }

    public final boolean a(h hVar) {
        String strB = b(hVar);
        com.kwad.sdk.core.d.c.d("AdMemCachePool", "contains key: " + strB);
        boolean z = false;
        if (!this.NL.containsKey(strB)) {
            return false;
        }
        WeakReference<Object> weakReference = this.NL.get(strB);
        if (weakReference != null && weakReference.get() != null) {
            z = true;
        }
        if (z) {
            com.kwad.sdk.core.d.c.d("AdMemCachePool", "contains ad: " + weakReference.get());
        }
        return z;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.NL.put(aw(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }

    public final void av(AdTemplate adTemplate) {
        this.NL.remove(aw(adTemplate));
    }

    private static String b(h hVar) {
        return hVar.og() + "-" + hVar.os();
    }

    private static String aw(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.ee(adTemplate) + "-" + com.kwad.sdk.core.response.b.e.ev(adTemplate);
    }
}
