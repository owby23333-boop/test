package com.anythink.expressad.splash.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.a.f;
import com.anythink.core.common.k.u;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.splash.js.SplashJSBridgeImpl;
import com.anythink.expressad.splash.js.SplashJsUtils;
import com.anythink.expressad.splash.view.ATSplashView;
import com.anythink.expressad.splash.view.ATSplashWebview;
import com.anythink.expressad.widget.FeedBackButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.anythink.expressad.foundation.d.c f11289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ATSplashView f11290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.anythink.expressad.splash.d.d f11291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.anythink.expressad.a.a f11292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f11294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f11295j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f11296k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f11297l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f11299n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f11300o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f11301p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f11302q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f11303r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f11304s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Context f11306u;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11288c = "SplashShowManager";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f11298m = 5;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f11305t = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private View.OnClickListener f11307v = new View.OnClickListener() { // from class: com.anythink.expressad.splash.c.d.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (d.this.f11293h) {
                d.b(d.this);
                d.a(d.this, -1);
            }
        }
    };

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private f.b f11308w = new f.b();
    public Handler a = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.splash.c.d.2
        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2 && d.this.f11289d != null && d.this.f11289d.ay() && d.this.f11290e != null) {
                    d.this.f11290e.getSplashWebview();
                    return;
                }
                return;
            }
            if (d.this.f11305t) {
                return;
            }
            if (!u.a(d.this.f11290e, d.this.f11308w)) {
                d.this.a.removeMessages(1);
                sendEmptyMessageDelayed(1, 1000L);
            } else {
                if (d.this.f11298m <= 0) {
                    d.b(d.this);
                    return;
                }
                d.g(d.this);
                d dVar = d.this;
                d.a(dVar, dVar.f11298m);
                d.this.a.removeMessages(1);
                sendEmptyMessageDelayed(1, 1000L);
            }
        }
    };

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private com.anythink.expressad.splash.d.a f11309x = new com.anythink.expressad.splash.d.a() { // from class: com.anythink.expressad.splash.c.d.3
        @Override // com.anythink.expressad.splash.d.a
        public final void a(int i2) {
            if (d.this.f11290e != null) {
                d.this.f11290e.changeCloseBtnState(i2);
            }
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void b() {
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void b(int i2) {
            o.d(d.this.f11288c, "resetCountdown".concat(String.valueOf(i2)));
            d.this.f11298m = i2;
            d.this.a.removeMessages(1);
            d.this.a.sendEmptyMessageDelayed(1, 1000L);
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void c() {
            d.b(d.this);
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a() {
            d.b(d.this);
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            d.this.a(cVar);
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(int i2, int i3) {
            if (i2 == 1) {
                d.this.a.removeMessages(1);
            }
            if (i2 == 2) {
                d.this.f11298m = i3;
                d.this.a.removeMessages(1);
                d.this.a.sendEmptyMessageDelayed(1, 1000L);
            }
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void b(String str) {
            try {
                if (d.this.f11291f != null) {
                    if (TextUtils.isEmpty(str)) {
                        d.this.f11291f.a(d.this.f11289d);
                        return;
                    }
                    com.anythink.expressad.foundation.d.c cVarB = com.anythink.expressad.foundation.d.c.b(com.anythink.expressad.foundation.d.c.a(d.this.f11289d));
                    cVarB.p(str);
                    d.this.a(cVarB);
                }
            } catch (Exception e2) {
                o.d(d.this.f11288c, e2.getMessage());
            }
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(String str) {
            d.a(d.this, str);
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(boolean z2) {
            if (z2) {
                d.this.a.removeMessages(1);
            }
        }
    };
    Rect b = new Rect();

    /* JADX INFO: renamed from: com.anythink.expressad.splash.c.d$6, reason: invalid class name */
    final class AnonymousClass6 implements com.anythink.expressad.foundation.f.a {
        AnonymousClass6() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            String string;
            d.this.e();
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 1);
                }
                string = jSONObject.toString();
            } catch (Throwable th) {
                o.b(d.this.f11288c, th.getMessage(), th);
                string = "";
            }
            String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
            j.a();
            j.a((WebView) d.this.f11290e.getSplashWebview(), AbsFeedBackForH5.a, strEncodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            String string;
            d.this.d();
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 2);
                }
                string = jSONObject.toString();
            } catch (Throwable th) {
                o.b(d.this.f11288c, th.getMessage(), th);
                string = "";
            }
            String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
            j.a();
            j.a((WebView) d.this.f11290e.getSplashWebview(), AbsFeedBackForH5.a, strEncodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            String string;
            d.this.d();
            try {
                JSONObject jSONObject = new JSONObject();
                if (n.a().g() != null) {
                    jSONObject.put("status", 2);
                }
                string = jSONObject.toString();
            } catch (Throwable th) {
                o.b(d.this.f11288c, th.getMessage(), th);
                string = "";
            }
            String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
            j.a();
            j.a((WebView) d.this.f11290e.getSplashWebview(), AbsFeedBackForH5.a, strEncodeToString);
        }
    }

    public d(Context context, String str, String str2) {
        this.f11299n = "点击跳过|";
        this.f11300o = "点击跳过|";
        this.f11301p = "秒";
        this.f11302q = "秒后自动关闭";
        this.f11296k = str2;
        this.f11297l = str;
        this.f11306u = context;
        if (this.f11294i == null) {
            this.f11294i = new TextView(context);
            this.f11294i.setGravity(1);
            this.f11294i.setTextIsSelectable(false);
            this.f11294i.setPadding(t.b(context, 5.0f), t.b(context, 5.0f), t.b(context, 5.0f), t.b(context, 5.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f11294i.getLayoutParams();
            this.f11294i.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(t.b(context, 100.0f), t.b(context, 50.0f)) : layoutParams);
            Context contextG = n.a().g();
            if (contextG != null) {
                String strA = com.anythink.expressad.foundation.b.a.b().a();
                int identifier = contextG.getResources().getIdentifier("anythink_splash_count_time_can_skip", i.f10649g, strA);
                int identifier2 = contextG.getResources().getIdentifier("anythink_splash_count_time_can_skip_not", i.f10649g, strA);
                int identifier3 = contextG.getResources().getIdentifier("anythink_splash_count_time_can_skip_s", i.f10649g, strA);
                this.f11300o = contextG.getResources().getString(identifier);
                String string = contextG.getResources().getString(identifier2);
                this.f11302q = string;
                this.f11299n = string;
                this.f11301p = contextG.getResources().getString(identifier3);
                this.f11294i.setBackgroundResource(contextG.getResources().getIdentifier("anythink_splash_close_bg", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
                this.f11294i.setTextColor(contextG.getResources().getColor(contextG.getResources().getIdentifier("anythink_splash_count_time_skip_text_color", i.f10646d, strA)));
            }
        }
    }

    static /* synthetic */ int g(d dVar) {
        int i2 = dVar.f11298m;
        dVar.f11298m = i2 - 1;
        return i2;
    }

    private void l() {
        ATSplashWebview splashWebview;
        Handler handler;
        this.f11303r = true;
        if (this.f11298m > 0 && (handler = this.a) != null) {
            handler.removeMessages(1);
        }
        ATSplashView aTSplashView = this.f11290e;
        if (aTSplashView == null || (splashWebview = aTSplashView.getSplashWebview()) == null || splashWebview.isDestroyed()) {
            return;
        }
        SplashJsUtils.sendEventToH5(splashWebview, "onInstallAlertShow", "");
    }

    private void c(com.anythink.expressad.foundation.d.c cVar) {
        b(cVar, n.a().g(), this.f11296k);
        c(cVar, n.a().g(), this.f11296k);
        a(cVar, n.a().g(), this.f11296k);
        cVar.c(true);
        com.anythink.expressad.foundation.g.a.f.a(this.f11296k, cVar, com.anythink.expressad.foundation.g.a.f.f10440f);
    }

    private void d(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.splash.d.d dVar = this.f11291f;
        if (dVar != null) {
            dVar.a(cVar);
        }
    }

    private void f() {
        Context contextG = n.a().g();
        if (contextG != null) {
            String strA = com.anythink.expressad.foundation.b.a.b().a();
            int identifier = contextG.getResources().getIdentifier("anythink_splash_count_time_can_skip", i.f10649g, strA);
            int identifier2 = contextG.getResources().getIdentifier("anythink_splash_count_time_can_skip_not", i.f10649g, strA);
            int identifier3 = contextG.getResources().getIdentifier("anythink_splash_count_time_can_skip_s", i.f10649g, strA);
            this.f11300o = contextG.getResources().getString(identifier);
            String string = contextG.getResources().getString(identifier2);
            this.f11302q = string;
            this.f11299n = string;
            this.f11301p = contextG.getResources().getString(identifier3);
            this.f11294i.setBackgroundResource(contextG.getResources().getIdentifier("anythink_splash_close_bg", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
            this.f11294i.setTextColor(contextG.getResources().getColor(contextG.getResources().getIdentifier("anythink_splash_count_time_skip_text_color", i.f10646d, strA)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        if (this.f11289d != null && !this.f11304s) {
            boolean z2 = true;
            this.f11304s = true;
            if (this.f11291f != null && this.f11290e != null) {
                if (this.f11306u != null && (this.f11306u instanceof Activity) && ((Activity) this.f11306u).isFinishing()) {
                    this.f11291f.a("Activity is finishing");
                    return;
                }
                this.f11291f.a();
            }
            if (!this.f11289d.V()) {
                if (!this.f11290e.isDynamicView()) {
                    com.anythink.expressad.foundation.d.c cVar = this.f11289d;
                    if (cVar.s()) {
                        z2 = false;
                    } else {
                        c(cVar, n.a().g(), this.f11296k);
                        cVar.c(true);
                        com.anythink.expressad.foundation.g.a.f.a(this.f11296k, cVar, com.anythink.expressad.foundation.g.a.f.f10440f);
                    }
                    if (z2) {
                        b(cVar, n.a().g(), this.f11296k);
                        a(cVar, n.a().g(), this.f11296k);
                    }
                    return;
                }
                com.anythink.expressad.foundation.d.c cVar2 = this.f11289d;
                b(cVar2, n.a().g(), this.f11296k);
                c(cVar2, n.a().g(), this.f11296k);
                a(cVar2, n.a().g(), this.f11296k);
                cVar2.c(true);
                com.anythink.expressad.foundation.g.a.f.a(this.f11296k, cVar2, com.anythink.expressad.foundation.g.a.f.f10440f);
            }
        }
    }

    private void h() {
        if (com.anythink.expressad.foundation.f.b.a().b() && !this.f11290e.isDynamicView()) {
            com.anythink.expressad.foundation.f.b.a().a(this.f11296k, new AnonymousClass6());
            FeedBackButton feedBackButtonB = com.anythink.expressad.foundation.f.b.a().b(this.f11296k);
            if (feedBackButtonB != null) {
                RelativeLayout.LayoutParams layoutParams = null;
                try {
                    layoutParams = (RelativeLayout.LayoutParams) feedBackButtonB.getLayoutParams();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(com.anythink.expressad.foundation.f.b.a, com.anythink.expressad.foundation.f.b.b);
                }
                layoutParams.topMargin = t.b(n.a().g(), 10.0f);
                layoutParams.leftMargin = t.b(n.a().g(), 10.0f);
                ViewGroup viewGroup = (ViewGroup) feedBackButtonB.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(feedBackButtonB);
                }
                this.f11290e.addView(feedBackButtonB, layoutParams);
            }
            this.f11289d.l(this.f11296k);
            com.anythink.expressad.foundation.f.b.a().a(this.f11296k, this.f11289d);
        }
    }

    private void i() {
        String str;
        if (this.f11293h) {
            str = this.f11300o + this.f11298m + this.f11301p;
        } else {
            str = this.f11298m + this.f11302q;
        }
        this.f11294i.setText(str);
    }

    private void j() {
        try {
            this.f11305t = true;
            if (this.f11291f != null) {
                this.f11291f.b();
                this.f11291f = null;
            }
            this.f11304s = false;
            if (this.f11290e != null) {
                this.f11290e.getSplashWebview();
            }
            if (this.a != null) {
                this.a.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused) {
        }
    }

    private void k() {
        ATSplashWebview splashWebview;
        Handler handler;
        this.f11303r = false;
        if (this.f11298m > 0 && (handler = this.a) != null) {
            handler.removeMessages(1);
            this.a.sendEmptyMessageDelayed(1, 1000L);
        }
        ATSplashView aTSplashView = this.f11290e;
        if (aTSplashView == null || (splashWebview = aTSplashView.getSplashWebview()) == null || splashWebview.isDestroyed()) {
            return;
        }
        SplashJsUtils.sendEventToH5(splashWebview, "onInstallAlertHide", "");
    }

    public final void a(com.anythink.expressad.splash.d.d dVar) {
        this.f11291f = dVar;
    }

    public final String b() {
        com.anythink.expressad.foundation.d.c cVar = this.f11289d;
        return (cVar == null || cVar.Z() == null) ? "" : this.f11289d.Z();
    }

    public final void e() {
        Handler handler;
        if (this.f11298m > 0 && (handler = this.a) != null) {
            handler.removeMessages(1);
        }
        ATSplashView aTSplashView = this.f11290e;
        if (aTSplashView != null) {
            aTSplashView.onPause();
            ATSplashWebview splashWebview = this.f11290e.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestroyed()) {
                return;
            }
            SplashJsUtils.sendEventToH5(splashWebview, SplashJsUtils.a, "");
        }
    }

    public final void a(int i2) {
        this.f11298m = i2;
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        boolean z2 = true;
        if (cVar.s()) {
            z2 = false;
        } else {
            c(cVar, n.a().g(), this.f11296k);
            cVar.c(true);
            com.anythink.expressad.foundation.g.a.f.a(this.f11296k, cVar, com.anythink.expressad.foundation.g.a.f.f10440f);
        }
        if (z2) {
            b(cVar, n.a().g(), this.f11296k);
            a(cVar, n.a().g(), this.f11296k);
        }
    }

    public final void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this.f11307v);
        }
        this.f11295j = viewGroup;
    }

    public final void d() {
        Handler handler;
        if (this.f11303r || com.anythink.expressad.foundation.f.b.f10401c) {
            return;
        }
        if (this.f11298m > 0 && (handler = this.a) != null) {
            handler.removeMessages(1);
            this.a.sendEmptyMessageDelayed(1, 1000L);
        }
        ATSplashView aTSplashView = this.f11290e;
        if (aTSplashView != null) {
            aTSplashView.onResume();
            ATSplashWebview splashWebview = this.f11290e.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestroyed()) {
                return;
            }
            SplashJsUtils.sendEventToH5(splashWebview, SplashJsUtils.b, "");
        }
    }

    public final com.anythink.expressad.splash.d.a a() {
        return this.f11309x;
    }

    private static void c(com.anythink.expressad.foundation.d.c cVar, Context context, String str) {
        com.anythink.expressad.foundation.b.a.b().b(context);
        if (!TextUtils.isEmpty(cVar.ag())) {
            com.anythink.expressad.a.a.a(context, cVar, str, cVar.ag(), false, true, com.anythink.expressad.a.a.a.f8006i);
        }
        if (TextUtils.isEmpty(str) || cVar.L() == null || cVar.L().o() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, str, cVar.L().o(), false);
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar, ATSplashView aTSplashView) {
        a(this.f11293h);
        this.f11289d = cVar;
        this.f11290e = aTSplashView;
        SplashJSBridgeImpl splashJSBridgeImpl = aTSplashView.getSplashJSBridgeImpl();
        if (splashJSBridgeImpl == null) {
            splashJSBridgeImpl = new SplashJSBridgeImpl(aTSplashView.getContext(), this.f11297l, this.f11296k);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            splashJSBridgeImpl.setCampaignList(arrayList);
        }
        splashJSBridgeImpl.setCountdownS(this.f11298m);
        splashJSBridgeImpl.setAllowSkip(this.f11293h ? 1 : 0);
        splashJSBridgeImpl.setSplashBridgeListener(this.f11309x);
        aTSplashView.setSplashJSBridgeImpl(splashJSBridgeImpl);
        boolean zS = cVar.s();
        View view = this.f11295j;
        if (view == null) {
            if (zS) {
                this.f11294i.setVisibility(8);
            }
            i();
            b(this.f11294i);
            aTSplashView.setCloseView(this.f11294i);
        } else {
            if (zS) {
                view.setVisibility(8);
            }
            b(this.f11295j);
            aTSplashView.setCloseView(this.f11295j);
        }
        aTSplashView.show();
        com.anythink.expressad.foundation.d.c cVar2 = this.f11289d;
        if (cVar2 != null && cVar2.ay() && aTSplashView != null) {
            aTSplashView.getSplashWebview();
        }
        aTSplashView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.anythink.expressad.splash.c.d.4
            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View view2) {
                n.a().a(new Runnable() { // from class: com.anythink.expressad.splash.c.d.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d dVar = d.this;
                        if (d.a(dVar, dVar.f11290e)) {
                            d.this.g();
                        }
                    }
                }, 30L);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View view2) {
            }
        });
        n.a().a(new Runnable() { // from class: com.anythink.expressad.splash.c.d.5
            @Override // java.lang.Runnable
            public final void run() {
                d dVar = d.this;
                if (d.a(dVar, dVar.f11290e)) {
                    d.this.g();
                }
            }
        }, 30L);
        b.a(this.f11289d.be());
        this.a.removeMessages(1);
        this.a.sendEmptyMessageDelayed(1, 1000L);
        this.a.sendEmptyMessageDelayed(2, 1000L);
        if (!com.anythink.expressad.foundation.f.b.a().b() || this.f11290e.isDynamicView()) {
            return;
        }
        com.anythink.expressad.foundation.f.b.a().a(this.f11296k, new AnonymousClass6());
        FeedBackButton feedBackButtonB = com.anythink.expressad.foundation.f.b.a().b(this.f11296k);
        if (feedBackButtonB != null) {
            RelativeLayout.LayoutParams layoutParams = null;
            try {
                layoutParams = (RelativeLayout.LayoutParams) feedBackButtonB.getLayoutParams();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(com.anythink.expressad.foundation.f.b.a, com.anythink.expressad.foundation.f.b.b);
            }
            layoutParams.topMargin = t.b(n.a().g(), 10.0f);
            layoutParams.leftMargin = t.b(n.a().g(), 10.0f);
            ViewGroup viewGroup = (ViewGroup) feedBackButtonB.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(feedBackButtonB);
            }
            this.f11290e.addView(feedBackButtonB, layoutParams);
        }
        this.f11289d.l(this.f11296k);
        com.anythink.expressad.foundation.f.b.a().a(this.f11296k, this.f11289d);
    }

    private void b(int i2) {
        ATSplashView aTSplashView = this.f11290e;
        if (aTSplashView != null) {
            aTSplashView.updateCountdown(i2);
            if (this.f11290e.getSplashJSBridgeImpl() != null) {
                this.f11290e.getSplashJSBridgeImpl().updateCountDown(i2);
            }
        }
        if (i2 < 0) {
            this.f11298m = i2;
        } else if (this.f11295j == null) {
            i();
        }
    }

    public final void c() {
        if (this.f11291f != null) {
            this.f11291f = null;
        }
        if (this.f11309x != null) {
            this.f11309x = null;
        }
        if (this.f11307v != null) {
            this.f11307v = null;
        }
        ATSplashView aTSplashView = this.f11290e;
        if (aTSplashView != null) {
            aTSplashView.destroy();
        }
        com.anythink.expressad.foundation.f.b.a().c(this.f11296k);
    }

    private void b(View view) {
        if (view != null) {
            view.setOnClickListener(this.f11307v);
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar, Context context, String str) {
        if (cVar != null) {
            try {
                if (TextUtils.isEmpty(cVar.ai())) {
                    return;
                }
                com.anythink.expressad.a.a.a(context, cVar, str, cVar.ai(), false, true, com.anythink.expressad.a.a.a.f8007j);
            } catch (Throwable th) {
                o.d(this.f11288c, th.getMessage());
            }
        }
    }

    static /* synthetic */ void b(d dVar) {
        try {
            dVar.f11305t = true;
            if (dVar.f11291f != null) {
                dVar.f11291f.b();
                dVar.f11291f = null;
            }
            dVar.f11304s = false;
            if (dVar.f11290e != null) {
                dVar.f11290e.getSplashWebview();
            }
            if (dVar.a != null) {
                dVar.a.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean a(View view) {
        return view != null && view.getVisibility() == 0 && view.getParent() != null && view.getWindowVisibility() == 0 && view.getGlobalVisibleRect(this.b) && ((long) this.b.height()) * ((long) this.b.width()) > 0;
    }

    private void a(String str) {
        com.anythink.expressad.splash.d.d dVar = this.f11291f;
        if (dVar != null) {
            dVar.a("web show failed:".concat(String.valueOf(str)));
        }
    }

    public final void a(boolean z2) {
        this.f11293h = z2;
        if (z2) {
            this.f11299n = this.f11300o;
        } else {
            this.f11299n = this.f11302q;
        }
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            try {
                cVar.aA();
            } catch (Throwable th) {
                o.a(this.f11288c, th.getMessage());
            }
        }
        com.anythink.expressad.splash.d.d dVar = this.f11291f;
        if (dVar != null) {
            dVar.a(cVar);
        }
    }

    private void a(com.anythink.expressad.foundation.d.c cVar, Context context, String str) {
        if (cVar != null) {
            try {
                List<String> listE = cVar.e();
                if (listE == null || listE.size() <= 0) {
                    return;
                }
                Iterator<String> it = listE.iterator();
                while (it.hasNext()) {
                    com.anythink.expressad.a.a.a(context, cVar, str, it.next(), true);
                }
            } catch (Throwable th) {
                o.d(this.f11288c, th.getMessage());
            }
        }
    }

    static /* synthetic */ void a(d dVar, int i2) {
        ATSplashView aTSplashView = dVar.f11290e;
        if (aTSplashView != null) {
            aTSplashView.updateCountdown(i2);
            if (dVar.f11290e.getSplashJSBridgeImpl() != null) {
                dVar.f11290e.getSplashJSBridgeImpl().updateCountDown(i2);
            }
        }
        if (i2 < 0) {
            dVar.f11298m = i2;
        } else if (dVar.f11295j == null) {
            dVar.i();
        }
    }

    static /* synthetic */ void a(d dVar, String str) {
        com.anythink.expressad.splash.d.d dVar2 = dVar.f11291f;
        if (dVar2 != null) {
            dVar2.a("web show failed:".concat(String.valueOf(str)));
        }
    }

    static /* synthetic */ boolean a(d dVar, View view) {
        return view != null && view.getVisibility() == 0 && view.getParent() != null && view.getWindowVisibility() == 0 && view.getGlobalVisibleRect(dVar.b) && ((long) dVar.b.height()) * ((long) dVar.b.width()) > 0;
    }
}
