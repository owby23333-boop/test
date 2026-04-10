package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.amgcyo.cuttadon.R$styleable;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class PercentageRing extends View {
    private int A;
    private int B;
    private float C;
    private int D;
    private Paint E;
    private int F;
    private int G;
    private float H;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Paint f5017s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Paint f5018t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private RectF f5019u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f5020v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Paint f5021w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f5022x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f5023y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f5024z;

    public PercentageRing(Context context) {
        this(context, null);
        a();
    }

    private void a() {
        this.A = 25;
        this.C = -90.0f;
        this.f5024z = 1.0f;
        this.f5021w = new Paint();
        this.f5021w.setAntiAlias(true);
        this.f5021w.setColor(this.f5020v);
        this.f5021w.setStyle(Paint.Style.STROKE);
        Paint paint = this.f5021w;
        double d2 = this.A;
        Double.isNaN(d2);
        paint.setStrokeWidth((float) (d2 * 0.18d));
        this.E = new Paint();
        this.E.setColor(this.D);
        this.E.setAntiAlias(true);
        this.E.setStyle(Paint.Style.FILL);
        Paint paint2 = this.E;
        double d3 = this.A;
        Double.isNaN(d3);
        paint2.setStrokeWidth((float) (d3 * 0.025d));
        this.E.setTextSize(this.A / 2);
        this.E.setTextAlign(Paint.Align.CENTER);
        this.f5017s = new Paint();
        this.f5017s.setAntiAlias(true);
        this.f5017s.setColor(this.B);
        this.f5017s.setStyle(Paint.Style.STROKE);
        Paint paint3 = this.f5017s;
        double d4 = this.A;
        Double.isNaN(d4);
        paint3.setStrokeWidth((float) (d4 * 0.18d));
        this.f5018t = new Paint();
        this.f5018t.setAntiAlias(true);
        this.f5018t.setColor(getResources().getColor(R.color.anythink_reward_kiloo_background));
        this.f5018t.setStyle(Paint.Style.FILL);
        Paint paint4 = this.f5018t;
        double d5 = this.A;
        Double.isNaN(d5);
        paint4.setStrokeWidth((float) (d5 * 0.15d));
        this.E.getTextSize();
    }

    private void b() {
        if (this.G >= this.F) {
            this.f5024z = 360.0f;
        } else {
            this.f5024z = (r0 * 360) / r1;
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f5019u, this.C, 360.0f, false, this.f5021w);
        canvas.drawArc(this.f5019u, this.C, this.f5024z, false, this.f5017s);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(a(i2), a(i2));
        this.f5022x = getMeasuredWidth() / 2;
        this.f5023y = getMeasuredHeight() / 2;
        this.A = this.f5022x;
        Paint paint = this.E;
        double d2 = this.A;
        Double.isNaN(d2);
        paint.setStrokeWidth((float) (d2 * 0.025d));
        this.E.setTextSize(this.A / 2);
        this.H = this.A * 0.3f;
        this.f5018t.setStrokeWidth(this.H);
        this.E.getTextSize();
        int i4 = this.f5022x;
        int i5 = this.A;
        float f2 = this.H;
        int i6 = this.f5023y;
        this.f5019u = new RectF((i4 - i5) + (f2 / 2.0f), (i6 - i5) + (f2 / 2.0f), (i4 + i5) - (f2 / 2.0f), (i6 + i5) - (f2 / 2.0f));
    }

    public void setMax(int i2) {
        this.F = i2;
        b();
    }

    public void setProgress(int i2) {
        this.G = i2;
        b();
    }

    public void setTargetPercent(int i2) {
        invalidate();
    }

    public PercentageRing(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public PercentageRing(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PercentageRing);
        this.f5020v = typedArrayObtainStyledAttributes.getColor(0, -5262117);
        this.B = typedArrayObtainStyledAttributes.getColor(2, -9875295);
        this.D = typedArrayObtainStyledAttributes.getColor(3, -1);
        typedArrayObtainStyledAttributes.recycle();
        a();
    }

    private int a(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        double d2 = this.A;
        Double.isNaN(d2);
        int i3 = (int) (d2 * 1.075d * 2.0d);
        return mode == Integer.MIN_VALUE ? Math.min(i3, size) : i3;
    }

    public void a(int i2, int i3) {
        this.f5021w.setColor(i2);
        this.f5017s.setColor(i3);
        invalidate();
    }
}
