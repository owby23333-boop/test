package com.kwad.sdk.utils.a;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements Executor {
    private Runnable bcJ;
    private Runnable bcK;

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.bcJ == null) {
            this.bcJ = d(runnable);
            d.getExecutor().execute(this.bcJ);
        } else {
            if (this.bcK == null) {
                this.bcK = d(runnable);
            }
        }
    }

    private Runnable d(final Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    f.this.scheduleNext();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleNext() {
        Runnable runnable = this.bcK;
        this.bcJ = runnable;
        this.bcK = null;
        if (runnable != null) {
            d.getExecutor().execute(this.bcJ);
        }
    }
}
