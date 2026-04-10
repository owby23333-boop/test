package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends a {
    private com.kwad.components.core.playable.a py;
    private PlayableSource sW;
    private final com.kwad.components.ad.reward.d.h sX = new com.kwad.components.ad.reward.d.i() { // from class: com.kwad.components.ad.reward.presenter.o.1
        @Override // com.kwad.components.ad.reward.d.i, com.kwad.components.ad.reward.d.h
        public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.d.l lVar) {
            o.this.sW = playableSource;
            if (o.this.py != null && o.this.py.pp()) {
                o.this.py.e(playableSource);
                com.kwad.components.ad.reward.j jVar = o.this.qS;
                if (jVar != null) {
                    jVar.d(playableSource);
                    o.this.qS.G(true);
                    if (o.this.qS.pw.jY()) {
                        o.this.qS.pw.jZ().pause();
                    }
                }
                com.kwad.components.ad.reward.b.fz().b(playableSource);
                return;
            }
            if (o.this.py != null) {
                o.this.py.hS();
            }
            if (lVar != null) {
                lVar.ho();
                com.kwad.sdk.core.d.b.d("RewardPlayablePresenter", "onEnterPlayable outer handled");
            } else if (com.kwad.sdk.core.response.a.a.ay(com.kwad.sdk.core.response.a.d.cb(o.this.qS.mAdTemplate))) {
                DownloadLandPageActivity.launch(o.this.getActivity(), o.this.qS.mAdTemplate, true);
            }
        }

        @Override // com.kwad.components.ad.reward.d.i, com.kwad.components.ad.reward.d.h
        public final void ca() {
            o.this.py.hS();
            com.kwad.components.ad.reward.j jVar = o.this.qS;
            if (jVar != null) {
                jVar.d((PlayableSource) null);
                if (o.this.qS.pw.jY()) {
                    o.this.qS.pw.jZ().resume();
                }
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.reward.j jVar = this.qS;
        this.py = jVar.py;
        this.py.a(jVar.mAdTemplate, jVar.mRootContainer, jVar.mApkDownloadHelper);
        com.kwad.components.ad.reward.monitor.a.a(this.qS.pN, "playable");
        com.kwad.components.ad.reward.monitor.a.a(this.qS.pN, "playable", com.kwad.sdk.core.response.a.a.bA(com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate)));
        this.py.po();
        this.py.a(new z.b() { // from class: com.kwad.components.ad.reward.presenter.o.2
            @Override // com.kwad.components.core.webview.jshandler.z.b
            public final void a(z.a aVar) {
                if (aVar.isSuccess()) {
                    return;
                }
                AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(o.this.qS.mAdTemplate);
                long loadTime = o.this.qS.py.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.a.a(o.this.qS.pN, "playable", com.kwad.sdk.core.response.a.a.bA(adInfoCb), System.currentTimeMillis() - loadTime, 3);
            }
        });
        this.py.a(new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.presenter.o.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(o.this.qS.mAdTemplate);
                long loadTime = o.this.qS.py.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.a.a(o.this.qS.pN, "playable", com.kwad.sdk.core.response.a.a.bA(adInfoCb), System.currentTimeMillis() - loadTime);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                com.kwad.components.ad.reward.j jVar2 = o.this.qS;
                com.kwad.components.ad.reward.monitor.a.a(jVar2.pN, "playable", com.kwad.sdk.core.response.a.a.bA(com.kwad.sdk.core.response.a.d.cb(jVar2.mAdTemplate)), System.currentTimeMillis() - o.this.qS.py.getLoadTime(), 2);
            }
        });
        com.kwad.components.ad.reward.b.fz().a(this.sX);
    }

    public final void e(@Nullable PlayableSource playableSource) {
        com.kwad.components.core.playable.a aVar = this.py;
        if (aVar != null) {
            if (playableSource != null) {
                aVar.e(playableSource);
            } else {
                aVar.e(this.sW);
            }
        }
    }

    public final void hS() {
        com.kwad.components.core.playable.a aVar = this.py;
        if (aVar != null) {
            aVar.hS();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((KsAdWebView) findViewById(R.id.ksad_playable_webview)).setVisibility(4);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.py.pn();
        this.py.hS();
        com.kwad.components.ad.reward.b.fz().b(this.sX);
    }
}
