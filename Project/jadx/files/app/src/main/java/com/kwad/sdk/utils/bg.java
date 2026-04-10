package com.kwad.sdk.utils;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public final class bg {
    private long aAm;
    private long aAn;
    private boolean aAo;

    public bg() {
        reset();
    }

    private void reset() {
        this.aAm = 0L;
        this.aAn = -1L;
    }

    public final void ET() {
        if (this.aAo && this.aAn < 0) {
            this.aAn = SystemClock.elapsedRealtime();
        }
    }

    public final void EU() {
        if (this.aAo && this.aAn > 0) {
            this.aAm += SystemClock.elapsedRealtime() - this.aAn;
            this.aAn = -1L;
        }
    }

    public final long EV() {
        if (!this.aAo) {
            return 0L;
        }
        this.aAo = false;
        if (this.aAn > 0) {
            this.aAm += SystemClock.elapsedRealtime() - this.aAn;
            this.aAn = -1L;
        }
        return this.aAm;
    }

    public final long getTime() {
        long j2 = this.aAn;
        long j3 = this.aAm;
        return j2 > 0 ? (j3 + SystemClock.elapsedRealtime()) - this.aAn : j3;
    }

    public final void startTiming() {
        reset();
        this.aAo = true;
        this.aAn = SystemClock.elapsedRealtime();
    }
}
