package com.kwad.components.ad.reward.k;

import com.kwad.components.ad.reward.model.RewardFraudVerifyRespInfo;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements com.kwad.sdk.core.webview.c.a {
    private WeakReference<com.kwad.components.ad.reward.g> td;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public RewardFraudVerifyRespInfo.FraudDataInfo AL;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "rewardFraudVerify";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public r(WeakReference<com.kwad.components.ad.reward.g> weakReference) {
        this.td = weakReference;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.td;
        com.kwad.components.ad.reward.g gVar = weakReference != null ? weakReference.get() : null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            gVar.sa = aVar.AL.isFraud() ? 3 : 2;
            gVar.sb = aVar.AL.getCode();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
