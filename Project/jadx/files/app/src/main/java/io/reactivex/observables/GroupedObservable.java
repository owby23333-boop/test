package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GroupedObservable<K, T> extends Observable<T> {
    final K key;

    protected GroupedObservable(@Nullable K k2) {
        this.key = k2;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}
