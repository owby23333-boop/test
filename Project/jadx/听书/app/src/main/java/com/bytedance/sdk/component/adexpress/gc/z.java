package com.bytedance.sdk.component.adexpress.gc;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.g.e;
import com.bytedance.sdk.component.adexpress.g.gz;
import com.bytedance.sdk.component.adexpress.g.i;
import com.bytedance.sdk.component.adexpress.g.kb;
import com.bytedance.sdk.component.adexpress.g.v;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements com.bytedance.sdk.component.adexpress.g.a<SSWebView>, kb, com.bytedance.sdk.component.adexpress.theme.z, com.bytedance.sdk.component.adexpress.z {
    protected SSWebView dl;
    private String e;
    private volatile e fo;
    protected boolean g;
    private String gz;
    private boolean i;
    private gz kb;
    private Context m;
    private boolean uy;
    private int v;
    private i wp;
    protected JSONObject z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f585a = 8;
    protected AtomicBoolean gc = new AtomicBoolean(false);
    private boolean pf = false;

    @Override // com.bytedance.sdk.component.adexpress.g.a
    public int dl() {
        return 0;
    }

    protected void fo() {
    }

    public abstract void g(int i);

    public abstract void m();

    protected void uy() {
    }

    protected void z(boolean z, int i) {
    }

    public z(Context context, i iVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.uy = false;
        this.m = context;
        this.wp = iVar;
        this.e = iVar.m();
        themeStatusBroadcastReceiver.z(this);
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            wp();
            return;
        }
        SSWebView sSWebViewI = i();
        this.dl = sSWebViewI;
        if (sSWebViewI == null) {
            if (com.bytedance.sdk.component.adexpress.a.getContext() != null) {
                this.dl = new SSWebView(com.bytedance.sdk.component.adexpress.a.getContext());
                return;
            }
            return;
        }
        this.uy = true;
    }

    private void wp() {
        if (this.m == null && com.bytedance.sdk.component.adexpress.a.getContext() != null) {
            this.m = com.bytedance.sdk.component.adexpress.a.getContext();
        }
        if (this.m != null) {
            SSWebView sSWebViewI = i();
            this.dl = sSWebViewI;
            if (sSWebViewI == null) {
                this.dl = new SSWebView(new MutableContextWrapper(this.m.getApplicationContext()));
            } else {
                this.uy = true;
            }
        }
    }

    private SSWebView i() {
        if (this.wp.sy()) {
            return gc.z().z(this.m, this.e);
        }
        return gc.z().g(this.m, this.e);
    }

    private void v() {
        if (this.wp.sy()) {
            gc.z().g(this.dl);
        } else {
            gc.z().dl(this.dl);
        }
    }

    public void z(String str) {
        this.gz = str;
    }

    public SSWebView z() {
        return this.dl;
    }

    public void z(gz gzVar) {
        this.kb = gzVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.a
    public void z(e eVar) {
        this.fo = eVar;
        if (z() == null || z().getWebView() == null) {
            this.fo.z(102, "SSWebview null is " + (z() == null) + " or Webview is null");
            return;
        }
        if (TextUtils.isEmpty(this.gz)) {
            this.fo.z(102, "url is empty");
            return;
        }
        if (!this.wp.sy()) {
            if (!this.pf && !com.bytedance.sdk.component.adexpress.z.g.g.z(this.z)) {
                this.fo.z(103, "data null is " + (this.z == null));
                return;
            } else if (this.pf && !com.bytedance.sdk.component.adexpress.z.g.g.dl(this.z)) {
                this.fo.z(103, "choice ad data null is " + (this.z == null));
                return;
            }
        } else if (dl() == 9 && !com.bytedance.sdk.component.adexpress.z.g.g.g(this.z)) {
            this.fo.z(103, "data null is " + (this.z == null));
            return;
        }
        this.wp.e().g(this.uy);
        if (this.uy) {
            try {
                this.dl.clearView();
                this.wp.e().e();
                com.bytedance.sdk.component.utils.kb.z(this.dl.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                return;
            } catch (Exception e) {
                gc.z().gc(this.dl);
                this.fo.z(102, "load exception is " + e.getMessage());
                return;
            }
        }
        SSWebView sSWebViewZ = z();
        sSWebViewZ.clearView();
        this.wp.e().e();
        sSWebViewZ.loadUrl(this.gz);
    }

    @Override // com.bytedance.sdk.component.adexpress.g.a
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public SSWebView e() {
        return z();
    }

    public void a() {
        if (this.gc.get()) {
            return;
        }
        this.gc.set(true);
        m();
        if (this.dl.getParent() != null) {
            ((ViewGroup) this.dl.getParent()).removeView(this.dl);
        }
        if (this.g) {
            v();
        } else {
            gc.z().gc(this.dl);
        }
    }

    public void gc() {
        if (z() == null) {
            return;
        }
        try {
            z().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    public void z(boolean z) {
        this.i = z;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.kb
    public void z(final v vVar) {
        if (vVar == null) {
            if (this.fo != null) {
                this.fo.z(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean zDl = vVar.dl();
        final float fA = (float) vVar.a();
        final float fGc = (float) vVar.gc();
        if (dl() == 0 && (fA <= 0.0f || fGc <= 0.0f)) {
            if (this.fo != null) {
                this.fo.z(105, "width is " + fA + "height is " + fGc);
            }
        } else {
            this.g = zDl;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                z(vVar, fA, fGc);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.gc.z.1
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.z(vVar, fA, fGc);
                    }
                });
            }
        }
    }

    protected void z(v vVar, float f, float f2) {
        z(this.g, vVar.kb());
        boolean z = this.g;
        if (z && !this.i) {
            z(f, f2);
            g(this.f585a);
            if (this.fo != null) {
                this.fo.z(z(), vVar);
                return;
            }
            return;
        }
        if (!z) {
            gc.z().gc(this.dl);
        }
        z(vVar.kb(), vVar.uy());
    }

    @Override // com.bytedance.sdk.component.adexpress.g.kb
    public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
        gz gzVar = this.kb;
        if (gzVar != null) {
            gzVar.z(view, i, dlVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.g.kb
    public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar, int i2) {
        gz gzVar = this.kb;
        if (gzVar != null) {
            gzVar.z(view, i, dlVar, i2);
        }
    }

    protected void z(float f, float f2) {
        this.wp.e().gz();
        if (com.bytedance.sdk.component.adexpress.a.z() && dl() == 9) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) z().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            z().setLayoutParams(layoutParams);
            return;
        }
        int iZ = (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.m, f);
        int iZ2 = (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.m, f2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) z().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(iZ, iZ2);
        }
        layoutParams2.width = iZ;
        layoutParams2.height = iZ2;
        z().setLayoutParams(layoutParams2);
    }

    private void z(int i, String str) {
        if (this.fo != null) {
            this.fo.z(i, str);
        }
    }

    private int g(Activity activity) {
        return activity.hashCode();
    }

    public void gz() {
        fo();
        Activity activityZ = com.bytedance.sdk.component.utils.g.z(this.dl);
        if (activityZ != null) {
            this.v = g(activityZ);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.z
    public void z(Activity activity) {
        if (this.v == 0 || activity == null || activity.hashCode() != this.v) {
            return;
        }
        a();
        uy();
    }

    public i kb() {
        return this.wp;
    }
}
