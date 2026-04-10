package com.kwad.sdk.commercial.c;

import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends com.kwad.sdk.core.response.a.a {
    public int adOperationType;
    public int campaignType;
    public long creativeId;
    public int errorCode;
    public String errorMsg;
    public int industryFirstLevelId;
    public long llsid;
    public int ocpcActionType;
    public long posId;
    public String templateId;
    public String templateVersion;
    public int tkPublishType;
    public int webUriSourceType;

    public a setLlsid(long j) {
        this.llsid = j;
        return this;
    }

    public a setPosId(long j) {
        this.posId = j;
        return this;
    }

    public a setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        this.creativeId = e.ev(adTemplate);
        this.llsid = e.ei(adTemplate);
        this.posId = e.ee(adTemplate);
        AdInfo adInfoEl = e.el(adTemplate);
        this.campaignType = com.kwad.sdk.core.response.b.a.m614do(adInfoEl);
        this.ocpcActionType = com.kwad.sdk.core.response.b.a.dp(adInfoEl);
        this.industryFirstLevelId = com.kwad.sdk.core.response.b.a.dq(adInfoEl);
        this.adOperationType = com.kwad.sdk.core.response.b.a.aQ(adInfoEl);
        this.webUriSourceType = com.kwad.sdk.core.response.b.a.dr(adInfoEl);
        AdMatrixInfo.MatrixTemplate matrixTemplateBf = d.bf(adTemplate);
        if (matrixTemplateBf != null) {
            this.templateId = matrixTemplateBf.templateId;
            this.templateVersion = String.valueOf(matrixTemplateBf.templateVersionCode);
            this.tkPublishType = matrixTemplateBf.publishType;
        }
        return this;
    }

    public a setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public a setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }
}
