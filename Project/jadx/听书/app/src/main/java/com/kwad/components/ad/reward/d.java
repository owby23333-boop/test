package com.kwad.components.ad.reward;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.components.ad.l.b {
    private List<AdTemplate> rv;
    private boolean rw;
    private List<com.kwad.components.core.e.d.c> rx;
    private y.b ry;

    @Override // com.kwad.components.ad.l.b
    public final String getName() {
        return "MiddlePlayEndCard";
    }

    @Override // com.kwad.components.ad.l.b
    public final boolean gt() {
        return false;
    }

    public d(List<AdTemplate> list, JSONObject jSONObject, y.b bVar) {
        super(jSONObject, null);
        this.rw = false;
        this.rx = new ArrayList();
        this.rv = list;
        this.ry = bVar;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<AdTemplate> it = this.rv.iterator();
        while (it.hasNext()) {
            this.rx.add(new com.kwad.components.core.e.d.c(it.next()));
        }
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, int i) {
        super.a(frameLayout, adBaseFrameLayout, this.rv, this.rx);
    }

    @Override // com.kwad.components.ad.l.b
    public final void gs() {
        super.gs();
        this.eN.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.d.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
    }

    public final void gu() {
        if (this.eS != null) {
            this.eS.uG();
        }
    }

    @Override // com.kwad.components.ad.l.b
    public final String K(AdTemplate adTemplate) {
        List<AdTemplate> list = this.rv;
        if (list == null || list.size() < 2) {
            return super.K(adTemplate);
        }
        return com.kwad.sdk.core.response.b.b.cA(this.rv.get(1));
    }

    public final void setShowLandingPage(boolean z) {
        this.rw = z;
    }

    @Override // com.kwad.components.ad.l.b
    public final void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplateList(this.rv);
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        List<AdTemplate> list = this.rv;
        y yVar = new y(new ArrayList(list.subList(1, list.size() - 1)));
        yVar.a(this.ry);
        aVar.a(yVar);
    }

    @Override // com.kwad.components.ad.l.b
    public final void gv() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card");
    }

    @Override // com.kwad.components.ad.l.b
    public final void gw() {
        com.kwad.components.ad.reward.monitor.c.a(this.mAdTemplate, true, "middle_play_end_card", K(this.mAdTemplate));
    }

    @Override // com.kwad.components.ad.l.b
    public final void gx() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card", K(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.ad.l.b
    public final boolean cH() {
        if (this.rw) {
            return this.Mn;
        }
        return super.cH();
    }
}
