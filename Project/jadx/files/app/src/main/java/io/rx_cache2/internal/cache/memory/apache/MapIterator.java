package io.rx_cache2.internal.cache.memory.apache;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public interface MapIterator<K, V> extends Iterator<K> {
    K getKey();

    V getValue();

    @Override // java.util.Iterator
    boolean hasNext();

    @Override // java.util.Iterator
    K next();

    @Override // java.util.Iterator
    void remove();

    V setValue(V v2);
}
