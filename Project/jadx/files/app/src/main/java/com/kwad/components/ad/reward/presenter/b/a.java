package com.kwad.components.ad.reward.presenter.b;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.components.ad.reward.model.EcOrderCardStyle;
import com.kwad.components.core.r.c;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a {
    private List<Integer> cI;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private final g up = new g();
    private long mPlayTime = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean uq = true;
    private volatile boolean cJ = false;
    private Runnable ur = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.b.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.up.qW()) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.up.qY();
                int iQZ = a.this.up.qX().qZ();
                a.this.qS.a(jElapsedRealtime, a.this.up.qX().ra(), iQZ);
            } else if (a.this.uq) {
                a.this.qS.a(5000L, 5000L, 1);
            }
            com.kwad.components.core.m.a.pr().Q(a.this.mAdTemplate);
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.b.a.2
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            a.this.hP();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayPause() {
            super.onLivePlayPause();
            a.this.up.qV();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            a.this.c(j2);
            a.this.mPlayTime = j2;
            a.this.up.qV();
            a.a(a.this, false);
            if (a.this.cJ) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.m.a.pr().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            com.kwad.components.ad.reward.monitor.a.b(a.this.qS.pN, a.this.mAdTemplate, a.this.qS.mPageEnterTime);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            a.this.im();
        }
    };
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.reward.presenter.b.a.3
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.up.qU();
            a.this.mHandler.removeCallbacks(a.this.ur);
            a.this.mHandler.postDelayed(a.this.ur, 5000L);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.up.qU();
            a.this.mHandler.removeCallbacks(a.this.ur);
            a.this.mHandler.postDelayed(a.this.ur, 5000L);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            a.this.hP();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            super.onVideoPlayError(i2, i3);
            com.kwad.components.ad.reward.monitor.a.a(a.this.qS.pN, a.this.qS.mAdTemplate, a.this.qS.qh, i2, i3);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayPaused() {
            super.onVideoPlayPaused();
            a.this.up.qV();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            a.this.c(j3);
            a.this.mPlayTime = j3;
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            super.onVideoPlayStart();
            a.this.im();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            super.onVideoPlaying();
            a.this.up.qV();
            a.a(a.this, false);
            if (a.this.cJ) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.m.a.pr().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            com.kwad.components.ad.reward.monitor.a.b(a.this.qS.pN, a.this.mAdTemplate, a.this.qS.mPageEnterTime);
        }
    };

    static /* synthetic */ boolean a(a aVar, boolean z2) {
        aVar.uq = false;
        return false;
    }

    static /* synthetic */ boolean b(a aVar, boolean z2) {
        aVar.cJ = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j2) {
        int iCeil = (int) Math.ceil(j2 / 1000.0f);
        List<Integer> list = this.cI;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.cI) {
            if (iCeil >= num.intValue()) {
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, iCeil, this.qS.mReportExtData);
                this.cI.remove(num);
                return;
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdTemplate = this.qS.mAdTemplate;
        this.mAdInfo = d.cb(this.mAdTemplate);
        this.cI = com.kwad.sdk.core.response.a.a.bc(this.mAdInfo);
        this.qS.pw.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        this.mHandler.postDelayed(this.ur, 5000L);
    }

    public final void hP() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        if (!jVar.pN || !jVar.pS) {
            com.kwad.sdk.core.report.a.i(this.mAdTemplate, this.qS.mReportExtData);
        }
        this.up.qV();
    }

    public final void im() {
        com.kwad.sdk.core.report.i iVar;
        this.cJ = false;
        EcOrderCardStyle ecOrderCardStyleCreateFromAdInfo = EcOrderCardStyle.createFromAdInfo(this.mAdInfo);
        if (ecOrderCardStyleCreateFromAdInfo != null) {
            iVar = new com.kwad.sdk.core.report.i();
            y.a aVar = new y.a();
            aVar.ajC = String.valueOf(ecOrderCardStyleCreateFromAdInfo.getValue());
            iVar.a(aVar);
        } else {
            iVar = null;
        }
        c.qa().a(this.mAdTemplate, null, iVar);
        com.kwad.sdk.core.report.a.h(this.mAdTemplate, this.qS.mReportExtData);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mHandler.removeCallbacksAndMessages(null);
        this.qS.pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        g.a aVarQX = this.up.qX();
        com.kwad.components.core.m.a.pr().a(this.qS.mAdTemplate, this.mPlayTime, aVarQX.ra(), aVarQX.qZ());
    }
}
