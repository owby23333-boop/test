package com.kwad.components.ad.e.a;

import android.view.View;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.e.kwai.a {
    private List<Integer> cI;
    private volatile boolean cJ = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j2) {
        int iCeil = (int) Math.ceil(j2 / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.cI) {
            if (iCeil >= num.intValue()) {
                com.kwad.sdk.core.report.a.a(this.nf.mAdTemplate, iCeil, (JSONObject) null);
                this.cI.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.cI = com.kwad.sdk.core.response.a.a.bc(com.kwad.sdk.core.response.a.d.cb(this.nf.mAdTemplate));
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.c.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                com.kwad.sdk.core.report.a.ax(c.this.nf.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayProgress(long j2, long j3) {
                c.this.c(j3);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                c.this.cJ = false;
                if (!c.this.nf.mAdTemplate.mPvReported) {
                    c.this.nf.mO.eO();
                }
                com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
                View view = (View) c.this.nf.na.getParent();
                if (view != null) {
                    iVar.p(view.getHeight(), view.getWidth());
                }
                com.kwad.components.core.r.c.qa().a(c.this.nf.mAdTemplate, null, iVar);
                com.kwad.sdk.core.report.a.h(c.this.nf.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                if (c.this.cJ) {
                    return;
                }
                c.this.cJ = true;
                com.kwad.components.core.m.a.pr().a(c.this.nf.mAdTemplate, System.currentTimeMillis(), 1);
            }
        };
        this.nf.ng.a(this.mVideoPlayStateListener);
    }
}
