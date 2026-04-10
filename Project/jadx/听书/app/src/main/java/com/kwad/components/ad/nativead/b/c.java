package com.kwad.components.ad.nativead.b;

import android.view.View;
import com.kwad.components.core.video.m;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.ad.nativead.a.a {
    private List<Integer> ck;
    private volatile boolean eE = false;

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.ck = com.kwad.sdk.core.response.b.a.bp(com.kwad.sdk.core.response.b.e.el(this.pq.mAdTemplate));
        this.mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.nativead.b.c.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                c.this.eE = false;
                if (!c.this.pq.mAdTemplate.mPvReported) {
                    c.this.pq.oW.fr();
                }
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                View view = (View) c.this.pq.pl.getParent();
                if (view != null) {
                    bVar.w(view.getHeight(), view.getWidth());
                }
                com.kwad.components.core.t.b.sY().a(c.this.pq.mAdTemplate, null, bVar);
                com.kwad.sdk.core.adlog.c.bX(c.this.pq.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlaying() {
                if (c.this.eE) {
                    return;
                }
                c.this.eE = true;
                com.kwad.components.core.p.a.se().a(c.this.pq.mAdTemplate, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j, long j2) {
                c.this.c(j2);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                com.kwad.sdk.core.adlog.c.bY(c.this.pq.mAdTemplate);
            }
        };
        this.pq.pr.b(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.ck) {
            if (iCeil >= num.intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.pq.mAdTemplate, iCeil, (JSONObject) null);
                this.ck.remove(num);
                return;
            }
        }
    }
}
