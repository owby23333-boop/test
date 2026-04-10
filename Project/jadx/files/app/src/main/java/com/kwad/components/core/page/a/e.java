package com.kwad.components.core.page.a;

import android.app.Activity;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends c {
    private com.kwad.components.core.page.b.a mPlayModule;
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.core.page.a.e.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            Activity activity = e.this.LF.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
        }
    };

    @Override // com.kwad.components.core.page.a.c, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mPlayModule = this.LF.mPlayModule;
        this.mPlayModule.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mPlayModule.b(this.mVideoPlayStateListener);
    }
}
