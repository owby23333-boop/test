package com.bytedance.sdk.openadsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes10.dex */
@SuppressLint({"AppCompatCustomView"})
public class ShadowImageView extends ImageView {
    private RectF bf;
    private Paint e;

    public ShadowImageView(Context context) {
        super(context);
        e();
    }

    private void e() {
        Paint paint = new Paint();
        this.e = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.e.setColor(Color.parseColor("#99333333"));
        this.e.setAntiAlias(true);
        this.e.setStrokeWidth(0.0f);
        this.bf = new RectF();
    }

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

    public ShadowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public ShadowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e();
    }
}
