package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class af implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b acw;
    private final boolean adc = false;
    private com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> add;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getKsAdData";
    }

    public af(com.kwad.sdk.core.webview.b bVar) {
        this.acw = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.adc) {
            AdTemplate adTemplate = this.acw.getAdTemplate();
            ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
            if (adTemplate.mAdScene != null) {
                impInfo.pageScene = adTemplate.mAdScene.getPageScene();
            }
            impInfo.subPageScene = 106L;
            impInfo.adScene.setAdNum(12);
            impInfo.sdkExtraData = com.kwad.sdk.core.response.b.e.eu(adTemplate);
            a(impInfo, cVar);
            return;
        }
        if (this.acw.KJ()) {
            cVar.onError(-1, "native adTemplate is null");
        } else {
            cVar.a(new a(this.acw.iu()));
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.add;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    private void a(final ImpInfo impInfo, final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.add;
        if (lVar != null) {
            lVar.cancel();
        }
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar2 = new com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.af.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: ou, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.a createRequest() {
                return new com.kwad.components.core.request.a(impInfo);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* JADX INFO: renamed from: af, reason: merged with bridge method [inline-methods] */
            public AdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(impInfo.adScene);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }
        };
        this.add = lVar2;
        lVar2.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.af.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i, String str) {
                k(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                n((AdResultData) baseResultData);
            }

            private void n(final AdResultData adResultData) {
                if (adResultData.isAdResultDataEmpty()) {
                    StringBuilder sb = new StringBuilder("onError:");
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(com.kwad.sdk.core.network.e.aEq.errorCode);
                    objArr[1] = TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg;
                    com.kwad.sdk.core.d.c.d("WebCardGetKsAdDataHandler", sb.append(String.format("code:%s__msg:%s", objArr)).toString());
                    bw.runOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.af.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            cVar.a(adResultData);
                        }
                    });
                    return;
                }
                bw.runOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.af.2.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        cVar.a(adResultData);
                    }
                });
            }

            private void k(int i, String str) {
                com.kwad.sdk.core.d.c.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i + " msg: " + str);
                af.this.a(cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.core.webview.c.c cVar) {
        bw.runOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.af.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdResultData adResultData = new AdResultData();
                adResultData.setAdTemplateList(new ArrayList());
                cVar.a(adResultData);
            }
        });
    }

    public static final class a implements com.kwad.sdk.core.b {
        AdResultData mAdResultData;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        public a(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject json;
            AdResultData adResultData = this.mAdResultData;
            if (adResultData == null || (json = adResultData.toJson()) == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.mAdResultData.getAdTemplateList()) {
                if (!TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                        jSONArray.put(adTemplate.toJson());
                    }
                } else {
                    jSONArray.put(adTemplate.toJson());
                }
            }
            com.kwad.sdk.utils.aa.putValue(json, "impAdInfo", jSONArray);
            return json;
        }
    }
}
