package com.kwad.components.core.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    private static volatile f Iv;
    private ConcurrentHashMap<String, WeakReference<Object>> Iu = new ConcurrentHashMap<>();

    private static String H(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.bU(adTemplate) + "-" + com.kwad.sdk.core.response.a.d.ck(adTemplate);
    }

    private static String b(g gVar) {
        return gVar.mG() + "-" + gVar.mM();
    }

    @NonNull
    public static f mF() {
        if (Iv == null) {
            synchronized (f.class) {
                if (Iv == null) {
                    Iv = new f();
                }
            }
        }
        return Iv;
    }

    public final void G(AdTemplate adTemplate) {
        this.Iu.remove(H(adTemplate));
    }

    public final boolean a(g gVar) {
        String strB = b(gVar);
        com.kwad.sdk.core.d.b.d("AdMemCachePool", "contains key: " + strB);
        boolean z2 = false;
        if (!this.Iu.containsKey(strB)) {
            return false;
        }
        WeakReference<Object> weakReference = this.Iu.get(strB);
        if (weakReference != null && weakReference.get() != null) {
            z2 = true;
        }
        if (z2) {
            com.kwad.sdk.core.d.b.d("AdMemCachePool", "contains ad: " + weakReference.get());
        }
        return z2;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.Iu.put(H(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }
}
