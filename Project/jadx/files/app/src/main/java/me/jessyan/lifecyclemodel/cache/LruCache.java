package me.jessyan.lifecyclemodel.cache;

import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class LruCache<K, V> implements Cache<K, V> {
    private final LinkedHashMap<K, V> cache = new LinkedHashMap<>(100, 0.75f, true);
    private int currentSize = 0;
    private final int initialMaxSize;
    private int maxSize;

    public LruCache(int i2) {
        this.initialMaxSize = i2;
        this.maxSize = i2;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    @Override // me.jessyan.lifecyclemodel.cache.Cache
    public void clear() {
        trimToSize(0);
    }

    @Override // me.jessyan.lifecyclemodel.cache.Cache
    public synchronized boolean containsKey(K k2) {
        return this.cache.containsKey(k2);
    }

    @Override // me.jessyan.lifecyclemodel.cache.Cache
    @Nullable
    public synchronized V get(K k2) {
        return this.cache.get(k2);
    }

    protected int getItemSize(V v2) {
        return 1;
    }

    @Override // me.jessyan.lifecyclemodel.cache.Cache
    public synchronized int getMaxSize() {
        return this.maxSize;
    }

    @Override // me.jessyan.lifecyclemodel.cache.Cache
    public Set<K> keySet() {
        return this.cache.keySet();
    }

    protected void onItemEvicted(K k2, V v2) {
    }

    @Override // me.jessyan.lifecyclemodel.cache.Cache
    @Nullable
    public synchronized V put(K k2, V v2) {
        if (getItemSize(v2) >= this.maxSize) {
            onItemEvicted(k2, v2);
            return null;
        }
        V vPut = this.cache.put(k2, v2);
        if (v2 != null) {
            this.currentSize += getItemSize(v2);
        }
        if (vPut != null) {
            this.currentSize -= getItemSize(vPut);
        }
        evict();
        return vPut;
    }

    @Override // me.jessyan.lifecyclemodel.cache.Cache
    @Nullable
    public synchronized V remove(K k2) {
        V vRemove;
        vRemove = this.cache.remove(k2);
        if (vRemove != null) {
            this.currentSize -= getItemSize(vRemove);
        }
        return vRemove;
    }

    public synchronized void setSizeMultiplier(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = Math.round(this.initialMaxSize * f2);
        evict();
    }

    @Override // me.jessyan.lifecyclemodel.cache.Cache
    public synchronized int size() {
        return this.currentSize;
    }

    protected synchronized void trimToSize(int i2) {
        while (this.currentSize > i2) {
            Map.Entry<K, V> next = this.cache.entrySet().iterator().next();
            V value = next.getValue();
            this.currentSize -= getItemSize(value);
            K key = next.getKey();
            this.cache.remove(key);
            onItemEvicted(key, value);
        }
    }
}
