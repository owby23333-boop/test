package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.l;
import com.yuewen.be4;
import com.yuewen.qt1;

/* JADX INFO: loaded from: classes12.dex */
public class k extends l {
    public static final String n = "HYY-TranslateGesture";
    public final be4 g;
    public float h;
    public float i;
    public float j;
    public int k;
    public int l;
    public int m;

    public interface a extends l.a {
        void c(l lVar, View view, PointF pointF, PointF pointF2);
    }

    public k() {
        this(1.0f);
    }

    @Override // com.duokan.core.ui.l
    public void H(View view, MotionEvent motionEvent, boolean z, l.a aVar) {
        qt1.r(n, "doDetect--->");
        be4 be4Var = new be4(view, motionEvent);
        if (!(aVar instanceof a)) {
            T(false);
            return;
        }
        a aVar2 = (a) aVar;
        qt1.a(n, "doDetect--->motionEvent action-->" + be4Var.d());
        if (be4Var.d() != 2) {
            e0(null);
            return;
        }
        if (this.g.j()) {
            e0(be4Var);
            return;
        }
        if (be4Var.e() > 2 || be4Var.e() != this.g.e()) {
            e0(be4Var);
            return;
        }
        if (be4Var.e() == 1) {
            PointF pointFB = this.g.b(0, new PointF());
            PointF pointFB2 = be4Var.b(0, new PointF());
            pointFB2.offset(-pointFB.x, -pointFB.y);
            int i = this.m;
            if (i < 0) {
                if (Double.compare(Math.pow(pointFB2.x, 2.0d) + Math.pow(pointFB2.y, 2.0d), Math.pow(this.k, 2.0d)) >= 0) {
                    be4Var.m(pointFB);
                    be4Var.l(pointFB2);
                    if (S(new PointF(0.0f, 0.0f), pointFB2, this.i, this.j)) {
                        this.m++;
                    }
                    e0(be4Var);
                    return;
                }
                return;
            }
            int i2 = i + 1;
            this.m = i2;
            if (i2 <= this.l || Double.compare(Math.pow(pointFB2.x, 2.0d) + Math.pow(pointFB2.y, 2.0d), Math.pow(this.h, 2.0d)) < 0) {
                return;
            }
            be4Var.m(pointFB);
            be4Var.l(pointFB2);
            qt1.a(n, "doDetect--->onTranslate");
            aVar2.c(this, be4Var.i(), pointFB, pointFB2);
            e0(be4Var);
            return;
        }
        int iC = be4Var.c(this.g.f(0));
        int iC2 = be4Var.c(this.g.f(1));
        if (iC < 0 || iC2 < 0) {
            T(false);
            return;
        }
        PointF pointFB3 = this.g.b(0, new PointF());
        PointF pointFB4 = this.g.b(1, new PointF());
        PointF pointFB5 = be4Var.b(iC, new PointF());
        PointF pointFB6 = be4Var.b(iC2, new PointF());
        double dH = h(pointFB3, pointFB4);
        double dH2 = h(pointFB5, pointFB6);
        double dJ = j(pointFB3, pointFB4);
        double dJ2 = j(pointFB5, pointFB6);
        if (Math.abs(dH2 - dH) > 10.0d || Math.abs(dJ2 - dJ) > P(be4Var.i())) {
            e0(be4Var);
            return;
        }
        PointF pointF = new PointF((pointFB3.x + pointFB4.x) / 2.0f, (pointFB3.y + pointFB4.y) / 2.0f);
        PointF pointF2 = new PointF((pointFB5.x + pointFB6.x) / 2.0f, (pointFB5.y + pointFB6.y) / 2.0f);
        PointF pointF3 = new PointF(pointF2.x - pointF.x, pointF2.y - pointF.y);
        int i3 = this.m;
        if (i3 < 0) {
            if (Double.compare(Math.pow(pointF3.x, 2.0d) + Math.pow(pointF3.y, 2.0d), Math.pow(this.k, 2.0d)) >= 0) {
                be4Var.m(pointF);
                be4Var.l(pointF3);
                if (S(new PointF(0.0f, 0.0f), pointF3, this.i, this.j)) {
                    this.m++;
                }
                e0(be4Var);
                return;
            }
            return;
        }
        int i4 = i3 + 1;
        this.m = i4;
        if (i4 <= this.l || Double.compare(Math.pow(pointF3.x, 2.0d) + Math.pow(pointF3.y, 2.0d), Math.pow(this.h, 2.0d)) < 0) {
            return;
        }
        be4Var.m(pointF);
        be4Var.l(pointF3);
        aVar2.c(this, be4Var.i(), pointF, pointF3);
        e0(be4Var);
    }

    @Override // com.duokan.core.ui.l
    public void J(View view, boolean z) {
        e0(null);
        this.m = -1;
    }

    public float a0() {
        return this.j;
    }

    public float b0() {
        return this.i;
    }

    public int c0() {
        return this.g.e();
    }

    public void d0(int i) {
        this.l = Math.max(0, i);
    }

    public final void e0(be4 be4Var) {
        this.g.k(be4Var);
    }

    public void f0(float f) {
        this.j = f;
    }

    public void g0(float f) {
        this.i = f;
    }

    public void i0(float f) {
        this.h = f;
    }

    public void j0(int i) {
        this.k = i;
    }

    public k(float f) {
        this.g = new be4();
        this.i = 0.0f;
        this.j = 180.0f;
        this.k = 0;
        this.l = 0;
        this.m = -1;
        this.h = f;
    }
}
