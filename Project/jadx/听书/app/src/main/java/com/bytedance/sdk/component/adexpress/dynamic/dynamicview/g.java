package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class g extends GradientDrawable {
    private final Paint g;
    protected Path z;

    public g() {
        this.z = new Path();
        Paint paint = new Paint(1);
        this.g = paint;
        paint.setColor(-1);
    }

    public g(GradientDrawable.Orientation orientation, int[] iArr) {
        super(orientation, iArr);
        this.z = new Path();
        Paint paint = new Paint(1);
        this.g = paint;
        paint.setColor(-1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.z;
        if (path == null || path.isEmpty()) {
            z(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.g, 31);
        z(canvas);
        this.g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.z, this.g);
        this.g.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    protected void z(Canvas canvas) {
        super.draw(canvas);
    }

    public void update(int i, int i2, int i3, int i4) {
        this.z.addRect(i, i2, i3, i4, Path.Direction.CW);
        invalidateSelf();
    }
}
