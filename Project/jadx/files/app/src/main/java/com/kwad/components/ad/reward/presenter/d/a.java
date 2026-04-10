package com.kwad.components.ad.reward.presenter.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a implements r.a, com.kwad.sdk.core.webview.c.kwai.a {
    private KsAdWebView cS;
    private s vF;
    private KSFrameLayout wa;
    private View wb;
    private u wc;

    private void initView() {
        this.cS = (KsAdWebView) findViewById(R.id.ksad_right_area_webview);
        this.wa = (KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container);
        this.wb = findViewById(R.id.ksad_playabale_end_card);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        initView();
        boolean z2 = !ah.cu(getContext()) && d.cn(this.qS.mAdTemplate);
        b.d("PlayableHorizontalPresenter", "onBind enable: " + z2);
        if (z2) {
            this.vF.e((ViewGroup) getRootView());
            this.vF.b(v.C(this.qS.mAdTemplate));
            this.wa.setWidthBasedRatio(false);
            if (this.wc == null) {
                this.wc = new u(this.cS, this.wb, this.qS.mApkDownloadHelper, this);
            }
            this.wc.a(this.qS.mAdTemplate, (AdBaseFrameLayout) findViewById(R.id.ksad_root_container));
        }
    }

    @Override // com.kwad.components.ad.reward.k.r.a
    public final void ir() {
    }

    @Override // com.kwad.components.ad.reward.k.r.a
    public final void is() {
        com.kwad.components.ad.reward.b.fz().c(PlayableSource.ACTIONBAR_CLICK, new com.kwad.components.ad.reward.f.a(getContext()));
        com.kwad.sdk.core.report.a.p(this.qS.mAdTemplate, 67);
    }

    @Override // com.kwad.components.ad.reward.k.r.a
    public final void it() {
        this.qS.a(1, getContext(), 1, 1);
    }

    @Override // com.kwad.components.ad.reward.k.r.a
    public final void iu() {
        this.qS.a(1, getContext(), 1, 2);
    }

    @Override // com.kwad.sdk.core.webview.c.kwai.a
    public final void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vF = new s(-1);
        this.vF.a(this);
    }
}
