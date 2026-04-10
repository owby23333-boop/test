package com.yuewen;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public class yz extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20653b;

    public yz(int i, int i2) {
        this.f20652a = i;
        this.f20653b = i2;
    }

    public final TextPaint a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setColor(this.f20652a);
        textPaint.setTextSize(this.f20653b);
        return textPaint;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        CharSequence charSequenceSubSequence = charSequence.subSequence(i, i2);
        TextPaint textPaintA = a(paint);
        Paint.FontMetricsInt fontMetricsInt = textPaintA.getFontMetricsInt();
        canvas.drawText(charSequenceSubSequence.toString(), f, i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2)), textPaintA);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) a(paint).measureText(charSequence, i, i2);
    }
}
