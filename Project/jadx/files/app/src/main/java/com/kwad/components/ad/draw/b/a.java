package com.kwad.components.ad.draw.b;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.widget.kwai.b;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.g.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.h.a {
    private b bY;
    private long dg;
    private com.kwad.sdk.contentalliance.kwai.kwai.a dh;
    private boolean di;
    private final c dj;
    private Context mContext;

    public a(@NonNull AdTemplate adTemplate, @NonNull b bVar, @NonNull DetailVideoView detailVideoView) {
        super(adTemplate, detailVideoView);
        this.dj = new c() { // from class: com.kwad.components.ad.draw.b.a.2
            @Override // com.kwad.sdk.core.g.c
            public final void aS() {
                if (a.this.dh == null) {
                    a aVar = a.this;
                    aVar.dh = com.kwad.sdk.contentalliance.kwai.kwai.a.am(aVar.mAdTemplate);
                    a.this.Gw.a(a.this.dh);
                }
                if (a.this.di) {
                    return;
                }
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.g.c
            public final void aT() {
                a.this.pause();
            }
        };
        this.dg = com.kwad.sdk.core.response.a.a.T(d.cb(this.mAdTemplate));
        this.bY = bVar;
        this.mContext = detailVideoView.getContext();
        aR();
        this.Gw.a(new c.e() { // from class: com.kwad.components.ad.draw.b.a.1
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                a.this.start(l.cv(a.this.mAdTemplate));
            }
        });
    }

    private void aR() {
        this.Gw.a(new b.a(this.mAdTemplate).bd(d.cd(this.mAdTemplate)).be(f.b(d.cc(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).uc(), this.mDetailVideoView);
        this.Gw.prepareAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(long j2) {
        if (this.bY.et()) {
            this.Gw.a(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, j2));
            this.Gw.start();
        }
    }

    @MainThread
    public final void a(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gw.c(iVar);
    }

    public final void aP() {
        long jCv = l.cv(this.mAdTemplate);
        if (this.Gw.qw() == null) {
            aR();
        }
        start(jCv);
        this.bY.a(this.dj);
    }

    public final void aQ() {
        this.dh = null;
        this.bY.b(this.dj);
        this.Gw.release();
    }

    @MainThread
    public final void b(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gw.d(iVar);
    }

    public final void f(boolean z2) {
        this.di = z2;
    }

    public final void pause() {
        this.Gw.pause();
    }

    @Override // com.kwad.components.ad.h.a
    @MainThread
    public final void release() {
        super.release();
        com.kwad.components.core.video.b bVar = this.Gw;
        if (bVar != null) {
            bVar.clear();
            this.Gw.release();
        }
    }

    public final void resume() {
        this.Gw.resume();
        com.kwad.components.core.r.b.ar(this.mContext).aI(false);
    }
}
