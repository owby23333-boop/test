package com.kwad.sdk.core.report;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes4.dex */
public class h extends com.kwad.sdk.core.response.a.a {
    public int aGB;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    public static h cj(AdTemplate adTemplate) {
        h hVar = new h();
        hVar.creativeId = com.kwad.sdk.core.response.b.e.ev(adTemplate);
        hVar.llsid = com.kwad.sdk.core.response.b.e.ei(adTemplate);
        int iEz = com.kwad.sdk.core.response.b.e.ez(adTemplate);
        hVar.score = iEz;
        hVar.aGB = iEz > 0 ? 1 : 0;
        return hVar;
    }

    public final String Iu() {
        return toJson().toString();
    }
}
