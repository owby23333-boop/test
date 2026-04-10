package com.bytedance.sdk.component.adexpress.dynamic.interact.e;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ga implements View.OnTouchListener {
    private float bf;
    private boolean d;
    private float e;
    private int ga;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.p tg;

    public ga(com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar, int i) {
        this.tg = pVar;
        this.ga = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.bf = y;
                if (Math.abs(y - this.e) > 10.0f) {
                    this.d = true;
                }
            }
        } else {
            if (!this.d) {
                return false;
            }
            int iBf = com.bytedance.sdk.component.adexpress.d.bf.bf(com.bytedance.sdk.component.adexpress.tg.getContext(), Math.abs(this.bf - this.e));
            if (this.bf - this.e < 0.0f && iBf > this.ga && (pVar = this.tg) != null) {
                pVar.e();
            }
        }
        return true;
    }
}
