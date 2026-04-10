package com.kwad.components.ad.splashscreen.b;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends e {
    private List<Integer> cI;
    private final com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.splashscreen.b.d.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            d.this.lh();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            d.this.c(j3);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            d.this.lg();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j2) {
        int iCeil = (int) Math.ceil(j2 / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cI.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.a(this.Cx.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lg() {
        com.kwad.sdk.core.report.a.h(this.Cx.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lh() {
        com.kwad.sdk.core.report.a.ax(this.Cx.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.cI = com.kwad.sdk.core.response.a.a.bc(com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate));
        com.kwad.components.ad.splashscreen.d.a aVar = this.Cx.BY;
        if (aVar != null) {
            aVar.a(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.d.a aVar = this.Cx.BY;
        if (aVar != null) {
            aVar.b(this.mVideoPlayStateListener);
        }
    }
}
