package com.kwad.components.ad.draw.presenter.c;

import com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.draw.b.a {
    private com.kwad.components.ad.l.b dF;
    private DrawVideoTailFrame fa;
    private l mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.draw.presenter.c.a.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            if (a.this.dF == null || !a.this.dF.aW()) {
                a.this.bn();
            } else {
                a.this.fa.setVisibility(8);
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fa = (DrawVideoTailFrame) findViewById(R.id.ksad_video_tail_frame);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.dF = this.dz.dF;
        this.fa.j(this.dz.mAdTemplate);
        this.fa.setAdBaseFrameLayout(this.dz.mRootContainer);
        this.fa.setApkDownloadHelper(this.dz.mApkDownloadHelper);
        this.fa.setVisibility(8);
        this.fa.setAdInteractionListener(this.dz.dh);
        this.dz.dB.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.dz.dB.a(this.mVideoPlayStateListener);
        this.fa.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn() {
        this.fa.bW();
        this.fa.setVisibility(0);
    }
}
