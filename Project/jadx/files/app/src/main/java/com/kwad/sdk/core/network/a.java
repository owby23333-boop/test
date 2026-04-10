package com.kwad.sdk.core.network;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<R extends g> {
    private static final ExecutorService sExecutors = com.kwad.sdk.core.threads.b.yc();
    private Future<?> mTask;

    @CallSuper
    protected void cancel() {
        Future<?> future = this.mTask;
        if (future != null) {
            future.cancel(true);
        }
    }

    @NonNull
    protected abstract R createRequest();

    protected void fetch() {
        try {
            this.mTask = getExecutor().submit(new Runnable() { // from class: com.kwad.sdk.core.network.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        a.this.fetchImpl();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            });
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    @WorkerThread
    protected abstract void fetchImpl();

    protected ExecutorService getExecutor() {
        return sExecutors;
    }

    protected abstract void onResponse(R r2, c cVar);
}
