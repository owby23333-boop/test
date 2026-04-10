package com.kwad.components.ad.e.a;

import android.widget.ProgressBar;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends com.kwad.components.ad.e.kwai.a {
    private ProgressBar nE;

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i2) {
        this.nE.setProgress(i2);
        if (this.nE.getVisibility() == 0) {
            return;
        }
        this.nE.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY() {
        if (this.nE.getVisibility() != 0) {
            return;
        }
        this.nE.setVisibility(8);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.nE.setProgress(0);
        this.nE.setVisibility(8);
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.k.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                k.this.eY();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                k.this.eY();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayProgress(long j2, long j3) {
                k.this.K(j2 != 0 ? (int) ((j3 * 100.0f) / j2) : 0);
            }
        };
        this.nf.ng.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nE = (ProgressBar) findViewById(R.id.ksad_video_progress);
    }
}
