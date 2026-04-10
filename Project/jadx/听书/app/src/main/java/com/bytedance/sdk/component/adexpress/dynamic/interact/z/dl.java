package com.bytedance.sdk.component.adexpress.dynamic.interact.z;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f568a;
    private float dl;
    private int e;
    private boolean fo;
    private float g;
    private boolean gc;
    private boolean gz;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.gz m;
    private float z;

    public dl(com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar) {
        this(gzVar, 5);
    }

    public dl(com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar, int i) {
        this.e = 5;
        this.gz = true;
        this.m = gzVar;
        if (i > 0) {
            this.e = i;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar3;
        if (this.fo) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.z = motionEvent.getX();
            this.g = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.f568a = motionEvent.getX();
                this.dl = motionEvent.getY();
                if (Math.abs(this.f568a - this.z) > 10.0f) {
                    this.gc = true;
                }
                if (Math.abs(this.f568a - this.z) > 8.0f || Math.abs(this.dl - this.g) > 8.0f) {
                    this.gz = false;
                }
                int iG = com.bytedance.sdk.component.adexpress.a.gz.g(com.bytedance.sdk.component.adexpress.a.getContext(), Math.abs(this.f568a - this.z));
                if (this.f568a > this.z && iG > this.e && (gzVar3 = this.m) != null) {
                    gzVar3.z();
                    this.fo = true;
                }
            }
        } else {
            if (!this.gc && !this.gz) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int iG2 = com.bytedance.sdk.component.adexpress.a.gz.g(com.bytedance.sdk.component.adexpress.a.getContext(), Math.abs(this.f568a - this.z));
            if (this.f568a > this.z && iG2 > this.e && (gzVar2 = this.m) != null) {
                gzVar2.z();
                this.fo = true;
            }
            float fAbs = Math.abs(x - this.z);
            float fAbs2 = Math.abs(y - this.g);
            if ((fAbs < 8.0f || fAbs2 < 8.0f) && (gzVar = this.m) != null) {
                gzVar.g();
                this.fo = true;
            }
        }
        return true;
    }
}
