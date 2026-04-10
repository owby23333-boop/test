package com.kwad.components.ad.nativead.b;

import android.widget.ProgressBar;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends com.kwad.components.ad.nativead.a.a {
    private ProgressBar pU;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pU = (ProgressBar) findViewById(R.id.ksad_video_progress);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.pU.setProgress(0);
        this.pU.setVisibility(8);
        this.mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.nativead.b.k.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j, long j2) {
                k.this.U(j != 0 ? (int) ((j2 * 100.0f) / j) : 0);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                k.this.fH();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                k.this.fH();
            }
        };
        this.pq.pr.b(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i) {
        this.pU.setProgress(i);
        if (this.pU.getVisibility() == 0) {
            return;
        }
        this.pU.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fH() {
        if (this.pU.getVisibility() != 0) {
            return;
        }
        this.pU.setVisibility(8);
    }
}
