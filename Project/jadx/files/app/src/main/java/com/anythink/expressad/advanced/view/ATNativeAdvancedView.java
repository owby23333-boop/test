package com.anythink.expressad.advanced.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.expressad.advanced.d.c;
import com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.umeng.message.common.inter.ITagManager;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ATNativeAdvancedView extends RelativeLayout {
    protected static final String a = "webviewshow";
    private static String b = "ATNativeAdvancedView";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ATNativeAdvancedWebview f8249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f8250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8253g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f8254h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private NativeAdvancedJSBridgeImpl f8255i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f8256j;

    /* JADX INFO: renamed from: com.anythink.expressad.advanced.view.ATNativeAdvancedView$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                o.a(ATNativeAdvancedView.b, ATNativeAdvancedView.a);
                String string = "";
                try {
                    int[] iArr = new int[2];
                    ATNativeAdvancedView.this.f8249c.getLocationOnScreen(iArr);
                    o.d(ATNativeAdvancedView.b, "coordinate:" + iArr[0] + "--" + iArr[1]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("startX", t.a(n.a().g(), (float) iArr[0]));
                    jSONObject.put("startY", t.a(n.a().g(), (float) iArr[1]));
                    string = jSONObject.toString();
                } catch (Throwable th) {
                    o.b(ATNativeAdvancedView.b, th.getMessage(), th);
                }
                String strEncodeToString = Base64.encodeToString(string.toString().getBytes(), 2);
                j.a();
                j.a((WebView) ATNativeAdvancedView.this.f8249c, ATNativeAdvancedView.a, strEncodeToString);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public ATNativeAdvancedView(Context context) {
        this(context, null);
    }

    private void b() {
        ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f8249c;
        if (aTNativeAdvancedWebview != null && aTNativeAdvancedWebview.getParent() == null) {
            addView(this.f8249c, new ViewGroup.LayoutParams(-1, -1));
        }
        int[] iArr = new int[2];
        this.f8249c.getLocationInWindow(iArr);
        ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.f8249c;
        transInfoForMraid(aTNativeAdvancedWebview2, iArr[0], iArr[1], aTNativeAdvancedWebview2.getWidth(), this.f8249c.getHeight());
        ATNativeAdvancedWebview aTNativeAdvancedWebview3 = this.f8249c;
        if (aTNativeAdvancedWebview3 != null) {
            aTNativeAdvancedWebview3.setObject(this.f8255i);
            this.f8249c.post(new AnonymousClass1());
        }
        View view = this.f8250d;
        if (view != null) {
            if (view.getParent() != null) {
                bringChildToFront(this.f8250d);
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.b(getContext(), 28.0f), t.b(getContext(), 16.0f));
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.rightMargin = t.b(getContext(), 2.0f);
            layoutParams.topMargin = t.b(getContext(), 2.0f);
            addView(this.f8250d, layoutParams);
        }
    }

    private void c() {
        int[] iArr = new int[2];
        this.f8249c.getLocationInWindow(iArr);
        ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f8249c;
        transInfoForMraid(aTNativeAdvancedWebview, iArr[0], iArr[1], aTNativeAdvancedWebview.getWidth(), this.f8249c.getHeight());
        ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.f8249c;
        if (aTNativeAdvancedWebview2 != null) {
            aTNativeAdvancedWebview2.setObject(this.f8255i);
            this.f8249c.post(new AnonymousClass1());
        }
    }

    public static void transInfoForMraid(WebView webView, int i2, int i3, int i4, int i5) {
        o.d(b, "transInfoForMraid");
        try {
            int i6 = n.a().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i6 == 2 ? "landscape" : i6 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", ITagManager.STATUS_TRUE);
            float fE = k.e(n.a().g());
            float f2 = k.f(n.a().g());
            HashMap mapG = k.g(n.a().g());
            int iIntValue = ((Integer) mapG.get("width")).intValue();
            int iIntValue2 = ((Integer) mapG.get("height")).intValue();
            HashMap map = new HashMap();
            map.put(CallMraidJS.a, CallMraidJS.f8288k);
            map.put(CallMraidJS.b, "default");
            map.put(CallMraidJS.f8280c, ITagManager.STATUS_TRUE);
            map.put(CallMraidJS.f8281d, jSONObject);
            float f3 = i2;
            float f4 = i3;
            float f5 = i4;
            float f6 = i5;
            CallMraidJS.getInstance().fireSetDefaultPosition(webView, f3, f4, f5, f6);
            CallMraidJS.getInstance().fireSetCurrentPosition(webView, f3, f4, f5, f6);
            CallMraidJS.getInstance().fireSetScreenSize(webView, fE, f2);
            CallMraidJS.getInstance().fireSetMaxSize(webView, iIntValue, iIntValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(webView, map);
            CallMraidJS.getInstance().fireReadyEvent(webView);
        } catch (Throwable th) {
            o.b(b, "transInfoForMraid", th);
        }
    }

    public void changeCloseBtnState(int i2) {
        View view = this.f8250d;
        if (view != null) {
            if (i2 == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.f8253g = false;
        this.f8252f = false;
        this.f8251e = false;
    }

    public void clearResStateAndRemoveClose() {
        clearResState();
        View view = this.f8250d;
        if (view == null || view.getParent() == null) {
            return;
        }
        removeView(this.f8250d);
    }

    public void destroy() {
        removeAllViews();
        ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f8249c;
        if (aTNativeAdvancedWebview != null && !aTNativeAdvancedWebview.isDestroyed()) {
            this.f8249c.release();
            NativeAdvancedJsUtils.sendEventToH5(this.f8249c, "onSystemDestory", "");
        }
        if (this.f8256j != null) {
            this.f8256j = null;
        }
    }

    public NativeAdvancedJSBridgeImpl getAdvancedNativeJSBridgeImpl() {
        return this.f8255i;
    }

    public ATNativeAdvancedWebview getAdvancedNativeWebview() {
        return this.f8249c;
    }

    public View getCloseView() {
        return this.f8250d;
    }

    public boolean isEndCardReady() {
        return this.f8253g;
    }

    public boolean isH5Ready() {
        return this.f8251e;
    }

    public boolean isVideoReady() {
        return this.f8252f;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void resetLoadState() {
        this.f8253g = false;
        this.f8252f = false;
        this.f8251e = false;
    }

    public void setAdvancedNativeJSBridgeImpl(NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl) {
        this.f8255i = nativeAdvancedJSBridgeImpl;
        ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f8249c;
        if (aTNativeAdvancedWebview != null) {
            aTNativeAdvancedWebview.setObject(this.f8255i);
        }
    }

    public void setAdvancedNativeWebview(ATNativeAdvancedWebview aTNativeAdvancedWebview) {
        this.f8249c = aTNativeAdvancedWebview;
        NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl = this.f8255i;
        if (nativeAdvancedJSBridgeImpl != null) {
            aTNativeAdvancedWebview.setObject(nativeAdvancedJSBridgeImpl);
        }
    }

    public void setCloseView(View view) {
        this.f8250d = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setEndCardReady(boolean z2) {
        this.f8253g = z2;
    }

    public void setH5Ready(boolean z2) {
        this.f8251e = z2;
    }

    public void setVideoReady(boolean z2) {
        this.f8252f = z2;
    }

    public void show() {
        ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f8249c;
        if (aTNativeAdvancedWebview != null && aTNativeAdvancedWebview.getParent() == null) {
            addView(this.f8249c, new ViewGroup.LayoutParams(-1, -1));
        }
        int[] iArr = new int[2];
        this.f8249c.getLocationInWindow(iArr);
        ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.f8249c;
        transInfoForMraid(aTNativeAdvancedWebview2, iArr[0], iArr[1], aTNativeAdvancedWebview2.getWidth(), this.f8249c.getHeight());
        ATNativeAdvancedWebview aTNativeAdvancedWebview3 = this.f8249c;
        if (aTNativeAdvancedWebview3 != null) {
            aTNativeAdvancedWebview3.setObject(this.f8255i);
            this.f8249c.post(new AnonymousClass1());
        }
        View view = this.f8250d;
        if (view != null) {
            if (view.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.b(getContext(), 28.0f), t.b(getContext(), 16.0f));
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = t.b(getContext(), 2.0f);
                layoutParams.topMargin = t.b(getContext(), 2.0f);
                addView(this.f8250d, layoutParams);
            } else {
                bringChildToFront(this.f8250d);
            }
        }
        clearResState();
    }

    public ATNativeAdvancedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ATNativeAdvancedView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8256j = context;
    }
}
