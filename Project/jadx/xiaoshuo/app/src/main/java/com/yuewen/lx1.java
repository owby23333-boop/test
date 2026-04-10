package com.yuewen;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.h;
import com.duokan.core.ui.j;
import com.duokan.core.ui.l;

/* JADX INFO: loaded from: classes5.dex */
public class lx1 extends com.duokan.core.ui.l {
    public com.duokan.core.ui.j g = new com.duokan.core.ui.j();
    public com.duokan.core.ui.h h = new com.duokan.core.ui.h();
    public c i;

    public class a implements j.a {
        public a() {
        }

        @Override // com.duokan.core.ui.l.a
        public void K0(View view, PointF pointF) {
        }

        @Override // com.duokan.core.ui.l.a
        public void a1(View view, PointF pointF) {
        }

        @Override // com.duokan.core.ui.l.a
        public void b1(View view, PointF pointF) {
        }

        @Override // com.duokan.core.ui.j.a
        public void h0(com.duokan.core.ui.l lVar, View view, PointF pointF) {
            lx1 lx1Var = lx1.this;
            lx1Var.e(lx1Var.i.Oa(view, pointF));
        }
    }

    public class b implements h.a {
        public b() {
        }

        @Override // com.duokan.core.ui.l.a
        public void K0(View view, PointF pointF) {
        }

        @Override // com.duokan.core.ui.l.a
        public void a1(View view, PointF pointF) {
        }

        @Override // com.duokan.core.ui.l.a
        public void b1(View view, PointF pointF) {
        }

        @Override // com.duokan.core.ui.h.a
        public void d(com.duokan.core.ui.l lVar, View view, PointF pointF, float f) {
            lx1.this.i.Za(view, pointF, f);
            lx1.this.e(true);
        }
    }

    public interface c {
        void K0(View view, PointF pointF);

        boolean Oa(View view, PointF pointF);

        void Za(View view, PointF pointF, float f);

        void a1(View view, PointF pointF);
    }

    public lx1(c cVar) {
        this.i = cVar;
    }

    @Override // com.duokan.core.ui.l
    public void H(View view, MotionEvent motionEvent, boolean z, l.a aVar) {
        this.g.w(view, motionEvent, z, new a());
        this.h.w(view, motionEvent, z, new b());
    }

    @Override // com.duokan.core.ui.l
    public void J(View view, boolean z) {
        this.g.Y(view, z);
        this.h.Y(view, z);
    }
}
