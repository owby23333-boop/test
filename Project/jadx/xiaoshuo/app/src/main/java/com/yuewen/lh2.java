package com.yuewen;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes12.dex */
public class lh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f13918a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Runnable> f13919b = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        while (!this.f13919b.isEmpty()) {
            Runnable runnablePoll = this.f13919b.poll();
            if (runnablePoll != null) {
                runnablePoll.run();
            }
        }
    }

    public synchronized void b() {
        this.f13918a = false;
        this.f13919b.clear();
    }

    public boolean c() {
        return this.f13918a;
    }

    public synchronized void f() {
        this.f13918a = true;
        rv1.m(new Runnable() { // from class: com.yuewen.kh2
            @Override // java.lang.Runnable
            public final void run() {
                this.f13491a.e();
            }
        });
    }

    public synchronized void g(Runnable runnable) {
        if (runnable != null) {
            if (!this.f13918a) {
                this.f13919b.add(runnable);
                return;
            }
            runnable.run();
        }
    }

    public synchronized void h(boolean z) {
        if (this.f13918a != z) {
            this.f13918a = z;
            if (z) {
                f();
            } else {
                this.f13919b.clear();
            }
        }
    }
}
