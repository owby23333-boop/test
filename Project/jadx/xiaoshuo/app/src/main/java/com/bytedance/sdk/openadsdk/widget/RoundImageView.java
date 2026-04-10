package com.bytedance.sdk.openadsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes10.dex */
@SuppressLint({"AppCompatCustomView"})
public class RoundImageView extends ImageView {
    private int bf;
    private int d;
    private int e;

    public RoundImageView(Context context) {
        super(context);
        this.e = 0;
        this.bf = 0;
        this.d = 0;
    }

    private Bitmap e(Bitmap bitmap, int i) {
        int i2 = i * 2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = height > width ? Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width) : height < width ? Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height) : null;
        if (bitmapCreateBitmap != null) {
            bitmap = bitmapCreateBitmap;
        }
        if (bitmap.getWidth() != i2 || bitmap.getHeight() != i2) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i2, i2, true);
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap2;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmapCopy;
        Bitmap bitmapE;
        Drawable drawable2 = getDrawable();
        if (drawable2 == null || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        measure(0, 0);
        if (drawable2.getClass() == NinePatchDrawable.class || (bitmap = ((BitmapDrawable) drawable2).getBitmap()) == null) {
            return;
        }
        try {
            bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        } catch (Throwable unused) {
            bitmapCopy = null;
        }
        if (bitmapCopy == null) {
            super.onDraw(canvas);
            return;
        }
        if (this.e == 0) {
            this.e = getWidth();
        }
        if (this.bf == 0) {
            this.bf = getHeight();
        }
        int i = this.e;
        int i2 = this.bf;
        if (i >= i2) {
            i = i2;
        }
        try {
            bitmapE = e(bitmapCopy, i / 2);
        } catch (Throwable unused2) {
            bitmapE = null;
        }
        if (bitmapE == null) {
            super.onDraw(canvas);
        } else {
            canvas.drawBitmap(bitmapE, (this.e / 2) - r2, (this.bf / 2) - r2, (Paint) null);
        }
    }

    public RoundImageView(Context context, int i, int i2, int i3) {
        super(context);
        this.d = i;
        this.e = i2;
        this.bf = i3;
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
        this.bf = 0;
        this.d = 0;
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0;
        this.bf = 0;
        this.d = 0;
    }
}
