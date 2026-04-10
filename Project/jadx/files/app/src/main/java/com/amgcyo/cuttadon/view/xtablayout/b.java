package com.amgcyo.cuttadon.view.xtablayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: DividerDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends Drawable {
    private RectF b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5632e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5630c = -16777216;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5631d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5633f = 1;
    private Paint a = new Paint();

    public b(Context context) {
        this.f5632e = a(context, 2.0f);
        this.a.setColor(this.f5630c);
        this.a.setAntiAlias(true);
    }

    public void a(int i2) {
        this.a.setColor(i2);
    }

    public void b(int i2) {
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("Gravity must be one of 0(DividerDrawable.TOP)、1(DividerDrawable.CENTER) and 2(DividerDrawable.BOTTOM)");
        }
        this.f5633f = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.drawColor(0);
        int i2 = this.f5631d;
        if (i2 != 0) {
            float f2 = i2;
            RectF rectF = this.b;
            float f3 = rectF.bottom;
            if (f2 < f3) {
                int i3 = (int) ((f3 - i2) / 2.0f);
                int i4 = this.f5633f;
                if (i4 == 0) {
                    canvas.drawRect(rectF.left, rectF.top, rectF.right, f3 - (i3 * 2), this.a);
                    return;
                }
                if (i4 == 1) {
                    float f4 = i3;
                    canvas.drawRect(rectF.left, rectF.top + f4, rectF.right, f3 - f4, this.a);
                    return;
                } else {
                    if (i4 != 2) {
                        return;
                    }
                    canvas.drawRect(rectF.left, rectF.top + (i3 * 2), rectF.right, f3, this.a);
                    return;
                }
            }
        }
        canvas.drawRect(this.b, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f5632e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        this.b = new RectF(i2, i3, i4, i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    public void a(int i2, int i3) {
        this.f5632e = i2;
        this.f5631d = i3;
        invalidateSelf();
    }

    private int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
