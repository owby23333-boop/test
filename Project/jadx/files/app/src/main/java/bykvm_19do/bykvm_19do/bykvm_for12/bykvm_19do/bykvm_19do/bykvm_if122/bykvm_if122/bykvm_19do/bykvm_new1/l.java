package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
final class l {
    private final CountDownLatch a = new CountDownLatch(1);
    private long b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f1127c = -1;

    l() {
    }

    void a() {
        if (this.f1127c == -1) {
            long j2 = this.b;
            if (j2 != -1) {
                this.f1127c = j2 - 1;
                this.a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    void b() {
        if (this.f1127c != -1 || this.b == -1) {
            throw new IllegalStateException();
        }
        this.f1127c = System.nanoTime();
        this.a.countDown();
    }

    void c() {
        if (this.b != -1) {
            throw new IllegalStateException();
        }
        this.b = System.nanoTime();
    }
}
