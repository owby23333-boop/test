package com.kwad.components.ad.e.a;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.af;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.e.kwai.a {
    private View np;

    /* JADX INFO: Access modifiers changed from: private */
    public void eT() {
        if (this.np.getVisibility() != 0) {
            return;
        }
        this.np.setVisibility(8);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (af.isNetworkConnected(this.np.getContext())) {
            this.np.setVisibility(8);
            return;
        }
        this.np.setVisibility(0);
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.d.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                super.onVideoPlayStart();
                d.this.eT();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                d.this.eT();
            }
        };
        this.nf.ng.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.np = findViewById(R.id.ksad_video_network_unavailable);
    }
}
