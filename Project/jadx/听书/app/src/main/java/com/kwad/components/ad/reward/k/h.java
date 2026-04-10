package com.kwad.components.ad.reward.k;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private a AF;

    public interface a {
        void af(int i);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "hasReward";
    }

    public h(a aVar) {
        this.AF = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        int iOptInt;
        if (this.AF != null) {
            try {
                iOptInt = new JSONObject(str).optInt("severCheckResult");
            } catch (JSONException e) {
                e.printStackTrace();
                iOptInt = 0;
            }
            this.AF.af(iOptInt);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.AF = null;
    }
}
