package com.kwad.components.ad.nativead.b;

import android.view.View;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends com.kwad.components.ad.nativead.a.a {
    private View pS;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.pS = findViewById(R.id.ksad_video_error_container);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.pS.setVisibility(8);
        this.mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.nativead.b.j.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                j.this.fG();
            }
        };
        this.pq.pr.b(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fG() {
        if (this.pS.getVisibility() == 0) {
            return;
        }
        this.pS.setVisibility(0);
    }
}
