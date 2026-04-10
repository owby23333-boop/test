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
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class SplashDiffuseView extends View {
    private static int dl = 50;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObjectAnimator f609a;
    private int g;
    private Paint z;

    public SplashDiffuseView(Context context) {
        this(context, null);
    }

    public SplashDiffuseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SplashDiffuseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 10;
        dl();
    }

    private void dl() {
        Paint paint = new Paint();
        this.z = paint;
        paint.setAntiAlias(true);
        this.z.setColor(Color.parseColor("#FFFFFFFF"));
        this.z.setStyle(Paint.Style.STROKE);
        this.z.setStrokeWidth(18.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.f609a = objectAnimatorOfFloat;
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
        this.z.setShader(new LinearGradient(getMeasuredWidth() / 2, 0.0f, getMeasuredWidth() / 2, getMeasuredHeight(), -1, 16777215, Shader.TileMode.CLAMP));
        canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, this.g, this.z);
    }

    public void z() {
        int iMin = ((int) Math.min(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f)) - 18;
        dl = iMin;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(10, iMin);
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.0f, 0.2f, 0.3f, 1.0f));
        valueAnimatorOfInt.setDuration(800L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SplashDiffuseView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashDiffuseView.this.g = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SplashDiffuseView.this.invalidate();
            }
        });
        valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SplashDiffuseView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SplashDiffuseView.this.setVisibility(0);
                SplashDiffuseView.this.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SplashDiffuseView.this.f609a.start();
            }
        });
        valueAnimatorOfInt.start();
    }

    public void g() {
        clearAnimation();
    }
}
