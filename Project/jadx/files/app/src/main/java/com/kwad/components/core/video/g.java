package com.kwad.components.core.video;

import android.os.SystemClock;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private volatile boolean RD;
    private long RE;
    private a RF = new a();

    public static class a {
        private long RG = 0;
        private int RH = 0;

        public final void accumulate(long j2) {
            this.RG += j2;
            this.RH++;
        }

        public final int qZ() {
            return this.RH;
        }

        public final long ra() {
            return this.RG;
        }
    }

    public final void qU() {
        if (this.RD) {
            return;
        }
        this.RD = true;
        this.RE = SystemClock.elapsedRealtime();
        com.kwad.sdk.core.video.kwai.kwai.a.cu("videoStartBlock");
    }

    public final void qV() {
        if (this.RD) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.RE;
            this.RF.accumulate(jElapsedRealtime);
            this.RD = false;
            com.kwad.sdk.core.video.kwai.kwai.a.cu("videoEndBlock");
            com.kwad.sdk.core.video.kwai.kwai.a.cu("videoBlockTime_" + jElapsedRealtime);
        }
    }

    public final boolean qW() {
        return this.RD;
    }

    @NonNull
    public final a qX() {
        if (this.RD) {
            this.RF.accumulate(SystemClock.elapsedRealtime() - this.RE);
            this.RD = false;
        }
        return this.RF;
    }

    public final long qY() {
        return this.RE;
    }
}
