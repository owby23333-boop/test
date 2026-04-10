package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.api.core.ApiWebView;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.d;
import com.kwad.sdk.utils.bl;

/* JADX INFO: loaded from: classes3.dex */
public class c extends ApiWebView {
    private boolean aoR;
    private com.kwad.sdk.core.webview.kwai.a aoS;

    public c(Context context) {
        super(bp(context));
        this.aoR = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet) {
        super(bp(context), attributeSet);
        this.aoR = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i2) {
        super(bp(context), attributeSet, i2);
        this.aoR = true;
        init();
    }

    @RequiresApi(api = 21)
    public c(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(bp(context), attributeSet, i2, i3);
        this.aoR = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i2, boolean z2) {
        super(bp(context), attributeSet, i2, z2);
        this.aoR = true;
        init();
    }

    private static Context bp(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21 && i2 < 23) {
            context = context.createConfigurationContext(new Configuration());
        }
        Context contextUnwrapContextIfNeed = Wrapper.unwrapContextIfNeed(context);
        if (!(contextUnwrapContextIfNeed instanceof ResContext)) {
            return contextUnwrapContextIfNeed;
        }
        ((d) ServiceProvider.get(d.class)).gatherException(new IllegalArgumentException("KSApiWebView context not except--context:" + contextUnwrapContextIfNeed.getClass().getName() + "--classloader:" + contextUnwrapContextIfNeed.getClassLoader().getClass().getName() + "--context2:" + Wrapper.unwrapContextIfNeed(ServiceProvider.getContext()).getClass().getName()));
        return Wrapper.unwrapContextIfNeed(ServiceProvider.getContext());
    }

    private void init() {
        bl.a(this);
        this.aoS = new com.kwad.sdk.core.webview.kwai.a();
        setWebViewClient(this.aoS);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.aoR) {
            super.destroy();
        }
    }

    public final void release() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
        removeAllViews();
        destroy();
    }

    public void setEnableDestroy(boolean z2) {
        this.aoR = z2;
    }

    public void setNeedHybridLoad(boolean z2) {
        this.aoS.setNeedHybridLoad(z2);
    }
}
