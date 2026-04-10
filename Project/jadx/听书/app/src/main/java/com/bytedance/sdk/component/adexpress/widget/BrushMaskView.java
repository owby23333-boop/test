package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class BrushMaskView extends View {
    private static final String z = "BrushMaskView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Canvas f590a;
    private Bitmap dl;
    private Paint e;
    private Paint g;
    private Paint gc;
    private Paint gz;
    private BitmapDrawable m;

    public void setEraserSize(float f) {
        this.e.setStrokeWidth(f);
        this.gz.setStrokeWidth(f);
    }

    public void setMaskColor(int i) {
        this.g.setColor(i);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(z(i), z(i2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.dl;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.gc);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        z(i, i2);
    }

    private void z(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.dl = bitmapCreateBitmap;
            Canvas canvas = this.f590a;
            if (canvas == null) {
                this.f590a = new Canvas(this.dl);
            } else {
                canvas.setBitmap(bitmapCreateBitmap);
            }
            this.f590a.drawRoundRect(new RectF(0.0f, 0.0f, i, i2), 120.0f, 120.0f, this.g);
            if (this.m != null) {
                this.m.setBounds(new Rect(0, 0, i, i2));
                this.m.draw(this.f590a);
            }
        } catch (Exception e) {
            wp.a(z, e.getMessage());
        }
    }

    private int z(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(0, size);
        }
        return 0;
    }

    public void setWatermark(int i) {
        if (i == -1) {
            this.m = null;
        } else {
            this.m = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), i));
        }
    }
}
