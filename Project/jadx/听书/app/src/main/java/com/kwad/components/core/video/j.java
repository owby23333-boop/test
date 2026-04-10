package com.kwad.components.core.video;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    private volatile boolean abc;
    private long abd;
    private a abe = new a();

    public static class a {
        private long abf = 0;
        private int abg = 0;

        public final void accumulate(long j) {
            this.abf += j;
            this.abg++;
        }

        public final int ui() {
            return this.abg;
        }

        public final long uj() {
            return this.abf;
        }

        public final void reset() {
            this.abf = 0L;
            this.abg = 0;
        }
    }

    public final void ud() {
        if (this.abc) {
            return;
        }
        this.abc = true;
        this.abd = SystemClock.elapsedRealtime();
        com.kwad.sdk.core.video.a.a.a.eE("videoStartBlock");
    }

    public final void ue() {
        if (this.abc) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.abd;
            this.abe.accumulate(jElapsedRealtime);
            this.abc = false;
            com.kwad.sdk.core.video.a.a.a.eE("videoEndBlock");
            com.kwad.sdk.core.video.a.a.a.eE("videoBlockTime_" + jElapsedRealtime);
        }
    }

    public final boolean uf() {
        return this.abc;
    }

    public final a ug() {
        if (this.abc) {
            this.abe.accumulate(SystemClock.elapsedRealtime() - this.abd);
            this.abc = false;
        }
        return this.abe;
    }

    public final long uh() {
        return this.abd;
    }

    public final void reset() {
        this.abc = false;
        this.abd = 0L;
        this.abe.reset();
    }
}
