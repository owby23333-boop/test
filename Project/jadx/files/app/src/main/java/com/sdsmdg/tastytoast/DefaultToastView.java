package com.sdsmdg.tastytoast;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultToastView extends View {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    ValueAnimator f17854s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    float f17855t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Paint f17856u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Paint f17857v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f17858w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f17859x;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DefaultToastView.this.f17855t = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DefaultToastView.this.postInvalidate();
        }
    }

    public DefaultToastView(Context context) {
        super(context);
        this.f17855t = 0.0f;
        this.f17858w = 0.0f;
    }

    private void c() {
        this.f17856u = new Paint();
        this.f17856u.setAntiAlias(true);
        this.f17856u.setStyle(Paint.Style.STROKE);
        this.f17856u.setColor(Color.parseColor("#222222"));
        this.f17856u.setStrokeWidth(a(2.0f));
        this.f17857v = new Paint();
        this.f17857v.setAntiAlias(true);
        this.f17857v.setStyle(Paint.Style.STROKE);
        this.f17857v.setColor(Color.parseColor("#222222"));
        this.f17857v.setStrokeWidth(a(4.0f));
        this.f17859x = a(4.0f);
    }

    public void a() {
        b();
        a(0.0f, 1.0f, com.anythink.expressad.exoplayer.i.a.f9492f);
    }

    public void b() {
        if (this.f17854s != null) {
            clearAnimation();
            this.f17854s.end();
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        float f2 = this.f17858w;
        canvas.drawCircle(f2 / 2.0f, f2 / 2.0f, f2 / 4.0f, this.f17856u);
        for (int i2 = 0; i2 < 360; i2 += 40) {
            int i3 = (int) ((this.f17855t * 40.0f) + i2);
            double d2 = this.f17858w / 4.0f;
            double d3 = i3;
            Double.isNaN(d3);
            double d4 = (d3 * 3.141592653589793d) / 180.0d;
            double dCos = Math.cos(d4);
            Double.isNaN(d2);
            double d5 = this.f17858w / 4.0f;
            double dSin = Math.sin(d4);
            Double.isNaN(d5);
            double d6 = (this.f17858w / 4.0f) + this.f17859x;
            double dCos2 = Math.cos(d4);
            Double.isNaN(d6);
            double d7 = (this.f17858w / 4.0f) + this.f17859x;
            double dSin2 = Math.sin(d4);
            Double.isNaN(d7);
            float f3 = this.f17858w;
            canvas.drawLine((f3 / 2.0f) - ((float) (d2 * dCos)), (f3 / 2.0f) - ((float) (d5 * dSin)), (f3 / 2.0f) - ((float) (d6 * dCos2)), (f3 / 2.0f) - ((float) (d7 * dSin2)), this.f17857v);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        c();
        this.f17858w = getMeasuredWidth();
        a(5.0f);
    }

    private ValueAnimator a(float f2, float f3, long j2) {
        this.f17854s = ValueAnimator.ofFloat(f2, f3);
        this.f17854s.setDuration(j2);
        this.f17854s.setInterpolator(new LinearInterpolator());
        this.f17854s.setRepeatCount(-1);
        this.f17854s.setRepeatMode(1);
        this.f17854s.addUpdateListener(new a());
        if (!this.f17854s.isRunning()) {
            this.f17854s.start();
        }
        return this.f17854s;
    }

    public DefaultToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17855t = 0.0f;
        this.f17858w = 0.0f;
    }

    public DefaultToastView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17855t = 0.0f;
        this.f17858w = 0.0f;
    }

    public int a(float f2) {
        return (int) (f2 * getContext().getResources().getDisplayMetrics().density);
    }
}
