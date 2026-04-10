package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowImageView extends ImageView {
    private RectF g;
    private Paint z;

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.g.right == getMeasuredWidth() && this.g.bottom == getMeasuredHeight()) {
            return;
        }
        this.g.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.g;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.g.bottom / 2.0f, this.z);
        super.onDraw(canvas);
    }
}
