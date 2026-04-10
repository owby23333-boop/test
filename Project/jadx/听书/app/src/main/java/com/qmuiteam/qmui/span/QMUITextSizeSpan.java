package com.qmuiteam.qmui.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes4.dex */
public class QMUITextSizeSpan extends ReplacementSpan {
    private Paint mPaint;
    private int mTextSize;
    private Typeface mTypeface;
    private int mVerticalOffset;

    public QMUITextSizeSpan(int i, int i2) {
        this(i, i2, null);
    }

    public QMUITextSizeSpan(int i, int i2, Typeface typeface) {
        this.mTextSize = i;
        this.mVerticalOffset = i2;
        this.mTypeface = typeface;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setTextSize(this.mTextSize);
        this.mPaint.setTypeface(this.mTypeface);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.mTextSize > paint.getTextSize() && fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = this.mPaint.getFontMetricsInt();
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return (int) this.mPaint.measureText(charSequence, i, i2);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        this.mPaint.setColor(paint.getColor());
        this.mPaint.setStyle(paint.getStyle());
        this.mPaint.setAntiAlias(paint.isAntiAlias());
        canvas.drawText(charSequence, i, i2, f, i4 + this.mVerticalOffset, this.mPaint);
    }
}
