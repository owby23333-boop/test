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
public class ErrorToastView extends View {
    private float A;
    private float B;
    private boolean C;
    private boolean D;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    RectF f17861s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    RectF f17862t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    RectF f17863u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    ValueAnimator f17864v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    float f17865w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Paint f17866x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f17867y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f17868z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ErrorToastView.this.f17865w = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ErrorToastView errorToastView = ErrorToastView.this;
            float f2 = errorToastView.f17865w;
            if (f2 < 0.5d) {
                errorToastView.D = false;
                ErrorToastView.this.C = false;
                ErrorToastView errorToastView2 = ErrorToastView.this;
                errorToastView2.B = errorToastView2.f17865w * 240.0f;
                ErrorToastView.this.C = true;
            } else if (f2 <= 0.55d || f2 >= 0.7d) {
                ErrorToastView.this.B = 120.0f;
                ErrorToastView.this.D = true;
                ErrorToastView.this.C = false;
            } else {
                errorToastView.B = 120.0f;
                ErrorToastView.this.D = false;
                ErrorToastView.this.C = true;
            }
            ErrorToastView.this.postInvalidate();
        }
    }

    public ErrorToastView(Context context) {
        super(context);
        this.f17861s = new RectF();
        this.f17862t = new RectF();
        this.f17863u = new RectF();
        this.f17865w = 0.0f;
        this.f17867y = 0.0f;
        this.f17868z = 0.0f;
        this.A = 0.0f;
        this.B = 0.0f;
        this.C = false;
        this.D = false;
    }

    private void c() {
        this.f17866x = new Paint();
        this.f17866x.setAntiAlias(true);
        this.f17866x.setStyle(Paint.Style.STROKE);
        this.f17866x.setColor(Color.parseColor("#d9534f"));
        this.f17866x.setStrokeWidth(a(2.0f));
    }

    private void d() {
        float f2 = this.A;
        float f3 = this.f17867y;
        this.f17861s = new RectF(f2 / 2.0f, f3 / 2.0f, f3 - (f2 / 2.0f), (f3 * 3.0f) / 2.0f);
        float f4 = this.A;
        float f5 = this.f17868z;
        float f6 = this.f17867y;
        this.f17862t = new RectF((f4 + f5) - f5, (f6 / 3.0f) - f5, f4 + f5 + f5, (f6 / 3.0f) + f5);
        float f7 = this.f17867y;
        float f8 = this.A;
        float f9 = this.f17868z;
        this.f17863u = new RectF((f7 - f8) - ((5.0f * f9) / 2.0f), (f7 / 3.0f) - f9, (f7 - f8) - (f9 / 2.0f), (f7 / 3.0f) + f9);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f17866x.setStyle(Paint.Style.STROKE);
        canvas.drawArc(this.f17861s, 210.0f, this.B, false, this.f17866x);
        this.f17866x.setStyle(Paint.Style.FILL);
        if (this.C) {
            float f2 = this.A;
            float f3 = this.f17868z;
            canvas.drawCircle(f2 + f3 + (f3 / 2.0f), this.f17867y / 3.0f, f3, this.f17866x);
            float f4 = this.f17867y;
            float f5 = f4 - this.A;
            float f6 = this.f17868z;
            canvas.drawCircle((f5 - f6) - (f6 / 2.0f), f4 / 3.0f, f6, this.f17866x);
        }
        if (this.D) {
            canvas.drawArc(this.f17862t, 160.0f, -220.0f, false, this.f17866x);
            canvas.drawArc(this.f17863u, 20.0f, 220.0f, false, this.f17866x);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        c();
        d();
        this.f17867y = getMeasuredWidth();
        this.A = a(10.0f);
        this.f17868z = a(3.0f);
    }

    public void b() {
        if (this.f17864v != null) {
            clearAnimation();
            this.D = false;
            this.B = 0.0f;
            this.C = false;
            this.f17865w = 0.0f;
            this.f17864v.end();
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
        this.f17864v = ValueAnimator.ofFloat(f2, f3);
        this.f17864v.setDuration(j2);
        this.f17864v.setInterpolator(new LinearInterpolator());
        this.f17864v.addUpdateListener(new a());
        if (!this.f17864v.isRunning()) {
            this.f17864v.start();
        }
        return this.f17864v;
    }

    public ErrorToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17861s = new RectF();
        this.f17862t = new RectF();
        this.f17863u = new RectF();
        this.f17865w = 0.0f;
        this.f17867y = 0.0f;
        this.f17868z = 0.0f;
        this.A = 0.0f;
        this.B = 0.0f;
        this.C = false;
        this.D = false;
    }

    public ErrorToastView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17861s = new RectF();
        this.f17862t = new RectF();
        this.f17863u = new RectF();
        this.f17865w = 0.0f;
        this.f17867y = 0.0f;
        this.f17868z = 0.0f;
        this.A = 0.0f;
        this.B = 0.0f;
        this.C = false;
        this.D = false;
    }
}
