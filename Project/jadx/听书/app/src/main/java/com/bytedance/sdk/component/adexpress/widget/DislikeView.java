package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class DislikeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f594a;
    private final RectF dl;
    private Paint e;
    private int g;
    private Paint gc;
    private int gz;
    private int m;
    private int z;

    public DislikeView(Context context) {
        super(context);
        this.dl = new RectF();
        z();
    }

    private void z() {
        Paint paint = new Paint();
        this.f594a = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.e = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.gc = paint3;
        paint3.setAntiAlias(true);
    }

    public void setRadius(int i) {
        this.m = i;
    }

    public void setDislikeColor(int i) {
        this.e.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.e.setStrokeWidth(i);
    }

    public void setStrokeColor(int i) {
        this.f594a.setStyle(Paint.Style.STROKE);
        this.f594a.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.f594a.setStrokeWidth(i);
        this.gz = i;
    }

    public void setBgColor(int i) {
        this.gc.setStyle(Paint.Style.FILL);
        this.gc.setColor(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.dl;
        int i = this.m;
        canvas.drawRoundRect(rectF, i, i, this.gc);
        RectF rectF2 = this.dl;
        int i2 = this.m;
        canvas.drawRoundRect(rectF2, i2, i2, this.f594a);
        int i3 = this.z;
        int i4 = this.g;
        canvas.drawLine(i3 * 0.3f, i4 * 0.3f, i3 * 0.7f, i4 * 0.7f, this.e);
        int i5 = this.z;
        int i6 = this.g;
        canvas.drawLine(i5 * 0.7f, i6 * 0.3f, i5 * 0.3f, i6 * 0.7f, this.e);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.z = i;
        this.g = i2;
        RectF rectF = this.dl;
        int i5 = this.gz;
        rectF.set(i5, i5, i - i5, i2 - i5);
    }
}
