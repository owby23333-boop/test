package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

/* JADX INFO: loaded from: classes2.dex */
public class ShakeButton extends Button {
    private ValueAnimator z;

    public ShakeButton(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        z();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.z.removeAllListeners();
            this.z.removeAllUpdateListeners();
            this.z = null;
        }
    }

    private void z() {
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.z.removeAllListeners();
            this.z.removeAllUpdateListeners();
            this.z = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1300L);
        this.z.setInterpolator(new LinearInterpolator());
        this.z.setRepeatCount(-1);
        this.z.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ShakeButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float animatedFraction = valueAnimator2.getAnimatedFraction();
                ShakeButton.this.setRotation((float) (((double) ((1.0f - animatedFraction) * 6.0f)) * Math.cos(((double) (animatedFraction * 10.0f)) * 3.141592653589793d)));
            }
        });
        this.z.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.widget.ShakeButton.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationEnd(animator);
                ShakeButton.this.setRotation(6.0f);
            }
        });
        this.z.start();
    }
}
