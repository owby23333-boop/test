package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class DislikeView extends View {
    private int bf;
    private RectF d;
    private int e;
    private Paint ga;
    private Paint p;
    private Paint tg;
    private int v;
    private int vn;

    public DislikeView(Context context) {
        super(context);
        e();
    }

    private void e() {
        Paint paint = new Paint();
        this.tg = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.p = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.ga = paint3;
        paint3.setAntiAlias(true);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.d;
        int i = this.vn;
        canvas.drawRoundRect(rectF, i, i, this.ga);
        RectF rectF2 = this.d;
        int i2 = this.vn;
        canvas.drawRoundRect(rectF2, i2, i2, this.tg);
        int i3 = this.e;
        int i4 = this.bf;
        canvas.drawLine(i3 * 0.3f, i4 * 0.3f, i3 * 0.7f, i4 * 0.7f, this.p);
        int i5 = this.e;
        int i6 = this.bf;
        canvas.drawLine(i5 * 0.7f, i6 * 0.3f, i5 * 0.3f, i6 * 0.7f, this.p);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = i;
        this.bf = i2;
        int i5 = this.v;
        this.d = new RectF(i5, i5, this.e - i5, this.bf - i5);
    }

    public void setBgColor(int i) {
        this.ga.setStyle(Paint.Style.FILL);
        this.ga.setColor(i);
    }

    public void setDislikeColor(int i) {
        this.p.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.p.setStrokeWidth(i);
    }

    public void setRadius(int i) {
        this.vn = i;
    }

    public void setStrokeColor(int i) {
        this.tg.setStyle(Paint.Style.STROKE);
        this.tg.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.tg.setStrokeWidth(i);
        this.v = i;
    }
}
