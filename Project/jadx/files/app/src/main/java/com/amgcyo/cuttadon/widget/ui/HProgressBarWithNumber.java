package com.amgcyo.cuttadon.widget.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.amgcyo.cuttadon.R$styleable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class HProgressBarWithNumber extends ProgressBar {
    protected int A;
    protected boolean B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected Paint f5675s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected int f5676t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected int f5677u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected int f5678v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected int f5679w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int f5680x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected int f5681y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected int f5682z;

    public HProgressBarWithNumber(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.HProgressBarWithNumber);
        this.f5676t = typedArrayObtainStyledAttributes.getColor(2, -261935);
        this.f5677u = (int) typedArrayObtainStyledAttributes.getDimension(4, this.f5677u);
        this.f5680x = typedArrayObtainStyledAttributes.getColor(1, this.f5676t);
        this.f5681y = typedArrayObtainStyledAttributes.getColor(7, -2894118);
        this.f5679w = (int) typedArrayObtainStyledAttributes.getDimension(0, this.f5679w);
        this.f5682z = (int) typedArrayObtainStyledAttributes.getDimension(6, this.f5682z);
        this.f5678v = (int) typedArrayObtainStyledAttributes.getDimension(3, this.f5678v);
        if (typedArrayObtainStyledAttributes.getInt(5, 0) != 0) {
            this.B = false;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private int c(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) (getPaddingTop() + getPaddingBottom() + Math.max(Math.max(this.f5679w, this.f5682z), Math.abs(this.f5675s.descent() - this.f5675s.ascent())));
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    protected int b(int i2) {
        return (int) TypedValue.applyDimension(2, i2, getResources().getDisplayMetrics());
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft(), getHeight() / 2);
        float progress = (int) (this.A * ((getProgress() * 1.0f) / getMax()));
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        sb.append(String.format(Locale.getDefault(), "%d", Integer.valueOf((int) (((getProgress() * 1.0f) / getMax()) * 100.0f))));
        sb.append("%");
        String string = sb.toString();
        float fMeasureText = this.f5675s.measureText(string);
        float fDescent = (this.f5675s.descent() + this.f5675s.ascent()) / 2.0f;
        if (progress + fMeasureText > this.A) {
            progress = this.A - fMeasureText;
        } else {
            z2 = false;
        }
        float f2 = progress - (this.f5678v / 2);
        if (f2 > 0.0f) {
            this.f5675s.setColor(this.f5680x);
            this.f5675s.setStrokeWidth(this.f5679w);
            canvas.drawLine(0.0f, 0.0f, f2, 0.0f, this.f5675s);
        }
        if (this.B) {
            this.f5675s.setColor(this.f5676t);
            canvas.drawText(string, progress, -fDescent, this.f5675s);
        }
        if (!z2) {
            this.f5675s.setColor(this.f5681y);
            this.f5675s.setStrokeWidth(this.f5682z);
            canvas.drawLine(progress + (this.f5678v / 2) + fMeasureText, 0.0f, this.A, 0.0f, this.f5675s);
        }
        canvas.restore();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i2, int i3) {
        setMeasuredDimension(View.MeasureSpec.getSize(i2), c(i3));
        this.A = (getMeasuredWidth() - getPaddingRight()) - getPaddingLeft();
    }

    public void setmReachedBarColor(int i2) {
        this.f5680x = i2;
    }

    public void setmTextColor(int i2) {
        this.f5676t = i2;
    }

    public void setmUnReachedBarColor(int i2) {
        this.f5681y = i2;
    }

    public HProgressBarWithNumber(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5675s = new Paint();
        this.f5676t = -261935;
        this.f5677u = b(10);
        this.f5678v = a(10);
        this.f5679w = a(2);
        this.f5680x = -261935;
        this.f5681y = -2894118;
        this.f5682z = a(2);
        this.B = true;
        a(attributeSet);
        this.f5675s.setAntiAlias(true);
        this.f5675s.setTextSize(this.f5677u);
        this.f5675s.setColor(this.f5676t);
    }

    protected int a(int i2) {
        return (int) TypedValue.applyDimension(1, i2, getResources().getDisplayMetrics());
    }
}
