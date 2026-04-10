package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowImageView extends ImageView {
    private RectF g;
    private Paint z;

    public ShadowImageView(Context context) {
        super(context);
        z();
    }

    private void z() {
        Paint paint = new Paint();
        this.z = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.z.setColor(Color.parseColor("#99333333"));
        this.z.setAntiAlias(true);
        this.z.setStrokeWidth(0.0f);
        this.g = new RectF();
    }

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
