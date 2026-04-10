package com.kwad.components.ad.reward.k;

import android.content.Context;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.ad.reward.g AM;
    private AdTemplate mAdTemplate;
    private Context mContext;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean AN;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showLandingPage";
    }

    public t(Context context, com.kwad.components.ad.reward.g gVar) {
        this.mContext = context;
        this.mAdTemplate = gVar.mAdTemplate;
        this.AM = gVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            a(aVar);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    private void a(a aVar) {
        if (aVar.AN) {
            com.kwad.components.ad.reward.presenter.f.r(this.AM);
        } else {
            AdWebViewActivityProxy.launch(this.mContext, this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.AM = null;
        this.mContext = null;
        this.mAdTemplate = null;
    }
}
