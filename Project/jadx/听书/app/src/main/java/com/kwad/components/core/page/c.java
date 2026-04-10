package com.kwad.components.core.page;

import android.content.Context;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.e;
import com.kwad.components.core.page.c.a.f;
import com.kwad.components.core.page.c.a.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.core.m.c<com.kwad.components.core.page.c.a.b> {
    private AdWebViewActivityProxy.a Tu;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean mAutoShow;
    private Context mContext;
    private com.kwad.components.core.page.a.a mLandPageViewListener;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    @Override // com.kwad.components.core.m.c
    public final void initData() {
    }

    private c(Context context) {
        super(context);
    }

    @Override // com.kwad.components.core.m.c
    public final void ak() {
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.components.core.m.c, com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.release();
            this.mAdWebView = null;
        }
    }

    @Override // com.kwad.components.core.m.c
    public final int getLayoutId() {
        return R.layout.ksad_activity_ad_webview;
    }

    public static c a(Context context, AdWebViewActivityProxy.a aVar) {
        c cVar = new c(context);
        cVar.b(context, aVar);
        return cVar;
    }

    private void b(Context context, AdWebViewActivityProxy.a aVar) {
        this.Tu = aVar;
        this.mContext = context;
        this.mAdTemplate = aVar.getAdTemplate();
        this.mPageUrl = aVar.qR();
        this.mPageTitle = aVar.qQ();
        this.mShowPermission = aVar.qT();
        this.mAutoShow = aVar.qV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.m.c
    /* JADX INFO: renamed from: qX, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.core.page.c.a.b al() {
        com.kwad.components.core.page.c.a.b bVar = new com.kwad.components.core.page.c.a.b();
        bVar.mContext = this.mContext;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.Tu = this.Tu;
        bVar.mPageTitle = this.mPageTitle;
        bVar.mPageUrl = this.mPageUrl;
        bVar.mAutoShow = this.mAutoShow;
        bVar.mShowPermission = this.mShowPermission;
        bVar.TK = this.mLandPageViewListener;
        bVar.setWebCardCloseListener(this.mWebCardCloseListener);
        bVar.jI = this.nY;
        return bVar;
    }

    public final void setLandPageViewListener(com.kwad.components.core.page.a.a aVar) {
        this.mLandPageViewListener = aVar;
    }

    public final void setWebCardCloseListener(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
        if (this.mAdWebView != null || bVar == null) {
            return;
        }
        bVar.b(null);
    }

    public final boolean getCanInterceptBackClick() {
        return ((com.kwad.components.core.page.c.a.b) this.mPresenter.NN()).re();
    }

    public final void qY() {
        ((com.kwad.components.core.page.c.a.b) this.mPresenter.NN()).qY();
    }

    @Override // com.kwad.components.core.m.c
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new f());
        presenter.a(new e());
        if (com.kwad.sdk.core.response.b.e.O(((com.kwad.components.core.page.c.a.b) this.Rv).mAdTemplate)) {
            presenter.a(new com.kwad.components.core.page.c.a.c());
        }
        if (com.kwad.sdk.core.response.b.a.aO(com.kwad.sdk.core.response.b.e.el(((com.kwad.components.core.page.c.a.b) this.Rv).mAdTemplate)) && com.kwad.components.core.r.a.sF().sL() && com.kwad.components.core.r.a.sF().sG() == 1) {
            presenter.a(new com.kwad.components.core.page.c.a.d());
        }
        presenter.a(new g());
        return presenter;
    }
}
