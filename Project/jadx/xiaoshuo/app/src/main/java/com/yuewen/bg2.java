package com.yuewen;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes12.dex */
public abstract class bg2 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9067b;
    public Paint c;

    public bg2(int i) {
        this(i, i);
    }

    public Paint a() {
        return this.c;
    }

    public abstract Path b();

    public void c(int i) {
        this.c.setColor(i);
        this.f9066a = i;
        invalidateSelf();
    }

    public void d(boolean z) {
        this.c.setColor(z ? this.f9066a : this.f9067b);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Path pathB = b();
        canvas.save();
        canvas.translate(getBounds().left, getBounds().top);
        if (pathB != null) {
            canvas.drawPath(pathB, this.c);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.c.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
    }

    public bg2(int i, int i2) {
        this.f9066a = i;
        this.f9067b = i2;
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(i);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setAntiAlias(true);
    }
}
