package com.bytedance.sdk.component.adexpress.dynamic.interact.e;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class tg implements View.OnTouchListener {
    private float bf;
    private float d;
    private float e;
    private boolean ga = true;
    private int m;
    private float p;
    private float tg;
    private boolean v;
    private float vn;
    private boolean wu;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.p zk;

    public tg(com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar, int i, boolean z) {
        this.zk = pVar;
        this.m = i;
        this.wu = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e = motionEvent.getX();
            this.bf = motionEvent.getY();
            this.vn = motionEvent.getY();
            this.ga = true;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.p = y;
                if (Math.abs(y - this.vn) > 10.0f) {
                    this.v = true;
                }
                this.tg = motionEvent.getX();
                this.d = motionEvent.getY();
                if (Math.abs(this.tg - this.e) > 8.0f || Math.abs(this.d - this.bf) > 8.0f) {
                    this.ga = false;
                }
            }
        } else {
            if (!this.v && !this.ga) {
                return false;
            }
            if (this.wu || (pVar3 = this.zk) == null) {
                int iBf = com.bytedance.sdk.component.adexpress.d.bf.bf(com.bytedance.sdk.component.adexpress.tg.getContext(), Math.abs(this.p - this.vn));
                if (this.p - this.vn < 0.0f && iBf > this.m && (pVar2 = this.zk) != null) {
                    pVar2.e();
                } else if (this.ga && (pVar = this.zk) != null) {
                    pVar.e();
                }
            } else {
                pVar3.e();
            }
        }
        return true;
    }
}
