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
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public class JinniuCouponLayout extends LinearLayout {
    private float Ao;
    private Rect Ap;
    private RectF Aq;
    private RectF Ar;
    private RectF As;
    private RectF At;
    private Path Au;

    @ColorInt
    private int endColor;
    private Paint mPaint;
    private float mRadius;

    @ColorInt
    private int startColor;

    public JinniuCouponLayout(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.Ao = 4.0f;
        this.mRadius = 10.0f;
        this.Ap = new Rect();
        this.Aq = new RectF();
        this.Ar = new RectF();
        this.As = new RectF();
        this.At = new RectF();
        this.Au = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        init(context, null, 0);
    }

    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.Ao = 4.0f;
        this.mRadius = 10.0f;
        this.Ap = new Rect();
        this.Aq = new RectF();
        this.Ar = new RectF();
        this.As = new RectF();
        this.At = new RectF();
        this.Au = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        init(context, attributeSet, 0);
    }

    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPaint = new Paint();
        this.Ao = 4.0f;
        this.mRadius = 10.0f;
        this.Ap = new Rect();
        this.Aq = new RectF();
        this.Ar = new RectF();
        this.As = new RectF();
        this.At = new RectF();
        this.Au = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        init(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mPaint = new Paint();
        this.Ao = 4.0f;
        this.mRadius = 10.0f;
        this.Ap = new Rect();
        this.Aq = new RectF();
        this.Ar = new RectF();
        this.As = new RectF();
        this.At = new RectF();
        this.Au = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        init(context, attributeSet, i2);
    }

    private void a(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        RectF rectF4 = this.Aq;
        path.moveTo(rectF4.left, rectF4.top + this.mRadius);
        this.At.set(rectF);
        RectF rectF5 = this.At;
        float f2 = rectF5.top;
        float f3 = this.mRadius;
        rectF5.bottom = f2 + (f3 * 2.0f);
        rectF5.right = rectF5.left + (f3 * 2.0f);
        path.arcTo(rectF5, 180.0f, 90.0f);
        path.lineTo(rectF2.left, rectF2.top);
        path.arcTo(rectF2, -180.0f, -180.0f);
        path.lineTo(rectF.width() - this.mRadius, rectF.top);
        this.At.set(rectF);
        RectF rectF6 = this.At;
        float f4 = rectF6.right;
        float f5 = this.mRadius;
        rectF6.left = f4 - (f5 * 2.0f);
        rectF6.bottom = rectF6.top + (f5 * 2.0f);
        path.arcTo(rectF6, 270.0f, 90.0f);
        this.At.set(rectF);
        RectF rectF7 = this.At;
        float f6 = rectF7.right;
        float f7 = this.mRadius;
        rectF7.left = f6 - (f7 * 2.0f);
        rectF7.top = rectF7.bottom - (f7 * 2.0f);
        path.arcTo(rectF7, 0.0f, 90.0f);
        path.lineTo(rectF3.right, rectF3.bottom);
        path.arcTo(rectF3, 0.0f, -180.0f);
        path.lineTo(rectF.left + this.mRadius, rectF.bottom);
        this.At.set(rectF);
        RectF rectF8 = this.At;
        float f8 = rectF8.left;
        float f9 = this.mRadius;
        rectF8.right = f8 + (f9 * 2.0f);
        rectF8.top = rectF8.bottom - (f9 * 2.0f);
        path.arcTo(rectF8, 90.0f, 90.0f);
    }

    private void init(Context context, @Nullable AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_JinniuCouponLayout, i2, 0);
        this.mRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_outerRadius, 4.0f);
        this.Ao = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_JinniuCouponLayout_ksad_verticalRadius, 10.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.mPaint.setAntiAlias(true);
    }

    private void setGradientPaint(RectF rectF) {
        this.mPaint.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, this.startColor, this.endColor, Shader.TileMode.CLAMP));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.Ap.setEmpty();
        getDrawingRect(this.Ap);
        this.Aq.set(this.Ap);
        if (getChildCount() > 1) {
            View childAt = getChildAt(0);
            RectF rectF = this.Ar;
            if (rectF == null) {
                this.Ar = new RectF();
            } else {
                rectF.setEmpty();
            }
            RectF rectF2 = this.As;
            if (rectF2 == null) {
                this.As = new RectF();
            } else {
                rectF2.setEmpty();
            }
            float measuredWidth = childAt.getMeasuredWidth();
            Rect rect = this.Ap;
            float f2 = rect.left + measuredWidth;
            RectF rectF3 = this.Ar;
            int i2 = rect.top;
            float f3 = this.Ao;
            rectF3.set(f2, i2 - f3, (2.0f * f3) + f2, i2 + f3);
            RectF rectF4 = this.As;
            RectF rectF5 = this.Ar;
            float f4 = rectF5.left;
            int i3 = this.Ap.bottom;
            float f5 = this.Ao;
            rectF4.set(f4, i3 - f5, rectF5.right, i3 + f5);
            a(this.Au, this.Aq, this.Ar, this.As);
            setGradientPaint(this.Aq);
            canvas.drawPath(this.Au, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }
}
