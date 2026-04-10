package com.kwad.components.ad.e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.e.a.g;
import com.kwad.components.ad.e.a.h;
import com.kwad.components.ad.e.a.i;
import com.kwad.components.ad.e.a.k;
import com.kwad.components.ad.e.d;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.j;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends KSFrameLayout {
    private com.kwad.components.core.widget.kwai.b bY;
    private j cK;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private KsNativeAd.VideoPlayListener mJ;
    private d.a mO;
    private Presenter mPresenter;
    private AdBasePvFrameLayout na;
    private com.kwad.components.ad.e.kwai.b nf;
    private com.kwad.components.ad.e.b.a ng;
    private KsAdVideoPlayConfig nh;

    public f(@NonNull Context context) {
        this(context, null);
    }

    private f(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private f(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, 0);
        this.cK = new j() { // from class: com.kwad.components.ad.e.f.1
            @Override // com.kwad.sdk.widget.j
            public final void aw() {
                l.cu(f.this.mAdTemplate);
            }
        };
        D(context);
    }

    private void D(Context context) {
        com.kwad.sdk.i.a.inflate(context, R.layout.ksad_native_video_layout, this);
        this.na = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.mDetailVideoView = (DetailVideoView) this.na.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView.setAd(true);
    }

    private Presenter an() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.e.a.e());
        presenter.a(new com.kwad.components.ad.e.a.c());
        presenter.a(new i());
        presenter.a(new com.kwad.components.ad.e.a.j());
        presenter.a(new com.kwad.components.ad.e.a.d());
        presenter.a(new com.kwad.components.ad.e.a.b());
        presenter.a(new k());
        presenter.a(new com.kwad.components.ad.e.a.a(this.nh));
        presenter.a(new g());
        presenter.a(com.kwad.sdk.core.response.a.a.ay(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate)) ? new com.kwad.components.ad.e.a.f() : new h());
        return presenter;
    }

    private com.kwad.components.ad.e.kwai.b eR() {
        com.kwad.components.ad.e.kwai.b bVar = new com.kwad.components.ad.e.kwai.b();
        bVar.na = this.na;
        AdTemplate adTemplate = this.mAdTemplate;
        bVar.mAdTemplate = adTemplate;
        bVar.mO = this.mO;
        bVar.mJ = this.mJ;
        bVar.mApkDownloadHelper = (this.mApkDownloadHelper == null && com.kwad.sdk.core.response.a.a.ay(com.kwad.sdk.core.response.a.d.cb(adTemplate))) ? new com.kwad.components.core.d.b.c(this.mAdTemplate) : this.mApkDownloadHelper;
        bVar.ng = this.ng;
        return bVar;
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.nh = ksAdVideoPlayConfig;
        this.na.setVisibleListener(this.cK);
        this.bY = new com.kwad.components.core.widget.kwai.b(getParent() == null ? this : (View) getParent(), 30);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewAttached() {
        super.onViewAttached();
        if (this.ng == null) {
            this.ng = new com.kwad.components.ad.e.b.a(this.mAdTemplate, this.bY, this.mDetailVideoView, this.nh);
        }
        this.nf = eR();
        this.mPresenter = an();
        this.mPresenter.H(this.na);
        this.mPresenter.f(this.nf);
        this.bY.rU();
        this.ng.aP();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewDetached() {
        super.onViewDetached();
        com.kwad.components.core.widget.kwai.b bVar = this.bY;
        if (bVar != null) {
            bVar.release();
        }
        com.kwad.components.ad.e.b.a aVar = this.ng;
        if (aVar != null) {
            aVar.aQ();
        }
        com.kwad.components.ad.e.kwai.b bVar2 = this.nf;
        if (bVar2 != null) {
            bVar2.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.mO = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.mJ = videoPlayListener;
    }
}
