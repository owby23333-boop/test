package com.bytedance.sdk.component.dl.g.z.gc;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
final class wp {
    private final CountDownLatch z = new CountDownLatch(1);
    private long g = -1;
    private long dl = -1;

    wp() {
    }

    void z() {
        if (this.g != -1) {
            throw new IllegalStateException();
        }
        this.g = System.nanoTime();
    }

    void g() {
        if (this.dl != -1 || this.g == -1) {
            throw new IllegalStateException();
        }
        this.dl = System.nanoTime();
        this.z.countDown();
    }

    void dl() {
        if (this.dl == -1) {
            long j = this.g;
            if (j != -1) {
                this.dl = j - 1;
                this.z.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
