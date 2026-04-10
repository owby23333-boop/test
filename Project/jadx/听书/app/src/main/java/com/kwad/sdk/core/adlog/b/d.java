package com.kwad.sdk.core.adlog.b;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes4.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String awq;
    public int awx;
    public int axH;
    public int retryCount;
    public int status;

    public static d EJ() {
        return new d();
    }

    public final d cR(int i) {
        this.status = i;
        return this;
    }

    public final d dp(String str) {
        this.awq = str;
        return this;
    }

    public final d cS(int i) {
        this.awx = i;
        return this;
    }

    public final d cT(int i) {
        this.axH = 1;
        return this;
    }

    public final d cU(int i) {
        this.retryCount = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: dq, reason: merged with bridge method [inline-methods] */
    public final d setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: cV, reason: merged with bridge method [inline-methods] */
    public final d setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: cg, reason: merged with bridge method [inline-methods] */
    public final d setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }
}
