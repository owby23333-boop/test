package io.rx_cache2.internal.cache.memory.apache;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface Put<K, V> {
    void clear();

    Object put(K k2, V v2);

    void putAll(Map<? extends K, ? extends V> map);
}
