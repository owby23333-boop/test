package com.kwad.components.ad.draw.b;

import android.content.Context;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.sdk.mvp.a {
    private boolean dA;
    public com.kwad.components.ad.draw.c.a dB;
    public IAdLivePlayModule dC;
    public IAdLiveOfflineView dD;
    public com.kwad.components.ad.draw.presenter.b.a dE;
    public com.kwad.components.ad.l.b dF;
    public KsDrawAd.AdInteractionListener dh;
    public c mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        IAdLivePlayModule iAdLivePlayModule = this.dC;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.release();
            this.dC = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.dD;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.dD = null;
        }
        com.kwad.components.ad.draw.c.a aVar = this.dB;
        if (aVar != null) {
            aVar.release();
        }
    }

    public final void a(int i, Context context, final int i2, int i3) {
        a.C0333a c0333aAB = new a.C0333a(context).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aq(false).aB(i3);
        IAdLivePlayModule iAdLivePlayModule = this.dC;
        com.kwad.components.core.e.d.a.a(c0333aAB.A(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).ay(true).aA(i2).az(i).a(new a.b() { // from class: com.kwad.components.ad.draw.b.b.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    b.this.a(i2, null);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.dd(i);
        bVar.f(this.mRootContainer.getTouchCoords());
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, bVar, (JSONObject) null);
        KsDrawAd.AdInteractionListener adInteractionListener = this.dh;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        if (this.dA) {
            return;
        }
        com.kwad.components.ad.draw.a.c.b(this.mAdTemplate, 1, com.kwad.sdk.core.response.b.b.de(this.mAdTemplate) ? 2 : 1);
        this.dA = true;
    }
}
