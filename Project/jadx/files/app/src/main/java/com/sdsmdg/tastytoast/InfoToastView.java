package com.sdsmdg.tastytoast;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public class InfoToastView extends View {
    private boolean A;
    private boolean B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    ValueAnimator f17870s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    float f17871t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Paint f17872u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f17873v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f17874w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f17875x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f17876y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f17877z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            InfoToastView.this.f17871t = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            InfoToastView infoToastView = InfoToastView.this;
            if (infoToastView.f17871t < 0.9d) {
                float f2 = (infoToastView.f17873v * 2.0f) - (InfoToastView.this.f17875x * 4.0f);
                InfoToastView infoToastView2 = InfoToastView.this;
                infoToastView.f17876y = (f2 * (infoToastView2.f17871t / 2.0f)) + infoToastView2.f17875x;
            } else {
                infoToastView.f17876y = infoToastView.f17873v - ((InfoToastView.this.f17875x * 5.0f) / 4.0f);
            }
            InfoToastView infoToastView3 = InfoToastView.this;
            float f3 = infoToastView3.f17871t;
            if (f3 < 0.16d) {
                infoToastView3.A = true;
                InfoToastView.this.f17877z = false;
            } else if (f3 < 0.32d) {
                infoToastView3.A = false;
                InfoToastView.this.f17877z = true;
            } else if (f3 < 0.48d) {
                infoToastView3.A = true;
                InfoToastView.this.f17877z = false;
            } else if (f3 < 0.64d) {
                infoToastView3.A = false;
                InfoToastView.this.f17877z = true;
            } else if (f3 < 0.8d) {
                infoToastView3.A = true;
                InfoToastView.this.f17877z = false;
            } else if (f3 < 0.96d) {
                infoToastView3.A = false;
                InfoToastView.this.f17877z = true;
            } else {
                infoToastView3.f17877z = false;
                InfoToastView.this.B = true;
                InfoToastView.this.A = false;
            }
            InfoToastView.this.postInvalidate();
        }
    }

    public InfoToastView(Context context) {
        super(context);
        new RectF();
        this.f17871t = 0.0f;
        this.f17873v = 0.0f;
        this.f17874w = 0.0f;
        this.f17875x = 0.0f;
        this.f17876y = 0.0f;
        this.f17877z = false;
        this.A = false;
        this.B = false;
    }

    private void d() {
        float f2 = this.f17875x;
        float f3 = this.f17873v;
        new RectF(f2, f2, f3 - f2, f3 - f2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f17872u.setStyle(Paint.Style.STROKE);
        float f2 = this.f17875x;
        float f3 = this.f17873v;
        canvas.drawLine(f2, f3 - ((f2 * 3.0f) / 2.0f), this.f17876y, f3 - ((f2 * 3.0f) / 2.0f), this.f17872u);
        this.f17872u.setStyle(Paint.Style.FILL);
        if (this.f17877z) {
            float f4 = this.f17875x;
            float f5 = this.f17874w;
            canvas.drawCircle(f4 + f5, this.f17873v / 3.0f, f5, this.f17872u);
            float f6 = this.f17873v;
            float f7 = f6 - this.f17875x;
            float f8 = this.f17874w;
            canvas.drawCircle(f7 - (f8 * 2.0f), f6 / 3.0f, f8, this.f17872u);
        }
        if (this.B) {
            float f9 = this.f17875x;
            float f10 = this.f17874w;
            canvas.drawCircle(f9 + ((f10 * 3.0f) / 2.0f), this.f17873v / 3.0f, f10, this.f17872u);
            float f11 = this.f17873v;
            float f12 = f11 - this.f17875x;
            float f13 = this.f17874w;
            canvas.drawCircle(f12 - ((5.0f * f13) / 2.0f), f11 / 3.0f, f13, this.f17872u);
        }
        if (this.A) {
            float f14 = this.f17875x;
            float f15 = this.f17874w;
            canvas.drawCircle(f14 + (2.0f * f15), this.f17873v / 3.0f, f15, this.f17872u);
            float f16 = this.f17873v;
            float f17 = f16 - this.f17875x;
            float f18 = this.f17874w;
            canvas.drawCircle(f17 - f18, f16 / 3.0f, f18, this.f17872u);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        c();
        d();
        this.f17873v = getMeasuredWidth();
        this.f17875x = a(10.0f);
        this.f17874w = a(3.0f);
        this.f17876y = this.f17875x;
    }

    private void c() {
        this.f17872u = new Paint();
        this.f17872u.setAntiAlias(true);
        this.f17872u.setStyle(Paint.Style.STROKE);
        this.f17872u.setColor(Color.parseColor("#337ab7"));
        this.f17872u.setStrokeWidth(a(2.0f));
    }

    public void b() {
        if (this.f17870s != null) {
            clearAnimation();
            this.f17877z = false;
            this.B = false;
            this.A = false;
            this.f17876y = this.f17875x;
            this.f17871t = 0.0f;
            this.f17870s.end();
        }
    }

    public int a(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void a() {
        b();
        a(0.0f, 1.0f, com.anythink.expressad.exoplayer.i.a.f9492f);
    }

    private ValueAnimator a(float f2, float f3, long j2) {
        this.f17870s = ValueAnimator.ofFloat(f2, f3);
        this.f17870s.setDuration(j2);
        this.f17870s.setInterpolator(new LinearInterpolator());
        this.f17870s.addUpdateListener(new a());
        if (!this.f17870s.isRunning()) {
            this.f17870s.start();
        }
        return this.f17870s;
    }

    public InfoToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new RectF();
        this.f17871t = 0.0f;
        this.f17873v = 0.0f;
        this.f17874w = 0.0f;
        this.f17875x = 0.0f;
        this.f17876y = 0.0f;
        this.f17877z = false;
        this.A = false;
        this.B = false;
    }

    public InfoToastView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new RectF();
        this.f17871t = 0.0f;
        this.f17873v = 0.0f;
        this.f17874w = 0.0f;
        this.f17875x = 0.0f;
        this.f17876y = 0.0f;
        this.f17877z = false;
        this.A = false;
        this.B = false;
    }
}
