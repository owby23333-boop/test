package com.anythink.expressad.splash.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.core.common.a.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.u;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.out.e;
import com.anythink.expressad.out.t;
import com.anythink.expressad.splash.view.ATSplashPopView;
import com.anythink.expressad.splash.view.ATSplashView;
import com.anythink.expressad.splash.view.ATSplashWebview;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements g {
    private static String b = "SplashProvider";
    private Context A;
    private boolean B;
    private com.anythink.expressad.foundation.d.c C;
    private ATSplashPopView D;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11321d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f11323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.anythink.expressad.splash.c.c f11326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.anythink.expressad.splash.c.d f11327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private b f11328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private e f11329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private d f11330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ATSplashView f11331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ATSplashWebview f11332o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ViewGroup f11333p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private View f11334q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.anythink.expressad.d.c f11335r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f11336s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ViewGroup f11337t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f11338u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f11340w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f11341x;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11322e = 5;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f11339v = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Object f11342y = new Object();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Object f11343z = new Object();
    public boolean a = false;
    private boolean E = false;
    private boolean F = false;

    public c(Context context, String str, String str2) {
        this.f11340w = k.e(n.a().g());
        this.f11341x = k.f(n.a().g());
        this.f11340w = context.getResources().getDisplayMetrics().widthPixels;
        this.f11341x = context.getResources().getDisplayMetrics().heightPixels;
        this.f11321d = str;
        this.f11320c = str2;
        this.A = context;
        if (this.f11327j == null) {
            if (context != null) {
                this.f11327j = new com.anythink.expressad.splash.c.d(context, this.f11321d, this.f11320c);
            } else {
                this.f11327j = new com.anythink.expressad.splash.c.d(n.a().g(), this.f11321d, this.f11320c);
            }
        }
        if (this.f11332o == null) {
            try {
                if (context != null) {
                    this.f11332o = new ATSplashWebview(context);
                } else {
                    this.f11332o = new ATSplashWebview(n.a().g());
                }
            } catch (Exception unused) {
            }
            ATSplashWebview aTSplashWebview = this.f11332o;
            if (aTSplashWebview != null) {
                aTSplashWebview.setWebViewClient(new com.anythink.expressad.splash.view.b(this.f11320c, this.f11327j.a()));
            }
        }
        if (this.f11331n == null) {
            if (context != null) {
                this.f11331n = new ATSplashView(context);
            } else {
                this.f11331n = new ATSplashView(n.a().g());
            }
            this.f11331n.setSplashWebview(this.f11332o);
        }
    }

    private void b(ViewGroup viewGroup) {
        this.f11337t = viewGroup;
    }

    private String h() {
        if (this.a) {
            com.anythink.expressad.splash.c.d dVar = this.f11327j;
            return dVar != null ? dVar.b() : "";
        }
        com.anythink.expressad.splash.c.c cVar = this.f11326i;
        return cVar != null ? cVar.a() : "";
    }

    private void i() {
        this.E = true;
        ATSplashPopView aTSplashPopView = this.D;
        if (aTSplashPopView != null) {
            aTSplashPopView.startCountDown();
        }
    }

    private void j() {
        this.E = false;
        ATSplashPopView aTSplashPopView = this.D;
        if (aTSplashPopView != null) {
            aTSplashPopView.release();
        }
    }

    private void k() {
        com.anythink.expressad.splash.c.d dVar = this.f11327j;
        if (dVar != null) {
            dVar.d();
        }
        ATSplashPopView aTSplashPopView = this.D;
        if (aTSplashPopView == null || !this.E) {
            return;
        }
        aTSplashPopView.reStartCountDown();
    }

    private void l() {
        ATSplashWebview aTSplashWebview = this.f11332o;
        if (aTSplashWebview != null) {
            aTSplashWebview.setOnTouchListener(new View.OnTouchListener() { // from class: com.anythink.expressad.splash.d.c.2
                final /* synthetic */ boolean a = true;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return !this.a;
                }
            });
        }
        ATSplashView aTSplashView = this.f11331n;
        if (aTSplashView != null) {
            aTSplashView.setOnTouchListener(new View.OnTouchListener() { // from class: com.anythink.expressad.splash.d.c.3
                final /* synthetic */ boolean a = true;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return !this.a;
                }
            });
        }
    }

    private void m() {
        com.anythink.expressad.splash.c.d dVar = this.f11327j;
        if (dVar != null) {
            dVar.e();
        }
        ATSplashPopView aTSplashPopView = this.D;
        if (aTSplashPopView == null || !this.E) {
            return;
        }
        aTSplashPopView.pauseCountDown();
    }

    public final long c() {
        return this.f11323f;
    }

    public final boolean d() {
        return this.f11338u;
    }

    public final int e() {
        return this.f11322e;
    }

    public final void f() {
        a(100, 100);
    }

    public final void g() {
        this.C = null;
        if (this.f11329l != null) {
            this.f11329l = null;
        }
        if (this.f11328k != null) {
            this.f11328k = null;
        }
        if (this.f11330m != null) {
            this.f11330m = null;
        }
        com.anythink.expressad.splash.c.c cVar = this.f11326i;
        if (cVar != null) {
            cVar.b();
        }
        com.anythink.expressad.splash.c.d dVar = this.f11327j;
        if (dVar != null) {
            dVar.c();
        }
        if (this.A != null) {
            this.A = null;
        }
    }

    @Override // com.anythink.core.common.a.g
    public final boolean isReady() {
        return this.f11326i.c() != null && com.anythink.expressad.splash.c.b.a(this.f11331n, this.f11326i.c());
    }

    private void c(boolean z2) {
        this.B = z2;
    }

    public final boolean a() {
        return this.f11336s;
    }

    public final void b() {
        this.f11336s = false;
    }

    private void a(long j2) {
        this.f11323f = j2;
    }

    private void b(int i2) {
        this.f11339v = i2;
    }

    public final void a(boolean z2) {
        this.F = z2;
    }

    public final void b(boolean z2) {
        this.f11338u = z2;
    }

    public final void a(com.anythink.expressad.out.d dVar) {
        if (this.f11328k == null) {
            this.f11328k = new b(this);
        }
        this.f11328k.a(dVar);
    }

    public final void a(e eVar) {
        this.f11329l = eVar;
    }

    public final void a(int i2) {
        this.f11322e = i2;
    }

    private void a(String str, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(str)) {
            e eVar = this.f11329l;
            if (eVar != null) {
                eVar.a("token is null or empty");
                return;
            }
            return;
        }
        a(viewGroup);
    }

    public final void a(ViewGroup viewGroup) {
        this.f11333p = viewGroup;
        ATSplashView aTSplashView = this.f11331n;
        if (aTSplashView != null) {
            aTSplashView.setDevContainer(viewGroup);
        }
        com.anythink.expressad.splash.c.c cVar = this.f11326i;
        com.anythink.expressad.foundation.d.c cVarC = cVar != null ? cVar.c() : null;
        if (cVarC != null) {
            if (this.f11335r == null) {
                com.anythink.expressad.d.b.a();
                this.f11335r = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e(), this.f11320c);
            }
            this.f11330m = new d(this, this.f11329l, this.f11335r.a(), cVarC);
            o.a(b, "show start");
            int i2 = this.f11322e;
            if (i2 < 2 || i2 > 10) {
                this.f11322e = 5;
            }
            a(cVarC, false);
            return;
        }
        e eVar = this.f11329l;
        if (eVar != null) {
            eVar.a("campaignEx is vali");
        }
    }

    final void a(com.anythink.expressad.foundation.d.c cVar, boolean z2) {
        if (cVar != null && z2) {
            if (this.f11335r == null) {
                com.anythink.expressad.d.b.a();
                this.f11335r = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e(), this.f11320c);
            }
            this.f11330m = new d(this, this.f11329l, this.f11335r.a(), cVar);
        }
        this.C = cVar;
        ViewGroup viewGroup = this.f11333p;
        if (viewGroup == null) {
            d dVar = this.f11330m;
            if (dVar != null) {
                dVar.a("container is null");
                return;
            }
            return;
        }
        if (this.f11327j == null) {
            this.f11327j = new com.anythink.expressad.splash.c.d(viewGroup.getContext(), this.f11321d, this.f11320c);
        }
        a(cVar, 0, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.anythink.expressad.foundation.d.c cVar, final int i2, final boolean z2) {
        if (!com.anythink.expressad.splash.c.b.a(this.f11331n, cVar)) {
            if (i2 > 0) {
                this.f11327j.a.postDelayed(new Runnable() { // from class: com.anythink.expressad.splash.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.a(cVar, i2 - 1, z2);
                    }
                }, 1L);
                return;
            }
            d dVar = this.f11330m;
            if (dVar != null) {
                dVar.a("campaignEx is not ready");
                return;
            }
            return;
        }
        l();
        this.f11327j.a(this.f11322e);
        this.f11327j.a(this.f11337t);
        this.f11327j.a(this.f11330m);
        o.d(b, "start show process");
        ViewGroup viewGroup = this.f11333p;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            u.a(this.f11331n);
            this.f11333p.addView(this.f11331n, new ViewGroup.LayoutParams(-1, -1));
        }
        this.f11327j.a(this.f11338u);
        this.f11327j.a(cVar, this.f11331n);
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        synchronized (this.f11342y) {
            if (this.f11336s) {
                if (this.f11328k != null) {
                    this.f11328k.a("current unit is loading");
                    this.f11336s = true;
                }
                return;
            }
            this.f11336s = true;
            this.f11331n.clearResState();
            this.f11335r = new com.anythink.expressad.d.c();
            if (this.f11326i == null) {
                this.f11326i = new com.anythink.expressad.splash.c.c(this.f11321d, this.f11320c, this.f11323f * 1000);
            }
            b bVar = this.f11328k;
            if (bVar != null) {
                bVar.b("");
                this.f11326i.a(this.f11328k);
            }
            this.f11331n.resetLoadState();
            this.f11326i.b(this.f11322e);
            this.f11326i.a(this.f11331n);
            this.f11326i.a(this.f11335r);
            this.f11326i.a(this.f11340w, this.f11341x);
            this.f11326i.b(this.f11338u);
            this.f11326i.a(this.F);
            this.f11326i.a(this.f11339v);
            this.f11326i.a(dVar);
        }
    }

    private void a(Context context) {
        if (this.f11327j == null) {
            if (context != null) {
                this.f11327j = new com.anythink.expressad.splash.c.d(context, this.f11321d, this.f11320c);
            } else {
                this.f11327j = new com.anythink.expressad.splash.c.d(n.a().g(), this.f11321d, this.f11320c);
            }
        }
        if (this.f11332o == null) {
            try {
                if (context != null) {
                    this.f11332o = new ATSplashWebview(context);
                } else {
                    this.f11332o = new ATSplashWebview(n.a().g());
                }
            } catch (Exception unused) {
            }
            ATSplashWebview aTSplashWebview = this.f11332o;
            if (aTSplashWebview != null) {
                aTSplashWebview.setWebViewClient(new com.anythink.expressad.splash.view.b(this.f11320c, this.f11327j.a()));
            }
        }
        if (this.f11331n == null) {
            if (context != null) {
                this.f11331n = new ATSplashView(context);
            } else {
                this.f11331n = new ATSplashView(n.a().g());
            }
            this.f11331n.setSplashWebview(this.f11332o);
        }
    }

    private void a(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f11334q = view;
        if (view != null) {
            a(layoutParams.width, layoutParams.height);
            ATSplashView aTSplashView = this.f11331n;
            if (aTSplashView != null) {
                aTSplashView.setIconVg(view, layoutParams);
            }
        }
    }

    private ViewGroup a(t tVar) {
        this.D = new ATSplashPopView(n.a().g(), new ATSplashPopView.a(this.f11321d, this.f11320c, tVar.a(), this.C), this.f11330m);
        return this.D;
    }

    private void a(int i2, int i3) {
        int iE = k.e(n.a().g());
        int iF = k.f(n.a().g());
        int i4 = this.f11339v;
        if (i4 == 1) {
            if (iF >= i3 * 4) {
                this.f11341x = iF - i3;
                this.f11340w = iE;
                return;
            } else {
                this.f11341x = 0;
                this.f11340w = 0;
                return;
            }
        }
        if (i4 == 2) {
            if (iE >= i2 * 4) {
                this.f11340w = iE - i2;
                this.f11341x = iF;
            } else {
                this.f11341x = 0;
                this.f11340w = 0;
            }
        }
    }
}
