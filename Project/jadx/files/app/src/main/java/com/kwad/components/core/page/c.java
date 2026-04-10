package com.kwad.components.core.page;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.a.kwai.e;
import com.kwad.components.core.page.a.kwai.f;
import com.kwad.components.core.page.a.kwai.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.core.j.c<com.kwad.components.core.page.a.kwai.b> {
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean mAutoShow;
    private Context mContext;
    private com.kwad.components.core.page.kwai.a mLandPageViewListener;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private com.kwad.sdk.core.webview.c.kwai.b mWebCardCloseListener;

    private c(Context context) {
        super(context);
    }

    public static c b(Context context, AdWebViewActivityProxy.a aVar) {
        c cVar = new c(context);
        cVar.c(context, aVar);
        return cVar;
    }

    private void c(Context context, AdWebViewActivityProxy.a aVar) {
        this.mContext = context;
        this.mAdTemplate = aVar.getAdTemplate();
        this.mPageUrl = aVar.ot();
        this.mPageTitle = aVar.os();
        this.mShowPermission = aVar.ou();
        this.mAutoShow = aVar.ov();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.j.c
    /* JADX INFO: renamed from: ox, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.core.page.a.kwai.b kH() {
        com.kwad.components.core.page.a.kwai.b bVar = new com.kwad.components.core.page.a.kwai.b();
        bVar.mContext = this.mContext;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.mPageTitle = this.mPageTitle;
        bVar.mPageUrl = this.mPageUrl;
        bVar.mAutoShow = this.mAutoShow;
        bVar.mShowPermission = this.mShowPermission;
        bVar.LM = this.mLandPageViewListener;
        bVar.setWebCardCloseListener(this.mWebCardCloseListener);
        bVar.gu = this.lU;
        return bVar;
    }

    public final boolean getCanInterceptBackClick() {
        return ((com.kwad.components.core.page.a.kwai.b) this.mPresenter.Bs()).oE();
    }

    @Override // com.kwad.components.core.j.c
    public final int getLayoutId() {
        return R.layout.ksad_activity_ad_webview;
    }

    @Override // com.kwad.components.core.j.c
    public final void initData() {
    }

    @Override // com.kwad.components.core.j.c
    public final void kF() {
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.components.core.j.c
    @NonNull
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new f());
        presenter.a(new e());
        if (com.kwad.sdk.core.response.a.d.q(((com.kwad.components.core.page.a.kwai.b) this.Ki).mAdTemplate)) {
            presenter.a(new com.kwad.components.core.page.a.kwai.c());
        }
        if (com.kwad.sdk.core.response.a.a.aH(com.kwad.sdk.core.response.a.d.cb(((com.kwad.components.core.page.a.kwai.b) this.Ki).mAdTemplate)) && com.kwad.components.core.p.a.pJ().pP() && com.kwad.components.core.p.a.pJ().pK() == 1) {
            presenter.a(new com.kwad.components.core.page.a.kwai.d());
        }
        presenter.a(new g());
        return presenter;
    }

    public final void oy() {
        ((com.kwad.components.core.page.a.kwai.b) this.mPresenter.Bs()).oy();
    }

    public final void setLandPageViewListener(com.kwad.components.core.page.kwai.a aVar) {
        this.mLandPageViewListener = aVar;
    }

    public final void setWebCardCloseListener(com.kwad.sdk.core.webview.c.kwai.b bVar) {
        this.mWebCardCloseListener = bVar;
        if (this.mAdWebView != null || bVar == null) {
            return;
        }
        bVar.a(null);
    }
}
