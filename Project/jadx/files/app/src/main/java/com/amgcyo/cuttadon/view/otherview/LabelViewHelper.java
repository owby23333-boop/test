package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.amgcyo.cuttadon.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class LabelViewHelper {
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f5000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f5001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f5002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f5003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Paint f5004l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Paint f5005m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Path f5006n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Path f5007o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Paint f5008p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Rect f5009q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Context f5010r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f5011s;

    public LabelViewHelper(Context context, AttributeSet attributeSet, int i2) {
        this.f5010r = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LabelView, i2, 0);
        this.a = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, a(40.0f));
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, a(20.0f));
        this.f4995c = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, a(1.0f));
        this.f4996d = typedArrayObtainStyledAttributes.getString(6);
        this.f4997e = typedArrayObtainStyledAttributes.getColor(0, -1624781376);
        this.f4998f = typedArrayObtainStyledAttributes.getColor(4, -1);
        this.f4999g = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, a(14.0f));
        this.f5000h = typedArrayObtainStyledAttributes.getInt(9, 0);
        this.f5001i = typedArrayObtainStyledAttributes.getColor(7, -1);
        this.f5002j = typedArrayObtainStyledAttributes.getBoolean(10, true);
        this.f5003k = typedArrayObtainStyledAttributes.getInteger(3, 1);
        typedArrayObtainStyledAttributes.recycle();
        this.f5004l = new Paint();
        this.f5004l.setDither(true);
        this.f5004l.setAntiAlias(true);
        this.f5004l.setStyle(Paint.Style.FILL);
        this.f5005m = new Paint();
        this.f5005m.setDither(true);
        this.f5005m.setAntiAlias(true);
        this.f5005m.setStyle(Paint.Style.STROKE);
        this.f5006n = new Path();
        this.f5006n.reset();
        this.f5007o = new Path();
        this.f5007o.reset();
        this.f5008p = new Paint();
        this.f5008p.setDither(true);
        this.f5008p.setAntiAlias(true);
        this.f5008p.setStrokeJoin(Paint.Join.ROUND);
        this.f5008p.setStrokeCap(Paint.Cap.SQUARE);
        this.f5009q = new Rect();
    }

    private int b(float f2) {
        return (int) ((f2 / this.f5010r.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void a(Canvas canvas, int i2, int i3) {
        if (!this.f5002j || this.f4996d == null) {
            return;
        }
        float f2 = this.a + (this.b / 2);
        a(i2, i3);
        this.f5004l.setColor(this.f4997e);
        int i4 = this.f5011s;
        if (i4 != 0) {
            this.f5004l.setAlpha(i4);
        }
        this.f5005m.setColor(this.f4998f);
        this.f5005m.setStrokeWidth(this.f4995c);
        canvas.drawPath(this.f5006n, this.f5004l);
        canvas.drawPath(this.f5006n, this.f5005m);
        this.f5008p.setTextSize(this.f4999g);
        this.f5008p.setColor(this.f5001i);
        Paint paint = this.f5008p;
        String str = this.f4996d;
        paint.getTextBounds(str, 0, str.length(), this.f5009q);
        this.f5008p.setTypeface(Typeface.defaultFromStyle(this.f5000h));
        float fWidth = ((f2 * 1.4142135f) / 2.0f) - (this.f5009q.width() / 2);
        canvas.drawTextOnPath(this.f4996d, this.f5007o, fWidth < 0.0f ? 0.0f : fWidth, this.f5009q.height() / 2, this.f5008p);
    }

    public void c(View view, int i2) {
        float f2 = i2;
        if (this.b != a(f2)) {
            this.b = a(f2);
            view.invalidate();
        }
    }

    public int d() {
        return this.f5003k;
    }

    public void e(View view, int i2) {
        if (this.f5001i != i2) {
            this.f5001i = i2;
            view.invalidate();
        }
    }

    public int f() {
        return this.f5001i;
    }

    public int g() {
        return b(this.f4999g);
    }

    public int h() {
        return this.f5000h;
    }

    public void b(View view, int i2) {
        float f2 = i2;
        if (this.a != a(f2)) {
            this.a = a(f2);
            view.invalidate();
        }
    }

    public void d(View view, int i2) {
        if (this.f5003k == i2 || i2 > 4 || i2 < 1) {
            return;
        }
        this.f5003k = i2;
        view.invalidate();
    }

    public void f(View view, int i2) {
        if (this.f4999g != i2) {
            this.f4999g = i2;
            view.invalidate();
        }
    }

    public void g(View view, int i2) {
        if (this.f5000h == i2) {
            return;
        }
        this.f5000h = i2;
        view.invalidate();
    }

    public int c() {
        return b(this.b);
    }

    public String e() {
        return this.f4996d;
    }

    public int b() {
        return b(this.a);
    }

    private void a(int i2, int i3) {
        int i4 = this.a;
        int i5 = this.b;
        float f2 = (i2 - i4) - i5;
        float f3 = i2;
        float f4 = (i3 - i4) - i5;
        float f5 = i3;
        float f6 = i5 / 2;
        int i6 = this.f5003k;
        if (i6 == 1) {
            this.f5006n.reset();
            this.f5006n.moveTo(0.0f, this.a);
            this.f5006n.lineTo(this.a, 0.0f);
            this.f5006n.lineTo(this.a + this.b, 0.0f);
            this.f5006n.lineTo(0.0f, this.a + this.b);
            this.f5006n.close();
            this.f5007o.reset();
            this.f5007o.moveTo(0.0f, this.a + f6);
            this.f5007o.lineTo(this.a + f6, 0.0f);
            this.f5007o.close();
            return;
        }
        if (i6 == 2) {
            this.f5006n.reset();
            this.f5006n.moveTo(f2, 0.0f);
            this.f5006n.lineTo(this.b + f2, 0.0f);
            this.f5006n.lineTo(f3, this.a);
            this.f5006n.lineTo(f3, this.a + this.b);
            this.f5006n.close();
            this.f5007o.reset();
            this.f5007o.moveTo(f2 + f6, 0.0f);
            this.f5007o.lineTo(f3, this.a + f6);
            this.f5007o.close();
            return;
        }
        if (i6 == 3) {
            this.f5006n.reset();
            this.f5006n.moveTo(0.0f, f4);
            this.f5006n.lineTo(this.a + this.b, f5);
            this.f5006n.lineTo(this.a, f5);
            this.f5006n.lineTo(0.0f, this.b + f4);
            this.f5006n.close();
            this.f5007o.reset();
            this.f5007o.moveTo(0.0f, f4 + f6);
            this.f5007o.lineTo(this.a + f6, f5);
            this.f5007o.close();
            return;
        }
        if (i6 != 4) {
            return;
        }
        this.f5006n.reset();
        this.f5006n.moveTo(f2, f5);
        this.f5006n.lineTo(f3, f4);
        this.f5006n.lineTo(f3, this.b + f4);
        this.f5006n.lineTo(this.b + f2, f5);
        this.f5006n.close();
        this.f5007o.reset();
        this.f5007o.moveTo(f2 + f6, f5);
        this.f5007o.lineTo(f3, f4 + f6);
        this.f5007o.close();
    }

    private int a(float f2) {
        return (int) ((f2 * this.f5010r.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void a(View view, boolean z2) {
        if (this.f5002j != z2) {
            this.f5002j = z2;
            view.invalidate();
        }
    }

    public int a() {
        return this.f4997e;
    }

    public void a(View view, int i2) {
        if (this.f4997e != i2) {
            this.f4997e = i2;
            view.invalidate();
        }
    }

    public void a(View view, String str) {
        String str2 = this.f4996d;
        if (str2 == null || !str2.equals(str)) {
            this.f4996d = str;
            view.invalidate();
        }
    }
}
