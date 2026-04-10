package com.anythink.expressad.exoplayer.k;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    private final Object a = new Object();
    private final PriorityQueue<Integer> b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9908c = Integer.MIN_VALUE;

    public static class a extends IOException {
        public a(int i2, int i3) {
            super("Priority too low [priority=" + i2 + ", highest=" + i3 + "]");
        }
    }

    public final void a() {
        synchronized (this.a) {
            this.b.add(0);
            this.f9908c = Math.max(this.f9908c, 0);
        }
    }

    public final void b() {
        synchronized (this.a) {
            while (this.f9908c != 0) {
                this.a.wait();
            }
        }
    }

    public final void c() {
        synchronized (this.a) {
            this.b.remove(0);
            this.f9908c = this.b.isEmpty() ? Integer.MIN_VALUE : this.b.peek().intValue();
            this.a.notifyAll();
        }
    }

    private boolean b(int i2) {
        boolean z2;
        synchronized (this.a) {
            z2 = this.f9908c == i2;
        }
        return z2;
    }

    public final void a(int i2) {
        synchronized (this.a) {
            if (this.f9908c != i2) {
                throw new a(i2, this.f9908c);
            }
        }
    }
}
