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
public class SuccessToastView extends View {
    private boolean A;
    private boolean B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    RectF f17879s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    ValueAnimator f17880t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    float f17881u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Paint f17882v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f17883w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f17884x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f17885y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f17886z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SuccessToastView.this.f17881u = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SuccessToastView successToastView = SuccessToastView.this;
            float f2 = successToastView.f17881u;
            if (f2 < 0.5d) {
                successToastView.A = false;
                SuccessToastView.this.B = false;
                SuccessToastView successToastView2 = SuccessToastView.this;
                successToastView2.f17886z = successToastView2.f17881u * (-360.0f);
            } else if (f2 <= 0.55d || f2 >= 0.7d) {
                SuccessToastView.this.f17886z = -180.0f;
                SuccessToastView.this.A = true;
                SuccessToastView.this.B = true;
            } else {
                successToastView.f17886z = -180.0f;
                SuccessToastView.this.A = true;
                SuccessToastView.this.B = false;
            }
            SuccessToastView.this.postInvalidate();
        }
    }

    public SuccessToastView(Context context) {
        super(context);
        this.f17879s = new RectF();
        this.f17881u = 0.0f;
        this.f17883w = 0.0f;
        this.f17884x = 0.0f;
        this.f17885y = 0.0f;
        this.f17886z = 0.0f;
        this.A = false;
        this.B = false;
    }

    private void c() {
        this.f17882v = new Paint();
        this.f17882v.setAntiAlias(true);
        this.f17882v.setStyle(Paint.Style.STROKE);
        this.f17882v.setColor(Color.parseColor("#5cb85c"));
        this.f17882v.setStrokeWidth(a(2.0f));
    }

    private void d() {
        float f2 = this.f17885y;
        float f3 = this.f17883w;
        this.f17879s = new RectF(f2, f2, f3 - f2, f3 - f2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f17882v.setStyle(Paint.Style.STROKE);
        canvas.drawArc(this.f17879s, 180.0f, this.f17886z, false, this.f17882v);
        this.f17882v.setStyle(Paint.Style.FILL);
        if (this.A) {
            float f2 = this.f17885y;
            float f3 = this.f17884x;
            canvas.drawCircle(f2 + f3 + (f3 / 2.0f), this.f17883w / 3.0f, f3, this.f17882v);
        }
        if (this.B) {
            float f4 = this.f17883w;
            float f5 = f4 - this.f17885y;
            float f6 = this.f17884x;
            canvas.drawCircle((f5 - f6) - (f6 / 2.0f), f4 / 3.0f, f6, this.f17882v);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        c();
        d();
        this.f17883w = getMeasuredWidth();
        this.f17885y = a(10.0f);
        this.f17884x = a(3.0f);
    }

    public void b() {
        if (this.f17880t != null) {
            clearAnimation();
            this.A = false;
            this.B = false;
            this.f17881u = 0.0f;
            this.f17880t.end();
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
        this.f17880t = ValueAnimator.ofFloat(f2, f3);
        this.f17880t.setDuration(j2);
        this.f17880t.setInterpolator(new LinearInterpolator());
        this.f17880t.addUpdateListener(new a());
        if (!this.f17880t.isRunning()) {
            this.f17880t.start();
        }
        return this.f17880t;
    }

    public SuccessToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17879s = new RectF();
        this.f17881u = 0.0f;
        this.f17883w = 0.0f;
        this.f17884x = 0.0f;
        this.f17885y = 0.0f;
        this.f17886z = 0.0f;
        this.A = false;
        this.B = false;
    }

    public SuccessToastView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17879s = new RectF();
        this.f17881u = 0.0f;
        this.f17883w = 0.0f;
        this.f17884x = 0.0f;
        this.f17885y = 0.0f;
        this.f17886z = 0.0f;
        this.A = false;
        this.B = false;
    }
}
