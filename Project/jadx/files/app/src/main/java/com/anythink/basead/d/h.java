package com.anythink.basead.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.anythink.basead.a.a;
import com.anythink.basead.a.c;
import com.anythink.basead.ui.BaseMediaAdView;
import com.anythink.basead.ui.MediaAdView;
import com.anythink.basead.ui.MraidMediaView;
import com.anythink.basead.ui.OwnNativeAdView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.z;
import com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup;
import com.anythink.expressad.out.o;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class h {
    Context a;
    com.anythink.basead.e.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    com.anythink.core.common.k.a.c f6011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    com.anythink.basead.a.c f6012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    View f6013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f6014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    aa f6015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    j f6016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f6017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String f6018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    com.anythink.expressad.advanced.d.c f6019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    BaseMediaAdView f6020l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f6022n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f6023o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    com.anythink.basead.a.a f6024p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    OwnNativeAdView f6025q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f6026r = h.class.getSimpleName();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    View.OnClickListener f6021m = new View.OnClickListener() { // from class: com.anythink.basead.d.h.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            h.this.a(view, 1);
        }
    };

    private static class a implements BaseMediaAdView.a {
        private final BaseMediaAdView.a a;

        public a(BaseMediaAdView.a aVar) {
            this.a = aVar;
        }

        @Override // com.anythink.basead.ui.BaseMediaAdView.a
        public final void onClickCloseView() {
            BaseMediaAdView.a aVar = this.a;
            if (aVar != null) {
                aVar.onClickCloseView();
            }
        }
    }

    public h(Context context, aa aaVar, j jVar, com.anythink.core.common.a.g gVar) {
        this.a = context.getApplicationContext();
        this.f6015g = aaVar;
        this.f6016h = jVar;
        if (gVar instanceof com.anythink.expressad.advanced.d.c) {
            this.f6019k = (com.anythink.expressad.advanced.d.c) gVar;
            this.f6019k.a(new o() { // from class: com.anythink.basead.d.h.3
                @Override // com.anythink.expressad.out.o
                public final void a() {
                }

                @Override // com.anythink.expressad.out.o
                public final void a(com.anythink.expressad.foundation.d.c cVar) {
                    Context contextG = n.a().g();
                    h hVar = h.this;
                    if (hVar.f6012d == null) {
                        hVar.f6012d = new com.anythink.basead.a.c(contextG, hVar.f6016h, hVar.f6015g);
                        h.this.f6012d.a(new c.b() { // from class: com.anythink.basead.d.h.3.1
                            @Override // com.anythink.basead.a.c.b
                            public final void a() {
                                com.anythink.basead.e.a aVar = h.this.b;
                                if (aVar != null) {
                                    aVar.onAdClick(1);
                                }
                            }

                            @Override // com.anythink.basead.a.c.b
                            public final void b() {
                            }

                            @Override // com.anythink.basead.a.c.b
                            public final void a(boolean z2) {
                                com.anythink.basead.e.a aVar = h.this.b;
                                if (aVar != null) {
                                    aVar.onDeeplinkCallback(z2);
                                }
                            }
                        });
                    }
                    com.anythink.basead.d.a.b.a(h.this.f6012d.b(), cVar);
                    com.anythink.expressad.advanced.d.c cVar2 = h.this.f6019k;
                    ATOutNativeAdvancedViewGroup aTOutNativeAdvancedViewGroupC = cVar2 != null ? cVar2.c() : null;
                    com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(h.this.f6016h.f7303d, "");
                    if (aTOutNativeAdvancedViewGroupC != null) {
                        iVar.f5934f = aTOutNativeAdvancedViewGroupC.getHeight();
                        iVar.f5933e = aTOutNativeAdvancedViewGroupC.getWidth();
                    }
                    iVar.f5935g = new com.anythink.basead.c.a();
                    h.this.f6012d.a(iVar);
                }

                @Override // com.anythink.expressad.out.o
                public final void a(String str) {
                }

                @Override // com.anythink.expressad.out.o
                public final void b() {
                    com.anythink.basead.e.a aVar = h.this.b;
                    if (aVar != null) {
                        aVar.onAdShow();
                    }
                }

                @Override // com.anythink.expressad.out.o
                public final void c() {
                }

                @Override // com.anythink.expressad.out.o
                public final void d() {
                }

                @Override // com.anythink.expressad.out.o
                public final void e() {
                }

                @Override // com.anythink.expressad.out.o
                public final void f() {
                    com.anythink.basead.e.a aVar = h.this.b;
                    if (aVar != null) {
                        aVar.onAdClosed();
                    }
                }
            });
        }
    }

    private static com.anythink.basead.c.a c(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        int iA = a(width);
        int iA2 = a(height);
        com.anythink.basead.c.a aVar = new com.anythink.basead.c.a();
        aVar.a = i2 + iA;
        aVar.b = i3 + iA2;
        aVar.f5888e = iA;
        aVar.f5889f = iA2;
        aVar.f5886c = aVar.a + ((int) (Math.random() * 15.0d));
        aVar.f5887d = aVar.b + ((int) (Math.random() * 15.0d));
        aVar.f5890g = aVar.f5886c - i2;
        aVar.f5891h = aVar.f5887d - i3;
        return aVar;
    }

    private void m() {
        com.anythink.basead.a.a aVar = this.f6024p;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void n() {
        com.anythink.basead.a.a aVar = this.f6024p;
        if (aVar != null) {
            aVar.b();
            this.f6024p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f6014f) {
            return;
        }
        this.f6014f = true;
        if (this.f6017i && this.f6015g.g()) {
            BaseMediaAdView baseMediaAdView = this.f6020l;
            if (baseMediaAdView instanceof MraidMediaView) {
                ((MraidMediaView) baseMediaAdView).fireAudioVolumeChange(this.f6017i);
            }
        }
        if (this.f6015g instanceof z) {
            com.anythink.basead.d.c.c cVarA = com.anythink.basead.d.c.c.a();
            Context context = this.a;
            j jVar = this.f6016h;
            cVarA.a(context, com.anythink.basead.d.c.c.a(jVar.b, jVar.f7302c), this.f6015g, this.f6016h.f7312m);
        }
        com.anythink.expressad.advanced.d.c cVar = this.f6019k;
        View viewC = cVar != null ? cVar.c() : this.f6025q;
        if (this.f6015g.g()) {
            viewC = this.f6020l;
        }
        if (viewC != null) {
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(this.f6016h.f7303d, "");
            iVar.f5934f = viewC.getHeight();
            iVar.f5933e = viewC.getWidth();
            com.anythink.basead.a.b.a(8, this.f6015g, iVar);
            com.anythink.basead.e.a aVar = this.b;
            if (aVar != null) {
                aVar.onAdShow();
            }
        }
        m();
    }

    private View p() {
        View monitorClickView;
        BaseMediaAdView baseMediaAdView = this.f6020l;
        if (baseMediaAdView != null && (monitorClickView = baseMediaAdView.getMonitorClickView()) != null) {
            return monitorClickView;
        }
        View[] viewArr = new View[1];
        a(this.f6025q, viewArr);
        return viewArr[0] != null ? viewArr[0] : this.f6025q;
    }

    private void q() {
        k kVar;
        j jVar = this.f6016h;
        if (jVar == null || (kVar = jVar.f7312m) == null || kVar.F() != 2) {
            return;
        }
        final View viewP = p();
        this.f6024p = new com.anythink.basead.a.a(viewP, this.f6016h, new a.InterfaceC0128a() { // from class: com.anythink.basead.d.h.6
            @Override // com.anythink.basead.a.a.InterfaceC0128a
            public final void a(int i2) {
                h.this.a(viewP, 2);
            }
        });
    }

    public final String b() {
        aa aaVar = this.f6015g;
        return aaVar != null ? aaVar.r() : "";
    }

    public final String d() {
        aa aaVar = this.f6015g;
        return aaVar != null ? aaVar.w() : "";
    }

    public final String e() {
        aa aaVar = this.f6015g;
        return aaVar != null ? aaVar.t() : "";
    }

    public final String f() {
        aa aaVar = this.f6015g;
        return aaVar != null ? aaVar.u() : "";
    }

    public final String g() {
        aa aaVar = this.f6015g;
        return aaVar != null ? aaVar.v() : "";
    }

    public final boolean h() {
        return this.f6019k != null;
    }

    public final void i() {
        com.anythink.core.common.k.a.c cVar = this.f6011c;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void j() {
        i();
        n();
        this.f6013e = null;
        this.f6025q = null;
        this.b = null;
        try {
            if (this.f6019k != null) {
                this.f6019k.e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.anythink.basead.a.c cVar = this.f6012d;
        if (cVar != null) {
            cVar.d();
            this.f6012d = null;
        }
        com.anythink.core.common.k.a.c cVar2 = this.f6011c;
        if (cVar2 != null) {
            cVar2.b();
            this.f6011c = null;
        }
        BaseMediaAdView baseMediaAdView = this.f6020l;
        if (baseMediaAdView != null) {
            baseMediaAdView.destroy();
        }
    }

    public final void k() {
        com.anythink.expressad.advanced.d.c cVar = this.f6019k;
        if (cVar != null) {
            cVar.d(3);
        }
    }

    public final void l() {
        com.anythink.expressad.advanced.d.c cVar = this.f6019k;
        if (cVar != null) {
            cVar.e(3);
        }
    }

    final void a(View view, final int i2) {
        com.anythink.basead.c.a adClickRecord;
        if (this.f6025q != null) {
            n();
            o();
            if (this.f6012d == null) {
                this.f6012d = new com.anythink.basead.a.c(n.a().g(), this.f6016h, this.f6015g);
            }
            if (this.f6012d.a()) {
                return;
            }
            this.f6012d.a(new c.b() { // from class: com.anythink.basead.d.h.2
                @Override // com.anythink.basead.a.c.b
                public final void a() {
                    BaseMediaAdView baseMediaAdView = h.this.f6020l;
                    if (baseMediaAdView != null) {
                        baseMediaAdView.notifyClick();
                    }
                    com.anythink.basead.e.a aVar = h.this.b;
                    if (aVar != null) {
                        aVar.onAdClick(i2);
                    }
                }

                @Override // com.anythink.basead.a.c.b
                public final void b() {
                }

                @Override // com.anythink.basead.a.c.b
                public final void a(boolean z2) {
                    com.anythink.basead.e.a aVar = h.this.b;
                    if (aVar != null) {
                        aVar.onDeeplinkCallback(z2);
                    }
                }
            });
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(this.f6016h.f7303d, "");
            iVar.f5934f = this.f6025q.getHeight();
            iVar.f5933e = this.f6025q.getWidth();
            if (i2 != 2) {
                adClickRecord = this.f6025q.getAdClickRecord();
            } else if (view == null) {
                adClickRecord = null;
            } else {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int i3 = iArr[0];
                int i4 = iArr[1];
                int width = view.getWidth();
                int height = view.getHeight();
                int iA = a(width);
                int iA2 = a(height);
                com.anythink.basead.c.a aVar = new com.anythink.basead.c.a();
                aVar.a = i3 + iA;
                aVar.b = i4 + iA2;
                aVar.f5888e = iA;
                aVar.f5889f = iA2;
                aVar.f5886c = aVar.a + ((int) (Math.random() * 15.0d));
                aVar.f5887d = aVar.b + ((int) (Math.random() * 15.0d));
                aVar.f5890g = aVar.f5886c - i3;
                aVar.f5891h = aVar.f5887d - i4;
                adClickRecord = aVar;
            }
            iVar.f5935g = adClickRecord;
            this.f6012d.a(iVar);
        }
    }

    private View b(Context context, boolean z2, boolean z3, BaseMediaAdView.a aVar) {
        a aVar2 = new a(aVar);
        OwnNativeAdView ownNativeAdView = new OwnNativeAdView(this.a);
        if (z2) {
            this.f6025q = ownNativeAdView;
            this.f6020l = new MraidMediaView(context, this.f6015g, this.f6016h, z3, aVar2);
            ((MraidMediaView) this.f6020l).setMraidWebViewListener(new MraidMediaView.a() { // from class: com.anythink.basead.d.h.4
                @Override // com.anythink.basead.ui.MraidMediaView.a
                public final void a(String str) {
                    aa aaVar = h.this.f6015g;
                    if (aaVar != null) {
                        aaVar.v(str);
                    }
                    h hVar = h.this;
                    hVar.a(hVar.f6020l, 1);
                }

                @Override // com.anythink.basead.ui.MraidMediaView.a
                public final void a() {
                    h hVar = h.this;
                    OwnNativeAdView ownNativeAdView2 = hVar.f6025q;
                    if (ownNativeAdView2 != null) {
                        hVar.b(ownNativeAdView2);
                    }
                }
            });
        } else {
            this.f6020l = new MediaAdView(context, this.f6015g, this.f6016h, z3, aVar2);
        }
        this.f6020l.init(this.f6022n, this.f6023o);
        BaseMediaAdView baseMediaAdView = this.f6020l;
        ownNativeAdView.addView(baseMediaAdView, new FrameLayout.LayoutParams(baseMediaAdView.getMediaViewWidth(), this.f6020l.getMediaViewHeight()));
        if (z2) {
            q();
        } else {
            a(ownNativeAdView, this.f6020l.getClickViews());
        }
        return ownNativeAdView;
    }

    private boolean d(View view) {
        OwnNativeAdView[] ownNativeAdViewArr = new OwnNativeAdView[1];
        a(ownNativeAdViewArr, view);
        if (ownNativeAdViewArr[0] == null || ownNativeAdViewArr[0].getChildCount() == 0) {
            return false;
        }
        this.f6025q = ownNativeAdViewArr[0];
        q();
        return true;
    }

    public final void b(View view) {
        this.f6013e = view;
        com.anythink.core.common.k.a.a aVar = new com.anythink.core.common.k.a.a() { // from class: com.anythink.basead.d.h.5
            @Override // com.anythink.core.common.k.a.a, com.anythink.core.common.k.a.b
            public final void recordImpression(View view2) {
                h.this.o();
            }
        };
        if (this.f6011c == null) {
            view.getContext();
            this.f6011c = new com.anythink.core.common.k.a.c(this.f6016h.f7312m.R() <= 0 ? 100 : this.f6016h.f7312m.R());
        }
        this.f6011c.a(view, aVar);
    }

    public final String c() {
        aa aaVar = this.f6015g;
        return aaVar != null ? aaVar.s() : "";
    }

    private static int a(int i2) {
        Random random = new Random();
        if (i2 <= 0) {
            return 0;
        }
        double d2 = i2;
        Double.isNaN(d2);
        int i3 = (int) (0.1d * d2);
        Double.isNaN(d2);
        return random.nextInt((((int) (d2 * 0.9d)) - i3) + 1) + i3;
    }

    public final void a(int i2, int i3) {
        this.f6022n = i2;
        this.f6023o = i3;
        com.anythink.expressad.advanced.d.c cVar = this.f6019k;
        if (cVar != null) {
            cVar.a(i3, i2);
        }
    }

    public final com.anythink.core.common.e.i a() {
        return this.f6015g;
    }

    public final View a(Context context, boolean z2, boolean z3, BaseMediaAdView.a aVar) {
        aa aaVar = this.f6015g;
        if (aaVar != null && aaVar.g() && z2) {
            return b(context, true, z3, aVar);
        }
        com.anythink.expressad.advanced.d.c cVar = this.f6019k;
        if (cVar != null) {
            cVar.a(z3 ? 1 : 0);
            return this.f6019k.c();
        }
        aa aaVar2 = this.f6015g;
        if (aaVar2 != null && !TextUtils.isEmpty(aaVar2.u()) && z2 && (this.f6015g instanceof com.anythink.core.common.e.g)) {
            return b(context, false, z3, aVar);
        }
        return null;
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.b = aVar;
    }

    public final void a(boolean z2) {
        this.f6017i = z2;
        com.anythink.expressad.advanced.d.c cVar = this.f6019k;
        if (cVar != null) {
            cVar.b(z2 ? 1 : 2);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void a(String str) {
        this.f6018j = str;
        if (this.f6019k != null) {
            if (!TextUtils.isEmpty(this.f6018j)) {
                String str2 = this.f6018j;
                byte b = -1;
                switch (str2.hashCode()) {
                    case 49:
                        if (str2.equals("1")) {
                            b = 0;
                        }
                        break;
                    case 50:
                        if (str2.equals("2")) {
                            b = 1;
                        }
                        break;
                    case 51:
                        if (str2.equals("3")) {
                            b = 2;
                        }
                        break;
                }
                if (b == 0) {
                    this.f6019k.c(3);
                    return;
                } else {
                    if (b != 1) {
                        if (b != 2) {
                            return;
                        }
                        this.f6019k.c(2);
                        return;
                    }
                    this.f6019k.c(1);
                    return;
                }
            }
            this.f6019k.c(3);
        }
    }

    public final void a(View view, List<View> list) {
        if (d(view)) {
            aa aaVar = this.f6015g;
            if (aaVar != null && !aaVar.g()) {
                b(view);
            }
            if (list != null) {
                for (View view2 : list) {
                    if (view2 != null) {
                        view2.setOnClickListener(this.f6021m);
                    }
                }
                return;
            }
            view.setOnClickListener(this.f6021m);
        }
    }

    public final void a(View view) {
        if (d(view)) {
            aa aaVar = this.f6015g;
            if (aaVar != null && !aaVar.g()) {
                b(view);
            }
            a(view, this.f6021m);
        }
    }

    private void a(OwnNativeAdView[] ownNativeAdViewArr, View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof OwnNativeAdView) {
                ownNativeAdViewArr[0] = (OwnNativeAdView) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(ownNativeAdViewArr, viewGroup.getChildAt(i2));
            }
        }
    }

    private void a(View view, View.OnClickListener onClickListener) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), onClickListener);
            }
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    private void a(View view, View[] viewArr) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), viewArr);
            }
            return;
        }
        if (((view instanceof Button) || (view instanceof TextView)) && TextUtils.equals(((TextView) view).getText().toString(), this.f6015g.w())) {
            viewArr[0] = view;
        }
    }

    public final boolean a(boolean z2, boolean z3) {
        if (this.f6015g.n() != 67) {
            return false;
        }
        return this.f6015g.a(z2, z3);
    }
}
