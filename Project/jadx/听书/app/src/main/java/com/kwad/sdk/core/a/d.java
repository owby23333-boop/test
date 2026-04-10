package com.kwad.sdk.core.a;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.h;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static g aDR;

    public static void g(Map<String, String> map) {
        qe().g(map);
    }

    public static String as(String str) {
        return qe().as(str);
    }

    public static String getResponseData(String str) {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return qe().getResponseData(str);
    }

    public static void a(String str, Map<String, String> map, String str2) {
        qe().a(str, map, str2);
    }

    private static g qe() {
        g gVar = aDR;
        if (gVar != null) {
            return gVar;
        }
        h hVar = (h) com.kwad.sdk.components.d.f(h.class);
        if (hVar != null) {
            hVar.qe();
            aDR = hVar.qe();
        } else {
            aDR = new a();
        }
        return aDR;
    }
}
