package com.anythink.basead.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;

/* JADX INFO: loaded from: classes2.dex */
public class FullScreenAdView extends BaseScreenAdView {
    public static final String TAG = FullScreenAdView.class.getSimpleName();
    private GuideToClickView ae;

    public FullScreenAdView(Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void A() {
        if (this.f6144u) {
            C();
            return;
        }
        if (1 != ((BaseScreenAdView) this).a || this.f6145v) {
            B();
            p();
            return;
        }
        double dE = this.f6114c.f7312m.e();
        Double.isNaN(dE);
        double dCeil = Math.ceil(dE / 1000.0d);
        PlayerView playerView = this.f6147x;
        if (playerView != null) {
            double videoLength = playerView.getVideoLength();
            Double.isNaN(videoLength);
            double dCeil2 = Math.ceil(videoLength / 1000.0d);
            if (dCeil > dCeil2) {
                dCeil = dCeil2;
            }
        }
        RewardExitConfirmDialogActivity.a(getContext(), String.valueOf((int) dCeil), new Runnable() { // from class: com.anythink.basead.ui.FullScreenAdView.2
            @Override // java.lang.Runnable
            public final void run() {
                FullScreenAdView.this.B();
                FullScreenAdView.this.C();
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void D() {
        super.D();
        a(this.R, this.S);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00bf  */
    @Override // com.anythink.basead.ui.BaseScreenAdView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void H() {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.ui.FullScreenAdView.H():void");
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void I() {
        BaseShakeView baseShakeView;
        GuideToClickView guideToClickView;
        PlayerView playerView = this.f6147x;
        if (playerView != null) {
            this.f6146w.removeView(playerView);
            this.f6147x = null;
        }
        CountDownView countDownView = this.H;
        if (countDownView != null) {
            countDownView.setVisibility(8);
        }
        this.I.setClickAreaScaleFactor(this.N);
        MuteImageView muteImageView = this.K;
        if (muteImageView != null) {
            muteImageView.setVisibility(8);
        }
        BaseShakeView baseShakeView2 = this.R;
        if (baseShakeView2 != null) {
            baseShakeView2.setVisibility(8);
        }
        BaseShakeView baseShakeView3 = this.S;
        if (baseShakeView3 != null && this.Q != 8) {
            baseShakeView3.setVisibility(8);
        }
        if (this.f6114c.f7312m.i() == 1 && !getHasPerformClick() && (guideToClickView = this.ae) != null) {
            guideToClickView.setVisibility(0);
            this.ae.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.FullScreenAdView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FullScreenAdView.this.b(1);
                }
            });
        }
        if (n()) {
            PanelView panelView = this.f6148y;
            if (panelView != null) {
                panelView.setVisibility(8);
            }
            if (!m() || (baseShakeView = this.S) == null) {
                return;
            }
            baseShakeView.setVisibility(0);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void J() {
        this.O = this.C;
        this.P = this.D;
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView, com.anythink.basead.ui.BaseAdView
    protected final void a() {
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_full_screen", "layout"), this);
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView, com.anythink.basead.ui.BaseAdView
    protected final void b(int i2) {
        super.b(i2);
        GuideToClickView guideToClickView = this.ae;
        if (guideToClickView != null) {
            guideToClickView.setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final boolean c(int i2) {
        return (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 5 || i2 == 6) ? com.anythink.basead.a.e.a(this.f6115d) : i2 == 8;
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    public void init() {
        this.R = (BaseShakeView) findViewById(h.a(getContext(), "myoffer_shake_view", "id"));
        this.S = (BaseShakeView) findViewById(h.a(getContext(), "myoffer_shake_border_view", "id"));
        o();
        this.ae = (GuideToClickView) findViewById(h.a(getContext(), "myoffer_guide_to_click_view", "id"));
        super.init();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final int q() {
        int i2 = this.Q;
        return i2 == 8 ? i2 : this.C < this.D ? this.ac >= this.ad ? 1 : 5 : this.ac < this.ad ? 2 : 6;
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
        }
    }

    public FullScreenAdView(Context context, j jVar, i iVar, String str, int i2, int i3) {
        super(context, jVar, iVar, str, i2, i3);
        setId(h.a(getContext(), "myoffer_full_screen_view_id", "id"));
        this.G = 0;
    }
}
