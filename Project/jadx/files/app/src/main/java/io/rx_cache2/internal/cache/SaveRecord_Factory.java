package io.rx_cache2.internal.cache;

import dagger.internal.b;
import io.rx_cache2.internal.Memory;
import io.rx_cache2.internal.Persistence;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class SaveRecord_Factory implements b<SaveRecord> {
    private final a<String> encryptKeyProvider;
    private final a<EvictExpirableRecordsPersistence> evictExpirableRecordsPersistenceProvider;
    private final a<Integer> maxMgPersistenceCacheProvider;
    private final a<Memory> memoryProvider;
    private final a<Persistence> persistenceProvider;

    public SaveRecord_Factory(a<Memory> aVar, a<Persistence> aVar2, a<Integer> aVar3, a<EvictExpirableRecordsPersistence> aVar4, a<String> aVar5) {
        this.memoryProvider = aVar;
        this.persistenceProvider = aVar2;
        this.maxMgPersistenceCacheProvider = aVar3;
        this.evictExpirableRecordsPersistenceProvider = aVar4;
        this.encryptKeyProvider = aVar5;
    }

    public static SaveRecord_Factory create(a<Memory> aVar, a<Persistence> aVar2, a<Integer> aVar3, a<EvictExpirableRecordsPersistence> aVar4, a<String> aVar5) {
        return new SaveRecord_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    @Override // javax.inject.a, dagger.a
    public SaveRecord get() {
        return new SaveRecord(this.memoryProvider.get(), this.persistenceProvider.get(), this.maxMgPersistenceCacheProvider.get(), this.evictExpirableRecordsPersistenceProvider.get(), this.encryptKeyProvider.get());
    }
}
