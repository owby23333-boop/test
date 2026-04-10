package com.sdsmdg.tastytoast;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public class ConfusingToastView extends View {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Bitmap f17847s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    ValueAnimator f17848t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    float f17849u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Paint f17850v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f17851w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f17852x;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ConfusingToastView confusingToastView = ConfusingToastView.this;
            confusingToastView.f17849u += 4.0f;
            confusingToastView.postInvalidate();
        }
    }

    public ConfusingToastView(Context context) {
        super(context);
        this.f17849u = 0.0f;
        this.f17851w = 0.0f;
        this.f17852x = 0.0f;
    }

    private void c() {
        this.f17850v = new Paint();
        this.f17850v.setAntiAlias(true);
        this.f17850v.setStyle(Paint.Style.STROKE);
        this.f17850v.setColor(Color.parseColor("#FE9D4D"));
    }

    private void d() {
        Path path = new Path();
        RectF rectF = new RectF((this.f17851w / 2.0f) - a(1.5f), (this.f17852x / 2.0f) - a(1.5f), (this.f17851w / 2.0f) + a(1.5f), (this.f17852x / 2.0f) + a(1.5f));
        path.addArc(rectF, 180.0f, 180.0f);
        rectF.set(rectF.left - a(3.0f), rectF.top - a(1.5f), rectF.right, rectF.bottom + a(1.5f));
        path.addArc(rectF, 0.0f, 180.0f);
        rectF.set(rectF.left, rectF.top - a(1.5f), rectF.right + a(3.0f), rectF.bottom + a(1.5f));
        path.addArc(rectF, 180.0f, 180.0f);
        rectF.set(rectF.left - a(3.0f), rectF.top - a(1.5f), rectF.right, rectF.bottom + a(1.5f));
        path.addArc(rectF, 0.0f, 180.0f);
        this.f17847s = Bitmap.createBitmap((int) this.f17851w, (int) this.f17852x, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f17847s);
        this.f17850v.setStrokeWidth(a(1.7f));
        canvas.drawPath(path, this.f17850v);
    }

    public float a(float f2) {
        return f2 * getContext().getResources().getDisplayMetrics().density;
    }

    public void b() {
        if (this.f17848t != null) {
            clearAnimation();
            this.f17848t.end();
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.rotate(this.f17849u, this.f17851w / 4.0f, (this.f17852x * 2.0f) / 5.0f);
        canvas.drawBitmap(this.f17847s, (this.f17851w / 4.0f) - (r0.getWidth() / 2.0f), ((this.f17852x * 2.0f) / 5.0f) - (this.f17847s.getHeight() / 2.0f), this.f17850v);
        canvas.restore();
        canvas.save();
        canvas.rotate(this.f17849u, (this.f17851w * 3.0f) / 4.0f, (this.f17852x * 2.0f) / 5.0f);
        canvas.drawBitmap(this.f17847s, ((this.f17851w * 3.0f) / 4.0f) - (r0.getWidth() / 2.0f), ((this.f17852x * 2.0f) / 5.0f) - (this.f17847s.getHeight() / 2.0f), this.f17850v);
        canvas.restore();
        this.f17850v.setStrokeWidth(a(2.0f));
        float f2 = this.f17851w;
        float f3 = this.f17852x;
        canvas.drawLine(f2 / 4.0f, (f3 * 3.0f) / 4.0f, (f2 * 3.0f) / 4.0f, (f3 * 3.0f) / 4.0f, this.f17850v);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f17851w = getMeasuredWidth();
        this.f17852x = getMeasuredHeight();
        c();
        d();
    }

    public void a() {
        b();
        a(0.0f, 1.0f, com.anythink.expressad.exoplayer.i.a.f9492f);
    }

    private ValueAnimator a(float f2, float f3, long j2) {
        this.f17848t = ValueAnimator.ofFloat(f2, f3);
        this.f17848t.setDuration(j2);
        this.f17848t.setInterpolator(new LinearInterpolator());
        this.f17848t.setRepeatCount(-1);
        this.f17848t.setRepeatMode(1);
        this.f17848t.addUpdateListener(new a());
        if (!this.f17848t.isRunning()) {
            this.f17848t.start();
        }
        return this.f17848t;
    }

    public ConfusingToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17849u = 0.0f;
        this.f17851w = 0.0f;
        this.f17852x = 0.0f;
    }

    public ConfusingToastView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17849u = 0.0f;
        this.f17851w = 0.0f;
        this.f17852x = 0.0f;
    }
}
