package com.sdsmdg.tastytoast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class WarningToastView extends View {
    private float A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    RectF f17888s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    RectF f17889t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    RectF f17890u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Paint f17891v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f17892w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f17893x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f17894y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f17895z;

    public WarningToastView(Context context) {
        super(context);
        this.f17888s = new RectF();
        this.f17889t = new RectF();
        this.f17890u = new RectF();
        this.f17892w = 0.0f;
        this.f17893x = 0.0f;
        this.f17894y = 0.0f;
        this.f17895z = 0.0f;
        this.A = 0.0f;
    }

    private void a() {
        this.f17891v = new Paint();
        this.f17891v.setAntiAlias(true);
        this.f17891v.setStyle(Paint.Style.STROKE);
        this.f17891v.setColor(Color.parseColor("#f0ad4e"));
        this.f17891v.setStrokeWidth(this.f17894y);
    }

    private void b() {
        float f2 = this.f17895z;
        float f3 = this.f17892w;
        this.f17888s = new RectF(f2, 0.0f, f3 - f2, f3 - this.A);
        double d2 = this.f17895z;
        Double.isNaN(d2);
        float fA = a(6.0f);
        float f4 = this.f17895z;
        this.f17889t = new RectF((float) (d2 * 1.5d), fA + f4 + (this.f17893x / 3.0f), f4 + a(9.0f), a(6.0f) + this.f17895z + (this.f17893x / 2.0f));
        float fA2 = this.f17895z + a(9.0f);
        float fA3 = a(3.0f);
        float f5 = this.f17895z;
        this.f17890u = new RectF(fA2, fA3 + f5 + (this.f17893x / 3.0f), f5 + a(18.0f), a(3.0f) + this.f17895z + (this.f17893x / 2.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f17891v.setStyle(Paint.Style.STROKE);
        canvas.drawArc(this.f17888s, 170.0f, -144.0f, false, this.f17891v);
        canvas.drawLine((this.f17892w - a(3.0f)) - this.f17894y, this.f17895z + (this.f17893x / 6.0f), (this.f17892w - a(3.0f)) - this.f17894y, (this.f17893x - a(2.0f)) - (this.f17893x / 4.0f), this.f17891v);
        float fA = ((this.f17892w - a(3.0f)) - this.f17894y) - a(8.0f);
        double d2 = this.f17895z;
        double d3 = this.f17893x;
        Double.isNaN(d3);
        Double.isNaN(d2);
        float fA2 = ((this.f17892w - a(3.0f)) - this.f17894y) - a(8.0f);
        double dA = this.f17893x - a(3.0f);
        double d4 = this.f17893x;
        Double.isNaN(d4);
        Double.isNaN(dA);
        canvas.drawLine(fA, (float) (d2 + (d3 / 8.5d)), fA2, (float) (dA - (d4 / 2.5d)), this.f17891v);
        float fA3 = ((this.f17892w - a(3.0f)) - this.f17894y) - a(17.0f);
        float f2 = this.f17895z + (this.f17893x / 10.0f);
        float fA4 = ((this.f17892w - a(3.0f)) - this.f17894y) - a(17.0f);
        double dA2 = this.f17893x - a(3.0f);
        double d5 = this.f17893x;
        Double.isNaN(d5);
        Double.isNaN(dA2);
        canvas.drawLine(fA3, f2, fA4, (float) (dA2 - (d5 / 2.5d)), this.f17891v);
        float fA5 = ((this.f17892w - a(3.0f)) - this.f17894y) - a(26.0f);
        float f3 = this.f17895z + (this.f17893x / 10.0f);
        float fA6 = ((this.f17892w - a(3.0f)) - this.f17894y) - a(26.0f);
        double dA3 = this.f17893x - a(2.0f);
        double d6 = this.f17893x;
        Double.isNaN(d6);
        Double.isNaN(dA3);
        canvas.drawLine(fA5, f3, fA6, (float) (dA3 - (d6 / 2.5d)), this.f17891v);
        canvas.drawArc(this.f17889t, 170.0f, 180.0f, false, this.f17891v);
        canvas.drawArc(this.f17890u, 175.0f, -150.0f, false, this.f17891v);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        a();
        b();
        this.f17893x = getMeasuredHeight();
        this.f17892w = getMeasuredWidth();
        this.f17895z = a(2.0f);
        this.A = this.f17895z * 2.0f;
        this.f17894y = a(2.0f);
    }

    public float a(float f2) {
        return f2 * (getContext().getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public WarningToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17888s = new RectF();
        this.f17889t = new RectF();
        this.f17890u = new RectF();
        this.f17892w = 0.0f;
        this.f17893x = 0.0f;
        this.f17894y = 0.0f;
        this.f17895z = 0.0f;
        this.A = 0.0f;
    }

    public WarningToastView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17888s = new RectF();
        this.f17889t = new RectF();
        this.f17890u = new RectF();
        this.f17892w = 0.0f;
        this.f17893x = 0.0f;
        this.f17894y = 0.0f;
        this.f17895z = 0.0f;
        this.A = 0.0f;
    }
}
