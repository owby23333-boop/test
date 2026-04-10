package com.kwad.components.ad.reward.k;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.KSCouponLabelTextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ba;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends d implements View.OnClickListener {
    private ViewGroup gu;
    private TextView oC;
    private ViewGroup zk;
    private KSCornerImageView zq;
    private LinearLayout zr;
    private KsPriceView zs;
    private TextView zt;
    private View zu;
    private KSCornerImageView zv;
    private b zw;
    private a zx;

    public interface a {
        void hL();
    }

    public m(ViewGroup viewGroup, b bVar) {
        this.gu = viewGroup;
        this.zw = bVar;
        initView();
    }

    private static View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) com.kwad.sdk.i.a.a(context, R.layout.ksad_reward_order_card_coupon, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }

    static /* synthetic */ View a(m mVar, Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        return a(context, couponInfo, viewGroup);
    }

    private void a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.zq, adProductInfo.getIcon(), adTemplate);
        this.oC.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.zr.setVisibility(8);
            this.zx.hL();
        } else {
            this.zr.setVisibility(0);
            this.zr.post(new Runnable() { // from class: com.kwad.components.ad.reward.k.m.1
                @Override // java.lang.Runnable
                public final void run() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        m mVar = m.this;
                        View viewA = m.a(mVar, mVar.zr.getContext(), couponInfo, m.this.zr);
                        ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        m.this.zr.addView(viewA, layoutParams);
                        com.kwad.components.core.r.j.a(new com.kwad.components.core.widget.e(), m.this.zr);
                    }
                    if (m.this.zx != null) {
                        if (m.this.zr.getChildCount() > 0) {
                            m.this.zr.getChildAt(0).post(new Runnable() { // from class: com.kwad.components.ad.reward.k.m.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    m.this.zx.hL();
                                }
                            });
                        } else {
                            m.this.zx.hL();
                        }
                    }
                }
            });
        }
        this.zs.f(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String strAj = com.kwad.components.ad.c.b.aj();
        if (ba.isNullString(strAj)) {
            return;
        }
        KSImageLoader.loadImage(this.zv, strAj, adTemplate);
    }

    private void initView() {
        this.zk = (ViewGroup) this.gu.findViewById(R.id.ksad_reward_order_root);
        this.zq = (KSCornerImageView) this.gu.findViewById(R.id.ksad_reward_order_icon);
        this.oC = (TextView) this.gu.findViewById(R.id.ksad_reward_order_title);
        this.zr = (LinearLayout) this.gu.findViewById(R.id.ksad_reward_order_coupon_list);
        this.zs = (KsPriceView) this.gu.findViewById(R.id.ksad_reward_order_price);
        this.zt = (TextView) this.gu.findViewById(R.id.ksad_reward_order_btn_buy);
        this.zu = this.gu.findViewById(R.id.ksad_reward_order_text_area);
        this.zv = (KSCornerImageView) this.gu.findViewById(R.id.ksad_reward_order_kwai_logo);
        this.zt.setText(com.kwad.components.ad.c.b.ai());
        this.zt.setOnClickListener(this);
        this.zq.setOnClickListener(this);
        this.zu.setOnClickListener(this);
        Context context = this.gu.getContext();
        if (ah.cu(context)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.gu.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.gu.setLayoutParams(layoutParams2);
        }
    }

    public final void a(a aVar) {
        this.zx = aVar;
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(v vVar) {
        super.a(vVar);
        a(com.kwad.sdk.core.response.a.a.cr(com.kwad.sdk.core.response.a.d.cb(vVar.getAdTemplate())), vVar.getAdTemplate());
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup hc() {
        return this.zk;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.zw == null) {
            return;
        }
        if (view.equals(this.zt)) {
            this.zw.hg();
        } else if (view.equals(this.zq)) {
            this.zw.iy();
        } else if (view.equals(this.zu)) {
            this.zw.iz();
        }
    }
}
