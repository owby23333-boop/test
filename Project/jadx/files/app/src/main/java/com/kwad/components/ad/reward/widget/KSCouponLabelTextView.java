package com.kwad.components.ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"AppCompatCustomView"})
public class KSCouponLabelTextView extends TextView implements d {
    private final Path AA;
    private Path AB;
    private Path AC;
    private boolean AE;
    private final Rect Ap;
    private final RectF Aq;
    private final RectF At;
    private float Av;
    private float Aw;
    private float Ax;
    private final RectF Ay;
    private final RectF Az;
    private final Paint mPaint;

    @ColorInt
    private int strokeColor;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.Ap = new Rect();
        this.Aq = new RectF();
        this.Ay = new RectF();
        this.Az = new RectF();
        this.AA = new Path();
        this.At = new RectF();
        this.AE = true;
        init(context, null, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.Ap = new Rect();
        this.Aq = new RectF();
        this.Ay = new RectF();
        this.Az = new RectF();
        this.AA = new Path();
        this.At = new RectF();
        this.AE = true;
        init(context, attributeSet, 0);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPaint = new Paint();
        this.Ap = new Rect();
        this.Aq = new RectF();
        this.Ay = new RectF();
        this.Az = new RectF();
        this.AA = new Path();
        this.At = new RectF();
        this.AE = true;
        init(context, attributeSet, i2);
    }

    @RequiresApi(api = 19)
    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f2 = this.Av;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        path2.addArc(rectF2, 90.0f, -180.0f);
        path3.addArc(rectF3, 90.0f, 180.0f);
        path.op(this.AB, Path.Op.DIFFERENCE);
        path.op(this.AC, Path.Op.DIFFERENCE);
    }

    private void a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f2 = rectF2.left;
        float f3 = this.Ax;
        rectF2.left = f2 - f3;
        rectF2.right = rectF2.left + (f3 * 2.0f);
        float fHeight = rectF.height();
        float f4 = this.Ax;
        rectF2.top += (fHeight - (f4 * 2.0f)) / 2.0f;
        rectF2.bottom = rectF2.top + (f4 * 2.0f);
    }

    private void b(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(rectF.left, rectF.top + this.Av);
        this.At.set(rectF);
        RectF rectF4 = this.At;
        float f2 = rectF4.top;
        float f3 = this.Av;
        rectF4.bottom = f2 + (f3 * 2.0f);
        rectF4.right = rectF4.left + (f3 * 2.0f);
        path.arcTo(rectF4, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.Av, rectF.top);
        this.At.set(rectF);
        RectF rectF5 = this.At;
        float f4 = rectF5.right;
        float f5 = this.Av;
        rectF5.left = f4 - (f5 * 2.0f);
        rectF5.bottom = rectF5.top + (f5 * 2.0f);
        path.arcTo(rectF5, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.Av);
        this.At.set(rectF);
        RectF rectF6 = this.At;
        float f6 = rectF6.right;
        float f7 = this.Av;
        rectF6.left = f6 - (f7 * 2.0f);
        rectF6.top = rectF6.bottom - (f7 * 2.0f);
        path.arcTo(rectF6, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.Av, rectF.bottom);
        this.At.set(rectF);
        RectF rectF7 = this.At;
        float f8 = rectF7.left;
        float f9 = this.Av;
        rectF7.right = f8 + (f9 * 2.0f);
        rectF7.top = rectF7.bottom - (f9 * 2.0f);
        path.arcTo(rectF7, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f2 = rectF2.right;
        float f3 = this.Ax;
        rectF2.right = f2 + f3;
        rectF2.left = rectF2.right - (f3 * 2.0f);
        float fHeight = rectF.height();
        float f4 = this.Ax;
        rectF2.top += (fHeight - (f4 * 2.0f)) / 2.0f;
        rectF2.bottom = rectF2.top + (f4 * 2.0f);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i2, 0);
        int color = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.Av = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_labelRadius, 8.0f);
        this.Aw = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeSize, 2.0f);
        this.strokeColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeColor, color);
        this.Ax = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_sideRadius, 16.0f);
        typedArrayObtainStyledAttributes.recycle();
        ks();
    }

    private void ks() {
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.Aw);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        this.strokeColor = getResources().getColor(R.color.ksad_reward_main_color);
        setTextColor(this.strokeColor);
        ks();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Ap.setEmpty();
        getDrawingRect(this.Ap);
        float f2 = this.Aw / 2.0f;
        this.Aq.set(this.Ap);
        RectF rectF = this.Aq;
        rectF.left += f2;
        rectF.top += f2;
        rectF.right -= f2;
        rectF.bottom -= f2;
        a(rectF, this.Ay);
        b(this.Aq, this.Az);
        if (Build.VERSION.SDK_INT >= 19) {
            Path path = this.AB;
            if (path == null) {
                this.AB = new Path();
            } else {
                path.reset();
            }
            Path path2 = this.AC;
            if (path2 == null) {
                this.AC = new Path();
            } else {
                path2.reset();
            }
            a(this.AA, this.AB, this.AC, this.Aq, this.Ay, this.Az);
        } else {
            b(this.AA, this.Aq, this.Ay, this.Az);
        }
        canvas.drawPath(this.AA, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.AE) {
            if (((float) (getPaddingLeft() + getPaddingRight())) + getPaint().measureText(getText().toString()) <= ((float) getMeasuredWidth())) {
                return;
            }
            setVisibility(8);
        }
    }
}
