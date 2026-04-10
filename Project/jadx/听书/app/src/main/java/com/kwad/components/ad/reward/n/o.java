package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.KsAuthorIconView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends s implements View.OnClickListener {
    private KsAuthorIconView De;
    private RelativeLayout Df;
    private String fA;
    private KsLogoView fB;
    private TextView fu;
    private TextView fv;
    private TextView fw;
    private KsLogoView fx;
    private com.kwad.components.ad.reward.g tm;
    private boolean fs = false;
    private Runnable fI = new Runnable() { // from class: com.kwad.components.ad.reward.n.o.2
        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.c.a.a.a(o.this.fv, o.this.fA, KsLogoView.a(o.this.fB));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                o.this.fv.setText(o.this.fA);
                o.this.fv.setVisibility(0);
            }
        }
    };

    public o(com.kwad.components.ad.reward.g gVar) {
        this.tm = gVar;
    }

    public final void b(ViewGroup viewGroup, int i) {
        if (i == 8) {
            super.a(viewGroup, R.id.ksad_reward_origin_live_shop_stub, R.id.ksad_reward_origin_live_root);
            this.fs = true;
        } else {
            super.a(viewGroup, R.id.ksad_reward_origin_live_base_stub, R.id.ksad_reward_origin_live_root);
            this.fs = false;
        }
        initView();
    }

    private void initView() {
        if (this.vV == null) {
            return;
        }
        this.De = (KsAuthorIconView) this.vV.findViewById(R.id.ksad_live_author_icon);
        this.fu = (TextView) this.vV.findViewById(R.id.kwad_actionbar_title);
        this.fv = (TextView) this.vV.findViewById(R.id.kwad_actionbar_des_text);
        this.fw = (TextView) this.vV.findViewById(R.id.ksad_live_actionbar_btn);
        this.fx = (KsLogoView) this.vV.findViewById(R.id.ksad_reward_live_kwai_logo);
        if (!this.fs) {
            this.Df = (RelativeLayout) this.vV.findViewById(R.id.ksad_reward_origin_live_relative);
        }
        this.vV.setOnClickListener(this);
        this.fw.setOnClickListener(this);
        this.De.setOnClickListener(this);
        this.fv.setOnClickListener(this);
        this.fu.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void a(r rVar) {
        super.a(rVar);
        j(rVar.getAdTemplate());
    }

    private void j(AdTemplate adTemplate) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.fu.setText(com.kwad.sdk.core.response.b.a.cl(adInfoEl));
        com.kwad.components.core.widget.e eVar = new com.kwad.components.core.widget.e();
        this.De.setVisibility(0);
        this.De.j(adTemplate);
        this.De.a(eVar);
        this.fw.setText(com.kwad.sdk.core.response.b.a.aE(adInfoEl));
        if (com.kwad.sdk.core.response.b.a.bf(adInfoEl) == 8) {
            this.fx.setVisibility(0);
            this.fx.aP(adTemplate);
            this.fv.setText(com.kwad.sdk.core.response.b.a.au(adInfoEl));
        } else {
            this.fA = com.kwad.sdk.core.response.b.a.au(adInfoEl);
            KsLogoView ksLogoView = new KsLogoView(this.vV.getContext(), false);
            this.fB = ksLogoView;
            ksLogoView.setLogoLoadFinishListener(new KsLogoView.a() { // from class: com.kwad.components.ad.reward.n.o.1
                @Override // com.kwad.components.core.widget.KsLogoView.a
                public final void bE() {
                    o.this.fv.post(o.this.fI);
                }
            });
            this.fB.aP(adTemplate);
            this.fx.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void ac(boolean z) {
        super.ac(z);
        Context context = this.vV.getContext();
        if (aq.QW()) {
            return;
        }
        if (!this.fs) {
            this.vV.findViewById(R.id.ksad_reward_origin_live_base1).setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.Df.getLayoutParams();
            layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
            this.Df.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.fw.getLayoutParams();
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
            this.fw.setLayoutParams(layoutParams2);
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = this.vV.getLayoutParams();
        layoutParams3.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.vV.setLayoutParams(layoutParams3);
        i(this.vV, 85);
    }

    private static void i(View view, int i) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = com.kwad.sdk.c.a.a.a(view.getContext(), 20.0f);
            view.requestLayout();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.fw)) {
            this.tm.a(1, view.getContext(), 29, 1);
            return;
        }
        if (view.equals(this.De)) {
            this.tm.a(1, view.getContext(), 30, 1);
            return;
        }
        if (view.equals(this.fv)) {
            this.tm.a(1, view.getContext(), 32, 1);
        } else if (view.equals(this.fu)) {
            this.tm.a(1, view.getContext(), 31, 1);
        } else if (view.equals(this.vV)) {
            this.tm.a(1, view.getContext(), 53, 2);
        }
    }
}
