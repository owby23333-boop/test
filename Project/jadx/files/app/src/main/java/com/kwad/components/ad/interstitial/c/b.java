package com.kwad.components.ad.interstitial.c;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Presenter {
    public c jq;

    @Override // com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        this.jq = (c) Bs();
    }

    public void cT() {
        List<Presenter> listBr = Br();
        if (listBr == null) {
            return;
        }
        for (Presenter presenter : listBr) {
            if (presenter instanceof b) {
                ((b) presenter).cT();
            }
        }
    }

    public void cU() {
        List<Presenter> listBr = Br();
        if (listBr == null) {
            return;
        }
        for (Presenter presenter : listBr) {
            if (presenter instanceof b) {
                ((b) presenter).cU();
            }
        }
    }
}
