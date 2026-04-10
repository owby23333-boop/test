package com.qmuiteam.qmui.widget.webview;

import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.qmuiteam.qmui.util.QMUILangHelper;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIBridgeWebViewClient extends QMUIWebViewClient {
    public static final String QMUI_BRIDGE_HAS_MESSAGE = "qmui://__QUEUE_MESSAGE__";
    public static final String QMUI_BRIDGE_JS = "QMUIWebviewBridge.js";
    private boolean mNeedInjectLocalBridgeJs;
    private QMUIWebViewBridgeHandler mWebViewBridgeHandler;

    public QMUIBridgeWebViewClient(boolean z, boolean z2, QMUIWebViewBridgeHandler qMUIWebViewBridgeHandler) {
        this(z, z2, true, qMUIWebViewBridgeHandler);
    }

    public QMUIBridgeWebViewClient(boolean z, boolean z2, boolean z3, QMUIWebViewBridgeHandler qMUIWebViewBridgeHandler) {
        super(z, z2);
        this.mNeedInjectLocalBridgeJs = z3;
        this.mWebViewBridgeHandler = qMUIWebViewBridgeHandler;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(QMUI_BRIDGE_HAS_MESSAGE)) {
            this.mWebViewBridgeHandler.fetchAndMessageFromJs();
            return true;
        }
        return onShouldOverrideUrlLoading(webView, str);
    }

    protected boolean onShouldOverrideUrlLoading(WebView webView, String str) {
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest.getUrl().toString().startsWith(QMUI_BRIDGE_HAS_MESSAGE)) {
            this.mWebViewBridgeHandler.fetchAndMessageFromJs();
            return true;
        }
        return onShouldOverrideUrlLoading(webView, webResourceRequest);
    }

    protected boolean onShouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // com.qmuiteam.qmui.widget.webview.QMUIWebViewClient, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) throws Throwable {
        super.onPageFinished(webView, str);
        if (this.mNeedInjectLocalBridgeJs) {
            String strLoadBridgeScript = loadBridgeScript(webView.getContext());
            if (strLoadBridgeScript != null) {
                webView.evaluateJavascript(strLoadBridgeScript, null);
                this.mWebViewBridgeHandler.onBridgeLoaded();
                return;
            }
            return;
        }
        this.mWebViewBridgeHandler.onBridgeLoaded();
    }

    private static String loadBridgeScript(Context context) throws Throwable {
        Throwable th;
        InputStream inputStreamOpen;
        try {
            inputStreamOpen = context.getAssets().open(QMUI_BRIDGE_JS);
        } catch (Exception e) {
            e = e;
            inputStreamOpen = null;
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpen = null;
            QMUILangHelper.close(inputStreamOpen);
            throw th;
        }
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
                StringBuilder sb = new StringBuilder();
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    sb.append(line);
                    sb.append("\n");
                }
                bufferedReader.close();
                inputStreamOpen.close();
                String string = sb.toString();
                QMUILangHelper.close(inputStreamOpen);
                return string;
            } catch (Throwable th3) {
                th = th3;
                QMUILangHelper.close(inputStreamOpen);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            QMUILangHelper.close(inputStreamOpen);
            return null;
        }
    }
}
