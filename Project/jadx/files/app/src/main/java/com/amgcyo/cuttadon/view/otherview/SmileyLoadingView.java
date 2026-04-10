package com.amgcyo.cuttadon.view.otherview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.amgcyo.cuttadon.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class SmileyLoadingView extends View {
    private static final int K = Color.parseColor("#b3d8f3");
    private float A;
    private float B;
    private float C;
    private int D;
    private int E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private ValueAnimator J;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Paint f5071s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Paint f5072t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Path f5073u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Path f5074v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private RectF f5075w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float[] f5076x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float[] f5077y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float[] f5078z;

    public interface a {
    }

    public SmileyLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(AttributeSet attributeSet) {
        setBackgroundColor(0);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SmileyLoadingView);
        this.D = typedArrayObtainStyledAttributes.getColor(2, K);
        this.E = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, a(5.0f));
        typedArrayObtainStyledAttributes.getInt(1, 2000);
        typedArrayObtainStyledAttributes.getInt(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        this.B = 180.0f;
        this.f5073u = new Path();
        this.f5074v = new Path();
        this.f5071s = new Paint(1);
        this.f5071s.setStyle(Paint.Style.STROKE);
        this.f5071s.setStrokeCap(Paint.Cap.ROUND);
        this.f5071s.setStrokeJoin(Paint.Join.ROUND);
        this.f5071s.setStrokeWidth(this.E);
        this.f5071s.setColor(this.D);
        this.f5072t = new Paint(1);
        this.f5072t.setStyle(Paint.Style.STROKE);
        this.f5072t.setStrokeCap(Paint.Cap.ROUND);
        this.f5072t.setStrokeJoin(Paint.Join.ROUND);
        this.f5072t.setStyle(Paint.Style.FILL);
        this.f5072t.setColor(this.D);
        this.f5076x = new float[2];
        this.f5077y = new float[2];
        this.f5078z = new float[2];
    }

    private int b(int i2) {
        int iA = a(30.0f);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return Math.min(iA, size);
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.J.end();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.F) {
            float[] fArr = this.f5077y;
            canvas.drawCircle(fArr[0], fArr[1], this.C, this.f5072t);
            float[] fArr2 = this.f5078z;
            canvas.drawCircle(fArr2[0], fArr2[1], this.C, this.f5072t);
            this.f5074v.reset();
            this.f5074v.addArc(this.f5075w, this.A, this.B);
            canvas.drawPath(this.f5074v, this.f5071s);
            return;
        }
        if (this.H) {
            float[] fArr3 = this.f5077y;
            canvas.drawCircle(fArr3[0], fArr3[1], this.C, this.f5072t);
        }
        if (this.I) {
            float[] fArr4 = this.f5078z;
            canvas.drawCircle(fArr4[0], fArr4[1], this.C, this.f5072t);
        }
        if (this.G) {
            this.f5074v.reset();
            this.f5074v.addArc(this.f5075w, this.A, this.B);
            canvas.drawPath(this.f5074v, this.f5071s);
        } else {
            this.f5074v.reset();
            this.f5074v.addArc(this.f5075w, this.A, this.B);
            canvas.drawPath(this.f5074v, this.f5071s);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(b(i2), a(i3));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int width = getWidth();
        int height = getHeight();
        float[] fArr = this.f5076x;
        int i6 = width - paddingRight;
        fArr[0] = (i6 + paddingLeft) >> 1;
        fArr[1] = ((height - paddingBottom) + paddingTop) >> 1;
        int i7 = this.E;
        float fMin = Math.min(((i6 - paddingLeft) - i7) >> 1, (((height - paddingTop) - paddingBottom) - i7) >> 1);
        int i8 = this.E;
        this.C = i8 / 2;
        this.f5075w = new RectF(paddingLeft + i8, paddingTop + i8, (width - i8) - paddingRight, (height - i8) - paddingBottom);
        this.f5074v.arcTo(this.f5075w, 0.0f, 180.0f);
        Path path = this.f5073u;
        float[] fArr2 = this.f5076x;
        path.addCircle(fArr2[0], fArr2[1], fMin, Path.Direction.CW);
        PathMeasure pathMeasure = new PathMeasure(this.f5073u, true);
        pathMeasure.getPosTan((pathMeasure.getLength() / 8.0f) * 5.0f, this.f5077y, null);
        pathMeasure.getPosTan((pathMeasure.getLength() / 8.0f) * 7.0f, this.f5078z, null);
        float[] fArr3 = this.f5077y;
        float f2 = fArr3[0];
        int i9 = this.E;
        fArr3[0] = f2 + (i9 >> 2);
        fArr3[1] = fArr3[1] + (i9 >> 1);
        float[] fArr4 = this.f5078z;
        fArr4[0] = fArr4[0] - (i9 >> 2);
        fArr4[1] = fArr4[1] + (i9 >> 1);
    }

    public void setAnimDuration(int i2) {
    }

    public void setAnimRepeatCount(int i2) {
    }

    public void setOnAnimPerformCompletedListener(a aVar) {
    }

    public void setPaintAlpha(int i2) {
        this.f5071s.setAlpha(i2);
        this.f5072t.setAlpha(i2);
        invalidate();
    }

    public void setStrokeColor(int i2) {
        this.D = i2;
        invalidate();
    }

    public void setStrokeWidth(int i2) {
        this.E = i2;
    }

    public SmileyLoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private int a(int i2) {
        int iA = a(30.0f);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return Math.min(iA, size);
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    private int a(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
