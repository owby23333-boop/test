package com.amgcyo.cuttadon.view.showcaseview.i;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: compiled from: RectangleShape.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements e {
    private boolean a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Rect f5503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5504f;

    public d(int i2, int i3) {
        this.a = false;
        this.b = 0;
        this.f5501c = 0;
        this.f5502d = true;
        this.b = i2;
        this.f5501c = i3;
        b();
    }

    private void b() {
        int i2 = this.b;
        int i3 = this.f5501c;
        this.f5503e = new Rect((-i2) / 2, (-i3) / 2, i2 / 2, i3 / 2);
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public void a(Canvas canvas, Paint paint, int i2, int i3) {
        if (this.f5503e.isEmpty()) {
            return;
        }
        RectF rectF = new RectF();
        int i4 = this.f5503e.left + i2;
        int i5 = this.f5504f;
        rectF.left = i4 - i5;
        rectF.top = (r1.top + i3) - i5;
        rectF.right = r1.right + i2 + i5;
        rectF.bottom = r1.bottom + i3 + i5;
        canvas.drawRoundRect(rectF, 10.0f, 10.0f, paint);
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public int getHeight() {
        return this.f5501c;
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public void a(com.amgcyo.cuttadon.view.showcaseview.j.a aVar) {
        if (this.f5502d) {
            Rect rectA = aVar.a();
            this.f5501c = rectA.height();
            if (this.a) {
                this.b = Integer.MAX_VALUE;
            } else {
                this.b = rectA.width();
            }
            b();
        }
    }

    public d(Rect rect, boolean z2) {
        this.a = false;
        this.b = 0;
        this.f5501c = 0;
        this.f5502d = true;
        this.a = z2;
        this.f5501c = rect.height();
        if (z2) {
            this.b = Integer.MAX_VALUE;
        } else {
            this.b = rect.width();
        }
        b();
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public int a() {
        return (this.f5501c / 2) + this.f5504f;
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public void a(int i2) {
        this.f5504f = i2;
    }
}
