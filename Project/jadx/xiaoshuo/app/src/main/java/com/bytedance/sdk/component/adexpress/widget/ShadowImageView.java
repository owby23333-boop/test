package com.bytedance.sdk.component.adexpress.widget;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AppCompatCustomView"})
public class ShadowImageView extends ImageView {
    private RectF bf;
    private Paint e;

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.bf;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, rectF.bottom / 2.0f, this.e);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.bf.right == getMeasuredWidth() && this.bf.bottom == getMeasuredHeight()) {
            return;
        }
        this.bf.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }
}
