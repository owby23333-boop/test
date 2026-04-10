package com.amgcyo.cuttadon.view.read.anim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.amgcyo.cuttadon.view.read.anim.PageAnimation;

/* JADX INFO: compiled from: HorizonPageAnim.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends PageAnimation {
    private boolean A;
    private boolean B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected Bitmap f5216u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected Bitmap f5217v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected boolean f5218w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f5219x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f5220y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f5221z;

    public c(int i2, int i3, View view, PageAnimation.a aVar) {
        this(i2, i3, 0, 0, view, aVar);
    }

    public void a(boolean z2) {
        this.f5200q = z2;
    }

    public abstract void b(Canvas canvas);

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public Bitmap c() {
        return this.f5217v;
    }

    public abstract void c(Canvas canvas);

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public Bitmap d() {
        return this.f5217v;
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void f() {
        if (this.b.computeScrollOffset()) {
            int currX = this.b.getCurrX();
            int currY = this.b.getCurrY();
            b(currX, currY);
            if (this.b.getFinalX() == currX && this.b.getFinalY() == currY) {
                this.f5188e = false;
            }
            this.a.postInvalidate();
        }
    }

    public void h() {
        Bitmap bitmap = this.f5216u;
        this.f5216u = this.f5217v;
        this.f5217v = bitmap;
    }

    public c(int i2, int i3, int i4, int i5, View view, PageAnimation.a aVar) {
        super(i2, i3, i4, i5, view, aVar);
        this.f5218w = false;
        this.f5219x = 0;
        this.f5220y = 0;
        this.f5221z = false;
        this.A = false;
        this.B = false;
        this.f5216u = Bitmap.createBitmap(this.f5193j, this.f5194k, Bitmap.Config.RGB_565);
        this.f5217v = Bitmap.createBitmap(this.f5193j, this.f5194k, Bitmap.Config.RGB_565);
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public boolean a(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        float f2 = x2;
        float f3 = y2;
        b(f2, f3);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5219x = 0;
            this.f5220y = 0;
            this.f5221z = false;
            this.B = false;
            this.A = false;
            this.f5188e = false;
            this.f5218w = false;
            a(f2, f3);
            a();
        } else if (action == 1) {
            if (!this.f5221z) {
                this.A = x2 >= this.f5189f / 2 || this.f5200q;
                if (this.A) {
                    boolean zHasNext = this.f5186c.hasNext();
                    a(PageAnimation.Direction.NEXT);
                    if (!zHasNext) {
                        return true;
                    }
                } else {
                    boolean zA = this.f5186c.a();
                    a(PageAnimation.Direction.PRE);
                    if (!zA) {
                        return true;
                    }
                }
            }
            if (this.f5218w) {
                this.f5186c.b();
            }
            if (!this.B) {
                g();
                this.a.invalidate();
            }
        } else if (action == 2) {
            int scaledTouchSlop = ViewConfiguration.get(this.a.getContext()).getScaledTouchSlop();
            if (!this.f5221z) {
                float f4 = scaledTouchSlop;
                this.f5221z = Math.abs(this.f5195l - f2) > f4 || Math.abs(this.f5196m - f3) > f4;
            }
            if (this.f5221z) {
                if (this.f5219x == 0 && this.f5220y == 0) {
                    if (f2 - this.f5195l > 0.0f) {
                        this.A = false;
                        boolean zA2 = this.f5186c.a();
                        a(PageAnimation.Direction.PRE);
                        if (!zA2) {
                            this.B = true;
                            return true;
                        }
                    } else {
                        this.A = true;
                        boolean zHasNext2 = this.f5186c.hasNext();
                        a(PageAnimation.Direction.NEXT);
                        if (!zHasNext2) {
                            this.B = true;
                            return true;
                        }
                    }
                } else if (this.A) {
                    if (x2 - this.f5219x > 0) {
                        this.f5218w = true;
                    } else {
                        this.f5218w = false;
                    }
                } else if (x2 - this.f5219x < 0) {
                    this.f5218w = true;
                } else {
                    this.f5218w = false;
                }
                this.f5219x = x2;
                this.f5220y = y2;
                this.f5188e = true;
                this.a.invalidate();
            }
        }
        return true;
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void a(Canvas canvas) {
        if (this.f5188e) {
            b(canvas);
            return;
        }
        if (this.f5218w) {
            this.f5217v = this.f5216u.copy(Bitmap.Config.RGB_565, true);
        }
        c(canvas);
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void a() {
        if (this.b.isFinished()) {
            return;
        }
        this.b.abortAnimation();
        this.f5188e = false;
        b(this.b.getFinalX(), this.b.getFinalY());
        this.a.postInvalidate();
    }
}
