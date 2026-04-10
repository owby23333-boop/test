package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends a {
    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        try {
            this.qS.pw.ka().jU();
        } catch (Throwable th) {
            bh.postOnUiThread(new av() { // from class: com.kwad.components.ad.reward.presenter.i.1
                @Override // com.kwad.sdk.utils.av
                public final void doTask() {
                    com.kwad.sdk.crash.b.f(th);
                    i.this.hH();
                }
            });
        }
    }
}
