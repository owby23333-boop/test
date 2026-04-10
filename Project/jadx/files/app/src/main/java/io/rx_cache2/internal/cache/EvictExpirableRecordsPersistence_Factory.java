package io.rx_cache2.internal.cache;

import dagger.internal.b;
import io.rx_cache2.internal.Memory;
import io.rx_cache2.internal.Persistence;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class EvictExpirableRecordsPersistence_Factory implements b<EvictExpirableRecordsPersistence> {
    private final a<String> encryptKeyProvider;
    private final a<Integer> maxMgPersistenceCacheProvider;
    private final a<Memory> memoryProvider;
    private final a<Persistence> persistenceProvider;

    public EvictExpirableRecordsPersistence_Factory(a<Memory> aVar, a<Persistence> aVar2, a<Integer> aVar3, a<String> aVar4) {
        this.memoryProvider = aVar;
        this.persistenceProvider = aVar2;
        this.maxMgPersistenceCacheProvider = aVar3;
        this.encryptKeyProvider = aVar4;
    }

    public static EvictExpirableRecordsPersistence_Factory create(a<Memory> aVar, a<Persistence> aVar2, a<Integer> aVar3, a<String> aVar4) {
        return new EvictExpirableRecordsPersistence_Factory(aVar, aVar2, aVar3, aVar4);
    }

    @Override // javax.inject.a, dagger.a
    public EvictExpirableRecordsPersistence get() {
        return new EvictExpirableRecordsPersistence(this.memoryProvider.get(), this.persistenceProvider.get(), this.maxMgPersistenceCacheProvider.get(), this.encryptKeyProvider.get());
    }
}
