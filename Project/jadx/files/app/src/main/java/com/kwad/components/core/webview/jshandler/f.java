package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.kwad.sdk.core.webview.b.a {
    private List<AdTemplate> Sj;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private b pr;

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    public interface b {
        void c(AdTemplate adTemplate, long j2);
    }

    public f(com.kwad.sdk.core.webview.b bVar) {
        this.mJsBridgeContext = bVar;
    }

    public f(List<AdTemplate> list) {
        this.Sj = list;
    }

    private List<AdTemplate> ro() {
        List<AdTemplate> list = this.Sj;
        if (list != null) {
            return list;
        }
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        if (bVar != null) {
            return bVar.ze();
        }
        return null;
    }

    public final void a(b bVar) {
        this.pr = bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            long j2 = aVar.creativeId;
            AdTemplate adTemplateA = com.kwad.sdk.core.response.a.d.a(ro(), j2, aVar.adStyle);
            if (this.pr != null) {
                this.pr.c(adTemplateA, j2);
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "adImpression";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
