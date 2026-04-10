package com.tencent.smtt.sdk.ui.dialog.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class a extends View {
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f19142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f19143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Path f19144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Path f19145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RectF f19146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f19147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f19148i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f19149j;

    public a(Context context, float f2, float f3, float f4) {
        super(context, null, 0);
        a(context, f2, f3, f4);
    }

    private int a(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(100, size);
        }
        return 100;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a(Context context, float f2, float f3, float f4) {
        this.f19148i = f3;
        this.f19149j = f4;
        int color = Color.parseColor("#989DB4");
        float fA = a(context, 6.0f);
        this.f19142c = new Paint();
        this.f19143d = new Paint();
        this.f19143d.setColor(-1);
        this.f19143d.setStyle(Paint.Style.FILL);
        this.f19143d.setAntiAlias(true);
        this.f19142c.setColor(color);
        this.f19142c.setStyle(Paint.Style.STROKE);
        this.f19142c.setAntiAlias(true);
        this.f19142c.setStrokeWidth(fA);
        this.f19142c.setStrokeJoin(Paint.Join.ROUND);
        this.f19146g = new RectF();
        this.f19147h = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(0.0f, 0.0f);
        canvas.rotate(0.0f);
        if (this.f19145f == null) {
            this.f19145f = new Path();
        }
        this.f19145f.reset();
        this.f19145f.addRoundRect(this.f19146g, this.f19147h, Path.Direction.CCW);
        this.f19145f.close();
        canvas.drawPath(this.f19145f, this.f19143d);
        canvas.translate(this.a / 2.0f, (this.b / 2.0f) + (this.f19149j / 2.0f));
        if (this.f19144e == null) {
            this.f19144e = new Path();
        }
        this.f19144e.reset();
        this.f19144e.moveTo(0.0f, 0.0f);
        this.f19144e.lineTo((-this.f19148i) / 2.0f, (-this.f19149j) / 2.0f);
        this.f19144e.close();
        canvas.drawPath(this.f19144e, this.f19142c);
        this.f19144e.reset();
        this.f19144e.moveTo(0.0f, 0.0f);
        this.f19144e.lineTo(this.f19148i / 2.0f, (-this.f19149j) / 2.0f);
        this.f19144e.close();
        canvas.drawPath(this.f19144e, this.f19142c);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(a(i2), a(i3));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.a = i2;
        this.b = i3;
        RectF rectF = this.f19146g;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = this.a;
        rectF.bottom = this.b;
    }
}
