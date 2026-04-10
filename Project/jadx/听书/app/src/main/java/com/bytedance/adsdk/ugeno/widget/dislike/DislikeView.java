package com.bytedance.adsdk.ugeno.widget.dislike;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.adsdk.ugeno.dl;

/* JADX INFO: loaded from: classes2.dex */
public class DislikeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RectF f252a;
    private int dl;
    private float e;
    private int fo;
    private int g;
    private Paint gc;
    private Paint gz;
    private Paint m;
    private dl z;

    public DislikeView(Context context) {
        super(context);
        z();
    }

    private void z() {
        Paint paint = new Paint();
        this.gc = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.gz = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.m = paint3;
        paint3.setAntiAlias(true);
        setBackgroundColor(0);
    }

    public void setRadius(float f) {
        this.e = f;
    }

    public void setDislikeColor(int i) {
        this.gz.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.gz.setStrokeWidth(i);
    }

    public void setStrokeColor(int i) {
        this.gc.setStyle(Paint.Style.STROKE);
        this.gc.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.gc.setStrokeWidth(i);
        this.fo = i;
    }

    public void setBgColor(int i) {
        this.m.setStyle(Paint.Style.FILL);
        this.m.setColor(i);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        dl dlVar = this.z;
        if (dlVar != null) {
            int[] iArrZ = dlVar.z(i, i2);
            super.onMeasure(iArrZ[0], iArrZ[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(0);
        RectF rectF = this.f252a;
        float f = this.e;
        canvas.drawRoundRect(rectF, f, f, this.m);
        RectF rectF2 = this.f252a;
        float f2 = this.e;
        canvas.drawRoundRect(rectF2, f2, f2, this.gc);
        int i = this.g;
        int i2 = this.dl;
        canvas.drawLine(i * 0.3f, i2 * 0.3f, i * 0.7f, i2 * 0.7f, this.gz);
        int i3 = this.g;
        int i4 = this.dl;
        canvas.drawLine(i3 * 0.7f, i4 * 0.3f, i3 * 0.3f, i4 * 0.7f, this.gz);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g = i;
        this.dl = i2;
        int i5 = this.fo;
        this.f252a = new RectF(i5, i5, this.g - i5, this.dl - i5);
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.g(i, i2, i3, i4);
        }
    }

    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        this.z = dlVar;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.gc();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.m();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(z);
        }
    }
}
