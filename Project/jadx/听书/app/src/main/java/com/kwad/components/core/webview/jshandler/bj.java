package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public class bj implements com.kwad.sdk.core.webview.c.a {
    private a aeG;
    private AdTemplate mAdTemplate;
    protected Context mContext;

    public interface a {
        boolean eM();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showPlayable";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bj(Context context, AdTemplate adTemplate) {
        this.mContext = com.kwad.sdk.o.m.wrapContextIfNeed(context);
        this.mAdTemplate = adTemplate;
    }

    public final void a(a aVar) {
        this.aeG = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.aeG;
        boolean zEM = aVar != null ? aVar.eM() : true;
        com.kwad.sdk.core.d.c.d("WebShowPlayableHandler", "handleJsCall launch AdPlayableActivityProxy : " + zEM);
        if (zEM) {
            com.kwad.components.core.page.a.launch(this.mContext, this.mAdTemplate);
        }
    }
}
