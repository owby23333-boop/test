package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.s;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements s.a, s.b {
    private long aDs;
    private long aDt;
    private long aDu;
    private int aDv;
    private int aDw = 1000;
    private long mStartTime;

    @Override // com.kwai.filedownloader.s.b
    public final void aj(long j2) {
        if (this.aDw <= 0) {
            return;
        }
        boolean z2 = true;
        if (this.aDs != 0) {
            long jUptimeMillis = SystemClock.uptimeMillis() - this.aDs;
            if (jUptimeMillis >= this.aDw || (this.aDv == 0 && jUptimeMillis > 0)) {
                this.aDv = (int) ((j2 - this.aDt) / jUptimeMillis);
                this.aDv = Math.max(0, this.aDv);
            } else {
                z2 = false;
            }
        }
        if (z2) {
            this.aDt = j2;
            this.aDs = SystemClock.uptimeMillis();
        }
    }

    @Override // com.kwai.filedownloader.s.b
    public final void end(long j2) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j3 = j2 - this.aDu;
        this.aDs = 0L;
        long jUptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (jUptimeMillis > 0) {
            j3 /= jUptimeMillis;
        }
        this.aDv = (int) j3;
    }

    @Override // com.kwai.filedownloader.s.a
    public final int getSpeed() {
        return this.aDv;
    }

    @Override // com.kwai.filedownloader.s.b
    public final void reset() {
        this.aDv = 0;
        this.aDs = 0L;
    }

    @Override // com.kwai.filedownloader.s.b
    public final void start(long j2) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.aDu = j2;
    }
}
