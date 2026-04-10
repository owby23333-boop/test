package io.reactivex.parallel;

import io.reactivex.annotations.Experimental;
import io.reactivex.functions.BiFunction;

/* JADX INFO: loaded from: classes8.dex */
@Experimental
public enum ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // io.reactivex.functions.BiFunction
    public ParallelFailureHandling apply(Long l, Throwable th) {
        return this;
    }
}
