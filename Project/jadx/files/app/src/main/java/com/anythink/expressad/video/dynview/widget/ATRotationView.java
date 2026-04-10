package com.anythink.expressad.video.dynview.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class ATRotationView extends FrameLayout {
    Runnable a;
    private Camera b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Matrix f11717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f11725k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f11726l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f11727m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f11728n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f11729o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f11730p;

    public ATRotationView(Context context) {
        super(context);
        this.f11720f = 40;
        this.f11721g = 20;
        this.f11722h = 0;
        this.f11723i = 0;
        this.f11725k = 0;
        this.f11726l = 0.5f;
        this.f11727m = 0.9f;
        this.f11728n = true;
        this.f11729o = false;
        this.f11730p = false;
        this.a = new Runnable() { // from class: com.anythink.expressad.video.dynview.widget.ATRotationView.1
            @Override // java.lang.Runnable
            public final void run() {
                ATRotationView.a(ATRotationView.this);
            }
        };
        a();
    }

    private void a() {
        this.b = new Camera();
        this.f11717c = new Matrix();
        setWillNotDraw(false);
    }

    private void b(Canvas canvas) {
        int height = getHeight() / 2;
        int i2 = ((this.f11722h * this.f11718d) / 2) / this.f11720f;
        a(canvas, i2, height, 0);
        a(canvas, i2, height, 1);
        if (Math.abs(this.f11722h) > this.f11720f / 2) {
            a(canvas, i2, height, 3);
            a(canvas, i2, height, 2);
        } else {
            a(canvas, i2, height, 2);
            a(canvas, i2, height, 3);
        }
    }

    private void c(int i2) {
        this.f11723i = i2;
        int iA = Math.abs(this.f11722h) > this.f11720f / 2 ? a(2) : a(3);
        if (this.f11725k != iA) {
            this.f11725k = iA;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (getChildCount() == 0) {
            return;
        }
        if (this.f11729o) {
            int height = getHeight() / 2;
            int i2 = ((this.f11722h * this.f11718d) / 2) / this.f11720f;
            a(canvas, i2, height, 0);
            a(canvas, i2, height, 1);
            if (Math.abs(this.f11722h) > this.f11720f / 2) {
                a(canvas, i2, height, 3);
                a(canvas, i2, height, 2);
                return;
            } else {
                a(canvas, i2, height, 2);
                a(canvas, i2, height, 3);
                return;
            }
        }
        int width = getWidth() / 2;
        int i3 = ((this.f11722h * this.f11719e) / 2) / this.f11720f;
        b(canvas, i3, width, 0);
        b(canvas, i3, width, 1);
        if (Math.abs(this.f11722h) > this.f11720f / 2) {
            b(canvas, i3, width, 3);
            b(canvas, i3, width, 2);
        } else {
            b(canvas, i3, width, 2);
            b(canvas, i3, width, 3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        float f2 = i6;
        float f3 = this.f11726l;
        int i7 = (int) (((1.0f - f3) * f2) / 2.0f);
        int i8 = i5 - i3;
        float f4 = i8;
        float f5 = this.f11727m;
        int i9 = (int) (((1.0f - f5) * f4) / 2.0f);
        this.f11718d = (int) (f4 * f5);
        this.f11719e = (int) (f2 * f3);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            childAt.layout(i7, i9, i6 - i7, i8 - i9);
            childAt.setClickable(true);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i11 = layoutParams.width;
            int i12 = this.f11719e;
            if (i11 != i12) {
                layoutParams.width = i12;
                layoutParams.height = this.f11718d;
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    public void setAutoscroll(boolean z2) {
        if (z2) {
            postDelayed(this.a, 1000 / this.f11721g);
        }
        this.f11728n = z2;
    }

    public void setHeightRatio(float f2) {
        this.f11727m = f2;
    }

    public void setRotateV(boolean z2) {
        this.f11729o = z2;
        invalidate();
    }

    public void setWidthRatio(float f2) {
        this.f11726l = f2;
    }

    private void a(Canvas canvas) {
        int width = getWidth() / 2;
        int i2 = ((this.f11722h * this.f11719e) / 2) / this.f11720f;
        b(canvas, i2, width, 0);
        b(canvas, i2, width, 1);
        if (Math.abs(this.f11722h) > this.f11720f / 2) {
            b(canvas, i2, width, 3);
            b(canvas, i2, width, 2);
        } else {
            b(canvas, i2, width, 2);
            b(canvas, i2, width, 3);
        }
    }

    private void b() {
        int iA;
        if (getChildCount() == 0) {
            return;
        }
        this.f11722h--;
        this.f11724j = this.f11723i;
        int i2 = this.f11722h;
        int i3 = this.f11720f;
        int i4 = this.f11724j - (i2 / i3);
        this.f11722h = i2 % i3;
        this.f11723i = i4;
        if (Math.abs(this.f11722h) > this.f11720f / 2) {
            iA = a(2);
        } else {
            iA = a(3);
        }
        if (this.f11725k != iA) {
            this.f11725k = iA;
        }
        invalidate();
        if (this.f11728n) {
            postDelayed(this.a, 1000 / this.f11721g);
        }
    }

    private void a(int i2, int i3, int i4) {
        float f2 = (-i2) / 2.0f;
        if (i4 == 0) {
            this.b.translate(0.0f, f2, 0.0f);
            float f3 = -i3;
            this.b.rotateX(f3);
            this.b.translate(0.0f, f2, 0.0f);
            this.b.translate(0.0f, f2, 0.0f);
            this.b.rotateX(f3);
            this.b.translate(0.0f, f2, 0.0f);
            return;
        }
        if (i4 == 1) {
            this.b.translate(0.0f, f2, 0.0f);
            this.b.rotateX(i3);
            this.b.translate(0.0f, f2, 0.0f);
        } else if (i4 != 2) {
            if (i4 != 3) {
                return;
            }
            this.b.rotateX(0.0f);
        } else {
            this.b.translate(0.0f, f2, 0.0f);
            this.b.rotateX(-i3);
            this.b.translate(0.0f, f2, 0.0f);
        }
    }

    public ATRotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11720f = 40;
        this.f11721g = 20;
        this.f11722h = 0;
        this.f11723i = 0;
        this.f11725k = 0;
        this.f11726l = 0.5f;
        this.f11727m = 0.9f;
        this.f11728n = true;
        this.f11729o = false;
        this.f11730p = false;
        this.a = new Runnable() { // from class: com.anythink.expressad.video.dynview.widget.ATRotationView.1
            @Override // java.lang.Runnable
            public final void run() {
                ATRotationView.a(ATRotationView.this);
            }
        };
        a();
    }

    private void a(Canvas canvas, int i2, int i3, int i4) {
        canvas.save();
        this.b.save();
        this.f11717c.reset();
        float f2 = i2;
        this.b.translate(0.0f, f2, 0.0f);
        this.b.rotateX(this.f11722h);
        this.b.translate(0.0f, f2, 0.0f);
        if (i2 == 0) {
            if (this.f11730p) {
                a(this.f11718d, this.f11720f, i4);
            } else {
                a(-this.f11718d, -this.f11720f, i4);
            }
        } else if (i2 > 0) {
            a(this.f11718d, this.f11720f, i4);
        } else if (i2 < 0) {
            a(-this.f11718d, -this.f11720f, i4);
        }
        this.b.getMatrix(this.f11717c);
        this.b.restore();
        this.f11717c.preTranslate((-getWidth()) / 2, -i3);
        this.f11717c.postTranslate(getWidth() / 2, i3);
        canvas.concat(this.f11717c);
        View childAt = getChildAt(a(i4));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    private void b(int i2) {
        int iA;
        int i3 = this.f11720f;
        int i4 = this.f11724j - (i2 / i3);
        this.f11722h = i2 % i3;
        this.f11723i = i4;
        if (Math.abs(this.f11722h) > this.f11720f / 2) {
            iA = a(2);
        } else {
            iA = a(3);
        }
        if (this.f11725k != iA) {
            this.f11725k = iA;
        }
        invalidate();
    }

    public ATRotationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11720f = 40;
        this.f11721g = 20;
        this.f11722h = 0;
        this.f11723i = 0;
        this.f11725k = 0;
        this.f11726l = 0.5f;
        this.f11727m = 0.9f;
        this.f11728n = true;
        this.f11729o = false;
        this.f11730p = false;
        this.a = new Runnable() { // from class: com.anythink.expressad.video.dynview.widget.ATRotationView.1
            @Override // java.lang.Runnable
            public final void run() {
                ATRotationView.a(ATRotationView.this);
            }
        };
        a();
    }

    private void b(int i2, int i3, int i4) {
        if (i4 == 0) {
            float f2 = (-i2) / 2;
            this.b.translate(f2, 0.0f, 0.0f);
            float f3 = -i3;
            this.b.rotateY(f3);
            this.b.translate(f2, 0.0f, 0.0f);
            this.b.translate(f2, 0.0f, 0.0f);
            this.b.rotateY(f3);
            this.b.translate(f2, 0.0f, 0.0f);
            return;
        }
        if (i4 == 1) {
            float f4 = i2 / 2;
            this.b.translate(f4, 0.0f, 0.0f);
            this.b.rotateY(i3);
            this.b.translate(f4, 0.0f, 0.0f);
            return;
        }
        if (i4 != 2) {
            if (i4 != 3) {
                return;
            }
            this.b.rotateY(0.0f);
        } else {
            float f5 = (-i2) / 2;
            this.b.translate(f5, 0.0f, 0.0f);
            this.b.rotateY(-i3);
            this.b.translate(f5, 0.0f, 0.0f);
        }
    }

    private int a(int i2) {
        int i3;
        int i4;
        int i5;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    i3 = i2 != 3 ? 0 : this.f11723i;
                } else if (this.f11730p) {
                    i4 = this.f11723i;
                    i3 = i4 - 1;
                } else {
                    i5 = this.f11723i;
                    i3 = i5 + 1;
                }
            } else if (this.f11730p) {
                i5 = this.f11723i;
                i3 = i5 + 1;
            } else {
                i4 = this.f11723i;
                i3 = i4 - 1;
            }
        } else if (this.f11730p) {
            i3 = this.f11723i - 2;
        } else {
            i3 = this.f11723i + 2;
        }
        int childCount = i3 % getChildCount();
        return childCount >= 0 ? childCount : childCount + getChildCount();
    }

    private void b(Canvas canvas, int i2, int i3, int i4) {
        canvas.save();
        this.b.save();
        this.f11717c.reset();
        float f2 = i2;
        this.b.translate(f2, 0.0f, 0.0f);
        this.b.rotateY(this.f11722h);
        this.b.translate(f2, 0.0f, 0.0f);
        if (i2 == 0) {
            if (this.f11730p) {
                b(this.f11719e, this.f11720f, i4);
            } else {
                b(-this.f11719e, -this.f11720f, i4);
            }
        } else if (i2 > 0) {
            b(this.f11719e, this.f11720f, i4);
        } else if (i2 < 0) {
            b(-this.f11719e, -this.f11720f, i4);
        }
        this.b.getMatrix(this.f11717c);
        this.b.restore();
        this.f11717c.preTranslate(-i3, (-getHeight()) / 2);
        this.f11717c.postTranslate(i3, getHeight() / 2);
        canvas.concat(this.f11717c);
        View childAt = getChildAt(a(i4));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    static /* synthetic */ void a(ATRotationView aTRotationView) {
        int iA;
        if (aTRotationView.getChildCount() != 0) {
            aTRotationView.f11722h--;
            aTRotationView.f11724j = aTRotationView.f11723i;
            int i2 = aTRotationView.f11722h;
            int i3 = aTRotationView.f11720f;
            int i4 = aTRotationView.f11724j - (i2 / i3);
            aTRotationView.f11722h = i2 % i3;
            aTRotationView.f11723i = i4;
            if (Math.abs(aTRotationView.f11722h) > aTRotationView.f11720f / 2) {
                iA = aTRotationView.a(2);
            } else {
                iA = aTRotationView.a(3);
            }
            if (aTRotationView.f11725k != iA) {
                aTRotationView.f11725k = iA;
            }
            aTRotationView.invalidate();
            if (aTRotationView.f11728n) {
                aTRotationView.postDelayed(aTRotationView.a, 1000 / aTRotationView.f11721g);
            }
        }
    }
}
