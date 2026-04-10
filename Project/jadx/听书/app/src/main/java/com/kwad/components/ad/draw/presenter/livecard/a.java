package com.kwad.components.ad.draw.presenter.livecard;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.draw.b.a {
    private AdLiveHandleClickListener ea = new AdLiveHandleClickListener() { // from class: com.kwad.components.ad.draw.presenter.livecard.a.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener
        public final void handleAdLiveClick(int i) {
            if (i == 1) {
                a.this.dz.a(1, a.this.getContext(), 115, 1);
            } else if (i == 2) {
                a.this.dz.a(1, a.this.getContext(), 117, 2);
            }
        }
    };

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (this.dz.dD != null) {
            this.dz.dD.registerClickListener(this.ea);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.dz.dD != null) {
            this.dz.dD.unRegisterClickListener(this.ea);
        }
    }
}
