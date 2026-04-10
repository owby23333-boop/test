package com.dangdang.zframework.view;

import android.app.ActivityManager;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class DDWebView extends BridgeWebView {
    private WebChromeClient chromeClient;
    Context mContext;

    public DDWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.chromeClient = new WebChromeClient() { // from class: com.dangdang.zframework.view.DDWebView.1
        };
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        setWebChromeClient(this.chromeClient);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dangdang.zframework.view.DDWebView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
    }

    private boolean isAccessibilityInjectionEnabled() {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            return !r0.getEnabledAccessibilityServiceList(1).isEmpty();
        }
        return false;
    }

    public void clear() {
    }

    public void destroy() {
        try {
            removeAllViews();
            setOnLongClickListener(null);
            setWebChromeClient(null);
            setWebViewClient(null);
            removeAllViews();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getContentHeight() {
        return super.getContentHeight() + 5;
    }

    public ProgressBar getProgressBar() {
        return new ProgressBar(this.mContext);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebView getWebView() {
        return this;
    }

    public boolean isServiceWork(Context context, String str) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningServices(Integer.MAX_VALUE);
        if (runningServices.size() <= 0) {
            return false;
        }
        for (int i = 0; i < runningServices.size(); i++) {
            if (runningServices.get(i).service.getClassName().toString().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTTsAvilible() {
        if (isAccessibilityInjectionEnabled()) {
            return true;
        }
        return isServiceWork(getContext(), "com.google.android.marvin.talkback.TalkBackService");
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (isTTsAvilible()) {
            return;
        }
        super.setOnLongClickListener(onLongClickListener);
    }

    public void setShowProgressBar(boolean z) {
    }

    public DDWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.chromeClient = new WebChromeClient() { // from class: com.dangdang.zframework.view.DDWebView.1
        };
        this.mContext = context;
        init(context);
    }

    public DDWebView(Context context) {
        super(context);
        this.chromeClient = new WebChromeClient() { // from class: com.dangdang.zframework.view.DDWebView.1
        };
        this.mContext = context;
        init(context);
    }
}
