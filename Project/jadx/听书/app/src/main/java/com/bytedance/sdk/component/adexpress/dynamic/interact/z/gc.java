package com.bytedance.sdk.component.adexpress.dynamic.interact.z;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.interact.gz f571a;
    private boolean dl;
    private float g;
    private int gc;
    private float z;

    public gc(com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar, int i) {
        this.f571a = gzVar;
        this.gc = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.z = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.g = y;
                if (Math.abs(y - this.z) > 10.0f) {
                    this.dl = true;
                }
            }
        } else {
            if (!this.dl) {
                return false;
            }
            int iG = com.bytedance.sdk.component.adexpress.a.gz.g(com.bytedance.sdk.component.adexpress.a.getContext(), Math.abs(this.g - this.z));
            if (this.g - this.z < 0.0f && iG > this.gc && (gzVar = this.f571a) != null) {
                gzVar.z();
                this.z = 0.0f;
                this.g = 0.0f;
                this.dl = false;
            }
        }
        return true;
    }
}
