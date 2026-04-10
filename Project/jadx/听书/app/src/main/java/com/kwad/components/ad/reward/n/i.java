package com.kwad.components.ad.reward.n;

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
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.media3.common.C;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
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
import com.kwad.sdk.utils.aq;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends d implements View.OnClickListener {
    private ViewGroup Cc;
    private KsPriceView Cd;
    private TextView Ce;
    private KsStyledTextButton Cf;
    private TextView Cg;
    private TextView Ch;
    private View Ci;
    private ImageView Cj;
    private TextView fv;
    private TextView ko;
    private KsLogoView mLogoView;
    private KSCornerImageView nR;
    private com.kwad.components.ad.reward.g tm;
    private ViewGroup vV;

    static /* synthetic */ Animator a(i iVar, View view, float f) {
        return a(view, f);
    }

    public i(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup, KsLogoView ksLogoView) {
        this.tm = gVar;
        this.mLogoView = ksLogoView;
        this.Cc = viewGroup;
        initView();
    }

    private void initView() {
        this.vV = (ViewGroup) this.Cc.findViewById(R.id.ksad_reward_jinniu_root);
        this.nR = (KSCornerImageView) this.Cc.findViewById(R.id.ksad_reward_jinniu_icon);
        this.ko = (TextView) this.Cc.findViewById(R.id.ksad_reward_jinniu_title);
        this.fv = (TextView) this.Cc.findViewById(R.id.ksad_reward_jinniu_desc);
        this.Cd = (KsPriceView) this.Cc.findViewById(R.id.ksad_reward_jinniu_price);
        this.Ce = (TextView) this.Cc.findViewById(R.id.ksad_reward_jinniu_right_label);
        this.Cf = (KsStyledTextButton) this.Cc.findViewById(R.id.ksad_reward_jinniu_btn_buy);
        this.Cj = (ImageView) this.Cc.findViewById(R.id.ksad_reward_jinniu_light_sweep);
        this.Ci = this.Cc.findViewById(R.id.ksad_reward_jinniu_coupon_layout);
        this.Cg = (TextView) this.Cc.findViewById(R.id.ksad_reward_jinniu_coupon);
        this.Ch = (TextView) this.Cc.findViewById(R.id.ksad_reward_jinniu_coupon_prefix);
        this.vV.setOnClickListener(this);
        KsStyledTextButton ksStyledTextButton = this.Cf;
        if (ksStyledTextButton != null) {
            ksStyledTextButton.setOnClickListener(this);
        }
        Context context = this.vV.getContext();
        if (aq.QW()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.vV.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.vV.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        if (rVar == null) {
            return;
        }
        a(rVar.getAdTemplate(), a.Z(rVar.getAdTemplate()));
        ViewGroup viewGroup = this.vV;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    i iVar = i.this;
                    Animator animatorA = iVar.a(iVar.vV, i.this.Cf, i.this.mLogoView);
                    if (animatorA != null) {
                        animatorA.start();
                    }
                }
            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            this.vV.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (i.this.Cf == null || i.this.Cf.getWidth() == 0) {
                        return;
                    }
                    float width = i.this.Cf.getWidth();
                    i iVar = i.this;
                    final Animator animatorA = i.a(iVar, iVar.Cj, width);
                    if (animatorA != null) {
                        animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.i.2.1
                            private int Cl = 1;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (this.Cl >= 3) {
                                    return;
                                }
                                animatorA.start();
                                this.Cl++;
                            }
                        });
                        animatorA.start();
                    }
                }
            }, 5000L);
        }
    }

    private void a(AdTemplate adTemplate, a aVar) {
        if (aVar == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.nR, aVar.ho(), adTemplate, 4);
        TextView textView = this.ko;
        if (textView != null) {
            textView.setText(aVar.getTitle());
        }
        TextView textView2 = this.fv;
        if (textView2 != null) {
            textView2.setText(aVar.hp());
        }
        KsPriceView ksPriceView = this.Cd;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
            this.Cd.getConfig().as(dimensionPixelSize).au(dimensionPixelSize).at(this.Cd.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
            this.Cd.d(aVar.lf(), aVar.eB(), true);
        }
        if (this.Ce != null) {
            if (!TextUtils.isEmpty(aVar.li())) {
                this.Ce.setText(aVar.li());
            } else if (!TextUtils.isEmpty(aVar.getRating())) {
                this.Ce.setText(aVar.getRating());
            } else {
                this.Ce.setVisibility(8);
            }
        }
        if (this.Cg != null && !TextUtils.isEmpty(aVar.lg())) {
            this.Cg.setText(aVar.lg());
        }
        if (this.Cf != null && !TextUtils.isEmpty(aVar.lh())) {
            this.Cf.setText(aVar.lh());
        }
        int i = TextUtils.isEmpty(aVar.lg()) ? 8 : 0;
        View view = this.Ci;
        if (view != null) {
            view.setVisibility(i);
        }
        if (this.Ch == null || TextUtils.isEmpty(aVar.ih())) {
            return;
        }
        this.Ch.setText(aVar.ih());
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hP() {
        return this.vV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(final View view, View view2, final View view3) {
        final int height = view.getHeight();
        if (height <= 0 || view.getLayoutParams() == null) {
            return null;
        }
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.51f, 0.0f, 0.67f, 1.0f);
        ValueAnimator duration = ValueAnimator.ofInt(height, view.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_card_height_full)).setDuration(500L);
        duration.setInterpolator(interpolatorCreate);
        view.getContext();
        if (aq.QW() && view3 != null && (view3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            final int i = marginLayoutParams.bottomMargin;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.n.i.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    int i2 = iIntValue - height;
                    marginLayoutParams.bottomMargin = i + i2;
                    view3.setLayoutParams(marginLayoutParams);
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

    private static Animator a(View view, float f) {
        if (view == null || view.getWidth() <= 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", view.getResources().getDimension(R.dimen.ksad_jinniu_light_sweep_width) + f).setDuration(1000L);
        duration.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2);
        return animatorSet;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.vV)) {
            this.tm.a(1, view.getContext(), TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS, 2);
        } else if (view.equals(this.Cf)) {
            this.tm.a(1, view.getContext(), 1, 1);
        }
    }

    static class a {
        private String Ct;
        private String Cu;
        private String Cv;
        private String Cw;
        private String nw;
        private String rating;
        private String sW;
        private String sX;
        private String title;
        private String uS;

        private a() {
        }

        static a Z(AdTemplate adTemplate) {
            CouponInfo firstCouponList;
            AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
            AdProductInfo adProductInfoCV = com.kwad.sdk.core.response.b.a.cV(adInfoEl);
            a aVar = new a();
            String name = adProductInfoCV.getName();
            aVar.title = name;
            if (TextUtils.isEmpty(name)) {
                aVar.title = com.kwad.sdk.core.response.b.a.ax(adInfoEl);
            }
            aVar.Cv = com.kwad.sdk.core.response.b.a.aE(adInfoEl);
            aVar.sW = adProductInfoCV.getIcon();
            aVar.sX = com.kwad.sdk.core.response.b.a.au(adInfoEl);
            aVar.Ct = adProductInfoCV.getPrice();
            aVar.nw = adProductInfoCV.getOriginPrice();
            aVar.Cw = adProductInfoCV.getVolume();
            aVar.rating = adProductInfoCV.getRating();
            if (!adProductInfoCV.isCouponListEmpty() && (firstCouponList = adProductInfoCV.getFirstCouponList()) != null) {
                aVar.Cu = CouponInfo.jinniuFormatCoupon(firstCouponList);
                aVar.S(firstCouponList.getFormattedJinniuPrefix());
            }
            return aVar;
        }

        public final String ho() {
            return this.sW;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String hp() {
            return this.sX;
        }

        public final String lf() {
            return this.Ct;
        }

        public final String eB() {
            return this.nw;
        }

        public final String lg() {
            return this.Cu;
        }

        public final String lh() {
            return this.Cv;
        }

        public final String li() {
            return this.Cw;
        }

        public final String getRating() {
            return this.rating;
        }

        public final String ih() {
            return this.uS;
        }

        private void S(String str) {
            this.uS = str;
        }
    }
}
