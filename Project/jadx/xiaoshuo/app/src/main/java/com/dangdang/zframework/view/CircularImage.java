package com.dangdang.zframework.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes10.dex */
public class CircularImage extends MaskedImage {
    public CircularImage(Context context) {
        super(context);
    }

    @Override // com.dangdang.zframework.view.MaskedImage
    public Bitmap createMask() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        canvas.drawOval(new RectF(0.0f, 0.0f, getWidth(), getHeight()), paint);
        return bitmapCreateBitmap;
    }

    public CircularImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
