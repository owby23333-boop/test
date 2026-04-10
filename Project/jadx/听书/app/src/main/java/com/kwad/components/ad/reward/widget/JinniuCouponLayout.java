package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public class JinniuCouponLayout extends LinearLayout {
    private float DA;
    private Rect DB;
    private RectF DC;
    private RectF DD;
    private RectF DE;
    private RectF DF;
    private Path DG;
    private int endColor;
    private Paint mPaint;
    private float mRadius;
    private int startColor;

    public JinniuCouponLayout(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.DA = 4.0f;
        this.mRadius = 10.0f;
        this.DB = new Rect();
        this.DC = new RectF();
        this.DD = new RectF();
        this.DE = new RectF();
        this.DF = new RectF();
        this.DG = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, null, 0);
    }

    public JinniuCouponLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.DA = 4.0f;
        this.mRadius = 10.0f;
        this.DB = new Rect();
        this.DC = new RectF();
        this.DD = new RectF();
        this.DE = new RectF();
        this.DF = new RectF();
        this.DG = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, 0);
    }

    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.DA = 4.0f;
        this.mRadius = 10.0f;
        this.DB = new Rect();
        this.DC = new RectF();
        this.DD = new RectF();
        this.DE = new RectF();
        this.DF = new RectF();
        this.DG = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i);
    }

    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPaint = new Paint();
        this.DA = 4.0f;
        this.mRadius = 10.0f;
        this.DB = new Rect();
        this.DC = new RectF();
        this.DD = new RectF();
        this.DE = new RectF();
        this.DF = new RectF();
        this.DG = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_JinniuCouponLayout, i, 0);
        this.mRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_outerRadius, 4.0f);
        this.DA = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_verticalRadius, 10.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.DB.setEmpty();
        getDrawingRect(this.DB);
        this.DC.set(this.DB);
        if (getChildCount() > 1) {
            View childAt = getChildAt(0);
            RectF rectF = this.DD;
            if (rectF == null) {
                this.DD = new RectF();
            } else {
                rectF.setEmpty();
            }
            RectF rectF2 = this.DE;
            if (rectF2 == null) {
                this.DE = new RectF();
            } else {
                rectF2.setEmpty();
            }
            float measuredWidth = this.DB.left + childAt.getMeasuredWidth();
            RectF rectF3 = this.DD;
            float f = this.DB.top;
            float f2 = this.DA;
            rectF3.set(measuredWidth, f - f2, (f2 * 2.0f) + measuredWidth, this.DB.top + this.DA);
            this.DE.set(this.DD.left, this.DB.bottom - this.DA, this.DD.right, this.DB.bottom + this.DA);
            a(this.DG, this.DC, this.DD, this.DE);
            setGradientPaint(this.DC);
            canvas.drawPath(this.DG, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    private void setGradientPaint(RectF rectF) {
        this.mPaint.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, this.startColor, this.endColor, Shader.TileMode.CLAMP));
    }

    private void a(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(this.DC.left, this.DC.top + this.mRadius);
        this.DF.set(rectF);
        RectF rectF4 = this.DF;
        rectF4.bottom = rectF4.top + (this.mRadius * 2.0f);
        RectF rectF5 = this.DF;
        rectF5.right = rectF5.left + (this.mRadius * 2.0f);
        path.arcTo(this.DF, 180.0f, 90.0f);
        path.lineTo(rectF2.left, rectF2.top);
        path.arcTo(rectF2, -180.0f, -180.0f);
        path.lineTo(rectF.width() - this.mRadius, rectF.top);
        this.DF.set(rectF);
        RectF rectF6 = this.DF;
        rectF6.left = rectF6.right - (this.mRadius * 2.0f);
        RectF rectF7 = this.DF;
        rectF7.bottom = rectF7.top + (this.mRadius * 2.0f);
        path.arcTo(this.DF, 270.0f, 90.0f);
        this.DF.set(rectF);
        RectF rectF8 = this.DF;
        rectF8.left = rectF8.right - (this.mRadius * 2.0f);
        RectF rectF9 = this.DF;
        rectF9.top = rectF9.bottom - (this.mRadius * 2.0f);
        path.arcTo(this.DF, 0.0f, 90.0f);
        path.lineTo(rectF3.right, rectF3.bottom);
        path.arcTo(rectF3, 0.0f, -180.0f);
        path.lineTo(rectF.left + this.mRadius, rectF.bottom);
        this.DF.set(rectF);
        RectF rectF10 = this.DF;
        rectF10.right = rectF10.left + (this.mRadius * 2.0f);
        RectF rectF11 = this.DF;
        rectF11.top = rectF11.bottom - (this.mRadius * 2.0f);
        path.arcTo(this.DF, 90.0f, 90.0f);
    }
}
