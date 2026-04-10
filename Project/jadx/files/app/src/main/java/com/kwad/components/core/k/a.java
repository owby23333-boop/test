package com.kwad.components.core.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.n.kwai.b;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a extends m<com.kwad.components.core.n.a, AdResultData> {
    private b Kj;

    public a(b bVar) {
        this.Kj = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.m
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void afterParseData(AdResultData adResultData) {
        super.afterParseData(adResultData);
        e(adResultData);
    }

    private static void e(AdResultData adResultData) {
        com.kwad.components.core.m.a aVarPr;
        int i2;
        for (AdTemplate adTemplate : adResultData.getProceedTemplateList()) {
            AdInfo adInfoCb = d.cb(adTemplate);
            if (com.kwad.sdk.core.response.a.a.aW(adInfoCb)) {
                if (com.kwad.sdk.core.response.a.a.aU(adInfoCb).size() == 0) {
                    aVarPr = com.kwad.components.core.m.a.pr();
                    i2 = 21005;
                    aVarPr.f(adTemplate, i2);
                }
            } else if (com.kwad.sdk.core.response.a.a.ba(adInfoCb) && TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(adInfoCb))) {
                aVarPr = com.kwad.components.core.m.a.pr();
                i2 = 21006;
                aVarPr.f(adTemplate, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.m
    @NonNull
    /* JADX INFO: renamed from: ag, reason: merged with bridge method [inline-methods] */
    public AdResultData parseData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(this.Kj.Ot);
        adResultData.parseJson(jSONObject);
        return adResultData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.a
    @NonNull
    /* JADX INFO: renamed from: mx */
    public com.kwad.components.core.n.a createRequest() {
        return new com.kwad.components.core.n.a(this.Kj);
    }
}
