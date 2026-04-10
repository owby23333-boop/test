package com.bytedance.sdk.component.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.iq;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.widget.web.BizWebView;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SSWebView extends BizWebView {
    private JSONObject e;
    private float fo;
    private int fv;
    private com.bytedance.sdk.component.widget.g.z gc;
    private boolean gz;
    private dl h;
    private JSONObject hh;
    private long i;
    private AtomicBoolean io;
    private AtomicBoolean iq;
    private int js;
    private long kb;
    private JSONObject l;
    private float ls;
    private String m;
    private float p;
    private float pf;
    private iq q;
    private JSONObject sy;
    private g tb;
    private AtomicInteger uf;
    private float uy;
    private boolean v;
    private long wp;
    private AtomicBoolean zw;

    /* JADX INFO: loaded from: classes2.dex */
    public interface dl {
        void z(boolean z);
    }

    /* JADX INFO: loaded from: classes2.dex */
    public interface g {
        void z(int i);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public com.bytedance.sdk.component.widget.g.z getMaterialMeta() {
        return this.gc;
    }

    public void setMaterialMeta(com.bytedance.sdk.component.widget.g.z zVar) {
        this.gc = zVar;
    }

    @Override // android.view.View
    public String getTag() {
        return this.m;
    }

    public void setTag(String str) {
        this.m = str;
    }

    public void setLandingPage(boolean z2) {
        this.gz = z2;
    }

    public void setTouchStateListener(dl dlVar) {
        this.h = dlVar;
    }

    public SSWebView(Context context) {
        super(context);
        this.fo = 0.0f;
        this.uy = 0.0f;
        this.kb = 0L;
        this.wp = 0L;
        this.i = 0L;
        this.v = false;
        this.pf = 20.0f;
        this.p = 50.0f;
        this.iq = new AtomicBoolean();
        this.zw = new AtomicBoolean();
        this.io = new AtomicBoolean(true);
        this.uf = new AtomicInteger();
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview
    public void G_() {
        m();
        super.G_();
    }

    private void m() {
        this.q = null;
        this.tb = null;
        setTouchStateListener(null);
        I_();
        this.gc = null;
        this.e = null;
        this.gz = false;
    }

    public boolean H_() {
        iq iqVar = this.q;
        if (iqVar == null) {
            return false;
        }
        return iqVar.z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.i.dl
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient instanceof dl) {
            setTouchStateListener((dl) webViewClient);
        } else {
            setTouchStateListener(null);
        }
        if (webViewClient == 0) {
            webViewClient = new z();
        }
        super.setWebViewClient(webViewClient);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentZ;
        try {
            z(motionEvent);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.v && (viewParentZ = z((View) this)) != null) {
                viewParentZ.requestDisallowInterceptTouchEvent(true);
            }
            return zOnInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public void setIsPreventTouchEvent(boolean z2) {
        this.v = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ViewParent z(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (g(view2) || dl(view2)) ? parent : z(view2);
    }

    private static boolean g(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass != null) {
                if (clsLoadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass2 != null) {
                return clsLoadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable th2) {
            wp.z(th2);
            return false;
        }
    }

    private boolean dl(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass != null) {
                if (clsLoadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass2 != null) {
                return clsLoadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable th2) {
            wp.z(th2);
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.i.dl
    public void onPause() {
        super.onPause();
        dl dlVar = this.h;
        if (dlVar != null) {
            dlVar.z(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        dl dlVar = this.h;
        if (dlVar != null) {
            dlVar.z(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.i.dl
    public void destroy() {
        super.destroy();
        m();
    }

    public void z(int i, boolean z2) {
        this.io.set(z2);
        this.uf.set(i);
        this.zw.set(true);
        if (this.iq.get()) {
            g(i, z2);
        }
    }

    private void g(int i, boolean z2) {
        iq iqVar = this.q;
        if (iqVar == null) {
            this.q = new iq(getContext(), i, z2);
        } else {
            iqVar.z(z2);
        }
        this.q.z(this.pf);
        this.q.dl(this.ls);
        this.q.g(this.p);
        this.q.z(this.sy);
        this.q.dl(this.hh);
        this.q.g(this.l);
        this.q.gc(this.fv);
        this.q.m(this.js);
        this.q.z(new iq.z() { // from class: com.bytedance.sdk.component.widget.SSWebView.1
            @Override // com.bytedance.sdk.component.utils.iq.z
            public void z(int i2) {
                if (i2 == 1) {
                    SSWebView.this.z(1);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    SSWebView.this.z(2);
                }
            }
        });
        iq iqVar2 = this.q;
        com.bytedance.sdk.component.widget.g.z zVar = this.gc;
        iqVar2.dl(zVar != null ? zVar.z() : 0);
    }

    public void z(int i) {
        g gVar = this.tb;
        if (gVar != null) {
            gVar.z(i);
        }
    }

    public void I_() {
        this.zw.set(false);
        iq iqVar = this.q;
        if (iqVar != null) {
            com.bytedance.sdk.component.widget.g.z zVar = this.gc;
            iqVar.a(zVar != null ? zVar.z() : 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.iq.set(true);
        if (this.zw.get()) {
            g(this.uf.get(), this.io.get());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.iq.set(false);
        iq iqVar = this.q;
        if (iqVar != null) {
            com.bytedance.sdk.component.widget.g.z zVar = this.gc;
            iqVar.g(zVar != null ? zVar.z() : 0);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        iq iqVar = this.q;
        if (iqVar != null) {
            if (z2) {
                com.bytedance.sdk.component.widget.g.z zVar = this.gc;
                iqVar.z(zVar != null ? zVar.z() : 0);
            } else {
                com.bytedance.sdk.component.widget.g.z zVar2 = this.gc;
                iqVar.g(zVar2 != null ? zVar2.z() : 0);
            }
        }
    }

    private void z(MotionEvent motionEvent) {
        if (!this.gz || this.gc == null) {
            return;
        }
        if ((this.m == null && this.e == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.fo = motionEvent.getRawX();
                this.uy = motionEvent.getRawY();
                this.kb = System.currentTimeMillis();
                this.e = new JSONObject();
                if (this.g != null) {
                    this.g.setTag(2064056319, Long.valueOf(this.kb));
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.e.put("start_x", String.valueOf(this.fo));
                this.e.put("start_y", String.valueOf(this.uy));
                this.e.put("offset_x", String.valueOf(motionEvent.getRawX() - this.fo));
                this.e.put("offset_y", String.valueOf(motionEvent.getRawY() - this.uy));
                this.e.put("url", String.valueOf(getUrl()));
                this.e.put("tag", "");
                this.wp = System.currentTimeMillis();
                if (this.g != null) {
                    this.g.setTag(2064056318, Long.valueOf(this.wp));
                }
                this.e.put("down_time", this.kb);
                this.e.put("up_time", this.wp);
                if (com.bytedance.sdk.component.widget.z.z.z().g() != null) {
                    long j = this.i;
                    long j2 = this.kb;
                    if (j != j2) {
                        this.i = j2;
                        com.bytedance.sdk.component.widget.z.z.z();
                    }
                }
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public void setShakeValue(float f) {
        this.pf = f;
    }

    public void setDeepShakeValue(float f) {
        this.ls = f;
    }

    public void setWriggleValue(float f) {
        this.p = f;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.sy = jSONObject;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.hh = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.l = jSONObject;
    }

    public void setCalculationMethod(int i) {
        this.fv = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.js = i;
    }

    public void setOnShakeListener(g gVar) {
        this.tb = gVar;
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class z extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (webView == null) {
                return true;
            }
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.destroy();
            return true;
        }
    }
}
