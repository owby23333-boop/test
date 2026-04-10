package com.qmuiteam.qmui.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIMarginImageSpan extends QMUIAlignMiddleImageSpan {
    private int mOffsetY;
    private int mSpanMarginLeft;
    private int mSpanMarginRight;

    public QMUIMarginImageSpan(Drawable drawable, int i, int i2, int i3) {
        this(drawable, i, i2, i3, 0);
    }

    public QMUIMarginImageSpan(Drawable drawable, int i, int i2, int i3, int i4) {
        super(drawable, i);
        this.mSpanMarginLeft = i2;
        this.mSpanMarginRight = i3;
        this.mOffsetY = i4;
    }

    @Override // com.qmuiteam.qmui.span.QMUIAlignMiddleImageSpan, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.mSpanMarginLeft != 0 || this.mSpanMarginRight != 0) {
            super.getSize(paint, charSequence, i, i2, fontMetricsInt);
            return getDrawable().getIntrinsicWidth() + this.mSpanMarginLeft + this.mSpanMarginRight;
        }
        return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
    }

    @Override // com.qmuiteam.qmui.span.QMUIAlignMiddleImageSpan, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, this.mOffsetY);
        super.draw(canvas, charSequence, i, i2, f + this.mSpanMarginLeft, i3, i4, i5, paint);
        canvas.restore();
    }
}
