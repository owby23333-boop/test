package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes2.dex */
public class z extends g {
    private final Bitmap dl;
    private final Rect g = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f561a = new Paint(1);

    public z(Bitmap bitmap, g gVar) {
        this.dl = bitmap;
        if (gVar != null) {
            this.z = gVar.z;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iHeight = rect.height();
        int iWidth = rect.width();
        int width = this.dl.getWidth();
        int height = this.dl.getHeight();
        this.g.set(0, 0, width, height);
        if (height >= iHeight && width >= iWidth) {
            if (width > iWidth) {
                this.g.left = (width - iWidth) / 2;
                Rect rect2 = this.g;
                rect2.right = rect2.left + iWidth;
            }
            if (height > iHeight) {
                this.g.top = (height - iHeight) / 2;
                Rect rect3 = this.g;
                rect3.bottom = rect3.top + iHeight;
                return;
            }
            return;
        }
        float f = iHeight;
        float f2 = f * 1.0f;
        float f3 = height;
        float f4 = f2 / f3;
        float f5 = iWidth;
        float f6 = 1.0f * f5;
        float f7 = width;
        if (Math.max(f4, f6 / f7) > f4) {
            int i = (int) ((f2 / f5) * f7);
            this.g.top = (height - i) / 2;
            Rect rect4 = this.g;
            rect4.bottom = rect4.top + i;
            return;
        }
        int i2 = (int) ((f6 / f) * f3);
        this.g.left = (width - i2) / 2;
        Rect rect5 = this.g;
        rect5.right = rect5.left + i2;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.g
    protected void z(Canvas canvas) {
        canvas.drawBitmap(this.dl, this.g, getBounds(), this.f561a);
    }
}
