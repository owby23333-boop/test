package com.anythink.basead.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.anythink.basead.ui.BaseShakeView;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.a.f;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.u;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseSplashAdView extends BaseAdView {
    protected TextView A;
    protected CloseFrameLayout B;
    protected String C;
    protected Timer D;
    protected boolean E;
    protected com.anythink.basead.e.a F;
    protected b G;
    final long H;
    protected BaseShakeView I;
    GuideToClickView J;
    protected final View.OnClickListener K;
    boolean L;
    boolean M;
    boolean N;
    boolean O;
    private f.b a;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f6162t;

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseSplashAdView$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (BaseSplashAdView.this.f6114c.f7312m.p() == 0 || BaseSplashAdView.this.N) {
                BaseSplashAdView.this.s();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseSplashAdView$3, reason: invalid class name */
    final class AnonymousClass3 extends TimerTask {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (BaseSplashAdView.this.f6162t <= 0) {
                BaseSplashAdView.e(BaseSplashAdView.this);
            } else {
                BaseSplashAdView baseSplashAdView = BaseSplashAdView.this;
                baseSplashAdView.a(baseSplashAdView.f6162t);
            }
            BaseSplashAdView.this.f6162t -= 1000;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            BaseSplashAdView baseSplashAdView = BaseSplashAdView.this;
            if (u.a(baseSplashAdView, baseSplashAdView.a)) {
                BaseSplashAdView.this.post(new Runnable() { // from class: com.anythink.basead.ui.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6323s.a();
                    }
                });
            }
        }
    }

    public BaseSplashAdView(Context context) {
        super(context);
        this.C = "Skip";
        this.H = 1000L;
        this.f6162t = 5000L;
        this.K = new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSplashAdView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSplashAdView.super.b(1);
            }
        };
        this.L = false;
        this.M = false;
        this.N = false;
    }

    private void o() {
        s();
        this.A.setText(this.C);
        this.N = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Timer timer = this.D;
        if (timer != null) {
            timer.cancel();
        }
        this.D = null;
        if (this.E) {
            return;
        }
        this.E = true;
        if (!this.L) {
            a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5907k, "SplashView not showing on screen."));
        }
        com.anythink.basead.e.a aVar = this.F;
        if (aVar != null) {
            aVar.onAdClosed();
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    public void destroy() {
        super.destroy();
        this.F = null;
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void e() {
        this.L = true;
        com.anythink.basead.a.b.a(8, this.f6115d, i());
        com.anythink.basead.e.a aVar = this.F;
        if (aVar != null) {
            aVar.onAdShow();
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void f() {
        if (this.f6115d instanceof aa) {
            if (this.G == null) {
                this.G = new b(this);
            }
            post(new Runnable() { // from class: com.anythink.basead.ui.BaseSplashAdView.4
                @Override // java.lang.Runnable
                public final void run() {
                    BaseSplashAdView.this.G.b();
                }
            });
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void g() {
        if (!(this.f6115d instanceof aa) || this.G == null) {
            return;
        }
        post(new Runnable() { // from class: com.anythink.basead.ui.BaseSplashAdView.5
            @Override // java.lang.Runnable
            public final void run() {
                BaseSplashAdView.this.G.c();
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseAdView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.anythink.basead.ui.BaseAdView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 != 0 || this.M) {
            return;
        }
        this.M = true;
        if (this.O) {
            return;
        }
        this.B.setVisibility(0);
        this.B.setOnClickListener(new AnonymousClass2());
        this.N = false;
        this.D = new Timer();
        this.D.schedule(new AnonymousClass3(), 1000L, 1000L);
        a(this.f6162t);
        this.f6162t -= 1000;
    }

    protected void p() {
        int size = this.f6129r.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f6129r.get(i2);
            if (view != null) {
                view.setOnClickListener(this.K);
            }
        }
    }

    protected final void q() {
        if (m()) {
            this.I = (BaseShakeView) findViewById(h.a(getContext(), "myoffer_shake_view", "id"));
            this.I.setVisibility(0);
            this.I.setOnShakeListener(new BaseShakeView.a() { // from class: com.anythink.basead.ui.BaseSplashAdView.6
                @Override // com.anythink.basead.ui.BaseShakeView.a
                public final boolean a() {
                    BaseSplashAdView baseSplashAdView = BaseSplashAdView.this;
                    if (baseSplashAdView.E) {
                        return false;
                    }
                    baseSplashAdView.b(4);
                    return true;
                }
            }, this.f6114c.f7312m);
            this.f6129r.add(this.I);
        }
    }

    protected final void r() {
        GuideToClickView guideToClickView;
        this.J = (GuideToClickView) findViewById(h.a(getContext(), "myoffer_guide_to_click_view", "id"));
        if (this.f6114c.f7312m.i() != 1 || (guideToClickView = this.J) == null) {
            return;
        }
        guideToClickView.setVisibility(0);
        this.f6129r.add(this.J);
    }

    public void setDontCountDown(boolean z2) {
        CloseFrameLayout closeFrameLayout;
        this.O = z2;
        if (!this.O || (closeFrameLayout = this.B) == null) {
            return;
        }
        closeFrameLayout.setVisibility(8);
    }

    private void c() {
        this.B.setVisibility(0);
        this.B.setOnClickListener(new AnonymousClass2());
        this.N = false;
        this.D = new Timer();
        this.D.schedule(new AnonymousClass3(), 1000L, 1000L);
        a(this.f6162t);
        this.f6162t -= 1000;
    }

    private void b() {
        if (this.M) {
            return;
        }
        this.M = true;
        if (this.O) {
            return;
        }
        this.B.setVisibility(0);
        this.B.setOnClickListener(new AnonymousClass2());
        this.N = false;
        this.D = new Timer();
        this.D.schedule(new AnonymousClass3(), 1000L, 1000L);
        a(this.f6162t);
        this.f6162t -= 1000;
    }

    protected final void a(com.anythink.basead.c.e eVar) {
        if (this.L) {
            return;
        }
        this.L = true;
        com.anythink.basead.e.a aVar = this.F;
        if (aVar != null) {
            aVar.onShowFailed(eVar);
        }
    }

    static /* synthetic */ void e(BaseSplashAdView baseSplashAdView) {
        baseSplashAdView.s();
        baseSplashAdView.A.setText(baseSplashAdView.C);
        baseSplashAdView.N = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        if (this.f6114c.f7312m.p() == 0) {
            this.A.setText((j2 / 1000) + "s | " + this.C);
            return;
        }
        this.A.setText((j2 / 1000) + " s");
    }

    public BaseSplashAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar);
        this.C = "Skip";
        this.H = 1000L;
        this.f6162t = 5000L;
        this.K = new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSplashAdView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSplashAdView.super.b(1);
            }
        };
        this.L = false;
        this.M = false;
        this.N = false;
        this.a = new f.b();
        this.F = aVar;
        this.C = getResources().getString(h.a(getContext(), "myoffer_splash_skip_text", com.anythink.expressad.foundation.h.i.f10649g));
        this.A = (TextView) findViewById(h.a(getContext(), "myoffer_splash_skip", "id"));
        this.B = (CloseFrameLayout) findViewById(h.a(getContext(), "myoffer_splash_skip_area", "id"));
        this.f6162t = this.f6114c.f7312m.n();
        a(this.B, this.f6114c.f7312m.h());
        this.E = false;
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected void a(int i2) {
        com.anythink.basead.e.a aVar = this.F;
        if (aVar != null) {
            aVar.onAdClick(i2);
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a(boolean z2) {
        com.anythink.basead.e.a aVar = this.F;
        if (aVar != null) {
            aVar.onDeeplinkCallback(z2);
        }
    }
}
