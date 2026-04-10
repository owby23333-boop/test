package com.amgcyo.cuttadon.utils.otherutils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: CenterImageSpan.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends ImageSpan {
    public i(Drawable drawable) {
        super(drawable);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        Drawable drawable = getDrawable();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i7 = ((((fontMetricsInt.descent + i5) + i5) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2);
        canvas.save();
        canvas.translate(f2, i7);
        drawable.draw(canvas);
        canvas.restore();
    }
}
