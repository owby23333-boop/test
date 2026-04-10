package com.anythink.expressad.advanced.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.expressad.advanced.d.d;
import com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.advanced.view.ATNativeAdvancedView;
import com.anythink.expressad.advanced.view.ATNativeAdvancedWebview;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.y;
import com.anythink.expressad.widget.FeedBackButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.anythink.expressad.foundation.d.c f8174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ATNativeAdvancedView f8175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d f8176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.anythink.expressad.a.a f8177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.anythink.expressad.advanced.d.c f8178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f8179h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f8181j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f8182k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f8183l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f8184m;
    private String b = "NativeAdvancedShowManager";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8180i = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View.OnClickListener f8185n = new View.OnClickListener() { // from class: com.anythink.expressad.advanced.c.b.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (b.this.f8179h) {
                b.b(b.this);
            }
        }
    };
    public Handler a = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.advanced.c.b.2
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 2 && b.this.f8174c != null && b.this.f8174c.ay() && b.this.f8175d != null) {
                b.this.f8175d.getAdvancedNativeWebview();
            }
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.anythink.expressad.advanced.d.a f8186o = new com.anythink.expressad.advanced.d.a() { // from class: com.anythink.expressad.advanced.c.b.3
        @Override // com.anythink.expressad.advanced.d.a
        public final void a(int i2) {
            b.this.f8180i = i2;
            if (b.this.f8175d != null) {
                b.this.f8175d.changeCloseBtnState(i2);
            }
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void b() {
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void b(int i2) {
            o.d(b.this.b, "resetCountdown".concat(String.valueOf(i2)));
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void c() {
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void d() {
            b.b(b.this);
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void a() {
            if (b.this.f8175d != null) {
                b.this.f8175d.setVisibility(8);
            }
            b.b(b.this);
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            b.this.a(cVar);
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void a(boolean z2) {
            if (b.this.f8176e != null) {
                b.this.f8184m = z2;
                if (z2) {
                    d unused = b.this.f8176e;
                } else {
                    d unused2 = b.this.f8176e;
                }
            }
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void a(String str) {
            try {
                if (b.this.f8176e != null) {
                    if (TextUtils.isEmpty(str)) {
                        b.this.f8176e.a(b.this.f8174c);
                        d unused = b.this.f8176e;
                    } else {
                        com.anythink.expressad.foundation.d.c cVarB = com.anythink.expressad.foundation.d.c.b(com.anythink.expressad.foundation.d.c.a(b.this.f8174c));
                        cVarB.p(str);
                        b.this.a(cVarB);
                    }
                }
            } catch (Exception e2) {
                o.d(b.this.b, e2.getMessage());
            }
        }
    };

    public b(Context context, String str, String str2) {
        this.f8182k = str2;
        this.f8183l = str;
        if (this.f8181j == null) {
            this.f8181j = new ImageView(context);
            this.f8181j.setPadding(t.b(context, 2.0f), t.b(context, 2.0f), t.b(context, 2.0f), t.b(context, 2.0f));
            Context contextG = n.a().g();
            this.f8181j.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f8181j.getLayoutParams();
            this.f8181j.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(t.b(contextG, 29.0f), t.b(contextG, 16.0f)) : layoutParams);
            this.f8181j.setImageResource(contextG.getResources().getIdentifier("anythink_native_advanced_close_icon", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
        }
    }

    private void g() {
        if (this.f8174c.V()) {
            return;
        }
        boolean z2 = true;
        this.f8174c.c(true);
        com.anythink.expressad.foundation.d.c cVar = this.f8174c;
        if (cVar.s()) {
            z2 = false;
        } else {
            Context contextG = n.a().g();
            String str = this.f8182k;
            com.anythink.expressad.foundation.b.a.b().b(contextG);
            if (!TextUtils.isEmpty(cVar.ag())) {
                com.anythink.expressad.a.a.a(contextG, cVar, str, cVar.ag(), false, true, com.anythink.expressad.a.a.a.f8006i);
            }
            if (!TextUtils.isEmpty(str) && cVar.L() != null && cVar.L().o() != null) {
                com.anythink.expressad.a.a.a(contextG, cVar, str, cVar.L().o(), false);
            }
            cVar.c(true);
            f.a(this.f8182k, cVar, f.f10441g);
        }
        if (z2) {
            b(cVar, n.a().g(), this.f8182k);
            a(cVar, n.a().g(), this.f8182k);
        }
        d dVar = this.f8176e;
        if (dVar != null) {
            dVar.a();
        }
    }

    private static void h() {
    }

    private void i() {
        d dVar = this.f8176e;
        if (dVar != null) {
            dVar.c();
            this.f8176e = null;
        }
    }

    private static /* synthetic */ void j() {
    }

    public final com.anythink.expressad.advanced.d.a b() {
        return this.f8186o;
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        boolean z2 = true;
        if (cVar.s()) {
            z2 = false;
        } else {
            Context contextG = n.a().g();
            String str = this.f8182k;
            com.anythink.expressad.foundation.b.a.b().b(contextG);
            if (!TextUtils.isEmpty(cVar.ag())) {
                com.anythink.expressad.a.a.a(contextG, cVar, str, cVar.ag(), false, true, com.anythink.expressad.a.a.a.f8006i);
            }
            if (!TextUtils.isEmpty(str) && cVar.L() != null && cVar.L().o() != null) {
                com.anythink.expressad.a.a.a(contextG, cVar, str, cVar.L().o(), false);
            }
            cVar.c(true);
            f.a(this.f8182k, cVar, f.f10441g);
        }
        if (z2) {
            b(cVar, n.a().g(), this.f8182k);
            a(cVar, n.a().g(), this.f8182k);
        }
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

    private void f() {
        Context contextG = n.a().g();
        this.f8181j.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f8181j.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(t.b(contextG, 29.0f), t.b(contextG, 16.0f));
        }
        this.f8181j.setLayoutParams(layoutParams);
        this.f8181j.setImageResource(contextG.getResources().getIdentifier("anythink_native_advanced_close_icon", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
    }

    public final void d() {
        ATNativeAdvancedWebview advancedNativeWebview;
        if (this.f8175d == null || com.anythink.expressad.foundation.f.b.f10401c || (advancedNativeWebview = this.f8175d.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestroyed()) {
            return;
        }
        NativeAdvancedJsUtils.sendEventToH5(advancedNativeWebview, NativeAdvancedJsUtils.b, "");
    }

    public final void e() {
        ATNativeAdvancedWebview advancedNativeWebview;
        ATNativeAdvancedView aTNativeAdvancedView = this.f8175d;
        if (aTNativeAdvancedView == null || (advancedNativeWebview = aTNativeAdvancedView.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestroyed()) {
            return;
        }
        j.a();
        j.a((WebView) advancedNativeWebview, NativeAdvancedJsUtils.a, "");
    }

    public final void a(com.anythink.expressad.advanced.d.c cVar) {
        this.f8178g = cVar;
    }

    public final void a(d dVar) {
        this.f8176e = dVar;
    }

    public final String a() {
        com.anythink.expressad.foundation.d.c cVar = this.f8174c;
        return (cVar == null || cVar.Z() == null) ? "" : this.f8174c.Z();
    }

    public final void c() {
        if (this.f8176e != null) {
            this.f8176e = null;
        }
        if (this.f8186o != null) {
            this.f8186o = null;
        }
        if (this.f8185n != null) {
            this.f8185n = null;
        }
        ATNativeAdvancedView aTNativeAdvancedView = this.f8175d;
        if (aTNativeAdvancedView != null) {
            aTNativeAdvancedView.destroy();
        }
        if (this.f8178g != null) {
            this.f8178g = null;
        }
        com.anythink.expressad.foundation.f.b.a().c(this.f8182k);
    }

    public final void a(final com.anythink.expressad.foundation.d.c cVar, final ATNativeAdvancedView aTNativeAdvancedView, boolean z2) {
        FeedBackButton feedBackButtonB;
        if (aTNativeAdvancedView == null) {
            return;
        }
        com.anythink.expressad.foundation.f.b.a().a(this.f8182k, new com.anythink.expressad.foundation.f.a() { // from class: com.anythink.expressad.advanced.c.b.4
            @Override // com.anythink.expressad.foundation.f.a
            public final void a() {
                String string;
                b.this.e();
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (n.a().g() != null) {
                        jSONObject.put("status", 1);
                    }
                    string = jSONObject.toString();
                } catch (Throwable th) {
                    o.b(b.this.b, th.getMessage(), th);
                    string = "";
                }
                String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
                j.a();
                j.a((WebView) aTNativeAdvancedView.getAdvancedNativeWebview(), AbsFeedBackForH5.a, strEncodeToString);
            }

            @Override // com.anythink.expressad.foundation.f.a
            public final void b() {
                String string;
                b.this.d();
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (n.a().g() != null) {
                        jSONObject.put("status", 2);
                    }
                    string = jSONObject.toString();
                } catch (Throwable th) {
                    o.b(b.this.b, th.getMessage(), th);
                    string = "";
                }
                String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
                j.a();
                j.a((WebView) aTNativeAdvancedView.getAdvancedNativeWebview(), AbsFeedBackForH5.a, strEncodeToString);
            }

            @Override // com.anythink.expressad.foundation.f.a
            public final void c() {
                String string;
                b.this.d();
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (n.a().g() != null) {
                        jSONObject.put("status", 2);
                    }
                    string = jSONObject.toString();
                } catch (Throwable th) {
                    o.b(b.this.b, th.getMessage(), th);
                    string = "";
                }
                String strEncodeToString = Base64.encodeToString(string.getBytes(), 2);
                j.a();
                j.a((WebView) aTNativeAdvancedView.getAdvancedNativeWebview(), AbsFeedBackForH5.a, strEncodeToString);
            }
        });
        if (cVar.H() && com.anythink.expressad.foundation.f.b.a().b() && (feedBackButtonB = com.anythink.expressad.foundation.f.b.a().b(this.f8182k)) != null) {
            RelativeLayout.LayoutParams layoutParams = null;
            try {
                layoutParams = (RelativeLayout.LayoutParams) feedBackButtonB.getLayoutParams();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(com.anythink.expressad.foundation.f.b.a, com.anythink.expressad.foundation.f.b.b);
            }
            layoutParams.addRule(12);
            ViewGroup viewGroup = (ViewGroup) feedBackButtonB.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(feedBackButtonB);
            }
            aTNativeAdvancedView.addView(feedBackButtonB, layoutParams);
        }
        this.f8179h = this.f8179h;
        this.f8174c = cVar;
        this.f8175d = aTNativeAdvancedView;
        NativeAdvancedJSBridgeImpl advancedNativeJSBridgeImpl = aTNativeAdvancedView.getAdvancedNativeJSBridgeImpl();
        if (advancedNativeJSBridgeImpl == null) {
            advancedNativeJSBridgeImpl = new NativeAdvancedJSBridgeImpl(aTNativeAdvancedView.getContext(), this.f8183l, this.f8182k);
            List<com.anythink.expressad.foundation.d.c> arrayList = new ArrayList<>();
            arrayList.add(cVar);
            advancedNativeJSBridgeImpl.setCampaignList(arrayList);
        }
        advancedNativeJSBridgeImpl.setAllowSkip(this.f8179h ? 1 : 0);
        advancedNativeJSBridgeImpl.setNativeAdvancedBridgeListener(this.f8186o);
        aTNativeAdvancedView.setAdvancedNativeJSBridgeImpl(advancedNativeJSBridgeImpl);
        if (cVar.s() || !this.f8179h) {
            this.f8181j.setVisibility(8);
        }
        ImageView imageView = this.f8181j;
        if (imageView != null) {
            imageView.setOnClickListener(this.f8185n);
        }
        aTNativeAdvancedView.setCloseView(this.f8181j);
        if (aTNativeAdvancedView.getVisibility() != 0) {
            aTNativeAdvancedView.setVisibility(0);
        }
        boolean zA = y.a(aTNativeAdvancedView.getAdvancedNativeWebview());
        com.anythink.expressad.advanced.d.c cVar2 = this.f8178g;
        if (cVar2 == null || zA || cVar2.c() == null || this.f8178g.c().getAlpha() < 0.5f || this.f8178g.c().getVisibility() != 0 || this.f8184m) {
            if (z2) {
                aTNativeAdvancedView.postDelayed(new Runnable() { // from class: com.anythink.expressad.advanced.c.b.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.a(cVar, aTNativeAdvancedView, false);
                    }
                }, 200L);
                return;
            }
            return;
        }
        aTNativeAdvancedView.show();
        com.anythink.expressad.foundation.b.a.b().b(aTNativeAdvancedView.getContext());
        cVar.l(this.f8182k);
        com.anythink.expressad.foundation.f.b.a().a(this.f8182k, cVar);
        com.anythink.expressad.foundation.d.c cVar3 = this.f8174c;
        if (cVar3 != null && cVar3.ay() && aTNativeAdvancedView != null) {
            aTNativeAdvancedView.getAdvancedNativeWebview();
            try {
                com.anythink.expressad.advanced.a.a.c(cVar.Z());
            } catch (Throwable th) {
                o.a("OMSDK", th.getMessage());
                com.anythink.expressad.foundation.d.c cVar4 = this.f8174c;
                if (cVar4 != null) {
                    cVar4.Z();
                    this.f8174c.aa();
                    this.f8174c.aZ();
                }
            }
        }
        if (!this.f8174c.V()) {
            boolean z3 = true;
            this.f8174c.c(true);
            com.anythink.expressad.foundation.d.c cVar5 = this.f8174c;
            if (cVar5.s()) {
                z3 = false;
            } else {
                Context contextG = n.a().g();
                String str = this.f8182k;
                com.anythink.expressad.foundation.b.a.b().b(contextG);
                if (!TextUtils.isEmpty(cVar5.ag())) {
                    com.anythink.expressad.a.a.a(contextG, cVar5, str, cVar5.ag(), false, true, com.anythink.expressad.a.a.a.f8006i);
                }
                if (!TextUtils.isEmpty(str) && cVar5.L() != null && cVar5.L().o() != null) {
                    com.anythink.expressad.a.a.a(contextG, cVar5, str, cVar5.L().o(), false);
                }
                cVar5.c(true);
                f.a(this.f8182k, cVar5, f.f10441g);
            }
            if (z3) {
                b(cVar5, n.a().g(), this.f8182k);
                a(cVar5, n.a().g(), this.f8182k);
            }
            d dVar = this.f8176e;
            if (dVar != null) {
                dVar.a();
            }
        }
        int i2 = this.f8180i;
        if (i2 != -1) {
            aTNativeAdvancedView.changeCloseBtnState(i2);
        }
        com.anythink.expressad.advanced.a.a.c(cVar.Z());
        this.a.sendEmptyMessageDelayed(2, 1000L);
    }

    private void b(com.anythink.expressad.foundation.d.c cVar, Context context, String str) {
        if (cVar != null) {
            try {
                if (TextUtils.isEmpty(cVar.ai())) {
                    return;
                }
                com.anythink.expressad.a.a.a(context, cVar, str, cVar.ai(), false, true, com.anythink.expressad.a.a.a.f8007j);
            } catch (Throwable th) {
                o.d(this.b, th.getMessage());
            }
        }
    }

    static /* synthetic */ void b(b bVar) {
        d dVar = bVar.f8176e;
        if (dVar != null) {
            dVar.c();
            bVar.f8176e = null;
        }
    }

    public final void a(boolean z2) {
        this.f8179h = z2;
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        cVar.l(this.f8182k);
        d dVar = this.f8176e;
        if (dVar != null) {
            dVar.a(cVar);
        }
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(this.f8185n);
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
                o.d(this.b, th.getMessage());
            }
        }
    }
}
