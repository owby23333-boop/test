package com.kwad.components.ad.reward.presenter.b;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b {
    private AdLiveHandleClickListener ea = new AdLiveHandleClickListener() { // from class: com.kwad.components.ad.reward.presenter.b.a.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener
        public final void handleAdLiveClick(int i) {
            if (i == 1) {
                a.this.tm.a(1, a.this.getContext(), 115, 1);
            } else if (i == 2) {
                a.this.tm.a(1, a.this.getContext(), 117, 1);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (this.tm.dD != null) {
            this.tm.dD.registerClickListener(this.ea);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.tm.dD != null) {
            this.tm.dD.unRegisterClickListener(this.ea);
        }
    }
}
