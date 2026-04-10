package com.anythink.expressad.mbbanner.a.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.foundation.d.d;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.m;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.y;
import com.anythink.expressad.mbbanner.a.c.e;
import com.anythink.expressad.mbbanner.view.ATBannerWebView;
import com.anythink.expressad.out.TemplateBannerView;
import com.anythink.expressad.out.i;
import com.anythink.expressad.out.p;
import com.anythink.expressad.videocommon.b.j;
import com.anythink.expressad.widget.FeedBackButton;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f10827c = "BannerShowManager";
    private float A;
    com.anythink.expressad.a.a a;
    i b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.anythink.expressad.mbbanner.a.c.c f10828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.anythink.expressad.foundation.d.c f10830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TemplateBannerView f10831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f10832h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ATBannerWebView f10833i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f10834j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f10835k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f10836l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f10837m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f10838n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f10839o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f10840p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f10841q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f10842r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f10843s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<com.anythink.expressad.foundation.d.c> f10844t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f10845u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.anythink.expressad.mbbanner.a.a.c f10847w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f10850z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f10846v = 15000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Handler f10848x = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.mbbanner.a.d.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
        }
    };

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private com.anythink.expressad.foundation.g.g.a f10849y = new com.anythink.expressad.foundation.g.g.a() { // from class: com.anythink.expressad.mbbanner.a.d.c.4
        @Override // com.anythink.expressad.foundation.g.g.a
        public final void a() {
            c.this.a(com.anythink.expressad.mbbanner.a.a.f10768n);
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void c() {
        }
    };
    private View.OnClickListener B = new View.OnClickListener() { // from class: com.anythink.expressad.mbbanner.a.d.c.5
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (c.this.f10841q) {
                c.b(c.this);
            }
        }
    };
    private com.anythink.expressad.mbbanner.a.c.a C = new com.anythink.expressad.mbbanner.a.c.a() { // from class: com.anythink.expressad.mbbanner.a.d.c.6
        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void a(int i2) {
            if (i2 == 2) {
                c.c(c.this);
            } else {
                c.this.l();
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void b() {
            c.b(c.this);
        }

        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void b(int i2) {
            if (i2 != 1) {
                c.this.e();
            } else {
                c.this.h();
                c.b();
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void a() {
            c.b(c.this);
        }

        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            c.this.a(cVar, false, "");
        }

        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void a(boolean z2) {
            if (c.this.f10828d != null) {
                c.this.f10840p = z2;
                if (z2) {
                    c.this.f10828d.b();
                } else {
                    c.this.f10828d.c();
                }
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void a(boolean z2, String str) {
            try {
                if (c.this.f10828d != null) {
                    if (TextUtils.isEmpty(str)) {
                        c.this.f10828d.a(c.this.f10830f);
                        c.this.f10828d.a();
                    } else {
                        com.anythink.expressad.foundation.d.c cVarB = com.anythink.expressad.foundation.d.c.b(com.anythink.expressad.foundation.d.c.a(c.this.f10830f));
                        cVarB.p(str);
                        c.this.a(cVarB, z2, str);
                    }
                }
            } catch (Exception e2) {
                o.d(c.f10827c, e2.getMessage());
            }
        }
    };
    private com.anythink.expressad.atsignalcommon.a.b D = new com.anythink.expressad.atsignalcommon.a.b() { // from class: com.anythink.expressad.mbbanner.a.d.c.2
        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            c.l(c.this);
            o.d("WindVaneWebView", "BANNER onPageFinished");
            com.anythink.expressad.mbbanner.a.a.a.a(webView);
            c.n(c.this);
            if (c.this.f10830f == null || c.this.f10830f.s()) {
                return;
            }
            c.this.h();
            c.b();
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            c.this.a(str);
            c.b();
        }
    };

    public c(TemplateBannerView templateBannerView, com.anythink.expressad.mbbanner.a.c.c cVar, String str, String str2, boolean z2, com.anythink.expressad.d.c cVar2) {
        this.f10829e = z2;
        this.f10831g = templateBannerView;
        this.f10842r = str2;
        this.f10843s = str;
        this.f10828d = new e(cVar, cVar2);
    }

    static /* synthetic */ void b() {
    }

    static /* synthetic */ boolean l(c cVar) {
        cVar.f10837m = true;
        return true;
    }

    private void m() {
        ImageView imageView;
        if (this.f10829e && (imageView = this.f10834j) != null && imageView.getVisibility() == 0) {
            this.f10834j.setVisibility(8);
            this.f10834j.setOnClickListener(null);
            if (this.f10831g == null || this.f10834j.getParent() == null) {
                return;
            }
            this.f10831g.removeView(this.f10834j);
        }
    }

    private static void n() {
    }

    static /* synthetic */ boolean n(c cVar) {
        cVar.f10839o = true;
        return true;
    }

    private boolean d() throws Throwable {
        String strA = a(this.f10830f);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        if (this.f10831g == null) {
            a(com.anythink.expressad.mbbanner.a.a.f10763i);
            return true;
        }
        if (this.f10833i == null) {
            this.f10833i = new ATBannerWebView(n.a().g());
            this.f10833i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f10833i.setWebViewClient(new com.anythink.expressad.mbbanner.view.a(this.f10842r, this.f10844t, this.C));
        }
        ImageView imageView = this.f10832h;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (this.f10833i.getVisibility() != 0) {
            this.f10833i.setVisibility(0);
        }
        if (this.f10833i.getParent() == null) {
            this.f10831g.addView(this.f10833i);
            d(this.f10830f.H());
        }
        l();
        this.f10847w = new com.anythink.expressad.mbbanner.a.a.c(this.f10831g.getContext(), this.f10843s, this.f10842r);
        this.f10847w.a(this.f10844t);
        this.f10847w.a(this.C);
        this.f10847w.a(this.f10845u);
        this.f10833i.setWebViewListener(this.D);
        this.f10833i.setObject(this.f10847w);
        if (strA.startsWith(BmobDbOpenHelper.FILE)) {
            this.f10833i.loadUrl(strA);
            return true;
        }
        this.f10833i.loadDataWithBaseURL(this.f10830f.p(), strA, "text/html", com.anythink.expressad.foundation.g.a.bN, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void e() {
        if (this.f10831g == null) {
            a(com.anythink.expressad.mbbanner.a.a.f10763i);
            return;
        }
        ATBannerWebView aTBannerWebView = this.f10833i;
        if (aTBannerWebView != null && aTBannerWebView.getParent() != null) {
            this.f10831g.removeView(this.f10833i);
        }
        if (this.f10832h == null) {
            this.f10832h = new ImageView(n.a().g());
            this.f10832h.setOnTouchListener(new View.OnTouchListener() { // from class: com.anythink.expressad.mbbanner.a.d.c.7
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.f10850z = motionEvent.getRawX();
                    c.this.A = motionEvent.getRawY();
                    o.d(c.f10827c, c.this.f10850z + "  " + c.this.A);
                    return false;
                }
            });
            this.f10832h.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.mbbanner.a.d.c.8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.this.a(com.anythink.expressad.mbbanner.a.e.b.a(CommonJSBridgeImpUtils.buildClickJsonObject(c.this.f10850z, c.this.A), c.this.f10830f), false, "");
                }
            });
        }
        String strBe = this.f10830f.be();
        if (TextUtils.isEmpty(strBe)) {
            a(com.anythink.expressad.mbbanner.a.a.f10762h);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(strBe, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.mbbanner.a.d.c.9
                @Override // com.anythink.expressad.foundation.g.d.c
                public final void a(Bitmap bitmap, String str) {
                    if (c.this.f10832h != null) {
                        c.this.f10832h.setImageBitmap(bitmap);
                    }
                    c.l(c.this);
                    c.m(c.this);
                    c.this.l();
                    c.this.h();
                }

                @Override // com.anythink.expressad.foundation.g.d.c
                public final void a(String str, String str2) {
                    c.this.a(com.anythink.expressad.mbbanner.a.a.f10764j);
                }
            });
        }
    }

    private void f() {
        if (this.f10829e && this.f10834j == null) {
            this.f10834j = new ImageView(n.a().g());
            this.f10834j.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(n.a().g(), "anythink_banner_close", com.anythink.expressad.foundation.h.i.f10645c));
            this.f10834j.setVisibility(8);
            this.f10834j.setContentDescription("closeButton");
        }
    }

    private boolean g() {
        TemplateBannerView templateBannerView = this.f10831g;
        return (templateBannerView == null || y.a(templateBannerView) || this.f10840p) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        TemplateBannerView templateBannerView;
        if (this.f10837m && !this.f10838n && this.f10828d != null) {
            this.f10838n = true;
            this.f10848x.removeCallbacks(this.f10849y);
            com.anythink.expressad.foundation.d.c cVar = this.f10830f;
            if (cVar != null && !cVar.am()) {
                this.f10830f.an();
                this.f10828d.a(this.f10844t);
            }
        }
        if (this.f10837m && this.f10835k && this.f10836l && this.f10838n && this.f10830f != null && !i()) {
            TemplateBannerView templateBannerView2 = this.f10831g;
            boolean z2 = (templateBannerView2 == null || y.a(templateBannerView2) || this.f10840p) ? false : true;
            if (!z2 && (templateBannerView = this.f10831g) != null) {
                templateBannerView.postDelayed(new Runnable() { // from class: com.anythink.expressad.mbbanner.a.d.c.10
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.h();
                    }
                }, 1000L);
            }
            if (this.f10839o && z2) {
                o.d(f10827c, "onBannerWebViewShow && transInfoToMraid");
                int[] iArr = new int[2];
                this.f10831g.getLocationInWindow(iArr);
                com.anythink.expressad.mbbanner.a.a.a.a(this.f10833i, iArr[0], iArr[1]);
                com.anythink.expressad.mbbanner.a.a.a.a(this.f10833i, iArr[0], iArr[1], this.f10831g.getWidth(), this.f10831g.getHeight());
                this.f10839o = false;
                if (!TextUtils.isEmpty(this.f10830f.be())) {
                    com.anythink.expressad.foundation.g.d.b.a(n.a().g()).c(this.f10830f.be());
                }
            }
            o.d(f10827c, "showSuccessed:" + this.f10830f.aZ());
            if (!z2) {
                this.f10830f.c(false);
                return;
            }
            ImageView imageView = this.f10832h;
            if (imageView == null || imageView.getVisibility() != 0) {
                List<com.anythink.expressad.foundation.d.c> list = this.f10844t;
                if (list != null && list.size() > 0) {
                    boolean z3 = false;
                    int i2 = 0;
                    for (int i3 = 0; i3 < this.f10844t.size(); i3++) {
                        if (!this.f10844t.get(i3).s() && (i3 == 0 || !this.f10844t.get(i3).V())) {
                            c(this.f10844t.get(i3), n.a().g(), this.f10842r);
                            this.f10844t.get(i3).c(true);
                            f.a(this.f10842r, this.f10844t.get(i3), "banner");
                            i2 = i3;
                            z3 = true;
                        }
                    }
                    if (z3) {
                        b(this.f10844t.get(i2), n.a().g(), this.f10842r);
                        a(this.f10844t.get(i2), n.a().g(), this.f10842r);
                    }
                }
            } else {
                com.anythink.expressad.foundation.d.c cVar2 = this.f10830f;
                if (cVar2 != null) {
                    if (cVar2 != null) {
                        c(cVar2, n.a().g(), this.f10842r);
                        b(cVar2, n.a().g(), this.f10842r);
                        a(cVar2, n.a().g(), this.f10842r);
                    }
                    this.f10830f.c(true);
                    f.a(this.f10842r, this.f10830f, "banner");
                }
            }
            this.f10841q = true;
            com.anythink.expressad.mbbanner.a.c.c cVar3 = this.f10828d;
            if (cVar3 != null) {
                cVar3.a(this.f10830f, false);
            }
            this.f10848x.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private synchronized boolean i() {
        boolean zV;
        zV = this.f10830f.V();
        if (!zV) {
            this.f10830f.c(true);
        }
        return zV;
    }

    private void j() {
        com.anythink.expressad.mbbanner.a.c.c cVar = this.f10828d;
        if (cVar != null) {
            cVar.d();
        }
    }

    private void k() {
        if (this.f10832h != null) {
            ATBannerWebView aTBannerWebView = this.f10833i;
            if (aTBannerWebView != null) {
                aTBannerWebView.setVisibility(8);
            }
            if (this.f10832h.getVisibility() != 0) {
                this.f10832h.setVisibility(0);
            }
            if (this.f10831g != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                this.f10832h.setScaleType(ImageView.ScaleType.FIT_XY);
                if (this.f10832h.getParent() == null) {
                    this.f10831g.addView(this.f10832h, layoutParams);
                }
                d(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        ImageView imageView;
        if (!this.f10829e || (imageView = this.f10834j) == null) {
            return;
        }
        if (imageView.getVisibility() != 0) {
            this.f10834j.setVisibility(0);
            this.f10834j.setOnClickListener(this.B);
        }
        if (this.f10834j.getParent() != null || this.f10831g == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(t.b(n.a().g(), 12.0f), t.b(n.a().g(), 12.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        this.f10831g.addView(this.f10834j, layoutParams);
    }

    public final void b(boolean z2) {
        this.f10835k = z2;
        h();
    }

    public final void c(boolean z2) {
        this.f10836l = z2;
        h();
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            c(cVar, n.a().g(), this.f10842r);
            b(cVar, n.a().g(), this.f10842r);
            a(cVar, n.a().g(), this.f10842r);
        }
    }

    private static void c(com.anythink.expressad.foundation.d.c cVar, Context context, String str) {
        if (!TextUtils.isEmpty(cVar.ag())) {
            com.anythink.expressad.a.a.a(context, cVar, str, cVar.ag(), false, true, com.anythink.expressad.a.a.a.f8006i);
        }
        if (TextUtils.isEmpty(str) || cVar.L() == null || cVar.L().o() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, str, cVar.L().o(), false);
    }

    public final void a(i iVar) {
        this.b = iVar;
    }

    static /* synthetic */ void m(c cVar) {
        if (cVar.f10832h != null) {
            ATBannerWebView aTBannerWebView = cVar.f10833i;
            if (aTBannerWebView != null) {
                aTBannerWebView.setVisibility(8);
            }
            if (cVar.f10832h.getVisibility() != 0) {
                cVar.f10832h.setVisibility(0);
            }
            if (cVar.f10831g != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                cVar.f10832h.setScaleType(ImageView.ScaleType.FIT_XY);
                if (cVar.f10832h.getParent() == null) {
                    cVar.f10831g.addView(cVar.f10832h, layoutParams);
                }
                cVar.d(true);
            }
        }
    }

    public final void a(boolean z2, int i2) {
        this.f10845u = i2;
        if (i2 == 0) {
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.c cVarC = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.f10842r);
            if (cVarC == null) {
                return;
            } else {
                z2 = cVarC.d() == 1;
            }
        }
        this.f10829e = z2;
    }

    private static void b(com.anythink.expressad.foundation.d.c cVar, Context context, String str) {
        if (cVar != null) {
            try {
                if (TextUtils.isEmpty(cVar.ai())) {
                    return;
                }
                com.anythink.expressad.a.a.a(context, cVar, str, cVar.ai(), false, true, com.anythink.expressad.a.a.a.f8007j);
            } catch (Throwable th) {
                o.d(f10827c, th.getMessage());
            }
        }
    }

    static /* synthetic */ void c(c cVar) {
        ImageView imageView;
        if (cVar.f10829e && (imageView = cVar.f10834j) != null && imageView.getVisibility() == 0) {
            cVar.f10834j.setVisibility(8);
            cVar.f10834j.setOnClickListener(null);
            if (cVar.f10831g == null || cVar.f10834j.getParent() == null) {
                return;
            }
            cVar.f10831g.removeView(cVar.f10834j);
        }
    }

    private com.anythink.expressad.foundation.d.c b(d dVar) {
        if (dVar != null) {
            this.f10844t = dVar.J;
            List<com.anythink.expressad.foundation.d.c> list = this.f10844t;
            if (list != null && list.size() > 0) {
                return this.f10844t.get(0);
            }
        }
        return null;
    }

    public final void a(boolean z2) {
        this.f10829e = z2;
    }

    private static String a(com.anythink.expressad.foundation.d.c cVar) throws Throwable {
        String strConcat;
        if (cVar == null) {
            return "";
        }
        String strB = j.a().b(cVar.p());
        if (TextUtils.isEmpty(strB)) {
            strB = cVar.q();
            if (cVar.ay()) {
                try {
                    File file = new File(strB);
                    if (!file.exists()) {
                        return "";
                    }
                    strConcat = m.a(file);
                } catch (Exception unused) {
                    File file2 = new File(strB);
                    if (file2.exists() && file2.isFile() && file2.canRead()) {
                        strConcat = "file:////".concat(String.valueOf(strB));
                    }
                    return strB;
                }
                return strConcat;
            }
            File file3 = new File(strB);
            if (file3.exists() && file3.isFile() && file3.canRead()) {
                return "file:////".concat(String.valueOf(strB));
            }
        }
        return strB;
    }

    static /* synthetic */ void b(c cVar) {
        com.anythink.expressad.mbbanner.a.c.c cVar2 = cVar.f10828d;
        if (cVar2 != null) {
            cVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.f10830f == null || i()) {
            return;
        }
        this.f10848x.removeCallbacks(this.f10849y);
        com.anythink.expressad.mbbanner.a.c.c cVar = this.f10828d;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void d(boolean z2) {
        if (this.f10831g != null) {
            FeedBackButton feedBackButtonB = com.anythink.expressad.foundation.f.b.a().b(this.f10842r);
            if (com.anythink.expressad.foundation.f.b.a().b() && z2 && feedBackButtonB != null) {
                ViewGroup viewGroup = (ViewGroup) feedBackButtonB.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(feedBackButtonB);
                }
                feedBackButtonB.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) feedBackButtonB.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(com.anythink.expressad.foundation.f.b.a, com.anythink.expressad.foundation.f.b.b);
                }
                layoutParams.addRule(12);
                feedBackButtonB.setLayoutParams(layoutParams);
                this.f10831g.addView(feedBackButtonB);
            }
            com.anythink.expressad.foundation.f.b.a().a(this.f10842r, new com.anythink.expressad.foundation.f.a() { // from class: com.anythink.expressad.mbbanner.a.d.c.3
                @Override // com.anythink.expressad.foundation.f.a
                public final void a() {
                    String string;
                    c.this.f10831g.onPause();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (n.a().g() != null) {
                            jSONObject.put("status", 1);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        o.b(c.f10827c, th.getMessage(), th);
                        string = "";
                    }
                    String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) c.this.f10833i, AbsFeedBackForH5.a, strEncodeToString);
                }

                @Override // com.anythink.expressad.foundation.f.a
                public final void b() {
                    String string;
                    c.this.f10831g.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (n.a().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        o.b(c.f10827c, th.getMessage(), th);
                        string = "";
                    }
                    String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) c.this.f10833i, AbsFeedBackForH5.a, strEncodeToString);
                }

                @Override // com.anythink.expressad.foundation.f.a
                public final void c() {
                    String string;
                    c.this.f10831g.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (n.a().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        o.b(c.f10827c, th.getMessage(), th);
                        string = "";
                    }
                    String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((WebView) c.this.f10833i, AbsFeedBackForH5.a, strEncodeToString);
                }
            });
            this.f10830f.l(this.f10842r);
            com.anythink.expressad.foundation.f.b.a().a(this.f10842r, this.f10830f);
        }
    }

    public final void a() {
        if (this.f10828d != null) {
            this.f10828d = null;
        }
        ATBannerWebView aTBannerWebView = this.f10833i;
        if (aTBannerWebView != null) {
            aTBannerWebView.setWebViewListener(null);
        }
        if (this.D != null) {
            this.D = null;
        }
        ImageView imageView = this.f10834j;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        ImageView imageView2 = this.f10832h;
        if (imageView2 != null) {
            imageView2.setOnClickListener(null);
        }
        TemplateBannerView templateBannerView = this.f10831g;
        if (templateBannerView != null) {
            templateBannerView.removeAllViews();
        }
        ATBannerWebView aTBannerWebView2 = this.f10833i;
        if (aTBannerWebView2 != null) {
            aTBannerWebView2.release();
        }
        com.anythink.expressad.mbbanner.a.a.c cVar = this.f10847w;
        if (cVar != null) {
            cVar.a();
        }
        if (this.C != null) {
            this.C = null;
        }
        com.anythink.expressad.foundation.f.b.a().c(this.f10842r);
    }

    private static void a(com.anythink.expressad.foundation.d.c cVar, Context context, String str) {
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
                o.d(f10827c, th.getMessage());
            }
        }
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z2, String str) {
        if (this.f10841q) {
            if (this.a == null) {
                this.a = new com.anythink.expressad.a.a(n.a().g(), this.f10842r);
            }
            this.a.a(new p.e() { // from class: com.anythink.expressad.mbbanner.a.d.c.11
                @Override // com.anythink.expressad.out.p.c
                public final void a(int i2) {
                }

                @Override // com.anythink.expressad.out.p.c
                public final void a(com.anythink.expressad.foundation.d.c cVar2, String str2) {
                }

                @Override // com.anythink.expressad.out.p.c
                public final void a(com.anythink.expressad.out.j jVar) {
                }

                @Override // com.anythink.expressad.out.p.c
                public final void a(com.anythink.expressad.out.j jVar, String str2) {
                }

                @Override // com.anythink.expressad.out.p.c
                public final boolean a() {
                    return false;
                }

                @Override // com.anythink.expressad.out.p.e
                public final void b() {
                    if (c.this.f10828d != null) {
                        c.this.f10828d.a();
                    }
                }

                @Override // com.anythink.expressad.out.p.c
                public final void b(com.anythink.expressad.out.j jVar) {
                }

                @Override // com.anythink.expressad.out.p.c
                public final void b(com.anythink.expressad.out.j jVar, String str2) {
                }

                @Override // com.anythink.expressad.out.p.c
                public final void c(com.anythink.expressad.out.j jVar) {
                }

                @Override // com.anythink.expressad.out.p.c
                public final void d(com.anythink.expressad.out.j jVar) {
                }
            });
            cVar.l(this.f10842r);
            if (!this.f10830f.W()) {
                this.f10830f.X();
            }
            com.anythink.expressad.mbbanner.a.c.c cVar2 = this.f10828d;
            if (cVar2 != null) {
                cVar2.a(cVar);
            }
            if (z2) {
                TextUtils.isEmpty(str);
            }
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        if (i2 == i4 && i3 == i5) {
            return;
        }
        ATBannerWebView aTBannerWebView = this.f10833i;
        o.d("BannerCallJS", "fireOnBannerViewSizeChange");
        try {
            CallMraidJS.getInstance().fireSizeChangeEvent(aTBannerWebView, i2, i3);
        } catch (Throwable th) {
            o.b("BannerCallJS", "fireOnBannerViewSizeChange", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.anythink.expressad.foundation.d.d r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.mbbanner.a.d.c.a(com.anythink.expressad.foundation.d.d):void");
    }
}
