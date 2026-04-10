package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends KSFrameLayout implements com.kwad.sdk.widget.c {
    private ImageView dI;
    private TextView eD;
    private ImageView eL;
    private KSFrameLayout kW;
    private KSFrameLayout kd;
    private String lY;

    @Nullable
    private View lZ;
    private AdTemplate mAdTemplate;
    private KsLogoView mLogoView;
    private ImageView ma;
    private TextProgressBar mb;
    private ViewGroup mc;
    private ViewGroup md;

    /* JADX INFO: renamed from: me, reason: collision with root package name */
    private ImageView f16959me;
    private View mf;
    private View mg;
    private TextView mh;
    private ImageView mi;
    private TextView mj;
    private TextView mk;
    private TextView ml;
    private TextProgressBar mm;
    private TextView mn;
    private i mo;
    private final a mp;
    private boolean mq;

    public static class a {
        private boolean ms = false;
        private boolean mt = false;
        private int mu = 0;
        private boolean mv = true;

        public final void I(int i2) {
            this.mu = i2;
        }

        public final int eF() {
            return this.mu;
        }

        public final boolean eG() {
            return this.mv;
        }

        public final void v(boolean z2) {
            this.ms = z2;
        }

        public final void w(boolean z2) {
            this.mt = z2;
        }

        public final void x(boolean z2) {
            this.mv = z2;
        }
    }

    public f(@NonNull Context context, a aVar) {
        super(context);
        this.lY = "%s秒后进入试玩页";
        this.mq = false;
        this.mp = aVar;
        com.kwad.sdk.i.a.inflate(context, this.mp.eG() ? R.layout.ksad_interstitial_native_above : R.layout.ksad_interstitial_native, this);
        s(this.mp.ms);
    }

    private void a(View view, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = com.kwad.sdk.b.kwai.a.a(getContext(), i2);
        layoutParams.height = com.kwad.sdk.b.kwai.a.a(getContext(), i3);
        view.setLayoutParams(layoutParams);
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z2) {
        kSFrameLayout.setClickable(true);
        new com.kwad.sdk.widget.f(kSFrameLayout, this);
        this.kd.setWidthBasedRatio(!z2);
    }

    private void b(View view, boolean z2) {
        i iVar;
        i iVar2;
        i iVar3 = this.mo;
        if (iVar3 != null) {
            iVar3.p(z2);
            this.mo.a(this.kW);
        }
        if (view.equals(this)) {
            i iVar4 = this.mo;
            if (iVar4 != null) {
                iVar4.dQ();
                return;
            }
            return;
        }
        if (view.equals(this.mf)) {
            if (!(1 == this.mp.eF()) || (iVar2 = this.mo) == null) {
                return;
            }
            iVar2.dP();
            return;
        }
        if (view.equals(this.mm)) {
            i iVar5 = this.mo;
            if (iVar5 != null) {
                iVar5.dR();
                return;
            }
            return;
        }
        if (view.equals(this.md)) {
            i iVar6 = this.mo;
            if (iVar6 != null) {
                iVar6.ec();
                return;
            }
            return;
        }
        if (view.equals(this.mb)) {
            i iVar7 = this.mo;
            if (iVar7 != null) {
                iVar7.dS();
                return;
            }
            return;
        }
        if (view.equals(this.mg)) {
            i iVar8 = this.mo;
            if (iVar8 != null) {
                iVar8.dV();
                return;
            }
            return;
        }
        if (view.equals(this.kd)) {
            i iVar9 = this.mo;
            if (iVar9 != null) {
                iVar9.dT();
                return;
            }
            return;
        }
        if (view.equals(this.eL)) {
            i iVar10 = this.mo;
            if (iVar10 != null) {
                iVar10.dU();
                return;
            }
            return;
        }
        if (view.equals(this.dI)) {
            i iVar11 = this.mo;
            if (iVar11 != null) {
                iVar11.dW();
                return;
            }
            return;
        }
        if (view.equals(this.mj)) {
            i iVar12 = this.mo;
            if (iVar12 != null) {
                iVar12.dX();
                return;
            }
            return;
        }
        if (view.equals(this.eD)) {
            i iVar13 = this.mo;
            if (iVar13 != null) {
                iVar13.dY();
                return;
            }
            return;
        }
        if (view.equals(this.mi)) {
            i iVar14 = this.mo;
            if (iVar14 != null) {
                iVar14.dZ();
                return;
            }
            return;
        }
        if (view.equals(this.mk)) {
            i iVar15 = this.mo;
            if (iVar15 != null) {
                iVar15.ea();
                return;
            }
            return;
        }
        if (!view.equals(this.ml) || (iVar = this.mo) == null) {
            return;
        }
        iVar.eb();
    }

    private void d(View view, int i2) {
        com.kwad.sdk.b.kwai.a.b(view, 0, com.kwad.sdk.b.kwai.a.a(getContext(), i2), 0, 0);
    }

    private void ez() {
        a(this.mi, 40, 40);
        a(this.mm, 130, 30);
        this.mk.setTextSize(14.0f);
        d(this.mm, 11);
        d(this.mk, 7);
        d(this.ml, 7);
    }

    private void s(boolean z2) {
        setClickable(true);
        this.kW = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_container);
        this.kd = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_video_container);
        this.lZ = findViewById(R.id.ksad_interstitial_full_bg);
        this.ma = (ImageView) findViewById(R.id.ksad_interstitial_tail_frame);
        this.eL = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_interstitial_logo);
        this.mc = (ViewGroup) findViewById(R.id.ksad_interstitial_playing);
        this.md = (ViewGroup) findViewById(R.id.ksad_interstitial_play_end);
        this.mb = (TextProgressBar) findViewById(R.id.ksad_interstitial_download_btn);
        this.mf = findViewById(R.id.ksad_interstitial_close_outer);
        TextProgressBar textProgressBar = this.mb;
        if (textProgressBar != null) {
            textProgressBar.setTextDimen(com.kwad.sdk.b.kwai.a.a(getContext(), 10.0f));
            this.mb.setTextColor(-1);
        }
        this.f16959me = (ImageView) findViewById(R.id.ksad_interstitial_mute);
        this.mh = (TextView) findViewById(R.id.ksad_interstitial_count_down);
        this.mi = (ImageView) findViewById(R.id.ksad_interstitial_logo);
        this.mk = (TextView) findViewById(R.id.ksad_interstitial_name);
        this.ml = (TextView) findViewById(R.id.ksad_interstitial_desc);
        this.mm = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.mg = findViewById(R.id.ksad_ad_download_container);
        this.dI = (ImageView) findViewById(R.id.ksad_app_icon);
        this.mj = (TextView) findViewById(R.id.ksad_app_title);
        this.eD = (TextView) findViewById(R.id.ksad_app_desc);
        new com.kwad.sdk.widget.f(this, this);
        new com.kwad.sdk.widget.f(this.eL, this);
        new com.kwad.sdk.widget.f(this.mb, this);
        new com.kwad.sdk.widget.f(this.mm, this);
        new com.kwad.sdk.widget.f(this.mf, this);
        new com.kwad.sdk.widget.f(this.md, this);
        new com.kwad.sdk.widget.f(this.mh, this);
        new com.kwad.sdk.widget.f(this.mg, this);
        new com.kwad.sdk.widget.f(this.dI, this);
        new com.kwad.sdk.widget.f(this.mj, this);
        new com.kwad.sdk.widget.f(this.eD, this);
        new com.kwad.sdk.widget.f(this.mi, this);
        new com.kwad.sdk.widget.f(this.mk, this);
        new com.kwad.sdk.widget.f(this.ml, this);
        this.f16959me.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.interstitial.e.f.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.f16959me.setSelected(!f.this.f16959me.isSelected());
                if (f.this.mo != null) {
                    f.this.mo.o(f.this.f16959me.isSelected());
                }
            }
        });
        this.mn = (TextView) findViewById(R.id.ksad_interstitial_playable_timer);
        a(this.kd, z2);
        if (ah.DI()) {
            return;
        }
        ez();
    }

    public final void C(String str) {
        TextView textView = this.mh;
        if (textView == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (!this.mp.mt || this.mq || this.mh.getVisibility() == 0) {
            return;
        }
        this.mh.setVisibility(0);
    }

    public final void a(float f2, com.kwad.sdk.core.video.videoview.a aVar) {
        this.kd.setRatio(f2);
        this.kd.addView(aVar);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 17;
        aVar.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    public final void a(AdTemplate adTemplate, AdInfo adInfo) {
        TextView textView;
        String strBJ;
        TextProgressBar textProgressBar;
        String strAx;
        this.mi.setImageResource(R.drawable.ksad_default_app_icon);
        if (com.kwad.sdk.core.response.a.a.cg(adInfo)) {
            KSImageLoader.loadCircleIcon(this.mi, com.kwad.sdk.core.response.a.a.cl(adInfo), getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon));
            this.mk.setText(com.kwad.sdk.core.response.a.a.bK(adInfo));
            this.ml.setText(com.kwad.sdk.core.response.a.a.ao(adInfo));
            if (com.kwad.sdk.core.response.a.a.ch(adInfo)) {
                textProgressBar = this.mm;
                strAx = com.kwad.components.ad.c.b.ah();
            } else {
                textProgressBar = this.mm;
                strAx = com.kwad.components.ad.c.b.ak();
            }
        } else if (com.kwad.components.ad.interstitial.kwai.b.c(adInfo)) {
            AdProductInfo adProductInfoCr = com.kwad.sdk.core.response.a.a.cr(adInfo);
            KSImageLoader.loadWithRadius(this.mi, adProductInfoCr.icon, adTemplate, 4);
            this.mk.setText(adProductInfoCr.name);
            this.ml.setVisibility(8);
            textProgressBar = this.mm;
            strAx = com.kwad.components.ad.c.b.ai();
        } else {
            if (com.kwad.sdk.core.response.a.a.ay(adInfo)) {
                KSImageLoader.loadWithRadius(this.mi, com.kwad.sdk.core.response.a.a.bL(adInfo), adTemplate, 4);
                textView = this.mk;
                strBJ = com.kwad.sdk.core.response.a.a.ap(adInfo);
            } else {
                KSImageLoader.loadWithRadius(this.mi, com.kwad.sdk.core.response.a.d.cf(adTemplate), adTemplate, 4);
                textView = this.mk;
                strBJ = com.kwad.sdk.core.response.a.a.bJ(adInfo);
            }
            textView.setText(strBJ);
            this.ml.setText(com.kwad.sdk.core.response.a.a.ao(adInfo));
            textProgressBar = this.mm;
            strAx = com.kwad.sdk.core.response.a.a.ax(adInfo);
        }
        textProgressBar.f(strAx, 0);
    }

    public final void a(String str, AdTemplate adTemplate) {
        if (ba.isNullString(str)) {
            return;
        }
        this.eL.setImageDrawable(null);
        KSImageLoader.loadImage(this.eL, str, adTemplate);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            b(view, false);
        }
    }

    public final void b(boolean z2, int i2) {
        TextView textView = this.mn;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        if (i2 >= 0) {
            this.mn.setText(String.format(this.lY, String.valueOf(i2)));
        }
    }

    public final void b(boolean z2, boolean z3) {
        if (this.eL != null) {
            this.eL.setVisibility(z2 ? 0 : 8);
            this.eL.setClickable(z3);
        }
    }

    public final void eA() {
        TextView textView = this.mh;
        if (textView != null) {
            textView.setVisibility(8);
            this.mq = true;
        }
    }

    public final void eB() {
        View view = this.mf;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void eC() {
        t(false);
        this.md.setVisibility(0);
        this.ma.setVisibility(0);
    }

    public final void eD() {
        this.md.setVisibility(8);
        this.ma.setVisibility(8);
        t(true);
    }

    public final boolean eE() {
        ViewGroup viewGroup = this.md;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    public final void f(int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.width = i2;
        marginLayoutParams.height = i3;
        setLayoutParams(marginLayoutParams);
    }

    @Nullable
    public final View getBlurBgView() {
        return this.lZ;
    }

    public final ImageView getTailFrameView() {
        return this.ma;
    }

    public final void h(String str, int i2) {
        TextProgressBar textProgressBar = this.mb;
        if (textProgressBar != null) {
            textProgressBar.f(str, 0);
        }
        TextProgressBar textProgressBar2 = this.mm;
        if (textProgressBar2 != null) {
            textProgressBar2.f(str, 0);
        }
    }

    public final void j(AdTemplate adTemplate) {
        this.mLogoView.U(adTemplate);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void setViewListener(i iVar) {
        this.mo = iVar;
    }

    public final void t(boolean z2) {
        if (this.mc != null) {
            this.mc.setVisibility(z2 ? 0 : 8);
        }
    }

    public final void u(boolean z2) {
        ImageView imageView = this.f16959me;
        if (imageView != null) {
            imageView.setSelected(z2);
        }
    }
}
