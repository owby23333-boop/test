package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.mvp.Presenter;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: loaded from: classes3.dex */
public class a extends Presenter {
    public com.kwad.components.ad.reward.j qS;

    public final void L(boolean z2) {
        int i2 = z2 ? 1 : TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED;
        com.kwad.components.ad.reward.j jVar = this.qS;
        com.kwad.sdk.core.report.a.a(jVar.mAdTemplate, i2, jVar.mRootContainer.getTouchCoords(), this.qS.mReportExtData);
        this.qS.mAdOpenInteractionListener.bN();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        this.qS = (com.kwad.components.ad.reward.j) Bs();
    }

    protected final void hH() {
        this.qS.hH();
    }
}
