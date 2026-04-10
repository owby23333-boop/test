package com.kwad.components.ad.reward.f;

import androidx.media3.session.MediaController;
import com.kwad.components.core.video.h;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.offline.api.core.adlive.model.LiveShopItemInfo;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.k.a<h> {
    private IAdLivePlayModule hR;
    private List<h> uC;
    private long uD;
    private AdLivePlayStateListener uE;

    public a(AdTemplate adTemplate, IAdLivePlayModule iAdLivePlayModule) {
        super(adTemplate);
        this.uC = new CopyOnWriteArrayList();
        this.uD = MediaController.RELEASE_UNBIND_TIMEOUT_MS;
        this.uE = new AdLivePlayStateListener() { // from class: com.kwad.components.ad.reward.f.a.1
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.1
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onMediaPrepared();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(final long j) {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.2
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public void accept(h hVar) {
                        hVar.onMediaPlayProgress(a.this.uD, j);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.3
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onMediaPlayStart();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.4
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onLivePlayResume();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.5
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onMediaPlayPaused();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.6
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onMediaPlayCompleted();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.7
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onLivePlayEnd();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLiveAudioEnableChange(final boolean z) {
                a.this.a(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.8
                    @Override // com.kwad.sdk.g.a
                    public final /* bridge */ /* synthetic */ void accept(h hVar) {
                    }
                });
            }
        };
        this.hR = iAdLivePlayModule;
        if (e.ef(adTemplate) == 2) {
            this.uD = com.kwad.sdk.core.response.b.a.ag(e.el(adTemplate));
        }
        this.hR.registerAdLivePlayStateListener(this.uE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.g.a<h> aVar) {
        if (aVar != null) {
            Iterator<h> it = this.uC.iterator();
            while (it.hasNext()) {
                aVar.accept(it.next());
            }
        }
    }

    @Override // com.kwad.components.ad.k.a
    public final void resume() {
        this.hR.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void skipToEnd() {
        this.hR.skipToEnd();
    }

    @Override // com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        return this.hR.getPlayDuration();
    }

    public final void registerAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.hR.registerAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    public final void unRegisterAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.hR.unRegisterAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    public final LiveShopItemInfo getCurrentShowShopItemInfo() {
        return this.hR.getCurrentShowShopItemInfo();
    }

    public final void onResume() {
        this.hR.onResume();
    }

    public final void onPause() {
        this.hR.onPause();
    }

    private void ie() {
        try {
            this.uC.clear();
            this.hR.unRegisterAdLivePlayStateListener(this.uE);
            this.hR.onDestroy();
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.components.ad.k.a
    public final void pause() {
        this.hR.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.k.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(h hVar) {
        if (hVar != null) {
            this.uC.add(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.k.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(h hVar) {
        if (hVar != null) {
            this.uC.remove(hVar);
        }
    }

    public final void removeInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor) {
        this.hR.removeInterceptor(onAdLiveResumeInterceptor);
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.hR.setAudioEnabled(z, z2);
    }

    @Override // com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        ie();
    }
}
