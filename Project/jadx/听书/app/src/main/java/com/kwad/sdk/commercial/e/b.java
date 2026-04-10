package com.kwad.sdk.commercial.e;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes4.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String awh;
    public String awi;

    public static b DW() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: bN, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cM(String str) {
        this.awh = str;
        return this;
    }

    public final b cN(String str) {
        this.awi = str;
        return this;
    }
}
