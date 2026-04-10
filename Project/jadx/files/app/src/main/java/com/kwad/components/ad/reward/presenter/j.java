package com.kwad.components.ad.reward.presenter;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends a {
    private final AdLiveCallerContextListener sC = new AdLiveCallerContextListener() { // from class: com.kwad.components.ad.reward.presenter.j.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener
        public final boolean isCloseDialogShowing() {
            return com.kwad.components.ad.reward.j.e(j.this.qS);
        }
    };
    private final com.kwad.components.core.j.kwai.a sD = new com.kwad.components.core.j.kwai.b() { // from class: com.kwad.components.ad.reward.presenter.j.2
        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void a(com.kwad.components.core.l.d dVar) {
            super.a(dVar);
            if (j.this.qS.pw.jY()) {
                j.this.qS.pw.jZ().onResume();
                if (com.kwad.components.core.r.b.ar(j.this.qS.mContext).pY()) {
                    j.this.qS.c(false, false);
                }
            }
        }

        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void b(com.kwad.components.core.l.d dVar) {
            super.b(dVar);
            if (j.this.qS.pw.jY()) {
                j.this.qS.pw.jZ().onPause();
            }
        }

        @Override // com.kwad.components.core.j.kwai.b, com.kwad.components.core.j.kwai.a
        public final void c(com.kwad.components.core.l.d dVar) {
            super.c(dVar);
            if (j.this.qS.pw.jY()) {
                j.this.qS.pw.jZ().onDestroy();
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (this.qS.pw.jY()) {
            this.qS.pw.jZ().registerAdLiveCallerContextListener(this.sC);
            this.qS.Kg.add(this.sD);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        if (this.qS.pw.jY()) {
            this.qS.pw.jZ().unRegisterAdLiveCallerContextListener(this.sC);
            this.qS.Kg.remove(this.sD);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
