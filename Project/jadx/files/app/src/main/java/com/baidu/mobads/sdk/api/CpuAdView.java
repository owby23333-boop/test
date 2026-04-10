package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.co;
import com.baidu.mobads.sdk.internal.cq;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class CpuAdView extends RelativeLayout {
    private cq mAdProd;

    public interface CpuAdViewInternalStatusListener {
        void loadDataError(String str);

        void onAdClick();

        void onAdImpression(String str);

        void onContentClick();

        void onContentImpression(String str);

        void onExitLp();

        void onLpContentStatus(Map<String, Object> map);
    }

    public CpuAdView(Context context) {
        super(context);
    }

    protected boolean canGoBack() {
        try {
            WebView webView = (WebView) this.mAdProd.v();
            if (webView != null) {
                return webView.canGoBack();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    protected void goBack() {
        try {
            WebView webView = (WebView) this.mAdProd.v();
            if (webView != null) {
                webView.goBack();
            }
        } catch (Throwable unused) {
        }
    }

    public void onDestroy() {
        View viewV = this.mAdProd.v();
        if (viewV instanceof WebView) {
            ((WebView) viewV).destroy();
        }
    }

    public boolean onKeyBackDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !canGoBack()) {
            return false;
        }
        goBack();
        return true;
    }

    public void onPause() {
        View viewV = this.mAdProd.v();
        if (viewV instanceof WebView) {
            ((WebView) viewV).onPause();
        }
    }

    public void onResume() {
        View viewV = this.mAdProd.v();
        if (viewV instanceof WebView) {
            ((WebView) viewV).onResume();
        }
    }

    public void requestData() {
        cq cqVar = this.mAdProd;
        if (cqVar != null) {
            cqVar.a();
        }
    }

    public CpuAdView(Context context, String str, int i2, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        co coVar = new co(context);
        this.mAdProd = new cq(context, coVar, str, i2, cPUWebAdRequestParam);
        addView(coVar, new ViewGroup.LayoutParams(-1, -1));
    }

    public CpuAdView(Context context, String str, int i2, CPUWebAdRequestParam cPUWebAdRequestParam, CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        super(context);
        co coVar = new co(context);
        this.mAdProd = new cq(context, coVar, str, i2, cPUWebAdRequestParam);
        this.mAdProd.a(cpuAdViewInternalStatusListener);
        addView(coVar, new ViewGroup.LayoutParams(-1, -1));
    }
}
