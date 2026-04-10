package com.anythink.basead.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.basead.a.b.g;
import com.anythink.basead.c;
import com.anythink.basead.c.i;
import com.anythink.basead.e.b;
import com.anythink.basead.ui.BaseShakeView;
import com.anythink.basead.ui.EndCardView;
import com.anythink.basead.ui.MraidEndCardView;
import com.anythink.basead.ui.PanelView;
import com.anythink.basead.ui.PlayerView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.ac;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.h;
import com.anythink.expressad.video.module.a.a.m;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseScreenAdView extends BaseAdView {
    public static final int FORMAT_INTERSTITIAL = 3;
    public static final int FORMAT_REWARD_VIDEO = 1;
    public static final String TAG = BaseScreenAdView.class.getSimpleName();
    public static final int TYPE_FULL_SCREEN = 0;
    public static final int TYPE_HALF_SCREEN = 1;
    protected b A;
    int B;
    protected int C;
    protected int D;
    protected b.InterfaceC0141b E;
    protected boolean F;
    protected int G;
    protected CountDownView H;
    protected CloseImageView I;
    protected ViewGroup J;
    protected MuteImageView K;
    protected int L;
    protected boolean M;
    protected float N;
    protected int O;
    protected int P;
    protected int Q;
    protected BaseShakeView R;
    protected BaseShakeView S;
    final long T;
    final long U;
    Runnable V;
    ConcurrentHashMap<Integer, Boolean> W;
    protected int a;
    protected int aa;
    protected int ab;
    protected int ac;
    protected int ad;
    private boolean ae;
    private boolean af;
    private long ag;
    private long ah;
    private long ai;
    private long aj;
    private com.anythink.basead.c ak;
    private boolean al;
    private boolean am;
    private boolean an;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected int f6143t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f6144u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected boolean f6145v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected RelativeLayout f6146w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected PlayerView f6147x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected PanelView f6148y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected BaseEndCardView f6149z;

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseScreenAdView$2, reason: invalid class name */
    final class AnonymousClass2 implements c.a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.c.a
        public final void a() {
            BaseScreenAdView.c(BaseScreenAdView.this);
        }

        @Override // com.anythink.basead.c.a
        public final void b() {
            BaseScreenAdView.this.r();
            BaseScreenAdView.this.ak.b();
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseScreenAdView$7, reason: invalid class name */
    final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BaseScreenAdView.this.A();
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseScreenAdView$8, reason: invalid class name */
    final class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BaseScreenAdView.f(BaseScreenAdView.this);
        }
    }

    public BaseScreenAdView(Context context) {
        super(context);
        this.G = 0;
        this.al = false;
        this.T = m.ag;
        this.U = 500L;
        this.am = false;
        this.an = false;
        this.V = new Runnable() { // from class: com.anythink.basead.ui.BaseScreenAdView.1
            @Override // java.lang.Runnable
            public final void run() {
                BaseScreenAdView.super.h();
            }
        };
    }

    private void K() {
        if (n() && !this.f6114c.f7312m.V() && this.f6149z == null) {
            this.f6149z = b(true);
        }
    }

    private void L() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.C = displayMetrics.widthPixels;
        this.D = displayMetrics.heightPixels;
    }

    private void M() {
        if (this.f6149z == null) {
            this.f6149z = b(false);
        }
        H();
    }

    private void N() {
        this.Q = q();
        final boolean zC = c(this.Q);
        EndCardView endCardView = new EndCardView(getContext(), this.f6115d, this.f6114c);
        endCardView.setSize(this.C, this.D);
        endCardView.init(false, false, new EndCardView.a() { // from class: com.anythink.basead.ui.BaseScreenAdView.16
            @Override // com.anythink.basead.ui.EndCardView.a
            public final void a() {
                String str = BaseScreenAdView.TAG;
                BaseScreenAdView.this.b(1);
            }

            @Override // com.anythink.basead.ui.EndCardView.a
            public final void b() {
                BaseScreenAdView.this.I();
                if (zC) {
                    BaseScreenAdView.this.E();
                }
            }
        });
        this.f6149z = endCardView;
        H();
        PanelView panelView = this.f6148y;
        if (panelView != null && panelView.getVisibility() == 0) {
            if (this.f6148y.getCTAButton() == null || this.f6148y.getCTAButton().getVisibility() != 0) {
                this.f6130s = this.f6148y;
            } else {
                this.f6130s = this.f6148y.getCTAButton();
            }
        }
        endCardView.load();
    }

    private void O() {
        s();
        if (this.ak == null) {
            this.ak = new com.anythink.basead.c();
        }
        this.ak.a(getContext(), this.f6115d, this.f6114c, new AnonymousClass2());
    }

    private void P() {
        this.ae = true;
        ViewGroup viewGroup = this.J;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void Q() {
        if (this.A == null) {
            this.A = new b(this.f6146w);
        }
        this.A.b();
    }

    private void R() {
        b bVar = this.A;
        if (bVar != null) {
            bVar.c();
        }
    }

    private void S() {
        com.anythink.basead.a.b.a(1, this.f6115d, i());
        b.InterfaceC0141b interfaceC0141b = this.E;
        if (interfaceC0141b != null) {
            interfaceC0141b.b();
        }
    }

    private void T() {
        CountDownView countDownView = this.H;
        if (countDownView != null) {
            countDownView.setVisibility(4);
        }
    }

    private void U() {
        CloseImageView closeImageView = this.I;
        if (closeImageView != null) {
            this.N = a(closeImageView, this.f6114c.f7312m.h());
            this.I.setVisibility(8);
            this.I.setOnClickListener(new AnonymousClass7());
        }
    }

    private void V() {
        ViewGroup viewGroup = this.J;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            this.J.setOnClickListener(new AnonymousClass8());
        }
    }

    private void W() {
        ViewGroup viewGroup;
        if (this.ae || (viewGroup = this.J) == null || viewGroup.isShown()) {
            return;
        }
        this.J.setVisibility(0);
    }

    protected abstract void A();

    protected final void B() {
        PlayerView playerView = this.f6147x;
        if (playerView == null || !playerView.isPlaying()) {
            return;
        }
        this.f6147x.stop();
        this.f6147x.removeAllViews();
        i iVarI = i();
        iVarI.f5935g = j();
        com.anythink.basead.a.b.a(16, this.f6115d, iVarI);
    }

    protected final void C() {
        i iVarI = i();
        iVarI.f5935g = j();
        com.anythink.basead.a.b.a(7, this.f6115d, iVarI);
        b.InterfaceC0141b interfaceC0141b = this.E;
        if (interfaceC0141b != null) {
            interfaceC0141b.e();
        }
    }

    protected void D() {
        CountDownView countDownView = this.H;
        if (countDownView != null && !countDownView.isShown()) {
            this.H.setVisibility(0);
        }
        MuteImageView muteImageView = this.K;
        if (muteImageView == null || muteImageView.isShown()) {
            return;
        }
        this.K.setVisibility(0);
    }

    protected final void E() {
        if (this.f6148y.getVisibility() != 0) {
            this.f6148y.setVisibility(0);
        }
    }

    protected void F() {
        if (this.f6148y.getVisibility() != 8) {
            this.f6148y.setVisibility(8);
        }
    }

    protected void G() {
        ViewGroup viewGroup;
        CloseImageView closeImageView = this.I;
        if (closeImageView != null && !closeImageView.isShown()) {
            this.I.setVisibility(0);
            this.I.setClickAreaScaleFactor(this.N);
        }
        if (this.ae || (viewGroup = this.J) == null || viewGroup.isShown()) {
            return;
        }
        this.J.setVisibility(0);
    }

    protected abstract void H();

    protected abstract void I();

    protected abstract void J();

    @Override // com.anythink.basead.ui.BaseAdView
    protected void a() {
    }

    protected void b() {
        this.f6146w = (RelativeLayout) findViewById(h.a(getContext(), "myoffer_rl_root", "id"));
        this.f6147x = (PlayerView) findViewById(h.a(getContext(), "myoffer_player_view_id", "id"));
        this.f6148y = (PanelView) findViewById(h.a(getContext(), "myoffer_banner_view_id", "id"));
        this.H = (CountDownView) findViewById(h.a(getContext(), "myoffer_count_down_view_id", "id"));
        this.K = (MuteImageView) findViewById(h.a(getContext(), "myoffer_btn_mute_id", "id"));
        this.I = (CloseImageView) findViewById(h.a(getContext(), "myoffer_btn_close_id", "id"));
        this.J = (ViewGroup) findViewById(h.a(getContext(), "myoffer_feedback_ll_id", "id"));
        CountDownView countDownView = this.H;
        if (countDownView != null) {
            countDownView.setVisibility(4);
        }
        z();
        CloseImageView closeImageView = this.I;
        if (closeImageView != null) {
            this.N = a(closeImageView, this.f6114c.f7312m.h());
            this.I.setVisibility(8);
            this.I.setOnClickListener(new AnonymousClass7());
        }
        ViewGroup viewGroup = this.J;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            this.J.setOnClickListener(new AnonymousClass8());
        }
        v();
    }

    protected void c() {
        this.f6147x.setListener(new PlayerView.a() { // from class: com.anythink.basead.ui.BaseScreenAdView.9
            @Override // com.anythink.basead.ui.PlayerView.a
            public final void a() {
                String str = BaseScreenAdView.TAG;
                BaseScreenAdView.this.D();
                BaseScreenAdView.this.aj = System.currentTimeMillis();
                BaseScreenAdView.this.h();
                BaseScreenAdView.b(BaseScreenAdView.this);
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void b() {
                String str = BaseScreenAdView.TAG;
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void c() {
                String str = BaseScreenAdView.TAG;
                i iVarI = BaseScreenAdView.this.i();
                com.anythink.basead.a.b.a(5, BaseScreenAdView.this.f6115d, iVarI);
                com.anythink.basead.a.b.a(31, BaseScreenAdView.this.f6115d, iVarI);
                b.InterfaceC0141b interfaceC0141b = BaseScreenAdView.this.E;
                if (interfaceC0141b != null) {
                    interfaceC0141b.c();
                }
                BaseScreenAdView baseScreenAdView = BaseScreenAdView.this;
                if (!baseScreenAdView.f6145v) {
                    baseScreenAdView.f6145v = true;
                    b.InterfaceC0141b interfaceC0141b2 = baseScreenAdView.E;
                    if (interfaceC0141b2 != null) {
                        interfaceC0141b2.d();
                    }
                }
                if (BaseScreenAdView.this.f6114c.f7312m.J() == 1) {
                    BaseScreenAdView.this.p();
                    BaseScreenAdView.this.l();
                    return;
                }
                BaseScreenAdView.this.l();
                BaseScreenAdView baseScreenAdView2 = BaseScreenAdView.this;
                CloseImageView closeImageView = baseScreenAdView2.I;
                if (closeImageView != null) {
                    baseScreenAdView2.a(closeImageView);
                }
                BaseScreenAdView.this.C();
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void d() {
                BaseScreenAdView baseScreenAdView = BaseScreenAdView.this;
                BaseScreenAdView.c(baseScreenAdView, baseScreenAdView.f6147x.getCurrentPosition());
                i iVarI = BaseScreenAdView.this.i();
                iVarI.f5935g = BaseScreenAdView.this.j();
                com.anythink.basead.a.b.a(14, BaseScreenAdView.this.f6115d, iVarI);
                k kVar = BaseScreenAdView.this.f6114c.f7312m;
                if (kVar == null || kVar.u() != 1) {
                    return;
                }
                BaseScreenAdView.this.b(1);
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void e() {
                String str = BaseScreenAdView.TAG;
                i iVarI = BaseScreenAdView.this.i();
                iVarI.f5935g = BaseScreenAdView.this.j();
                com.anythink.basead.a.b.a(12, BaseScreenAdView.this.f6115d, iVarI);
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void f() {
                String str = BaseScreenAdView.TAG;
                i iVarI = BaseScreenAdView.this.i();
                iVarI.f5935g = BaseScreenAdView.this.j();
                com.anythink.basead.a.b.a(13, BaseScreenAdView.this.f6115d, iVarI);
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void g() {
                BaseScreenAdView baseScreenAdView = BaseScreenAdView.this;
                j jVar = baseScreenAdView.f6114c;
                new com.anythink.basead.a.b.f(jVar.b, baseScreenAdView.f6115d, jVar.f7312m).b();
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void b(int i2) {
                i iVarI = BaseScreenAdView.this.i();
                if (i2 == 25) {
                    String str = BaseScreenAdView.TAG;
                    com.anythink.basead.a.b.a(2, BaseScreenAdView.this.f6115d, iVarI);
                } else if (i2 == 50) {
                    String str2 = BaseScreenAdView.TAG;
                    com.anythink.basead.a.b.a(3, BaseScreenAdView.this.f6115d, iVarI);
                } else {
                    if (i2 != 75) {
                        return;
                    }
                    String str3 = BaseScreenAdView.TAG;
                    com.anythink.basead.a.b.a(4, BaseScreenAdView.this.f6115d, iVarI);
                }
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void a(int i2) {
                BaseScreenAdView.this.D();
                BaseScreenAdView.a(BaseScreenAdView.this, i2);
                BaseScreenAdView.b(BaseScreenAdView.this, i2);
                CountDownView countDownView = BaseScreenAdView.this.H;
                if (countDownView != null && countDownView.isShown()) {
                    BaseScreenAdView.this.H.refresh(i2);
                }
                BaseScreenAdView baseScreenAdView = BaseScreenAdView.this;
                int i3 = baseScreenAdView.L;
                if (i3 >= 0 && i2 >= i3) {
                    baseScreenAdView.G();
                }
                if (i2 >= BaseScreenAdView.this.f6114c.f7312m.e()) {
                    BaseScreenAdView baseScreenAdView2 = BaseScreenAdView.this;
                    if (baseScreenAdView2.f6145v) {
                        return;
                    }
                    baseScreenAdView2.G();
                    BaseScreenAdView baseScreenAdView3 = BaseScreenAdView.this;
                    baseScreenAdView3.f6145v = true;
                    b.InterfaceC0141b interfaceC0141b = baseScreenAdView3.E;
                    if (interfaceC0141b != null) {
                        interfaceC0141b.d();
                    }
                }
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void a(com.anythink.basead.c.e eVar) {
                BaseScreenAdView.this.p();
                i iVarI = BaseScreenAdView.this.i();
                iVarI.f5936h = BaseScreenAdView.this.fillVideoEndRecord(false);
                com.anythink.basead.a.b.a(17, BaseScreenAdView.this.f6115d, iVarI);
                BaseScreenAdView.this.a(eVar);
                BaseScreenAdView baseScreenAdView = BaseScreenAdView.this;
                if (!baseScreenAdView.f6145v && baseScreenAdView.f6114c.f7312m.f() == 1 && com.anythink.basead.c.f.C.equals(eVar.b())) {
                    BaseScreenAdView baseScreenAdView2 = BaseScreenAdView.this;
                    baseScreenAdView2.f6145v = true;
                    b.InterfaceC0141b interfaceC0141b = baseScreenAdView2.E;
                    if (interfaceC0141b != null) {
                        interfaceC0141b.d();
                    }
                }
            }

            @Override // com.anythink.basead.ui.PlayerView.a
            public final void c(int i2) {
                BaseScreenAdView.this.d(i2);
                com.anythink.basead.a.b.a(35, BaseScreenAdView.this.f6115d, BaseScreenAdView.this.i());
            }
        });
        this.f6147x.initMuteStatus(this.M);
        this.f6147x.setVideoSize(this.O, this.P);
        this.f6147x.setVideoRateConfig(this.f6115d.k().S(), this.f6115d.k().T());
        this.f6147x.load(this.f6115d.x(), false);
    }

    protected abstract boolean c(int i2);

    @Override // com.anythink.basead.ui.BaseAdView
    protected void destroy() {
        super.destroy();
        this.E = null;
        BaseEndCardView baseEndCardView = this.f6149z;
        if (baseEndCardView != null) {
            baseEndCardView.a();
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void e() {
        com.anythink.basead.a.b.a(8, this.f6115d, i());
        b.InterfaceC0141b interfaceC0141b = this.E;
        if (interfaceC0141b != null) {
            interfaceC0141b.a();
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void f() {
        this.af = true;
        if (this.A == null) {
            this.A = new b(this.f6146w);
        }
        this.A.b();
    }

    public com.anythink.basead.c.j fillVideoEndRecord(boolean z2) {
        com.anythink.basead.c.j jVar = new com.anythink.basead.c.j();
        jVar.f5954l = this.f6143t == 2 ? 4 : 1;
        jVar.f5956r = 1;
        PlayerView playerView = this.f6147x;
        jVar.a = playerView != null ? playerView.getVideoLength() / 1000 : 0;
        jVar.b = this.B / 1000;
        PlayerView playerView2 = this.f6147x;
        jVar.f5947c = playerView2 != null ? playerView2.getCurrentPosition() / 1000 : 0;
        jVar.f5948d = this.B == 0 ? 1 : 0;
        jVar.f5955o = this.B == 0 ? 1 : 2;
        PlayerView playerView3 = this.f6147x;
        jVar.f5949e = (playerView3 == null || playerView3.getCurrentPosition() != this.f6147x.getVideoLength()) ? 0 : 1;
        jVar.f5957u = z2 ? 0 : 2;
        jVar.f5950f = this.aj;
        jVar.f5951g = System.currentTimeMillis();
        PlayerView playerView4 = this.f6147x;
        jVar.f5952h = playerView4 != null ? playerView4.getCurrentPosition() : 0;
        new StringBuilder("Video End Record:").append(jVar.toString());
        return jVar;
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void g() {
        this.af = false;
        post(new Runnable() { // from class: com.anythink.basead.ui.BaseScreenAdView.3
            @Override // java.lang.Runnable
            public final void run() {
                BaseScreenAdView.e(BaseScreenAdView.this);
            }
        });
    }

    public float getCloseButtonScaleFactor() {
        return this.N;
    }

    public boolean getHasPerformClick() {
        return this.an;
    }

    public long getHideBannerTime() {
        return this.ai;
    }

    public long getShowBannerTime() {
        return this.ag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseAdView
    public final synchronized void h() {
        if (this.f6114c.f7312m.R() > 0) {
            n.a().a(this.V, this.f6114c.f7312m.R());
        } else {
            super.h();
        }
    }

    public boolean hasReward() {
        return this.f6145v;
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final i i() {
        i iVar = new i(this.f6114c.f7303d, this.f6128q);
        iVar.f5933e = getWidth();
        iVar.f5934f = getHeight();
        PlayerView playerView = this.f6147x;
        if (playerView != null && playerView.hasVideo()) {
            iVar.f5936h = fillVideoEndRecord(true);
        }
        return iVar;
    }

    public void init() {
        b();
        this.F = c(this.Q);
        if (this.f6144u) {
            J();
            p();
            return;
        }
        int i2 = this.a;
        if (1 == i2) {
            if (this.f6115d.E()) {
                J();
                c();
                K();
                return;
            } else {
                a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5907k, com.anythink.basead.c.f.D));
                b.InterfaceC0141b interfaceC0141b = this.E;
                if (interfaceC0141b != null) {
                    interfaceC0141b.e();
                    return;
                }
                return;
            }
        }
        if (3 == i2) {
            if (this.f6115d.C() == 1 && this.f6115d.E()) {
                J();
                c();
                K();
            } else {
                J();
                p();
                if (n()) {
                    return;
                }
                h();
            }
        }
    }

    public boolean isShowEndCard() {
        return this.f6144u;
    }

    public boolean isVideoMute() {
        return this.M;
    }

    public boolean needHideFeedbackButton() {
        return this.ae;
    }

    protected final void o() {
        BaseShakeView baseShakeView = this.R;
        if (baseShakeView != null) {
            baseShakeView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseScreenAdView.10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseScreenAdView.this.b(1);
                }
            });
            this.R.setOnShakeListener(new BaseShakeView.a() { // from class: com.anythink.basead.ui.BaseScreenAdView.11
                @Override // com.anythink.basead.ui.BaseShakeView.a
                public final boolean a() {
                    if (!BaseScreenAdView.this.x()) {
                        return false;
                    }
                    BaseScreenAdView.this.b(4);
                    return true;
                }
            }, this.f6114c.f7312m);
        }
        BaseShakeView baseShakeView2 = this.S;
        if (baseShakeView2 != null) {
            baseShakeView2.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseScreenAdView.12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseScreenAdView.this.b(1);
                }
            });
            this.S.setOnShakeListener(new BaseShakeView.a() { // from class: com.anythink.basead.ui.BaseScreenAdView.13
                @Override // com.anythink.basead.ui.BaseShakeView.a
                public final boolean a() {
                    if (!BaseScreenAdView.this.x()) {
                        return false;
                    }
                    BaseScreenAdView.this.b(4);
                    return true;
                }
            }, this.f6114c.f7312m);
        }
    }

    protected final void p() {
        this.f6144u = true;
        if (n()) {
            M();
        } else {
            N();
        }
        BaseEndCardView baseEndCardView = this.f6149z;
        if (baseEndCardView != null) {
            baseEndCardView.postDelayed(new Runnable() { // from class: com.anythink.basead.ui.BaseScreenAdView.14
                @Override // java.lang.Runnable
                public final void run() {
                    BaseScreenAdView.this.G();
                }
            }, a(this.f6114c.f7312m));
        }
        com.anythink.basead.a.b.a(6, this.f6115d, i());
    }

    protected abstract int q();

    protected final void r() {
        this.am = true;
        try {
            if ((this.ak == null || !this.ak.a()) && this.f6147x != null && this.f6147x.hasVideo()) {
                if (!this.f6147x.isPlaying()) {
                    this.aj = System.currentTimeMillis();
                    this.B = this.f6147x.getCurrentPosition();
                    if (this.B != 0) {
                        com.anythink.basead.a.b.a(15, this.f6115d, i());
                    }
                }
                this.f6147x.start();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected final void s() {
        this.am = false;
        PlayerView playerView = this.f6147x;
        if (playerView != null) {
            if (playerView.isPlaying()) {
                com.anythink.basead.a.b.a(11, this.f6115d, i());
            }
            this.f6147x.pause();
        }
    }

    public void setCloseButtonScaleFactor(float f2) {
        this.N = f2;
        CloseImageView closeImageView = this.I;
        if (closeImageView != null) {
            closeImageView.setClickAreaScaleFactor(this.N);
        }
    }

    public void setHasPerformClick(boolean z2) {
        this.an = z2;
    }

    public void setHasReward(boolean z2) {
        this.f6145v = z2;
    }

    public void setHideBannerTime(long j2) {
        this.ai = j2;
    }

    public void setHideFeedbackButton(boolean z2) {
        this.ae = z2;
    }

    public void setIsShowEndCard(boolean z2) {
        this.f6144u = z2;
    }

    public void setListener(b.InterfaceC0141b interfaceC0141b) {
        this.E = interfaceC0141b;
    }

    public void setShowBannerTime(long j2) {
        this.ag = j2;
    }

    public void setVideoMute(boolean z2) {
        this.M = z2;
    }

    protected final void t() {
        destroy();
        n.a().c(this.V);
    }

    protected void u() {
        String strU = this.f6115d.u();
        if (!TextUtils.isEmpty(strU)) {
            com.anythink.basead.a.f.a();
            int[] iArrA = com.anythink.core.common.k.b.a(com.anythink.basead.a.f.a(1, strU));
            if (iArrA != null) {
                this.ac = iArrA[0];
                this.ad = iArrA[1];
            }
        }
        String strX = this.f6115d.x();
        if (!TextUtils.isEmpty(strX)) {
            com.anythink.basead.a.f.a();
            g.a aVarA = g.a(com.anythink.basead.a.f.a(4, strX));
            if (aVarA != null) {
                this.aa = aVarA.a;
                this.ab = aVarA.b;
            }
        } else if (!TextUtils.isEmpty(strU)) {
            this.aa = this.ac;
            this.ab = this.ad;
        }
        StringBuilder sb = new StringBuilder("mMaterialWidth: ");
        sb.append(this.aa);
        sb.append(", mMaterialHeight: ");
        sb.append(this.ab);
    }

    protected void v() {
        PanelView panelView = this.f6148y;
        if (panelView != null) {
            panelView.setVisibility(4);
            this.f6148y.init(this.f6115d, this.f6114c, this.f6143t, m(), new PanelView.a() { // from class: com.anythink.basead.ui.BaseScreenAdView.5
                @Override // com.anythink.basead.ui.PanelView.a
                public final void a() {
                    BaseScreenAdView.this.b(1);
                }

                @Override // com.anythink.basead.ui.PanelView.a
                public final boolean b() {
                    if (!BaseScreenAdView.this.x()) {
                        return false;
                    }
                    BaseScreenAdView.this.b(4);
                    return true;
                }
            });
        }
        w();
    }

    protected abstract void w();

    protected final boolean x() {
        com.anythink.basead.c cVar = this.ak;
        return (cVar == null || !cVar.a()) && this.am;
    }

    protected void y() {
    }

    protected void z() {
        MuteImageView muteImageView = this.K;
        if (muteImageView == null) {
            return;
        }
        if (this.M) {
            muteImageView.setMute(true);
        } else {
            muteImageView.setMute(false);
        }
        this.K.setVisibility(4);
        this.K.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseScreenAdView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseScreenAdView baseScreenAdView = BaseScreenAdView.this;
                if (baseScreenAdView.f6147x == null || baseScreenAdView.K == null) {
                    return;
                }
                if (!r0.isMute()) {
                    BaseScreenAdView baseScreenAdView2 = BaseScreenAdView.this;
                    baseScreenAdView2.M = true;
                    baseScreenAdView2.K.setMute(true);
                    BaseScreenAdView.this.f6147x.setMute(true);
                    return;
                }
                BaseScreenAdView baseScreenAdView3 = BaseScreenAdView.this;
                baseScreenAdView3.M = false;
                baseScreenAdView3.K.setMute(false);
                BaseScreenAdView.this.f6147x.setMute(false);
            }
        });
    }

    protected final void d(int i2) {
        CountDownView countDownView = this.H;
        if (countDownView != null) {
            countDownView.setDuration(i2);
        }
    }

    private static int a(k kVar) {
        int iB;
        if (kVar == null || (iB = (int) (kVar.B() / 100.0f)) == 0) {
            return 0;
        }
        Random random = new Random();
        if (random.nextInt(100) > iB) {
            return 0;
        }
        int iC = kVar.C();
        int iD = kVar.D();
        if (iD <= 0) {
            return 0;
        }
        if (iC == iD) {
            return iC;
        }
        try {
            return random.nextInt(iD - iC) + iC;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private void g(int i2) {
        if (this.F && this.ag == -1) {
            long j2 = this.ah;
            if (j2 != 0) {
                this.ag = i2;
                if (j2 > 0) {
                    this.ai = this.ag + j2;
                }
                E();
            }
        }
    }

    private void e(int i2) {
        ac acVarX;
        Map<Integer, String[]> mapY;
        com.anythink.core.common.e.i iVar = this.f6115d;
        if (!(iVar instanceof aa) || (acVarX = ((aa) iVar).X()) == null || (mapY = acVarX.y()) == null || mapY.size() <= 0) {
            return;
        }
        if (this.W == null) {
            this.W = new ConcurrentHashMap<>();
        }
        int i3 = i2 / 1000;
        for (Integer num : mapY.keySet()) {
            if (this.W.get(num) == null || !this.W.get(num).booleanValue()) {
                if (i3 >= num.intValue()) {
                    this.W.put(num, Boolean.TRUE);
                    i iVarI = i();
                    iVarI.f5936h.f5953i = num.intValue();
                    com.anythink.basead.a.b.a(32, this.f6115d, iVarI);
                }
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected void d() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.C = displayMetrics.widthPixels;
        this.D = displayMetrics.heightPixels;
        u();
    }

    private void f(int i2) {
        long j2 = this.ai;
        if (j2 >= 0 && i2 > j2) {
            F();
            return;
        }
        if (this.F) {
            long j3 = this.ag;
            if (j3 < 0 || i2 < j3) {
                return;
            }
            E();
        }
    }

    static /* synthetic */ void c(BaseScreenAdView baseScreenAdView, int i2) {
        if (baseScreenAdView.F && baseScreenAdView.ag == -1) {
            long j2 = baseScreenAdView.ah;
            if (j2 != 0) {
                baseScreenAdView.ag = i2;
                if (j2 > 0) {
                    baseScreenAdView.ai = baseScreenAdView.ag + j2;
                }
                baseScreenAdView.E();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BaseScreenAdView(android.content.Context r3, com.anythink.core.common.e.j r4, com.anythink.core.common.e.i r5, java.lang.String r6, int r7, int r8) {
        /*
            r2 = this;
            r2.<init>(r3, r4, r5, r6)
            r3 = 0
            r2.G = r3
            r2.al = r3
            r4 = 3000(0xbb8, double:1.482E-320)
            r2.T = r4
            r4 = 500(0x1f4, double:2.47E-321)
            r2.U = r4
            r2.am = r3
            r2.an = r3
            com.anythink.basead.ui.BaseScreenAdView$1 r4 = new com.anythink.basead.ui.BaseScreenAdView$1
            r4.<init>()
            r2.V = r4
            r2.a = r7
            r2.f6143t = r8
            com.anythink.core.common.e.j r4 = r2.f6114c
            com.anythink.core.common.e.k r4 = r4.f7312m
            int r4 = r4.v()
            if (r4 <= 0) goto L34
            com.anythink.core.common.e.j r4 = r2.f6114c
            com.anythink.core.common.e.k r4 = r4.f7312m
            int r4 = r4.v()
            int r4 = r4 * 1000
            goto L3c
        L34:
            com.anythink.core.common.e.j r4 = r2.f6114c
            com.anythink.core.common.e.k r4 = r4.f7312m
            int r4 = r4.v()
        L3c:
            long r4 = (long) r4
            r2.ag = r4
            com.anythink.core.common.e.j r4 = r2.f6114c
            com.anythink.core.common.e.k r4 = r4.f7312m
            int r4 = r4.w()
            if (r4 <= 0) goto L54
            com.anythink.core.common.e.j r4 = r2.f6114c
            com.anythink.core.common.e.k r4 = r4.f7312m
            int r4 = r4.w()
            int r4 = r4 * 1000
            goto L5c
        L54:
            com.anythink.core.common.e.j r4 = r2.f6114c
            com.anythink.core.common.e.k r4 = r4.f7312m
            int r4 = r4.w()
        L5c:
            long r4 = (long) r4
            r2.ah = r4
            long r4 = r2.ah
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L71
            long r0 = r2.ag
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 < 0) goto L71
            long r0 = r0 + r4
            r2.ai = r0
            goto L75
        L71:
            long r4 = r2.ah
            r2.ai = r4
        L75:
            com.anythink.core.common.e.j r4 = r2.f6114c
            com.anythink.core.common.e.k r4 = r4.f7312m
            int r4 = r4.z()
            int r4 = r4 * 1000
            r2.L = r4
            com.anythink.core.common.e.j r4 = r2.f6114c
            com.anythink.core.common.e.k r4 = r4.f7312m
            int r4 = r4.y()
            if (r4 != 0) goto L8c
            r3 = 1
        L8c:
            r2.M = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.BaseScreenAdView.<init>(android.content.Context, com.anythink.core.common.e.j, com.anythink.core.common.e.i, java.lang.String, int, int):void");
    }

    static /* synthetic */ void f(BaseScreenAdView baseScreenAdView) {
        baseScreenAdView.s();
        if (baseScreenAdView.ak == null) {
            baseScreenAdView.ak = new com.anythink.basead.c();
        }
        baseScreenAdView.ak.a(baseScreenAdView.getContext(), baseScreenAdView.f6115d, baseScreenAdView.f6114c, baseScreenAdView.new AnonymousClass2());
    }

    static /* synthetic */ void c(BaseScreenAdView baseScreenAdView) {
        baseScreenAdView.ae = true;
        ViewGroup viewGroup = baseScreenAdView.J;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    protected final void a(com.anythink.basead.c.e eVar) {
        b.InterfaceC0141b interfaceC0141b = this.E;
        if (interfaceC0141b != null) {
            interfaceC0141b.a(eVar);
        }
        k();
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a(int i2) {
        b.InterfaceC0141b interfaceC0141b = this.E;
        if (interfaceC0141b != null) {
            interfaceC0141b.a(i2);
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a(boolean z2) {
        b.InterfaceC0141b interfaceC0141b = this.E;
        if (interfaceC0141b != null) {
            interfaceC0141b.a(z2);
        }
    }

    final void a(final BaseShakeView baseShakeView, final BaseShakeView baseShakeView2) {
        if (this.al) {
            return;
        }
        this.al = true;
        if (baseShakeView == null || !m()) {
            return;
        }
        baseShakeView.setVisibility(0);
        baseShakeView.postDelayed(new Runnable() { // from class: com.anythink.basead.ui.BaseScreenAdView.4
            @Override // java.lang.Runnable
            public final void run() {
                if (BaseScreenAdView.this.f6144u) {
                    return;
                }
                try {
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.2f);
                    valueAnimatorOfFloat.setDuration(500L);
                    valueAnimatorOfFloat.setRepeatCount(1);
                    valueAnimatorOfFloat.setRepeatMode(2);
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.BaseScreenAdView.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (baseShakeView.getVisibility() == 0) {
                                baseShakeView.setAlpha(fFloatValue);
                            }
                            BaseShakeView baseShakeView3 = baseShakeView2;
                            if (baseShakeView3 == null || baseShakeView3.getVisibility() != 0) {
                                return;
                            }
                            baseShakeView2.setAlpha(fFloatValue);
                        }
                    });
                    valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.anythink.basead.ui.BaseScreenAdView.4.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationRepeat(Animator animator) {
                            super.onAnimationRepeat(animator);
                            baseShakeView.setVisibility(8);
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            BaseShakeView baseShakeView3 = baseShakeView2;
                            if (baseShakeView3 == null || BaseScreenAdView.this.f6144u) {
                                return;
                            }
                            baseShakeView3.setAlpha(0.2f);
                            baseShakeView2.setVisibility(0);
                        }
                    });
                    valueAnimatorOfFloat.start();
                } catch (Throwable unused) {
                    baseShakeView.setVisibility(8);
                    BaseShakeView baseShakeView3 = baseShakeView2;
                    if (baseShakeView3 == null || BaseScreenAdView.this.f6144u) {
                        return;
                    }
                    baseShakeView3.setVisibility(0);
                }
            }
        }, m.ag);
    }

    static /* synthetic */ void e(BaseScreenAdView baseScreenAdView) {
        b bVar = baseScreenAdView.A;
        if (bVar != null) {
            bVar.c();
        }
    }

    private BaseEndCardView b(boolean z2) {
        MraidEndCardView mraidEndCardView = new MraidEndCardView(getContext(), this.f6115d, this.f6114c);
        mraidEndCardView.setEndCardListener(new MraidEndCardView.a() { // from class: com.anythink.basead.ui.BaseScreenAdView.15
            @Override // com.anythink.basead.ui.MraidEndCardView.a
            public final void a(String str) {
                String str2 = BaseScreenAdView.TAG;
                BaseScreenAdView.this.f6115d.v(str);
                BaseScreenAdView.this.b(1);
            }

            @Override // com.anythink.basead.ui.MraidEndCardView.a
            public final void b() {
                BaseScreenAdView.this.I();
            }

            @Override // com.anythink.basead.ui.MraidEndCardView.a
            public final void a() {
                BaseScreenAdView baseScreenAdView = BaseScreenAdView.this;
                if (3 == baseScreenAdView.a) {
                    if (baseScreenAdView.f6115d.C() == 1 && BaseScreenAdView.this.f6115d.E()) {
                        return;
                    }
                    BaseScreenAdView.this.h();
                }
            }
        });
        mraidEndCardView.init(z2);
        return mraidEndCardView;
    }

    static /* synthetic */ void a(BaseScreenAdView baseScreenAdView, int i2) {
        ac acVarX;
        Map<Integer, String[]> mapY;
        com.anythink.core.common.e.i iVar = baseScreenAdView.f6115d;
        if (!(iVar instanceof aa) || (acVarX = ((aa) iVar).X()) == null || (mapY = acVarX.y()) == null || mapY.size() <= 0) {
            return;
        }
        if (baseScreenAdView.W == null) {
            baseScreenAdView.W = new ConcurrentHashMap<>();
        }
        int i3 = i2 / 1000;
        for (Integer num : mapY.keySet()) {
            if (baseScreenAdView.W.get(num) == null || !baseScreenAdView.W.get(num).booleanValue()) {
                if (i3 >= num.intValue()) {
                    baseScreenAdView.W.put(num, Boolean.TRUE);
                    i iVarI = baseScreenAdView.i();
                    iVarI.f5936h.f5953i = num.intValue();
                    com.anythink.basead.a.b.a(32, baseScreenAdView.f6115d, iVarI);
                }
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected void b(int i2) {
        this.an = true;
        this.N = a(this.I, this.f6114c.f7312m.g());
        if (this.af || this.f6115d == null) {
            return;
        }
        super.b(i2);
    }

    static /* synthetic */ void b(BaseScreenAdView baseScreenAdView) {
        com.anythink.basead.a.b.a(1, baseScreenAdView.f6115d, baseScreenAdView.i());
        b.InterfaceC0141b interfaceC0141b = baseScreenAdView.E;
        if (interfaceC0141b != null) {
            interfaceC0141b.b();
        }
    }

    static /* synthetic */ void b(BaseScreenAdView baseScreenAdView, int i2) {
        long j2 = baseScreenAdView.ai;
        if (j2 >= 0 && i2 > j2) {
            baseScreenAdView.F();
            return;
        }
        if (baseScreenAdView.F) {
            long j3 = baseScreenAdView.ag;
            if (j3 < 0 || i2 < j3) {
                return;
            }
            baseScreenAdView.E();
        }
    }
}
