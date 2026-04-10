package com.kwad.components.core.page.a.kwai;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.a.kwai.f;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public com.kwad.components.core.page.kwai.a LM;

    @Nullable
    public KsAdWebView.c LN;

    @Nullable
    public f.a LO;

    @Nullable
    public ac.b LP;
    public boolean LQ = false;
    public boolean LR = false;

    @NonNull
    public ViewGroup gu;

    @NonNull
    public AdTemplate mAdTemplate;

    @NonNull
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;

    @NonNull
    public Context mContext;

    @Nullable
    public String mPageTitle;

    @NonNull
    public String mPageUrl;
    public boolean mShowPermission;

    @Nullable
    public com.kwad.sdk.core.webview.c.kwai.b mWebCardCloseListener;

    private void aA(boolean z2) {
        this.LR = true;
    }

    public final void a(f.a aVar) {
        this.LO = aVar;
    }

    public final void a(ac.b bVar) {
        this.LP = bVar;
        aA(true);
    }

    public final void a(KsAdWebView.c cVar) {
        this.LN = cVar;
    }

    public final boolean oE() {
        return this.LR;
    }

    public final boolean oF() {
        return !ou();
    }

    public final boolean ou() {
        return this.mShowPermission;
    }

    public final void oy() {
        ac.b bVar = this.LP;
        if (bVar != null) {
            bVar.oO();
        }
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.LN = null;
        this.LO = null;
        this.mWebCardCloseListener = null;
        this.LP = null;
    }

    public final void setWebCardCloseListener(@Nullable com.kwad.sdk.core.webview.c.kwai.b bVar) {
        this.mWebCardCloseListener = bVar;
    }
}
