package com.kwad.components.ad.reward.j;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.video.i;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.h.a implements j.a {
    private boolean lg;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean nG;
    private com.kwad.components.core.video.j nI;
    private j qS;
    private String xP;
    private AtomicBoolean xQ;
    private boolean xR;
    private boolean xS;
    private final List<h.a> xT;
    private final List<InterfaceC0370a> xU;
    private OfflineOnAudioConflictListener xV;

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.j.a$a, reason: collision with other inner class name */
    public interface InterfaceC0370a {
        void jp();
    }

    public a(j jVar, boolean z2) {
        super(jVar.mAdTemplate, jVar.pv);
        this.xQ = new AtomicBoolean(false);
        this.xR = false;
        this.xS = false;
        this.lg = false;
        this.xT = new ArrayList();
        this.xU = new ArrayList();
        this.xV = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.reward.j.a.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.a(a.this, true);
                if (a.this.Gw != null) {
                    a.this.Gw.setAudioEnabled(false);
                }
                synchronized (a.this.xT) {
                    Iterator it = a.this.xT.iterator();
                    while (it.hasNext()) {
                        ((h.a) it.next()).onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (a.this.xT) {
                    Iterator it = a.this.xT.iterator();
                    while (it.hasNext()) {
                        ((h.a) it.next()).onAudioBeReleased();
                    }
                }
            }
        };
        this.qS = jVar;
        this.mContext = jVar.mContext;
        this.mVideoPlayConfig = jVar.mVideoPlayConfig;
        this.mVideoPlayerStatus = this.mAdTemplate.mVideoPlayerStatus;
        this.xR = z2;
        this.xP = getVideoUrl();
    }

    static /* synthetic */ boolean a(a aVar, boolean z2) {
        aVar.xS = true;
        return true;
    }

    private void aR() {
        if (jX()) {
            return;
        }
        this.Gw.a(new b.a(this.mAdTemplate).bd(this.xP).be(f.b(d.cc(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.kwai.kwai.a.am(this.mAdTemplate)).uc(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Gw.prepareAsync();
    }

    private String getVideoUrl() {
        if (jX()) {
            return "";
        }
        String strE = com.kwad.sdk.core.response.a.a.E(d.cb(this.mAdTemplate));
        File fileAN = com.kwad.sdk.core.diskcache.a.a.vE().aN(strE);
        return (fileAN == null || !fileAN.exists()) ? com.kwad.sdk.core.config.d.uJ() > 0 ? com.kwad.sdk.core.videocache.b.a.bl(this.mContext).cz(strE) : strE : fileAN.getAbsolutePath();
    }

    private boolean jX() {
        return com.kwad.sdk.core.response.a.a.co(d.cb(this.mAdTemplate));
    }

    private void stop() {
        pause();
        this.lg = true;
    }

    public final void a(InterfaceC0370a interfaceC0370a) {
        this.xU.add(interfaceC0370a);
    }

    @MainThread
    public final void a(i iVar) {
        com.kwad.components.core.video.b bVar;
        if (iVar == null || (bVar = this.Gw) == null) {
            return;
        }
        bVar.c(iVar);
    }

    public final void a(h.a aVar) {
        this.xT.add(aVar);
    }

    public final void b(InterfaceC0370a interfaceC0370a) {
        this.xU.remove(interfaceC0370a);
    }

    @MainThread
    public final void b(i iVar) {
        com.kwad.components.core.video.b bVar;
        if (iVar == null || (bVar = this.Gw) == null) {
            return;
        }
        bVar.d(iVar);
    }

    public final void b(h.a aVar) {
        this.xT.remove(aVar);
    }

    public final long getPlayDuration() {
        com.kwad.components.core.video.b bVar;
        if (!this.xQ.get() || (bVar = this.Gw) == null) {
            return 0L;
        }
        return bVar.getPlayDuration();
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gt() {
        this.xS = false;
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gu() {
        if (this.lg) {
            return;
        }
        resume();
        if (this.nG || (com.kwad.components.ad.reward.kwai.b.gR() && this.xS)) {
            com.kwad.components.core.r.b.ar(this.mContext).aI(com.kwad.components.ad.reward.kwai.b.gR());
            if (com.kwad.components.ad.reward.kwai.b.gR() && this.xS) {
                this.xS = false;
                this.nG = true;
                setAudioEnabled(true, false);
            } else {
                if (this.xR || !com.kwad.components.core.r.b.ar(this.mContext).pY()) {
                    return;
                }
                this.nG = false;
                setAudioEnabled(this.nG, false);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gv() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gw() {
        com.kwad.components.core.video.b bVar;
        this.xS = false;
        if (!this.xQ.get() || (bVar = this.Gw) == null) {
            return;
        }
        bVar.d(this.nI);
        this.Gw.release();
    }

    public final void jU() {
        if (this.xQ.get()) {
            return;
        }
        this.xQ.set(true);
        aR();
        this.nI = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.j.a.2
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                super.onVideoPlayError(i2, i3);
                com.kwad.components.core.m.a.pr().b(a.this.mAdTemplate, i2, i3);
            }
        };
        this.Gw.c(this.nI);
        this.Gw.a(new c.e() { // from class: com.kwad.components.ad.reward.j.a.3
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                com.kwad.sdk.core.b.b.we();
                if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
                    a.this.Gw.start();
                }
            }
        });
        com.kwad.components.core.r.b.ar(this.mContext).a(this.xV);
    }

    public final boolean jV() {
        return this.xR;
    }

    public final void jW() {
        Iterator<InterfaceC0370a> it = this.xU.iterator();
        while (it.hasNext()) {
            it.next().jp();
        }
    }

    public final void pause() {
        if (!this.xQ.get() || this.Gw == null || jX() || j.e(this.qS)) {
            return;
        }
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
        com.kwad.components.core.r.b.ar(this.mContext).b(this.xV);
    }

    @Override // com.kwad.components.ad.h.a
    @WorkerThread
    public final void releaseSync() {
        super.releaseSync();
        com.kwad.components.core.video.b bVar = this.Gw;
        if (bVar != null) {
            bVar.clear();
            this.Gw.releaseSync();
        }
        com.kwad.components.core.r.b.ar(this.mContext).b(this.xV);
    }

    public final void resume() {
        this.lg = false;
        if (!this.xQ.get() || this.Gw == null || jX() || j.e(this.qS)) {
            return;
        }
        this.Gw.resume();
    }

    public final void setAudioEnabled(boolean z2, boolean z3) {
        this.nG = z2;
        if (!this.xQ.get() || this.Gw == null) {
            return;
        }
        if (z2 && z3) {
            com.kwad.components.core.r.b.ar(this.mContext).aI(true);
        }
        this.Gw.setAudioEnabled(z2);
    }

    @Deprecated
    public final void skipToEnd() {
        com.kwad.components.core.video.b bVar;
        if (!this.xQ.get() || (bVar = this.Gw) == null) {
            return;
        }
        bVar.onPlayStateChanged(9);
        stop();
    }
}
