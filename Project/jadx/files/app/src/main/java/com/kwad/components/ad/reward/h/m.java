package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.a.kwai.v;
import com.kwad.components.core.webview.jshandler.z;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends v implements z.b {

    @Nullable
    private com.kwad.components.core.playable.a py;

    public m(com.kwad.components.ad.reward.j jVar) {
        this.py = jVar.py;
        com.kwad.components.core.playable.a aVar = this.py;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.z.b
    public final void a(z.a aVar) {
        b(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerPlayableStatusListener";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.core.playable.a aVar = this.py;
        if (aVar != null) {
            aVar.b(this);
            this.py = null;
        }
    }
}
