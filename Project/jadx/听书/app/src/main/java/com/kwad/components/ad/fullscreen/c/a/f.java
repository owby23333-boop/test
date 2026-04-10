package com.kwad.components.ad.fullscreen.c.a;

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
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.o;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.widget.h;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.kwad.components.ad.reward.presenter.b implements o, com.kwad.sdk.core.g.b, com.kwad.sdk.widget.d {
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
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.c.a.f.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            if (f.this.kn != null) {
                f.this.kn.setVisibility(8);
            }
            if (f.this.kt != null) {
                f.this.kt.setVisibility(8);
            }
            if (f.this.gX != null) {
                f.this.gX.bH(f.this.getContext());
            }
            if (f.this.kv != null) {
                f.this.kv.cancel();
                f.this.kv = null;
            }
        }
    };

    @Override // com.kwad.sdk.core.g.b
    public final void cd() {
    }

    @Override // com.kwad.components.ad.reward.e.o
    public final int dr() {
        return com.kwad.sdk.c.a.a.h(getContext(), R.dimen.ksad_fullscreen_shake_tips_title_marginBottom) + com.kwad.sdk.c.a.a.h(getContext(), R.dimen.ksad_fullscreen_shake_tips_height);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        if (com.kwad.components.ad.fullscreen.b.a.b(getContext(), this.tm.mAdTemplate)) {
            this.tm.a(this);
            this.tm.b(this.mPlayEndPageListener);
            ds();
            initView();
            a(adInfoEl);
            float fEd = com.kwad.sdk.core.response.b.b.ed(adInfoEl);
            com.kwad.sdk.core.g.d dVar = this.gX;
            if (dVar == null) {
                com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(fEd);
                this.gX = dVar2;
                dVar2.a(this);
            } else {
                dVar.g(fEd);
            }
            this.gX.bG(getContext());
            Context context = getContext();
            if (context != null) {
                this.gZ = (Vibrator) context.getSystemService("vibrator");
            }
            com.kwad.components.ad.fullscreen.b.a.H(getContext());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void ds() {
        /*
            r8 = this;
            int r0 = com.kwad.sdk.R.id.ksad_root_container
            android.view.View r0 = r8.findViewById(r0)
            com.kwad.sdk.core.view.AdBaseFrameLayout r0 = (com.kwad.sdk.core.view.AdBaseFrameLayout) r0
            android.content.Context r1 = r8.getContext()
            int r2 = com.kwad.sdk.R.layout.ksad_shake_center
            r3 = 0
            android.view.View r1 = com.kwad.sdk.o.m.a(r1, r2, r0, r3)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r8.kn = r1
            r1.setVisibility(r3)
            android.view.ViewGroup r1 = r8.kn
            android.content.res.Resources r1 = r1.getResources()
            com.kwad.components.ad.reward.g r2 = r8.tm     // Catch: java.lang.Throwable -> L38
            com.kwad.sdk.core.response.model.AdTemplate r2 = r2.mAdTemplate     // Catch: java.lang.Throwable -> L38
            com.kwad.sdk.core.response.model.AdInfo r2 = com.kwad.sdk.core.response.b.e.el(r2)     // Catch: java.lang.Throwable -> L38
            int r2 = com.kwad.sdk.core.response.b.a.bf(r2)     // Catch: java.lang.Throwable -> L38
            r4 = 8
            if (r2 != r4) goto L3c
            com.kwad.components.ad.reward.g r2 = r8.tm     // Catch: java.lang.Throwable -> L38
            int r2 = r2.mScreenOrientation     // Catch: java.lang.Throwable -> L38
            if (r2 != 0) goto L3c
            r2 = 1
            goto L3d
        L38:
            r2 = move-exception
            com.kwad.sdk.core.d.c.printStackTrace(r2)
        L3c:
            r2 = r3
        L3d:
            if (r2 == 0) goto L46
            int r4 = com.kwad.sdk.R.dimen.ksad_fullscreen_shake_tips_icon_live_shop_marginBottom
            int r4 = r1.getDimensionPixelSize(r4)
            goto L4c
        L46:
            int r4 = com.kwad.sdk.R.dimen.ksad_fullscreen_shake_tips_icon_marginBottom
            int r4 = r1.getDimensionPixelSize(r4)
        L4c:
            int r5 = com.kwad.sdk.R.dimen.ksad_fullscreen_shake_tips_icon_marginLeft
            int r5 = r1.getDimensionPixelSize(r5)
            if (r2 == 0) goto L5b
            int r2 = com.kwad.sdk.R.dimen.ksad_fullscreen_shake_tips_title_live_shop_marginBottom
            int r2 = r1.getDimensionPixelSize(r2)
            goto L61
        L5b:
            int r2 = com.kwad.sdk.R.dimen.ksad_fullscreen_shake_tips_title_marginBottom
            int r2 = r1.getDimensionPixelSize(r2)
        L61:
            int r6 = com.kwad.sdk.R.dimen.ksad_fullscreen_shake_tips_height
            int r1 = r1.getDimensionPixelSize(r6)
            android.content.Context r6 = r8.getContext()
            int r7 = com.kwad.sdk.R.layout.ksad_shake_tips_title
            android.view.View r3 = com.kwad.sdk.o.m.a(r6, r7, r0, r3)
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r8.kt = r3
            int r6 = com.kwad.sdk.R.id.ksad_shake_tips_label
            android.view.View r3 = r3.findViewById(r6)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r8.ku = r3
            android.widget.FrameLayout r3 = r8.kt
            r6 = 4
            r3.setVisibility(r6)
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r6 = -2
            r3.<init>(r6, r1)
            r3.leftMargin = r5
            r3.bottomMargin = r2
            r1 = 83
            r3.gravity = r1
            android.widget.FrameLayout r1 = r8.kt
            r0.addView(r1, r3)
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r1.<init>(r6, r6)
            r2 = 17
            r1.gravity = r2
            android.view.ViewGroup r2 = r8.kn
            r0.addView(r2, r1)
            com.kwad.components.ad.reward.g r1 = r8.tm
            com.kwad.sdk.core.response.model.AdTemplate r1 = r1.mAdTemplate
            r2 = 185(0xb9, float:2.59E-43)
            r3 = 0
            com.kwad.sdk.core.adlog.c.b(r1, r2, r3)
            android.view.ViewGroup r1 = r8.kn
            com.kwad.components.ad.fullscreen.c.a.f$6 r2 = new com.kwad.components.ad.fullscreen.c.a.f$6
            r2.<init>()
            r1.post(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.fullscreen.c.a.f.ds():void");
    }

    private void initView() {
        this.ko = (TextView) this.kn.findViewById(R.id.ksad_shake_center_title);
        this.kp = (TextView) this.kn.findViewById(R.id.ksad_shake_center_sub_title);
        this.kq = (ImageView) this.kn.findViewById(R.id.ksad_shake_center_icon);
        this.kr = (FrameLayout) this.kn.findViewById(R.id.ksad_shake_center_circle_area);
        this.ks = (ImageView) this.kn.findViewById(R.id.ksad_shake_center_circle_area_bg);
        new h(getContext(), this.kn, this);
    }

    private void a(AdInfo adInfo) {
        String strEf = com.kwad.sdk.core.response.b.b.ef(adInfo);
        TextView textView = this.ko;
        if (textView != null) {
            textView.setText(strEf);
        }
        TextView textView2 = this.ku;
        if (textView2 != null) {
            textView2.setText(strEf);
        }
        String strA = a(this.tm, adInfo);
        TextView textView3 = this.kp;
        if (textView3 != null) {
            textView3.setText("或点击" + strA);
        }
    }

    private static String a(com.kwad.components.ad.reward.g gVar, AdInfo adInfo) {
        String strEh = com.kwad.sdk.core.response.b.b.eh(adInfo);
        com.kwad.components.core.e.d.c cVar = gVar.mApkDownloadHelper;
        if (!com.kwad.sdk.core.response.b.a.aF(adInfo) || cVar == null) {
            return strEh;
        }
        int iPB = cVar.pB();
        AdMatrixInfo.DownloadTexts downloadTextsEj = com.kwad.sdk.core.response.b.b.ej(adInfo);
        if (iPB == 8) {
            return downloadTextsEj.installAppLabel;
        }
        if (iPB == 12) {
            return downloadTextsEj.openAppLabel;
        }
        return downloadTextsEj.adActionDescription;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(float f, float f2) {
        if (this.kn == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.kn.getResources();
        Animator animatorA = com.kwad.components.core.t.o.a((View) this.kq, (Interpolator) null, 100L, 16.0f);
        animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.c.a.f.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.kq.setPivotX(f.this.kq.getWidth());
                f.this.kq.setPivotY(f.this.kq.getHeight());
            }
        });
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.kn, "translationX", f - (this.kn.getLeft() + (this.kn.getWidth() / 2.0f)));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.kn, "translationY", f2 - (this.kn.getTop() + (this.kn.getHeight() / 2.0f)));
        float dimension = resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_height);
        final float dimension2 = resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_icon_size);
        float width = this.kr.getWidth();
        float width2 = this.kq.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(width, dimension);
        valueAnimatorOfFloat.addUpdateListener(new com.kwad.components.ad.widget.a(this.ks) { // from class: com.kwad.components.ad.fullscreen.c.a.f.8
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
        valueAnimatorOfFloat2.addUpdateListener(new com.kwad.components.ad.widget.a(this.kq) { // from class: com.kwad.components.ad.fullscreen.c.a.f.9
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
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_stroke_size);
        ValueAnimator valueAnimatorOfArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) f.this.ks.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(iIntValue);
                    if (iIntValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    f.this.ks.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setDuration(200L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.ko.setAlpha(fFloatValue);
                    f.this.kp.setAlpha(fFloatValue);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(this.ko.getHeight(), 0.0f);
        valueAnimatorOfFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.ko) { // from class: com.kwad.components.ad.fullscreen.c.a.f.12
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator valueAnimatorOfFloat5 = ValueAnimator.ofFloat(this.kp.getHeight(), 0.0f);
        valueAnimatorOfFloat5.addUpdateListener(new com.kwad.components.ad.widget.a(this.kp) { // from class: com.kwad.components.ad.fullscreen.c.a.f.13
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
        animatorClone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.c.a.f.2
            private boolean kx = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.kq.setPivotX(dimension2);
                f.this.kq.setPivotY(dimension2);
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
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    f.this.kt.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.kt.setLayoutParams(layoutParams);
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
            bw.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.c.a.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.gX.Jb();
                }
            }, null, 500L);
            return;
        }
        if (this.tm != null) {
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            bVar.l(d);
            this.tm.a(1, getContext(), 157, 1, 0L, false, bVar);
        }
        bw.a(new bg() { // from class: com.kwad.components.ad.fullscreen.c.a.f.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("ShakePresenter", "onShakeEvent openGate2");
                f.this.gX.Jb();
            }
        }, null, 500L);
        bw.a(getContext(), this.gZ);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        this.tm.a(1, getContext(), 158, 1);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        this.tm.a(1, getContext(), 158, 1);
    }
}
