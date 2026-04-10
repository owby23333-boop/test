package org.reactivestreams;

/* JADX INFO: loaded from: classes9.dex */
public interface Subscription {
    void cancel();

    void request(long j);
}
