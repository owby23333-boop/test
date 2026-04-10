package com.amgcyo.cuttadon.view.comment;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: CommentRoundBgColorSpan.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends ReplacementSpan {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4626s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4627t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4628u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4629v;

    public b(int i2, int i3, int i4) {
        this.f4627t = i2;
        this.f4628u = i3;
        this.f4626s = i4;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        int color = paint.getColor();
        float strokeWidth = paint.getStrokeWidth();
        paint.setColor(this.f4627t);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        paint.setAntiAlias(true);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        paint.setColor(this.f4628u);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(strokeWidth);
        canvas.drawText(charSequence, i2, i3, f2, i5 - ((((i5 + fontMetricsInt.descent) + i5) + fontMetricsInt.ascent) - (i6 + i4)), paint);
        paint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        this.f4629v = (int) (paint.measureText(charSequence, i2, i3) + (this.f4626s * 2));
        return this.f4629v + 5;
    }
}
