package com.kwad.sdk.core.i;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static c aKc;
    private static c aKd;

    public static c j(boolean z, boolean z2) {
        c cVar;
        com.kwad.sdk.core.d.c.d("KSUserAgentManager", "obtainUAGetter useKwaiUA: " + z + ", unionUAMark: " + z2);
        if (z) {
            if (aKc == null) {
                aKc = new b();
            }
            cVar = aKc;
        } else {
            if (aKd == null) {
                aKd = new d();
            }
            cVar = aKd;
        }
        cVar.bt(z2);
        com.kwad.sdk.core.d.c.d("KSUserAgentManager", "obtainUAGetter result: " + cVar);
        return cVar;
    }
}
