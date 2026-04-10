package io.rx_cache2.internal;

import dagger.internal.b;
import io.rx_cache2.internal.cache.EvictExpiredRecordsPersistence;
import io.rx_cache2.internal.cache.GetDeepCopy;
import io.rx_cache2.internal.cache.TwoLayersCache;
import io.rx_cache2.internal.migration.DoMigrations;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class ProcessorProvidersBehaviour_Factory implements b<ProcessorProvidersBehaviour> {
    private final a<DoMigrations> doMigrationsProvider;
    private final a<EvictExpiredRecordsPersistence> evictExpiredRecordsPersistenceProvider;
    private final a<GetDeepCopy> getDeepCopyProvider;
    private final a<TwoLayersCache> twoLayersCacheProvider;
    private final a<Boolean> useExpiredDataIfLoaderNotAvailableProvider;

    public ProcessorProvidersBehaviour_Factory(a<TwoLayersCache> aVar, a<Boolean> aVar2, a<EvictExpiredRecordsPersistence> aVar3, a<GetDeepCopy> aVar4, a<DoMigrations> aVar5) {
        this.twoLayersCacheProvider = aVar;
        this.useExpiredDataIfLoaderNotAvailableProvider = aVar2;
        this.evictExpiredRecordsPersistenceProvider = aVar3;
        this.getDeepCopyProvider = aVar4;
        this.doMigrationsProvider = aVar5;
    }

    public static ProcessorProvidersBehaviour_Factory create(a<TwoLayersCache> aVar, a<Boolean> aVar2, a<EvictExpiredRecordsPersistence> aVar3, a<GetDeepCopy> aVar4, a<DoMigrations> aVar5) {
        return new ProcessorProvidersBehaviour_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    @Override // javax.inject.a, dagger.a
    public ProcessorProvidersBehaviour get() {
        return new ProcessorProvidersBehaviour(this.twoLayersCacheProvider.get(), this.useExpiredDataIfLoaderNotAvailableProvider.get(), this.evictExpiredRecordsPersistenceProvider.get(), this.getDeepCopyProvider.get(), this.doMigrationsProvider.get());
    }
}
