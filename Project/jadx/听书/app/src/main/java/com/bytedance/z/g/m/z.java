package com.bytedance.z.g.m;

import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements Runnable {
    private final long dl;
    private final long g;
    private Handler z;

    z(Handler handler, long j, long j2) {
        this.z = handler;
        this.g = j;
        this.dl = j2;
    }

    void z() {
        if (g() > 0) {
            this.z.postDelayed(this, g());
        } else {
            this.z.post(this);
        }
    }

    void z(long j) {
        if (j > 0) {
            this.z.postDelayed(this, j);
        } else {
            this.z.post(this);
        }
    }

    long g() {
        return this.g;
    }

    long dl() {
        return this.dl;
    }
}
