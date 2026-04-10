package com.bytedance.sdk.component.dl.z;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class tb {
    public static final tb dl = new tb() { // from class: com.bytedance.sdk.component.dl.z.tb.1
        @Override // com.bytedance.sdk.component.dl.z.tb
        public void e() throws IOException {
        }

        @Override // com.bytedance.sdk.component.dl.z.tb
        public tb z(long j) {
            return this;
        }

        @Override // com.bytedance.sdk.component.dl.z.tb
        public tb z(long j, TimeUnit timeUnit) {
            return this;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f697a;
    private long g;
    private boolean z;

    public tb z(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(j)));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.f697a = timeUnit.toNanos(j);
        return this;
    }

    public long n_() {
        return this.f697a;
    }

    public boolean dl() {
        return this.z;
    }

    public long o_() {
        if (!this.z) {
            throw new IllegalStateException("No deadline");
        }
        return this.g;
    }

    public tb z(long j) {
        this.z = true;
        this.g = j;
        return this;
    }

    public tb gc() {
        this.f697a = 0L;
        return this;
    }

    public tb m() {
        this.z = false;
        return this;
    }

    public void e() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.z && this.g - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
