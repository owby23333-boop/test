package com.kwad.components.offline.tk.kwai;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaView;
import com.kwad.sdk.components.j;
import com.kwad.sdk.components.k;
import com.kwad.sdk.components.l;
import com.kwad.sdk.utils.an;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements l {
    private final IOfflineCompoTachikomaView XG;

    public g(@NonNull IOfflineCompoTachikomaView iOfflineCompoTachikomaView) {
        an.checkNotNull(iOfflineCompoTachikomaView);
        this.XG = iOfflineCompoTachikomaView;
    }

    @Override // com.kwad.sdk.components.l
    public final void a(j jVar) {
        if (jVar != null) {
            this.XG.registerHostActionHandler(new c(jVar));
        }
    }

    @Override // com.kwad.sdk.components.l
    public final void a(com.kwad.sdk.core.webview.b.g gVar) {
        if (gVar == null) {
            return;
        }
        this.XG.registerTKBridge(new d(gVar));
    }

    @Override // com.kwad.sdk.components.l
    public final void a(String str, String str2, k kVar) {
        this.XG.execute(str, str2, new f(kVar));
    }

    @Override // com.kwad.sdk.components.l
    public final void c(com.kwad.sdk.core.webview.b.a aVar) {
        if (aVar == null) {
            return;
        }
        this.XG.registerJsBridge(new b(aVar));
    }

    @Override // com.kwad.sdk.components.l
    public final int getUniqId() {
        return this.XG.getUniqId();
    }

    @Override // com.kwad.sdk.components.l
    public final View getView() {
        return this.XG.getView();
    }

    @Override // com.kwad.sdk.components.l
    public final void onDestroy() {
        this.XG.onDestroy();
    }

    @Override // com.kwad.sdk.components.l
    public final void setCustomEnv(Map<String, Object> map) {
        this.XG.setCustomEnv(map);
    }

    @Override // com.kwad.sdk.components.l
    public final void unregisterJsBridge() {
        this.XG.unregisterJsBridge();
    }
}
