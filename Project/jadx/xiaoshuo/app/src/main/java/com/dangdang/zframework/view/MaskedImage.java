package com.dangdang.zframework.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes10.dex */
public abstract class MaskedImage extends DDImageView {
    private static final Xfermode MASK_XFERMODE = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private Bitmap mask;
    private Paint paint;

    public MaskedImage(Context context) {
        super(context);
    }

    public abstract Bitmap createMask();

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            Drawable drawable2 = getDrawable();
            if (drawable2 == null) {
                return;
            }
            if (this.paint == null) {
                Paint paint = new Paint();
                this.paint = paint;
                paint.setFilterBitmap(false);
                this.paint.setXfermode(MASK_XFERMODE);
            }
            int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            drawable2.setBounds(0, 0, getWidth(), getHeight());
            drawable2.draw(canvas);
            Bitmap bitmap = this.mask;
            if (bitmap == null || bitmap.isRecycled()) {
                this.mask = createMask();
            }
            canvas.drawBitmap(this.mask, 0.0f, 0.0f, this.paint);
            canvas.restoreToCount(iSaveLayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MaskedImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaskedImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
