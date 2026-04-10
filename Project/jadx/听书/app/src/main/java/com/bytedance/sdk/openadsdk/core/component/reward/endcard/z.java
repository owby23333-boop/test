package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.Patterns;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.i.fo;
import com.bytedance.sdk.openadsdk.core.i.gc;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.js.m;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.q;
import com.bytedance.sdk.openadsdk.core.zw;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f952a;
    protected String dl;
    protected SSWebView e;
    protected fo fo;
    protected AtomicInteger fv;
    protected na g;
    protected mc gz;
    protected int js;
    protected com.bytedance.sdk.openadsdk.core.widget.z.a kb;
    protected int q;
    protected int tb;
    protected String uy;
    gc wp;
    protected TTBaseVideoActivity z;
    int gc = 0;
    int m = 0;
    int i = 0;
    String v = "";
    protected boolean pf = false;
    protected boolean ls = false;
    protected final AtomicBoolean p = new AtomicBoolean(true);
    protected AtomicBoolean iq = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.core.js.z zw = new com.bytedance.sdk.openadsdk.core.js.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.z.1
        @Override // com.bytedance.sdk.openadsdk.core.js.z
        public int z() {
            int measuredHeight = z.this.e != null ? z.this.e.getMeasuredHeight() : -1;
            wp.z("TTAndroidObject", "mWebView>>>>height=".concat(String.valueOf(measuredHeight)));
            return measuredHeight <= 0 ? oq.gc((Context) z.this.z) : measuredHeight;
        }

        @Override // com.bytedance.sdk.openadsdk.core.js.z
        public int g() {
            int measuredWidth = z.this.e != null ? z.this.e.getMeasuredWidth() : -1;
            wp.z("TTAndroidObject", "mWebView>>>>width=".concat(String.valueOf(measuredWidth)));
            return measuredWidth <= 0 ? oq.a((Context) z.this.z) : measuredWidth;
        }
    };
    protected m io = new m() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.z.2
        @Override // com.bytedance.sdk.openadsdk.core.js.m
        public void z() {
            SSWebView sSWebView = z.this.e;
            if (sSWebView == null) {
                return;
            }
            sSWebView.onPause();
        }

        @Override // com.bytedance.sdk.openadsdk.core.js.m
        public void g() {
            SSWebView sSWebView = z.this.e;
            if (sSWebView == null) {
                return;
            }
            sSWebView.pauseTimers();
        }
    };

    public void a(boolean z) {
    }

    public abstract String io();

    public void uf() {
    }

    public abstract void z(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.g.g gVar);

    public abstract void z(boolean z, Map<String, Object> map, View view);

    public z(TTBaseVideoActivity tTBaseVideoActivity, na naVar, String str, int i, int i2, boolean z) {
        this.z = tTBaseVideoActivity;
        this.g = naVar;
        this.dl = str;
        this.js = naVar.zr();
        if (zw.g().mz()) {
            float f = this.z.getResources().getDisplayMetrics().density;
            float f2 = Resources.getSystem().getDisplayMetrics().density;
            this.tb = oq.g(f2, oq.z(f, i));
            this.q = oq.g(f2, oq.z(f, i2));
        } else {
            this.tb = i;
            this.q = i2;
        }
        this.f952a = z;
    }

    protected void z() {
        SSWebView sSWebView = this.e;
        if (sSWebView != null) {
            sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.z.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (z.this.e == null || z.this.e.getViewTreeObserver() == null) {
                        return;
                    }
                    z.this.e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = z.this.e.getMeasuredWidth();
                    int measuredHeight = z.this.e.getMeasuredHeight();
                    if (z.this.e.getVisibility() == 0) {
                        z.this.g(measuredWidth, measuredHeight);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, int i2) {
        if (this.gz == null || this.z.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediaFormat.KEY_WIDTH, i);
            jSONObject.put(MediaFormat.KEY_HEIGHT, i2);
            this.gz.z("resize", jSONObject);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public void z(boolean z) {
        if (this.gz == null || this.z.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.gz.z("viewableChange", jSONObject);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public void g(boolean z) {
        if (this.gz == null || this.z.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.gz.z("volumeChange", jSONObject);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public void z(boolean z, boolean z2) {
        if (this.gz == null || this.z.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.gz.z("endcard_control_event", jSONObject);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public void dl(boolean z) {
        if (this.gz == null || this.z.isFinishing()) {
            return;
        }
        try {
            this.gz.m(z);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public void z(int i, int i2) {
        if (this.gz == null || this.z.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadStatus", i);
            jSONObject.put("downloadProcessRate", i2);
            this.gz.g("showDownloadStatus", jSONObject);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public void z(long j, long j2, int i) {
        if (j2 > 0) {
            z(i, (int) ((j * 100) / j2));
        }
    }

    public boolean g() {
        return this.ls;
    }

    public boolean dl() {
        if (!iq()) {
            return false;
        }
        AtomicInteger atomicInteger = this.fv;
        if (atomicInteger == null || atomicInteger.get() == 0) {
            return this.p.get();
        }
        return true;
    }

    public boolean a() {
        return this.pf;
    }

    protected void z(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.z.g.z(this.z).z(false).g(false).z(sSWebView);
        q.z(sSWebView, gk.dl, na.a(this.g));
        oq.z((com.bytedance.sdk.component.i.dl) sSWebView);
        sSWebView.setMixedContentMode(0);
    }

    public void z(int i) {
        oq.z((View) this.e, 0);
        if (i == 1) {
            oq.z((View) this.e, 0.0f);
        }
        if (i == 2) {
            hh();
        }
        mc mcVar = this.gz;
        if (mcVar != null) {
            mcVar.z(eo.ls(this.g), false);
        }
    }

    public void gc() {
        gc gcVar = this.wp;
        if (gcVar != null) {
            gcVar.z(System.currentTimeMillis());
        }
    }

    public void m() {
        if (this.z.gb() instanceof com.bytedance.sdk.openadsdk.core.component.reward.a.fo) {
            l();
        } else {
            oq.z((View) this.e, 8);
        }
    }

    public boolean e() {
        SSWebView sSWebView = this.e;
        if (sSWebView != null) {
            return sSWebView.canGoBack();
        }
        return false;
    }

    public void gz() {
        SSWebView sSWebView = this.e;
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return;
        }
        this.e.goBack();
    }

    public void fo() {
        this.fo = null;
    }

    public int uy() {
        return this.i;
    }

    public String kb() {
        return this.v;
    }

    public void wp() {
        SSWebView sSWebView = this.e;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        mc mcVar = this.gz;
        if (mcVar != null) {
            mcVar.hh();
            SSWebView sSWebView2 = this.e;
            if (sSWebView2 != null) {
                if (sSWebView2.getVisibility() == 0) {
                    this.gz.m(true);
                    z(true);
                    z(false, true);
                } else {
                    this.gz.m(false);
                    z(false);
                    z(true, false);
                }
            }
        }
        gc gcVar = this.wp;
        if (gcVar != null) {
            gcVar.a();
        }
        com.bytedance.sdk.openadsdk.core.widget.z.a aVar = this.kb;
        if (aVar != null) {
            aVar.g(false);
        }
    }

    public void i() {
        SSWebView sSWebView = this.e;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        mc mcVar = this.gz;
        if (mcVar != null) {
            mcVar.l();
            this.gz.m(false);
            z(false);
            z(true, false);
        }
        com.bytedance.sdk.openadsdk.core.widget.z.a aVar = this.kb;
        if (aVar != null) {
            aVar.dl();
        }
    }

    public void v() {
        gc gcVar = this.wp;
        if (gcVar != null) {
            gcVar.gc();
        }
    }

    public void pf() {
        mc mcVar = this.gz;
        if (mcVar != null) {
            mcVar.h();
        }
        fo foVar = this.fo;
        if (foVar != null) {
            foVar.z(true);
            this.fo.ls();
        }
        gc gcVar = this.wp;
        if (gcVar != null) {
            gcVar.m();
        }
        SSWebView sSWebView = this.e;
        if (sSWebView != null) {
            com.bytedance.sdk.openadsdk.core.oq.z(this.z, sSWebView);
            com.bytedance.sdk.openadsdk.core.oq.z(this.e);
            this.e.destroy();
        }
        this.e = null;
    }

    public void ls() {
        SSWebView sSWebView = this.e;
        if (sSWebView != null) {
            sSWebView.onResume();
            this.e.resumeTimers();
            oq.z((View) this.e, 1.0f);
            sy();
        }
    }

    public void z(Map<String, Object> map) {
        fo foVar = this.fo;
        if (foVar != null) {
            foVar.uy();
        }
    }

    public void p() {
        fo foVar = this.fo;
        if (foVar != null) {
            foVar.fo();
        }
    }

    public void fv() {
        fo foVar = this.fo;
        if (foVar != null) {
            foVar.kb();
        }
    }

    public void js() {
        fo foVar = this.fo;
        if (foVar != null) {
            foVar.wp();
        }
    }

    public void tb() {
        fo foVar = this.fo;
        if (foVar != null) {
            foVar.dl();
            this.fo.a();
        }
    }

    public boolean q() {
        mc mcVar = this.gz;
        if (mcVar == null) {
            return false;
        }
        return mcVar.q();
    }

    public void z(boolean z, int i, String str) {
        fo foVar = this.fo;
        if (foVar == null) {
            return;
        }
        if (z) {
            foVar.g();
        } else {
            foVar.z(i, str);
        }
    }

    private boolean z(String str) {
        try {
            new URL(str);
            if (URLUtil.isValidUrl(str)) {
                if (Patterns.WEB_URL.matcher(str).matches()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public boolean iq() {
        return z(this.uy);
    }

    public void zw() {
        SSWebView sSWebView = this.e;
        if (sSWebView != null) {
            sSWebView.loadUrl("about:blank");
        }
    }

    public void z(JSONObject jSONObject) {
        mc mcVar = this.gz;
        if (mcVar == null) {
            wp.a("BaseEndCard", "mJsObject is null!");
        } else {
            mcVar.z("showPlayAgainEntrance", jSONObject);
        }
    }

    public void z(na naVar) {
        this.g = naVar;
        this.pf = false;
    }

    private void hh() {
        if (this.iq.getAndSet(true)) {
            return;
        }
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "translationY", oq.gc((Context) this.z), 0.0f);
            objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.z.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    z.this.iq.set(false);
                }
            });
            objectAnimatorOfFloat.start();
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private void l() {
        if (this.iq.getAndSet(true)) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "translationY", 0.0f, oq.gc((Context) this.z));
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.z.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                oq.z((View) z.this.e, 8);
                z.this.iq.set(false);
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void sy() {
        mc mcVar = this.gz;
        if (mcVar == null) {
            return;
        }
        mcVar.z(new SSWebView.g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.z.6
            @Override // com.bytedance.sdk.component.widget.SSWebView.g
            public void z(int i) {
                if (z.this.gz != null) {
                    z.this.gz.z(i);
                }
            }
        });
    }
}
