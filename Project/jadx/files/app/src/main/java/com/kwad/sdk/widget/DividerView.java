package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public class DividerView extends View {
    public static int ORIENTATION_HORIZONTAL = 0;
    public static int ORIENTATION_VERTICAL = 1;
    private int aBF;
    private Paint mPaint;
    private int orientation;

    public DividerView(Context context) {
        this(context, null);
    }

    public DividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ksad_DividerView, 0, 0);
        try {
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DividerView_ksad_dashGap, 5);
            int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DividerView_ksad_dashLength, 5);
            int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DividerView_ksad_dashThickness, 3);
            this.aBF = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DividerView_ksad_color, -16777216);
            this.orientation = typedArrayObtainStyledAttributes.getInt(R.styleable.ksad_DividerView_ksad_orientation, ORIENTATION_HORIZONTAL);
            typedArrayObtainStyledAttributes.recycle();
            this.mPaint = new Paint();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(this.aBF);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(dimensionPixelSize3);
            this.mPaint.setPathEffect(new DashPathEffect(new float[]{dimensionPixelSize2, dimensionPixelSize}, 0.0f));
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float width;
        float f2;
        float height;
        Paint paint;
        Canvas canvas2;
        float f3;
        if (this.orientation == ORIENTATION_HORIZONTAL) {
            height = getHeight() * 0.5f;
            f3 = 0.0f;
            width = getWidth();
            paint = this.mPaint;
            canvas2 = canvas;
            f2 = height;
        } else {
            width = getWidth() * 0.5f;
            f2 = 0.0f;
            height = getHeight();
            paint = this.mPaint;
            canvas2 = canvas;
            f3 = width;
        }
        canvas2.drawLine(f3, f2, width, height, paint);
    }

    public void setDividerColor(int i2) {
        this.aBF = i2;
        this.mPaint.setColor(this.aBF);
        postInvalidate();
    }
}
