package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.arialyy.aria.core.listener.ISchedulers;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.widget.KSRatingBar;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends d implements View.OnClickListener {
    private ImageView fo;
    private TextView hb;
    private TextView lN;
    private AdTemplate mAdTemplate;
    private KsLogoView mLogoView;
    private DetailVideoView pv;
    private com.kwad.components.ad.reward.j qS;
    private ViewGroup sN;
    private int tt = Integer.MIN_VALUE;
    private ViewStub yW;
    private ViewGroup zR;
    private KSRatingBar zS;
    private TextView zT;
    private KsStyledTextButton zU;
    private TextView zV;

    static class a {
        private String os;
        private String qM;
        private String title;
        private float zX;
        private String zY;

        private a() {
        }

        public static a n(AdInfo adInfo) {
            if (adInfo == null) {
                return null;
            }
            a aVar = new a();
            aVar.title = com.kwad.sdk.core.response.a.a.bJ(adInfo);
            aVar.qM = com.kwad.sdk.core.response.a.a.ao(adInfo);
            aVar.os = com.kwad.sdk.core.response.a.a.bL(adInfo);
            aVar.zX = com.kwad.sdk.core.response.a.a.av(adInfo);
            aVar.zY = com.kwad.sdk.core.response.a.a.as(adInfo);
            return aVar;
        }

        public final String fo() {
            return this.os;
        }

        public final String gE() {
            return this.qM;
        }

        public final float getRating() {
            return this.zX;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String kp() {
            return this.zY;
        }
    }

    public p(AdTemplate adTemplate, com.kwad.components.ad.reward.j jVar, ViewGroup viewGroup, DetailVideoView detailVideoView) {
        this.mAdTemplate = adTemplate;
        this.sN = viewGroup;
        this.qS = jVar;
        this.pv = detailVideoView;
    }

    public p(AdTemplate adTemplate, com.kwad.components.ad.reward.j jVar, ViewStub viewStub, DetailVideoView detailVideoView) {
        this.mAdTemplate = adTemplate;
        this.yW = viewStub;
        this.qS = jVar;
        this.pv = detailVideoView;
    }

    private void initView() {
        this.zR = (ViewGroup) this.sN.findViewById(R.id.ksad_play_again_end_card);
        this.mLogoView = (KsLogoView) this.sN.findViewById(R.id.ksad_play_again_end_logo);
        this.fo = (ImageView) this.sN.findViewById(R.id.ksad_play_again_end_icon);
        this.hb = (TextView) this.sN.findViewById(R.id.ksad_play_again_end_title);
        this.zS = (KSRatingBar) this.sN.findViewById(R.id.ksad_play_again_end_score);
        this.zT = (TextView) this.sN.findViewById(R.id.ksad_play_again_end_count);
        this.lN = (TextView) this.sN.findViewById(R.id.ksad_play_again_end_desc);
        this.zU = (KsStyledTextButton) this.sN.findViewById(R.id.ksad_play_again_end_btn_download);
        this.zV = (TextView) this.sN.findViewById(R.id.ksad_play_again_end_btn_action);
        this.zR.setOnClickListener(this);
        this.zV.setOnClickListener(this);
        this.zU.setOnClickListener(this);
    }

    private void kn() {
        ViewGroup viewGroup = this.zR;
        if (viewGroup == null) {
            return;
        }
        boolean zCu = ah.cu(viewGroup.getContext());
        if (this.zR.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.zR.getLayoutParams();
            if (zCu) {
                int dimensionPixelSize = this.zR.getResources().getDimensionPixelSize(R.dimen.ksad_play_again_end_height_with_logo);
                layoutParams.width = -1;
                layoutParams.height = dimensionPixelSize;
            } else {
                layoutParams.width = com.kwad.sdk.b.kwai.a.getScreenWidth(this.zR.getContext()) / 2;
                layoutParams.height = -1;
            }
            this.zR.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(View view) {
        if (view == null || view.getWidth() == 0) {
            return;
        }
        if (ah.cu(view.getContext())) {
            view.setVisibility(0);
            Animator animatorA = t.a(this.mAdTemplate, this.zR, this.pv);
            if (animatorA != null) {
                animatorA.start();
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.rightMargin = -view.getWidth();
            this.zR.setLayoutParams(marginLayoutParams);
            Animator animatorA2 = t.a(this.mAdTemplate, this.pv, view);
            view.setVisibility(0);
            if (animatorA2 != null) {
                animatorA2.start();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(v vVar) {
        super.a(vVar);
        AdTemplate adTemplate = vVar.getAdTemplate();
        this.mLogoView.U(adTemplate);
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        a aVarN = a.n(adInfoCb);
        this.hb.setText(aVarN.getTitle());
        this.zT.setText(aVarN.kp());
        this.lN.setText(aVarN.gE());
        this.zU.setText(com.kwad.sdk.core.response.a.a.ax(adInfoCb));
        boolean zAy = com.kwad.sdk.core.response.a.a.ay(adInfoCb);
        boolean zCu = ah.cu(this.zR.getContext());
        Resources resources = this.zR.getResources();
        ViewGroup.LayoutParams layoutParams = this.fo.getLayoutParams();
        int i2 = 18;
        if (layoutParams != null) {
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_play_again_end_icon_size);
            if (!zCu) {
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_play_again_end_icon_size_horizontal);
                i2 = 14;
            } else if (zAy) {
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_play_again_end_icon_size_download);
                i2 = 24;
            }
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            this.fo.setLayoutParams(layoutParams);
        }
        KSImageLoader.loadAppIcon(this.fo, aVarN.fo(), adTemplate, i2);
        if (zCu && zAy) {
            if (aVarN.getRating() < 0.0f) {
                this.zS.setVisibility(8);
            } else {
                this.zS.setVisibility(0);
                this.zS.setStar(aVarN.getRating());
            }
            if (aVarN.kp() == null) {
                this.zT.setVisibility(8);
            } else {
                this.zT.setVisibility(0);
                this.zT.setText(aVarN.kp());
            }
        }
        if (zAy) {
            return;
        }
        this.zT.setVisibility(8);
        this.zS.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.k.d
    protected final void ad(boolean z2) {
        Resources resources = this.zR.getResources();
        ViewGroup.LayoutParams layoutParams = this.zR.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (z2) {
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = hc().getResources().getDimensionPixelSize(R.dimen.ksad_play_again_end_animate_margin);
            }
            this.zR.setBackgroundColor(-1);
            this.hb.setTextColor(resources.getColor(R.color.ksad_play_again_title_text_color));
            this.lN.setTextColor(resources.getColor(R.color.ksad_play_again_desc_text_color));
            this.tt = com.kwad.sdk.b.kwai.a.G(this.pv);
            com.kwad.sdk.b.kwai.a.o(this.pv, 49);
        } else {
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = 0;
            }
            this.hb.setTextColor(resources.getColor(R.color.ksad_play_again_title_text_color_horizontal));
            this.lN.setTextColor(resources.getColor(R.color.ksad_play_again_desc_text_color_horizontal));
            this.zR.setBackgroundColor(resources.getColor(R.color.ksad_play_again_horizontal_bg));
        }
        if (marginLayoutParams != null) {
            this.zR.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup hc() {
        return this.sN;
    }

    public final void hide() {
        ViewGroup viewGroup = this.sN;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final void ko() {
        int i2;
        DetailVideoView detailVideoView = this.pv;
        if (detailVideoView == null || (i2 = this.tt) == Integer.MIN_VALUE) {
            return;
        }
        com.kwad.sdk.b.kwai.a.o(detailVideoView, i2);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.zV)) {
            this.qS.C(false);
            com.kwad.sdk.core.report.a.p(this.mAdTemplate, ISchedulers.SUB_CANCEL);
        } else if (view.equals(this.zR)) {
            this.qS.a(2, view.getContext(), 2, 2);
        } else if (view.equals(this.zU)) {
            this.qS.a(2, view.getContext(), 2, 1);
        }
    }

    public final void show() {
        ViewStub viewStub;
        if (this.sN == null && (viewStub = this.yW) != null) {
            this.sN = (ViewGroup) viewStub.inflate();
            initView();
        }
        if (this.mLogoView == null) {
            initView();
        }
        if (this.sN != null) {
            kn();
            this.sN.setVisibility(0);
            this.sN.post(new Runnable() { // from class: com.kwad.components.ad.reward.k.p.1
                @Override // java.lang.Runnable
                public final void run() {
                    p pVar = p.this;
                    pVar.r(pVar.zR);
                }
            });
            y.b bVar = new y.b();
            bVar.akm = 205;
            com.kwad.sdk.core.report.a.a(this.mAdTemplate, ISchedulers.SUB_CANCEL, bVar, (JSONObject) null);
        }
    }
}
