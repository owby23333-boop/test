package com.mardous.discreteseekbar.a.d;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: StateDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends Drawable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ColorStateList f17637s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Paint f17638t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f17639u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f17640v = 255;

    public c(@NonNull ColorStateList colorStateList) {
        a(colorStateList);
        this.f17638t = new Paint(1);
    }

    private boolean a(int[] iArr) {
        int colorForState = this.f17637s.getColorForState(iArr, this.f17639u);
        if (colorForState == this.f17639u) {
            return false;
        }
        this.f17639u = colorForState;
        invalidateSelf();
        return true;
    }

    abstract void a(Canvas canvas, Paint paint);

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f17638t.setColor(this.f17639u);
        this.f17638t.setAlpha(a(Color.alpha(this.f17639u)));
        a(canvas, this.f17638t);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f17640v;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f17637s.isStateful() || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f17640v = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f17638t.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || super.setState(iArr);
    }

    public void a(@NonNull ColorStateList colorStateList) {
        this.f17637s = colorStateList;
        this.f17639u = colorStateList.getDefaultColor();
    }

    int a(int i2) {
        int i3 = this.f17640v;
        return (i2 * (i3 + (i3 >> 7))) >> 8;
    }
}
