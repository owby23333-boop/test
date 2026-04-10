package com.yuewen;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes12.dex */
public abstract class ni extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f14861a;

    public ni(int i) {
        Paint paint = new Paint();
        this.f14861a = paint;
        paint.setColor(i);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    public Paint a() {
        return this.f14861a;
    }

    public void b(int i) {
        this.f14861a.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f14861a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f14861a.setColorFilter(colorFilter);
    }
}
