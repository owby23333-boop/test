package com.kwad.components.ad.fullscreen.b.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.kwad.components.ad.reward.d.m;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.r.o;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends com.kwad.components.ad.reward.presenter.a implements m, com.kwad.sdk.core.f.b, com.kwad.sdk.widget.c {
    private com.kwad.sdk.core.f.d ee;
    private Vibrator ef;
    private ViewGroup ha;
    private TextView hb;
    private TextView hc;
    private ImageView hd;
    private FrameLayout he;
    private ImageView hf;
    private FrameLayout hg;
    private TextView hh;

    @Nullable
    private Animator hi;
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.1
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (f.this.ha != null) {
                f.this.ha.setVisibility(8);
            }
            if (f.this.hg != null) {
                f.this.hg.setVisibility(8);
            }
            if (f.this.ee != null) {
                f.this.ee.bj(f.this.getContext());
            }
            if (f.this.hi != null) {
                f.this.hi.cancel();
                f.this.hi = null;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(float f2, float f3) {
        if (this.ha == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.ha.getResources();
        Animator animatorA = o.a((View) this.hd, (Interpolator) null, 100L, 16.0f);
        animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.hd.setPivotX(f.this.hd.getWidth());
                f.this.hd.setPivotY(f.this.hd.getHeight());
            }
        });
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.ha, "translationX", f2 - (this.ha.getLeft() + (this.ha.getWidth() / 2.0f)));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.ha, "translationY", f3 - (this.ha.getTop() + (this.ha.getHeight() / 2.0f)));
        float dimension = resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_height);
        final float dimension2 = resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_icon_size);
        float width = this.he.getWidth();
        float width2 = this.hd.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(width, dimension);
        valueAnimatorOfFloat.addUpdateListener(new com.kwad.components.ad.widget.a(this.hf) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.8
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float fFloatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i2 = (int) fFloatValue;
                    layoutParams.height = i2;
                    layoutParams.width = i2;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(width2, dimension2);
        valueAnimatorOfFloat2.addUpdateListener(new com.kwad.components.ad.widget.a(this.hd) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.9
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float fFloatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i2 = (int) fFloatValue;
                    layoutParams.height = i2;
                    layoutParams.width = i2;
                }
            }
        });
        int color = resources.getColor(R.color.ksad_shake_icon_bg_start_color);
        final int color2 = resources.getColor(R.color.ksad_reward_main_color);
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_stroke_size);
        ValueAnimator valueAnimatorOfArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) f.this.hf.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(iIntValue);
                    if (iIntValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    f.this.hf.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setDuration(200L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.hb.setAlpha(fFloatValue);
                    f.this.hc.setAlpha(fFloatValue);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(this.hb.getHeight(), 0.0f);
        valueAnimatorOfFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.hb) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.12
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator valueAnimatorOfFloat5 = ValueAnimator.ofFloat(this.hc.getHeight(), 0.0f);
        valueAnimatorOfFloat5.addUpdateListener(new com.kwad.components.ad.widget.a(this.hc) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.13
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, valueAnimatorOfFloat, valueAnimatorOfFloat2, valueAnimatorOfArgb, valueAnimatorOfFloat4, valueAnimatorOfFloat5);
        AnimatorSet animatorSet3 = new AnimatorSet();
        final Animator animatorClone = animatorA.clone();
        animatorClone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.2
            private boolean hk = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.hk = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.hk) {
                    return;
                }
                animatorClone.start();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.hd.setPivotX(dimension2);
                f.this.hd.setPivotY(dimension2);
            }
        });
        final ViewGroup.LayoutParams layoutParams = this.hg.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    f.this.hg.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.hg.setLayoutParams(layoutParams);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        });
        animatorSet3.playTogether(animatorClone, duration, ObjectAnimator.ofFloat(this.hh, "alpha", 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(animatorA, animatorA.clone(), animatorA.clone(), valueAnimatorOfFloat3, animatorSet2, animatorSet3);
        return animatorSet;
    }

    private static String a(j jVar, AdInfo adInfo) {
        String strDj = com.kwad.sdk.core.response.a.b.dj(adInfo);
        com.kwad.components.core.d.b.c cVar = jVar.mApkDownloadHelper;
        if (!com.kwad.sdk.core.response.a.a.ay(adInfo) || cVar == null) {
            return strDj;
        }
        int iNw = cVar.nw();
        AdMatrixInfo.DownloadTexts downloadTextsDl = com.kwad.sdk.core.response.a.b.dl(adInfo);
        return iNw != 8 ? iNw != 12 ? downloadTextsDl.adActionDescription : downloadTextsDl.openAppLabel : downloadTextsDl.installAppLabel;
    }

    private void a(AdInfo adInfo) {
        String strDh = com.kwad.sdk.core.response.a.b.dh(adInfo);
        TextView textView = this.hb;
        if (textView != null) {
            textView.setText(strDh);
        }
        TextView textView2 = this.hh;
        if (textView2 != null) {
            textView2.setText(strDh);
        }
        String strA = a(this.qS, adInfo);
        TextView textView3 = this.hc;
        if (textView3 != null) {
            textView3.setText("或点击" + strA);
        }
    }

    private void ci() {
        final AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.ha = (ViewGroup) com.kwad.sdk.i.a.a(getContext(), R.layout.ksad_shake_center, adBaseFrameLayout, false);
        this.ha.setVisibility(0);
        Resources resources = this.ha.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_marginLeft);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_marginBottom);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_title_marginBottom);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_height);
        this.hg = (FrameLayout) com.kwad.sdk.i.a.a(getContext(), R.layout.ksad_shake_tips_title, adBaseFrameLayout, false);
        this.hh = (TextView) this.hg.findViewById(R.id.ksad_shake_tips_label);
        this.hg.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize3;
        layoutParams.gravity = 83;
        adBaseFrameLayout.addView(this.hg, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        adBaseFrameLayout.addView(this.ha, layoutParams2);
        com.kwad.sdk.core.report.a.b(this.qS.mAdTemplate, NormalCmdFactory.TASK_CANCEL_ALL, (JSONObject) null);
        this.ha.post(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.6
            @Override // java.lang.Runnable
            public final void run() {
                int height = adBaseFrameLayout.getHeight();
                f fVar = f.this;
                fVar.hi = fVar.a(dimensionPixelSize, height - dimensionPixelSize2);
                if (f.this.hi != null) {
                    f.this.hi.start();
                }
            }
        });
    }

    private void initView() {
        this.hb = (TextView) this.ha.findViewById(R.id.ksad_shake_center_title);
        this.hc = (TextView) this.ha.findViewById(R.id.ksad_shake_center_sub_title);
        this.hd = (ImageView) this.ha.findViewById(R.id.ksad_shake_center_icon);
        this.he = (FrameLayout) this.ha.findViewById(R.id.ksad_shake_center_circle_area);
        this.hf = (ImageView) this.ha.findViewById(R.id.ksad_shake_center_circle_area_bg);
        new com.kwad.sdk.widget.f(getContext(), this.ha, this);
    }

    @Override // com.kwad.sdk.core.f.b
    public final void a(double d2) {
        com.kwad.sdk.core.b.b.we();
        Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
        Activity activity = getActivity();
        boolean z2 = activity != null && activity.equals(currentActivity);
        if (com.kwad.components.core.d.a.b.na() || !z2) {
            bh.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.ee.xP();
                }
            }, null, 500L);
            return;
        }
        if (this.qS != null) {
            i iVar = new i();
            iVar.i(d2);
            this.qS.a(1, getContext(), 157, 1, 0L, false, iVar);
        }
        bh.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.5
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("ShakePresenter", "onShakeEvent openGate2");
                f.this.ee.xP();
            }
        }, null, 500L);
        bh.a(getContext(), this.ef);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.qS.a(1, getContext(), 158, 1);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate);
        if (com.kwad.components.ad.fullscreen.a.a.a(getContext(), this.qS.mAdTemplate)) {
            this.qS.a(this);
            this.qS.b(this.mPlayEndPageListener);
            ci();
            initView();
            a(adInfoCb);
            float fDf = com.kwad.sdk.core.response.a.b.df(adInfoCb);
            com.kwad.sdk.core.f.d dVar = this.ee;
            if (dVar == null) {
                this.ee = new com.kwad.sdk.core.f.d(fDf);
                this.ee.a(this);
            } else {
                dVar.e(fDf);
            }
            this.ee.bi(getContext());
            Context context = getContext();
            if (context != null) {
                this.ef = (Vibrator) context.getSystemService("vibrator");
            }
            com.kwad.components.ad.fullscreen.a.a.H(getContext());
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        this.qS.a(1, getContext(), 158, 1);
    }

    @Override // com.kwad.sdk.core.f.b
    public final void bd() {
    }

    @Override // com.kwad.components.ad.reward.d.m
    public final int ch() {
        return com.kwad.sdk.b.kwai.a.g(getContext(), R.dimen.ksad_fullscreen_shake_tips_title_marginBottom) + com.kwad.sdk.b.kwai.a.g(getContext(), R.dimen.ksad_fullscreen_shake_tips_height);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ViewGroup viewGroup = this.ha;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.ha.getParent()).removeView(this.ha);
            }
            this.ha = null;
        }
        bh.b(getContext(), this.ef);
        this.ef = null;
        Animator animator = this.hi;
        if (animator != null) {
            animator.cancel();
            this.hi = null;
        }
        this.qS.c(this.mPlayEndPageListener);
    }
}
