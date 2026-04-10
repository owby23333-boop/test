package com.kwad.components.ad.c.c;

import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: classes3.dex */
public class a extends Presenter {
    public com.kwad.components.ad.c.b cD;

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        Object objNN = NN();
        if (objNN instanceof com.kwad.components.ad.c.b) {
            this.cD = (com.kwad.components.ad.c.b) objNN;
        }
    }
}
