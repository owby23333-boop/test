package com.kwad.sdk.core.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static f afr;

    public static void a(String str, Map<String, String> map, String str2) {
        nR().a(str, map, str2);
    }

    public static String bF(String str) {
        return nR().bF(str);
    }

    public static void d(@NonNull Map<String, String> map) {
        nR().d(map);
    }

    public static String getResponseData(String str) {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return nR().getResponseData(str);
    }

    private static f nR() {
        f aVar;
        f fVar = afr;
        if (fVar != null) {
            return fVar;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        com.kwad.sdk.components.f fVar2 = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar2 != null) {
            fVar2.nR();
            aVar = fVar2.nR();
        } else {
            aVar = new a();
        }
        afr = aVar;
        return afr;
    }
}
