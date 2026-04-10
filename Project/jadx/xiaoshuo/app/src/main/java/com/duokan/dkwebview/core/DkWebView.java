package com.duokan.dkwebview.core;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;
import android.webkit.DownloadListener;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import com.duokan.core.ui.Scrollable;
import com.duokan.dkwebview.core.WebView;
import com.duokan.dkwebview.core.WebpageView;
import com.duokan.reader.BaseEnv;
import com.yuewen.g72;
import com.yuewen.lp2;
import com.yuewen.mj;
import com.yuewen.og4;
import org.json.JSONException;

/* JADX INFO: loaded from: classes15.dex */
public class DkWebView extends WebView {
    public static final String C = "com.duokan.dkwebview.core.DkWebView";
    public static final int D = 0;
    public static final int E = 1;
    public int A;
    public d B;
    public final WebSettings w;
    public final g72.e x;
    public Scrollable.b y;
    public boolean z;

    public class a implements g72.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f3451a;

        public a(boolean z) {
            this.f3451a = z;
        }

        @Override // com.yuewen.g72.e
        public void V6(g72 g72Var) {
            if (this.f3451a) {
                if (g72Var.n()) {
                    DkWebView.this.w.setCacheMode(-1);
                } else {
                    DkWebView.this.w.setCacheMode(1);
                }
            }
        }
    }

    public class b implements DownloadListener {
        public b() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            WebpageView.b bVar;
            Uri uri = Uri.parse(str);
            if (uri.getLastPathSegment() == null || !uri.getLastPathSegment().contains(".apk") || (bVar = DkWebView.this.q) == null) {
                lp2.M(DkWebView.this.getContext(), str);
            } else {
                bVar.La(str);
            }
        }
    }

    public class c implements Scrollable.b {
        public c() {
        }

        @Override // com.duokan.core.ui.Scrollable.b
        public void a(Scrollable scrollable, Scrollable.ScrollState scrollState, Scrollable.ScrollState scrollState2) {
            if (DkWebView.this.y != null) {
                DkWebView.this.y.a(scrollable, scrollState, scrollState2);
            }
        }

        @Override // com.duokan.core.ui.Scrollable.b
        public void b(Scrollable scrollable, boolean z) {
            if (DkWebView.this.y != null) {
                DkWebView.this.y.b(scrollable, z);
            }
        }
    }

    public interface d {
        void a();
    }

    @SuppressLint({"NewApi"})
    public DkWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = null;
        this.z = false;
        this.A = 0;
        boolean z = mj.a() != null && mj.a().L();
        this.x = new a(z);
        boolean z2 = BaseEnv.get() != null && BaseEnv.get().F();
        if (z2) {
            setLoadingTimout(0L);
        }
        WebSettings settings = getSettings();
        this.w = settings;
        og4.a(settings);
        super.setDownloadListener(new b());
        setLayerType(0, null);
        if (z2 || !z) {
            WebpageView.setWebContentsDebuggingEnabled(true);
        }
        super.setOnScrollListener(new c());
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public WebBackForwardList G() {
        if (this.z) {
            return null;
        }
        return super.G();
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public void N(String str) throws JSONException {
        super.N(str);
        d dVar = this.B;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public void addJavascriptInterface(Object obj, String str) {
        if (this.z) {
            return;
        }
        super.addJavascriptInterface(obj, str);
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public boolean canGoBack() {
        if (this.z) {
            return false;
        }
        return super.canGoBack();
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public boolean canGoBackOrForward(int i) {
        if (this.z) {
            return false;
        }
        return super.canGoBackOrForward(i);
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public boolean canGoForward() {
        if (this.z) {
            return false;
        }
        return super.canGoForward();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        if (this.z) {
            return 0;
        }
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        if (this.z) {
            return 0;
        }
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.z) {
            return;
        }
        super.computeScroll();
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        if (this.z) {
            return 0;
        }
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        if (this.z) {
            return 0;
        }
        return super.computeVerticalScrollOffset();
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        if (this.z) {
            return 0;
        }
        return super.computeVerticalScrollRange();
    }

    @Override // com.yuewen.tl1
    public boolean d(String str) {
        if (this.z) {
            return false;
        }
        loadUrl(str);
        return true;
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public void destroy() {
        if (this.z) {
            return;
        }
        this.z = true;
        removeView(this.f3457a);
        this.f3457a.setWebChromeClient(null);
        this.f3457a.stopLoading();
        this.f3457a.getSettings().setJavaScriptEnabled(false);
        this.f3457a.clearHistory();
        this.f3457a.removeAllViews();
        super.destroy();
    }

    @Override // com.duokan.dkwebview.core.WebView, com.duokan.dkwebview.core.WebpageView
    /* JADX INFO: renamed from: e0 */
    public WebView.b L(WebpageView.e eVar) {
        WebView.b bVar = new WebView.b(eVar);
        bVar.setVerticalOverScrollMode(Scrollable.OverScrollMode.NEVER);
        return bVar;
    }

    @Override // android.view.View
    @TargetApi(16)
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.z) {
            return null;
        }
        return super.getAccessibilityNodeProvider();
    }

    public Scrollable.b getOnScrollerListener() {
        return this.y;
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public void goBack() {
        if (this.z) {
            return;
        }
        super.goBack();
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public void goBackOrForward(int i) {
        if (this.z) {
            return;
        }
        super.goBackOrForward(i);
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public void goForward() {
        if (this.z) {
            return;
        }
        super.goForward();
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public boolean isPrivateBrowsingEnabled() {
        if (this.z) {
            return false;
        }
        return super.isPrivateBrowsingEnabled();
    }

    @Override // com.duokan.dkwebview.core.WebpageView, com.yuewen.tl1
    public void loadUrl(String str) {
        if (this.z) {
            return;
        }
        super.loadUrl(str);
    }

    @Override // com.duokan.dkwebview.core.WebpageView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        g72.h().e(this.x);
        super.onAttachedToWindow();
    }

    @Override // com.duokan.dkwebview.core.WebpageView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        g72.h().s(this.x);
        super.onDetachedFromWindow();
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public boolean pageDown(boolean z) {
        if (this.z) {
            return false;
        }
        return super.pageDown(z);
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public boolean pageUp(boolean z) {
        if (this.z) {
            return false;
        }
        return super.pageUp(z);
    }

    @Override // android.view.View
    @TargetApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (this.z) {
            return false;
        }
        return super.performAccessibilityAction(i, bundle);
    }

    @Override // android.view.View
    public final boolean performLongClick() {
        return true;
    }

    public boolean q0() {
        return this.z;
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public void reload() {
        if (this.z) {
            return;
        }
        super.reload();
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public void removeJavascriptInterface(String str) {
        if (this.z) {
            return;
        }
        super.removeJavascriptInterface(str);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        if (this.z) {
            return false;
        }
        return super.requestChildRectangleOnScreen(view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.z) {
            return false;
        }
        return super.requestFocus(i, rect);
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public final void setDownloadListener(DownloadListener downloadListener) {
    }

    @Override // android.view.View
    public void setLayerType(int i, Paint paint) {
        if (this.z) {
            return;
        }
        super.setLayerType(i, paint);
    }

    public void setOnPageFinishedCallback(d dVar) {
        this.B = dVar;
    }

    @Override // com.duokan.dkwebview.core.WebpageView, com.duokan.core.ui.Scrollable
    public void setOnScrollListener(Scrollable.b bVar) {
        this.y = bVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        if (this.z) {
            return;
        }
        super.setOverScrollMode(i);
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        if (this.z) {
            return;
        }
        super.setScrollBarStyle(i);
    }

    public void setWebViewType(int i) {
        this.A = i;
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public void setWebpageChromeClient(com.duokan.dkwebview.core.b bVar) {
        if (this.z) {
            return;
        }
        super.setWebpageChromeClient(bVar);
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public void setWebpageClient(com.duokan.dkwebview.core.c cVar) {
        if (this.z) {
            return;
        }
        super.setWebpageClient(cVar);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (this.z) {
            return false;
        }
        return super.shouldDelayChildPressedState();
    }

    @Override // com.duokan.dkwebview.core.WebpageView
    public void stopLoading() {
        if (this.z) {
            return;
        }
        super.stopLoading();
    }
}
