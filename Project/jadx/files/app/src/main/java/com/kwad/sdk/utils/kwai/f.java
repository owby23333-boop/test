package com.kwad.sdk.utils.kwai;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Executor {
    private Runnable aBv;
    private Runnable aBw;

    private Runnable c(final Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.kwai.f.1
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
        this.aBv = this.aBw;
        this.aBw = null;
        if (this.aBv != null) {
            d.getExecutor().execute(this.aBv);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.aBv == null) {
            this.aBv = c(runnable);
            d.getExecutor().execute(this.aBv);
        } else {
            if (this.aBw == null) {
                this.aBw = c(runnable);
            }
        }
    }
}
