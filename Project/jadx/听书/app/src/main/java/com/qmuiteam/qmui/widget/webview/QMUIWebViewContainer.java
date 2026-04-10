package com.qmuiteam.qmui.widget.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIWebViewContainer extends QMUIFrameLayout {
    private QMUIWebView.OnScrollChangeListener mOnScrollChangeListener;
    private QMUIWebView mWebView;

    public QMUIWebViewContainer(Context context) {
        super(context);
    }

    public QMUIWebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void addWebView(QMUIWebView qMUIWebView, boolean z) {
        this.mWebView = qMUIWebView;
        qMUIWebView.setNeedDispatchSafeAreaInset(z);
        this.mWebView.addCustomOnScrollChangeListener(new QMUIWebView.OnScrollChangeListener() { // from class: com.qmuiteam.qmui.widget.webview.QMUIWebViewContainer.1
            @Override // com.qmuiteam.qmui.widget.webview.QMUIWebView.OnScrollChangeListener
            public void onScrollChange(WebView webView, int i, int i2, int i3, int i4) {
                if (QMUIWebViewContainer.this.mOnScrollChangeListener != null) {
                    QMUIWebViewContainer.this.mOnScrollChangeListener.onScrollChange(webView, i, i2, i3, i4);
                }
            }
        });
        addView(this.mWebView, getWebViewLayoutParams());
        QMUIWindowInsetHelper.handleWindowInsets(this, WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.displayCutout());
    }

    protected FrameLayout.LayoutParams getWebViewLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public void setNeedDispatchSafeAreaInset(boolean z) {
        QMUIWebView qMUIWebView = this.mWebView;
        if (qMUIWebView != null) {
            qMUIWebView.setNeedDispatchSafeAreaInset(z);
        }
    }

    public void destroy() {
        removeView(this.mWebView);
        removeAllViews();
        this.mWebView.setWebChromeClient(null);
        this.mWebView.setWebViewClient(null);
        this.mWebView.destroy();
    }

    public void setCustomOnScrollChangeListener(QMUIWebView.OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }
}
