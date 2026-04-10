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

/* JADX INFO: loaded from: classes10.dex */
public class TTRoundRectImageView extends ImageView {
    private int bf;
    private int d;
    private Paint e;
    private Matrix tg;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    private Bitmap e(Drawable drawable2) {
        if (drawable2 == null) {
            return null;
        }
        if (drawable2 instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable2).getBitmap();
        }
        int width = drawable2.getIntrinsicWidth() <= 0 ? getWidth() : drawable2.getIntrinsicWidth();
        int height = drawable2.getIntrinsicHeight() <= 0 ? getHeight() : drawable2.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable2.setBounds(0, 0, width, height);
        drawable2.draw(canvas);
        return bitmapCreateBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable2 = getDrawable();
        if (drawable2 == null) {
            super.onDraw(canvas);
            return;
        }
        Bitmap bitmapE = e(drawable2);
        if (bitmapE == null) {
            super.onDraw(canvas);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        BitmapShader bitmapShader = new BitmapShader(bitmapE, tileMode, tileMode);
        float fMax = (bitmapE.getWidth() == getWidth() && bitmapE.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapE.getWidth(), (getHeight() * 1.0f) / bitmapE.getHeight());
        this.tg.setScale(fMax, fMax);
        bitmapShader.setLocalMatrix(this.tg);
        this.e.setShader(bitmapShader);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.bf, this.d, this.e);
    }

    public void setXRound(int i) {
        this.bf = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.d = i;
        postInvalidate();
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bf = 25;
        this.d = 25;
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setFilterBitmap(true);
        this.tg = new Matrix();
    }
}
