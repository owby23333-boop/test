package com.amgcyo.cuttadon.widget.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.amgcyo.cuttadon.R$styleable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class RoundProgressWidthNumber extends HProgressBarWithNumber {
    private int C;
    private int D;
    private RectF E;

    public RoundProgressWidthNumber(Context context) {
        this(context, null);
    }

    @Override // com.amgcyo.cuttadon.widget.ui.HProgressBarWithNumber, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        String str = String.format(Locale.getDefault(), "%d", Integer.valueOf((int) (((getProgress() * 1.0f) / getMax()) * 100.0f))) + "%";
        float fMeasureText = this.f5675s.measureText(str);
        float fDescent = (this.f5675s.descent() + this.f5675s.ascent()) / 2.0f;
        canvas.save();
        canvas.translate(getPaddingLeft() + (this.D / 2), getPaddingTop() + (this.D / 2));
        this.f5675s.setStyle(Paint.Style.STROKE);
        this.f5675s.setColor(this.f5681y);
        this.f5675s.setStrokeWidth(this.f5682z);
        canvas.drawCircle(this.C, this.C, this.C, this.f5675s);
        this.f5675s.setColor(this.f5680x);
        this.f5675s.setStrokeWidth(this.f5679w);
        this.E.set(0.0f, 0.0f, this.C * 2, this.C * 2);
        canvas.drawArc(this.E, 0.0f, ((getProgress() * 1.0f) / getMax()) * 360.0f, false, this.f5675s);
        this.f5675s.setStyle(Paint.Style.FILL);
        canvas.drawText(str, this.C - (fMeasureText / 2.0f), this.C - fDescent, this.f5675s);
        canvas.restore();
    }

    @Override // com.amgcyo.cuttadon.widget.ui.HProgressBarWithNumber, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i2, int i3) {
        this.D = Math.max(this.f5679w, this.f5682z);
        int paddingLeft = (this.C * 2) + this.D + getPaddingLeft() + getPaddingRight();
        int iMin = Math.min(ProgressBar.resolveSize(paddingLeft, i2), ProgressBar.resolveSize(paddingLeft, i3));
        this.C = (((iMin - getPaddingLeft()) - getPaddingRight()) - this.D) / 2;
        setMeasuredDimension(iMin, iMin);
    }

    public RoundProgressWidthNumber(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = a(30);
        this.f5679w = (int) (this.f5682z * 2.5f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundProgressWidthNumber);
        this.C = (int) typedArrayObtainStyledAttributes.getDimension(0, this.C);
        typedArrayObtainStyledAttributes.recycle();
        this.f5675s.setStyle(Paint.Style.STROKE);
        this.f5675s.setAntiAlias(true);
        this.f5675s.setDither(true);
        this.f5675s.setStrokeCap(Paint.Cap.ROUND);
        this.E = new RectF();
    }
}
