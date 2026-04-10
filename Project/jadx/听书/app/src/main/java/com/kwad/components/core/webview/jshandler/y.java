package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class y implements com.kwad.sdk.core.webview.c.a {
    private List<AdTemplate> acH;
    private com.kwad.sdk.core.webview.b eQ;
    private b ry;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface b {
        void W(AdTemplate adTemplate);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "adImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public y(List<AdTemplate> list) {
        this.acH = list;
    }

    public y(com.kwad.sdk.core.webview.b bVar) {
        this.eQ = bVar;
    }

    public final void a(b bVar) {
        this.ry = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            AdTemplate adTemplateA = com.kwad.sdk.core.response.b.e.a(uB(), aVar.creativeId, aVar.adStyle);
            b bVar = this.ry;
            if (bVar != null) {
                bVar.W(adTemplateA);
            }
        } catch (JSONException unused) {
        }
    }

    private List<AdTemplate> uB() {
        List<AdTemplate> list = this.acH;
        if (list != null) {
            return list;
        }
        com.kwad.sdk.core.webview.b bVar = this.eQ;
        if (bVar != null) {
            return bVar.KI();
        }
        return null;
    }
}
