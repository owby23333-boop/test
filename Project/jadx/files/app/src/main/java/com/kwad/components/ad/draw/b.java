package com.kwad.components.ad.draw;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends KSFrameLayout {

    @Nullable
    private KsDrawAd.AdInteractionListener bV;
    private com.kwad.components.ad.draw.kwai.b bW;
    private com.kwad.components.ad.draw.b.a bX;
    private com.kwad.components.core.widget.kwai.b bY;
    private boolean bZ;
    private ImageView ca;
    private com.kwad.sdk.core.g.b cb;
    private View.OnClickListener cc;
    private i cd;
    private AdInfo mAdInfo;

    @NonNull
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private Presenter mPresenter;
    private AdBaseFrameLayout mRootContainer;

    public b(@NonNull Context context) {
        super(context);
        this.cc = new View.OnClickListener() { // from class: com.kwad.components.ad.draw.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.kwad.components.core.d.b.a.a(new a.C0395a(b.this.bW.mRootContainer.getContext()).J(b.this.bW.mAdTemplate).b(b.this.bW.mApkDownloadHelper).al(false).ap(3).a(new a.b() { // from class: com.kwad.components.ad.draw.b.1.1
                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                    }
                }));
                if (3 == com.kwad.sdk.core.response.a.a.bl(com.kwad.sdk.core.response.a.d.cb(b.this.bW.mAdTemplate))) {
                    b.this.al();
                }
            }
        };
        this.cd = new j() { // from class: com.kwad.components.ad.draw.b.2
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayPaused() {
                super.onVideoPlayPaused();
                b.this.ca.setVisibility(0);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                super.onVideoPlayStart();
                b.this.ca.setVisibility(8);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                b.this.ca.setVisibility(8);
            }
        };
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        this.bX.f(!this.bZ);
        if (this.bZ) {
            this.bX.resume();
        } else {
            this.bX.pause();
        }
        this.bZ = !this.bZ;
    }

    private com.kwad.components.ad.draw.kwai.b am() {
        com.kwad.components.ad.draw.kwai.b bVar = new com.kwad.components.ad.draw.kwai.b();
        bVar.bV = this.bV;
        bVar.mRootContainer = this.mRootContainer;
        bVar.mAdTemplate = this.mAdTemplate;
        if (com.kwad.sdk.core.response.a.a.ay(this.mAdInfo)) {
            bVar.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
        }
        bVar.bX = this.bX;
        bVar.co = new com.kwad.components.ad.draw.a.a.a(this.mAdTemplate);
        if (com.kwad.sdk.core.response.a.b.bf(this.mAdTemplate)) {
            bVar.cp = new com.kwad.components.ad.i.b();
        }
        return bVar;
    }

    private Presenter an() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.draw.a.kwai.a());
        presenter.a(new com.kwad.components.ad.draw.a.b());
        presenter.a(new com.kwad.components.ad.draw.a.d());
        presenter.a(new com.kwad.components.ad.draw.a.c());
        presenter.a(new com.kwad.components.ad.draw.a.a.b());
        if (com.kwad.sdk.core.response.a.b.aS(this.mAdTemplate)) {
            presenter.a(new com.kwad.components.ad.draw.a.a.c());
        }
        presenter.a(new com.kwad.components.ad.draw.a.b.a());
        if (com.kwad.sdk.core.response.a.b.bf(this.mAdTemplate)) {
            presenter.a(new com.kwad.components.ad.draw.a.b.b());
        }
        if (com.kwad.sdk.core.response.a.a.aI(this.mAdInfo)) {
            presenter.a(new com.kwad.components.ad.draw.a.a());
        }
        return presenter;
    }

    private void initView() {
        com.kwad.sdk.i.a.inflate(this.mContext, R.layout.ksad_draw_layout, this);
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.ca = (ImageView) this.mRootContainer.findViewById(R.id.ksad_video_control_button);
        this.mDetailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView.f(true, com.kwad.sdk.core.config.d.vh());
        this.mDetailVideoView.setOnClickListener(this.cc);
        this.ca.setOnClickListener(this.cc);
    }

    public final void a(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        this.bY = new com.kwad.components.core.widget.kwai.b(this, 70);
        this.bX = new com.kwad.components.ad.draw.b.a(this.mAdTemplate, this.bY, this.mDetailVideoView);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewAttached() {
        super.onViewAttached();
        this.bW = am();
        this.mPresenter = an();
        this.mPresenter.H(this.mRootContainer);
        this.mPresenter.f(this.bW);
        this.bY.a(this.cb);
        this.bY.rU();
        this.bX.aP();
        this.bX.a(this.cd);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewDetached() {
        super.onViewDetached();
        com.kwad.components.core.widget.kwai.b bVar = this.bY;
        if (bVar != null) {
            bVar.release();
        }
        com.kwad.components.ad.draw.b.a aVar = this.bX;
        if (aVar != null) {
            aVar.aQ();
            this.bX.b(this.cd);
        }
        com.kwad.components.ad.draw.kwai.b bVar2 = this.bW;
        if (bVar2 != null) {
            bVar2.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.bV = adInteractionListener;
    }

    public final void setPageExitListener(com.kwad.sdk.core.g.b bVar) {
        this.cb = bVar;
    }
}
