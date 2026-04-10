package com.kwad.components.ad.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public b Gw;
    private boolean Gx = false;
    private i Gy = new j() { // from class: com.kwad.components.ad.h.a.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            super.onVideoPlayError(i2, i3);
            if (!a.this.Gx) {
                a.this.mc();
            } else if (d.vc()) {
                a.this.mc();
            }
        }
    };

    @NonNull
    public AdTemplate mAdTemplate;
    protected DetailVideoView mDetailVideoView;

    public a(@NonNull AdTemplate adTemplate, DetailVideoView detailVideoView) {
        this.mAdTemplate = adTemplate;
        this.mDetailVideoView = detailVideoView;
        this.Gw = new b(this.mDetailVideoView);
        ma();
    }

    private void ma() {
        this.Gw.c(this.Gy);
    }

    private void mb() {
        i iVar;
        b bVar = this.Gw;
        if (bVar == null || (iVar = this.Gy) == null) {
            return;
        }
        bVar.d(iVar);
        this.Gy = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc() {
        com.kwad.components.core.m.a.pr().f(this.mAdTemplate, 21008);
        this.Gx = true;
    }

    @WorkerThread
    public void release() {
        this.Gx = false;
        mb();
    }

    @WorkerThread
    public void releaseSync() {
        this.Gx = false;
        mb();
    }
}
