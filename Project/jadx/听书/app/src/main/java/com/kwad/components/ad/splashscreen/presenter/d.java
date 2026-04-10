package com.kwad.components.ad.splashscreen.presenter;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends e {
    private List<Integer> ck;
    private final com.kwad.components.core.video.l mVideoPlayStateListener = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.splashscreen.presenter.d.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            d.this.mg();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            d.this.c(j2);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            d.this.mh();
        }
    };

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.ck = com.kwad.sdk.core.response.b.a.bp(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate));
        if (this.Gf.Fq != null) {
            this.Gf.Fq.b(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.Gf.Fq != null) {
            this.Gf.Fq.a(this.mVideoPlayStateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mg() {
        com.kwad.sdk.core.adlog.c.bX(this.Gf.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mh() {
        com.kwad.sdk.core.adlog.c.bY(this.Gf.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.ck.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.Gf.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }
}
