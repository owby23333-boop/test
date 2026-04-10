package com.anythink.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.basead.e.b;
import com.anythink.basead.ui.PanelView;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.m;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class ThirdPartyFullScreenAdView extends BaseScreenAdView {
    public static final String TAG = ThirdPartyFullScreenAdView.class.getSimpleName();
    View ae;
    Timer af;
    private BaseAd ag;
    private final com.anythink.core.common.i.a ah;
    private final com.anythink.core.common.i.b ai;

    /* JADX INFO: renamed from: com.anythink.basead.ui.ThirdPartyFullScreenAdView$5, reason: invalid class name */
    final class AnonymousClass5 extends TimerTask {
        AnonymousClass5() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            ThirdPartyFullScreenAdView thirdPartyFullScreenAdView = ThirdPartyFullScreenAdView.this;
            ThirdPartyFullScreenAdView.a(thirdPartyFullScreenAdView, (int) thirdPartyFullScreenAdView.ag.getVideoProgress());
        }
    }

    public ThirdPartyFullScreenAdView(Context context) {
        super(context);
        this.ah = com.anythink.core.common.i.c.a();
        this.ai = new com.anythink.core.common.i.b() { // from class: com.anythink.basead.ui.ThirdPartyFullScreenAdView.1
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPartyFullScreenAdView.this.G();
            }
        };
    }

    private void K() {
        int i2 = this.L;
        if (i2 < 0) {
            return;
        }
        if (i2 > 0) {
            this.ah.a(this.ai, i2, true);
        } else {
            G();
        }
    }

    private void L() {
        ArrayList arrayList = new ArrayList();
        int iX = this.f6114c.f7312m.x();
        if (iX == 0) {
            arrayList.addAll(this.f6148y.getClickViews());
            arrayList.add(this.f6148y);
            BaseEndCardView baseEndCardView = this.f6149z;
            if (baseEndCardView != null) {
                arrayList.add(baseEndCardView);
            }
        } else if (iX != 1) {
            if (iX == 2) {
                arrayList.addAll(this.f6148y.getClickViews());
                arrayList.add(this.f6148y);
            }
        } else if (this.f6148y.getCTAButton() != null) {
            arrayList.add(this.f6148y.getCTAButton());
        }
        this.ag.registerListener(this, arrayList, null);
    }

    private void M() {
        if (this.af == null) {
            this.af = new Timer();
            this.af.schedule(new AnonymousClass5(), 0L, 300L);
        }
    }

    private void N() {
        Timer timer = this.af;
        if (timer != null) {
            timer.cancel();
        }
    }

    private void O() {
        Timer timer = this.af;
        if (timer != null) {
            timer.cancel();
            this.af = null;
        }
        this.ah.a(this.ai);
    }

    static /* synthetic */ void b(ThirdPartyFullScreenAdView thirdPartyFullScreenAdView) {
        Timer timer = thirdPartyFullScreenAdView.af;
        if (timer != null) {
            timer.cancel();
        }
    }

    private void e(int i2) {
        post(new f(this, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(int i2) {
        int i3 = i2 * 1000;
        CountDownView countDownView = this.H;
        if (countDownView != null && countDownView.isShown()) {
            this.H.refresh(i3);
        }
        int i4 = this.L;
        if (i4 < 0 || i3 < i4) {
            return;
        }
        G();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void A() {
        super.C();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void G() {
        super.G();
        this.ah.a(this.ai);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    @Override // com.anythink.basead.ui.BaseScreenAdView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void H() {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.ThirdPartyFullScreenAdView.H():void");
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void I() {
        View view = this.ae;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.ae.getParent()).removeView(this.ae);
        }
        CountDownView countDownView = this.H;
        if (countDownView != null) {
            countDownView.setVisibility(8);
        }
        MuteImageView muteImageView = this.K;
        if (muteImageView != null) {
            muteImageView.setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void J() {
        this.O = this.C;
        this.P = this.D;
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView, com.anythink.basead.ui.BaseAdView
    protected final void a() {
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_thirdparty_full_screen", "layout"), this);
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView, com.anythink.basead.ui.BaseAdView
    protected void destroy() {
        super.destroy();
        Timer timer = this.af;
        if (timer != null) {
            timer.cancel();
            this.af = null;
        }
        this.ah.a(this.ai);
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    public void init() {
        b();
        this.F = c(this.Q);
        this.ag.setNativeEventListener(new m() { // from class: com.anythink.basead.ui.ThirdPartyFullScreenAdView.2
            @Override // com.anythink.core.common.b.m
            public final void a(String str, String str2) {
                ThirdPartyFullScreenAdView.this.p();
                ThirdPartyFullScreenAdView.this.a(com.anythink.basead.c.f.a(str, str2));
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdClicked(View view) {
                b.InterfaceC0141b interfaceC0141b = ThirdPartyFullScreenAdView.this.E;
                if (interfaceC0141b != null) {
                    interfaceC0141b.a(1);
                }
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdDislikeButtonClick() {
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdImpressed() {
                b.InterfaceC0141b interfaceC0141b = ThirdPartyFullScreenAdView.this.E;
                if (interfaceC0141b != null) {
                    interfaceC0141b.a();
                }
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdVideoEnd() {
                ThirdPartyFullScreenAdView.b(ThirdPartyFullScreenAdView.this);
                ThirdPartyFullScreenAdView.this.G();
                b.InterfaceC0141b interfaceC0141b = ThirdPartyFullScreenAdView.this.E;
                if (interfaceC0141b != null) {
                    interfaceC0141b.c();
                }
                ThirdPartyFullScreenAdView.this.p();
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdVideoProgress(int i2) {
                ThirdPartyFullScreenAdView.b(ThirdPartyFullScreenAdView.this);
                ThirdPartyFullScreenAdView.a(ThirdPartyFullScreenAdView.this, i2);
            }

            @Override // com.anythink.core.common.b.l
            public final void onAdVideoStart() {
                ThirdPartyFullScreenAdView.a(ThirdPartyFullScreenAdView.this);
                b.InterfaceC0141b interfaceC0141b = ThirdPartyFullScreenAdView.this.E;
                if (interfaceC0141b != null) {
                    interfaceC0141b.b();
                }
            }

            @Override // com.anythink.core.common.b.l
            public final void onDeeplinkCallback(boolean z2) {
            }

            @Override // com.anythink.core.common.b.l
            public final void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            }
        });
        if (!this.f6144u) {
            int i2 = ((BaseScreenAdView) this).a;
            if (1 == i2 || 3 != i2) {
                return;
            }
            if (TextUtils.equals(this.ag.getAdType(), "1") && this.ae != null) {
                J();
                c();
                int i3 = this.L;
                if (i3 >= 0) {
                    if (i3 > 0) {
                        this.ah.a(this.ai, i3, true);
                        return;
                    } else {
                        G();
                        return;
                    }
                }
                return;
            }
        }
        J();
        p();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final int q() {
        int i2 = this.Q;
        return i2 == 8 ? i2 : this.C < this.D ? this.ac >= this.ad ? 1 : 5 : this.ac < this.ad ? 2 : 6;
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void u() {
        String strU = this.f6115d.u();
        if (TextUtils.isEmpty(strU)) {
            return;
        }
        com.anythink.basead.a.f.a();
        int[] iArrA = com.anythink.core.common.k.b.a(com.anythink.basead.a.f.a(2, strU));
        if (iArrA != null) {
            this.ac = iArrA[0];
            this.ad = iArrA[1];
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void v() {
        PanelView panelView = this.f6148y;
        if (panelView != null) {
            panelView.setVisibility(4);
            this.f6148y.init(this.f6115d, this.f6114c, this.f6143t, false, new PanelView.a() { // from class: com.anythink.basead.ui.ThirdPartyFullScreenAdView.3
                @Override // com.anythink.basead.ui.PanelView.a
                public final void a() {
                }

                @Override // com.anythink.basead.ui.PanelView.a
                public final boolean b() {
                    return false;
                }
            });
        }
        w();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void w() {
        if (this.f6148y != null) {
            if (com.anythink.basead.a.e.a(this.f6115d)) {
                this.Q = 0;
            } else {
                this.Q = 8;
            }
            this.f6148y.setLayoutType(this.Q);
            if (this.Q == 8 && this.f6114c.f7312m.x() == 0) {
                this.f6148y.getCTAButton().setVisibility(8);
            }
            this.f6148y.setVisibility(0);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void z() {
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
        this.K.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.ThirdPartyFullScreenAdView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ThirdPartyFullScreenAdView thirdPartyFullScreenAdView = ThirdPartyFullScreenAdView.this;
                if (thirdPartyFullScreenAdView.ae == null || thirdPartyFullScreenAdView.K == null || thirdPartyFullScreenAdView.ag == null) {
                    return;
                }
                ThirdPartyFullScreenAdView thirdPartyFullScreenAdView2 = ThirdPartyFullScreenAdView.this;
                thirdPartyFullScreenAdView2.M = !thirdPartyFullScreenAdView2.M;
                thirdPartyFullScreenAdView2.K.setMute(thirdPartyFullScreenAdView2.M);
                ThirdPartyFullScreenAdView.this.ag.setVideoMute(ThirdPartyFullScreenAdView.this.M);
            }
        });
    }

    static /* synthetic */ void a(ThirdPartyFullScreenAdView thirdPartyFullScreenAdView) {
        if (thirdPartyFullScreenAdView.af == null) {
            thirdPartyFullScreenAdView.af = new Timer();
            thirdPartyFullScreenAdView.af.schedule(thirdPartyFullScreenAdView.new AnonymousClass5(), 0L, 300L);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void c() {
        View view = this.ae;
        if (view != null) {
            this.f6146w.addView(view, 0, new RelativeLayout.LayoutParams(-1, -1));
            d(((int) this.ag.getVideoDuration()) * 1000);
            D();
            L();
        }
    }

    public ThirdPartyFullScreenAdView(Context context, j jVar, i iVar, String str, int i2, int i3, BaseAd baseAd) {
        super(context, jVar, iVar, str, i2, i3);
        this.ah = com.anythink.core.common.i.c.a();
        this.ai = new com.anythink.core.common.i.b() { // from class: com.anythink.basead.ui.ThirdPartyFullScreenAdView.1
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPartyFullScreenAdView.this.G();
            }
        };
        this.ag = baseAd;
        this.ae = this.ag.getAdMediaView(new Object[0]);
        setId(h.a(getContext(), "myoffer_thirdparty_full_screen_view_id", "id"));
        this.G = 0;
    }

    static /* synthetic */ void a(ThirdPartyFullScreenAdView thirdPartyFullScreenAdView, int i2) {
        thirdPartyFullScreenAdView.post(new f(thirdPartyFullScreenAdView, i2));
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final boolean c(int i2) {
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 5 || i2 == 6) {
            return com.anythink.basead.a.e.a(this.f6115d);
        }
        return i2 == 8;
    }
}
