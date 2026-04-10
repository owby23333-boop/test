package com.yuewen;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.duokan.core.sys.AsyncCache;
import com.yuewen.be;

/* JADX INFO: loaded from: classes5.dex */
public abstract class fe extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap.Config f11110a;
    public final AsyncCache c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f11111b = new Rect();
    public float d = 1.0f;
    public float e = 0.25f;
    public float f = 0.6f;
    public int g = 0;
    public int h = 0;
    public a i = null;
    public a j = null;

    public class a extends be.a {
        public final be.b l;

        public a(b bVar) {
            super(Math.round(bVar.d().width() * bVar.e()), Math.round(bVar.d().height() * bVar.e()), fe.this.f11110a);
            this.l = bVar;
        }

        @Override // com.yuewen.be.a
        public void E(Bitmap bitmap) {
            fe.this.h(bitmap, this.l.d(), this.l.e());
        }

        @Override // com.duokan.core.sys.AsyncCache.e
        public void u() {
        }
    }

    public class b extends be.b {
        public b(Rect rect, float f) {
            super(fe.this.getClass().toString(), fe.this.toString(), rect, f);
        }
    }

    public fe(Bitmap.Config config, AsyncCache asyncCache) {
        this.f11110a = config;
        this.c = asyncCache;
    }

    public final Rect b(Rect rect, int i, int i2) {
        if (rect.isEmpty()) {
            return new Rect();
        }
        Rect rect2 = new Rect(0, 0, g(), f());
        Rect rect3 = new Rect(rect);
        int i3 = (int) (this.g * (this.e + 1.0f));
        int i4 = (int) (this.h * (this.f + 1.0f));
        rect3.inset((-Math.max(0, i3 - rect3.width())) / 2, (-Math.max(0, i4 - rect3.height())) / 2);
        rect3.intersect(rect2);
        int iMin = Math.min(i3 * i4, rect2.width() * rect2.height());
        while (rect3.width() * rect3.height() < iMin) {
            int iWidth = rect3.width();
            rect3.inset((-(Math.min(iMin / rect3.height(), i) - rect3.width())) / 2, 0);
            rect3.intersect(rect2);
            int iHeight = rect3.height();
            rect3.inset(0, (-(Math.min(iMin / rect3.width(), i2) - rect3.height())) / 2);
            rect3.intersect(rect2);
            if (iWidth == rect3.width() && iHeight == rect3.height()) {
                break;
            }
        }
        if (rect3.width() % 2 != 0) {
            rect3.right++;
        }
        return rect3;
    }

    public final void c() {
        a aVar = this.i;
        if (aVar != null) {
            this.c.o(aVar);
            this.i = null;
        }
        a aVar2 = this.j;
        if (aVar2 != null) {
            this.c.o(aVar2);
            this.j = null;
        }
    }

    public final void d(Canvas canvas) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a aVar;
        canvas.save();
        canvas.translate(getBounds().left, getBounds().top);
        b bVar = new b(b(this.f11111b, com.duokan.core.utils.a.v(canvas), com.duokan.core.utils.a.u(canvas)), this.d);
        a aVar2 = this.i;
        if (aVar2 != null && (aVar2.p() || this.i.l.c(bVar) == 0)) {
            this.c.o(this.i);
            this.i = null;
        }
        a aVar3 = this.j;
        if (aVar3 != null && (aVar3.p() || this.j.l.c(bVar) == 0)) {
            this.c.o(this.j);
            this.j = null;
        }
        a aVar4 = this.i;
        if (aVar4 == null) {
            this.i = (a) this.c.g(bVar, 1);
        } else {
            int iC = aVar4.l.c(bVar);
            if (iC < Integer.MAX_VALUE && (aVar = (a) this.c.g(bVar, iC + 1)) != null) {
                if (aVar.q()) {
                    this.c.o(this.i);
                    this.i = aVar;
                } else {
                    this.c.w(aVar);
                }
            }
        }
        a aVar5 = this.i;
        boolean z = false;
        if (aVar5 != null) {
            int iRound = Math.round(aVar5.l.d().left * this.d);
            int iRound2 = Math.round(this.i.l.d().top * this.d);
            float fE = this.d / this.i.l.e();
            boolean z2 = this.i.l.c(bVar) == Integer.MAX_VALUE;
            if (!this.i.C(canvas, iRound, iRound2, fE, null)) {
                d(canvas);
            } else if (!z2) {
                invalidateSelf();
            }
            z = z2;
        } else {
            d(canvas);
        }
        if (this.j == this.i) {
            this.j = null;
        }
        a aVar6 = this.j;
        if (aVar6 != null && aVar6.q()) {
            this.j = null;
        }
        if (this.j == null && !z) {
            a aVar7 = (a) this.c.h(bVar, new a(bVar));
            this.j = aVar7;
            this.c.w(aVar7);
        }
        canvas.restore();
    }

    public final AsyncCache e() {
        return this.c;
    }

    public int f() {
        return (int) (getIntrinsicHeight() * this.d);
    }

    public int g() {
        return (int) (getIntrinsicWidth() * this.d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public abstract void h(Bitmap bitmap, RectF rectF, float f);

    public final void i(int i) {
        this.h = i;
    }

    public final void j(int i) {
        this.g = i;
    }

    public final void k(int i, int i2, int i3, int i4) {
        this.f11111b.set(i, i2, i3, i4);
    }

    public final void l(Rect rect) {
        this.f11111b.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
