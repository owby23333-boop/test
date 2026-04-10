package com.anythink.expressad.splash.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.u;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.splash.js.SplashJSBridgeImpl;
import com.anythink.expressad.splash.js.SplashJsUtils;
import com.umeng.message.common.inter.ITagManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ATSplashView extends RelativeLayout {
    protected static final String a = "webviewshow";
    protected static final String b = "updateCountdown";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f11418c = "ATSplashView";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ATSplashWebview f11420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ViewGroup f11421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f11422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f11423h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11424i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11425j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11426k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ViewGroup f11427l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f11428m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View f11429n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f11430o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f11431p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private RelativeLayout.LayoutParams f11432q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private SplashJSBridgeImpl f11433r;

    public ATSplashView(Context context) {
        this(context, null);
    }

    private void b() {
        setBackgroundColor(0);
        this.f11419d = getResources().getConfiguration().orientation;
    }

    private void c() {
        View view;
        View view2;
        View view3;
        if (this.f11423h != null) {
            if (this.f11421f == null) {
                this.f11421f = new RelativeLayout(getContext());
                this.f11421f.setId(2147482647);
            }
            if (this.f11419d == 2) {
                this.f11424i = t.f(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(0, this.f11421f.getId());
                if (!this.f11430o || (view2 = this.f11429n) == null) {
                    ATSplashWebview aTSplashWebview = this.f11420e;
                    if (aTSplashWebview != null && aTSplashWebview.getParent() == null) {
                        addView(this.f11420e, layoutParams);
                    }
                    d();
                } else {
                    if (view2.getParent() != null) {
                        u.a(this.f11429n);
                    }
                    addView(this.f11429n, layoutParams);
                }
                ViewGroup viewGroup = this.f11421f;
                if (viewGroup != null && viewGroup.getParent() == null) {
                    int i2 = this.f11432q.width;
                    int i3 = this.f11424i;
                    if (i2 > i3 / 4) {
                        i2 = i3 / 4;
                    }
                    this.f11421f.addView(this.f11423h, i2, -1);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, -1);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(13);
                    addView(this.f11421f, layoutParams2);
                }
            } else {
                this.f11424i = t.e(getContext());
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(2, this.f11421f.getId());
                if (!this.f11430o || (view = this.f11429n) == null) {
                    ATSplashWebview aTSplashWebview2 = this.f11420e;
                    if (aTSplashWebview2 != null && aTSplashWebview2.getParent() == null) {
                        addView(this.f11420e, layoutParams3);
                    }
                    d();
                } else {
                    if (view.getParent() != null) {
                        u.a(this.f11429n);
                    }
                    addView(this.f11429n, layoutParams3);
                }
                ViewGroup viewGroup2 = this.f11421f;
                if (viewGroup2 != null && viewGroup2.getParent() == null) {
                    int i4 = this.f11432q.height;
                    int i5 = this.f11424i;
                    if (i4 > i5 / 4) {
                        i4 = i5 / 4;
                    }
                    this.f11421f.addView(this.f11423h, -1, i4);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i4);
                    layoutParams4.addRule(12);
                    addView(this.f11421f, layoutParams4);
                }
            }
        } else if (!this.f11430o || (view3 = this.f11429n) == null) {
            ATSplashWebview aTSplashWebview3 = this.f11420e;
            if (aTSplashWebview3 != null && aTSplashWebview3.getParent() == null) {
                addView(this.f11420e, new ViewGroup.LayoutParams(-1, -1));
            }
            d();
        } else {
            if (view3.getParent() != null) {
                u.a(this.f11429n);
            }
            addView(this.f11429n, new ViewGroup.LayoutParams(-1, -1));
        }
        View view4 = this.f11422g;
        if (view4 != null) {
            if (view4.getParent() != null) {
                bringChildToFront(this.f11422g);
                return;
            }
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(t.b(getContext(), 100.0f), t.b(getContext(), 30.0f));
            layoutParams5.addRule(10);
            layoutParams5.addRule(11);
            layoutParams5.rightMargin = t.b(getContext(), 10.0f);
            layoutParams5.topMargin = t.b(getContext(), 10.0f);
            addView(this.f11422g, layoutParams5);
        }
    }

    private void d() {
        ATSplashWebview aTSplashWebview = this.f11420e;
        if (aTSplashWebview != null) {
            aTSplashWebview.setObject(this.f11433r);
            this.f11420e.post(new Runnable() { // from class: com.anythink.expressad.splash.view.ATSplashView.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        o.a(ATSplashView.f11418c, ATSplashView.a);
                        String string = "";
                        try {
                            int[] iArr = new int[2];
                            ATSplashView.this.f11420e.getLocationOnScreen(iArr);
                            o.d(ATSplashView.f11418c, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("startX", t.a(n.a().g(), (float) iArr[0]));
                            jSONObject.put("startY", t.a(n.a().g(), (float) iArr[1]));
                            string = jSONObject.toString();
                        } catch (Throwable th) {
                            o.b(ATSplashView.f11418c, th.getMessage(), th);
                        }
                        int[] iArr2 = new int[2];
                        ATSplashView.this.f11420e.getLocationInWindow(iArr2);
                        ATSplashView.transInfoForMraid(ATSplashView.this.f11420e, iArr2[0], iArr2[1], ATSplashView.this.f11420e.getWidth(), ATSplashView.this.f11420e.getHeight());
                        String strEncodeToString = Base64.encodeToString(string.toString().getBytes(), 2);
                        j.a();
                        j.a((WebView) ATSplashView.this.f11420e, ATSplashView.a, strEncodeToString);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public static void transInfoForMraid(WebView webView, int i2, int i3, int i4, int i5) {
        o.d(f11418c, "transInfoForMraid");
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
            map.put(CallMraidJS.a, "Interstitial");
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
            o.b(f11418c, "transInfoForMraid", th);
        }
    }

    public void changeCloseBtnState(int i2) {
        View view = this.f11422g;
        if (view != null) {
            if (i2 == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.f11428m = false;
        this.f11426k = false;
        this.f11425j = false;
    }

    public void destroy() {
        ATSplashWebview aTSplashWebview = this.f11420e;
        if (aTSplashWebview == null || aTSplashWebview.isDestroyed()) {
            return;
        }
        this.f11420e.release();
        SplashJsUtils.sendEventToH5(this.f11420e, "onSystemDestory", "");
    }

    public View getCloseView() {
        return this.f11422g;
    }

    public ViewGroup getDevContainer() {
        return this.f11427l;
    }

    public View getIconVg() {
        return this.f11423h;
    }

    public SplashJSBridgeImpl getSplashJSBridgeImpl() {
        return this.f11433r;
    }

    public ATSplashWebview getSplashWebview() {
        return this.f11420e;
    }

    public boolean isAttach() {
        return this.f11431p;
    }

    public boolean isDynamicView() {
        return this.f11430o;
    }

    public boolean isH5Ready() {
        return this.f11425j;
    }

    public boolean isImageReady() {
        return this.f11428m;
    }

    public boolean isVideoReady() {
        return this.f11426k;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11431p = true;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    public void onPause() {
        View view = this.f11429n;
        if (view == null || !(view instanceof ATSplashNativeView)) {
            return;
        }
        ((ATSplashNativeView) view).setIsPause(true);
    }

    public void onResume() {
        View view = this.f11429n;
        if (view == null || !(view instanceof ATSplashNativeView)) {
            return;
        }
        ((ATSplashNativeView) view).setIsPause(false);
    }

    public void resetLoadState() {
        this.f11426k = false;
        this.f11425j = false;
    }

    public void setCloseView(View view) {
        this.f11422g = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setDevContainer(ViewGroup viewGroup) {
        this.f11427l = viewGroup;
    }

    public void setDynamicView(boolean z2) {
        this.f11430o = z2;
    }

    public void setH5Ready(boolean z2) {
        this.f11425j = z2;
    }

    public void setIconVg(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f11423h = view;
        this.f11432q = layoutParams;
    }

    public void setImageReady(boolean z2) {
        this.f11428m = z2;
    }

    public void setNotchPadding(int i2, int i3, int i4, int i5) {
        View view = this.f11429n;
        if (view == null || !(view instanceof ATSplashNativeView)) {
            return;
        }
        ((ATSplashNativeView) view).setNotchPadding(i2, i3, i4, i5);
    }

    public void setSplashJSBridgeImpl(SplashJSBridgeImpl splashJSBridgeImpl) {
        this.f11433r = splashJSBridgeImpl;
        ATSplashWebview aTSplashWebview = this.f11420e;
        if (aTSplashWebview != null) {
            aTSplashWebview.setObject(this.f11433r);
        }
    }

    public void setSplashNativeView(View view) {
        if (view != null) {
            this.f11429n = view;
        }
    }

    public void setSplashWebview(ATSplashWebview aTSplashWebview) {
        this.f11420e = aTSplashWebview;
        SplashJSBridgeImpl splashJSBridgeImpl = this.f11433r;
        if (splashJSBridgeImpl != null) {
            aTSplashWebview.setObject(splashJSBridgeImpl);
        }
    }

    public void setVideoReady(boolean z2) {
        this.f11426k = z2;
    }

    public void show() {
        View view;
        View view2;
        View view3;
        ViewGroup viewGroup;
        if (this.f11433r != null && (viewGroup = this.f11427l) != null && (viewGroup.getContext() instanceof Activity)) {
            this.f11433r.updateContext(this.f11427l.getContext());
        }
        if (this.f11423h != null) {
            if (this.f11421f == null) {
                this.f11421f = new RelativeLayout(getContext());
                this.f11421f.setId(2147482647);
            }
            if (this.f11419d == 2) {
                this.f11424i = t.f(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(0, this.f11421f.getId());
                if (!this.f11430o || (view2 = this.f11429n) == null) {
                    ATSplashWebview aTSplashWebview = this.f11420e;
                    if (aTSplashWebview != null && aTSplashWebview.getParent() == null) {
                        addView(this.f11420e, layoutParams);
                    }
                    d();
                } else {
                    if (view2.getParent() != null) {
                        u.a(this.f11429n);
                    }
                    addView(this.f11429n, layoutParams);
                }
                ViewGroup viewGroup2 = this.f11421f;
                if (viewGroup2 != null && viewGroup2.getParent() == null) {
                    int i2 = this.f11432q.width;
                    int i3 = this.f11424i;
                    if (i2 > i3 / 4) {
                        i2 = i3 / 4;
                    }
                    this.f11421f.addView(this.f11423h, i2, -1);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, -1);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(13);
                    addView(this.f11421f, layoutParams2);
                }
            } else {
                this.f11424i = t.e(getContext());
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(2, this.f11421f.getId());
                if (!this.f11430o || (view = this.f11429n) == null) {
                    ATSplashWebview aTSplashWebview2 = this.f11420e;
                    if (aTSplashWebview2 != null && aTSplashWebview2.getParent() == null) {
                        addView(this.f11420e, layoutParams3);
                    }
                    d();
                } else {
                    if (view.getParent() != null) {
                        u.a(this.f11429n);
                    }
                    addView(this.f11429n, layoutParams3);
                }
                ViewGroup viewGroup3 = this.f11421f;
                if (viewGroup3 != null && viewGroup3.getParent() == null) {
                    int i4 = this.f11432q.height;
                    int i5 = this.f11424i;
                    if (i4 > i5 / 4) {
                        i4 = i5 / 4;
                    }
                    this.f11421f.addView(this.f11423h, -1, i4);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i4);
                    layoutParams4.addRule(12);
                    addView(this.f11421f, layoutParams4);
                }
            }
        } else if (!this.f11430o || (view3 = this.f11429n) == null) {
            ATSplashWebview aTSplashWebview3 = this.f11420e;
            if (aTSplashWebview3 != null && aTSplashWebview3.getParent() == null) {
                addView(this.f11420e, new ViewGroup.LayoutParams(-1, -1));
            }
            d();
        } else {
            if (view3.getParent() != null) {
                u.a(this.f11429n);
            }
            addView(this.f11429n, new ViewGroup.LayoutParams(-1, -1));
        }
        View view4 = this.f11422g;
        if (view4 != null) {
            if (view4.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(t.b(getContext(), 100.0f), t.b(getContext(), 30.0f));
                layoutParams5.addRule(10);
                layoutParams5.addRule(11);
                layoutParams5.rightMargin = t.b(getContext(), 10.0f);
                layoutParams5.topMargin = t.b(getContext(), 10.0f);
                addView(this.f11422g, layoutParams5);
            } else {
                bringChildToFront(this.f11422g);
            }
        }
        clearResState();
    }

    public void updateCountdown(int i2) {
        View view;
        if (this.f11420e != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.anythink.expressad.d.a.b.dk, i2);
                String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
                j.a();
                j.a((WebView) this.f11420e, b, strEncodeToString);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (this.f11430o && (view = this.f11429n) != null && (view instanceof ATSplashNativeView)) {
                ((ATSplashNativeView) view).updateCountDown(i2);
            }
        }
    }

    public ATSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ATSplashView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
