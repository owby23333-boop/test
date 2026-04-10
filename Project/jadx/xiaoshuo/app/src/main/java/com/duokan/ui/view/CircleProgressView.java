package com.duokan.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes5.dex */
public class CircleProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Point f6728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f6729b;
    public float c;
    public Paint d;
    public int e;
    public float f;
    public Paint g;
    public int h;
    public float i;
    public float j;
    public float k;
    public RectF l;
    public float m;
    public float n;
    public float o;
    public boolean p;
    public int q;
    public ValueAnimator r;
    public int s;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CircleProgressView.this.m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CircleProgressView circleProgressView = CircleProgressView.this;
            circleProgressView.n = circleProgressView.h(circleProgressView.m * CircleProgressView.this.o, CircleProgressView.this.s);
            CircleProgressView.this.postInvalidate();
        }
    }

    public CircleProgressView(Context context) {
        this(context, null);
    }

    public final void f(Canvas canvas) {
        canvas.save();
        canvas.drawArc(this.l, this.j, this.k, false, this.g);
        canvas.drawArc(this.l, this.j, this.k * this.m, false, this.d);
        canvas.restore();
    }

    public final void g() {
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(this.f);
        this.d.setStrokeCap(Paint.Cap.ROUND);
        this.d.setColor(this.e);
        Paint paint2 = new Paint();
        this.g = paint2;
        paint2.setAntiAlias(true);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setStrokeWidth(this.i);
        this.g.setStrokeCap(Paint.Cap.ROUND);
        this.g.setColor(this.h);
    }

    public float h(double d, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("The   scale   must   be   a   positive   integer   or   zero");
        }
        if (i == 0) {
            return Float.parseFloat(new DecimalFormat("0").format(d));
        }
        String str = "0.";
        for (int i2 = 0; i2 < i; i2++) {
            str = str + "0";
        }
        return Float.parseFloat(new DecimalFormat(str).format(d));
    }

    public void i(float f, float f2) {
        this.n = f;
        this.o = f2;
        j(this.m, Float.valueOf(f).floatValue() / f2, this.q);
    }

    public final void j(float f, float f2, int i) {
        if (!this.p) {
            this.m = f2;
            this.n = h(this.n, this.s);
            postInvalidate();
        } else {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
            this.r = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(i);
            this.r.addUpdateListener(new a());
            this.r.start();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        f(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Point point = this.f6728a;
        point.x = i / 2;
        point.y = i2 / 2;
        float fMax = Math.max(this.f, this.i);
        float fMin = Math.min((i - getPaddingLeft()) - getPaddingRight(), (i2 - getPaddingBottom()) - getPaddingTop()) / 2.0f;
        this.f6729b = fMin;
        float f = fMax / 2.0f;
        this.c = fMin + f;
        RectF rectF = this.l;
        Point point2 = this.f6728a;
        int i5 = point2.x;
        rectF.left = (i5 - fMin) + f;
        int i6 = point2.y;
        rectF.top = (i6 - fMin) + f;
        rectF.right = (i5 + fMin) - f;
        rectF.bottom = (i6 + fMin) - f;
    }

    public void setAnim(boolean z) {
        this.p = z;
    }

    public void setBgCirColor(int i) {
        this.h = i;
        this.g.setColor(i);
    }

    public void setBgCirWidth(float f) {
        this.i = f;
        this.g.setStrokeWidth(f);
    }

    public void setCirColor(int i) {
        this.e = i;
        this.d.setColor(i);
    }

    public void setCirWidth(float f) {
        this.f = f;
        this.d.setStrokeWidth(f);
    }

    public void setValue(float f) {
        this.n = f;
        j(this.m, Float.valueOf(f).floatValue() / this.o, this.q);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 15.0f;
        this.i = 15.0f;
        this.j = 270.0f;
        this.k = 360.0f;
        this.o = 100.0f;
        this.p = false;
        this.q = 800;
        this.s = 2;
        this.h = Color.parseColor("#f5f5f5");
        this.e = Color.parseColor("#FFD014");
        this.f6728a = new Point();
        this.l = new RectF();
        g();
    }
}
