package com.kwad.components.ad.nativead.b;

import android.view.View;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ao;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.components.ad.nativead.a.a {
    private View pE;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pE = findViewById(R.id.ksad_video_network_unavailable);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (ao.isNetworkConnected(this.pE.getContext())) {
            this.pE.setVisibility(8);
            return;
        }
        this.pE.setVisibility(0);
        this.mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.nativead.b.d.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                d.this.fz();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                d.this.fz();
            }
        };
        this.pq.pr.b(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz() {
        if (this.pE.getVisibility() != 0) {
            return;
        }
        this.pE.setVisibility(8);
    }
}
