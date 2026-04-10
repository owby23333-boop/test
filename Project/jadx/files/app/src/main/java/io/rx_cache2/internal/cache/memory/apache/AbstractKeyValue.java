package io.rx_cache2.internal.cache.memory.apache;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractKeyValue<K, V> implements KeyValue<K, V> {
    private K key;
    private V value;

    protected AbstractKeyValue(K k2, V v2) {
        this.key = k2;
        this.value = v2;
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.KeyValue
    public K getKey() {
        return this.key;
    }

    @Override // io.rx_cache2.internal.cache.memory.apache.KeyValue
    public V getValue() {
        return this.value;
    }

    protected K setKey(K k2) {
        K k3 = this.key;
        this.key = k2;
        return k3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public V setValue(V v2) {
        V v3 = this.value;
        this.value = v2;
        return v3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
