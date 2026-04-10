package com.anythink.expressad.advanced.d;

import android.content.Context;
import android.util.Base64;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.anythink.core.common.a.g;
import com.anythink.core.common.b.n;
import com.anythink.expressad.advanced.c.c;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.advanced.view.ATNativeAdvancedView;
import com.anythink.expressad.advanced.view.ATNativeAdvancedWebview;
import com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.y;
import com.anythink.expressad.out.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements g {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8189c = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f8190g = "NativeAdvancedProvider";
    private JSONObject C;
    private ATOutNativeAdvancedViewGroup E;
    private boolean F;
    private boolean G;
    private boolean H;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f8192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    com.anythink.expressad.foundation.d.d f8193f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f8194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f8195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.anythink.expressad.advanced.c.a f8196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.anythink.expressad.advanced.c.b f8197k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private b f8198l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private o f8199m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private d f8200n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ATNativeAdvancedView f8201o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ATNativeAdvancedWebview f8202p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private com.anythink.expressad.advanced.view.a f8203q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.anythink.expressad.d.c f8204r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f8205s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f8206t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f8207u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f8208v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f8209w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f8210x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f8211y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f8212z = 0;
    private int A = 0;
    private Object B = new Object();
    private boolean D = false;
    private boolean I = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8191d = false;
    private ViewTreeObserver.OnScrollChangedListener J = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.anythink.expressad.advanced.d.c.1
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            if (c.this.I) {
                c.this.I = false;
                if (c.this.E != null) {
                    c.this.E.postDelayed(new Runnable() { // from class: com.anythink.expressad.advanced.d.c.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.this.I = true;
                        }
                    }, 1000L);
                }
                try {
                    c.this.j();
                } catch (Throwable unused) {
                }
            }
        }
    };

    public c(String str, String str2, Context context) {
        com.anythink.expressad.advanced.view.a aVar;
        int i2;
        this.f8195i = str;
        this.f8194h = str2;
        if (this.f8197k == null) {
            this.f8197k = new com.anythink.expressad.advanced.c.b(n.a().g(), this.f8195i, this.f8194h);
            this.f8197k.a(this);
        }
        if (this.f8202p == null) {
            try {
                this.f8202p = new ATNativeAdvancedWebview(n.a().g());
            } catch (Throwable unused) {
            }
            if (this.f8203q == null) {
                try {
                    this.f8203q = new com.anythink.expressad.advanced.view.a(this.f8194h, this.f8197k.b(), this);
                } catch (Throwable unused2) {
                }
            }
            ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f8202p;
            if (aTNativeAdvancedWebview != null && (aVar = this.f8203q) != null) {
                aTNativeAdvancedWebview.setWebViewClient(aVar);
            }
        }
        if (this.f8201o == null) {
            this.f8201o = new ATNativeAdvancedView(context);
            this.f8201o.setAdvancedNativeWebview(this.f8202p);
            ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.f8202p;
            if (aTNativeAdvancedWebview2 != null && aTNativeAdvancedWebview2.getParent() == null) {
                this.f8201o.addView(this.f8202p, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        if (this.E == null) {
            this.E = new ATOutNativeAdvancedViewGroup(n.a().g());
            int i3 = this.f8212z;
            this.E.setLayoutParams((i3 == 0 || (i2 = this.A) == 0) ? new ViewGroup.LayoutParams(-1, -1) : new ViewGroup.LayoutParams(i3, i2));
            this.E.setProvider(this);
            this.E.addView(this.f8201o);
            this.E.getViewTreeObserver().addOnScrollChangedListener(this.J);
        }
    }

    private void g(int i2) {
        if (this.f8207u) {
            this.f8206t = i2;
            ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f8202p;
            if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
                return;
            }
            int i3 = this.f8206t;
            if (i3 == 1) {
                this.f8197k.a(true);
                NativeAdvancedJsUtils.sendThirdToH5(this.f8202p, NativeAdvancedJsUtils.f8236f, "", null);
            } else if (i3 == 0) {
                this.f8197k.a(false);
                NativeAdvancedJsUtils.sendThirdToH5(this.f8202p, NativeAdvancedJsUtils.f8237g, "", null);
            }
        }
    }

    private void h(int i2) {
        if (this.f8209w) {
            this.f8208v = i2;
            ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f8202p;
            if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
                return;
            }
            NativeAdvancedJsUtils.sendThirdToH5(this.f8202p, NativeAdvancedJsUtils.f8238h, "mute", Integer.valueOf(i2));
        }
    }

    private void i(int i2) {
        if (this.f8211y) {
            this.f8210x = i2;
            ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f8202p;
            if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
                return;
            }
            NativeAdvancedJsUtils.sendThirdToH5(this.f8202p, NativeAdvancedJsUtils.f8240j, NativeAdvancedJsUtils.f8241k, Integer.valueOf(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.F && this.G && this.H && !y.a(this.f8201o.getAdvancedNativeWebview()) && this.E.getAlpha() >= 0.5f && this.E.getVisibility() == 0) {
            com.anythink.expressad.advanced.c.b bVar = this.f8197k;
            if (bVar != null) {
                bVar.d();
            }
            g();
        }
    }

    private void k() {
        com.anythink.expressad.advanced.c.b bVar = this.f8197k;
        if (bVar != null) {
            bVar.e();
        }
    }

    public final int d() {
        return this.f8206t;
    }

    public final void e(int i2) {
        if (i2 == 1) {
            this.F = false;
        } else if (i2 == 2) {
            this.G = false;
        } else if (i2 == 3) {
            this.H = false;
        }
        com.anythink.expressad.advanced.c.b bVar = this.f8197k;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // com.anythink.core.common.a.g
    public boolean isReady() {
        return false;
    }

    private void f(int i2) {
        ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f8202p;
        if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
            return;
        }
        try {
            if (this.f8202p != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(NativeAdvancedJsUtils.f8243m, i2);
                j.a();
                j.a((WebView) this.f8202p, NativeAdvancedJsUtils.f8242l, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.a(f8190g, th.getMessage());
        }
    }

    public final void b() {
        this.f8205s = false;
    }

    public final ATOutNativeAdvancedViewGroup c() {
        return this.E;
    }

    public final void d(int i2) {
        if (i2 == 1) {
            this.F = true;
        } else if (i2 == 2) {
            this.G = true;
        } else if (i2 == 3) {
            this.H = true;
        }
        try {
            j();
        } catch (Throwable unused) {
        }
    }

    private void b(JSONObject jSONObject) {
        if (this.D) {
            this.C = jSONObject;
            ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f8202p;
            if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
                return;
            }
            NativeAdvancedJsUtils.sendThirdToH5(this.f8202p, NativeAdvancedJsUtils.f8234d, "", jSONObject);
        }
    }

    public final boolean a() {
        return this.f8205s;
    }

    public final void c(int i2) {
        this.f8211y = true;
        i(i2);
    }

    private void a(JSONObject jSONObject) {
        this.D = true;
        b(jSONObject);
    }

    private String h() {
        if (this.f8191d) {
            com.anythink.expressad.advanced.c.b bVar = this.f8197k;
            return bVar != null ? bVar.a() : "";
        }
        com.anythink.expressad.advanced.c.a aVar = this.f8196j;
        return aVar != null ? aVar.a() : "";
    }

    private void i() {
        g(this.f8206t);
        h(this.f8208v);
        i(this.f8210x);
        b(this.C);
        n.a().g();
        f(k.a());
    }

    public final void a(o oVar) {
        this.f8199m = oVar;
    }

    public final void e() {
        if (this.f8199m != null) {
            this.f8199m = null;
        }
        if (this.f8198l != null) {
            this.f8198l = null;
        }
        if (this.f8200n != null) {
            this.f8200n = null;
        }
        com.anythink.expressad.advanced.c.a aVar = this.f8196j;
        if (aVar != null) {
            aVar.a((ATNativeAdvancedView) null);
            this.f8196j.b();
        }
        com.anythink.expressad.advanced.c.b bVar = this.f8197k;
        if (bVar != null) {
            bVar.c();
        }
        ATNativeAdvancedView aTNativeAdvancedView = this.f8201o;
        if (aTNativeAdvancedView != null) {
            aTNativeAdvancedView.destroy();
        }
        com.anythink.expressad.advanced.a.a.c(this.f8193f.f());
        com.anythink.expressad.advanced.view.a aVar2 = this.f8203q;
        if (aVar2 != null) {
            aVar2.a();
        }
        ATOutNativeAdvancedViewGroup aTOutNativeAdvancedViewGroup = this.E;
        if (aTOutNativeAdvancedViewGroup != null) {
            aTOutNativeAdvancedViewGroup.getViewTreeObserver().removeOnScrollChangedListener(this.J);
            this.E.removeAllViews();
            this.E = null;
        }
    }

    public final void a(int i2) {
        this.f8207u = true;
        g(i2);
    }

    public final void b(int i2) {
        this.f8209w = true;
        h(i2);
    }

    private void a(com.anythink.expressad.foundation.d.c cVar) {
        this.f8197k.a(this.f8200n);
        com.anythink.expressad.foundation.h.o.d(f8190g, "start show process");
        this.f8197k.a(cVar, this.f8201o, true);
    }

    private void b(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.A = i2;
        this.f8212z = i3;
        this.E.setLayoutParams(new ViewGroup.LayoutParams(i3, i2));
    }

    private void g() {
        final com.anythink.expressad.foundation.d.c[] cVarArr = new com.anythink.expressad.foundation.d.c[1];
        com.anythink.expressad.advanced.c.a aVar = this.f8196j;
        if (aVar != null) {
            cVarArr[0] = aVar.c();
        }
        if (cVarArr[0] != null) {
            if (this.f8204r == null) {
                com.anythink.expressad.d.b.a();
                this.f8204r = com.anythink.expressad.d.b.b(com.anythink.expressad.foundation.b.a.b().e(), this.f8194h);
            }
            this.f8200n = new d(this, this.f8199m, this.f8204r.a(), cVarArr[0]);
            if (this.f8192e) {
                return;
            }
            this.f8192e = true;
            com.anythink.expressad.advanced.c.c.a(this.f8201o, cVarArr[0], this.f8195i, this.f8194h, this.f8206t, new c.a() { // from class: com.anythink.expressad.advanced.d.c.2
                @Override // com.anythink.expressad.advanced.c.c.a
                public final void a() {
                    com.anythink.expressad.foundation.h.o.a(c.f8190g, "show start");
                    c.this.a(cVarArr[0], false);
                }

                @Override // com.anythink.expressad.advanced.c.c.a
                public final void b() {
                    c.this.f8192e = false;
                }
            });
        }
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        this.f8193f = dVar;
        this.I = true;
        this.f8205s = true;
        this.f8201o.clearResStateAndRemoveClose();
        com.anythink.expressad.d.b.a();
        this.f8204r = com.anythink.expressad.d.b.d(com.anythink.expressad.foundation.b.a.b().e(), this.f8194h);
        if (this.f8204r == null) {
            this.f8204r = com.anythink.expressad.d.c.y();
        }
        this.f8198l = new b(this);
        this.f8198l.a(this.f8199m);
        if (this.f8196j == null) {
            this.f8196j = new com.anythink.expressad.advanced.c.a(this.f8195i, this.f8194h);
        }
        b bVar = this.f8198l;
        if (bVar != null) {
            this.f8196j.a(bVar);
        }
        this.f8201o.resetLoadState();
        this.f8196j.a(this.f8201o);
        this.f8196j.a(this.f8204r);
        this.f8196j.a(this.f8212z, this.A);
        this.f8196j.a(this.f8206t);
        this.f8196j.a(dVar);
    }

    private void a(Context context) {
        com.anythink.expressad.advanced.view.a aVar;
        ViewGroup.LayoutParams layoutParams;
        int i2;
        if (this.f8197k == null) {
            this.f8197k = new com.anythink.expressad.advanced.c.b(n.a().g(), this.f8195i, this.f8194h);
            this.f8197k.a(this);
        }
        if (this.f8202p == null) {
            try {
                this.f8202p = new ATNativeAdvancedWebview(n.a().g());
            } catch (Throwable unused) {
            }
            if (this.f8203q == null) {
                try {
                    this.f8203q = new com.anythink.expressad.advanced.view.a(this.f8194h, this.f8197k.b(), this);
                } catch (Throwable unused2) {
                }
            }
            ATNativeAdvancedWebview aTNativeAdvancedWebview = this.f8202p;
            if (aTNativeAdvancedWebview != null && (aVar = this.f8203q) != null) {
                aTNativeAdvancedWebview.setWebViewClient(aVar);
            }
        }
        if (this.f8201o == null) {
            this.f8201o = new ATNativeAdvancedView(context);
            this.f8201o.setAdvancedNativeWebview(this.f8202p);
            ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.f8202p;
            if (aTNativeAdvancedWebview2 != null && aTNativeAdvancedWebview2.getParent() == null) {
                this.f8201o.addView(this.f8202p, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        if (this.E == null) {
            this.E = new ATOutNativeAdvancedViewGroup(n.a().g());
            int i3 = this.f8212z;
            if (i3 != 0 && (i2 = this.A) != 0) {
                layoutParams = new ViewGroup.LayoutParams(i3, i2);
            } else {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            this.E.setLayoutParams(layoutParams);
            this.E.setProvider(this);
            this.E.addView(this.f8201o);
            this.E.getViewTreeObserver().addOnScrollChangedListener(this.J);
        }
    }

    public final String a(String str) {
        com.anythink.expressad.advanced.c.a aVar = this.f8196j;
        return aVar != null ? aVar.a(str) : "";
    }

    public final void a(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.A = i2;
        this.f8212z = i3;
        this.E.setLayoutParams(new ViewGroup.LayoutParams(i3, i2));
    }

    final void a(com.anythink.expressad.foundation.d.c cVar, boolean z2) {
        g(this.f8206t);
        h(this.f8208v);
        i(this.f8210x);
        b(this.C);
        n.a().g();
        f(k.a());
        ATOutNativeAdvancedViewGroup aTOutNativeAdvancedViewGroup = this.E;
        if (aTOutNativeAdvancedViewGroup == null || aTOutNativeAdvancedViewGroup.getParent() == null) {
            return;
        }
        if (cVar != null && z2) {
            if (this.f8204r == null) {
                com.anythink.expressad.d.b.a();
                this.f8204r = com.anythink.expressad.d.b.b(com.anythink.expressad.foundation.b.a.b().e(), this.f8194h);
            }
            this.f8200n = new d(this, this.f8199m, this.f8204r.a(), cVar);
        }
        if (this.f8197k == null) {
            this.f8197k = new com.anythink.expressad.advanced.c.b(n.a().g(), this.f8195i, this.f8194h);
            this.f8197k.a(this);
        }
        this.f8197k.a(this.f8200n);
        com.anythink.expressad.foundation.h.o.d(f8190g, "start show process");
        this.f8197k.a(cVar, this.f8201o, true);
    }
}
