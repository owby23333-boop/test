package com.kwad.components.core.n;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a extends l<com.kwad.components.core.request.a, AdResultData> {
    private ImpInfo Rw;

    public a(ImpInfo impInfo) {
        this.Rw = impInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.a
    /* JADX INFO: renamed from: ou */
    public com.kwad.components.core.request.a createRequest() {
        return new com.kwad.components.core.request.a(this.Rw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.l
    /* JADX INFO: renamed from: af */
    public AdResultData parseData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(this.Rw.adScene);
        adResultData.parseJson(jSONObject);
        return adResultData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.l
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void afterParseData(AdResultData adResultData) {
        super.afterParseData(adResultData);
        p(adResultData);
    }

    private static void p(AdResultData adResultData) {
        for (AdTemplate adTemplate : adResultData.getProceedTemplateList()) {
            AdInfo adInfoEl = e.el(adTemplate);
            if (com.kwad.sdk.core.response.b.a.bd(adInfoEl)) {
                if (com.kwad.sdk.core.response.b.a.ba(adInfoEl).size() == 0) {
                    com.kwad.components.core.p.a.se().f(adTemplate, 21005);
                }
            } else if (com.kwad.sdk.core.response.b.a.bi(adInfoEl) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(adInfoEl))) {
                com.kwad.components.core.p.a.se().f(adTemplate, 21006);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public ExecutorService getExecutor() {
        return GlobalThreadPools.Ju();
    }
}
