package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public class an implements com.kwad.sdk.core.webview.b.a {
    private a Ul;
    private AdTemplate mAdTemplate;
    protected Context mContext;

    public interface a {
        boolean dC();
    }

    public an(Context context, AdTemplate adTemplate) {
        this.mContext = Wrapper.wrapContextIfNeed(context);
        this.mAdTemplate = adTemplate;
    }

    public final void a(a aVar) {
        this.Ul = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = this.Ul;
        boolean zDC = aVar != null ? aVar.dC() : true;
        com.kwad.sdk.core.d.b.d("WebShowPlayableHandler", "handleJsCall launch AdPlayableActivityProxy : " + zDC);
        if (zDC) {
            com.kwad.components.core.page.a.launch(this.mContext, this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "showPlayable";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
