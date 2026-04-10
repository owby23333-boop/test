package com.kwad.components.ad.reward.presenter;

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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends b implements View.OnClickListener, com.kwad.components.ad.reward.e.o, com.kwad.sdk.core.g.b {
    private com.kwad.sdk.core.g.d gX;
    private Vibrator gZ;
    private ViewGroup kn;
    private TextView ko;
    private TextView kp;
    private ImageView kq;
    private FrameLayout kr;
    private ImageView ks;
    private FrameLayout kt;
    private TextView ku;
    private Animator kv;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.t.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            if (t.this.kn != null) {
                t.this.kn.setVisibility(8);
            }
            if (t.this.kt != null) {
                t.this.kt.setVisibility(8);
            }
            if (t.this.gX != null) {
                t.this.gX.bH(t.this.getContext());
            }
            if (t.this.kv != null) {
                t.this.kv.cancel();
                t.this.kv = null;
            }
        }
    };

    @Override // com.kwad.sdk.core.g.b
    public final void cd() {
    }

    @Override // com.kwad.components.ad.reward.e.o
    public final int dr() {
        return com.kwad.sdk.c.a.a.h(getContext(), R.dimen.ksad_reward_shake_tips_title_marginBottom) + com.kwad.sdk.c.a.a.h(getContext(), R.dimen.ksad_reward_shake_tips_height);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        this.tm.a(this);
        this.tm.b(this.mPlayEndPageListener);
        ds();
        initView();
        a(adInfoEl);
        float fEe = com.kwad.sdk.core.response.b.b.ee(adInfoEl);
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(fEe);
            this.gX = dVar2;
            dVar2.a(this);
        } else {
            dVar.g(fEe);
        }
        this.gX.bG(getContext());
        Context context = getContext();
        if (context != null) {
            this.gZ = (Vibrator) context.getSystemService("vibrator");
        }
    }

    private void ds() {
        final int dimensionPixelSize;
        int dimensionPixelSize2;
        final AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        ViewGroup viewGroup = (ViewGroup) com.kwad.sdk.o.m.a(getContext(), R.layout.ksad_shake_center, adBaseFrameLayout, false);
        this.kn = viewGroup;
        viewGroup.setVisibility(0);
        Resources resources = this.kn.getResources();
        try {
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        boolean z = com.kwad.sdk.core.response.b.a.bf(com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate)) == 8;
        final int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginLeft);
        if (this.tm.mScreenOrientation == 1) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginBottom) + com.kwad.sdk.c.a.a.a(getContext(), 50.0f);
        } else if (z) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_live_shop_marginBottom);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_marginBottom);
        }
        if (this.tm.mScreenOrientation == 1) {
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_title_marginBottom) + com.kwad.sdk.c.a.a.a(getContext(), 50.0f);
        } else if (z) {
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_title_live_shop_marginBottom);
        } else {
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_title_marginBottom);
        }
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_height);
        FrameLayout frameLayout = (FrameLayout) com.kwad.sdk.o.m.a(getContext(), R.layout.ksad_shake_tips_title, adBaseFrameLayout, false);
        this.kt = frameLayout;
        this.ku = (TextView) frameLayout.findViewById(R.id.ksad_shake_tips_label);
        this.kt.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
        layoutParams.leftMargin = dimensionPixelSize3;
        layoutParams.bottomMargin = dimensionPixelSize2;
        layoutParams.gravity = 83;
        adBaseFrameLayout.addView(this.kt, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        adBaseFrameLayout.addView(this.kn, layoutParams2);
        com.kwad.sdk.core.adlog.c.b(this.tm.mAdTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, (JSONObject) null);
        this.kn.post(new bg() { // from class: com.kwad.components.ad.reward.presenter.t.6
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                int height = adBaseFrameLayout.getHeight();
                t tVar = t.this;
                tVar.kv = tVar.a(dimensionPixelSize3, height - dimensionPixelSize);
                if (t.this.kv != null) {
                    t.this.kv.start();
                }
            }
        });
    }

    private void initView() {
        this.ko = (TextView) this.kn.findViewById(R.id.ksad_shake_center_title);
        this.kp = (TextView) this.kn.findViewById(R.id.ksad_shake_center_sub_title);
        this.kq = (ImageView) this.kn.findViewById(R.id.ksad_shake_center_icon);
        this.kr = (FrameLayout) this.kn.findViewById(R.id.ksad_shake_center_circle_area);
        this.ks = (ImageView) this.kn.findViewById(R.id.ksad_shake_center_circle_area_bg);
        this.ko.setOnClickListener(this);
        this.kp.setOnClickListener(this);
        this.kr.setOnClickListener(this);
        this.ku.setOnClickListener(this);
    }

    private void a(AdInfo adInfo) {
        String strEg = com.kwad.sdk.core.response.b.b.eg(adInfo);
        TextView textView = this.ko;
        if (textView != null) {
            textView.setText(strEg);
        }
        TextView textView2 = this.ku;
        if (textView2 != null) {
            textView2.setText(strEg);
        }
        String strA = a(this.tm, adInfo);
        TextView textView3 = this.kp;
        if (textView3 != null) {
            textView3.setText("或点击" + strA);
        }
    }

    private static String a(com.kwad.components.ad.reward.g gVar, AdInfo adInfo) {
        String strEi = com.kwad.sdk.core.response.b.b.ei(adInfo);
        com.kwad.components.core.e.d.c cVar = gVar.mApkDownloadHelper;
        if (!com.kwad.sdk.core.response.b.a.aF(adInfo) || cVar == null) {
            return strEi;
        }
        int iPB = cVar.pB();
        AdMatrixInfo.DownloadTexts downloadTextsEk = com.kwad.sdk.core.response.b.b.ek(adInfo);
        if (iPB == 8) {
            return downloadTextsEk.installAppLabel;
        }
        if (iPB == 12) {
            return downloadTextsEk.openAppLabel;
        }
        return downloadTextsEk.adActionDescription;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(float f, float f2) {
        if (this.kn == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.kn.getResources();
        Animator animatorA = com.kwad.components.core.t.o.a((View) this.kq, (Interpolator) null, 100L, 16.0f);
        animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.t.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                t.this.kq.setPivotX(t.this.kq.getWidth());
                t.this.kq.setPivotY(t.this.kq.getHeight());
            }
        });
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.kn, "translationX", f - (this.kn.getLeft() + (this.kn.getWidth() / 2.0f)));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.kn, "translationY", f2 - (this.kn.getTop() + (this.kn.getHeight() / 2.0f)));
        float dimension = resources.getDimension(R.dimen.ksad_reward_shake_tips_height);
        final float dimension2 = resources.getDimension(R.dimen.ksad_reward_shake_tips_icon_size);
        float width = this.kr.getWidth();
        float width2 = this.kq.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(width, dimension);
        valueAnimatorOfFloat.addUpdateListener(new com.kwad.components.ad.widget.a(this.ks) { // from class: com.kwad.components.ad.reward.presenter.t.8
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float fFloatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) fFloatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(width2, dimension2);
        valueAnimatorOfFloat2.addUpdateListener(new com.kwad.components.ad.widget.a(this.kq) { // from class: com.kwad.components.ad.reward.presenter.t.9
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float fFloatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) fFloatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        int color = resources.getColor(R.color.ksad_shake_icon_bg_start_color);
        final int color2 = resources.getColor(R.color.ksad_reward_main_color);
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_reward_shake_tips_icon_stroke_size);
        ValueAnimator valueAnimatorOfArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) t.this.ks.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(iIntValue);
                    if (iIntValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    t.this.ks.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setDuration(200L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    t.this.ko.setAlpha(fFloatValue);
                    t.this.kp.setAlpha(fFloatValue);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(this.ko.getHeight(), 0.0f);
        valueAnimatorOfFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.ko) { // from class: com.kwad.components.ad.reward.presenter.t.12
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator valueAnimatorOfFloat5 = ValueAnimator.ofFloat(this.kp.getHeight(), 0.0f);
        valueAnimatorOfFloat5.addUpdateListener(new com.kwad.components.ad.widget.a(this.kp) { // from class: com.kwad.components.ad.reward.presenter.t.13
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
        animatorClone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.t.2
            private boolean kx = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                t.this.kq.setPivotX(dimension2);
                t.this.kq.setPivotY(dimension2);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.kx = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.kx) {
                    return;
                }
                animatorClone.start();
            }
        });
        final ViewGroup.LayoutParams layoutParams = this.kt.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.ksad_reward_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    t.this.kt.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    t.this.kt.setLayoutParams(layoutParams);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        animatorSet3.playTogether(animatorClone, duration, ObjectAnimator.ofFloat(this.ku, "alpha", 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(animatorA, animatorA.clone(), animatorA.clone(), valueAnimatorOfFloat3, animatorSet2, animatorSet3);
        return animatorSet;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ViewGroup viewGroup = this.kn;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.kn.getParent()).removeView(this.kn);
            }
            this.kn = null;
        }
        bw.b(getContext(), this.gZ);
        this.gZ = null;
        Animator animator = this.kv;
        if (animator != null) {
            animator.cancel();
            this.kv = null;
        }
        this.tm.c(this.mPlayEndPageListener);
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(double d) {
        com.kwad.sdk.core.c.b.Ho();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        Activity activity = getActivity();
        boolean z = activity != null && activity.equals(currentActivity);
        if (com.kwad.components.core.e.c.b.oW() || !z) {
            bw.a(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.t.4
                @Override // java.lang.Runnable
                public final void run() {
                    t.this.gX.Jb();
                }
            }, null, 500L);
            return;
        }
        if (this.tm != null && !this.tm.gV()) {
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            bVar.l(d);
            this.tm.a(1, getContext(), 157, 1, 0L, false, bVar);
        }
        bw.a(new bg() { // from class: com.kwad.components.ad.reward.presenter.t.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("RewardShakePresenter", "onShakeEvent openGate2");
                t.this.gX.Jb();
            }
        }, null, 500L);
        com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        if (this.tm.gV()) {
            return;
        }
        bw.a(getContext(), this.gZ);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.sdk.core.response.b.b.ec(com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate))) {
            this.tm.a(1, getContext(), 158, 1);
        }
    }
}
