package io.reactivex.exceptions;

import io.reactivex.annotations.Beta;

/* JADX INFO: loaded from: classes8.dex */
@Beta
public final class UndeliverableException extends IllegalStateException {
    private static final long serialVersionUID = 1644750035281290266L;

    public UndeliverableException(Throwable th) {
        super(th);
    }
}
