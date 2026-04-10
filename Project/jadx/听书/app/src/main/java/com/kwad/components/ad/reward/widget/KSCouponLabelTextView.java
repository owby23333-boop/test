package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public class KSCouponLabelTextView extends TextView implements d {
    private final Rect DB;
    private final RectF DC;
    private final RectF DF;
    private float DH;
    private float DI;
    private float DJ;
    private final RectF DK;
    private final RectF DL;
    private final Path DM;
    private Path DN;
    private Path DO;
    private boolean DP;
    private final Paint mPaint;
    private int strokeColor;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.DB = new Rect();
        this.DC = new RectF();
        this.DK = new RectF();
        this.DL = new RectF();
        this.DM = new Path();
        this.DF = new RectF();
        this.DP = true;
        a(context, null, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.DB = new Rect();
        this.DC = new RectF();
        this.DK = new RectF();
        this.DL = new RectF();
        this.DM = new Path();
        this.DF = new RectF();
        this.DP = true;
        a(context, attributeSet, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.DB = new Rect();
        this.DC = new RectF();
        this.DK = new RectF();
        this.DL = new RectF();
        this.DM = new Path();
        this.DF = new RectF();
        this.DP = true;
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i, 0);
        int color = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.DH = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_labelRadius, 8.0f);
        this.DI = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeSize, 2.0f);
        this.strokeColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeColor, color);
        this.DJ = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_sideRadius, 16.0f);
        typedArrayObtainStyledAttributes.recycle();
        lm();
    }

    private void lm() {
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.DI);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.DP) {
            if (((float) (getPaddingLeft() + getPaddingRight())) + getPaint().measureText(getText().toString()) <= ((float) getMeasuredWidth())) {
                return;
            }
            setVisibility(8);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.DB.setEmpty();
        getDrawingRect(this.DB);
        float f = this.DI / 2.0f;
        this.DC.set(this.DB);
        this.DC.left += f;
        this.DC.top += f;
        this.DC.right -= f;
        this.DC.bottom -= f;
        a(this.DC, this.DK);
        b(this.DC, this.DL);
        Path path = this.DN;
        if (path == null) {
            this.DN = new Path();
        } else {
            path.reset();
        }
        Path path2 = this.DO;
        if (path2 == null) {
            this.DO = new Path();
        } else {
            path2.reset();
        }
        a(this.DM, this.DN, this.DO, this.DC, this.DK, this.DL);
        canvas.drawPath(this.DM, this.mPaint);
    }

    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f = this.DH;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        path2.addArc(rectF2, 90.0f, -180.0f);
        path3.addArc(rectF3, 90.0f, 180.0f);
        path.op(this.DN, Path.Op.DIFFERENCE);
        path.op(this.DO, Path.Op.DIFFERENCE);
    }

    private void b(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(rectF.left, rectF.top + this.DH);
        this.DF.set(rectF);
        RectF rectF4 = this.DF;
        rectF4.bottom = rectF4.top + (this.DH * 2.0f);
        RectF rectF5 = this.DF;
        rectF5.right = rectF5.left + (this.DH * 2.0f);
        path.arcTo(this.DF, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.DH, rectF.top);
        this.DF.set(rectF);
        RectF rectF6 = this.DF;
        rectF6.left = rectF6.right - (this.DH * 2.0f);
        RectF rectF7 = this.DF;
        rectF7.bottom = rectF7.top + (this.DH * 2.0f);
        path.arcTo(this.DF, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.DH);
        this.DF.set(rectF);
        RectF rectF8 = this.DF;
        rectF8.left = rectF8.right - (this.DH * 2.0f);
        RectF rectF9 = this.DF;
        rectF9.top = rectF9.bottom - (this.DH * 2.0f);
        path.arcTo(this.DF, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.DH, rectF.bottom);
        this.DF.set(rectF);
        RectF rectF10 = this.DF;
        rectF10.right = rectF10.left + (this.DH * 2.0f);
        RectF rectF11 = this.DF;
        rectF11.top = rectF11.bottom - (this.DH * 2.0f);
        path.arcTo(this.DF, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    private void a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        rectF2.left -= this.DJ;
        rectF2.right = rectF2.left + (this.DJ * 2.0f);
        rectF2.top += (rectF.height() - (this.DJ * 2.0f)) / 2.0f;
        rectF2.bottom = rectF2.top + (this.DJ * 2.0f);
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        rectF2.right += this.DJ;
        rectF2.left = rectF2.right - (this.DJ * 2.0f);
        rectF2.top += (rectF.height() - (this.DJ * 2.0f)) / 2.0f;
        rectF2.bottom = rectF2.top + (this.DJ * 2.0f);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        int color = getResources().getColor(R.color.ksad_reward_main_color);
        this.strokeColor = color;
        setTextColor(color);
        lm();
        invalidate();
    }
}
