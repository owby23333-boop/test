package com.tencent.smtt.sdk.ui.dialog.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public class c extends Drawable {
    private float a;
    private float b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f19157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f19158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Path f19159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f19160f = new Paint();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RectF f19161g;

    public c(int i2, float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.b = f3;
        this.f19158d = f4;
        this.f19157c = f5;
        this.f19160f.setStyle(Paint.Style.FILL);
        this.f19160f.setAntiAlias(true);
        this.f19160f.setColor(i2);
        this.f19161g = new RectF();
    }

    public void a(int i2, int i3) {
        RectF rectF = this.f19161g;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = i2;
        rectF.bottom = i3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f19159e == null) {
            this.f19159e = new Path();
        }
        this.f19159e.reset();
        Path path = this.f19159e;
        RectF rectF = this.f19161g;
        float f2 = this.a;
        float f3 = this.b;
        float f4 = this.f19158d;
        float f5 = this.f19157c;
        path.addRoundRect(rectF, new float[]{f2, f2, f3, f3, f4, f4, f5, f5}, Path.Direction.CCW);
        this.f19159e.close();
        canvas.drawPath(this.f19159e, this.f19160f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f19160f.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f19160f.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
