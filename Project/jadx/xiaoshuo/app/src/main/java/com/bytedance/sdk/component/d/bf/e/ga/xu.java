package com.bytedance.sdk.component.d.bf.e.ga;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
final class xu {
    private final CountDownLatch e = new CountDownLatch(1);
    private long bf = -1;
    private long d = -1;

    public void bf() {
        if (this.d != -1 || this.bf == -1) {
            throw new IllegalStateException();
        }
        this.d = System.nanoTime();
        this.e.countDown();
    }

    public void d() {
        if (this.d == -1) {
            long j = this.bf;
            if (j != -1) {
                this.d = j - 1;
                this.e.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    public void e() {
        if (this.bf != -1) {
            throw new IllegalStateException();
        }
        this.bf = System.nanoTime();
    }
}
