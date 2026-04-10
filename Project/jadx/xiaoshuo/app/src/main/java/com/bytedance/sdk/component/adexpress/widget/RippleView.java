package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class RippleView extends View {
    private float bf;
    private ValueAnimator d;
    private float e;
    private Paint ga;
    private float p;
    private ValueAnimator tg;
    private float v;
    private long vn;
    private Animator.AnimatorListener zk;

    public RippleView(Context context) {
        super(context);
        this.vn = 300L;
        this.p = 0.0f;
        e();
    }

    public void bf() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.v);
        this.d = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.vn);
        this.d.setInterpolator(new LinearInterpolator());
        this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.p = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        this.d.start();
    }

    public void d() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.v, 0.0f);
        this.tg = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.vn);
        this.tg.setInterpolator(new LinearInterpolator());
        this.tg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.p = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.zk;
        if (animatorListener != null) {
            this.tg.addListener(animatorListener);
        }
        this.tg.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.e, this.bf, this.p, this.ga);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = i / 2.0f;
        this.bf = i2 / 2.0f;
        this.v = (float) (Math.hypot(i, i2) / 2.0d);
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.zk = animatorListener;
    }

    public void e() {
        Paint paint = new Paint(1);
        this.ga = paint;
        paint.setStyle(Paint.Style.FILL);
        this.ga.setColor(Color.parseColor("#99000000"));
    }
}
