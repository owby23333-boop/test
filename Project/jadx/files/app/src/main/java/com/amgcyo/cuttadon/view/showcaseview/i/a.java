package com.amgcyo.cuttadon.view.showcaseview.i;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: compiled from: CircleShape.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements e {
    private int a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5499c;

    public a() {
        this.a = 200;
        this.b = true;
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public void a(Canvas canvas, Paint paint, int i2, int i3) {
        if (this.a > 0) {
            canvas.drawCircle(i2, i3, r0 + this.f5499c, paint);
        }
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public int getHeight() {
        return this.a * 2;
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public void a(com.amgcyo.cuttadon.view.showcaseview.j.a aVar) {
        if (this.b) {
            this.a = a(aVar.a());
        }
    }

    public a(int i2) {
        this.a = 200;
        this.b = true;
        this.a = i2;
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public int a() {
        return this.a + this.f5499c;
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.i.e
    public void a(int i2) {
        this.f5499c = i2;
    }

    public static int a(Rect rect) {
        return Math.max(rect.width(), rect.height()) / 2;
    }

    public a(Rect rect) {
        this(a(rect));
    }

    public a(com.amgcyo.cuttadon.view.showcaseview.j.a aVar) {
        this(aVar.a());
    }
}
