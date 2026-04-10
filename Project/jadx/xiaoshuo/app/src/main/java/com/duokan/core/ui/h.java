package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.l;
import com.yuewen.be4;

/* JADX INFO: loaded from: classes12.dex */
public class h extends l {
    public final be4 g = new be4();
    public float h = 0.0f;
    public int i = 0;
    public boolean j = false;

    public interface a extends l.a {
        void d(l lVar, View view, PointF pointF, float f);
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
        double dJ = j(this.g.b(0, new PointF()), this.g.b(1, new PointF()));
        double dJ2 = j(be4Var.b(0, new PointF()), be4Var.b(1, new PointF()));
        if (!this.j) {
            if (Math.abs(dJ2 - dJ) > this.i) {
                a0(be4Var);
                this.j = true;
                return;
            }
            return;
        }
        float f = (float) (dJ2 / dJ);
        PointF pointF = new PointF((be4Var.g(0) + be4Var.g(1)) / 2.0f, (be4Var.h(0) + be4Var.h(1)) / 2.0f);
        be4Var.m(pointF);
        if (Float.compare(Math.abs(f - 1.0f), this.h) >= 0) {
            aVar2.d(this, view, pointF, f);
            a0(be4Var);
        }
    }

    @Override // com.duokan.core.ui.l
    public void J(View view, boolean z) {
        a0(null);
        this.j = false;
    }

    public final void a0(be4 be4Var) {
        this.g.k(be4Var);
    }

    public void b0(float f) {
        this.h = f;
    }

    public void c0(int i) {
        this.i = i;
    }
}
