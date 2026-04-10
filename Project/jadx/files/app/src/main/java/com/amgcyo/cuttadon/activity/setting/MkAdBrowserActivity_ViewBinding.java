package com.amgcyo.cuttadon.activity.setting;

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
public class MkAdBrowserActivity_ViewBinding implements Unbinder {
    private MkAdBrowserActivity a;

    @UiThread
    public MkAdBrowserActivity_ViewBinding(MkAdBrowserActivity mkAdBrowserActivity, View view) {
        this.a = mkAdBrowserActivity;
        mkAdBrowserActivity.pbProgress = (MkWebProgress) Utils.findRequiredViewAsType(view, R.id.pb_progress, "field 'pbProgress'", MkWebProgress.class);
        mkAdBrowserActivity.webView = (WebView) Utils.findRequiredViewAsType(view, R.id.webview, "field 'webView'", WebView.class);
        mkAdBrowserActivity.mRefreshView = (PullToRefreshView) Utils.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mRefreshView'", PullToRefreshView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MkAdBrowserActivity mkAdBrowserActivity = this.a;
        if (mkAdBrowserActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        mkAdBrowserActivity.pbProgress = null;
        mkAdBrowserActivity.webView = null;
        mkAdBrowserActivity.mRefreshView = null;
    }
}
