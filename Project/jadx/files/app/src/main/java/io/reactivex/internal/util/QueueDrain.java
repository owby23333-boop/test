package io.reactivex.internal.util;

import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
public interface QueueDrain<T, U> {
    boolean accept(Subscriber<? super U> subscriber, T t2);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i2);

    long produced(long j2);

    long requested();
}
