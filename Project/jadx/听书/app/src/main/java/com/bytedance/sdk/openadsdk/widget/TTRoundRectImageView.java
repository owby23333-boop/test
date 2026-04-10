package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class TTRoundRectImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Matrix f1494a;
    private int dl;
    private int g;
    private Paint z;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 25;
        this.dl = 25;
        Paint paint = new Paint();
        this.z = paint;
        paint.setAntiAlias(true);
        this.z.setFilterBitmap(true);
        this.f1494a = new Matrix();
    }

    public TTRoundRectImageView(Context context, int i, int i2) {
        this(context);
        this.g = i;
        this.dl = i2;
    }

    public void setXRound(int i) {
        this.g = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.dl = i;
        postInvalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmapZ = z(drawable);
            if (bitmapZ != null) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                BitmapShader bitmapShader = new BitmapShader(bitmapZ, tileMode, tileMode);
                float fMax = (bitmapZ.getWidth() == getWidth() && bitmapZ.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapZ.getWidth(), (getHeight() * 1.0f) / bitmapZ.getHeight());
                this.f1494a.setScale(fMax, fMax);
                bitmapShader.setLocalMatrix(this.f1494a);
                this.z.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.g, this.dl, this.z);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    private Bitmap z(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
