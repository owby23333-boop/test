package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.yuewen.w51;

/* JADX INFO: loaded from: classes12.dex */
public abstract class l {
    public static final /* synthetic */ boolean f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2994a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2995b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = true;

    public interface a {
        void K0(View view, PointF pointF);

        void a1(View view, PointF pointF);

        void b1(View view, PointF pointF);
    }

    public final void B(View view, MotionEvent motionEvent, boolean z, boolean z2, a aVar) {
        if (this.e) {
            this.c = false;
            if (this.f2994a) {
                if (z2) {
                    I(view, motionEvent, z, aVar);
                } else {
                    H(view, motionEvent, z, aVar);
                }
            }
        }
    }

    public int C(View view, int i) {
        return Math.round(view.getContext().getResources().getDisplayMetrics().density * i);
    }

    public void G(View view) {
        T(false);
    }

    public abstract void H(View view, MotionEvent motionEvent, boolean z, a aVar);

    public void I(View view, MotionEvent motionEvent, boolean z, a aVar) {
    }

    public abstract void J(View view, boolean z);

    public final boolean K() {
        return this.e;
    }

    public long L() {
        return ViewConfiguration.getJumpTapTimeout();
    }

    public int M() {
        return ViewConfiguration.getLongPressTimeout();
    }

    public int N(View view) {
        return ViewConfiguration.get(view.getContext()).getScaledMaximumFlingVelocity();
    }

    public int O(View view) {
        return ViewConfiguration.get(view.getContext()).getScaledMinimumFlingVelocity();
    }

    public int P(View view) {
        return ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
    }

    public final void Q(boolean z) {
        this.f2995b = z;
        if (z) {
            this.f2994a = true;
        }
    }

    public final boolean R() {
        if (this.e) {
            return this.f2995b;
        }
        return false;
    }

    public boolean S(PointF pointF, PointF pointF2, double d, double d2) {
        double d3 = d + 360.0d;
        double dV = V(k(pointF, pointF2), d, d3);
        if (Double.compare(dV, d) >= 0 && Double.compare(dV, d2) <= 0) {
            return true;
        }
        double dV2 = V(180.0d - k(pointF, pointF2), d, d3);
        return Double.compare(dV2, d) >= 0 && Double.compare(dV2, d2) <= 0;
    }

    public final void T(boolean z) {
        this.f2994a = z;
        if (z) {
            return;
        }
        this.f2995b = false;
        this.d = false;
    }

    public final boolean U() {
        if (this.e) {
            return this.f2994a;
        }
        return false;
    }

    public double V(double d, double d2, double d3) {
        while (true) {
            if (d >= d2 && d <= d3) {
                return d;
            }
            d = Double.compare(d, d2) < 0 ? d + 360.0d : d - 360.0d;
        }
    }

    public int W(int i, int i2, int i3) {
        return (int) V(i, i2, i3);
    }

    public void X(View view, MotionEvent motionEvent) {
    }

    public final void Y(View view, boolean z) {
        this.f2994a = true;
        this.c = false;
        this.f2995b = false;
        this.d = false;
        J(view, z);
    }

    public final void Z(boolean z) {
        this.e = z;
    }

    public final void e(boolean z) {
        this.c = z;
    }

    public final boolean g() {
        if (this.e) {
            return this.c;
        }
        return false;
    }

    public double h(PointF pointF, PointF pointF2) {
        return Math.toDegrees(o(pointF, pointF2));
    }

    public double j(PointF pointF, PointF pointF2) {
        return Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
    }

    public double k(PointF pointF, PointF pointF2) {
        double dH = h(pointF, pointF2);
        return Double.compare(dH, 180.0d) > 0 ? dH - 180.0d : dH;
    }

    public double o(PointF pointF, PointF pointF2) {
        PointF pointF3 = new PointF(pointF.x, -pointF.y);
        PointF pointF4 = new PointF(pointF2.x, -pointF2.y);
        float f2 = pointF4.x;
        float f3 = pointF3.x;
        if (f2 == f3) {
            return pointF4.y > pointF3.y ? 1.5707963267948966d : 4.71238898038469d;
        }
        float f4 = pointF4.y;
        float f5 = pointF3.y;
        if (f4 == f5) {
            if (f2 > f3) {
                return w51.l;
            }
            return 3.141592653589793d;
        }
        double dAtan = Math.atan(((double) (f4 - f5)) / ((double) (f2 - f3)));
        float f6 = pointF4.x;
        float f7 = pointF3.x;
        return (f6 >= f7 || pointF4.y <= pointF3.y) ? (f6 >= f7 || pointF4.y >= pointF3.y) ? (f6 <= f7 || pointF4.y >= pointF3.y) ? dAtan : dAtan + 6.283185307179586d : dAtan + 3.141592653589793d : dAtan + 3.141592653589793d;
    }

    public final void p(boolean z) {
        this.d = z;
    }

    public final boolean s() {
        if (this.e) {
            return this.d;
        }
        return false;
    }

    public final void w(View view, MotionEvent motionEvent, boolean z, a aVar) {
        B(view, motionEvent, z, false, aVar);
    }
}
