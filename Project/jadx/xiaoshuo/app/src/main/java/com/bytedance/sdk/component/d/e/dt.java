package com.bytedance.sdk.component.d.e;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class dt {
    public static final dt d = new dt() { // from class: com.bytedance.sdk.component.d.e.dt.1
        @Override // com.bytedance.sdk.component.d.e.dt
        public dt e(long j) {
            return this;
        }

        @Override // com.bytedance.sdk.component.d.e.dt
        public void p() throws IOException {
        }

        @Override // com.bytedance.sdk.component.d.e.dt
        public dt e(long j, TimeUnit timeUnit) {
            return this;
        }
    };
    private long bf;
    private boolean e;
    private long tg;

    public long b_() {
        return this.tg;
    }

    public long c_() {
        if (this.e) {
            return this.bf;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean d() {
        return this.e;
    }

    public dt e(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.tg = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public dt ga() {
        this.tg = 0L;
        return this;
    }

    public void p() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.e && this.bf - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public dt vn() {
        this.e = false;
        return this;
    }

    public dt e(long j) {
        this.e = true;
        this.bf = j;
        return this;
    }
}
