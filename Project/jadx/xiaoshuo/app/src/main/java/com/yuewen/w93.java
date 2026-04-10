package com.yuewen;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class w93 extends InsetDrawable {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 4;
    public static final int i = 8;
    public static final int j = 15;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f19406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f19407b;
    public final float[] c;
    public final int d;

    public w93(Drawable drawable2, float f2) {
        this(drawable2, f2, 15);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iSaveLayerAlpha = canvas.saveLayerAlpha(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), 255, 31);
        super.draw(canvas);
        Path path = this.f19407b;
        if (path != null) {
            canvas.drawPath(path, this.f19406a);
        }
        canvas.restoreToCount(iSaveLayerAlpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        this.f19407b.addRoundRect(new RectF(0.0f, 0.0f, i4 - i2, i5 - i3), this.c, Path.Direction.CW);
    }

    public w93(Drawable drawable2, float f2, int i2) {
        super(drawable2, 0);
        float[] fArr = new float[8];
        this.c = fArr;
        Paint paint = new Paint();
        this.f19406a = paint;
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Path path = new Path();
        this.f19407b = path;
        path.setFillType(Path.FillType.INVERSE_WINDING);
        this.d = i2;
        Arrays.fill(fArr, 0.0f);
        if ((i2 & 15) == 15) {
            Arrays.fill(fArr, f2);
            return;
        }
        if ((i2 & 1) == 1) {
            Arrays.fill(fArr, 0, 2, f2);
        }
        if ((i2 & 2) == 2) {
            Arrays.fill(fArr, 2, 4, f2);
        }
        if ((i2 & 8) == 8) {
            Arrays.fill(fArr, 4, 6, f2);
        }
        if ((i2 & 4) == 4) {
            Arrays.fill(fArr, 6, 8, f2);
        }
    }
}
