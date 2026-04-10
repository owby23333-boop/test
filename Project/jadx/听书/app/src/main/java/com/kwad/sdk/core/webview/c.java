package com.kwad.sdk.core.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.cb;

/* JADX INFO: loaded from: classes4.dex */
public class c extends WebView {
    private boolean aMS;
    private com.kwad.sdk.core.webview.a.a aMT;

    public c(Context context) {
        super(bT(context));
        this.aMS = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet) {
        super(bT(context), attributeSet);
        this.aMS = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(bT(context), attributeSet, i);
        this.aMS = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i, int i2) {
        super(bT(context), attributeSet, i, i2);
        this.aMS = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(bT(context), attributeSet, i, z);
        this.aMS = true;
        init();
    }

    public void setNeedHybridLoad(boolean z) {
        this.aMT.setNeedHybridLoad(z);
    }

    private void init() {
        cb.a(this);
        com.kwad.sdk.core.webview.a.a aVar = new com.kwad.sdk.core.webview.a.a();
        this.aMT = aVar;
        setWebViewClient(aVar);
    }

    private static Context bT(Context context) {
        Context contextEl = m.el(context);
        if (m.eo(contextEl)) {
            return contextEl;
        }
        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSApiWebView context not except--context:" + contextEl.getClass().getName() + "--classloader:" + contextEl.getClass().getClassLoader() + "--context2:" + m.el(ServiceProvider.Pp()).getClass().getName()));
        return m.el(ServiceProvider.Pp());
    }

    public void setEnableDestroy(boolean z) {
        this.aMS = z;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.aMS) {
            release();
        }
    }

    public final void release() {
        try {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
            removeAllViews();
            super.destroy();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }
}
