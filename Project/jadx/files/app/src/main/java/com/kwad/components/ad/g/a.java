package com.kwad.components.ad.g;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private View Gl;
    private Runnable Gm;
    private boolean Gn = false;

    @Nullable
    private Animator hi;
    private View xZ;
    private Button ya;
    private Button yb;

    public a(View view) {
        this.Gl = view;
        initView();
    }

    private static Animator a(final View view, float f2, final float f3, long j2) {
        final float f4 = f2 / f3;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, f3);
        valueAnimatorOfFloat.setDuration(j2);
        valueAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view.getResources().getDimension(R.dimen.ksad_reward_apk_info_card_actionbar_text_size);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.g.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f5 = f4 * fFloatValue;
                float f6 = f3;
                if (f6 != 0.0f) {
                    float f7 = (fFloatValue / f6) * dimension;
                    View view2 = view;
                    if (view2 instanceof TextView) {
                        ((TextView) view2).setTextSize(0, f7);
                    }
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) fFloatValue;
                    layoutParams.width = (int) f5;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        return valueAnimatorOfFloat;
    }

    private static Animator a(final View view, View view2, int i2, int i3, long j2, long j3) {
        Animator animatorB = b(view, 200L);
        float f2 = i2;
        float f3 = i3;
        Animator animatorA = a(view2, f2, f3, 200L);
        animatorA.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.g.a.2
            @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(1600L);
        Animator animatorB2 = b(view2, 200L);
        Animator animatorA2 = a(view, f2, f3, 200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animatorB, animatorA, objectAnimatorOfFloat, animatorB2, animatorA2);
        return animatorSet;
    }

    private static Animator b(View view, long j2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(j2);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return objectAnimatorOfFloat;
    }

    private void initView() {
        this.ya = (Button) this.Gl.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.yb = (Button) this.Gl.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.xZ = this.Gl.findViewById(R.id.ksad_reward_apk_info_install_container);
    }

    public final void kb() {
        lX();
    }

    public final void lW() {
        com.kwad.sdk.core.d.b.d("ApkInstallAnimHelper", "startAnimation");
        int height = this.xZ.getHeight();
        int width = this.xZ.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.hi == null) {
            this.hi = a(this.yb, this.ya, width, height, 1600L, 200L);
            this.hi.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.g.a.1
                @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(final Animator animator) {
                    if (a.this.Gn) {
                        return;
                    }
                    if (a.this.Gm == null) {
                        a.this.Gm = new Runnable() { // from class: com.kwad.components.ad.g.a.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                animator.start();
                            }
                        };
                    }
                    bh.a(a.this.Gm, null, 1600L);
                }
            });
        }
        com.kwad.sdk.core.d.b.d("ApkInstallAnimHelper", "mAnimator isStarted: " + this.hi.isStarted());
        if (!this.hi.isStarted()) {
            com.kwad.sdk.core.d.b.d("ApkInstallAnimHelper", "mAnimator.start()");
            this.hi.start();
        }
        this.Gn = false;
    }

    public final void lX() {
        Animator animator = this.hi;
        if (animator != null) {
            animator.cancel();
            this.hi.removeAllListeners();
            this.Gn = true;
        }
        Runnable runnable = this.Gm;
        if (runnable != null) {
            bh.b(runnable);
            this.Gm = null;
        }
    }

    public final void lY() {
        this.Gn = true;
    }
}
