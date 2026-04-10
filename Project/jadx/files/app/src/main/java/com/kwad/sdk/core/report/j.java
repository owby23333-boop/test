package com.kwad.sdk.core.report;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public class j extends com.kwad.sdk.core.response.kwai.a {
    public int ahU;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    public static j aG(AdTemplate adTemplate) {
        j jVar = new j();
        jVar.creativeId = com.kwad.sdk.core.response.a.d.ck(adTemplate);
        jVar.llsid = com.kwad.sdk.core.response.a.d.bY(adTemplate);
        jVar.score = com.kwad.sdk.core.response.a.d.cp(adTemplate);
        jVar.ahU = jVar.score > 0 ? 1 : 0;
        return jVar;
    }

    public final String xl() {
        return toJson().toString();
    }
}
