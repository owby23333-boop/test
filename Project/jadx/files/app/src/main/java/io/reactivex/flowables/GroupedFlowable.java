package io.reactivex.flowables;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GroupedFlowable<K, T> extends Flowable<T> {
    final K key;

    protected GroupedFlowable(@Nullable K k2) {
        this.key = k2;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}
