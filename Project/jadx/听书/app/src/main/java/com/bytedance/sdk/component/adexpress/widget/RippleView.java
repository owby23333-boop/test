package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class RippleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ValueAnimator f605a;
    private ValueAnimator dl;
    private float e;
    private Animator.AnimatorListener fo;
    private float g;
    private Paint gc;
    private float gz;
    private long m;
    private int uy;
    private float z;

    public RippleView(Context context, int i) {
        super(context);
        this.m = 300L;
        this.e = 0.0f;
        this.uy = i;
        z();
    }

    public void z() {
        Paint paint = new Paint(1);
        this.gc = paint;
        paint.setStyle(Paint.Style.FILL);
        this.gc.setColor(this.uy);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.z = i / 2.0f;
        this.g = i2 / 2.0f;
        this.gz = (float) (Math.hypot(i, i2) / 2.0d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.z, this.g, this.e, this.gc);
    }

    public void g() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.gz);
        this.dl = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.m);
        this.dl.setInterpolator(new LinearInterpolator());
        this.dl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        this.dl.start();
    }

    public void dl() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.gz, 0.0f);
        this.f605a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.m);
        this.f605a.setInterpolator(new LinearInterpolator());
        this.f605a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.fo;
        if (animatorListener != null) {
            this.f605a.addListener(animatorListener);
        }
        this.f605a.start();
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.fo = animatorListener;
    }
}
