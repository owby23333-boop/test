package com.kwad.components.ad.reward.presenter.c;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.components.ad.reward.model.EcOrderCardStyle;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.components.ad.reward.presenter.b;
import com.kwad.components.core.video.j;
import com.kwad.components.core.video.m;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {
    private List<Integer> ck;
    private AdInfo mAdInfo;
    private m vQ;
    private final j xp = new j();
    private long si = 0;
    private Handler iK = new Handler(Looper.getMainLooper());
    private boolean xq = true;
    private volatile boolean eE = false;
    private Runnable xr = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.xp.uf()) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.xp.uh();
                int iUi = a.this.xp.ug().ui();
                a.this.tm.a(jElapsedRealtime, a.this.xp.ug().uj(), iUi);
            } else if (a.this.xq) {
                a.this.tm.a(5000L, 5000L, 1);
            }
            com.kwad.components.core.p.a.se().aK(a.this.mAdTemplate);
        }
    };
    private m vR = new m() { // from class: com.kwad.components.ad.reward.presenter.c.a.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.iH();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            a.this.c(j2);
            a.this.si = j2;
            a.this.xp.ue();
            a.a(a.this, false);
            a.this.tm.si = j2;
            if (a.this.eE) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.p.a.se().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            c.b(a.this.tm.rS, a.this.mAdTemplate, a.this.tm.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.jb();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.xp.ue();
        }
    };
    private m jE = new m() { // from class: com.kwad.components.ad.reward.presenter.c.a.3
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.jb();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            a.this.c(j2);
            a.this.si = j2;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            a.this.xp.ue();
            a.a(a.this, false);
            if (a.this.eE) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.p.a.se().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            c.b(a.this.tm.rS, a.this.mAdTemplate, a.this.tm.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i, int i2) {
            super.onMediaPlayError(i, i2);
            c.a(a.this.tm.rS, a.this.tm.mAdTemplate, a.this.tm.sr, i, i2);
            com.kwad.components.ad.reward.monitor.b.c(a.this.tm.rS, a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.xp.ue();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.l
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.xp.ud();
            a.this.iK.removeCallbacks(a.this.xr);
            a.this.iK.postDelayed(a.this.xr, 5000L);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.l
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.xp.ud();
            a.this.iK.removeCallbacks(a.this.xr);
            a.this.iK.postDelayed(a.this.xr, 5000L);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            a.this.iH();
        }
    };

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.xq = false;
        return false;
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.eE = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        AdInfo adInfoEl = e.el(this.mAdTemplate);
        this.mAdInfo = adInfoEl;
        this.ck = com.kwad.sdk.core.response.b.a.bp(adInfoEl);
        if (this.tm.rE.kW()) {
            this.vQ = this.vR;
        } else {
            this.vQ = this.jE;
        }
        this.tm.rE.a(this.vQ);
        this.iK.postDelayed(this.xr, 5000L);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.iK.removeCallbacksAndMessages(null);
        this.tm.rE.b(this.vQ);
        j.a aVarUg = this.xp.ug();
        com.kwad.components.core.p.a.se().a(this.tm.mAdTemplate, this.si, aVarUg.uj(), aVarUg.ui());
    }

    public final void iH() {
        if (!this.tm.rS || !this.tm.rX) {
            com.kwad.sdk.core.adlog.c.g(this.mAdTemplate, this.tm.mReportExtData);
        }
        this.xp.ue();
    }

    public final void jb() {
        this.eE = false;
        EcOrderCardStyle ecOrderCardStyleCreateFromAdInfo = EcOrderCardStyle.createFromAdInfo(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        if (ecOrderCardStyleCreateFromAdInfo != null) {
            a.C0392a c0392a = new a.C0392a();
            c0392a.awY = String.valueOf(ecOrderCardStyleCreateFromAdInfo.getValue());
            bVar.b(c0392a);
        }
        if (!this.mAdTemplate.mPvReported) {
            checkExposure();
        }
        com.kwad.components.ad.reward.j.b.a(true, this.mAdTemplate, null, bVar);
        com.kwad.sdk.core.adlog.c.f(this.mAdTemplate, this.tm.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.ck) {
            if (iCeil >= num.intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, this.tm.mReportExtData);
                this.ck.remove(num);
                return;
            }
        }
    }

    private void checkExposure() {
        long j = this.mAdInfo.adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j <= 0 || com.kwad.sdk.core.response.b.a.ag(this.mAdInfo) <= 5000) {
            return;
        }
        this.iK.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.4
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.ad.reward.m.a(1, a.this.tm);
            }
        }, j);
    }
}
