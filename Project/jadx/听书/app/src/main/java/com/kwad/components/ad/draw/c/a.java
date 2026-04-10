package com.kwad.components.ad.draw.c;

import android.content.Context;
import com.kwad.components.ad.k.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.j.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.n;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {
    private long ff;
    private com.kwad.components.core.widget.a.b fg;
    private com.kwad.sdk.contentalliance.a.a.a fh;
    private boolean fi;
    private boolean fj;
    private int fk;
    public boolean fl;
    public int fm;
    private boolean fn;
    private final c fo;
    private Context mContext;

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.fn = true;
        return true;
    }

    public a(AdTemplate adTemplate, com.kwad.components.core.widget.a.b bVar, DetailVideoView detailVideoView) {
        super(adTemplate, detailVideoView);
        this.fj = false;
        this.fk = -1;
        this.fl = true;
        this.fm = 0;
        this.fo = new c() { // from class: com.kwad.components.ad.draw.c.a.3
            @Override // com.kwad.sdk.core.j.c
            public final void bt() {
                if (a.this.fh == null) {
                    a aVar = a.this;
                    aVar.fh = com.kwad.sdk.contentalliance.a.a.a.bQ(aVar.mAdTemplate);
                    a.this.LU.a(a.this.fh);
                }
                if (a.this.fn || a.this.fi || !a.this.bp()) {
                    return;
                }
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bu() {
                a.this.pause();
            }
        };
        this.ff = com.kwad.sdk.core.response.b.a.ab(e.el(this.mAdTemplate));
        this.fg = bVar;
        this.mContext = detailVideoView.getContext();
        bs();
        if (com.kwad.sdk.core.response.b.a.cb(e.el(this.mAdTemplate))) {
            this.LU.setVolume(0.0f, 0.0f);
            this.fj = true;
        }
        this.LU.a(new c.e() { // from class: com.kwad.components.ad.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    a.this.start(n.eN(a.this.mAdTemplate));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    public final void bo() {
        long jEN = n.eN(this.mAdTemplate);
        if (this.LU.tz() == null) {
            bs();
        }
        start(jEN);
        this.fg.a(this.fo);
        b((l) new m() { // from class: com.kwad.components.ad.draw.c.a.2
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                a.a(a.this, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(long j) {
        if (this.fg.ae() && bp() && !this.fn) {
            this.LU.a(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, j));
            this.LU.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bp() {
        int i = this.fm;
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            return this.fl;
        }
        return false;
    }

    public final void setVideoSound(boolean z) {
        if (this.LU == null) {
            return;
        }
        if (z) {
            this.LU.setVolume(1.0f, 1.0f);
            this.fj = false;
        } else {
            this.LU.setVolume(0.0f, 0.0f);
            this.fj = true;
        }
        this.fk = 1;
    }

    public final void bq() {
        this.fh = null;
        this.fg.b(this.fo);
        this.LU.release();
    }

    public final void g(boolean z) {
        this.fi = z;
    }

    public final boolean br() {
        return this.fn;
    }

    private void bs() {
        this.LU.a(new b.a(this.mAdTemplate).dg(e.en(this.mAdTemplate)).dh(h.b(e.em(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).El(), this.mDetailVideoView);
        this.LU.prepareAsync();
        if (this.fk != -1 || this.fj) {
            setVideoSound(!this.fj);
        }
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        super.resume();
        com.kwad.components.core.t.a.aC(this.mContext).aQ(false);
    }
}
