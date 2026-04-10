package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.f;
import com.bytedance.sdk.openadsdk.core.iq.zw;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class SiteGestureView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f1276a;
    private float dl;
    private long e;
    private f g;
    private float gc;
    private float m;
    private tb z;

    public SiteGestureView(Context context, f fVar, tb tbVar) {
        super(context);
        this.g = fVar;
        this.z = tbVar;
        setTag(2097610717, "click");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.dl = oq.a(getContext(), motionEvent.getX());
            this.f1276a = oq.a(getContext(), motionEvent.getY());
            this.gc = motionEvent.getRawX();
            this.m = motionEvent.getRawY();
            this.e = System.currentTimeMillis();
            this.z.z(motionEvent);
            if (this.g.g() == -1) {
                com.bytedance.sdk.component.utils.wp.z("xdy", "nt ad");
                return false;
            }
            if (!this.z.dl()) {
                com.bytedance.sdk.component.utils.wp.z("xdy", "un ad");
                return false;
            }
        } else {
            if (action == 1) {
                this.z.g();
                float fA = oq.a(getContext(), motionEvent.getX());
                float fA2 = oq.a(getContext(), motionEvent.getY());
                if (this.g.dl() == 0.0d) {
                    com.bytedance.sdk.component.utils.wp.z("xdy", "nh g");
                    g(-1, motionEvent);
                    return true;
                }
                float f = fA - this.dl;
                float f2 = fA2 - this.f1276a;
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(f2);
                if (fAbs <= 3.0f && fAbs2 <= 3.0f) {
                    com.bytedance.sdk.component.utils.wp.z("xdy", "c ad");
                    this.z.z(motionEvent);
                    return true;
                }
                double dDl = this.g.dl();
                int iA = this.g.a();
                if (fAbs > fAbs2) {
                    if (fAbs > dDl) {
                        long j = iA;
                        if (com.bytedance.sdk.openadsdk.core.tb.g.z(j, 2L) && f < 0.0f) {
                            return z(2, motionEvent);
                        }
                        if (com.bytedance.sdk.openadsdk.core.tb.g.z(j, 4L) && f > 0.0f) {
                            return z(4, motionEvent);
                        }
                    }
                } else if (fAbs2 > dDl) {
                    long j2 = iA;
                    if (com.bytedance.sdk.openadsdk.core.tb.g.z(j2, 8L) && f2 < 0.0f) {
                        return z(8, motionEvent);
                    }
                    if (com.bytedance.sdk.openadsdk.core.tb.g.z(j2, 16L) && f2 > 0.0f) {
                        return z(16, motionEvent);
                    }
                }
                return false;
            }
            if (action == 3) {
                com.bytedance.sdk.component.utils.wp.z("xdy", "gesture cancel");
            }
        }
        return true;
    }

    private boolean z(int i, MotionEvent motionEvent) {
        if (this.g.z() == 1 && this.z.z()) {
            com.bytedance.sdk.component.utils.wp.z("xdy", i + " ad");
            this.z.z(motionEvent);
            return false;
        }
        com.bytedance.sdk.component.utils.wp.z("xdy", i + " site");
        g(i, motionEvent);
        return true;
    }

    private void g(int i, MotionEvent motionEvent) {
        int[] iArrZ = oq.z(this);
        com.bytedance.sdk.openadsdk.core.iq.zw zwVarZ = new zw.z().z("express_gesture_view").a(this.gc).dl(this.m).g(motionEvent.getRawX()).z(motionEvent.getRawY()).g(this.e).dl(getWidth()).a(getHeight()).z(iArrZ == null ? 0 : iArrZ[0]).g(iArrZ != null ? iArrZ[1] : 0).z(true).z(System.currentTimeMillis()).z();
        this.g.z(i);
        this.z.z(this, 1, zwVarZ, this.g);
    }
}
