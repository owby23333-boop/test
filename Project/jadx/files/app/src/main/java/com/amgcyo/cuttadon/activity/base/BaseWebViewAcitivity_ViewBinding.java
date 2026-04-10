package com.amgcyo.cuttadon.activity.base;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.amgcyo.cuttadon.view.webview.MkWebProgress;
import com.fatcatfat.io.R;
import com.tencent.smtt.sdk.WebView;

/* JADX INFO: loaded from: classes.dex */
public class BaseWebViewAcitivity_ViewBinding implements Unbinder {
    private BaseWebViewAcitivity a;

    @UiThread
    public BaseWebViewAcitivity_ViewBinding(BaseWebViewAcitivity baseWebViewAcitivity, View view) {
        this.a = baseWebViewAcitivity;
        baseWebViewAcitivity.pbProgress = (MkWebProgress) Utils.findRequiredViewAsType(view, R.id.pb_progress, "field 'pbProgress'", MkWebProgress.class);
        baseWebViewAcitivity.webView = (WebView) Utils.findRequiredViewAsType(view, R.id.webview, "field 'webView'", WebView.class);
        baseWebViewAcitivity.mRefreshView = (PullToRefreshView) Utils.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mRefreshView'", PullToRefreshView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BaseWebViewAcitivity baseWebViewAcitivity = this.a;
        if (baseWebViewAcitivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        baseWebViewAcitivity.pbProgress = null;
        baseWebViewAcitivity.webView = null;
        baseWebViewAcitivity.mRefreshView = null;
    }
}
