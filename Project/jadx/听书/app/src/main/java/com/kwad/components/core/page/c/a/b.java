package com.kwad.components.core.page.c.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public com.kwad.components.core.page.a.a TK;
    public KsAdWebView.c TL;
    public f.a TM;

    @Deprecated
    public com.kwad.components.core.webview.jshandler.b TN;
    public boolean TO = false;
    public boolean TP = false;
    public AdWebViewActivityProxy.a Tu;
    public ViewGroup jI;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;
    public Context mContext;
    public String mPageTitle;
    public String mPageUrl;
    public boolean mShowPermission;
    public com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.TL = null;
        this.TM = null;
        this.mWebCardCloseListener = null;
        this.TN = null;
    }

    public final boolean qT() {
        return this.mShowPermission;
    }

    public final void a(KsAdWebView.c cVar) {
        this.TL = cVar;
    }

    public final void a(f.a aVar) {
        this.TM = aVar;
    }

    public final void setWebCardCloseListener(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    private void aJ(boolean z) {
        this.TP = true;
    }

    public final void a(boolean z, View view) {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.mAdWebView.goBack();
            if (z) {
                com.kwad.sdk.core.adlog.c.bZ(this.mAdTemplate);
                return;
            }
            return;
        }
        com.kwad.components.core.page.a.a aVar = this.TK;
        if (aVar != null) {
            aVar.qO();
        }
    }

    public final boolean re() {
        return this.TP;
    }

    public final void a(com.kwad.components.core.webview.jshandler.b bVar) {
        this.TN = bVar;
        aJ(true);
    }

    public final void qY() {
        com.kwad.components.core.webview.jshandler.b bVar = this.TN;
        if (bVar != null) {
            bVar.rs();
        }
    }

    public final boolean rf() {
        return !qT();
    }
}
