package com.bytedance.sdk.component.adexpress.dynamic.interact.z;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;

/* JADX INFO: loaded from: classes2.dex */
public class g implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f570a;
    private long dl;
    private float g;
    private InteractViewContainer gc;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.gz m;
    private float z;

    public g(InteractViewContainer interactViewContainer, com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar) {
        this.gc = interactViewContainer;
        this.m = gzVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.dl = System.currentTimeMillis();
            this.z = motionEvent.getX();
            this.g = motionEvent.getY();
            this.gc.gc();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.z) >= com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), 10.0f) || Math.abs(y - this.g) >= com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), 10.0f)) {
                    this.f570a = true;
                    this.gc.m();
                }
            }
        } else {
            if (this.f570a) {
                return false;
            }
            if (System.currentTimeMillis() - this.dl >= 1500) {
                com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar = this.m;
                if (gzVar != null) {
                    gzVar.z();
                }
            } else {
                this.gc.m();
            }
        }
        return true;
    }
}
