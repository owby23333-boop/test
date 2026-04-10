package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class RingProgressView extends View {
    private Paint bf;
    private RectF d;
    private Context e;
    private ValueAnimator ga;
    private boolean p;
    private float tg;
    private int vn;

    public RingProgressView(Context context) {
        super(context);
        this.vn = 1500;
        this.e = context;
        Paint paint = new Paint();
        this.bf = paint;
        paint.setAntiAlias(true);
        this.bf.setStyle(Paint.Style.STROKE);
        this.bf.setStrokeWidth(10.0f);
        this.bf.setColor(Color.parseColor("#80FFFFFF"));
        this.d = new RectF();
    }

    public void bf() {
        ValueAnimator valueAnimator = this.ga;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void d() {
        this.p = true;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.p) {
            return;
        }
        canvas.drawArc(this.d, 270.0f, this.tg, false, this.bf);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d.set(5.0f, 5.0f, i - 5, i2 - 5);
    }

    public void setDuration(int i) {
        this.vn = i;
    }

    public void e() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.ga = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.vn);
        this.ga.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RingProgressView.this.tg = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RingProgressView.this.requestLayout();
            }
        });
        this.ga.start();
    }
}
