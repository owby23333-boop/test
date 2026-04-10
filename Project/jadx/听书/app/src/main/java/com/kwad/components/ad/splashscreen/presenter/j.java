package com.kwad.components.ad.splashscreen.presenter;

import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends e {
    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        findViewById(R.id.splash_play_card_view).setVisibility(0);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.j.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                j.this.dc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc() {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate);
        a(new b(), true);
        a(new c(), true);
        if (com.kwad.sdk.core.response.b.a.bc(adInfoEl)) {
            a(new d(), true);
            a(new t(), true);
        } else {
            a(new h(), true);
        }
        if (this.Gf.Fy) {
            a(new s(), true);
        } else {
            boolean zDM = com.kwad.sdk.core.response.b.b.dM(adInfoEl);
            boolean zDQ = com.kwad.sdk.core.response.b.b.dQ(adInfoEl);
            boolean zDY = com.kwad.sdk.core.response.b.b.dY(adInfoEl);
            if (com.kwad.sdk.core.response.b.b.dS(adInfoEl)) {
                a(new q(), true);
            } else if (zDM) {
                a(new o(), true);
            } else if (zDQ) {
                a(new m(), true);
            } else if (zDY) {
                a(new s(), true);
            } else {
                a(new s(), true);
            }
        }
        if (com.kwad.sdk.core.response.b.a.aP(adInfoEl)) {
            a(new f(), true);
        }
        if (!this.Gf.bO) {
            a(new com.kwad.components.ad.splashscreen.presenter.playcard.b(), true);
        }
        a(new a(), true);
        a(new g(), true);
    }
}
