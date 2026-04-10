package com.bytedance.sdk.component.adexpress.dynamic.interact.e;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class d implements View.OnTouchListener {
    private float bf;
    private float d;
    private float e;
    private boolean ga;
    private int p;
    private float tg;
    private boolean v;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.p vn;
    private boolean zk;

    public d(com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar) {
        this(pVar, 5);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar3;
        if (this.zk) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e = motionEvent.getX();
            this.bf = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.tg = motionEvent.getX();
                this.d = motionEvent.getY();
                if (Math.abs(this.tg - this.e) > 10.0f) {
                    this.ga = true;
                }
                if (Math.abs(this.tg - this.e) > 8.0f || Math.abs(this.d - this.bf) > 8.0f) {
                    this.v = false;
                }
                int iBf = com.bytedance.sdk.component.adexpress.d.bf.bf(com.bytedance.sdk.component.adexpress.tg.getContext(), Math.abs(this.tg - this.e));
                if (this.tg > this.e && iBf > this.p && (pVar3 = this.vn) != null) {
                    pVar3.e();
                    this.zk = true;
                }
            }
        } else {
            if (!this.ga && !this.v) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int iBf2 = com.bytedance.sdk.component.adexpress.d.bf.bf(com.bytedance.sdk.component.adexpress.tg.getContext(), Math.abs(this.tg - this.e));
            if (this.tg > this.e && iBf2 > this.p && (pVar2 = this.vn) != null) {
                pVar2.e();
                this.zk = true;
            }
            float fAbs = Math.abs(x - this.e);
            float fAbs2 = Math.abs(y - this.bf);
            if ((fAbs < 8.0f || fAbs2 < 8.0f) && (pVar = this.vn) != null) {
                pVar.bf();
                this.zk = true;
            }
        }
        return true;
    }

    public d(com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar, int i) {
        this.p = 5;
        this.v = true;
        this.vn = pVar;
        if (i > 0) {
            this.p = i;
        }
    }
}
