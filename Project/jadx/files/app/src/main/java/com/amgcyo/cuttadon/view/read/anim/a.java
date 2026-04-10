package com.amgcyo.cuttadon.view.read.anim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.amgcyo.cuttadon.view.read.anim.PageAnimation;

/* JADX INFO: compiled from: AutoPageAnim.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends PageAnimation {
    private boolean A;
    private int B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Rect f5210u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Rect f5211v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private GradientDrawable f5212w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected Bitmap f5213x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected Bitmap f5214y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected boolean f5215z;

    public a(int i2, int i3, View view, PageAnimation.a aVar) {
        this(i2, i3, 0, 0, view, aVar);
    }

    private void a(int i2, Canvas canvas) {
        this.f5212w.setBounds(0, i2, this.f5189f, i2 + 20);
        this.f5212w.draw(canvas);
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void a() {
    }

    public void b(Canvas canvas) {
        if (this.f5202s) {
            this.f5210u.bottom += Math.abs(this.f5201r);
            this.f5211v.bottom += Math.abs(this.f5201r);
            if (this.f5210u.bottom >= this.f5190g) {
                this.f5203t = this.f5186c.hasNext();
                this.f5210u.bottom = 0;
                this.f5211v.bottom = 0;
            }
        } else {
            Rect rect = this.f5210u;
            float f2 = this.f5198o;
            rect.bottom = (int) f2;
            this.f5211v.bottom = (int) f2;
        }
        if (!this.f5203t) {
            c(canvas);
            return;
        }
        canvas.drawBitmap(this.f5213x, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(this.f5214y, this.f5210u, this.f5211v, (Paint) null);
        a(this.f5210u.bottom, canvas);
    }

    public void c(Canvas canvas) {
        if (!this.f5215z) {
            canvas.drawBitmap(this.f5214y, 0.0f, 0.0f, (Paint) null);
        } else {
            this.f5214y = this.f5213x.copy(Bitmap.Config.RGB_565, true);
            canvas.drawBitmap(this.f5213x, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public Bitmap d() {
        return this.f5214y;
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void f() {
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void g() {
    }

    public void h() {
        Bitmap bitmap = this.f5213x;
        this.f5213x = this.f5214y;
        this.f5214y = bitmap;
    }

    public a(int i2, int i3, int i4, int i5, View view, PageAnimation.a aVar) {
        super(i2, i3, i4, i5, view, aVar);
        this.f5215z = false;
        this.A = false;
        this.B = 0;
        this.f5210u = new Rect(0, 0, this.f5193j, this.f5194k);
        this.f5211v = new Rect(0, 0, this.f5193j, this.f5194k);
        this.f5213x = Bitmap.createBitmap(this.f5193j, this.f5194k, Bitmap.Config.RGB_565);
        this.f5214y = Bitmap.createBitmap(this.f5193j, this.f5194k, Bitmap.Config.RGB_565);
        this.f5212w = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1711276032, 0});
        this.f5212w.setGradientType(0);
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public boolean a(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.A = false;
            this.f5215z = false;
            b(x2, this.f5210u.bottom);
            this.B = this.f5210u.bottom - y2;
            this.a.postInvalidate();
        } else if (action == 2) {
            float f2 = x2;
            b(f2, this.B + y2);
            int scaledTouchSlop = ViewConfiguration.get(this.a.getContext()).getScaledTouchSlop();
            if (!this.A) {
                float f3 = scaledTouchSlop;
                this.A = Math.abs(this.f5195l - f2) > f3 || Math.abs(this.f5196m - ((float) y2)) > f3;
            }
            if (this.A) {
                this.f5188e = true;
                this.a.postInvalidate();
            }
        }
        return true;
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public Bitmap c() {
        return this.f5214y;
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void a(Canvas canvas) {
        b(canvas);
    }
}
