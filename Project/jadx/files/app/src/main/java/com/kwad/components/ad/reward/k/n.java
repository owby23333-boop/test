package com.kwad.components.ad.reward.k;

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
import com.kwad.sdk.utils.ah;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends w implements View.OnClickListener {
    private TextView lN;
    private com.kwad.components.ad.reward.j qS;
    private KsLogoView zB;
    private KsLogoView zC;
    private KsAuthorIconView zD;
    private RelativeLayout zE;
    private String zG;
    private TextView zb;
    private TextView zc;
    private boolean zF = false;
    private Runnable zH = new Runnable() { // from class: com.kwad.components.ad.reward.k.n.2
        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.b.kwai.a.a(n.this.lN, n.this.zG, KsLogoView.a(n.this.zB));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                n.this.lN.setText(n.this.zG);
                n.this.lN.setVisibility(0);
            }
        }
    };

    public n(com.kwad.components.ad.reward.j jVar) {
        this.qS = jVar;
    }

    private void bindView(AdTemplate adTemplate) {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.zb.setText(com.kwad.sdk.core.response.a.a.bJ(adInfoCb));
        com.kwad.components.core.widget.e eVar = new com.kwad.components.core.widget.e();
        this.zD.setVisibility(0);
        this.zD.bindView(adTemplate);
        this.zD.a(eVar);
        this.zc.setText(com.kwad.sdk.core.response.a.a.ax(adInfoCb));
        if (com.kwad.sdk.core.response.a.a.aY(adInfoCb) == 8) {
            this.zC.setVisibility(0);
            this.zC.U(adTemplate);
            this.lN.setText(com.kwad.sdk.core.response.a.a.ao(adInfoCb));
        } else {
            this.zG = com.kwad.sdk.core.response.a.a.ao(adInfoCb);
            this.zB = new KsLogoView(this.sN.getContext(), false);
            this.zB.setLogoLoadFinishListener(new KsLogoView.a() { // from class: com.kwad.components.ad.reward.k.n.1
                @Override // com.kwad.components.core.widget.KsLogoView.a
                public final void km() {
                    n.this.lN.post(n.this.zH);
                }
            });
            this.zB.U(adTemplate);
            this.zC.setVisibility(8);
        }
    }

    private static void h(View view, int i2) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = com.kwad.sdk.b.kwai.a.a(view.getContext(), 20.0f);
            view.requestLayout();
        }
    }

    private void initView() {
        ViewGroup viewGroup = this.sN;
        if (viewGroup == null) {
            return;
        }
        this.zD = (KsAuthorIconView) viewGroup.findViewById(R.id.ksad_live_author_icon);
        this.zb = (TextView) this.sN.findViewById(R.id.kwad_actionbar_title);
        this.lN = (TextView) this.sN.findViewById(R.id.kwad_actionbar_des_text);
        this.zc = (TextView) this.sN.findViewById(R.id.ksad_live_actionbar_btn);
        this.zC = (KsLogoView) this.sN.findViewById(R.id.ksad_reward_live_kwai_logo);
        if (!this.zF) {
            this.zE = (RelativeLayout) this.sN.findViewById(R.id.ksad_reward_origin_live_relative);
        }
        this.sN.setOnClickListener(this);
        this.zc.setOnClickListener(this);
        this.zD.setOnClickListener(this);
        this.lN.setOnClickListener(this);
        this.zb.setOnClickListener(this);
    }

    public final void a(ViewGroup viewGroup, int i2) {
        boolean z2;
        if (i2 == 8) {
            super.a(viewGroup, R.id.ksad_reward_origin_live_shop_stub, R.id.ksad_reward_origin_live_root);
            z2 = true;
        } else {
            super.a(viewGroup, R.id.ksad_reward_origin_live_base_stub, R.id.ksad_reward_origin_live_root);
            z2 = false;
        }
        this.zF = z2;
        initView();
    }

    @Override // com.kwad.components.ad.reward.k.d
    protected final void a(v vVar) {
        super.a(vVar);
        bindView(vVar.getAdTemplate());
    }

    @Override // com.kwad.components.ad.reward.k.d
    protected final void ad(boolean z2) {
        super.ad(z2);
        Context context = this.sN.getContext();
        if (ah.cu(context)) {
            return;
        }
        if (this.zF) {
            ViewGroup.LayoutParams layoutParams = this.sN.getLayoutParams();
            layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
            this.sN.setLayoutParams(layoutParams);
            h(this.sN, 85);
            return;
        }
        this.sN.findViewById(R.id.ksad_reward_origin_live_base1).setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = this.zE.getLayoutParams();
        layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.zE.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.zc.getLayoutParams();
        layoutParams3.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.zc.setLayoutParams(layoutParams3);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.reward.j jVar;
        Context context;
        int i2;
        if (view.equals(this.zc)) {
            jVar = this.qS;
            context = view.getContext();
            i2 = 29;
        } else if (view.equals(this.zD)) {
            jVar = this.qS;
            context = view.getContext();
            i2 = 30;
        } else if (view.equals(this.lN)) {
            jVar = this.qS;
            context = view.getContext();
            i2 = 32;
        } else if (!view.equals(this.zb)) {
            if (view.equals(this.sN)) {
                this.qS.a(1, view.getContext(), 53, 2);
                return;
            }
            return;
        } else {
            jVar = this.qS;
            context = view.getContext();
            i2 = 31;
        }
        jVar.a(1, context, i2, 1);
    }
}
