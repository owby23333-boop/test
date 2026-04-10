package com.kwad.components.core.p;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.a.a.v;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.core.webview.a.b.c {
    private com.kwad.components.core.webview.a.c pR() {
        return new com.kwad.components.core.webview.a.c() { // from class: com.kwad.components.core.p.c.1
            @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.a(str, cVar);
                v vVar = new v();
                vVar.Vf = a.pJ().pQ() + 1;
                cVar.a(vVar);
            }
        };
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        lVar.c(pR());
    }

    @Override // com.kwad.components.core.webview.a.b.c, com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
    }

    @Override // com.kwad.components.core.webview.a.b.c, com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.h
    public final void pageClose(WebCloseStatus webCloseStatus) {
        super.pageClose(webCloseStatus);
        if (webCloseStatus.interactSuccess) {
            this.Vi.mTkDialogFragment.dismiss();
        } else {
            this.Vi.mActivity.finish();
        }
    }
}
