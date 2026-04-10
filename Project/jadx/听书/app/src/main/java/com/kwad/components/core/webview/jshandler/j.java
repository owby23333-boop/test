package com.kwad.components.core.webview.jshandler;

import com.kwad.components.core.playable.PlayableSource;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ack;
    private p aco;

    public static class b extends com.kwad.sdk.core.response.a.a {
        public int Re;
        public int acq;
        public int acr;
        public String acs;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getNativeData";
    }

    public j(p pVar) {
        this.aco = pVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            String target = aVar.getTarget();
            p pVar = this.aco;
            if (pVar != null) {
                pVar.a(this, target);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ack = null;
    }

    public final void f(PlayableSource playableSource) {
        if (playableSource == null) {
            return;
        }
        b bVar = new b();
        bVar.acq = playableSource.getCode();
        a(bVar);
    }

    public final void be(int i) {
        b bVar = new b();
        bVar.Re = i;
        a(bVar);
    }

    public final void aW(boolean z) {
        b bVar = new b();
        bVar.acr = z ? 1 : 0;
        a(bVar);
    }

    public final void P(long j) {
        b bVar = new b();
        bVar.acs = Long.toString(j);
        a(bVar);
    }

    public final void a(com.kwad.sdk.core.response.a.a aVar) {
        com.kwad.sdk.core.webview.c.c cVar = this.ack;
        if (cVar == null || aVar == null) {
            return;
        }
        cVar.a(aVar);
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String acp;

        public final String getTarget() {
            return this.acp;
        }
    }
}
