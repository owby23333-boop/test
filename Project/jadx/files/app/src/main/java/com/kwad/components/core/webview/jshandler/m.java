package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements com.kwad.sdk.core.webview.b.a {
    private final boolean SC = false;
    private final com.kwad.sdk.core.webview.b Sk;
    private com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData> im;

    public static final class a implements com.kwad.sdk.core.b {
        private List<AdTemplate> SF;

        public a(List<AdTemplate> list) {
            this.SF = list;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.SF) {
                if (!TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.b.printStackTrace(e2);
                        jSONArray.put(adTemplate.toJson());
                    }
                }
                jSONArray.put(adTemplate.toJson());
            }
            com.kwad.sdk.utils.s.putValue(jSONObject, "impAdInfo", jSONArray);
            return jSONObject;
        }
    }

    public m(com.kwad.sdk.core.webview.b bVar) {
        this.Sk = bVar;
    }

    private void a(final com.kwad.components.core.n.kwai.b bVar, final com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData> mVar = this.im;
        if (mVar != null) {
            mVar.cancel();
        }
        this.im = new com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.m.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.m
            @NonNull
            /* JADX INFO: renamed from: ag, reason: merged with bridge method [inline-methods] */
            public AdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(bVar.Ot);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: mx, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.n.a createRequest() {
                return new com.kwad.components.core.n.a(bVar);
            }
        };
        this.im.request(new com.kwad.sdk.core.network.p<com.kwad.components.core.n.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.m.2
            private void b(@NonNull final AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty()) {
                    bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.m.2.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            cVar.a(new a(adResultData.getAdTemplateList()));
                        }
                    });
                    return;
                }
                com.kwad.sdk.core.d.b.d("WebCardGetKsAdDataHandler", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(com.kwad.sdk.core.network.f.afS.errorCode), com.kwad.sdk.core.network.f.afS.msg));
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.m.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.a(new a(new ArrayList()));
                    }
                });
            }

            private void e(int i2, String str) {
                com.kwad.sdk.core.d.b.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i2 + " msg: " + str);
                m.this.a(cVar);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.g gVar, int i2, String str) {
                e(i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                b((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.core.webview.b.c cVar) {
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.m.3
            @Override // java.lang.Runnable
            public final void run() {
                cVar.a(new a(new ArrayList()));
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (!this.SC) {
            if (this.Sk.zf()) {
                cVar.onError(-1, "native adTemplate is null");
                return;
            } else {
                cVar.a(new a(this.Sk.ze()));
                return;
            }
        }
        AdTemplate adTemplate = this.Sk.getAdTemplate();
        com.kwad.components.core.n.kwai.b bVar = new com.kwad.components.core.n.kwai.b(adTemplate.mAdScene);
        if (adTemplate.mAdScene != null) {
            bVar.Ou = r1.getPageScene();
        }
        bVar.Ov = 106L;
        bVar.Ot.setAdNum(12);
        bVar.sdkExtraData = com.kwad.sdk.core.response.a.d.cj(adTemplate);
        a(bVar, cVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getKsAdData";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        com.kwad.sdk.core.network.m<com.kwad.components.core.n.a, AdResultData> mVar = this.im;
        if (mVar != null) {
            mVar.cancel();
        }
    }
}
