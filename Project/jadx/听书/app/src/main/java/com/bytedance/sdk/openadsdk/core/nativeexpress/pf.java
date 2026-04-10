package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class pf {
    private float dl;
    private float fo;
    private float g;
    private float gz;
    private float kb;
    private float uy;
    private View z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f1283a = 0.0f;
    private float gc = 0.0f;
    private float m = 0.0f;
    private float e = 0.0f;
    private boolean wp = false;
    private boolean i = false;
    private boolean v = false;
    private boolean pf = false;

    public pf(View view) {
        this.z = view;
    }

    public boolean z(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f1283a = motionEvent.getX();
            this.gc = motionEvent.getY();
            return false;
        }
        if (action != 2) {
            return false;
        }
        this.m = motionEvent.getX();
        this.e = motionEvent.getY();
        if (Math.abs(this.m - this.f1283a) < 5.0f || Math.abs(this.e - this.gc) < 5.0f) {
            this.pf = false;
            return false;
        }
        this.pf = true;
        return true;
    }

    public boolean g(MotionEvent motionEvent) {
        this.g = ((ViewGroup) this.z.getParent()).getWidth();
        this.dl = ((ViewGroup) this.z.getParent()).getHeight();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.i = false;
                this.v = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = x - this.f1283a;
                float f2 = y - this.gc;
                this.gz = this.z.getLeft() + f;
                this.fo = this.z.getTop() + f2;
                this.uy = this.z.getRight() + f;
                this.kb = this.z.getBottom() + f2;
                if (this.gz < 0.0f) {
                    this.v = true;
                    this.gz = 0.0f;
                    this.uy = this.z.getWidth() + 0.0f;
                }
                float f3 = this.uy;
                float f4 = this.g;
                if (f3 > f4) {
                    this.i = true;
                    this.uy = f4;
                    this.gz = f4 - this.z.getWidth();
                }
                if (this.fo < 0.0f) {
                    this.fo = 0.0f;
                    this.kb = 0.0f + this.z.getHeight();
                }
                float f5 = this.kb;
                float f6 = this.dl;
                if (f5 > f6) {
                    this.kb = f6;
                    this.fo = f6 - this.z.getHeight();
                }
                this.z.offsetLeftAndRight((int) f);
                this.z.offsetTopAndBottom((int) f2);
                if (this.v) {
                    View view = this.z;
                    view.offsetLeftAndRight(-view.getLeft());
                }
                if (this.i) {
                    this.z.offsetLeftAndRight((int) (this.g - r7.getRight()));
                }
            }
        } else {
            if (!this.pf) {
                return false;
            }
            if (((int) motionEvent.getRawX()) > this.g / 2.0f) {
                this.wp = false;
                this.z.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(this.g - this.z.getWidth()).start();
                this.z.offsetLeftAndRight((int) (this.g - r7.getRight()));
            } else {
                this.wp = true;
                this.z.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(0.0f).start();
                View view2 = this.z;
                view2.offsetLeftAndRight(-view2.getLeft());
            }
            this.z.invalidate();
        }
        return true;
    }
}
