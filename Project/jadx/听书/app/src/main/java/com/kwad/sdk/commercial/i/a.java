package com.kwad.sdk.commercial.i;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes4.dex */
public class a extends com.kwad.sdk.commercial.c.a {
    public String awh;
    public String awp;
    public String awq;
    public String awr;

    public static a Ec() {
        return new a();
    }

    public final a cT(String str) {
        this.awr = str;
        return this;
    }

    public final a cU(String str) {
        this.awh = str;
        return this;
    }

    public final a cV(String str) {
        this.awp = str;
        return this;
    }

    public final a cW(String str) {
        this.awq = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: bO, reason: merged with bridge method [inline-methods] */
    public final a setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }
}
