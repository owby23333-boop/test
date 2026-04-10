package com.kwad.components.core.d.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import com.kwad.components.core.d.a.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
public final class a extends KSFrameLayout {
    private final b II;
    private final b.C0394b IJ;
    private d IK;
    private InterfaceC0393a IL;
    private final AdTemplate mAdTemplate;
    private final Context mContext;
    private Presenter mPresenter;
    private final AdBaseFrameLayout mRootContainer;

    /* JADX INFO: renamed from: com.kwad.components.core.d.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0393a {
        void mZ();
    }

    public a(Context context, b bVar, b.C0394b c0394b) {
        super(context);
        this.mContext = context;
        this.II = bVar;
        this.IJ = c0394b;
        this.mAdTemplate = c0394b.adTemplate;
        com.kwad.sdk.i.a.inflate(context, R.layout.ksad_download_dialog_layout, this);
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        a(this.mRootContainer, "rootView is null");
        a((KsAdWebView) this.mRootContainer.findViewById(R.id.ksad_download_tips_web_card_webView), "webView is null");
    }

    private void a(View view, String str) {
        if (view != null) {
            return;
        }
        throw new RuntimeException("inflateView fail " + str + "\n--viewCount:" + getChildCount() + "\n--context:" + this.mContext.getClass().getName() + "\n--LayoutInflater context: " + LayoutInflater.from(this.mContext).getContext().getClass().getName() + "\n--classloader:" + a.class.getClassLoader().getClass().getName());
    }

    private static Presenter an() {
        Presenter presenter = new Presenter();
        presenter.a(new e());
        return presenter;
    }

    private d mY() {
        d dVar = new d();
        dVar.II = this.II;
        dVar.IJ = this.IJ;
        AdTemplate adTemplate = this.mAdTemplate;
        dVar.mAdTemplate = adTemplate;
        dVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.a.a.ay(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            dVar.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
        }
        return dVar;
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        InterfaceC0393a interfaceC0393a = this.IL;
        if (interfaceC0393a != null) {
            interfaceC0393a.mZ();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewAttached() {
        super.onViewAttached();
        this.IK = mY();
        this.mPresenter = an();
        this.mPresenter.H(this.mRootContainer);
        this.mPresenter.f(this.IK);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void onViewDetached() {
        super.onViewDetached();
        d dVar = this.IK;
        if (dVar != null) {
            dVar.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public final void setChangeListener(InterfaceC0393a interfaceC0393a) {
        this.IL = interfaceC0393a;
    }
}
