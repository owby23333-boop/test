package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class SplashDiffuseView extends View {
    private static int d = 50;
    private int bf;
    private Paint e;
    private ObjectAnimator tg;

    public SplashDiffuseView(Context context) {
        this(context, null);
    }

    private void bf() {
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setColor(Color.parseColor("#FFFFFFFF"));
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeWidth(18.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.tg = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(200L);
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.e.setShader(new LinearGradient(getMeasuredWidth() / 2, 0.0f, getMeasuredWidth() / 2, getMeasuredHeight(), -1, 16777215, Shader.TileMode.CLAMP));
        canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, this.bf, this.e);
    }

    public SplashDiffuseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SplashDiffuseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bf = 10;
        bf();
    }

    public void e() {
        int iMin = ((int) Math.min(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f)) - 18;
        d = iMin;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(10, iMin);
        valueAnimatorOfInt.setInterpolator(new e(0.0f, 0.2f, 0.3f, 1.0f));
        valueAnimatorOfInt.setDuration(800L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SplashDiffuseView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashDiffuseView.this.bf = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SplashDiffuseView.this.requestLayout();
            }
        });
        valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SplashDiffuseView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SplashDiffuseView.this.tg.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SplashDiffuseView.this.setVisibility(0);
                SplashDiffuseView.this.setAlpha(1.0f);
            }
        });
        valueAnimatorOfInt.start();
    }
}
