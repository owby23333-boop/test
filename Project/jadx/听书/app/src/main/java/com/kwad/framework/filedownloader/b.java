package com.kwad.framework.filedownloader;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.s;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements s.a, s.b {
    private long alc;
    private long ald;
    private long ale;
    private int alf;
    private int alg = 1000;
    private long mStartTime;

    @Override // com.kwad.framework.filedownloader.s.b
    public final void start(long j) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.ale = j;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void end(long j) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j2 = j - this.ale;
        this.alc = 0L;
        long jUptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (jUptimeMillis <= 0) {
            this.alf = (int) j2;
        } else {
            this.alf = (int) (j2 / jUptimeMillis);
        }
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void U(long j) {
        if (this.alg <= 0) {
            return;
        }
        boolean z = true;
        if (this.alc != 0) {
            long jUptimeMillis = SystemClock.uptimeMillis() - this.alc;
            if (jUptimeMillis >= this.alg || (this.alf == 0 && jUptimeMillis > 0)) {
                int i = (int) ((j - this.ald) / jUptimeMillis);
                this.alf = i;
                this.alf = Math.max(0, i);
            } else {
                z = false;
            }
        }
        if (z) {
            this.ald = j;
            this.alc = SystemClock.uptimeMillis();
        }
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void reset() {
        this.alf = 0;
        this.alc = 0L;
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.alf;
    }
}
