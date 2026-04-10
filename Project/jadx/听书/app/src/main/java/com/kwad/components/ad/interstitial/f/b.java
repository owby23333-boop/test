package com.kwad.components.ad.interstitial.f;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b extends Presenter {
    public c mj;

    @Override // com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        this.mj = (c) NN();
    }

    public void dR() {
        List<Presenter> listNM = NM();
        if (listNM == null) {
            return;
        }
        for (Presenter presenter : listNM) {
            if (presenter instanceof b) {
                ((b) presenter).dR();
            }
        }
    }

    public void dS() {
        List<Presenter> listNM = NM();
        if (listNM == null) {
            return;
        }
        for (Presenter presenter : listNM) {
            if (presenter instanceof b) {
                ((b) presenter).dS();
            }
        }
    }
}
