package com.anythink.expressad.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.b.a;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.webview.BrowserView;
import com.anythink.expressad.video.signal.factory.b;
import com.anythink.expressad.videocommon.b.i;
import com.anythink.expressad.videocommon.e.c;
import com.anythink.expressad.videocommon.e.d;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkAlertWebview extends AnythinkH5EndCardView {
    private String A;

    public AnythinkAlertWebview(Context context) {
        super(context);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    protected final String a() {
        if (TextUtils.isEmpty(this.f11830x)) {
            return "";
        }
        c.a().a(a.b().e(), this.f11830x, false);
        this.A = d.J();
        return !TextUtils.isEmpty(this.A) ? i.a().c(this.A) : "";
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    protected final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.f
    public void preLoadData(b bVar) {
        String strA = a();
        if (!this.f11788f || this.b == null || TextUtils.isEmpty(strA)) {
            this.f11787e.a(101, "");
            return;
        }
        BrowserView.DownloadListener downloadListener = new BrowserView.DownloadListener(this.b);
        downloadListener.setTitle(this.b.bb());
        this.f11825s.setDownloadListener(downloadListener);
        this.f11825s.setCampaignId(this.b.aZ());
        setCloseVisible(8);
        this.f11825s.setApiManagerJSFactory(bVar);
        this.f11825s.setWebViewListener(new com.anythink.expressad.atsignalcommon.a.b() { // from class: com.anythink.expressad.video.module.AnythinkAlertWebview.1
            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                o.d("AlertWebview", "===========finish+".concat(String.valueOf(str)));
                j.a();
                j.a(webView, "onJSBridgeConnected", "");
            }

            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
                o.d("AlertWebview", "===========onReceivedError");
                if (AnythinkAlertWebview.this.f11829w) {
                    return;
                }
                o.a(AnythinkBaseView.TAG, "onReceivedError,url:".concat(String.valueOf(str2)));
                AnythinkAlertWebview.this.f11829w = true;
            }

            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void readyState(WebView webView, int i2) {
                super.readyState(webView, i2);
                o.d("MBridgeAlertWebview", "===========readyState  :  ".concat(String.valueOf(i2)));
                AnythinkAlertWebview anythinkAlertWebview = AnythinkAlertWebview.this;
                if (anythinkAlertWebview.f11829w) {
                    return;
                }
                anythinkAlertWebview.f11828v = i2 == 1;
            }
        });
        setHtmlSource(com.anythink.expressad.videocommon.b.j.a().b(strA));
        this.f11828v = false;
        if (TextUtils.isEmpty(this.f11827u)) {
            o.a(AnythinkBaseView.TAG, "load url:".concat(String.valueOf(strA)));
            this.f11825s.loadUrl(strA);
        } else {
            o.a(AnythinkBaseView.TAG, "load html...");
            this.f11825s.loadDataWithBaseURL(strA, this.f11827u, "text/html", "UTF-8", null);
        }
        this.f11825s.setBackgroundColor(0);
        setBackgroundColor(0);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.h
    public void webviewshow() {
        RelativeLayout relativeLayout = this.f11823q;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(0);
        }
        super.webviewshow();
    }

    public AnythinkAlertWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
