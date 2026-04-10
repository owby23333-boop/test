package com.kwad.sdk.utils;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes4.dex */
public final class bv {
    private long bbB;
    private long bbC;
    private boolean bbD;

    public bv() {
        reset();
    }

    public final void startTiming() {
        reset();
        this.bbD = true;
        this.bbC = SystemClock.elapsedRealtime();
    }

    private void reset() {
        this.bbB = 0L;
        this.bbC = -1L;
    }

    public final void Sl() {
        if (this.bbD && this.bbC < 0) {
            this.bbC = SystemClock.elapsedRealtime();
        }
    }

    public final void Sm() {
        if (this.bbD && this.bbC > 0) {
            this.bbB += SystemClock.elapsedRealtime() - this.bbC;
            this.bbC = -1L;
        }
    }

    public final long Sn() {
        if (!this.bbD) {
            return 0L;
        }
        this.bbD = false;
        if (this.bbC > 0) {
            this.bbB += SystemClock.elapsedRealtime() - this.bbC;
            this.bbC = -1L;
        }
        return this.bbB;
    }

    public final long getTime() {
        if (this.bbC > 0) {
            return (this.bbB + SystemClock.elapsedRealtime()) - this.bbC;
        }
        return this.bbB;
    }
}
