package io.rx_cache2.internal.cache.memory.apache;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultMapEntry<K, V> extends AbstractMapEntry<K, V> {
    public DefaultMapEntry(K k2, V v2) {
        super(k2, v2);
    }

    public DefaultMapEntry(KeyValue<? extends K, ? extends V> keyValue) {
        super(keyValue.getKey(), keyValue.getValue());
    }

    public DefaultMapEntry(Map.Entry<? extends K, ? extends V> entry) {
        super(entry.getKey(), entry.getValue());
    }
}
