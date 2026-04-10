package com.mipay.imageloadhelper.cache;

/* JADX INFO: loaded from: classes17.dex */
public interface ICache<Key, Cache> {
    Cache getCache(Key key);

    boolean isCacheAvailable();

    void putCache(Key key, Cache cache);
}
