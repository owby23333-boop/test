package com.kwad.sdk.core.adlog.b;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes4.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int awx;
    public boolean axD;
    public int axE;
    public int axF;
    public long axG;
    public int axt;
    public String axu;
    public int retryCount;
    public int status;

    public static b EI() {
        return new b();
    }

    public final b cL(int i) {
        this.status = i;
        return this;
    }

    public final b bp(boolean z) {
        this.axD = z;
        return this;
    }

    public final b cM(int i) {
        this.awx = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: cf, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cN(int i) {
        this.retryCount = i;
        return this;
    }

    public final b cO(int i) {
        this.axt = i;
        return this;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final b m612do(String str) {
        this.axu = str;
        return this;
    }

    public final b cP(int i) {
        this.axE = i;
        return this;
    }

    public final b cQ(int i) {
        this.axF = i;
        return this;
    }

    public final b at(long j) {
        this.axG = j;
        return this;
    }
}
