package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.l;
import com.yuewen.e84;

/* JADX INFO: loaded from: classes12.dex */
public class j extends l {
    public MotionEvent g = null;

    public interface a extends l.a {
        void h0(l lVar, View view, PointF pointF);
    }

    @Override // com.duokan.core.ui.l
    public void H(View view, MotionEvent motionEvent, boolean z, l.a aVar) {
        if (!(aVar instanceof a)) {
            T(false);
            return;
        }
        a aVar2 = (a) aVar;
        if (this.g == null) {
            if (motionEvent.getPointerCount() == 1) {
                a0(motionEvent);
            }
        } else {
            if (motionEvent.getPointerCount() > 1) {
                T(false);
                return;
            }
            if (motionEvent.getEventTime() - this.g.getEventTime() > e84.U()) {
                T(false);
                return;
            }
            PointF pointF = new PointF(this.g.getX(), this.g.getY());
            PointF pointF2 = new PointF(motionEvent.getX(), motionEvent.getY());
            if (j(pointF, pointF2) > P(view)) {
                T(false);
            } else if (motionEvent.getAction() == 1) {
                aVar2.h0(this, view, pointF2);
            }
        }
    }

    @Override // com.duokan.core.ui.l
    public void J(View view, boolean z) {
        a0(null);
    }

    public final void a0(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.g;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.g = null;
        }
        if (motionEvent != null) {
            this.g = MotionEvent.obtain(motionEvent);
        }
    }
}
