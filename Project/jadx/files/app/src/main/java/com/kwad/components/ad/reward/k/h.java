package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.ah;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends d implements View.OnClickListener {

    @Nullable
    private TextView hb;

    @Nullable
    private KSCornerImageView lM;

    @Nullable
    private TextView lN;

    @Nullable
    private KsLogoView mLogoView;
    private com.kwad.components.ad.reward.j qS;
    private ViewGroup sN;

    @Nullable
    private KsStyledTextButton yA;

    @Nullable
    private TextView yB;

    @Nullable
    private TextView yC;

    @Nullable
    private View yD;

    @Nullable
    private ImageView yE;
    private ViewGroup yx;

    @Nullable
    private KsPriceView yy;

    @Nullable
    private TextView yz;

    static class a {
        private String lz;
        private String os;
        private String qM;
        private String rating;
        private String sd;
        private String title;
        private String yO;

        @Nullable
        private String yP;
        private String yQ;
        private String yR;

        private a() {
        }

        static a B(AdTemplate adTemplate) {
            CouponInfo firstCouponList;
            AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
            AdProductInfo adProductInfoCr = com.kwad.sdk.core.response.a.a.cr(adInfoCb);
            a aVar = new a();
            aVar.title = adProductInfoCr.getName();
            if (TextUtils.isEmpty(aVar.title)) {
                aVar.title = com.kwad.sdk.core.response.a.a.aq(adInfoCb);
            }
            aVar.yQ = com.kwad.sdk.core.response.a.a.ax(adInfoCb);
            aVar.os = adProductInfoCr.getIcon();
            aVar.qM = com.kwad.sdk.core.response.a.a.ao(adInfoCb);
            aVar.yO = adProductInfoCr.getPrice();
            aVar.lz = adProductInfoCr.getOriginPrice();
            aVar.yR = adProductInfoCr.getVolume();
            aVar.rating = adProductInfoCr.getRating();
            if (!adProductInfoCr.isCouponListEmpty() && (firstCouponList = adProductInfoCr.getFirstCouponList()) != null) {
                aVar.yP = CouponInfo.jinniuFormatCoupon(firstCouponList);
                aVar.T(firstCouponList.getFormattedJinniuPrefix());
            }
            return aVar;
        }

        private void T(String str) {
            this.sd = str;
        }

        public final String el() {
            return this.lz;
        }

        public final String fo() {
            return this.os;
        }

        public final String gE() {
            return this.qM;
        }

        public final String getRating() {
            return this.rating;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String hr() {
            return this.sd;
        }

        public final String kf() {
            return this.yO;
        }

        public final String kg() {
            return this.yP;
        }

        public final String kh() {
            return this.yQ;
        }

        public final String ki() {
            return this.yR;
        }
    }

    public h(com.kwad.components.ad.reward.j jVar, ViewGroup viewGroup, KsLogoView ksLogoView) {
        this.qS = jVar;
        this.mLogoView = ksLogoView;
        this.yx = viewGroup;
        initView();
    }

    @Nullable
    private static Animator a(View view, float f2) {
        if (view == null || view.getWidth() <= 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", view.getResources().getDimension(R.dimen.ksad_jinniu_light_sweep_width) + f2).setDuration(1000L);
        duration.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(final View view, View view2, final View view3) {
        final int height = view.getHeight();
        if (height <= 0 || view.getLayoutParams() == null) {
            return null;
        }
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.51f, 0.0f, 0.67f, 1.0f);
        ValueAnimator duration = ValueAnimator.ofInt(height, view.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_card_height_full)).setDuration(500L);
        duration.setInterpolator(interpolatorCreate);
        if (ah.cu(view.getContext()) && view3 != null && (view3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            final int i2 = marginLayoutParams.bottomMargin;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.k.h.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    int i3 = iIntValue - height;
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                    marginLayoutParams2.bottomMargin = i2 + i3;
                    view3.setLayoutParams(marginLayoutParams2);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = iIntValue;
                        view.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 0.0f).setDuration(200L);
        Interpolator interpolatorCreate2 = PathInterpolatorCompat.create(0.86f, 0.0f, 0.83f, 1.0f);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f).setDuration(300L);
        duration3.setInterpolator(interpolatorCreate2);
        animatorSet.playSequentially(duration2, duration3);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(duration, animatorSet);
        return animatorSet2;
    }

    static /* synthetic */ Animator a(h hVar, View view, float f2) {
        return a(view, f2);
    }

    private void a(AdTemplate adTemplate, a aVar) {
        TextView textView;
        String rating;
        if (aVar == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.lM, aVar.fo(), adTemplate, 4);
        TextView textView2 = this.hb;
        if (textView2 != null) {
            textView2.setText(aVar.getTitle());
        }
        TextView textView3 = this.lN;
        if (textView3 != null) {
            textView3.setText(aVar.gE());
        }
        KsPriceView ksPriceView = this.yy;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
            this.yy.getConfig().aj(dimensionPixelSize).al(dimensionPixelSize).ak(this.yy.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
            this.yy.d(aVar.kf(), aVar.el(), true);
        }
        if (this.yz != null) {
            if (!TextUtils.isEmpty(aVar.ki())) {
                textView = this.yz;
                rating = aVar.ki();
            } else if (TextUtils.isEmpty(aVar.getRating())) {
                this.yz.setVisibility(8);
            } else {
                textView = this.yz;
                rating = aVar.getRating();
            }
            textView.setText(rating);
        }
        if (this.yB != null && !TextUtils.isEmpty(aVar.kg())) {
            this.yB.setText(aVar.kg());
        }
        if (this.yA != null && !TextUtils.isEmpty(aVar.kh())) {
            this.yA.setText(aVar.kh());
        }
        int i2 = TextUtils.isEmpty(aVar.kg()) ? 8 : 0;
        View view = this.yD;
        if (view != null) {
            view.setVisibility(i2);
        }
        if (this.yC == null || TextUtils.isEmpty(aVar.hr())) {
            return;
        }
        this.yC.setText(aVar.hr());
    }

    private void initView() {
        this.sN = (ViewGroup) this.yx.findViewById(R.id.ksad_reward_jinniu_root);
        this.lM = (KSCornerImageView) this.yx.findViewById(R.id.ksad_reward_jinniu_icon);
        this.hb = (TextView) this.yx.findViewById(R.id.ksad_reward_jinniu_title);
        this.lN = (TextView) this.yx.findViewById(R.id.ksad_reward_jinniu_desc);
        this.yy = (KsPriceView) this.yx.findViewById(R.id.ksad_reward_jinniu_price);
        this.yz = (TextView) this.yx.findViewById(R.id.ksad_reward_jinniu_right_label);
        this.yA = (KsStyledTextButton) this.yx.findViewById(R.id.ksad_reward_jinniu_btn_buy);
        this.yE = (ImageView) this.yx.findViewById(R.id.ksad_reward_jinniu_light_sweep);
        this.yD = this.yx.findViewById(R.id.ksad_reward_jinniu_coupon_layout);
        this.yB = (TextView) this.yx.findViewById(R.id.ksad_reward_jinniu_coupon);
        this.yC = (TextView) this.yx.findViewById(R.id.ksad_reward_jinniu_coupon_prefix);
        this.sN.setOnClickListener(this);
        KsStyledTextButton ksStyledTextButton = this.yA;
        if (ksStyledTextButton != null) {
            ksStyledTextButton.setOnClickListener(this);
        }
        Context context = this.sN.getContext();
        if (ah.cu(context)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.sN.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.sN.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(v vVar) {
        super.a(vVar);
        if (vVar == null) {
            return;
        }
        a(vVar.getAdTemplate(), a.B(vVar.getAdTemplate()));
        ViewGroup viewGroup = this.sN;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.k.h.1
                @Override // java.lang.Runnable
                public final void run() {
                    h hVar = h.this;
                    Animator animatorA = hVar.a(hVar.sN, h.this.yA, h.this.mLogoView);
                    if (animatorA != null) {
                        animatorA.start();
                    }
                }
            }, com.anythink.expressad.video.module.a.a.m.ag);
            this.sN.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.k.h.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (h.this.yA == null || h.this.yA.getWidth() == 0) {
                        return;
                    }
                    float width = h.this.yA.getWidth();
                    h hVar = h.this;
                    final Animator animatorA = h.a(hVar, hVar.yE, width);
                    if (animatorA != null) {
                        animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.k.h.2.1
                            private int yG = 1;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (this.yG >= 3) {
                                    return;
                                }
                                animatorA.start();
                                this.yG++;
                            }
                        });
                        animatorA.start();
                    }
                }
            }, 5000L);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup hc() {
        return this.sN;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.sN)) {
            this.qS.a(1, view.getContext(), 118, 2);
        } else if (view.equals(this.yA)) {
            this.qS.a(1, view.getContext(), 1, 1);
        }
    }
}
