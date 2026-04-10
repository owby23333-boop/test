package com.kwad.sdk.commercial.j;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes4.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String awp;
    public String awq;
    public int awx;
    public int requestType;
    public int status;

    public static b Eg() {
        return new b();
    }

    public final b cG(int i) {
        this.status = i;
        return this;
    }

    public final b cH(int i) {
        this.awx = i;
        return this;
    }

    public final b db(String str) {
        this.awp = str;
        return this;
    }

    public final b dc(String str) {
        this.awq = str;
        return this;
    }

    public final b cI(int i) {
        this.requestType = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: cJ, reason: merged with bridge method [inline-methods] */
    public final b setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: dd, reason: merged with bridge method [inline-methods] */
    public final b setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: bP, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }
}
