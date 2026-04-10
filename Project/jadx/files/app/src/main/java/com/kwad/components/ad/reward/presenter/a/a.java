package com.kwad.components.ad.reward.presenter.a;

import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a {
    private AdLiveHandleClickListener uh = new AdLiveHandleClickListener() { // from class: com.kwad.components.ad.reward.presenter.a.a.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHandleClickListener
        public final void handleAdLiveClick(int i2) {
            if (i2 == 1) {
                a.this.qS.a(1, a.this.getContext(), 115, 1);
            } else if (i2 == 2) {
                a.this.qS.a(1, a.this.getContext(), 117, 1);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        IAdLiveOfflineView iAdLiveOfflineView = this.qS.px;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.registerClickListener(this.uh);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        IAdLiveOfflineView iAdLiveOfflineView = this.qS.px;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.unRegisterClickListener(this.uh);
        }
    }
}
