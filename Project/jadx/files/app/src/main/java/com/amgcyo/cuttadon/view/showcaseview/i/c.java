package com.amgcyo.cuttadon.view.showcaseview.i;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: compiled from: OvalShape.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements e {
    private int a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5500c;

    public c(int i2) {
        this.a = 200;
        this.b = true;
        this.a = i2;
    }

    public static int a(Rect rect) {
        return Math.max(rect.width(), rect.height()) / 2;
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public int getHeight() {
        return this.a;
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public void a(Canvas canvas, Paint paint, int i2, int i3) {
        int i4 = this.a;
        if (i4 > 0) {
            float f2 = i4 + this.f5500c;
            float f3 = i2;
            float f4 = i3;
            float f5 = f2 / 2.0f;
            canvas.drawOval(new RectF(f3 - f2, f4 - f5, f3 + f2, f4 + f5), paint);
        }
    }

    public c(Rect rect) {
        this(a(rect));
    }

    public c(com.amgcyo.cuttadon.view.showcaseview.j.a aVar) {
        this(aVar.a());
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public void a(com.amgcyo.cuttadon.view.showcaseview.j.a aVar) {
        if (this.b) {
            this.a = a(aVar.a());
        }
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public int a() {
        return this.a + this.f5500c;
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public void a(int i2) {
        this.f5500c = i2;
    }
}
