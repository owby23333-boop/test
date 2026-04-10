package com.yuewen;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* JADX INFO: loaded from: classes3.dex */
public class n80 extends ImageSpan {
    public n80(Drawable drawable2) {
        super(drawable2);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        try {
            Drawable drawable2 = getDrawable();
            canvas.save();
            canvas.translate(f, (((i5 - i3) - drawable2.getBounds().bottom) / 2) + i3);
            drawable2.draw(canvas);
            canvas.restore();
        } catch (Exception unused) {
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        try {
            Rect bounds = getDrawable().getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                int i4 = bounds.bottom - bounds.top;
                int i5 = (i4 / 2) - (i3 / 4);
                int i6 = -((i4 / 2) + (i3 / 4));
                fontMetricsInt.ascent = i6;
                fontMetricsInt.top = i6;
                fontMetricsInt.bottom = i5;
                fontMetricsInt.descent = i5;
            }
            return bounds.right;
        } catch (Exception unused) {
            return 20;
        }
    }
}
