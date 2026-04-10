package com.bytedance.e.e.vn;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Runnable {
    private final long bf;
    private final long d;
    private Handler e;

    public e(Handler handler, long j, long j2) {
        this.e = handler;
        this.bf = j;
        this.d = j2;
    }

    public long bf() {
        return this.bf;
    }

    public long d() {
        return this.d;
    }

    public void e() {
        if (bf() > 0) {
            this.e.postDelayed(this, bf());
        } else {
            this.e.post(this);
        }
    }

    public void e(long j) {
        if (j > 0) {
            this.e.postDelayed(this, j);
        } else {
            this.e.post(this);
        }
    }
}
