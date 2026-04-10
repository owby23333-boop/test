package com.yuewen;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.l;

/* JADX INFO: loaded from: classes5.dex */
public class i51 extends com.duokan.core.ui.l {
    public long g;
    public float h;
    public float i;
    public a j;

    public interface a {
        void a(MotionEvent motionEvent);
    }

    public i51(a aVar) {
        this.j = aVar;
    }

    @Override // com.duokan.core.ui.l
    public void H(View view, MotionEvent motionEvent, boolean z, l.a aVar) {
        a aVar2;
        int action = motionEvent.getAction() & 255;
        boolean z2 = false;
        if (action == 0) {
            this.g = System.currentTimeMillis();
            T(true);
            this.h = motionEvent.getX();
            this.i = motionEvent.getY();
        } else {
            if (action == 1) {
                if (System.currentTimeMillis() - this.g > M() || !U() || (aVar2 = this.j) == null) {
                    return;
                }
                aVar2.a(motionEvent);
                T(false);
                return;
            }
            if (action != 2) {
                T(false);
            } else {
                int iAbs = (int) Math.abs(motionEvent.getX() - this.h);
                int iAbs2 = (int) Math.abs(motionEvent.getY() - this.i);
                if (iAbs > P(view) || iAbs2 > P(view)) {
                    T(false);
                }
            }
        }
        if (System.currentTimeMillis() - this.g <= M() && motionEvent.getPointerCount() == 1) {
            z2 = true;
        }
        T(z2);
    }

    @Override // com.duokan.core.ui.l
    public void J(View view, boolean z) {
        this.g = 0L;
        this.h = 0.0f;
        this.i = 0.0f;
    }
}
