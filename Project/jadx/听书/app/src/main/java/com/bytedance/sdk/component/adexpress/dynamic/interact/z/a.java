package com.bytedance.sdk.component.adexpress.dynamic.interact.z;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f567a;
    private float dl;
    private float e;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.gz fo;
    private float g;
    private boolean gc = true;
    private boolean gz;
    private boolean kb;
    private float m;
    private int uy;
    private float z;

    public a(com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar, int i, boolean z) {
        this.fo = gzVar;
        this.uy = i;
        this.kb = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.z = motionEvent.getX();
            this.g = motionEvent.getY();
            this.m = motionEvent.getY();
            this.gc = true;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.e = y;
                if (Math.abs(y - this.m) > 10.0f) {
                    this.gz = true;
                }
                this.f567a = motionEvent.getX();
                this.dl = motionEvent.getY();
                if (Math.abs(this.f567a - this.z) > 8.0f || Math.abs(this.dl - this.g) > 8.0f) {
                    this.gc = false;
                }
            }
        } else {
            if (!this.gz && !this.gc) {
                return false;
            }
            if (!this.kb && (gzVar3 = this.fo) != null) {
                gzVar3.z();
            } else {
                int iG = com.bytedance.sdk.component.adexpress.a.gz.g(com.bytedance.sdk.component.adexpress.a.getContext(), Math.abs(this.e - this.m));
                if (this.e - this.m < 0.0f && iG > this.uy && (gzVar2 = this.fo) != null) {
                    gzVar2.z();
                } else if (this.gc && (gzVar = this.fo) != null) {
                    gzVar.z();
                }
            }
        }
        return true;
    }
}
