package com.kwad.components.ad.e.a;

import android.view.View;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends com.kwad.components.ad.e.kwai.a {
    private View nC;

    /* JADX INFO: Access modifiers changed from: private */
    public void eX() {
        if (this.nC.getVisibility() == 0) {
            return;
        }
        this.nC.setVisibility(0);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.nC.setVisibility(8);
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.j.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                j.this.eX();
            }
        };
        this.nf.ng.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nC = findViewById(R.id.ksad_video_error_container);
    }
}
