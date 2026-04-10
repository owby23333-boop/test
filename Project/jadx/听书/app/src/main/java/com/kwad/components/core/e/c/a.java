package com.kwad.components.core.e.c;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import com.kwad.components.core.e.c.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends KSFrameLayout {
    private final b OG;
    private final b.C0332b OH;
    private d OI;
    private InterfaceC0331a OJ;
    private final AdTemplate mAdTemplate;
    private final Context mContext;
    private Presenter mPresenter;
    private final AdBaseFrameLayout mRootContainer;

    /* JADX INFO: renamed from: com.kwad.components.core.e.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0331a {
        void oV();
    }

    public a(Context context, b bVar, b.C0332b c0332b) {
        super(context);
        this.mContext = context;
        this.OG = bVar;
        this.OH = c0332b;
        this.mAdTemplate = c0332b.adTemplate;
        m.inflate(context, R.layout.ksad_download_dialog_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        b(adBaseFrameLayout, "rootView is null");
        b((KsAdWebView) adBaseFrameLayout.findViewById(R.id.ksad_download_tips_web_card_webView), "webView is null");
    }

    private void b(View view, String str) {
        if (view == null) {
            throw new RuntimeException("inflateView fail " + str + "\n--viewCount:" + getChildCount() + "\n--context:" + this.mContext.getClass().getName() + "\n--LayoutInflater context: " + LayoutInflater.from(this.mContext).getContext().getClass().getName() + "\n--classloader:" + getClass().getClassLoader().getClass().getName());
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        this.OI = oU();
        Presenter presenterBD = bD();
        this.mPresenter = presenterBD;
        presenterBD.K(this.mRootContainer);
        this.mPresenter.n(this.OI);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        d dVar = this.OI;
        if (dVar != null) {
            dVar.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    private d oU() {
        d dVar = new d();
        dVar.OG = this.OG;
        dVar.OH = this.OH;
        dVar.mAdTemplate = this.mAdTemplate;
        dVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate))) {
            dVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        return dVar;
    }

    private static Presenter bD() {
        Presenter presenter = new Presenter();
        presenter.a(new e());
        return presenter;
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        InterfaceC0331a interfaceC0331a = this.OJ;
        if (interfaceC0331a != null) {
            interfaceC0331a.oV();
        }
    }

    public final void setChangeListener(InterfaceC0331a interfaceC0331a) {
        this.OJ = interfaceC0331a;
    }
}
