package com.yuewen;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes5.dex */
public class y93 extends ReplacementSpan {
    public static final int d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20256b;
    public final int c;

    public y93(int i, int i2) {
        this(i, i2, 8);
    }

    public final float a(Paint paint, CharSequence charSequence, int i, int i2) {
        return paint.measureText(charSequence, i, i2);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        RectF rectF = new RectF(f, i3, a(paint, charSequence, i, i2) + f, fontMetrics.bottom - fontMetrics.top);
        paint.setColor(this.f20255a);
        int i6 = this.c;
        canvas.drawRoundRect(rectF, i6, i6, paint);
        paint.setColor(this.f20256b);
        canvas.drawText(charSequence, i, i2, f, i4, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return Math.round(paint.measureText(charSequence, i, i2));
    }

    public y93(int i, int i2, int i3) {
        this.f20255a = i;
        this.f20256b = i2;
        this.c = i3;
    }
}
