package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bh;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class e implements com.kwad.sdk.core.webview.b.a {
    protected void a(com.kwad.components.core.webview.a.a.w wVar) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        final com.kwad.components.core.webview.a.a.w wVar = new com.kwad.components.core.webview.a.a.w();
        try {
            wVar.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.e.1
            @Override // java.lang.Runnable
            public final void run() {
                if (wVar.ry()) {
                    e.this.a(wVar);
                } else if (wVar.rz()) {
                    e.this.b(wVar);
                } else if (wVar.isFailed()) {
                    e.this.c(wVar);
                }
            }
        });
    }

    protected void b(com.kwad.components.core.webview.a.a.w wVar) {
    }

    protected void c(com.kwad.components.core.webview.a.a.w wVar) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "updateVideoPlayStatus";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
