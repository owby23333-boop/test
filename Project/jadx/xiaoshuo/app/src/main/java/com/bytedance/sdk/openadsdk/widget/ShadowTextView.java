package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes10.dex */
public class ShadowTextView extends TextView {
    private RectF bf;
    private int d;
    private Paint e;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    private void e() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.e = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.e.setColor(Color.parseColor("#99333333"));
        this.e.setAntiAlias(true);
        this.e.setStrokeWidth(0.0f);
        this.bf = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.bf;
        float f = rectF.bottom;
        canvas.drawRoundRect(rectF, f / 2.0f, f / 2.0f, this.e);
        canvas.translate((this.bf.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            this.bf.set(0.0f, 0.0f, 0.0f, 0.0f);
            return;
        }
        int iMeasureText = (int) getPaint().measureText("00");
        this.d = iMeasureText;
        if (measuredWidth < iMeasureText) {
            measuredWidth = iMeasureText;
        }
        int i3 = measuredWidth + ((measuredHeight / 2) * 2);
        setMeasuredDimension(i3, measuredHeight);
        this.bf.set(0.0f, 0.0f, i3, measuredHeight);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        e();
    }
}
