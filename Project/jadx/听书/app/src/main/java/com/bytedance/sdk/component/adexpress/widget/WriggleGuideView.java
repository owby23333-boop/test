package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class WriggleGuideView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f613a;
    private Bitmap dl;
    private boolean e;
    private z fo;
    private int g;
    private Paint gc;
    private boolean gz;
    private int m;
    private int z;

    public interface z {
    }

    private Bitmap z(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getContext().getResources(), tb.gc(getContext(), "tt_wriggle_union"));
        if (bitmapDecodeResource != null) {
            canvas.drawBitmap(bitmapDecodeResource, (Rect) null, new RectF(0.0f, 0.0f, i, i2), this.gc);
        }
        return bitmapCreateBitmap;
    }

    private Bitmap g(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getContext().getResources(), tb.gc(getContext(), "tt_wriggle_union_white"));
        if (bitmapDecodeResource != null) {
            canvas.drawBitmap(bitmapDecodeResource, (Rect) null, new RectF(0.0f, 0.0f, i, i2), paint);
        }
        return bitmapCreateBitmap;
    }

    private Bitmap dl(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(i / 2, 10.0f, this.m, paint);
        return bitmapCreateBitmap;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.e) {
            this.z = getWidth();
            int height = getHeight();
            this.g = height;
            this.dl = z(this.z, height);
            this.f613a = g(this.z, this.g);
            this.e = false;
        }
        Bitmap bitmap = this.dl;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.gc);
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        Bitmap bitmap2 = this.f613a;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, this.gc);
        }
        this.gc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(dl(this.z, this.g), 0.0f, 0.0f, this.gc);
        this.gc.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
        if (this.gz) {
            this.m += 5;
            invalidate();
            if (this.m >= this.z) {
                this.gz = false;
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fo != null) {
            this.fo = null;
        }
    }
}
