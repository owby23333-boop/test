package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
public class RingProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f604a;
    private RectF dl;
    private boolean e;
    private Paint g;
    private ValueAnimator gc;
    private int m;
    private Context z;

    public RingProgressView(Context context) {
        super(context);
        this.m = TTAdConstant.STYLE_SIZE_RADIO_3_2;
        this.z = context;
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(10.0f);
        this.g.setColor(Color.parseColor("#80FFFFFF"));
        this.dl = new RectF();
    }

    public void z() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.gc = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.m);
        this.gc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RingProgressView.this.f604a = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RingProgressView.this.requestLayout();
            }
        });
        this.gc.start();
    }

    public void g() {
        ValueAnimator valueAnimator = this.gc;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void dl() {
        this.e = true;
        invalidate();
    }

    public void setDuration(int i) {
        this.m = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.e) {
            return;
        }
        canvas.drawArc(this.dl, 270.0f, this.f604a, false, this.g);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dl.set(5.0f, 5.0f, i - 5, i2 - 5);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }
}
