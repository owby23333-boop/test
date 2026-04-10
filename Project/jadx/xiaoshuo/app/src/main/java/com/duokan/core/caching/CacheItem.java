package com.duokan.core.caching;

import java.io.Serializable;

/* JADX INFO: loaded from: classes12.dex */
public class CacheItem<T extends Serializable> implements Serializable {
    private final long mCacheTime = System.currentTimeMillis();
    private final T mValue;

    public CacheItem(T t) {
        this.mValue = t;
    }

    public long getCacheTime() {
        return this.mCacheTime;
    }

    public T getValue() {
        return this.mValue;
    }
}
