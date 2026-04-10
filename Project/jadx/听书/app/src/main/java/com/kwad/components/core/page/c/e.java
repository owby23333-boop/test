package com.kwad.components.core.page.c;

import android.app.Activity;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends c {
    private com.kwad.components.core.page.d.a mPlayModule;
    private l mVideoPlayStateListener = new m() { // from class: com.kwad.components.core.page.c.e.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i, int i2) {
            Activity activity = e.this.TD.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    };

    @Override // com.kwad.components.core.page.c.c, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.components.core.page.d.a aVar = this.TD.mPlayModule;
        this.mPlayModule = aVar;
        aVar.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mPlayModule.b(this.mVideoPlayStateListener);
    }
}
