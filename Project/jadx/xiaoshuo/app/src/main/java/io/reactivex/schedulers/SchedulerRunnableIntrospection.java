package io.reactivex.schedulers;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes8.dex */
@Experimental
public interface SchedulerRunnableIntrospection {
    @NonNull
    Runnable getWrappedRunnable();
}
