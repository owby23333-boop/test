package com.anythink.basead.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;

/* JADX INFO: loaded from: classes2.dex */
public class HalfScreenAdView extends BaseScreenAdView {
    public static final String TAG = HalfScreenAdView.class.getSimpleName();
    private int ae;
    private RelativeLayout af;

    public HalfScreenAdView(Context context) {
        super(context);
    }

    private void K() {
        if (!com.anythink.basead.a.e.a(this.f6115d)) {
            this.ae = 7;
        } else if (L()) {
            this.ae = 3;
        } else {
            this.ae = 4;
        }
    }

    private boolean L() {
        return this.aa <= this.ab;
    }

    private boolean M() {
        return !com.anythink.basead.a.e.a(this.f6115d);
    }

    private void N() {
        int i2;
        int i3;
        int i4;
        int iA;
        int i5;
        int i6;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f6148y.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f6146w.getLayoutParams();
        int i7 = layoutParams2.leftMargin;
        int i8 = layoutParams2.rightMargin;
        int i9 = layoutParams2.topMargin;
        int i10 = layoutParams2.bottomMargin;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f6147x.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.af.getLayoutParams();
        int iB = h.b(getContext());
        if (iB <= 0) {
            iB = h.a(getContext(), 25.0f);
        }
        int i11 = this.ae;
        if (i11 != 7) {
            if (i11 != 3) {
                View viewFindViewById = this.f6148y.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
                i2 = viewFindViewById != null ? ((RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams()).topMargin : 0;
                if (this.f6143t == 1) {
                    i4 = (this.C - i7) - i8;
                    i3 = (int) (i4 / 1.032258f);
                    this.O = i4;
                    this.P = (int) (this.O / 2.0f);
                    i5 = this.P;
                    iA = (i3 - i5) + i2;
                } else {
                    if (i9 < iB) {
                        i9 = (int) (iB * 1.1f);
                        layoutParams2.topMargin = i9;
                    }
                    i3 = (this.D - i9) - i10;
                    i4 = (int) (i3 * 1.032258f);
                    this.O = i4;
                    this.P = (int) (this.O / 2.0f);
                    iA = (i3 - this.P) + i2;
                    layoutParams2.width = i4;
                    this.f6146w.setLayoutParams(layoutParams2);
                }
            } else if (this.f6143t == 1) {
                View viewFindViewById2 = this.f6148y.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
                i2 = viewFindViewById2 != null ? ((RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams()).topMargin : 0;
                i4 = (this.C - i7) - i8;
                float f2 = i4;
                i3 = (int) (f2 / 0.5714286f);
                if (this.D < (h.a(getContext(), 28.0f) * 2) + i3) {
                    iA = (int) (f2 / 1.8181819f);
                    this.O = i4;
                    this.P = (i3 - iA) + i2;
                } else {
                    this.O = i4;
                    this.P = (int) (this.O / 0.8f);
                    i5 = this.P;
                    iA = (i3 - i5) + i2;
                }
            } else {
                if (i9 < iB) {
                    i9 = (int) (iB * 1.1f);
                    layoutParams2.topMargin = i9;
                }
                i3 = (this.D - i9) - i10;
                i4 = (int) (i3 * 1.6f);
                this.P = i3;
                this.O = (int) (this.P * 0.56f);
                i6 = i4 - this.O;
                layoutParams2.width = i4;
                this.f6146w.setLayoutParams(layoutParams2);
                iA = i3;
            }
            layoutParams4.width = i4;
            layoutParams4.height = i3;
            this.af.setLayoutParams(layoutParams4);
            layoutParams3.width = this.O;
            layoutParams3.height = this.P;
            this.f6147x.setLayoutParams(layoutParams3);
            layoutParams.width = i6;
            layoutParams.height = iA;
            this.f6148y.setLayoutParams(layoutParams);
        }
        if (this.f6143t == 2) {
            i3 = (this.D - i9) - i10;
            i4 = (int) (i3 * 1.75f);
            iA = h.a(getContext(), 120.0f);
            if (i9 < iB) {
                layoutParams2.topMargin = (int) (iB * 1.1f);
            }
            layoutParams2.width = i4;
            this.f6146w.setLayoutParams(layoutParams2);
        } else if (L()) {
            i4 = (this.C - i7) - i8;
            i3 = (int) (i4 / 0.5714286f);
            iA = h.a(getContext(), 240.0f);
        } else {
            i4 = (this.C - i7) - i8;
            i3 = (int) (i4 / 1.032258f);
            iA = h.a(getContext(), 120.0f);
        }
        this.O = i4;
        this.P = i3;
        i6 = i4;
        layoutParams4.width = i4;
        layoutParams4.height = i3;
        this.af.setLayoutParams(layoutParams4);
        layoutParams3.width = this.O;
        layoutParams3.height = this.P;
        this.f6147x.setLayoutParams(layoutParams3);
        layoutParams.width = i6;
        layoutParams.height = iA;
        this.f6148y.setLayoutParams(layoutParams);
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void A() {
        super.B();
        super.C();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void F() {
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void H() {
        if (this.af == null || this.f6149z == null) {
            return;
        }
        this.af.addView(this.f6149z, 1, this.f6147x.getLayoutParams());
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void I() {
        PlayerView playerView = this.f6147x;
        if (playerView != null) {
            this.af.removeView(playerView);
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
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void J() {
        int i2;
        int i3;
        int i4;
        int iA;
        int i5;
        int i6;
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f6148y.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f6146w.getLayoutParams();
            int i7 = layoutParams2.leftMargin;
            int i8 = layoutParams2.rightMargin;
            int i9 = layoutParams2.topMargin;
            int i10 = layoutParams2.bottomMargin;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f6147x.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.af.getLayoutParams();
            int iB = h.b(getContext());
            if (iB <= 0) {
                iB = h.a(getContext(), 25.0f);
            }
            if (this.ae != 7) {
                if (this.ae != 3) {
                    View viewFindViewById = this.f6148y.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
                    i2 = viewFindViewById != null ? ((RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams()).topMargin : 0;
                    if (this.f6143t == 1) {
                        i4 = (this.C - i7) - i8;
                        i3 = (int) (i4 / 1.032258f);
                        this.O = i4;
                        this.P = (int) (this.O / 2.0f);
                        i5 = this.P;
                        iA = (i3 - i5) + i2;
                    } else {
                        if (i9 < iB) {
                            i9 = (int) (iB * 1.1f);
                            layoutParams2.topMargin = i9;
                        }
                        i3 = (this.D - i9) - i10;
                        i4 = (int) (i3 * 1.032258f);
                        this.O = i4;
                        this.P = (int) (this.O / 2.0f);
                        iA = (i3 - this.P) + i2;
                        layoutParams2.width = i4;
                        this.f6146w.setLayoutParams(layoutParams2);
                    }
                } else if (this.f6143t == 1) {
                    View viewFindViewById2 = this.f6148y.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
                    i2 = viewFindViewById2 != null ? ((RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams()).topMargin : 0;
                    i4 = (this.C - i7) - i8;
                    float f2 = i4;
                    i3 = (int) (f2 / 0.5714286f);
                    if (this.D < (h.a(getContext(), 28.0f) * 2) + i3) {
                        iA = (int) (f2 / 1.8181819f);
                        this.O = i4;
                        this.P = (i3 - iA) + i2;
                    } else {
                        this.O = i4;
                        this.P = (int) (this.O / 0.8f);
                        i5 = this.P;
                        iA = (i3 - i5) + i2;
                    }
                } else {
                    if (i9 < iB) {
                        i9 = (int) (iB * 1.1f);
                        layoutParams2.topMargin = i9;
                    }
                    i3 = (this.D - i9) - i10;
                    i4 = (int) (i3 * 1.6f);
                    this.P = i3;
                    this.O = (int) (this.P * 0.56f);
                    i6 = i4 - this.O;
                    layoutParams2.width = i4;
                    this.f6146w.setLayoutParams(layoutParams2);
                    iA = i3;
                }
                layoutParams4.width = i4;
                layoutParams4.height = i3;
                this.af.setLayoutParams(layoutParams4);
                layoutParams3.width = this.O;
                layoutParams3.height = this.P;
                this.f6147x.setLayoutParams(layoutParams3);
                layoutParams.width = i6;
                layoutParams.height = iA;
                this.f6148y.setLayoutParams(layoutParams);
            }
            if (this.f6143t == 2) {
                i3 = (this.D - i9) - i10;
                i4 = (int) (i3 * 1.75f);
                iA = h.a(getContext(), 120.0f);
                if (i9 < iB) {
                    layoutParams2.topMargin = (int) (iB * 1.1f);
                }
                layoutParams2.width = i4;
                this.f6146w.setLayoutParams(layoutParams2);
            } else if (L()) {
                i4 = (this.C - i7) - i8;
                i3 = (int) (i4 / 0.5714286f);
                iA = h.a(getContext(), 240.0f);
            } else {
                i4 = (this.C - i7) - i8;
                i3 = (int) (i4 / 1.032258f);
                iA = h.a(getContext(), 120.0f);
            }
            this.O = i4;
            this.P = i3;
            i6 = i4;
            layoutParams4.width = i4;
            layoutParams4.height = i3;
            this.af.setLayoutParams(layoutParams4);
            layoutParams3.width = this.O;
            layoutParams3.height = this.P;
            this.f6147x.setLayoutParams(layoutParams3);
            layoutParams.width = i6;
            layoutParams.height = iA;
            this.f6148y.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView, com.anythink.basead.ui.BaseAdView
    protected final void a() {
        int i2 = this.ae;
        if (i2 == 3) {
            LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_half_screen_vertical", "layout"), this);
        } else if (i2 != 7) {
            LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_half_screen_horizontal", "layout"), this);
        } else {
            LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_half_screen_empty_info", "layout"), this);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void b() {
        super.b();
        this.af = (RelativeLayout) this.f6146w.findViewById(h.a(getContext(), "myoffer_rl_container", "id"));
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final boolean c(int i2) {
        return true;
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView, com.anythink.basead.ui.BaseAdView
    protected final void d() {
        super.d();
        if (!com.anythink.basead.a.e.a(this.f6115d)) {
            this.ae = 7;
        } else if (L()) {
            this.ae = 3;
        } else {
            this.ae = 4;
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final int q() {
        return this.Q;
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void w() {
        PanelView panelView = this.f6148y;
        if (panelView != null) {
            this.Q = this.ae;
            panelView.setLayoutType(this.Q);
            if (this.ae == 7) {
                if (this.f6114c.f7312m.x() == 0) {
                    this.f6148y.getCTAButton().setVisibility(8);
                }
                if (m()) {
                    this.R = (BaseShakeView) findViewById(h.a(getContext(), "myoffer_shake_view", "id"));
                    this.S = (BaseShakeView) findViewById(h.a(getContext(), "myoffer_shake_border_view", "id"));
                    o();
                    a(this.R, this.S);
                }
            }
        }
        super.E();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void y() {
    }

    public HalfScreenAdView(Context context, j jVar, i iVar, String str, int i2, int i3) {
        super(context, jVar, iVar, str, i2, i3);
        setId(h.a(getContext(), "myoffer_half_screen_view_id", "id"));
        this.G = 1;
    }
}
