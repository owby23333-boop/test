package com.zwb.danmaku.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDanmaku {
    private long A;
    private long B;
    private String[] C;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f20652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f20653d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20658i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f20660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f20661l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f20662m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f20663n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f20664o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f20665p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f20667r;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @DrawableRes
    private int f20672w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Bitmap f20673x;
    private Rect a = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f20654e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f20655f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f20656g = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f20659j = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f20666q = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f20668s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f20669t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f20670u = a.a;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ShowState f20671v = ShowState.STATE_NEVER_SHOWED;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Rect f20674y = new Rect();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private RectF f20675z = new RectF();

    public enum DanmakuType {
        TYPE_SCROLL_RL,
        TYPE_SCROLL_LR,
        TYPE_SCROLL_TB,
        TYPE_SCROLL_BT,
        TYPE_SPECIAL
    }

    public enum ShowState {
        STATE_NEVER_SHOWED,
        STATE_SHOWING,
        STATE_GONE
    }

    public float A() {
        return y() + k() + l() + (r() * 2.0f);
    }

    public boolean B() {
        return this.f20671v == ShowState.STATE_GONE;
    }

    public boolean C() {
        return this.f20667r;
    }

    public boolean D() {
        return this.f20671v == ShowState.STATE_NEVER_SHOWED;
    }

    public boolean E() {
        return this.f20671v == ShowState.STATE_SHOWING;
    }

    public void F() {
        Bitmap bitmap = this.f20673x;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f20673x.recycle();
        this.f20673x = null;
    }

    public abstract void G();

    public BaseDanmaku a(String str) {
        this.b = str;
        return this;
    }

    public abstract void a(int i2, int i3);

    public BaseDanmaku b(float f2) {
        this.f20659j = f2;
        return this;
    }

    public BaseDanmaku c(float f2) {
        return this;
    }

    public void c(int i2) {
        this.f20669t = i2;
    }

    public BaseDanmaku d(float f2) {
        return this;
    }

    public BaseDanmaku d(int i2) {
        this.f20661l = i2;
        return this;
    }

    public BaseDanmaku e(float f2) {
        this.f20665p = f2;
        return this;
    }

    public BaseDanmaku f(int i2) {
        this.f20653d = i2;
        return this;
    }

    public BaseDanmaku g(int i2) {
        this.f20657h = i2;
        return this;
    }

    public abstract DanmakuType getType();

    public BaseDanmaku h(int i2) {
        this.f20658i = i2;
        return this;
    }

    public BaseDanmaku i(float f2) {
        this.f20654e = f2;
        return this;
    }

    public BaseDanmaku j(float f2) {
        this.f20655f = f2;
        return this;
    }

    public BaseDanmaku k(float f2) {
        this.f20660k = f2;
        return this;
    }

    public BaseDanmaku l(float f2) {
        this.f20656g = f2;
        return this;
    }

    public BaseDanmaku m(float f2) {
        this.f20652c = f2;
        return this;
    }

    public float n() {
        return this.f20654e;
    }

    public float o() {
        return this.f20655f;
    }

    public int p() {
        return this.f20661l;
    }

    public int q() {
        return this.f20666q;
    }

    public float r() {
        return this.f20660k;
    }

    public ShowState s() {
        return this.f20671v;
    }

    public float t() {
        return this.f20656g;
    }

    public String u() {
        return this.b;
    }

    public int v() {
        return this.f20653d;
    }

    public int w() {
        return this.f20657h;
    }

    public float x() {
        return this.f20652c;
    }

    public int y() {
        return this.f20658i;
    }

    public String[] z() {
        return this.C;
    }

    public BaseDanmaku a(boolean z2) {
        this.f20667r = z2;
        return this;
    }

    public void b(int i2) {
        this.f20668s = i2;
    }

    public int c() {
        return this.f20672w;
    }

    public long d() {
        return this.B;
    }

    public long e() {
        return this.A;
    }

    public float f() {
        float fW = w() + j() + m() + (r() * 2.0f);
        if (this.C == null) {
            return fW;
        }
        int iW = w();
        String[] strArr = this.C;
        return (iW * strArr.length) + ((strArr.length - 1) * this.f20668s) + j() + m() + (r() * 2.0f);
    }

    public BaseDanmaku g(float f2) {
        this.f20663n = f2;
        return this;
    }

    public BaseDanmaku h(float f2) {
        this.f20664o = f2;
        return this;
    }

    public float i() {
        return this.f20659j;
    }

    public float j() {
        return this.f20665p;
    }

    public float k() {
        return this.f20662m;
    }

    public float l() {
        return this.f20663n;
    }

    public float m() {
        return this.f20664o;
    }

    public BaseDanmaku a(ShowState showState) {
        this.f20671v = showState;
        return this;
    }

    public Bitmap b() {
        return this.f20673x;
    }

    public void c(@NonNull Canvas canvas, @NonNull Paint paint, int i2, int i3) {
        if (z() == null) {
            canvas.drawText(u(), n() + k(), o() + m() + w(), paint);
            return;
        }
        float fW = 0.0f;
        for (String str : z()) {
            canvas.drawText(str, n() + k(), o() + m() + w() + fW, paint);
            fW += w() + g();
        }
    }

    public BaseDanmaku e(int i2) {
        this.f20666q = i2;
        return this;
    }

    public int g() {
        return this.f20668s;
    }

    public int h() {
        return this.f20669t;
    }

    public float a() {
        return this.f20670u;
    }

    public void b(@NonNull Canvas canvas, @NonNull Paint paint, int i2, int i3) {
        if (z() == null) {
            canvas.drawText(u(), n() + k(), o() + m() + w(), paint);
            return;
        }
        float fW = 0.0f;
        for (String str : z()) {
            canvas.drawText(str, n() + k(), o() + m() + w() + fW, paint);
            fW += w() + g();
        }
    }

    public BaseDanmaku a(float f2) {
        this.f20670u = f2;
        return this;
    }

    public BaseDanmaku f(float f2) {
        this.f20662m = f2;
        return this;
    }

    public BaseDanmaku a(@DrawableRes int i2) {
        this.f20672w = i2;
        return this;
    }

    public void a(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Paint paint2, @NonNull Paint paint3, int i2, int i3) {
        if (C()) {
            G();
            a(i2, i3);
            if (E()) {
                a(paint, paint2, paint3);
                a(canvas, paint3, i2, i3);
                if (this.f20666q == 2) {
                    c(canvas, paint2, i2, i3);
                }
                b(canvas, paint, i2, i3);
            }
        }
    }

    private void b(Paint paint) {
        this.C = this.b.split("\n");
        if ((h() - l()) - l() < 0.0f) {
            return;
        }
        String[] strArr = this.C;
        if (strArr == null) {
            this.C = a(u(), paint).split("\n");
        } else {
            this.C = a(strArr, paint).split("\n");
        }
    }

    public void a(@NonNull Canvas canvas, @NonNull Paint paint, int i2, int i3) {
        if (b() != null) {
            this.f20675z.set(n() - r(), o(), (n() + A()) - r(), o() + f());
            canvas.drawBitmap(b(), this.f20674y, this.f20675z, paint);
        }
    }

    private void a(@NonNull Paint paint, @NonNull Paint paint2, @NonNull Paint paint3) {
        try {
            if (x() > 0.0f) {
                paint.setTextSize(x());
                paint2.setTextSize(x());
            }
            if (v() != 0) {
                paint.setColor(v());
            }
            if (this.f20666q != 1) {
                paint.clearShadowLayer();
                if (r() > 0.0f && p() != 0) {
                    paint2.setColor(p());
                    paint2.setStrokeWidth(r());
                }
            } else if (r() > 0.0f && p() != 0) {
                paint.setShadowLayer(r(), 0.0f, 0.0f, p());
            }
            paint.setAlpha((int) a());
            paint2.setAlpha((int) a());
            paint3.setAlpha((int) a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(Paint paint) {
        if (TextUtils.isEmpty(u()) || paint == null) {
            return;
        }
        if (x() > 0.0f) {
            paint.setTextSize(x());
        }
        b(paint);
        String[] strArr = this.C;
        if (strArr == null) {
            paint.getTextBounds(u(), 0, u().length(), this.a);
            h(this.a.width()).g(this.a.height());
            return;
        }
        int iWidth = 0;
        int iHeight = 0;
        for (String str : strArr) {
            paint.getTextBounds(str, 0, str.length(), this.a);
            if (this.a.width() > iWidth) {
                iWidth = this.a.width();
            }
            if (this.a.height() > iHeight) {
                iHeight = this.a.height();
            }
        }
        h(iWidth).g(iHeight);
    }

    private String a(String[] strArr, Paint paint) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                if (paint.measureText(str) <= (h() - l()) - l()) {
                    sb.append(str);
                } else {
                    sb.append(a(str, paint));
                }
                sb.append("\n");
            }
        }
        if (!sb.toString().endsWith("\n")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private String a(String str, Paint paint) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        float fMeasureText = 0.0f;
        while (i2 != str.length()) {
            char cCharAt = str.charAt(i2);
            fMeasureText += paint.measureText(String.valueOf(cCharAt));
            if (fMeasureText <= (h() - l()) - l()) {
                sb.append(cCharAt);
            } else {
                sb.append("\n");
                i2--;
                fMeasureText = 0.0f;
            }
            i2++;
        }
        return sb.toString();
    }

    public void a(Context context) {
        if (context != null) {
            try {
                if (c() == 0 || this.f20673x != null) {
                    return;
                }
                this.f20673x = com.zwb.danmaku.d.a.a(context, c(), (int) A(), (int) f());
                this.f20674y.set(0, 0, this.f20673x.getWidth(), this.f20673x.getHeight());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
