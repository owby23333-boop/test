package com.kwad.components.core.page.d;

import android.content.Context;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.kwad.components.core.m.a.a {
    private String Bh;
    private boolean Bj = false;
    private final List<i.a> Bk = new ArrayList();
    private OfflineOnAudioConflictListener Bm = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.page.d.a.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.a(a.this, true);
            if (a.this.LU != null) {
                a.this.LU.setAudioEnabled(false);
            }
            synchronized (a.this.Bk) {
                Iterator it = a.this.Bk.iterator();
                while (it.hasNext()) {
                    ((i.a) it.next()).onAudioBeOccupied();
                }
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            synchronized (a.this.Bk) {
                Iterator it = a.this.Bk.iterator();
                while (it.hasNext()) {
                    ((i.a) it.next()).onAudioBeReleased();
                }
            }
        }
    };
    private b LU;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean pW;
    private m pY;

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.Bj = true;
        return true;
    }

    public a(final AdTemplate adTemplate, DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mAdTemplate = adTemplate;
        this.mContext = detailVideoView.getContext();
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        this.Bh = k.g(this.mContext, adTemplate);
        this.mDetailVideoView = detailVideoView;
        this.LU = new b(detailVideoView, adTemplate);
        bs();
        m mVar = new m() { // from class: com.kwad.components.core.page.d.a.2
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.p.a.se().g(adTemplate, i, i2);
            }
        };
        this.pY = mVar;
        this.LU.c(mVar);
        this.LU.a(new c.e() { // from class: com.kwad.components.core.page.d.a.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(c cVar) {
                try {
                    a.this.LU.start();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        com.kwad.components.core.t.a.aC(this.mContext).a(this.Bm);
    }

    private void bs() {
        this.LU.a(new b.a(this.mAdTemplate).dg(this.Bh).dh(h.b(e.em(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate)).El(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.LU.prepareAsync();
    }

    private void resume() {
        this.LU.resume();
    }

    private void pause() {
        if (this.mAdTemplate.mXiaomiAppStoreDetailViewOpen && this.mAdTemplate.mAdScene != null && this.mAdTemplate.mAdScene.getAdStyle() == 2) {
            return;
        }
        this.LU.pause();
    }

    public final void a(l lVar) {
        if (lVar == null) {
            return;
        }
        this.LU.c(lVar);
    }

    public final void b(l lVar) {
        if (lVar == null) {
            return;
        }
        this.LU.d(lVar);
    }

    public final void release() {
        com.kwad.components.core.video.b bVar = this.LU;
        if (bVar != null) {
            bVar.clear();
            this.LU.release();
        }
        com.kwad.components.core.t.a.aC(this.mContext).b(this.Bm);
    }

    @Override // com.kwad.components.core.m.a.a
    public final void gY() {
        this.Bj = false;
        if (this.LU.tz() == null) {
            bs();
        }
    }

    @Override // com.kwad.components.core.m.a.a
    public final void c(f fVar) {
        resume();
    }

    @Override // com.kwad.components.core.m.a.a
    public final void d(f fVar) {
        pause();
    }

    @Override // com.kwad.components.core.m.a.a
    public final void gZ() {
        this.Bj = false;
        com.kwad.components.core.video.b bVar = this.LU;
        if (bVar != null) {
            bVar.d(this.pY);
            this.LU.release();
        }
    }

    private void setAudioEnabled(boolean z, boolean z2) {
        this.pW = z;
        this.LU.setAudioEnabled(z);
    }
}
