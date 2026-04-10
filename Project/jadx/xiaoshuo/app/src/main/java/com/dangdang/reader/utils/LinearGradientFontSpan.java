package com.dangdang.reader.utils;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes10.dex */
public class LinearGradientFontSpan extends ReplacementSpan {
    private int endColor;
    private int mSize;
    private int startColor;

    public LinearGradientFontSpan(int i, int i2) {
        this.startColor = i;
        this.endColor = i2;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, paint.descent() - paint.ascent(), this.startColor, this.endColor, Shader.TileMode.REPEAT));
        canvas.drawText(charSequence, i, i2, f, i4, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        this.mSize = (int) paint.measureText(charSequence, i, i2);
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        if (fontMetricsInt != null) {
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return this.mSize;
    }
}
