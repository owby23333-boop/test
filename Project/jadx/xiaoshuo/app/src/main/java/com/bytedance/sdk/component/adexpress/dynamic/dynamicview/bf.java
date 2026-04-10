package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.component.sdk.annotation.ColorInt;

/* JADX INFO: loaded from: classes.dex */
public class bf extends GradientDrawable {
    private final Paint bf;
    protected Path e;

    public bf() {
        this.e = new Path();
        Paint paint = new Paint(1);
        this.bf = paint;
        paint.setColor(-1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.e;
        if (path == null || path.isEmpty()) {
            e(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.bf, 31);
        e(canvas);
        this.bf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.e, this.bf);
        this.bf.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    public void e(Canvas canvas) {
        super.draw(canvas);
    }

    public void update(int i, int i2, int i3, int i4) {
        this.e.addRect(i, i2, i3, i4, Path.Direction.CW);
        invalidateSelf();
    }

    public bf(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        super(orientation, iArr);
        this.e = new Path();
        Paint paint = new Paint(1);
        this.bf = paint;
        paint.setColor(-1);
    }
}
