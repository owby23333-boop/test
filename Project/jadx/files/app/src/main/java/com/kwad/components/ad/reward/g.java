package com.kwad.components.ad.reward;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends com.kwad.components.ad.i.b {
    private List<AdTemplate> po;
    private boolean pp;
    private List<com.kwad.components.core.d.b.c> pq;
    private f.b pr;

    public g(List<AdTemplate> list, @Nullable JSONObject jSONObject, f.b bVar) {
        super(jSONObject, null);
        this.pp = false;
        this.pq = new ArrayList();
        this.po = list;
        this.pr = bVar;
        List<AdTemplate> list2 = this.po;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        Iterator<AdTemplate> it = this.po.iterator();
        while (it.hasNext()) {
            this.pq.add(new com.kwad.components.core.d.b.c(it.next()));
        }
    }

    public final void A(boolean z2) {
        this.pp = z2;
    }

    @Override // com.kwad.components.ad.i.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.d.b.c cVar, int i2) {
        super.a(frameLayout, adBaseFrameLayout, this.po, this.pq, i2);
    }

    @Override // com.kwad.components.ad.i.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        List<AdTemplate> list = this.po;
        com.kwad.components.core.webview.jshandler.f fVar = new com.kwad.components.core.webview.jshandler.f(new ArrayList(list.subList(1, list.size() - 1)));
        fVar.a(this.pr);
        aVar.a(fVar);
    }

    @Override // com.kwad.components.ad.i.b
    public final void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplateList(this.po);
    }

    @Override // com.kwad.components.ad.i.b
    public final boolean bE() {
        return this.pp ? this.GO : super.bE();
    }

    @Override // com.kwad.components.ad.i.b
    @SuppressLint({"ClickableViewAccessibility"})
    public final void fK() {
        super.fK();
        this.cS.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.g.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
    }

    @Override // com.kwad.components.ad.i.b
    public final boolean fL() {
        return false;
    }

    public final void fM() {
        ae aeVar = this.mCardLifecycleHandler;
        if (aeVar != null) {
            aeVar.rs();
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final void fN() {
        com.kwad.components.ad.reward.monitor.a.a(true, "middle_play_end_card");
    }

    @Override // com.kwad.components.ad.i.b
    public final void fO() {
        com.kwad.components.ad.reward.monitor.a.a(true, "middle_play_end_card", m(this.mAdTemplate));
    }

    @Override // com.kwad.components.ad.i.b
    public final void fP() {
        com.kwad.components.ad.reward.monitor.a.a(true, "middle_play_end_card", m(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.ad.i.b
    public final String getName() {
        return "MiddlePlayEndCard";
    }

    @Override // com.kwad.components.ad.i.b
    public final String m(AdTemplate adTemplate) {
        List<AdTemplate> list = this.po;
        if (list == null || list.size() < 2) {
            return super.m(adTemplate);
        }
        String strAU = com.kwad.sdk.core.response.a.b.aU(this.po.get(1));
        new StringBuilder("getUrl: ").append(strAU);
        return strAU;
    }
}
