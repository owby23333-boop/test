package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowTextView extends TextView {
    private int dl;
    private RectF g;
    private Paint z;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dl = 0;
        z();
    }

    private void z() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.z = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.z.setColor(Color.parseColor("#99333333"));
        this.z.setAntiAlias(true);
        this.z.setStrokeWidth(0.0f);
        this.g = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            int iMeasureText = (int) getPaint().measureText("00");
            this.dl = iMeasureText;
            if (measuredWidth < iMeasureText) {
                measuredWidth = iMeasureText;
            }
            int i3 = measuredWidth + ((measuredHeight / 2) * 2);
            setMeasuredDimension(i3, measuredHeight);
            this.g.set(0.0f, 0.0f, i3, measuredHeight);
            return;
        }
        this.g.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.g;
        canvas.drawRoundRect(rectF, rectF.bottom / 2.0f, this.g.bottom / 2.0f, this.z);
        canvas.translate((this.g.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }
}
