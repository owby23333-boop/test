package com.kwad.components.ad.reward.m;

import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.m;
import com.kwad.sdk.utils.i;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private com.kwad.components.ad.reward.f.a Bp;
    private d Bq;
    private b Br;
    private com.kwad.components.ad.k.a Bs;
    private g tm;
    private int Bo = 0;
    private int Bt = 0;
    private List<m> Bu = new CopyOnWriteArrayList();

    public e(g gVar) {
        this.tm = gVar;
        this.Bs = new a(gVar.mAdTemplate);
    }

    public final void a(int i, com.kwad.components.ad.k.a aVar) {
        this.Bo = i;
        if (i == 1) {
            this.Bq = (d) aVar;
        } else if (i == 2) {
            this.Bp = (com.kwad.components.ad.reward.f.a) aVar;
        } else if (i == 3) {
            this.Br = (b) aVar;
        }
        this.Bs = aVar;
        Iterator<m> it = this.Bu.iterator();
        while (it.hasNext()) {
            this.Bs.b(it.next());
        }
        this.Bu.clear();
    }

    private com.kwad.components.ad.k.a kV() {
        return this.Bs;
    }

    public final boolean kW() {
        return this.Bp != null;
    }

    public final void a(m mVar) {
        if (kV().kR()) {
            this.Bu.add(mVar);
        } else {
            kV().b(mVar);
        }
    }

    public final void b(m mVar) {
        kV().a(mVar);
        if (mVar != null) {
            this.Bu.remove(mVar);
        }
    }

    public final void kT() {
        d dVar = this.Bq;
        if (dVar != null) {
            dVar.kT();
        }
    }

    public final void a(i.a aVar) {
        d dVar = this.Bq;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }

    public final void b(i.a aVar) {
        d dVar = this.Bq;
        if (dVar != null) {
            dVar.b(aVar);
        }
    }

    public final com.kwad.components.ad.reward.f.a kX() {
        return this.Bp;
    }

    public final b kY() {
        return this.Br;
    }

    public final void kS() {
        d dVar = this.Bq;
        if (dVar != null) {
            dVar.kS();
        } else {
            b bVar = this.Br;
            if (bVar != null) {
                bVar.kS();
            }
        }
        this.tm.gH();
    }

    public final long getPlayDuration() {
        return kV().getPlayDuration();
    }

    public final void skipToEnd() {
        kV().skipToEnd();
    }

    public final void setAudioEnabled(boolean z, boolean z2) {
        this.Bt = z ? 2 : 1;
        kV().setAudioEnabled(z, z2);
    }

    public final void resume() {
        int i;
        kV().resume();
        com.kwad.components.ad.reward.f.a aVar = this.Bp;
        if (aVar == null || (i = this.Bt) <= 0) {
            return;
        }
        aVar.setAudioEnabled(i == 2, false);
    }

    public final void pause() {
        kV().pause();
    }

    public final void release() {
        kV().release();
    }
}
