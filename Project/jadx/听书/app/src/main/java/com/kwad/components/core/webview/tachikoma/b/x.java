package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class x implements com.kwad.sdk.core.webview.c.a {
    private OfflineOnAudioConflictListener Bm = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.webview.tachikoma.b.x.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            x.this.bk(2);
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            x.this.bk(3);
        }
    };
    private com.kwad.sdk.core.webview.c.c acS;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean agO;
        public int agP;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerAudioFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.acS = cVar;
        com.kwad.components.core.t.a.aC(ServiceProvider.getContext()).a(this.Bm);
        bk(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(int i) {
        a aVar = new a();
        aVar.agO = com.kwad.components.core.t.a.aC(ServiceProvider.getContext()).sW();
        aVar.agP = i;
        com.kwad.sdk.core.webview.c.c cVar = this.acS;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.t.a.aC(ServiceProvider.getContext()).b(this.Bm);
        this.acS = null;
    }
}
