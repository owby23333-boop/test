package com.kwad.components.ad.k;

import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes3.dex */
public class b extends a<l> {
    public com.kwad.components.core.video.b LU;
    private boolean LV;
    private l LW;
    protected DetailVideoView mDetailVideoView;

    public b(AdTemplate adTemplate, DetailVideoView detailVideoView) {
        super(adTemplate);
        this.LV = false;
        this.LW = new m() { // from class: com.kwad.components.ad.k.b.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                b.this.mAdTemplate.setmCurPlayTime(-1L);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j, long j2) {
                b.this.mAdTemplate.setmCurPlayTime(j2);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                try {
                    super.onMediaPlayError(i, i2);
                    if (!b.this.LV) {
                        b.this.nJ();
                    } else if (e.FV()) {
                        b.this.nJ();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.mDetailVideoView = detailVideoView;
        this.LU = new com.kwad.components.core.video.b(this.mDetailVideoView, adTemplate);
        nH();
    }

    private void nH() {
        this.LU.c(this.LW);
    }

    private void nI() {
        l lVar;
        com.kwad.components.core.video.b bVar = this.LU;
        if (bVar == null || (lVar = this.LW) == null) {
            return;
        }
        bVar.d(lVar);
        this.LW = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ() {
        com.kwad.components.core.p.a.se().f(this.mAdTemplate, 21008);
        this.LV = true;
    }

    @Override // com.kwad.components.ad.k.a
    public long getPlayDuration() {
        com.kwad.components.core.video.b bVar = this.LU;
        if (bVar != null) {
            return bVar.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.ad.k.a
    public void resume() {
        this.LU.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public void pause() {
        this.LU.pause();
    }

    @Override // com.kwad.components.ad.k.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void b(l lVar) {
        com.kwad.components.core.video.b bVar;
        if (lVar == null || (bVar = this.LU) == null) {
            return;
        }
        bVar.c(lVar);
    }

    @Override // com.kwad.components.ad.k.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void a(l lVar) {
        if (lVar == null) {
            return;
        }
        this.LU.d(lVar);
    }

    @Override // com.kwad.components.ad.k.a
    public void release() {
        super.release();
        this.LV = false;
        nI();
        com.kwad.components.core.video.b bVar = this.LU;
        if (bVar != null) {
            bVar.clear();
            this.LU.release();
        }
    }
}
