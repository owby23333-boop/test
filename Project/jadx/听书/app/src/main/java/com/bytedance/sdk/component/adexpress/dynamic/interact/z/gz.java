package com.bytedance.sdk.component.adexpress.dynamic.interact.z;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class gz implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f572a;
    private final int dl = 10;
    private float e;
    private final boolean g;
    private float gc;
    private float m;
    private final com.bytedance.sdk.component.adexpress.dynamic.interact.gz z;

    public gz(com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar, boolean z) {
        this.z = gzVar;
        this.g = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f572a = motionEvent.getX();
            this.gc = motionEvent.getY();
            new Object[]{"mStartX: ", Float.valueOf(this.f572a), ", mStartY: " + this.gc};
        } else if (action == 1) {
            this.m = motionEvent.getX();
            this.e = motionEvent.getY();
            new Object[]{"mEndX: ", Float.valueOf(this.m), ", mEndY: " + this.e};
            if (!this.g && (gzVar2 = this.z) != null) {
                gzVar2.z();
            } else {
                float f = this.m - this.f572a;
                float f2 = this.e - this.gc;
                float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
                new Object[]{"slideDistancePx: ", Float.valueOf(fSqrt)};
                float fG = com.bytedance.sdk.component.adexpress.a.gz.g(com.bytedance.sdk.component.adexpress.a.getContext(), Math.abs(fSqrt));
                new Object[]{"slideDistanceDp:", Float.valueOf(fG), " and ", "mSlideThreshold:", 10};
                if (fG > 10.0f && (gzVar = this.z) != null) {
                    gzVar.z();
                }
            }
        }
        return true;
    }
}
