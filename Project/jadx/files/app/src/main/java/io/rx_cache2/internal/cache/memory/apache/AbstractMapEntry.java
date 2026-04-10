package io.rx_cache2.internal.cache.memory.apache;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMapEntry<K, V> extends AbstractKeyValue<K, V> implements Map.Entry<K, V> {
    protected AbstractMapEntry(K k2, V v2) {
        super(k2, v2);
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (getKey() != null ? getKey().equals(entry.getKey()) : entry.getKey() == null) {
            if (getValue() == null) {
                if (entry.getValue() == null) {
                    return true;
                }
            } else if (getValue().equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.AbstractKeyValue, java.util.Map.Entry
    public V setValue(V v2) {
        return (V) super.setValue(v2);
    }
}
