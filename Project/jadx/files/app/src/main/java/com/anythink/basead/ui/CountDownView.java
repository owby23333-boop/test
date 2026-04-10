package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class CountDownView extends View {
    private Paint a;
    private Paint b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f6167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f6168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f6169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6173i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6174j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6175k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private RectF f6176l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f6177m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f6178n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Rect f6179o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f6180p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f6181q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Paint.FontMetrics f6182r;

    public CountDownView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        this.f6168d = TypedValue.applyDimension(1, 2.5f, context.getResources().getDisplayMetrics());
        this.f6169e = TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
        this.f6170f = Color.parseColor("#66000000");
        this.f6171g = Color.parseColor("#CC000000");
        this.f6172h = -1;
        this.a = new Paint();
        this.a.setAntiAlias(true);
        this.a.setStrokeCap(Paint.Cap.ROUND);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.f6168d);
        this.b = new Paint(this.a);
        this.b.setColor(this.f6170f);
        this.b.setStyle(Paint.Style.FILL);
        this.f6167c = new Paint();
        this.f6167c.setAntiAlias(true);
        this.f6167c.setTextSize(this.f6169e);
        this.f6167c.setColor(this.f6172h);
        this.f6176l = new RectF();
        this.f6179o = new Rect();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.f6176l.centerX(), this.f6176l.centerY(), this.f6175k, this.b);
        this.a.setColor(this.f6171g);
        canvas.drawArc(this.f6176l, 0.0f, 360.0f, false, this.a);
        this.a.setColor(this.f6172h);
        canvas.drawArc(this.f6176l, -90.0f, this.f6177m, false, this.a);
        if (TextUtils.isEmpty(this.f6178n)) {
            return;
        }
        Paint paint = this.f6167c;
        String str = this.f6178n;
        paint.getTextBounds(str, 0, str.length(), this.f6179o);
        this.f6181q = this.f6167c.measureText(this.f6178n);
        this.f6182r = this.f6167c.getFontMetrics();
        String str2 = this.f6178n;
        float fCenterX = this.f6176l.centerX() - (this.f6181q / 2.0f);
        float fCenterY = this.f6176l.centerY();
        Paint.FontMetrics fontMetrics = this.f6182r;
        float f2 = fontMetrics.bottom;
        canvas.drawText(str2, fCenterX, fCenterY + (((f2 - fontMetrics.top) / 2.0f) - f2), this.f6167c);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f6173i = i2;
        this.f6174j = i3;
        a();
    }

    public void refresh(int i2) {
        this.f6177m = ((i2 * 1.0f) / this.f6180p) * 360.0f;
        StringBuilder sb = new StringBuilder();
        double d2 = this.f6180p - i2;
        Double.isNaN(d2);
        sb.append((int) Math.ceil(d2 / 1000.0d));
        this.f6178n = sb.toString();
        invalidate();
    }

    public void setBgColor(int i2) {
        this.f6170f = i2;
        this.b.setColor(this.f6170f);
    }

    public void setDuration(int i2) {
        this.f6180p = i2;
        StringBuilder sb = new StringBuilder();
        sb.append(i2 / 1000);
        this.f6178n = sb.toString();
    }

    public void setThickInPx(int i2) {
        this.f6168d = i2;
        this.a.setStrokeWidth(this.f6168d);
        a();
    }

    public void setUnderRingColor(int i2) {
        this.f6171g = i2;
    }

    public CountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6168d = TypedValue.applyDimension(1, 2.5f, context.getResources().getDisplayMetrics());
        this.f6169e = TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
        this.f6170f = Color.parseColor("#66000000");
        this.f6171g = Color.parseColor("#CC000000");
        this.f6172h = -1;
        this.a = new Paint();
        this.a.setAntiAlias(true);
        this.a.setStrokeCap(Paint.Cap.ROUND);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.f6168d);
        this.b = new Paint(this.a);
        this.b.setColor(this.f6170f);
        this.b.setStyle(Paint.Style.FILL);
        this.f6167c = new Paint();
        this.f6167c.setAntiAlias(true);
        this.f6167c.setTextSize(this.f6169e);
        this.f6167c.setColor(this.f6172h);
        this.f6176l = new RectF();
        this.f6179o = new Rect();
    }

    private void a() {
        float f2 = this.f6168d * 0.5f;
        float f3 = 0.0f + f2;
        this.f6176l.set(f3, f3, this.f6173i - f2, this.f6174j - f2);
        this.f6175k = ((int) this.f6176l.width()) >> 1;
    }
}
