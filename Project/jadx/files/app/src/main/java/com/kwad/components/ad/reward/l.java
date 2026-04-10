package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends com.kwad.components.ad.i.b {

    @Nullable
    private com.kwad.components.ad.reward.b.d qP;
    private WeakReference<j> qQ;

    public l(j jVar, @Nullable JSONObject jSONObject, @Nullable String str) {
        super(jSONObject, null);
        this.qQ = new WeakReference<>(jVar);
    }

    public final void a(@Nullable com.kwad.components.ad.reward.b.d dVar) {
        this.qP = dVar;
    }

    @Override // com.kwad.components.ad.i.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        aVar.a(new com.kwad.components.ad.reward.f.b(this.cS.getContext(), this.mAdTemplate, PlayableSource.ENDCARD_CLICK));
        aVar.a(new com.kwad.components.ad.reward.b.f(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.l.1
            @Override // com.kwad.components.ad.reward.b.d
            public final void a(com.kwad.components.ad.reward.b.b bVar) {
                if (l.this.qP != null) {
                    l.this.qP.a(bVar);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.b(new com.kwad.components.core.webview.jshandler.c() { // from class: com.kwad.components.ad.reward.l.2
            @Override // com.kwad.components.core.webview.jshandler.c
            public final void a(com.kwad.components.core.webview.jshandler.b bVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    bVar.a(com.kwad.components.ad.reward.b.a.hi().hj());
                }
            }
        }));
        WeakReference<j> weakReference = this.qQ;
        aVar.b(new com.kwad.components.ad.reward.h.n(weakReference != null ? weakReference.get() : null, -1L, this.mJsBridgeContext));
    }

    @Override // com.kwad.components.ad.i.b
    public final void fN() {
        WeakReference<j> weakReference = this.qQ;
        com.kwad.components.ad.reward.monitor.a.a((weakReference != null ? weakReference.get() : null) != null, "end_card");
    }

    @Override // com.kwad.components.ad.i.b
    public final void fO() {
        WeakReference<j> weakReference = this.qQ;
        com.kwad.components.ad.reward.monitor.a.a((weakReference != null ? weakReference.get() : null) != null, "end_card", m(this.mAdTemplate));
    }

    @Override // com.kwad.components.ad.i.b
    public final void fP() {
        WeakReference<j> weakReference = this.qQ;
        com.kwad.components.ad.reward.monitor.a.a((weakReference != null ? weakReference.get() : null) != null, "end_card", m(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }
}
