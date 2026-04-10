package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.l;
import com.yuewen.be4;

/* JADX INFO: loaded from: classes12.dex */
public class g extends l {
    public final be4 g = new be4();
    public float h = 0.0f;

    public interface a extends l.a {
        void A(View view, PointF pointF, float f);
    }

    @Override // com.duokan.core.ui.l
    public void H(View view, MotionEvent motionEvent, boolean z, l.a aVar) {
        be4 be4Var = new be4(view, motionEvent);
        if (!(aVar instanceof a)) {
            T(false);
            return;
        }
        a aVar2 = (a) aVar;
        if (be4Var.d() != 2) {
            a0(null);
            return;
        }
        if (be4Var.e() != 2) {
            a0(null);
            return;
        }
        if (this.g.j()) {
            a0(be4Var);
            return;
        }
        int iC = be4Var.c(this.g.f(0));
        int iC2 = be4Var.c(this.g.f(1));
        if (iC < 0 || iC2 < 0) {
            T(false);
            return;
        }
        PointF pointFB = this.g.b(0, new PointF());
        PointF pointFB2 = this.g.b(1, new PointF());
        PointF pointFB3 = be4Var.b(iC, new PointF());
        PointF pointFB4 = be4Var.b(iC2, new PointF());
        double dH = h(pointFB, pointFB2);
        double dH2 = h(pointFB3, pointFB4);
        PointF pointF = new PointF((pointFB3.x + pointFB4.x) / 2.0f, (pointFB3.y + pointFB4.y) / 2.0f);
        be4Var.m(pointF);
        float fV = (float) V(dH2 - dH, -180.0d, 180.0d);
        if (Float.compare(Math.abs(fV), this.h) >= 0) {
            aVar2.A(view, pointF, fV);
            a0(be4Var);
        }
    }

    @Override // com.duokan.core.ui.l
    public void J(View view, boolean z) {
        a0(null);
    }

    public final void a0(be4 be4Var) {
        this.g.k(be4Var);
    }

    public void b0(float f) {
        this.h = f;
    }
}
