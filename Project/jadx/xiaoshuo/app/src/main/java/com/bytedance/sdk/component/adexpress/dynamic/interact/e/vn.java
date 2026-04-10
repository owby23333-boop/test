package com.bytedance.sdk.component.adexpress.dynamic.interact.e;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class vn implements View.OnTouchListener {
    private static int d = 10;
    private float bf;
    private float e;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.p ga;
    private boolean tg;

    public vn(com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar) {
        this.ga = pVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e = motionEvent.getX();
            this.bf = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.e) >= d || Math.abs(y - this.bf) >= d) {
                    this.tg = true;
                }
            } else if (action == 3) {
                this.tg = false;
            }
        } else {
            if (this.tg) {
                this.tg = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.e) >= d || Math.abs(y2 - this.bf) >= d) {
                this.tg = false;
            } else {
                com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar = this.ga;
                if (pVar != null) {
                    pVar.e();
                }
            }
        }
        return true;
    }
}
