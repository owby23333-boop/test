package com.bytedance.sdk.component.adexpress.dynamic.interact.z;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class m implements View.OnTouchListener {
    private static int dl = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f573a;
    private float g;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.gz gc;
    private float z;

    public m(com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar) {
        this.gc = gzVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.z = motionEvent.getX();
            this.g = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.z) >= dl || Math.abs(y - this.g) >= dl) {
                    this.f573a = true;
                }
            } else if (action == 3) {
                this.f573a = false;
            }
        } else {
            if (this.f573a) {
                this.f573a = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.z) >= dl || Math.abs(y2 - this.g) >= dl) {
                this.f573a = false;
            } else {
                com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar = this.gc;
                if (gzVar != null) {
                    gzVar.z();
                }
            }
        }
        return true;
    }
}
