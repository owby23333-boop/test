package com.kwad.components.ad.draw.a.b;

import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.draw.kwai.a {

    @Nullable
    private com.kwad.components.ad.i.b cp;
    private DrawVideoTailFrame dc;
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.draw.a.b.a.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            if (a.this.cp == null || !a.this.cp.az()) {
                a.this.aO();
            } else {
                a.this.dc.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aO() {
        this.dc.aX();
        this.dc.setVisibility(0);
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.draw.kwai.b bVar = this.bW;
        this.cp = bVar.cp;
        this.dc.bindView(bVar.mAdTemplate);
        this.dc.setAdBaseFrameLayout(this.bW.mRootContainer);
        this.dc.setApkDownloadHelper(this.bW.mApkDownloadHelper);
        this.dc.setVisibility(8);
        this.dc.setAdInteractionListener(this.bW.bV);
        this.bW.bX.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dc = (DrawVideoTailFrame) findViewById(R.id.ksad_video_tail_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bW.bX.b(this.mVideoPlayStateListener);
        this.dc.release();
    }
}
