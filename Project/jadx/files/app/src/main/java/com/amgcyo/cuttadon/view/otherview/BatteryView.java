package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class BatteryView extends View {
    private boolean A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float[] f4918s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Paint f4919t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextPaint f4920u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4921v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4922w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4923x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private RectF f4924y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Path f4925z;

    public BatteryView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4918s = new float[]{3.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 3.0f, 3.0f};
        this.f4921v = -16777216;
        this.f4922w = -1;
        this.f4923x = 100;
        this.f4919t = new Paint(1);
        this.f4919t.setDither(true);
        this.f4920u = new TextPaint(1);
        this.f4920u.setDither(true);
        this.f4920u.setFakeBoldText(true);
        this.f4920u.setTextAlign(Paint.Align.CENTER);
        try {
            this.f4920u.setTypeface(Typeface.createFromAsset(getResources().getAssets(), "number.ttf"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f4924y = new RectF();
        this.f4925z = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int height = getHeight() / 6;
        float f2 = 1;
        this.f4924y.set(height + 1, f2, getWidth() - 1, getHeight() - 1);
        this.f4919t.setStyle(Paint.Style.STROKE);
        this.f4919t.setStrokeWidth(3.0f);
        this.f4919t.setColor(this.f4921v);
        canvas.drawRoundRect(this.f4924y, 4.0f, 4.0f, this.f4919t);
        RectF rectF = this.f4924y;
        float f3 = rectF.left + 2.0f + f2;
        float f4 = (rectF.right - 2.0f) - f2;
        rectF.set(f3, rectF.top + 2.0f + f2, f4, (rectF.bottom - 2.0f) - f2);
        this.f4919t.setStyle(Paint.Style.FILL);
        if (this.A) {
            this.f4920u.setTextSize(this.f4924y.height());
            this.f4920u.setColor(this.f4922w);
            Paint.FontMetrics fontMetrics = this.f4920u.getFontMetrics();
            canvas.drawText(String.valueOf(this.f4923x), ((f4 - f3) / 2.0f) + f3, (((getHeight() * 1.0f) / 2.0f) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f), this.f4920u);
        } else {
            this.f4924y.left += (1.0f - ((this.f4923x * 1.0f) / 100.0f)) * (f4 - f3);
            this.f4919t.setColor(this.f4921v);
            canvas.drawRoundRect(this.f4924y, 2.0f, 2.0f, this.f4919t);
        }
        int height2 = getHeight() / 2;
        int height3 = getHeight() / 5;
        this.f4924y.set(0.0f, height2 - height3, height, height2 + height3);
        this.f4925z.reset();
        this.f4925z.addRoundRect(this.f4924y, this.f4918s, Path.Direction.CCW);
        canvas.drawPath(this.f4925z, this.f4919t);
    }

    public void setColor(@ColorInt int i2) {
        this.f4921v = i2;
        this.f4922w = i2;
        invalidate();
    }

    public void setProgress(int i2) {
        this.f4923x = i2;
        invalidate();
    }

    public void setShowBatteryNumber(boolean z2) {
        this.A = z2;
        invalidate();
    }
}
