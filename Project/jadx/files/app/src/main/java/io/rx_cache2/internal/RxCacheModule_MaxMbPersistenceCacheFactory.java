package io.rx_cache2.internal;

import dagger.internal.b;
import dagger.internal.d;

/* JADX INFO: loaded from: classes3.dex */
public final class RxCacheModule_MaxMbPersistenceCacheFactory implements b<Integer> {
    private final RxCacheModule module;

    public RxCacheModule_MaxMbPersistenceCacheFactory(RxCacheModule rxCacheModule) {
        this.module = rxCacheModule;
    }

    public static RxCacheModule_MaxMbPersistenceCacheFactory create(RxCacheModule rxCacheModule) {
        return new RxCacheModule_MaxMbPersistenceCacheFactory(rxCacheModule);
    }

    public static Integer proxyMaxMbPersistenceCache(RxCacheModule rxCacheModule) {
        Integer numMaxMbPersistenceCache = rxCacheModule.maxMbPersistenceCache();
        d.a(numMaxMbPersistenceCache, "Cannot return null from a non-@Nullable @Provides method");
        return numMaxMbPersistenceCache;
    }

    @Override // javax.inject.a, dagger.a
    public Integer get() {
        Integer numMaxMbPersistenceCache = this.module.maxMbPersistenceCache();
        d.a(numMaxMbPersistenceCache, "Cannot return null from a non-@Nullable @Provides method");
        return numMaxMbPersistenceCache;
    }
}
