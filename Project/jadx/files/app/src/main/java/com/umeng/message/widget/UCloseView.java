package com.umeng.message.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.Button;
import com.umeng.message.proguard.m;

/* JADX INFO: loaded from: classes3.dex */
public class UCloseView extends Button {
    private float cx;
    private float cy;
    private float lineWith;
    private Paint mPaint;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f20601p;
    private float radius;
    private int remain;

    public UCloseView(Context context) {
        super(context);
        setBackgroundColor(0);
        this.mPaint = new Paint();
        this.remain = m.a(context, 1.0f);
        this.lineWith = m.a(context, 2.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cx = getWidth() / 2;
        this.cy = getHeight() / 2;
        this.radius = (Math.min(getHeight(), getWidth()) / 2) - this.remain;
        this.f20601p = this.radius / 1.4142f;
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(-16777216);
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(this.cx, this.cy, this.radius, this.mPaint);
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(this.lineWith);
        this.mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(this.cx, this.cy, this.radius, this.mPaint);
        float f2 = this.cx;
        float f3 = this.f20601p;
        float f4 = this.cy;
        canvas.drawLine(f2 - f3, f4 - f3, f2 + f3, f4 + f3, this.mPaint);
        float f5 = this.cx;
        float f6 = this.f20601p;
        float f7 = this.cy;
        canvas.drawLine(f5 + f6, f7 - f6, f5 - f6, f7 + f6, this.mPaint);
    }
}
